package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.loginCRMStar_Day14;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class loginCRMStar_Day14Test extends CommonBase {
    @BeforeMethod
    public void openBrowser()
    {
        driver = initBrowser(CT_PageURL.URL_CRMStar);
    }
    @Test
    public void loginSuccess()
    {
        loginCRMStar_Day14 login = new loginCRMStar_Day14(driver);
        login.chucnangLogin("admin@gmail.com","12345678");
        assertTrue( driver.findElement(By.xpath("//p[@class='text']")).isDisplayed());
    }
    @Test
    public void themNhanvien()
    {
        loginCRMStar_Day14 login = new loginCRMStar_Day14(driver);
        login.chucnangLogin("admin@gmail.com","12345678");
        assertTrue( driver.findElement(By.xpath("//p[@class='text']")).isDisplayed());
        login.chucnangThemNhanVien("Quản Lý","Admin/IT","KVLV1322",
                "Nguyen Van A","abd@gmail.com","987451236","NDD132");

    }
    @AfterMethod
    public void closeBrowser()
    {
        driver.close();
    }
}
