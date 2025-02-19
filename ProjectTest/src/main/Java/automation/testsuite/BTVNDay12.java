package automation.testsuite;
import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class BTVNDay12 extends CommonBase {
    @BeforeMethod
    public void openBrowser()
    {
        driver = initBrowser(CT_PageURL.URL_BTVN12);

    }

    @Test
    public void chooseDropdownlist()
    {
        WebElement listDropdown = driver.findElement(By.tagName("select"));

        Select select = new Select(listDropdown);
        select.selectByValue("VNM");
//        if (listDropdown.isSelected()==false)
//        {
//            driver.findElement(By.xpath("//*[@id=\"post-2646\"]/div[2]/div/div/div/p/select")).click();
//            System.out.println("Choose Dropdown list");
//        }
//        WebElement checkboxReading = driver.findElement(By.id("hobbies-checkbox-1"));
//        if (checkboxReading.isSelected()==false)
//        {
//            driver.findElement(By.xpath("//label[text()='Reading']")).click();
//            System.out.println("Checkbox reading has clicked");
//        }
    }
}
