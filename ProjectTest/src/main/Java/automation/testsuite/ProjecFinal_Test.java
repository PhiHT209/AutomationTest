package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.ProjectFinal;
import automation.pageLocator.loginCRMStar_Day14;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;



public class ProjecFinal_Test extends CommonBase {
    private ProjectFinal projectFinal;
    private String tenPhongBan;


    // Hàm tạo chuỗi random
    public String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }


    // Open browser
    @BeforeMethod
    public void openBrowser()
    {
        driver = initBrowser(CT_PageURL.URL_Final);
        projectFinal = new ProjectFinal(driver);
        projectFinal.FuntionLogin("admin@gmail.com","12345678");
        assertTrue( driver.findElement(By.xpath("//p[@class='text']")).isDisplayed());
    }


    // Function test Quản Lý Phòng Ban
    @Test (priority = 1)
    public void FuntionLogin_AccessPhongBan()
    {
        // Thêm Mới
        tenPhongBan = "Phòng " + generateRandomString(5);
        projectFinal.FuntionPhongBan(tenPhongBan);
        assertTrue(driver.findElement(By.xpath("//div[@class='toast-message']")).isDisplayed());
    }

    @Test (priority = 2, dependsOnMethods = "FuntionLogin_AccessPhongBan")
    public void FuntionTimKiem()
    {
        // Tim Kiem
        projectFinal.FunctionTimKiem(tenPhongBan);
        assertTrue(driver.findElement(By.xpath("//td[contains(text(),'" + tenPhongBan + "')]")).isDisplayed());
    }

    @Test (priority = 3)
    public void FuntionSuaPhongBan()
    {
        // Sửa
        String random1 = "Phòng " + generateRandomString(5);
        projectFinal.FuntionSuaPhongBan(random1);
        assertTrue(driver.findElement(By.xpath("//div[@class='toast-message']")).isDisplayed());
    }

    @Test (priority = 4)
    public void FuntionXemPhongBan()
    {
        // Xem
        projectFinal.FuntionXemPhongBan();
        assertTrue(driver.findElement(By.xpath("//p[@class='text']")).isDisplayed());
    }

    @Test (priority = 5)
    public void FuntionXoaPhongBan()
    {
        // Xóa
        projectFinal.FuntionXoaPhongBan();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.accept();
        assertTrue(driver.findElement(By.xpath("//p[@class='text']")).isDisplayed());
    }

    @Test (priority = 6)
    public void FuntionXuatExcel()
    {
        // Xuất Excel
        projectFinal.FunctionXuatExcel();
        assertTrue(driver.findElement(By.xpath("//p[@class='text']")).isDisplayed());
    }
    @AfterMethod
    public void closeBrowser()
    {
        if (driver != null)
        {
            driver.quit();
        }
    }

}
