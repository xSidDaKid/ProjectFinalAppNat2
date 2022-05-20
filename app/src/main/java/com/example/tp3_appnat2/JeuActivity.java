package com.example.tp3_appnat2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.DebugUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @Author Alperen Albaz, Shajaan Balasingam et Gafran Ijaz
 * @Groupe 02
 * @Remis_a Toufik Bellal
 * @Cours 420-G25-RO
 * @Date_de_remise 20 mai 2022
 * Classe qui est responsable de la gestion du jeu
 * <p>
 TODO: - Les tours; - La sauvegarde des donnees lors de la rotation; - Score;
 */
public class JeuActivity extends AppCompatActivity {

    private ImageView[][] images = new ImageView[3][3];

    private TextView textViewJoueur1, textViewJoueur2,textViewScore1,textViewScore2;
    private int tour = 1;
    private int tourInitiale=0;
    private String joueur="";
    private boolean partiFini = false;
    private static int scoreJoueur1, scoreJoueur2 = 0;
    private int[] orientationInt= {0,0,0,0,0,0,0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);
        if(savedInstanceState !=null){
            orientationInt = savedInstanceState.getIntArray("listeJeu");
            tour = savedInstanceState.getInt("tour");
            joueur = savedInstanceState.getString("joueur");
            scoreJoueur1 = savedInstanceState.getInt("score1");
            scoreJoueur2 = savedInstanceState.getInt("score2");
        }
        init();
        this.tourInitiale = tour;

