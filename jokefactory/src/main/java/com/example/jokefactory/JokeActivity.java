package com.example.jokefactory;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class JokeActivity extends AppCompatActivity {


    public static final String JOKE_KEY = "Joke";
    TextView joke;
    String JokeResult;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_layout);

        joke=findViewById(R.id.joke_id);
        Intent intent=getIntent();
        JokeResult=intent.getStringExtra(getString(R.string.Datajoke));

        if (JokeResult != null) {
            joke.setText(JokeResult);
        } else {
            joke.setText(R.string.DigDeep);
        }


    }
}
