package automation.testsuite;
import static org.testng.Assert.assertTrue;
import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.loginPage;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Alada_LoginTest extends CommonBase {
    @BeforeMethod
    public void openBrowser()
    {
        driver = initBrowser(CT_PageURL.URL_ALADA_DEMO);
    }
    @Test
    public void loginSuccess() //TestCase login thanh cong
    {
        loginPage login = new loginPage(driver);
        login.loginFunction("phihoang249@gmail.com","Abcd1234");
        //Assert Dashboard
        assertTrue(driver.findElement(By.xpath("//a[text()='Khóa học của tôi' and @class='fleft martop20 khct']")).isDisplayed());
    }
    @Test
    public void loginFailed_IncorrectPass() //TestCase login sai pass
    {
        loginPage login = new loginPage(driver);
        login.loginFunction("phihoang249@gmail.com", "123456");
        //Assert Dashboard
        assertTrue(driver.findElement(By.xpath("//p[text()='Mật khẩu sai.']")).isDisplayed());
    }
    @Test
    public void loginFailed_IncorrectEmail() //TestCase login sai email
    {
        loginPage login = new loginPage(driver);
        login.loginFunction("admi11n@demo.com", "Abcd1234");
        //Assert Dashboard
        assertTrue(driver.findElement(By.xpath("//p[text()='Email này chưa được đăng ký.']")).isDisplayed());
    }
    @AfterMethod
    public void closeBrowser()
    {
        driver.close();
    }
}
