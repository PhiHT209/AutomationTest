package automation.common;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CommonBase {

    public WebDriver driver;
    private int pagePageLoadTimeout = 40;

    public WebDriver initBrowser(String URL){
        // Run with firefox
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        return driver;

        // Run with chrome
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.get(URL);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//        return driver;
    }
    // Thay hàm findElemment (locator)
    public WebElement getElementPresentDOM(By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(pagePageLoadTimeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    // Thay hàm webElemment.click()
    public void click (By locator)
    {
        WebElement element = getElementPresentDOM(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(pagePageLoadTimeout));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void type (By locator, String value)
    {
        WebElement element = getElementPresentDOM(locator);
        element.clear();
        element.sendKeys(value);
    }

    public boolean isElementDisplay(By locator)
    {
        try
        {
            WebElement element = getElementPresentDOM(locator);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(pagePageLoadTimeout));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();
        }
        catch (NoSuchElementException ex1)
        {
            return false;
        }
        catch (TimeoutException ex2)
        {
            return false;
        }
    }

    // Cac ham javascript
    public void type_toElementbyvalueAttribute(By locator, String value)
    {
        try
        {
            WebElement element = getElementPresentDOM(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value = '" + value + "'", element);
        }
        catch (StaleElementReferenceException ex)
        {
            type_toElementbyvalueAttribute(locator, value);
        }
    }
    public void scrollToElement(By locator)
    {
        WebElement element = getElementPresentDOM(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void clickJavaScript(By locator)
    {
        WebElement element = getElementPresentDOM(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
}
