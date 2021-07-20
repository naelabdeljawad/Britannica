package com.browsers;

import com.clients.AbstractWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;


public class Chrome extends AbstractWeb {

    private ChromeDriver chromeDriver;
    private ChromeDriverService chromeDriverService;

    /**
     * Create chrome browser instance
     *
     * @return
     */
    @Override
    public WebDriver initBrowser() {
        BrowserCapabilities browserCapabilities = new BrowserCapabilities();
        ChromeOptions chromeOptions = browserCapabilities.getBrowserCapabilities();

        BrowserService browserService = new BrowserService();
        chromeDriverService = browserService.startService();
        chromeDriver = new ChromeDriver(chromeDriverService, chromeOptions);

        EventsListener eventsListener = new EventsListener();
        return eventsListener.registerWebDriverToListener(chromeDriver);
    }

    /**
     * Close driver and stop service if running
     */
    public void closeDriver() {
        chromeDriver.close();

        if (chromeDriverService.isRunning())
            chromeDriverService.stop();
    }
}
