package gittigidiyor.practise;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class OrderPage extends BasePage{
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getIncrease(){
        return driver.findElement(By.xpath("//*[@class='amount']"));
    }
    private WebElement getRemove(){
        return driver.findElement(By.xpath("//*[@title='Sil']"));
    }


    public void increaseProduct() {

        getIncrease().click();
         WebElement option2 = getIncrease().findElement(By.cssSelector("option[value='2']"));
         option2.click();
         Assert.assertTrue(option2.isSelected());
     }
     public void removeProduct(){
        getRemove().click();
     }

    public boolean isLoaded() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Sepetinizde ürün bulunmamaktadır.')]"))).isDisplayed();
    }


}
