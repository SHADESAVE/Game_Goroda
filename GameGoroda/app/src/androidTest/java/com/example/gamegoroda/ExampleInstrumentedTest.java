package com.example.gamegoroda;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.example.gamegoroda", appContext.getPackageName());
    }

    @Test
    public void test1_1() {
        Context context = InstrumentationRegistry.getTargetContext();
        Data data = new Data();
        assertNotNull(data.confirmWord("Рио-де-Жанейро", "О", "Введите слово", "towns", 29, context));
    }

    @Test
    public void test1_2() {
        Context context = InstrumentationRegistry.getTargetContext();
        Data data = new Data();
        assertNotNull(data.confirmWord("Великий Устюг", "Г", "Введите слово", "towns", 29, context));
    }

    @Test
    public void test1_3() {
        Context context = InstrumentationRegistry.getTargetContext();
        Data data = new Data();
        assertNotNull(data.confirmWord("Ыыыы", "Ы", "Введите слово", "towns", 29, context));
    }

    @Test
    public void test1_4() {
        Context context = InstrumentationRegistry.getTargetContext();
        Data data = new Data();
        assertNotNull(data.confirmWord("London", "N", "Введите слово", "towns", 29, context));
    }

    @Test
    public void test2_1() {
        Context context = InstrumentationRegistry.getTargetContext();
        Data data = new Data();
        assertNotNull(data.confirmWord("Александр", "Р", "Введите слово", "names", 2, context));
    }

    @Test
    public void test2_2() {
        Context context = InstrumentationRegistry.getTargetContext();
        Data data = new Data();
        assertNotNull(data.confirmWord("Alexander", "R", "Введите слово", "names", 2, context));
    }

    @Test
    public void test2_3() {
        Context context = InstrumentationRegistry.getTargetContext();
        Data data = new Data();
        assertNotNull(data.confirmWord("Эсфирь", "Р", "Введите слово", "names", 2, context));
    }

    @Test
    public void test2_4() {
        Context context = InstrumentationRegistry.getTargetContext();
        Data data = new Data();
        assertNotNull(data.confirmWord("ЫЫЫаааа", "А", "Введите слово", "names", 2, context));
    }

    @Test
    public void test3_1() {
        Context context = InstrumentationRegistry.getTargetContext();
        Data data = new Data();
        assertNotNull(data.confirmWord("Гвинея-Бисау", "У", "Введите слово", "country", 1, context));
    }

    @Test
    public void test3_2() {
        Context context = InstrumentationRegistry.getTargetContext();
        Data data = new Data();
        assertNotNull(data.confirmWord("Антигуа и Барбуда", "А", "Введите слово", "country", 1, context));
    }

    @Test
    public void test3_3() {
        Context context = InstrumentationRegistry.getTargetContext();
        Data data = new Data();
        assertNotNull(data.confirmWord("Russian Federation", "N", "Введите слово", "country", 1, context));

    }

    @Test
    public void test3_4() {
        Context context = InstrumentationRegistry.getTargetContext();
        Data data = new Data();
        assertNotNull(data.confirmWord("ывыф", "Ф", "Введите слово", "country", 1, context));

    }

    public static void main(String[] args) throws Exception {

        JUnitCore runner = new JUnitCore();

        Result result = runner.run(ExampleInstrumentedTest.class);

        Log.d("test","run tests: " + result.getRunCount());

        Log.d("test","failed tests: " + result.getFailureCount());

        Log.d("test", "ignored tests: " + result.getIgnoreCount());

        Log.d("test", "success: " + result.wasSuccessful());

    }
}
