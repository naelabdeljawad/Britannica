package com.browsers;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class BrowserCapabilities {
    public ChromeOptions getBrowserCapabilities() {
        /**
         * Webdriver caps with chrome options
         */
        Map<String, Object> prefs = new HashMap<String, Object>();
        ChromeOptions chromeOptions;
        chromeOptions = new ChromeOptions();
        prefs.put("profile.default_content_settings.popups", 0);
        chromeOptions.setExperimentalOption("prefs", prefs);
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("window-size=1920,1080");

        /**
         * Set chrome browser capabilities to launch browser
         */
        DesiredCapabilities webCapabilities = DesiredCapabilities.chrome();
        webCapabilities.setCapability("platform", Platform.MAC);
        webCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions.addArguments("start-maximized"));
        return chromeOptions.merge(webCapabilities);
    }
}
