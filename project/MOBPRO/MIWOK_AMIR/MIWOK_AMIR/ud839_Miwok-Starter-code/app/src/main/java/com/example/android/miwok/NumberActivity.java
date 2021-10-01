package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NumberActivity extends AppCompatActivity {

    ListView listNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        listNumber = (ListView) findViewById(R.id.ListViewNumbers);

        String [] color = {
                "Merah",
                "Kuning",
                "Hijau",
                "Jingga",
                "Biru",
                "Nila",
                "Ungu",
                "Coklat",
                "Oren",
                "Silver",
                "Gold",
                "Grey",
                };

        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice
                , android.R.id.text1, color);
        listNumber.setAdapter(Adapter);
    }
}
