package id.frogobox.amirisback.jurnal5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Praktikan on 22/02/2018.
 */

public class HutanActivity extends AppCompatActivity {

    ListView listViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_activity);

        listViews = (ListView)findViewById(R.id.list_isi);

        ArrayList<NewWord> arrayWords = new ArrayList<>();

        arrayWords.add(new NewWord("Anoa","Anoa depressicornis"));
        arrayWords.add(new NewWord("Bekantan","Nasalis larvatus"));
        arrayWords.add(new NewWord("Jalak Bali","Leucopsar rotschildi"));
        arrayWords.add(new NewWord("Enggang Gading","Rhinoplax vigil"));
        arrayWords.add(new NewWord("Maleo Senkawor","Macrocephalon maleo"));
        arrayWords.add(new NewWord("Mandar Dengkur","Aramidopsis plateni"));
        arrayWords.add(new NewWord("Mentilin","Tarsius bancanus"));
        arrayWords.add(new NewWord("Rusa Timor","Cervus timorensis"));
        arrayWords.add(new NewWord("Tangkasi","Tarsius tarsier"));

        WordAdapter call = new WordAdapter(this, arrayWords);
        listViews.setAdapter(call);
    }
}
