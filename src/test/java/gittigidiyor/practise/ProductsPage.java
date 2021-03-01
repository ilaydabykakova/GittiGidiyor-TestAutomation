package gittigidiyor.practise;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    public WebElement productPrice;
    public WebElement orderPrice;

    private WebElement getProduct(){
        return driver.findElement(By.xpath("//*[@id='product_id_532779150']"));
    }
    private WebElement getAddProduct(){
        return driver.findElement(By.id("add-to-basket"));
    }
    private WebElement OrderClick(){
        return driver.findElement(By.className("dIB"));
    }
    private WebElement getSearchKey(){
        return driver.findElement(By.xpath("//*[@data-cy='header-search-input']"));
    }

    public void searchKey(String item){
        getSearchKey().sendKeys(item);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    public void openPage(){
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(Utils.SECOND_URL);
    }
    public boolean isLoaded() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.className("desktop"))).isDisplayed();
    }

    public void Product() {
        Actions actions = new Actions(driver);
        actions.moveToElement(getProduct()).click().build().perform();

    }

    public void getAddBasket() throws InterruptedException {
        //productPrice = driver.findElement(By.id("sp-price-lowPrice"));

        getAddProduct().submit();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void getClickBasket() throws InterruptedException {

        Actions actions = new Actions(driver);
        actions.moveToElement(OrderClick()).click().build().perform();


    }
      /*  public void compareCost() {

        orderElement = driver.findElement(By.className("dIB"));
        Actions actions = new Actions(driver);
        actions.moveToElement(orderElement).doubleClick().build().perform();

        orderPrice = driver.findElement(By.className("total-price"));


      Assert.assertEquals(orderPrice.getText(), productPrice.getText());
      Assert.assertNotEquals(orderPrice.getText(), productPrice.getText());*/


}
