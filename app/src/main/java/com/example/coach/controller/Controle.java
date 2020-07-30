package com.example.coach.controller;

import android.content.Context;

import com.example.coach.modele.Profil;
import com.example.coach.outils.Serializer;

public final class Controle {
    private static Controle instance = null;
    private static Profil profil;
    private static String nomFic = "saveprofil";

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

        profil = new Profil(poids, taille, age, sexe);
        Serializer.serialize(nomFic,profil,contexte);
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
