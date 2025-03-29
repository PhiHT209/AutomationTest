package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Day16_Alert_Test extends CommonBase {

    @BeforeMethod
    public void openBrowser()
    {
        driver = initBrowser(CT_PageURL.URL_Alert);
    }

    @Test(priority = 1)
    public void pressOkButton()
    {
        click(By.xpath("//a[normalize-space()='Alert with Textbox']"));
        click(By.xpath("//button[@class='btn btn-info']"));

        // Kiem tra ms Alert
        String actualMes = driver.switchTo().alert().getText();
        String expectMes = "Please enter your name";
        assertEquals(actualMes,expectMes);
        //Nhap "Class 12" vaf click on => hienr thij text "Hello Class 12 How are you today"
        driver.switchTo().alert().sendKeys("Class 12");
        driver.switchTo().alert().accept();
        WebElement elementResult = getElementPresentDOM(By.xpath("//p[@id='demo1']"));
        String actualMText = elementResult.getText();
        String expectMText = "Hello Class 12 How are you today";
        assertEquals(actualMText, expectMText);

    }

    @Test (priority = 2)
    public void pressCancelButton()
    {
        click(By.xpath("//a[normalize-space()='Alert with Textbox']"));
        click(By.xpath("//button[@class='btn btn-info']"));

        // Kiem tra ms Alert
        String actualMes = driver.switchTo().alert().getText();
        String expectMes = "Please enter your name";
        assertEquals(actualMes,expectMes);
        //Nhap "Class 12" vaf click on => hienr thij text "Hello Class 12 How are you today"
        driver.switchTo().alert().sendKeys("Class 12");
        driver.switchTo().alert().dismiss();
        assertFalse(isElementDisplay(By.id("demo1")));

    }
    @AfterMethod
    public void closeBrowser()
    {
        driver.close();
    }
}
