package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.PageBTVN14;
import com.github.javafaker.Faker;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static org.testng.Assert.assertTrue;

public class BTVNDay14_Test extends CommonBase {

    @BeforeMethod
    public void openBrowser()
    {
        driver = initBrowser(CT_PageURL.URL_BTVN14);
    }

    Faker fake = new Faker();

    @Test(priority = 1)
    public void regSuccessBTVN14()
    {
        String randomeName = fake.name().fullName();
        String randomeemail = fake.internet().emailAddress();
        String randomePass = fake.internet().password(8,12);
        String randomeFone = "09" + fake.number().digits(8);


        PageBTVN14 reg = new PageBTVN14(driver);
        reg.chucnangRegBTVN_Day14(
                randomeName, randomeemail, randomeemail, randomePass, randomePass, randomeFone
        );
        assertTrue(driver.findElement(By.xpath("//a[text()='Khóa học của tôi' and @class='fleft martop20 khct']")).isDisplayed());
    }


    @Test(priority = 2)
    public void loginSuccessBTVN14()
    {
        PageBTVN14 login = new PageBTVN14(driver);
        login.chucnangLoginBTVN_Day14("phihoang249@gmail.com","Abcd1234");
        assertTrue(driver.findElement(By.xpath("//a[text()='Khóa học của tôi' and @class='fleft martop20 khct']")).isDisplayed());

        // đổi MK mới
        login.chucnangDoiMKMoi("Abcd1234","Abcd1234", "Abcd1234");

        // bỏ qua bảng alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        // Logout
        login.logOut();

        //Login again
        login.chucnangLoginBTVN_Day14("phihoang249@gmail.com","Abcd1234");
        assertTrue(driver.findElement(By.xpath("//a[text()='Khóa học của tôi' and @class='fleft martop20 khct']")).isDisplayed());
    }

//    @Test(priority = 3)
//    public void logOut()
//    {
//        PageBTVN14 logout = new PageBTVN14(driver);
//        logout.logOut();
//    }



//    @AfterMethod
//    public void closeBrowser()
//    {
//        driver.close();
//    }


}
