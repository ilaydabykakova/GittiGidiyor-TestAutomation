package gittigidiyor.practise;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.AbstractDocument;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }


    private WebElement getSearchKey() {
        return driver.findElement(By.xpath("//*[@data-cy='header-search-input']"));
    }

    public void searchKey(String item) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector(".tyj39b-3.gQhGuc"))).click().build().perform();

        getSearchKey().sendKeys(item);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void openPage() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(Utils.SECOND_URL);
    }

    public boolean isLoaded() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.className("desktop"))).isDisplayed();
    }

   public void getProduct() {
        WebElement element = driver.findElement(By.xpath("//*[@product-index]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();


        String productPrice = driver.findElement(By.xpath("//*[@id='sp-price-discountPrice']")).getText();
        actions.moveToElement(driver.findElement(By.id("action-buttons"))).click(driver.findElement(By.id("add-to-basket"))).build().perform();

        actions.moveToElement(driver.findElement(By.className("dIB"))).doubleClick().perform();

        String orderPrice = driver.findElement(By.xpath("//*[@class='real-discounted-price']")).getText();

       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //Fiyatları kontrol et.
        Assert.assertEquals("Not Equals !",productPrice,orderPrice);

       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }


}
