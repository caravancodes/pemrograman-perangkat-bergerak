package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {
    private String english[] = {"black","brown","dusty_yellow","gray","green","mustard_yellow","red","white"};
    private int gambar;
    ListView listPiew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        listPiew = (ListView) findViewById(R.id.ListViewNumbers);
        ArrayList<NewWord> arrayWord = new ArrayList<>();
        for (int i = 0; i < english.length; i++) {
            gambar = getResources().getIdentifier("color_"+english[i],"drawable", getPackageName());
            arrayWord.add(new NewWord(gambar, "luti", english[i]));
        }
        WordAdapter newAdapter = new WordAdapter(this, arrayWord, R.color.category_colors);
        listPiew.setAdapter(newAdapter);
    }
}
