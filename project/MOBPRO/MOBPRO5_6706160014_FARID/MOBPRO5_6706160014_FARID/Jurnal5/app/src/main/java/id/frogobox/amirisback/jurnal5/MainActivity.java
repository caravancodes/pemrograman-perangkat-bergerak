package id.frogobox.amirisback.jurnal5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView ListMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListMenu = (ListView) findViewById(R.id.list_menu);

        String isiMenu [] = {
                "Ternak",
                "Hutan",
                "Laut",
                "Langka"
        };

        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, isiMenu);
        ListMenu.setAdapter(Adapter);

        ListMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0){
                    Intent ins = new Intent(MainActivity.this, TernakActivity.class);
                    startActivity(ins);

                } else if (i==1){
                    Intent ins = new Intent(MainActivity.this, HutanActivity.class);
                    startActivity(ins);
                } else if (i==2){
                    Intent ins = new Intent(MainActivity.this, LautActivity.class);
                    startActivity(ins);
                } else if (i==3){
                    Intent ins = new Intent(MainActivity.this, LangkaActivity.class);
                    startActivity(ins);
                }
            }
        });


    }


    }
