package com.example.absenceapp;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
public class Hours_Absence_Stagger_Activity extends AppCompatActivity {
    ArrayList<Absent_Stager> absent_Staggers;
    double totalHours;
    ProgressBar progressBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hours_absence_stager);

        // Initialize UI elements
        progressBar = findViewById(R.id.progress_note);
        textView = findViewById(R.id.text_hours);
        // Initialize absent staggers and update UI
        setAbsent_Staggers();

          }
    public void setAbsent_Staggers() {
        absent_Staggers = new ArrayList<>();
        absent_Staggers.add(new Absent_Stager("Ayoub","Abghour"));
        absent_Staggers.add(new Absent_Stager("Ayoub","Abghour"));
        absent_Staggers.add(new Absent_Stager("Ayoub","Abghour"));
        absent_Staggers.add(new Absent_Stager("Ayoub","Abghour"));
        absent_Staggers.add(new Absent_Stager("Ayoub","Abghour"));
        absent_Staggers.add(new Absent_Stager("Ayoub","Abghour"));

        // Calculate total absence hours
        for (Absent_Stager as : absent_Staggers) {
            if (as != null) {
                 totalHours += 2.5; //Assuming each absence is 2.5 hours
            }
        }
        // Update UI
        updateUI();
    }
    private void updateUI() {
        // Update progress bar and text view
        progressBar.setProgress((int) totalHours);
        textView.setText(totalHours + "H");

    }
}
