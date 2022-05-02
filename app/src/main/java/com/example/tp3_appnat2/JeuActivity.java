package com.example.tp3_appnat2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class JeuActivity extends AppCompatActivity {

    private ImageView[][] images = new ImageView[3][3];

    private TextView textViewJoueur1, textViewJoueur2;

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

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int finalI = i;
                int finalJ = j;
                images[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        images[finalI][finalJ].setImageResource(R.drawable.o);
                        images[finalI][finalJ].getLayoutParams().height = 50;
                        images[finalI][finalJ].getLayoutParams().width = 50;
                    }
                });
            }
        }
    }


}