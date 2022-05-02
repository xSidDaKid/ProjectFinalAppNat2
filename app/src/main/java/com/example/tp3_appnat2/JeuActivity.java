package com.example.tp3_appnat2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class JeuActivity extends AppCompatActivity {
    TextView scoreJoueur1, scoreJoueur2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);
    }

    public void init() {
        Intent i2 = getIntent();
        String p1 = i2.getStringExtra("nomJoueurUn");
        String p2 = i2.getStringExtra("nomJoueurDeux");

        scoreJoueur1 = findViewById(R.id.scoreJoeur1);
        scoreJoueur2 = findViewById(R.id.scoreJoeur2);

        scoreJoueur1.append(p1);
        scoreJoueur2.append(p2);
    }
}