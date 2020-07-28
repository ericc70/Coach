package com.example.coach.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

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

    private void ecouteCalcul(){
        ((Button) findViewById(R.id.btnCalc)).setOnClickListener( new Button.OnClickListener(){
            public void onClick(View v){
               // Toast.makeText(MainActivity.this, "test hello les gens", Toast.LENGTH_SHORT).show();
                //Log.d("message", "clic ok sur le bouton Calcul *************" );


            }


        });

    }


}