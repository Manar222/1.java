package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage {
    private WebDriver driver;
    private By addToCartButton = By.id("add-to-cart-button");
    private By cartConfirmationMessage = By.cssSelector(".a-size-medium-plus");

    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    public String getConfirmationMessage() {
        return driver.findElement(cartConfirmationMessage).getText();
    }
}
