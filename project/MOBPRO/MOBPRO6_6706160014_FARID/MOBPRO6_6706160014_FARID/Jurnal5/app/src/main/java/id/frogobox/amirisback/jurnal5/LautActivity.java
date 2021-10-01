package id.frogobox.amirisback.jurnal5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Praktikan on 22/02/2018.
 */

public class LautActivity extends AppCompatActivity {

    ListView listViews;
    private int resId;
    private String gmb[] = {"anjing","beruang","gurita", "hiu", "kepiting", "kerang", "kudalaut", "lumba", "paus", "penyu"};
    private String hewans[] = {"Anjing Laut","Beruang Laut","Gurita","Hiu","Kepiting","Kerang","Kuda Laut","Lumba-Lumba","Paus","Penyu"};
    private String english[] = {"Monachus monachus","Ursus maritimus","Octopus vulgaris","Prionace glauca","Scyda serrata","Pinctada maxima","Hippocampus sp.","Delphinus capensis","Balaenoptera musculus","Chelonia midas"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_activity);

        listViews = (ListView)findViewById(R.id.list_isi);

        ArrayList<NewWord> arrayWords = new ArrayList<>();

        for (int i = 0 ; i < gmb.length ; i++) {
            resId = getResources().getIdentifier(gmb[i], "drawable", getPackageName());
            arrayWords.add(new NewWord(resId, hewans[i], english[i]));
        }

        WordAdapter call = new WordAdapter(this, arrayWords, R.color.category_laut);
        listViews.setAdapter(call);
    }

}
