package id.frogobox.amirisback.jurnal5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Praktikan on 22/02/2018.
 */

public class LangkaActivity extends AppCompatActivity {
    ListView listViews;
    private String hewans[] = {"Anoa","Bekantan","Jalak Bali","Enggang Gading","Maleo Senkawor","Mandar Dengkur","Mentilin","Rusa Timor","Tangkasi",};
    private String english[] = {"Anoa depressicornis","Nasalis larvatus","Leucopsar rotschildi","Rhinoplax vigil","Macrocephalon maleo","Aramidopsis plateni","Tarsius bancanus", "Cervus timorensis", "Tarsius tarsier"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_activity);

        listViews = (ListView)findViewById(R.id.list_isi);

        ArrayList<NewWord> arrayWords = new ArrayList<>();

        for (int i = 0 ; i < hewans.length ; i++) {
            arrayWords.add(new NewWord(hewans[i], english[i]));
        }
        WordAdapter call = new WordAdapter(this, arrayWords, R.color.category_langka);
        listViews.setAdapter(call);

    }
}
