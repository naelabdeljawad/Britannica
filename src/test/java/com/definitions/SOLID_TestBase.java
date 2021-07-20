package com.definitions;

import com.browsers.Chrome;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;

import static com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter.getCurrentStep;

public class SOLID_TestBase {
    public WebDriver chromeDriver;

    protected SOLID_TestBase() {
        createDriver();
    }

    protected Chrome chrome;

    public WebDriver createDriver() {
        try {
            getCurrentStep().log(Status.INFO, "Creating chrome driver...");
            chrome = new Chrome();
            this.chromeDriver = chrome.initBrowser();
            getCurrentStep().log(Status.INFO, "Chrome driver is created!");
            return this.chromeDriver;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeDriver() {
        try {
            chrome.closeDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
