package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private String english[] = {"black","brown","dusty_yellow","gray","green","mustard_yellow","red","white"};
    private int gambar, suara;
    ListView listPiew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        listPiew = (ListView) findViewById(R.id.ListViewNumbers);
        final ArrayList<NewWord> arrayWord = new ArrayList<>();
        for (int i = 0; i < english.length; i++) {
            suara = getResources().getIdentifier("color_"+english[i],"raw", getPackageName());
            gambar = getResources().getIdentifier("color_"+english[i],"drawable", getPackageName());
            arrayWord.add(new NewWord(gambar, "luti", english[i], suara));
        }
        WordAdapter newAdapter = new WordAdapter(this, arrayWord, R.color.category_colors);
        listPiew.setAdapter(newAdapter);
        listPiew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                NewWord positionWord = arrayWord.get(position);
                mMediaPlayer = MediaPlayer.create(ColorActivity.this, positionWord.getAudioId());
                mMediaPlayer.start();
            }
        });
    }
}
