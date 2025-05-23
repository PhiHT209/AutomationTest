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

    // Update hàm tạo tên phòng ban
    public static String generateMeaningfulString() {
        // List các tên phòng ban
        String[] meaningfulWords = {"IT", "HR", "KT", "MKT", "NS", "CSKH", "TCKT"};
        Random random = new Random();
        String prefix = meaningfulWords[random.nextInt(meaningfulWords.length)];
        // Tạo số ngẫu nhiên
        int randomNumber = 100 + random.nextInt(900); // Tạo số từ 100 đến 999
        // Ghép chuỗi
        return prefix + randomNumber;
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
    // Thêm Mới
    @Test (priority = 1)
    public void FuntionLogin_AccessPhongBan()
    {
        tenPhongBan = "Phòng " + generateMeaningfulString();
        projectFinal.FuntionPhongBan(tenPhongBan);
        assertTrue(driver.findElement(By.xpath("//div[@class='toast-message']")).isDisplayed());
    }

    // Tim Kiem
    @Test (priority = 2, dependsOnMethods = "FuntionLogin_AccessPhongBan")
    public void FuntionTimKiem()
    {
        projectFinal.FunctionTimKiem(tenPhongBan);
        assertTrue(driver.findElement(By.xpath("//td[contains(text(),'" + tenPhongBan + "')]")).isDisplayed());
    }

    // Sửa
    @Test (priority = 3, dependsOnMethods = "FuntionLogin_AccessPhongBan")
    public void FuntionSuaPhongBan()
    {
        String tenPhongBanMoi = "Phòng " + generateMeaningfulString();
        tenPhongBan = tenPhongBanMoi;
        projectFinal.FuntionSuaPhongBan( tenPhongBanMoi );
        assertTrue(driver.findElement(By.xpath("//div[@class='toast-message']")).isDisplayed());
    }

    // Xem
    @Test (priority = 4)
    public void FuntionXemPhongBan()
    {
        projectFinal.FuntionXemPhongBan();
        assertTrue(driver.findElement(By.xpath("//p[@class='text']")).isDisplayed());
    }

    // Xóa
    @Test (priority = 5)
    public void FuntionXoaPhongBan()
    {
        projectFinal.FuntionXoaPhongBan();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        assertTrue(driver.findElement(By.xpath("//p[@class='text']")).isDisplayed());
    }

    // Xuất Excel
    @Test (priority = 6)
    public void FuntionXuatExcel()
    {
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
