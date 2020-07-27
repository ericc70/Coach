package com.example.coach;
//package com.example.coach.modele;
import com.example.coach.modele.Profil;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>

 */

public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


}






public class ProfilTest  {
    @Test
    // creation profole
    private Profil profil= new Profil(67, 165, 35 ,0);
    private float img=(float)32.4;
    private String message="trop elever";
    void testGetImg() {
        assertEquals(img, profil.getImg(), (float)0.1);    }

    void testGetMessage() {
        assertEquals(message,profil.getMessage() );
    }
}
