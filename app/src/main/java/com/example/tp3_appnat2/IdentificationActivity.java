package com.example.tp3_appnat2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class IdentificationActivity extends AppCompatActivity {
    EditText joueur1, joueur2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identification);

    }

    public void jouer(View view) {
        joueur1 = findViewById(R.id.joueur1);
        joueur2 = findViewById(R.id.joueur2);
        String nomJoueur1 = joueur1.getText().toString();
        String nomJoueur2 = joueur2.getText().toString();

        Intent i = new Intent(this, JeuActivity.class);
        i.putExtra("nomJoueurUn", nomJoueur1);
        i.putExtra("nomJoueurDeux", nomJoueur2);
        startActivity(i);
    }
}