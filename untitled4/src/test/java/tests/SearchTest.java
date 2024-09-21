package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.ProductPage;

public class SearchTest {
    private WebDriver driver;
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private ProductPage productPage;

    @BeforeTest
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1024, 768));
        driver.get("https://www.amazon.com/");
        homePage = new HomePage(driver);
    }

    @Test
    public void testProductSearch() {
        homePage.searchFor("car accessories");
        searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.clickFirstProduct();
        productPage = new ProductPage(driver);
        String productTitle = productPage.getProductTitle();
        System.out.println("Product Title: " + productTitle);
       // Assert.assertEquals(productTitle, "Amazon.com : car accessories", "Product title does not match!");
    }



    /*@AfterTest
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }*/
}
