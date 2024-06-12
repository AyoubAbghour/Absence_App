package Read_excel_file;

import com.google.firebase.firestore.FirebaseFirestore;

public class FirestoreHelper {

    private FirebaseFirestore db;

    public FirestoreHelper() {
        db = FirebaseFirestore.getInstance();
    }

    public void addStager(String matriculeEtudiant, String CIN, String nom, String prenom, String nomPrenom, String groupe) {
        Stager stager = new Stager(matriculeEtudiant, CIN, nom, prenom, nomPrenom, groupe);
        db.collection("stagers").document(matriculeEtudiant)
                .set(stager)
                .addOnSuccessListener(aVoid -> System.out.println("Stager added with ID: " + matriculeEtudiant))
                .addOnFailureListener(e -> System.out.println("Error adding stager: " + e));
    }

    public void addGroup(String nameGroupe, String groupe) {
        Group group = new Group(nameGroupe, groupe);
        db.collection("groups").document(groupe)
                .set(group)
                .addOnSuccessListener(aVoid -> System.out.println("Group added with ID: " + groupe))
                .addOnFailureListener(e -> System.out.println("Error adding group: " + e));
    }

    public void addAbsentStager(String matriculeEtudiant, String nom, String prenom, String date, String groupe) {
        AbsentStager absentStager = new AbsentStager(matriculeEtudiant, nom, prenom, date, groupe);
        db.collection("absent_stagers").document(date + "_" + matriculeEtudiant)
                .set(absentStager)
                .addOnSuccessListener(aVoid -> System.out.println("Absent stager record added with ID: " + date + "_" + matriculeEtudiant))
                .addOnFailureListener(e -> System.out.println("Error adding absent stager record: " + e));
    }
}
