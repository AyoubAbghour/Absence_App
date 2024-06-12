package Read_excel_file;

public class Group {
    private String nameGroupe;
    private String groupe;

    public Group() {
        // Default constructor required for calls to DataSnapshot.getValue(Group.class)
    }

    public Group(String nameGroupe, String groupe) {
        this.nameGroupe = nameGroupe;
        this.groupe = groupe;
    }

    // Getters and setters
    public String getNameGroupe() {
        return nameGroupe;
    }

    public void setNameGroupe(String nameGroupe) {
        this.nameGroupe = nameGroupe;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }
}
