package automation.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;

public class loginPageBTVN13 {
    private WebDriver driver;

    public loginPageBTVN13(WebDriver driver) {
        this.driver = driver;
    }
    public void chucnangLogin (String email, String password)
    {
        WebElement emailTexboxBTVN = driver.findElement(By.id("email"));
        //Xoa gia tri mac dinh trong textbox email
        if (emailTexboxBTVN.isDisplayed()){
            emailTexboxBTVN.clear();
            //Nhap admin@demo.com
            emailTexboxBTVN.sendKeys(email);
        }

        WebElement passwordTextboxBTVN = driver.findElement(By.id("password"));
        if (passwordTextboxBTVN.isDisplayed()) {
            passwordTextboxBTVN.clear();
            passwordTextboxBTVN.sendKeys(password);
        }

        //Click button signin
        WebElement btnSigninBTVN = driver.findElement(By.xpath("//button[text()='Đăng nhập'] "));
        if (btnSigninBTVN.isDisplayed()){
            btnSigninBTVN.click();
        }

    }
}
