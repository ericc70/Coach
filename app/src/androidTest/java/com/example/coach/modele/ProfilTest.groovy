package com.example.coach.modele;



import org.junit.Test


public class ProfilTest extends groovy.util.GroovyTestCase {
 // creation profole
    private Profil profil= new Profil(67, 165, 35 ,0);
    private float img=(float)32.4;
    private String message="trop elever";
     @Test
    void testGetImg() {
        assertEquals(img, profil.getImg(), (float)0.1)
    }
@Test
    void testGetMessage() {
        assertEquals(message,profil.getMessage() );
    }
}
