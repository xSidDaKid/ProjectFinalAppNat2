package com.example.tp3_appnat2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @Author Alperen Albaz, Shajaan Balasingam et Gafran Ijaz
 * @Groupe 02
 * @Remis_a Toufik Bellal
 * @Cours 420-G25-RO
 * @Date_de_remise 20 mai 2022
 * Classe qui est responsable de la gestion du jeu
 * <p>
 TODO: - Les tours; - La sauvegarde des donnees lors de la rotation; - Score; - Validation du nom (Nom obligatoire);- Ajout button MENU et RESET
 */
public class JeuActivity extends AppCompatActivity {

    private ImageView[][] images = new ImageView[3][3];

    private TextView textViewJoueur1, textViewJoueur2;
    private int tour = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);
        init();
    }

    public void init() {
        Intent i2 = getIntent();
        String p1 = i2.getStringExtra("nomJoueurUn");
        String p2 = i2.getStringExtra("nomJoueurDeux");

        textViewJoueur1 = findViewById(R.id.scoreJoeur1);
        textViewJoueur2 = findViewById(R.id.scoreJoeur2);

        textViewJoueur1.append(p1);
        textViewJoueur2.append(p2);

        images[0][0] = findViewById(R.id.btn_0);
        images[0][1] = findViewById(R.id.btn_1);
        images[0][2] = findViewById(R.id.btn_2);

        images[1][0] = findViewById(R.id.btn_3);
        images[1][1] = findViewById(R.id.btn_4);
        images[1][2] = findViewById(R.id.btn_5);

        images[2][0] = findViewById(R.id.btn_6);
        images[2][1] = findViewById(R.id.btn_7);
        images[2][2] = findViewById(R.id.btn_8);

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                int finalI = i;
                int finalJ = j;
                System.out.println(tour);
                images[i][j].setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        tour+=1;
                        int tourJoueur = tour % 2;
                        System.out.println(tourJoueur);
                        if(tourJoueur == 0) {
                            images[finalI][finalJ].setImageResource(R.drawable.o);
                            images[finalI][finalJ].setTag("O");
                        }
                        else if(tourJoueur == 1){
                            images[finalI][finalJ].setImageResource(R.drawable.x);
                            images[finalI][finalJ].setTag("X");
                        }
                        images[finalI][finalJ].getLayoutParams().height = 182;
                        images[finalI][finalJ].getLayoutParams().width = 182;
                        images[finalI][finalJ].setClickable(false);
                        if(verifierGagner()){
                            System.out.println("true");
                        }
                    }
                });
            }
        }
    }

    /**
     * Methode qui permet de verifier si quelqu'un a gagne
     *
     * @return True --> Gagner False --> Pas Gagner
     */
    private boolean verifierGagner() {

        //Initialiser a "" (Valeur initiale --> null)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (images[i][j].getTag() == null)
                    images[i][j].setTag("");
            }
        }

        //Verifie les lignes
        for (int i = 0; i < 3; i++) {
            if (images[i][0].getTag().equals(images[i][1].getTag())
                    && images[i][0].getTag().equals(images[i][2].getTag())
                    && !images[i][0].getTag().equals("")) {
                montrerLigneGagnant(i);
                String valeur = images[i][0].getTag().toString();
                System.out.println(valeur);
                unDesJoueursAGagner();
                return true;
            }
        }

        //Verifie les colonnes
        for (int i = 0; i < 3; i++) {
            if (images[0][i].getTag().equals(images[1][i].getTag())
                    && images[0][i].getTag().equals(images[2][i].getTag())
                    && !images[0][i].getTag().equals("")) {
                montrerLigneGagnant(i + 3);//+3 pour commencer a la case 3 pour les colonnes
                unDesJoueursAGagner();
                return true;
            }
        }

        //Verifie la diagonale 1
        if (images[0][0].getTag().equals(images[1][1].getTag())
                && images[0][0].getTag().equals(images[2][2].getTag())
                && !images[0][0].getTag().equals("")) {
            montrerLigneGagnant(6);
            unDesJoueursAGagner();
            return true;
        }

        //Verifie la diagonale 2
        if (images[0][2].getTag().equals(images[1][1].getTag())
                && images[0][2].getTag().equals(images[2][0].getTag())
                && !images[0][2].getTag().equals("")) {
            montrerLigneGagnant(7);
            unDesJoueursAGagner();
            return true;
        }

        return false;
    }

    /**
     * Methode qui permet de savoir quelle ligne est le gagnant
     *
     * @param ligne Numero de la solution (8 solutions possibles)
     */
    private void montrerLigneGagnant(int ligne) {
        View view = findViewById(R.id.ligne0);//Valeur par defaut
        switch (ligne) {
            case 0:
                view = findViewById(R.id.ligne0);
                break;
            case 1:
                view = findViewById(R.id.ligne1);
                break;
            case 2:
                view = findViewById(R.id.ligne3);
                break;
            case 3:
                view = findViewById(R.id.colonne0);
                break;
            case 4:
                view = findViewById(R.id.colonne1);
                break;
            case 5:
                view = findViewById(R.id.colonne2);
                break;
            case 6:
                view = findViewById(R.id.diagonale1);
                break;
            case 7:
                view = findViewById(R.id.diagonale2);
                break;

        }
        view.setVisibility(View.VISIBLE);
    }

    private void unDesJoueursAGagner(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(images[i][j].isClickable()){
                    images[i][j].setClickable(false);
                }
            }
        }
    }


    public void click_restart(View view) {
        this.recreate();
    }
}