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

public class Cart extends AbstractPage {

    @FindBy(id = "cartContainer")
    private WebElement cartContainer;

    @FindBy(className = "miglog-cart-summary-prod-wrp")
    private List<WebElement> products;

    @FindBy(css = ".price .currency")
    private WebElement totalPrice;

    @FindBy(className = "infoSubText")
    private WebElement deliveryFee;

    @FindBy(className = "miglog-prod-totalPrize")
    private List<WebElement> productsPrices;

    public Cart(WebDriver chromeDriver) {
        super(chromeDriver);
        PageFactory.initElements(chromeDriver, this);
    }

    public double getTotalPriceInCart() {
        try {
            return CommonUtils.getDoubleFromNoisyString(totalPrice.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public double getCalculatedPriceInCart() {
        try {
            return CommonUtils.getDoubleFromNoisyString(deliveryFee.getText())
                    + productsPrices.stream().mapToDouble(i -> (CommonUtils.getDoubleFromNoisyString(i.getText()))).reduce(0, (x, y) -> x + y);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public boolean isPageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cartContainer"))).isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
