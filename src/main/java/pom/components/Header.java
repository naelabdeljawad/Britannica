package pom.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom.AbstractPage;

public class Header extends AbstractPage {

    @FindBy(id = "main")
    private WebElement pageContainer;

    @FindBy(className = "btnContinue")
    private WebElement startShoppingButton;

    @FindBy(id = "")
    private WebElement logo;

    @FindBy(id = "")
    private WebElement registerButton;

    @FindBy(className = "cartQuantity")
    private WebElement cartButton;

    @FindBy(id = "loginDropdownContainer")
    private WebElement loginButton;

    @FindBy(id = "js-site-search-input")
    private WebElement searchInput;

    @FindBy(className = "btnSubmit")
    private WebElement searchIconButton;

    public Header(WebDriver chromeDriver) {
        super(chromeDriver);
        PageFactory.initElements(chromeDriver, this);
    }

    public boolean clickLogin() {
        try {
            this.loginButton.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean clickCartQuantity() {
        try {
            this.cartButton.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean search(String productName) {
        try {
            this.searchInput.sendKeys(productName);
            this.searchIconButton.click();
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
