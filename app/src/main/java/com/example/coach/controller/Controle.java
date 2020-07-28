package com.example.coach.controller;

import com.example.coach.modele.Profil;

public final class Controle {
    private static Controle instance = null;
    private Profil profil;

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
    public static final Controle getInstance(){
        if(Controle.instance == null){
            Controle.instance = new Controle();

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
    public void creerProfil(Integer poids, Integer taille, Integer age, Integer sexe){

        profil = new Profil(poids, taille, age, sexe);
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
}
