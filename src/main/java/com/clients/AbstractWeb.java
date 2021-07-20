package com.clients;

import com.browsers.Browser;
import org.openqa.selenium.WebDriver;

public abstract class AbstractWeb implements Browser, Client {

    abstract public WebDriver initBrowser();

    @Override
    public WebDriver initClient() {
        return initBrowser();
    }
}
