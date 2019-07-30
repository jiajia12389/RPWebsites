package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner s1,s2;
    Button btnGo;
    ArrayAdapter<String> aaNumbers;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s1 = findViewById(R.id.s1);
        s2 = findViewById(R.id.s2);
        btnGo = findViewById(R.id.btnGo);


        final String [][] sites = {
                {
                    "https://www.facebook.com.sg/" ,"https://www.instagram.com"
                },
                {
                    "https://www.grab.com.sg", "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12"
                }
        };


        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        //Get the string-array and store as an Array
                        String[] subRP = getResources().getStringArray(R.array.subcategory);
                        aaNumbers = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, subRP);
                        s2.setAdapter(aaNumbers);
                        break;


                    case 1:
                        String[] subDIT = getResources().getStringArray(R.array.subcategoryDIT);
                        aaNumbers = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, subDIT);
                        s2.setAdapter(aaNumbers);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
//
            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = sites[s1.getSelectedItemPosition()][s2.getSelectedItemPosition()];
                Intent intent = new Intent(MainActivity.this,webBrowser.class);
                intent.putExtra("URL",url);
                startActivity(intent);
            }
        });

    }


}
