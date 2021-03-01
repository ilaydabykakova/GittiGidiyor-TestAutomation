package gittigidiyor.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage{

    private WebElement getEmail(){
        return driver.findElement(By.xpath("//*[@name='kullanici']"));
    }
    private WebElement getPass(){
        return driver.findElement(By.xpath("//*[@name='sifre']"));
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public boolean isLoaded() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Hesabım')]"))).isDisplayed();
    }
    public void enterToLogin(String email, String password){
        getEmail().sendKeys(email);
        getPass().sendKeys(password);
        driver.findElement(By.id("gg-login-enter")).submit();
    }

}
