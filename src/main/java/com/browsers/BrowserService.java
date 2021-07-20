package com.browsers;

import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;

public class BrowserService {

    public ChromeDriverService startService() {
        StringBuffer buffer = new StringBuffer();
        try {
            ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(
                    new File(String.valueOf(buffer.append(System.getProperty("user.dir")).append(File.separator)
                            .append("resources").append(File.separator).append("drivers").append(File.separator).append("chromedriverMac"))))
                    .usingAnyFreePort().build();
            service.start();
            return service;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
