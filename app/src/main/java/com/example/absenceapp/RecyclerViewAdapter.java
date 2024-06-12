package com.example.absenceapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.StagerViewHolder> {
    ArrayList<Stager> stageres;
    public RecyclerViewAdapter(ArrayList<Stager> stageres) {
        this.stageres = stageres;
    }
    @NonNull
    @Override
    public StagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.stager_custom_layout, parent, false);
        return new StagerViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull StagerViewHolder holder, int position) {
        Stager stager = stageres.get(position);
        String nom = stager.getNom();
        String prenom = stager.getPrenom();
        LocalDateTime date = stager.getDate();
        holder.nom.setText(nom + " " + prenom);
        holder.check.setOnCheckedChangeListener(null);
        holder.check.setChecked(stager.isChecked());
        holder.check.setOnCheckedChangeListener((buttonView, isChecked) -> {
            stageres.get(position).setIsChecked(isChecked);
        });
    }

    @Override
    public int getItemCount() {
        return stageres.size();
    }
    // Method to get the checked items
    public ArrayList<Stager> getStageres() {
        return stageres;
    }
    public class StagerViewHolder extends RecyclerView.ViewHolder {
        TextView nom;
        TextView date;
        CheckBox check;
        public StagerViewHolder(@NonNull View itemView) {
            super(itemView);
            nom = itemView.findViewById(R.id.nom);
            date = itemView.findViewById(R.id.date);
            check = itemView.findViewById(R.id.Checked);
        }
    }
}


 /*  check.setOnCheckedChangeListener((buttonView, isChecked) -> {
                      int position = getBindingAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                     stageres.get(position).setIsChecked(isChecked);
                }
            });

           */
