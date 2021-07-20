package com.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class EventsListener {

    public EventFiringWebDriver registerWebDriverToListener(WebDriver webDriver) {
        EventFiringWebDriver listenerDriver = new EventFiringWebDriver(webDriver);
        WebEventListener eventListener = new WebEventListener();
        return listenerDriver.register(eventListener);
    }
}
