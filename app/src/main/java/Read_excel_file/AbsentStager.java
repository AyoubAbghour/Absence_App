package Read_excel_file;
public class AbsentStager {
    private String matriculeEtudiant;
    private String nom;
    private String prenom;
    private String date;
    private String groupe;

    public AbsentStager() {
        // Default constructor required for calls to DataSnapshot.getValue(AbsentStager.class)
    }

    public AbsentStager(String matriculeEtudiant, String nom, String prenom, String date, String groupe) {
        this.matriculeEtudiant = matriculeEtudiant;
        this.nom = nom;
        this.prenom = prenom;
        this.date = date;
        this.groupe = groupe;
    }

    // Getters and setters
    public String getMatriculeEtudiant() {
        return matriculeEtudiant;
    }

    public void setMatriculeEtudiant(String matriculeEtudiant) {
        this.matriculeEtudiant = matriculeEtudiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }
}
