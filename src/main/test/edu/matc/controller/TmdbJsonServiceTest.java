package edu.matc.controller;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;

class TmdbJsonServiceTest {
    @Test
    void readTmdbApi() {
        // create the object that has the method we want to test
        TmdbJsonService test = new TmdbJsonService();

        // create variable for th expected value
        int testValue = 10;

        // call the method and get the actual value
        int actualValue = 0;
        try {
            actualValue = test.readTmdbApi();
        } catch (MalformedURLException m) {
            System.out.println(m);
        }

        // compare the two, pass of fail
        assertEquals(testValue, actualValue);
    }

}