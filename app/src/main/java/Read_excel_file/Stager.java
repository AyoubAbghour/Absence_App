package Read_excel_file;


public class Stager {
    private String matriculeEtudiant;
    private String CIN;
    private String nom;
    private String prenom;
    private String nomPrenom;
    private String groupe;
    public Stager() {
        // Default constructor required for calls to DataSnapshot.getValue(Stager.class)
    }

    public Stager(String matriculeEtudiant, String CIN, String nom, String prenom, String nomPrenom, String groupe) {
        this.matriculeEtudiant = matriculeEtudiant;
        this.CIN = CIN;
        this.nom = nom;
        this.prenom = prenom;
        this.nomPrenom = nomPrenom;
        this.groupe = groupe;
    }

    // Getters and setters
    public String getMatriculeEtudiant() {
        return matriculeEtudiant;
    }

    public void setMatriculeEtudiant(String matriculeEtudiant) {
        this.matriculeEtudiant = matriculeEtudiant;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
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

    public String getNomPrenom() {
        return nomPrenom;
    }

    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }
}
