package com.example.coach.controller;

import android.content.Context;

import com.example.coach.modele.AccesLocal;
import com.example.coach.modele.Profil;
import com.example.coach.outils.Serializer;

import java.util.Date;

public final class Controle {
    private static Controle instance = null;
    private static Profil profil;
    private static String nomFic = "saveprofil";
    private static AccesLocal accesLocal;


    /**
     * constructeur privée
     */
    private Controle(){
        super();
    }

    /**
     * Creation de l'instance
     * @return instance
     */
    public static final Controle getInstance(Context contexte){
        if(Controle.instance == null){
            Controle.instance = new Controle();
            recupSerialize(contexte);
            accesLocal = new AccesLocal(contexte);
            profil = accesLocal.recupDernier();


        }
    return Controle.instance;
    }

    /**
     * Creation du profil
     * @param poids
     * @param taille en cm
     * @param age
     * @param sexe 1 pour homme et 0 pour femme
     */
    public void creerProfil(Integer poids, Integer taille, Integer age, Integer sexe, Context contexte){

        profil = new Profil(new Date(), poids, taille, age, sexe);
        //Serializer.serialize(nomFic,profil,contexte);
        accesLocal.ajout(profil);

    }

    /**
     * recuperation img de profils
     * @return img
     */
    public float getImg(){
        return profil.getImg();
    }

    /**
     * recuperation message de profile
     * @return message
     */
    public String getMessage() {
        return profil.getMessage();
    }

    /**
     * récuperation de l'objet serialiser (le profil)
     * @param contexte
     */
    private static void recupSerialize(Context contexte ){
        profil = (Profil)Serializer.deSerialize(nomFic, contexte);
    }
    public Integer getPoids(){
        if(profil == null){return null;}
        else{ return profil.getPoids();}
    }
    public Integer getTaille(){
        if(profil == null){return null;}
        else{ return profil.getTaille();}
    }

    public Integer getAge(){
         if(profil == null){return null;}
         else{ return profil.getAge();}
    }

    public Integer getSexe(){
        if(profil == null){return null;}
        else{ return profil.getSexe();}
    }

}
