package com.example.gamegoroda;

import android.content.Context;

import androidx.test.InstrumentationRegistry;
import androidx.test.core.app.ApplicationProvider;


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
    @Test
    public void correctFname() {
        AddOrDelActivity addOrDelActivity = new AddOrDelActivity();
        addOrDelActivity.addWord("w");
    }

}