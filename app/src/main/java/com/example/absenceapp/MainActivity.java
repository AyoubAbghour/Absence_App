package com.example.absenceapp;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private FirebaseFirestore db;
    private ArrayList<Stager> stageres;
    private RecyclerViewAdapter adapter;
    public String data;
    private Button Btnsend;
    int id ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          data=getIntent().getStringExtra("key_group");
        // Initialize views
        rv = findViewById(R.id.rv);
        Btnsend = findViewById(R.id.BtnSend);

        // Initialize Firestore and list
        db = FirebaseFirestore.getInstance();
        stageres = new ArrayList<>();
        adapter = new RecyclerViewAdapter(stageres);

        // Setup RecyclerView
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        // Set OnClickListener for the Send button
        Btnsend.setOnClickListener(v -> getTheAbsent());

        queryStagers() ;


    }

    private void queryStagers() {
        ProgressDialogUtil.showProgressDialog(MainActivity.this);
        // Reference to the Firestore collection "stager"
        db.collection("stagers")
                .whereEqualTo("groupe", data) // Filter by groupe
                .get()
                .addOnCompleteListener(task -> {
                    ProgressDialogUtil.dismissProgressDialog(); // Dismiss progress dialog on error too
                    if (task.isSuccessful()) {

                        stageres.clear();
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            String groupe = document.getString("groupe");
                            String matriculeEtudiant = document.getString("matriculeEtudiant");
                            String nom = document.getString("nom");
                            String nomPrenom = document.getString("nomPrenom");
                            String prenom = document.getString("prenom");
                               id++;
                            Stager stager = new Stager(groupe, matriculeEtudiant, nom, nomPrenom, prenom,id);

                            stageres.add(stager);
                        }
                        adapter.notifyDataSetChanged();
                    } else {
                        Log.w(TAG, "Error getting documents.", task.getException());
                    }

                });
    }

    // Get the Absent Stager
    public void getTheAbsent() {
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
    }
}
