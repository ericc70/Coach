package com.example.coach.vue;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coach.R;
import com.example.coach.controller.Controle;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        this.controle = Controle.getInstance();
    }
    //propriete
    private EditText txtPoids;
    private EditText txtTaille;
    private EditText txtAge;
    private RadioButton rdHomme;
    private TextView lblIMG;
    private ImageView imgSmiley;
    private Controle controle;


    /**
     * initialisation des lien avec les objet graphique
     */
    private void init(){
        txtPoids = (EditText) findViewById(R.id.txtPoids);
        txtTaille = (EditText) findViewById(R.id.txtTaille);
        txtAge = (EditText) findViewById(R.id.txtAge);
        rdHomme = (RadioButton) findViewById(R.id.rdHomme);
        lblIMG = (TextView) findViewById(R.id.lblIMG);
        imgSmiley = (ImageView) findViewById(R.id.imgSmiley);
        ecouteCalcul();

    }

    private void ecouteCalcul() {
        ((Button) findViewById(R.id.btnCalc)).setOnClickListener(new Button.OnClickListener() {
            private Controle controle;

            public void onClick(View v) {
                // Toast.makeText(MainActivity.this, "test hello les gens", Toast.LENGTH_SHORT).show();
                //Log.d("message", "clic ok sur le bouton Calcul *************" );
                Integer poids = 0;
                Integer taille = 0;
                Integer age = 0;
                Integer sexe = 0;
                //recuperation des donnees saissie
                try {
                    poids = Integer.parseInt(txtPoids.getText().toString());
                    taille = Integer.parseInt(txtTaille.getText().toString());
                    age = Integer.parseInt(txtAge.getText().toString());
                } catch (Exception e) {
                }
                if (rdHomme.isChecked()) {
                    sexe = 1;
                }

                //controlle des donnees saissies

                if (poids == 0 || taille == 0 || age == 0) {
                    Toast.makeText(MainActivity.this, "Saisie incorecte", Toast.LENGTH_SHORT).show();

                } else {
                    afficheResult(poids, taille, age, sexe);

                }
            }
        });
    }

            /**
             * Affichage de L'IMG du message
             * @param poids
             * @param taille
             * @param age
             * @param sexe
             */
            private void afficheResult(Integer poids, Integer taille, Integer age, Integer sexe){
                this.controle.creerProfil(poids,taille,age,sexe);
                float img = this.controle.getImg();
                String message = this.controle.getMessage();
                if (message=="normal"){
                    imgSmiley.setImageResource(R.drawable.normal);
                    lblIMG.setTextColor(Color.GREEN);
                }else{
                    lblIMG.setTextColor(Color.RED);
                    if(message=="trop faible"){
                        imgSmiley.setImageResource(R.drawable.maigre);
                    }
                    else{
                        imgSmiley.setImageResource(R.drawable.poid);
                    }
                }
              //  lblIMG.setText(String.format("%.01f", img)+" :IMG " + message);
                lblIMG.setText(String.format("%.01f", img)+" :IMG " + message);




    }


}