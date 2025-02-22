package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.loginPage;
import automation.pageLocator.loginPageBTVN13;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class BTVNDay13 extends CommonBase {

    @BeforeMethod
    public void openBrowser()
    {
        driver = initBrowser(CT_PageURL.URL_BTVN13);

    }
    @Test
    public void loginThanhcong() //TestCase login thanh cong
    {
        loginPageBTVN13 login = new loginPageBTVN13(driver);
        login.chucnangLogin("admin@gmail.com","12345678");
        //Assert Dashboard
        assertTrue(driver.findElement(By.xpath("//p[text()='Quản lý người dùng' ]")).isDisplayed());
    }
    @Test
    public void loginThatbai_Saiemail() //TestCase login sai email
    {
        loginPageBTVN13 login = new loginPageBTVN13(driver);
        login.chucnangLogin("admin1@gmail.com", "12345678");
        //Assert Dashboard
        //assertTrue(driver.findElement(By.xpath("//span[@class='fl-message' and contains(text(), 'Tài khoản của bạn tạm thời không hoạt động')]")).isDisplayed());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@class='fl-message' and contains(text(), 'Tài khoản của bạn tạm thời không hoạt động')]")));
        assertTrue(errorMessage.isDisplayed());

    }
    @Test
    public void loginThatbai_Saipass() //TestCase login sai pass
    {
        loginPageBTVN13 login = new loginPageBTVN13(driver);
        login.chucnangLogin("admin@gmail.com", "123456");
        //Assert Dashboard
        //assertTrue(driver.findElement(By.xpath("//span[@class='fl-message']")).isDisplayed(),"Email hoặc mật khẩu không đúng");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@class='fl-message' and contains(text(), 'Email hoặc mật khẩu không đúng')]")));
        assertTrue(errorMessage.isDisplayed());
    }
    @Test
    public void loginThatbai_Saiemail_pass() //TestCase login sai pass
    {
        loginPageBTVN13 login = new loginPageBTVN13(driver);
        login.chucnangLogin("adm1in@gmail.com", "123456");
        //Assert Dashboard
        //assertTrue(driver.findElement(By.xpath("//span[@class='fl-message']")).isDisplayed(),"Email hoặc mật khẩu không đúng");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@class='fl-message' and contains(text(), 'Email hoặc mật khẩu không đúng')]")));
        assertTrue(errorMessage.isDisplayed());
    }
    @AfterMethod
    public void closeBrowser()
   {
       driver.close();
   }
}