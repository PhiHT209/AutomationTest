package automation.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;

public class loginPage {
    private WebDriver driver;

    public loginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void loginFunction(String email, String password)
    {
        WebElement emailTexbox = driver.findElement(By.id("txtLoginUsername"));
        //Xoa gia tri mac dinh trong textbox email
        if (emailTexbox.isDisplayed()){
            emailTexbox.clear();
        //Nhap admin@demo.com
        emailTexbox.sendKeys(email);
        }

        WebElement passwordTextbox = driver.findElement(By.id("txtLoginPassword"));
        if (passwordTextbox.isDisplayed()) {
            passwordTextbox.clear();
            passwordTextbox.sendKeys(password);
        }

        //Click button signin
        WebElement btnSignin = driver.findElement(By.xpath("//button[text()='ĐĂNG NHẬP' and @type='submit'] "));
        if (btnSignin.isDisplayed()){
            btnSignin.click();
        }

    }
}
