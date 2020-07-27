package com.example.coach.modele;


import ...

public class ProfilTest extends groovy.util.GroovyTestCase {
 // creation profole
    private Profil profil= new Profil(67, 165, 35 ,0);
    private float img=(float)32.4;
    private String message="trop elever";
    void testGetImg() {
        assertEquals(img, profil.getImg(), (float)0.1)
    }

    void testGetMessage() {
        assertEquals(message,profil.getMessage() );
    }
}
