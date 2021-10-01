package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    ListView listPiew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        listPiew = (ListView) findViewById(R.id.ListViewNumbers);

        ArrayList<NewWord> arrayWord = new ArrayList<>();
        arrayWord.add(new NewWord("luti","one"));
        arrayWord.add(new NewWord("luti","one"));
        arrayWord.add(new NewWord("luti","one"));
        arrayWord.add(new NewWord("luti","one"));
        arrayWord.add(new NewWord("luti","one"));
        arrayWord.add(new NewWord("luti","one"));
        arrayWord.add(new NewWord("luti","one"));
        arrayWord.add(new NewWord("luti","one"));
        arrayWord.add(new NewWord("luti","one"));
        arrayWord.add(new NewWord("luti","one"));
        arrayWord.add(new NewWord("luti","one"));
        arrayWord.add(new NewWord("luti","one"));
        arrayWord.add(new NewWord("luti","one"));
        arrayWord.add(new NewWord("luti","one"));
        arrayWord.add(new NewWord("luti","one"));
        arrayWord.add(new NewWord("luti","one"));


        WordAdapter newAdapter = new WordAdapter(this, arrayWord, R.color.category_phrases);
        listPiew.setAdapter(newAdapter);


    }
}
