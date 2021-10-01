package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private String english[] = {"daughter","father","grandfather","grandmother","mother","older_brother","older_sister","son","younger_brother","younger_sister"};
    private int gambar, suara;
    ListView listPiew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        listPiew = (ListView) findViewById(R.id.ListViewNumbers);

        final ArrayList<NewWord> arrayWord = new ArrayList<>();
        for (int i = 0; i < english.length; i++) {
            suara = getResources().getIdentifier("family_"+english[i],"raw", getPackageName());
            gambar = getResources().getIdentifier("family_"+english[i],"drawable", getPackageName());
            arrayWord.add(new NewWord(gambar, "luti", english[i], suara));
        }


        WordAdapter newAdapter = new WordAdapter(this, arrayWord, R.color.category_phrases);
        listPiew.setAdapter(newAdapter);
        listPiew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                NewWord positionWord = arrayWord.get(position);
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, positionWord.getAudioId());
                mMediaPlayer.start();
            }
        });

    }
}
