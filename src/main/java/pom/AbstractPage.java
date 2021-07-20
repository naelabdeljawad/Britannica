package pom;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public abstract class AbstractPage {
    public FluentWait<WebDriver> wait;
    protected WebDriver chromeDriver;

    protected AbstractPage(WebDriver webDriver) {
        this.chromeDriver = webDriver;
        this.wait = new FluentWait<>(chromeDriver).withTimeout(Duration.ofSeconds(5))
                .ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(2));
    }

    public WebDriver getWebDriver() {
        return chromeDriver;
    }

    public abstract boolean isPageDisplayed();
}
