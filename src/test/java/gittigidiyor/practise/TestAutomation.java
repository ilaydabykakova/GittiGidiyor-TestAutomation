package gittigidiyor.practise;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;


public class TestAutomation {
   WebDriver driver;
    WebElement element;
    @FindBy(xpath = "//*[@data-cy='header-user-menu']")
    private WebElement login_hover;
    @Before
    public void setup()
    {
        driver = getDriver();
    }
    @After
    public void cleanup()
    {
        driver.quit();
    }


    @Test
    public void ExecuteTest() throws InterruptedException {
        driver.get(Utils.BASE_URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //- www.gittigidiyor.com sitesi açılır
        MainPage mainPage = new MainPage(driver);
        assertTrue(mainPage.isLoaded());

        mainPage.goToLogin();
        //- Ana sayfanın açıldığı kontrol edilir. Siteye login olunur.
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterToLogin("helenaghosts@gmail.com","helena96");
        //- Login işlemi kontrol edilir.
        assertTrue(loginPage.isLoaded());


        //- Arama kutucuğuna bilgisayar kelimesi girilir.
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.searchKey("bilgisayar");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // - Arama sonuçları sayfasından 2.sayfa açılır.
        //- 2.sayfanın açıldığı kontrol edilir.
        productsPage.openPage();
        assertTrue(productsPage.isLoaded());
        productsPage.getProduct();
      //  productsPage.compareCost();

        // Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
        // Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.
         OrderPage orderPage = new OrderPage(driver);
         orderPage.increaseProduct();
         orderPage.removeProduct();
        assertTrue(orderPage.isLoaded());


    }

    private WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        return new ChromeDriver();
    }

}