        // l'idee etant que si la parti est fini, on le dirigie vers une autre page pour
        // demander s'il veut commencer en premier ou non au gagnant
        if(partiFini){
            Intent intent = new Intent(this, VictoireActivity.class);
            Bundle b = new Bundle();
            b.putString("GAGNANT", joueur);
            intent.putExtras(b);
            startActivity(intent);
            this.recreate();
        }
    }

    public void init() {
        Intent i2 = getIntent();
        tour = i2.getIntExtra("tourNombre",1);
        String p1 = i2.getStringExtra("nomJoueurUn");
        String p2 = i2.getStringExtra("nomJoueurDeux");

        textViewJoueur1 = findViewById(R.id.scoreJoeur1);
        textViewJoueur2 = findViewById(R.id.scoreJoeur2);
        textViewScore1 = findViewById(R.id.score1);
        textViewScore2 = findViewById(R.id.score2);

        textViewScore1.setText(scoreJoueur1+"");
        textViewScore2.setText(scoreJoueur2+"");

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





        for(int i=0;i<orientationInt.length;i++){
            if(i==0){
                if(orientationInt[i]==1){
                    images[0][0].setImageResource(R.drawable.o);
                    images[0][0].setTag("O");
                    images[0][0].getLayoutParams().height = 182;
                    images[0][0].getLayoutParams().width = 182;
                }
                if(orientationInt[i]==2){
                    images[0][0].setImageResource(R.drawable.x);
                    images[0][0].setTag("X");
                    images[0][0].getLayoutParams().height = 182;
                    images[0][0].getLayoutParams().width = 182;
                }
            }else if(i==1){
                if(orientationInt[i]==1){
                    images[0][1].setImageResource(R.drawable.o);
                    images[0][1].setTag("O");
                    images[0][1].getLayoutParams().height = 182;
                    images[0][1].getLayoutParams().width = 182;
                }
                if(orientationInt[i]==2){
                    images[0][1].setImageResource(R.drawable.x);
                    images[0][1].setTag("X");
                    images[0][1].getLayoutParams().height = 182;
                    images[0][1].getLayoutParams().width = 182;
                }
            }else if(i==2){
                if(orientationInt[i]==1){
                    images[0][2].setImageResource(R.drawable.o);
                    images[0][2].setTag("O");
                    images[0][2].getLayoutParams().height = 182;
                    images[0][2].getLayoutParams().width = 182;
                }
                if(orientationInt[i]==2){
                    images[0][2].setImageResource(R.drawable.x);
                    images[0][2].setTag("X");
                    images[0][2].getLayoutParams().height = 182;
                    images[0][2].getLayoutParams().width = 182;
                }
            }else if(i==3){
                if(orientationInt[i]==1){
                    images[1][0].setImageResource(R.drawable.o);
                    images[1][0].setTag("O");
                    images[1][0].getLayoutParams().height = 182;
                    images[1][0].getLayoutParams().width = 182;
                }
                if(orientationInt[i]==2){
                    images[1][0].setImageResource(R.drawable.x);
                    images[1][0].setTag("X");
                    images[1][0].getLayoutParams().height = 182;
                    images[1][0].getLayoutParams().width = 182;
                }
            }else if(i==4){
                if(orientationInt[i]==1){
                    images[1][1].setImageResource(R.drawable.o);
                    images[1][1].setTag("O");
                    images[1][1].getLayoutParams().height = 182;
                    images[1][1].getLayoutParams().width = 182;
                }
                if(orientationInt[i]==2){
                    images[1][1].setImageResource(R.drawable.x);
                    images[1][1].setTag("X");
                    images[1][1].getLayoutParams().height = 182;
                    images[1][1].getLayoutParams().width = 182;
                }
            }else if(i==5){
                if(orientationInt[i]==1){
                    images[1][2].setImageResource(R.drawable.o);
                    images[1][2].setTag("O");
                    images[1][2].getLayoutParams().height = 182;
                    images[1][2].getLayoutParams().width = 182;
                }
                if(orientationInt[i]==2){
                    images[1][2].setImageResource(R.drawable.x);
                    images[1][2].setTag("X");
                    images[1][2].getLayoutParams().height = 182;
                    images[1][2].getLayoutParams().width = 182;
                }
            }else if(i==6){
                if(orientationInt[i]==1){
                    images[2][0].setImageResource(R.drawable.o);
                    images[2][0].setTag("O");
                    images[2][0].getLayoutParams().height = 182;
                    images[2][0].getLayoutParams().width = 182;
                }
                if(orientationInt[i]==2){
                    images[2][0].setImageResource(R.drawable.x);
                    images[2][0].setTag("X");
                    images[2][0].getLayoutParams().height = 182;
                    images[2][0].getLayoutParams().width = 182;
                }
            }else if(i==7){
                if(orientationInt[i]==1){
                    images[2][1].setImageResource(R.drawable.o);
                    images[2][1].setTag("O");
                    images[2][1].getLayoutParams().height = 182;
                    images[2][1].getLayoutParams().width = 182;
                }
                if(orientationInt[i]==2){
                    images[2][1].setImageResource(R.drawable.x);
                    images[2][1].setTag("X");
                    images[2][1].getLayoutParams().height = 182;
                    images[2][1].getLayoutParams().width = 182;
                }
            }else if(i==8){
                if(orientationInt[i]==1){
                    images[2][2].setImageResource(R.drawable.o);
                    images[2][2].setTag("O");
                    images[2][2].getLayoutParams().height = 182;
                    images[2][2].getLayoutParams().width = 182;
                }
                if(orientationInt[i]==2){
                    images[2][2].setImageResource(R.drawable.x);
                    images[2][2].setTag("X");
                    images[2][2].getLayoutParams().height = 182;
                    images[2][2].getLayoutParams().width = 182;
                }
            }
        }
        if(joueur.equals("Player 1")){
            tour=1;
        }else if(joueur.equals("Player 2")){
            tour=2;
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                int finalI = i;
                int finalJ = j;
                System.out.println(tour);
                images[i][j].setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){

                        tour+=1;
                        System.out.println("tour"+tour);
                        int tourJoueur = tour % 2;
                        System.out.println(tourJoueur +"modulo");
                        if(tourJoueur == 0) {
                            images[finalI][finalJ].setImageResource(R.drawable.o);
                            images[finalI][finalJ].setTag("O");
                            orientationInt[3*finalI+finalJ]=1;
                        }
                        else if(tourJoueur == 1){
                            images[finalI][finalJ].setImageResource(R.drawable.x);
                            images[finalI][finalJ].setTag("X");
                            orientationInt[3*finalI+finalJ]=2;
                        }
                        images[finalI][finalJ].getLayoutParams().height = 182;
                        images[finalI][finalJ].getLayoutParams().width = 182;
                        images[finalI][finalJ].setClickable(false);
                        Pair<Boolean, String> conditionVictoire = verifierGagner();
                        System.out.println(tour);
                        if(conditionVictoire.first == true){
                            partiFini = true;
                            System.out.println("true");
                            System.out.println(conditionVictoire.second);
                            if(conditionVictoire.second == "O"){
                                System.out.println("IN HERE 1");
                                joueur = "Player 1";
                                scoreJoueur1+=1;
                                textViewScore1.setText(scoreJoueur1+"");
                                Toast.makeText(getApplicationContext(),"Player  "+ p1 +" ( "+ conditionVictoire.second+ " ) won",Toast.LENGTH_SHORT).show();
                            }else{
                                System.out.println("IN HERE 2");
                                joueur = "Player 2";
                                scoreJoueur2+=1;
                                textViewScore2.setText(scoreJoueur2+"");
                                Toast.makeText(getApplicationContext(),"Player  "+ p2 +" ( "+ conditionVictoire.second+ " ) won",Toast.LENGTH_SHORT).show();
                            }
                        //Si le joueur O gagne, tour est initialise a 1 alors le nombre maximale de tour est de 10
                        }else if(conditionVictoire.first == false && tour==10 && tourInitiale == 1){
                            System.out.println("IN HERE 3");
                            Toast.makeText(getApplicationContext(),"Partie Nulle",Toast.LENGTH_SHORT).show();
                            //Si le joueur X gagne, tour est initialise a 2 alors le nombre maximale de tour est de 11
                        }else if(conditionVictoire.first == false && tour==11 && tourInitiale == 2){
                            System.out.println("IN HERE 3");
                            Toast.makeText(getApplicationContext(),"Partie Nulle",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
//                if(partiFini){
//                    break;
//                }
            }
        }
    }

    /**
     * Methode qui permet de verifier si quelqu'un a gagne
     *
     * @return True --> Gagner False --> Pas Gagner
     */
    private Pair<Boolean, String> verifierGagner() {

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
                return new Pair<Boolean, String>(true, images[i][0].getTag().toString());
            }
        }

        //Verifie les colonnes
        for (int i = 0; i < 3; i++) {
            if (images[0][i].getTag().equals(images[1][i].getTag())
                    && images[0][i].getTag().equals(images[2][i].getTag())
                    && !images[0][i].getTag().equals("")) {
                montrerLigneGagnant(i + 3);//+3 pour commencer a la case 3 pour les colonnes
                unDesJoueursAGagner();
                return new Pair<Boolean, String>(true, images[i][0].getTag().toString());
            }
        }

        //Verifie la diagonale 1
        if (images[0][0].getTag().equals(images[1][1].getTag())
                && images[0][0].getTag().equals(images[2][2].getTag())
                && !images[0][0].getTag().equals("")) {
            montrerLigneGagnant(6);
            unDesJoueursAGagner();
            return new Pair<Boolean, String>(true, images[0][0].getTag().toString());
        }

        //Verifie la diagonale 2
        if (images[0][2].getTag().equals(images[1][1].getTag())
                && images[0][2].getTag().equals(images[2][0].getTag())
                && !images[0][2].getTag().equals("")) {
            montrerLigneGagnant(7);
            unDesJoueursAGagner();
            return new Pair<Boolean, String>(true, images[0][0].getTag().toString());
        }

        return new Pair<Boolean, String>(false, null);
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
        orientationInt= new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        getIntent().putExtra("tourNombre",tour);
        this.recreate();
    }


    public void click_menu(View view) {
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }

    //Orientation

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putIntArray("listeJeu", orientationInt);
        savedInstanceState.putInt("tour",tour);
        savedInstanceState.putString("joueur",joueur);
        savedInstanceState.putInt("score1",scoreJoueur1);
        savedInstanceState.putInt("score2",scoreJoueur2);
    }
}