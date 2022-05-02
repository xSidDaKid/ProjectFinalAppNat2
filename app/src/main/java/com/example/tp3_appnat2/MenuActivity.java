package com.example.tp3_appnat2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * @Author Alperen Albaz, Shajaan Balasingam et Gafran Ijaz
 * @Groupe 02
 * @Remis_a Toufik Bellal
 * @Cours 420-G25-RO
 * @Date_de_remise 20 mai 2022
 * Classe qui fait les redirections du menu
 */
public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }

    /**
     * Menu Option #1
     * Jouer contre un AI
     * @param view
     */
    public void playerVSAI(View view) {
        Intent intent = new Intent(this, unJoueurActivity.class);
        startActivity(intent);
    }

    /**
     * Menu Option #2
     * Joeur contre un autre joueur
     * @param view
     */
    public void playerVsPlayer(View view) {
        Intent intent = new Intent(this, IdentificationActivity.class);
        startActivity(intent);
    }

    /**
     * Menu Option #3
     * Page d'info
     * @param view
     */
    public void about(View view) {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    /**
     * Menu Option #4
     * Quitter
     * @param view
     */
    public void quitter(View view) {
        System.exit(0);
    }
}
