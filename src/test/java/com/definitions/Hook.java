package com.definitions;

import com.Log;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {

    @Before
    private void initTests() {
        Log.info("Test is about to start...");
    }

    @After
    private void closeDriver() {
        Log.info("Closing driver...");
    }
}
