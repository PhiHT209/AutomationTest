package automation.pageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TADA_UpdatePass_Page {
    private WebDriver driver;

    @FindBy(id = "UserName") WebElement textUsername;
    @FindBy(id = "Password") WebElement textPassword;
    @FindBy(xpath = "//button[contains(text(),'Đăng nhập')]") WebElement btnLogin;
    @FindBy(id = "my_account") WebElement btnMyAcc;
    @FindBy(xpath = "//a[@title='Đổi mật khẩu']") WebElement btnDoiMK;

    @FindBy(id = "OldPassword") WebElement textOldPassword;
    @FindBy(id = "NewPassword") WebElement textNewPassword;
    @FindBy(id = "ConfirmNewPassword") WebElement textCFNewPassword;
    @FindBy(xpath = "//input[@value='Cập nhật']") WebElement btnCapNhat;

    public TADA_UpdatePass_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginFunction(String username, String password)
    {
        textUsername.sendKeys(username);
        textPassword.sendKeys(password);
        btnLogin.click();

    }

    public void updatePass(String oldpass, String newpass)
    {
        btnMyAcc.click();
        textOldPassword.sendKeys(oldpass);
        textNewPassword.sendKeys(newpass);
        textCFNewPassword.sendKeys(newpass);
        btnCapNhat.click();

    }
}
