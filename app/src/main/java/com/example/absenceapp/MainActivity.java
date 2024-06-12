package com.example.absenceapp;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private FirebaseFirestore db;
    private ArrayList<Stager> stageres;
    private RecyclerViewAdapter adapter;
    private Button Btnsend;

    // Constant for Intent extra key
    private static final String EXTRA_KEY_GROUP = "key_group"; // Use underscore instead of space

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = FirebaseFirestore.getInstance();

        // Initialize views
        rv = findViewById(R.id.rv);
        Btnsend = findViewById(R.id.BtnSend);
        // Setup RecyclerView
        setupRecyclerView();

        // Set OnClickListener for the Send button
        Btnsend.setOnClickListener(v -> getTheAbsent());
        fetchStageres();
    }

    // Get the Absent Stager
    public void getTheAbsent() {
        if (adapter != null) {
            List<Stager> checkedItems = adapter.getStageres();
            // Do something with the checked items
            for (Stager stager : checkedItems) {
                if (stager.isChecked()) {
                    Log.d("tag", stager.getNom() + " " + stager.getPrenom());
                    stager.setIsChecked(false);
                    adapter.notifyItemChanged(stageres.indexOf(stager));
                }
            }
            Toast.makeText(getApplicationContext(), "send correct", Toast.LENGTH_SHORT).show();
        } else {
            Log.e(TAG, "Adapter is null in getTheAbsent()");
        }
    }
    private void fetchStageres() {

        String groupId = getIntent().getStringExtra(EXTRA_KEY_GROUP); // Use constant for key
        db.collection("stagers")

                .whereEqualTo("groupe", groupId)
                .get()
                .addOnCompleteListener(task -> {
                    ProgressDialogUtil.dismissProgressDialog(); // Dismiss progress dialog
                    if (task.isSuccessful()) {
                        stageres.clear(); // Clear the existing list to avoid duplications
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Stager stager = document.toObject(Stager.class);
                            stageres.add(stager);
                        }
                        if (adapter != null) {
                            adapter.notifyDataSetChanged(); // Notify adapter about data changes
                        } else {
                            Log.e(TAG, "Adapter is null in fetchStageres()");
                        }
                    } else {
                        Log.w(TAG, "Error getting documents.", task.getException());
                        Toast.makeText(getApplicationContext(), "Failed to fetch data", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    public void setupRecyclerView() {
        stageres = new ArrayList<>();
        adapter = new RecyclerViewAdapter(stageres);
          RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
          rv.setLayoutManager(lm);
          rv.setHasFixedSize(true);
          rv.setAdapter(adapter);
    }
}
