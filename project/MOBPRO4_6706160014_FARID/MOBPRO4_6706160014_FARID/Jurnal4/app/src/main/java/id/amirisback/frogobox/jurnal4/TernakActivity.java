package id.amirisback.frogobox.jurnal4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class TernakActivity extends AppCompatActivity {

    ListView List;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ternak);

        String [] daftar = {"Angsa", "Ayam", "Bebek", "Domba", "Kalkun", "Kambing", "Kelinci", "Kerbau", "Kuda", "Sapi"};
        List = (ListView) findViewById(R.id.ListTernak);
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, daftar);
        List.setAdapter(Adapter);

    }
}
