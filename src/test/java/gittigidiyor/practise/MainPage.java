package gittigidiyor.practise;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

   private WebElement getElement(){
       return driver.findElement(By.xpath("//*[@data-cy='header-user-menu']"));
   }
    private WebElement getSubElement(){
        return driver.findElement(By.xpath("//*[@data-cy='header-login-button']"));
    }



    public boolean isLoaded() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.id("__next"))).isDisplayed();
    }
    public void goToLogin(){
        getElement();
        Actions actions = new Actions(driver);
        actions.moveToElement(getElement()).clickAndHold().build().perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        getSubElement();
        actions.moveToElement(getSubElement()).click().build().perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

}
