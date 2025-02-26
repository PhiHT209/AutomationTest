package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.loginPageFactory_Day14;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest_Day14 extends CommonBase {
    @BeforeMethod
    public void openBrowser()
    {
        driver = initBrowser(CT_PageURL.URL_ALADA_DEMO);
    }

    @Test(priority = 1)
    public void LoginSuccessfully()
    {
        loginPageFactory_Day14 login = new loginPageFactory_Day14(driver);
        login.LoginFunction("phihoang249@gmail.com","Abcd1234");
        assertTrue(driver.findElement(By.xpath("//a[text()='Khóa học của tôi' and @class='fleft martop20 khct']")).isDisplayed());
    }
    @Test(priority = 2)
    public void LoginFailed_IncorrectPass()
    {
        loginPageFactory_Day14 login = new loginPageFactory_Day14(driver);
        login.LoginFunction("phihoang249@gmail.com","abcd1234");
        assertTrue(driver.findElement(By.xpath("//p[text()='Mật khẩu sai.']")).isDisplayed());
    }
    @Test(priority = 3)
    public void LoginFailed_IncorrectEmail()
    {
        loginPageFactory_Day14 login = new loginPageFactory_Day14(driver);
        login.LoginFunction("phihoang222249@gmail.com","Abcd1234");
        assertTrue(driver.findElement(By.xpath("//p[text()='Email này chưa được đăng ký.']")).isDisplayed());
    }
    @Test(priority = 4)
    public void Logout()
    {
        loginPageFactory_Day14 login = new loginPageFactory_Day14(driver);
        login.LoginFunction("phihoang249@gmail.com","Abcd1234");
        assertTrue(driver.findElement(By.xpath("//a[text()='Khóa học của tôi' and @class='fleft martop20 khct']")).isDisplayed());

        login.LogoutFunction();
        assertTrue(driver.findElement(By.xpath("//a[text()='Đăng Nhập']")).isDisplayed());

    }

    @AfterMethod
    public void closeBrowser()
    {
        driver.close();
    }
}
