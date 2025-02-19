package automation.testsuite;
import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class Day12 extends CommonBase {
    @BeforeMethod
    public void openBrowser()
    {
        driver = initBrowser(CT_PageURL.URL_DEMOQA);

    }

    @Test
    public void clickOnCheckbox()
    {
        WebElement checkboxSport = driver.findElement(By.id("hobbies-checkbox-1"));
        if (checkboxSport.isSelected()==false)
        {
            driver.findElement(By.xpath("//label[text()='Sports']")).click();
            System.out.println("Checkbox sprorts has clicked");
        }
        WebElement checkboxReading = driver.findElement(By.id("hobbies-checkbox-1"));
        if (checkboxReading.isSelected()==false)
        {
            driver.findElement(By.xpath("//label[text()='Reading']")).click();
            System.out.println("Checkbox reading has clicked");
        }
    }
}
