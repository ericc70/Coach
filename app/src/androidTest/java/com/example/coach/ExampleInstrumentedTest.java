package com.example.coach;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.coach.modele.Profil;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ExampleInstrumentedTest {


    // creation profole
    private Profil profil= new Profil(67, 165, 35 ,0);
    private float img=(float)32.4;
    private String message="trop elever";
    @Test
    void testGetImg() {
        assertEquals(img, profil.getImg(), (float)0.1);    }
@Test
    void testGetMessage() {
        assertEquals(message,profil.getMessage() );
    }
}




