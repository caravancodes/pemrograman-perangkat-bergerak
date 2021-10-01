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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_activity);

        listViews = (ListView)findViewById(R.id.list_isi);

        ArrayList<NewWord> arrayWords = new ArrayList<>();
        arrayWords.add(new NewWord("Anjing Laut","Monachus monachus"));
        arrayWords.add(new NewWord("Beruang Laut","Ursus maritimus"));
        arrayWords.add(new NewWord("Gurita ","Octopus vulgaris"));
        arrayWords.add(new NewWord("Hiu","Prionace glauca"));
        arrayWords.add(new NewWord("Kepiting","Scyda serrata"));
        arrayWords.add(new NewWord("Kerang ","Pinctada maxima"));
        arrayWords.add(new NewWord("Kuda Laut","Hippocampus sp."));
        arrayWords.add(new NewWord("Lumba-Lumba","Delphinus capensis"));
        arrayWords.add(new NewWord("Paus","Balaenoptera musculus"));
        arrayWords.add(new NewWord("Penyu","Chelonia midas"));


        WordAdapter call = new WordAdapter(this, arrayWords);
        listViews.setAdapter(call);

    }

}
