package pom.components;

import com.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom.AbstractPage;

import java.util.List;

public class Results extends AbstractPage {

    @FindBy(id = "mainProductGrid")
    private WebElement filtersContainer;

    @FindBy(className = "js-add-to-cart")
    private List<WebElement> addToCartButtons;


    public Results(WebDriver chromeDriver) {
        super(chromeDriver);
        PageFactory.initElements(chromeDriver, this);
    }

    public boolean clickAddProductToCart(String keyword) {
        try {
            CommonUtils.clickByJS(addToCartButtons.get(getIndexOfProductByKeyword(keyword)), chromeDriver);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("icon-empty-cart")));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private int getIndexOfProductByKeyword(String keyword) {
        List<WebElement> productsTexts = chromeDriver.findElements(By.cssSelector("#tabPane1 .middleContainer .text"));
        int size = productsTexts.size();

        for (int i = 0; i < size; i++) {
            if (productsTexts.get(i).getText().contains(keyword))
                return i;
        }
        return -1;
    }

    @Override
    public boolean isPageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(filtersContainer)).isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
