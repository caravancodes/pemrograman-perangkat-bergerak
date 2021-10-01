package id.frogobox.amirisback.jurnal5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import id.frogobox.amirisback.jurnal5.MainActivityChild.HutanActivity;
import id.frogobox.amirisback.jurnal5.MainActivityChild.LangkaActivity;
import id.frogobox.amirisback.jurnal5.MainActivityChild.LautActivity;
import id.frogobox.amirisback.jurnal5.MainActivityChild.TernakActivity;

public class MainActivity extends AppCompatActivity {

    ListView ListMenu;
    TextView textViewNumber;
    TextView textViewFamily;
    TextView textViewColors;
    TextView textViewPhrases;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewNumber = (TextView) findViewById(R.id.numbers);
        textViewFamily = (TextView) findViewById(R.id.family);
        textViewColors = (TextView) findViewById(R.id.colors);
        textViewPhrases = (TextView) findViewById(R.id.phrases);

        textViewNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, TernakActivity.class);
                startActivity(i);
            }
        });

        textViewFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, HutanActivity.class);
                startActivity(i);
            }
        });

        textViewColors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, LangkaActivity.class);
                startActivity(i);
            }
        });

        textViewPhrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "phrase ZONK", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, LautActivity.class);
                startActivity(i);

            }
        });


    }


    }
