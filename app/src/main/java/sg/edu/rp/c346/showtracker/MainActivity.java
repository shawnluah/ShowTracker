package sg.edu.rp.c346.showtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etDate;
    Button btnAdd;
    Spinner spn1, spn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etShowName);
        etDate = findViewById(R.id.etWatchDate);
        btnAdd = findViewById(R.id.btnAdd);
        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.genre_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn1.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.language_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn2.setAdapter(adapter2);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String date = etDate.getText().toString();
                String genre = spn1.getSelectedItem().toString();
                String language = spn2.getSelectedItem().toString();

                // Create the DBHelper object, passing in the activity context
                DBHelper db = new DBHelper(MainActivity.this);
                // insert a task

                long row_affected = db.insertShow(name, date, genre, language);

                db.close();

                if (row_affected != -1) {
                    Toast.makeText(MainActivity.this, "Insert Sucessfilly", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
