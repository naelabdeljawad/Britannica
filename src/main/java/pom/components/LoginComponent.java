package pom.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom.AbstractPage;

public class LoginComponent extends AbstractPage {

    @FindBy(id = "loginForm")
    private WebElement loginFormContainer;

    @FindBy(id = "loginDropdown")
    private WebElement loginDropdown;

    @FindBy(id = "j_username")
    private WebElement usernameTextField;

    @FindBy(id = "j_password")
    private WebElement passwordTextField;

    @FindBy(css = "#loginForm .btn.big")
    private WebElement loginButton;

    @FindBy(css = ".loginInfoContainer .name")
    private WebElement loggedInUserName;

    public LoginComponent(WebDriver chromeDriver) {
        super(chromeDriver);
        PageFactory.initElements(chromeDriver, this);
    }

    public boolean doLogin(String userName, String password) {
        try {
            wait.until(ExpectedConditions.visibilityOf(loginFormContainer));
            this.usernameTextField.sendKeys(userName);
            this.passwordTextField.sendKeys(password);
            this.loginButton.click();
            wait.until(ExpectedConditions.visibilityOf(loggedInUserName));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isLoggedIn() {
        try {
            return loggedInUserName.isDisplayed();
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
