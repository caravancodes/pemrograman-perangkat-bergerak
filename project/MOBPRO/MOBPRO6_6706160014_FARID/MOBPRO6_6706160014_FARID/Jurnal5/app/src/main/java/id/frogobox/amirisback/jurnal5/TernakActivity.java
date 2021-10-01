package id.frogobox.amirisback.jurnal5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class TernakActivity extends AppCompatActivity {

    ListView listViews;

    private int resId;
    private String hewans[] = {"Angsa","Ayam","Bebek","Domba","Kalkun","Kambing","Kelinci","Kerbau","Sapi"};
    private String english[] = {"Cygnus olor","Gallus gallus","Cairina moschata","Ovis ammon","Meleagris gallopavo","Capricornis sumatrensis","Oryctolagus cuniculus","Bubalus bubalis","Bos taurus"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_activity);

        listViews = (ListView)findViewById(R.id.list_isi);

        ArrayList<NewWord> arrayWords = new ArrayList<>();

        for (int i = 0 ; i < hewans.length ; i++) {
            resId = getResources().getIdentifier(hewans[i].toLowerCase(), "drawable", getPackageName());
            arrayWords.add(new NewWord(resId, hewans[i], english[i]));
        }

        WordAdapter call = new WordAdapter(this, arrayWords, R.color.category_ternak);
        listViews.setAdapter(call);

    }
}
