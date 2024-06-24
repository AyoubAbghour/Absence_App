package com.example.absenceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Groups_Activity extends AppCompatActivity {
    Button btn;
    Spinner sp;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);
        db = FirebaseFirestore.getInstance();
        btn = findViewById(R.id.Select);
        sp = findViewById(R.id.action_bar_spinner);

        ProgressDialogUtil.showProgressDialog(this); // Show progress dialog
        fetchGroupsFromFirestore();
    }

    private void fetchGroupsFromFirestore() {
        db.collection("groups").get().addOnCompleteListener(task -> {
            ProgressDialogUtil.dismissProgressDialog(); // Dismiss the progress dialog when the task is complete
            if (task.isSuccessful()) {
                List<String> groupNames = new ArrayList<>(); //listgroup of names
                for (QueryDocumentSnapshot document : task.getResult()) {
                    Map<String, Object> groupData = document.getData();
                    groupNames.add((String) groupData.get("groupe"));
                }
                populateSpinner(groupNames);
            } else {
                // Handle the error
                ProgressDialogUtil.dismissProgressDialog(); // Dismiss progress dialog on error too
                Toast.makeText(Groups_Activity.this, "Error getting groups", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void populateSpinner(List<String> groupNames) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, groupNames);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                btn.setOnClickListener(v -> {
                    String selectedGroup = (String) parent.getItemAtPosition(position);
                    Intent intent = new Intent(Groups_Activity.this, MainActivity.class);
                    intent.putExtra("key_group", selectedGroup); // Correct key
                    startActivity(intent);
                    Toast.makeText(Groups_Activity.this, selectedGroup, Toast.LENGTH_SHORT).show();
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
