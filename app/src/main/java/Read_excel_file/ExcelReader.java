package Read_excel_file;


 import android.content.Context;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.IOException;
import java.io.InputStream;


 import android.content.Context;
 import org.apache.poi.ss.usermodel.*;

 import java.io.IOException;
 import java.io.InputStream;

public class ExcelReader {

    private Context context;

    public ExcelReader(Context context) {
        this.context = context;
    }

    public void readExcelFile() throws IOException {
        InputStream inputStream = context.getAssets().open("Liste_Stagiaire.xlsx");
        Workbook workbook = WorkbookFactory.create(inputStream);

        readStagersSheet(workbook.getSheet("Liste_Stagiaires"));
        readGroupsSheet(workbook.getSheet("Groupes"));
        readAbsencesSheet(workbook.getSheet("Absences_Stagiaires"));
        workbook.close();
        inputStream.close();

    }

    private void readStagersSheet(Sheet sheet) {
        FirestoreHelper firestoreHelper = new FirestoreHelper();
        for (Row row : sheet) {
            if (row.getRowNum() == 0) { // Skip header row
                continue;
            }
            String matriculeEtudiant = row.getCell(0).getStringCellValue();
            String CIN = row.getCell(1).getStringCellValue();
            String nom = row.getCell(2).getStringCellValue();
            String prenom = row.getCell(3).getStringCellValue();
            String nomPrenom = row.getCell(4).getStringCellValue();
            String groupe = row.getCell(5).getStringCellValue();
            firestoreHelper.addStager(matriculeEtudiant, CIN, nom, prenom, nomPrenom, groupe);
        }
    }

    private void readGroupsSheet(Sheet sheet) {
        FirestoreHelper firestoreHelper = new FirestoreHelper();
        for (Row row : sheet) {
            if (row.getRowNum() == 0) { // Skip header row
                continue;
            }
            String nameGroupe = row.getCell(0).getStringCellValue();
            String groupe = row.getCell(1).getStringCellValue();
            firestoreHelper.addGroup(nameGroupe, groupe);
        }
    }

    private void readAbsencesSheet(Sheet sheet) {
        FirestoreHelper firestoreHelper = new FirestoreHelper();
        for (Row row : sheet) {
            if (row.getRowNum() == 0) { // Skip header row
                continue;
            }
            String matriculeEtudiant = row.getCell(0).getStringCellValue();
            String nom = row.getCell(1).getStringCellValue();
            String prenom = row.getCell(2).getStringCellValue();
            String date = row.getCell(3).getStringCellValue();
            String groupe = row.getCell(4).getStringCellValue();
            firestoreHelper.addAbsentStager(matriculeEtudiant, nom, prenom, date, groupe);
        }
    }
}
