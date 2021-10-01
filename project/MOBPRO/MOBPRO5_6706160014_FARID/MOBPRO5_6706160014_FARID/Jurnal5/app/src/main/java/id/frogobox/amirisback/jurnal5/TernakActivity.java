package id.frogobox.amirisback.jurnal5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class TernakActivity extends AppCompatActivity {

    ListView listViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_activity);

        listViews = (ListView)findViewById(R.id.list_isi);

        ArrayList<NewWord> arrayWords = new ArrayList<>();

        arrayWords.add(new NewWord("Angsa","Cygnus olor"));
        arrayWords.add(new NewWord("Ayam","Gallus gallus"));
        arrayWords.add(new NewWord("Bebek","Cairina moschata"));
        arrayWords.add(new NewWord("Domba","Ovis ammon"));
        arrayWords.add(new NewWord("Kalkun","Meleagris gallopavo"));
        arrayWords.add(new NewWord("Kambing","Capricornis sumatrensis"));
        arrayWords.add(new NewWord("Kelinci","Oryctolagus cuniculus"));
        arrayWords.add(new NewWord("Kerbau","Bubalus bubalis"));
        arrayWords.add(new NewWord("Sapi","Bos taurus"));

        WordAdapter call = new WordAdapter(this, arrayWords);
        listViews.setAdapter(call);

    }
}
