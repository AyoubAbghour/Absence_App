package Read_excel_file;


import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.absenceapp.R;

import java.io.IOException;

public class MainActivity_Excel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            ExcelReader excelReader = new ExcelReader(this);
            try {
                excelReader.readExcelFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
