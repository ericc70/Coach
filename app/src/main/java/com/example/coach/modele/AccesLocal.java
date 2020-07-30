package com.example.coach.modele;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.coach.outils.MySQLiteOpenHelper;

import java.util.Date;

public class AccesLocal {

    //propriete
    private String nomBase = "dbCoach4.sqlite";
    private Integer versionBase= 1;
    private MySQLiteOpenHelper accesBD;
    private SQLiteDatabase bd;


    public AccesLocal(Context contexte){
        accesBD = new MySQLiteOpenHelper(contexte, nomBase,null,versionBase);
    }


    /**
     * ajout d'un profil dans la DB
     * @param profil
     */
    public void ajout(Profil profil){
        bd=accesBD.getWritableDatabase();
        String req = "insert into profil(datemesure, poids, taille, age, sexe ) values";
        req += "(\""+profil.getDateMesure()+"\", "+profil.getPoids()+", "+profil.getTaille()+", "+profil.getAge()+", "+profil.getSexe()+")";
        bd.execSQL(req);
    }

    /**
     * recupération du dernier profil de la DB
     * @return
     */
    public Profil recupDernier(){
        bd = accesBD.getReadableDatabase();
        Profil profil=null;
        String req ="select * from profil";
        Cursor curseur = bd.rawQuery(req, null);
        curseur.moveToLast();
        if(!curseur.isAfterLast()){
            Date date= new Date();
            Integer poids = curseur.getInt(1);
            Integer taille = curseur.getInt(2);
            Integer age = curseur.getInt(3);
            Integer sexe = curseur.getInt(4);
            profil = new Profil(date,poids,taille,age,sexe);
            curseur.close();


        }
        return profil;
    }
}
