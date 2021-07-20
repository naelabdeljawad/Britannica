package pom;

import com.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class HomePage extends AbstractPage {

    @FindBy(id = "main")
    private WebElement pageContainer;

    public HomePage(WebDriver chromeDriver) {
        super(chromeDriver);
        PageFactory.initElements(chromeDriver, this);
    }

    public boolean openShufersalHomePage() {
        try {
            chromeDriver.manage().window().maximize();
            chromeDriver.get(PropertiesReader.getInstance().getProperty("base.url"));
            chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            //Init page factory to load elements after accepting cookies to avoid stale elements exceptions
            wait.until(ExpectedConditions.visibilityOf(pageContainer));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isPageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginDropdownContainer"))).isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
