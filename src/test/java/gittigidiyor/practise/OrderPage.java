package gittigidiyor.practise;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class OrderPage extends BasePage{
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getIncrease(){
        return driver.findElement(By.xpath("//*[@class='amount']"));
    }
    private WebElement getRemove(){
        return driver.findElement(By.cssSelector(".gg-icon.gg-icon-bin-medium"));
    }


    public void increaseProduct() {

        getIncrease().click();
        WebElement option2 = getIncrease().findElement(By.cssSelector("option[value='2']"));
        option2.click();
        Assert.assertTrue(option2.isSelected());
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     }
     public void removeProduct() throws InterruptedException {
        driver.findElement(By.xpath("//*[@class='seller']")).click();
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        getRemove().click();
        Thread.sleep(3000);
     }

    public boolean isLoaded() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Sepetinizde ürün bulunmamaktadır.')]"))).isDisplayed();
    }


}
