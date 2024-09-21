package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.ProductPage;
import pages.AddToCartPage;

import java.time.Duration;

public class CartTest {
    private WebDriver driver;
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private ProductPage productPage;
    private AddToCartPage addToCartPage;

    @BeforeTest
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        homePage = new HomePage(driver);
    }

    @Test
    public void testProductSearchAndAddToCart() {
        homePage.searchFor("car accessories");
        searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.clickFirstProduct();
        productPage = new ProductPage(driver);

        // Add to Cart
        addToCartPage = new AddToCartPage(driver);
        addToCartPage.clickAddToCart();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
        addToCartButton.click();

        // Verify confirmation message
        String confirmationMessage = addToCartPage.getConfirmationMessage();
        System.out.println("Confirmation Message: " + confirmationMessage);
        // Add assertions as needed
    }

    @AfterTest
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
