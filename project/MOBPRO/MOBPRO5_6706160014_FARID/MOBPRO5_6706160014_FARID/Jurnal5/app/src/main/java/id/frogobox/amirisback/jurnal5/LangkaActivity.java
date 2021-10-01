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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_activity);

        listViews = (ListView)findViewById(R.id.list_isi);

        ArrayList<NewWord> arrayWords = new ArrayList<>();

        arrayWords.add(new NewWord("Berang-Berang","Lutra sumatrana"));
        arrayWords.add(new NewWord("Katak ","Rana macrodon"));
        arrayWords.add(new NewWord("Koala","Phascolartus cinereus"));
        arrayWords.add(new NewWord("Kudanil","Hippotamus amphibius"));
        arrayWords.add(new NewWord("Laba-Laba","Heteropoda venatoria"));
        arrayWords.add(new NewWord("Landak ","Hystrix brachyura"));
        arrayWords.add(new NewWord("Monyet","Macaca fascicularis"));
        arrayWords.add(new NewWord("Rakun","Proyon lotor"));
        arrayWords.add(new NewWord("Rubah","Vulpes vulpes"));
        arrayWords.add(new NewWord("Tupai ","Tupaia javanica"));


        WordAdapter call = new WordAdapter(this, arrayWords);
        listViews.setAdapter(call);

    }
}
