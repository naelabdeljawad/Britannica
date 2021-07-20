package pom.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pom.AbstractPage;

public class ResultsFilters extends AbstractPage {

    @FindBy(id = "mainTabSection")
    private WebElement resultsContainer;

    @FindBy(id = "sortOptions1")
    private WebElement filterSelector;

    public ResultsFilters(WebDriver chromeDriver) {
        super(chromeDriver);
        PageFactory.initElements(chromeDriver, this);
    }

    public boolean selectFilterOrder(int index) {
        try {
            Select select = new Select(this.filterSelector);
            select.selectByIndex(index);
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
