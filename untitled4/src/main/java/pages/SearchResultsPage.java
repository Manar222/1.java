package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
    private WebDriver driver;
    private By firstProductLink = By.cssSelector(".s-main-slot .s-result-item h2 a");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFirstProduct() {
        driver.findElement(firstProductLink).click();
    }
}
