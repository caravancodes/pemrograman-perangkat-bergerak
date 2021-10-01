package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumberActivity extends AppCompatActivity {

    private String numbers[] = {"one","two","three","four","five","six","seven","eight"};
    private int gambar;
    ListView listPiew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        listPiew = (ListView) findViewById(R.id.ListViewNumbers);
        ArrayList<NewWord> arrayWord = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            gambar = getResources().getIdentifier("number_"+numbers[i],"drawable", getPackageName());
            arrayWord.add(new NewWord(gambar, "luti", numbers[i]));
        }
        WordAdapter newAdapter = new WordAdapter(this, arrayWord, R.color.category_numbers);
        listPiew.setAdapter(newAdapter);
    }
}