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
    private int resId;
    private String gmb[] = {"berang", "katak", "koala", "kudanil", "laba", "landak", "monyet", "rakun", "rubah", "tupai"};
    private String hewans[] = {"Berang-Berang","Katak","Koala","Kudanil","Laba-Laba","Landak","Monyet","Rakun","Rubah","Tupai"};
    private String english[] = {"Lutra sumatrana","Rana macrodon","Phascolartus cinereus","Hippotamus amphibius","Heteropoda venatoria","Hystrix brachyura", "Macaca fascicularis","Proyon lotor","Vulpes vulpes","Tupaia javanica"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_activity);

        listViews = (ListView)findViewById(R.id.list_isi);

        ArrayList<NewWord> arrayWords = new ArrayList<>();
        for (int i = 0 ; i < hewans.length ; i++) {
            resId = getResources().getIdentifier(gmb[i], "drawable", getPackageName());
            arrayWords.add(new NewWord(resId, hewans[i], english[i]));
        }
        WordAdapter call = new WordAdapter(this, arrayWords, R.color.category_hutan);
        listViews.setAdapter(call);
    }
}
