package sg.edu.rp.c346.showtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class homepage extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    ArrayList<Show> showal;
    Button btnAdd, btnUpdate, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        lv = findViewById(R.id.lvShow);
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);





        showal = new ArrayList<Show>();
        aa = new ShowAdapter(this, R.layout.row, showal);
        DBHelper db = new DBHelper(homepage.this);
        ArrayList<Show> data = db.getShowContent();
        aa = new ShowAdapter(this,R.layout.row, data);
        lv.setAdapter(aa);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openMainActivity();
            }
        });

    }
    public void openMainActivity () {
        Intent intent  = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }
}
