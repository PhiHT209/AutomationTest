package automation.pageLocator;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

import java.security.Key;

public class PageBTVN14 {
    private WebDriver driver;
    // Function Reg
    @FindBy(xpath = "//a[contains(text(),'Đăng Ký')]") WebElement buttonDangKy;
    @FindBy(xpath = "//input[@id='txtFirstname']") WebElement textHoTenReg;
    @FindBy(xpath = "//input[@id='txtEmail']") WebElement textEmailReg;
    @FindBy(xpath = "//input[@id='txtCEmail']") WebElement textCEmailReg;
    @FindBy(xpath = "//input[@id='txtPassword']") WebElement textPassReg;
    @FindBy(xpath = "//input[@id='txtCPassword']") WebElement textCPassReg;
    @FindBy(xpath = "//input[@id='txtPhone']") WebElement textFoneReg;
    @FindBy(xpath = "//button[@type='submit']") WebElement buttonConfirmReg;

    // Function Login
    @FindBy(xpath = "//a[contains(text(),'Đăng Nhập')]") WebElement buttonDangNhap;
    @FindBy(xpath="//input[@id='txtLoginUsername']") WebElement textEmail;
    @FindBy(xpath="//input[@id='txtLoginPassword']") WebElement textPassword;
    @FindBy(xpath = "//button[@type='submit']") WebElement buttonLogin;

    // Function Edit Infomation
    @FindBy(xpath = "//i[@class='fa fa-caret-down']") WebElement dropdownavatar;
    @FindBy(xpath = "//a[@class='fs14']") WebElement buttonEditInfo;
    @FindBy(xpath = "//input[@id='txtpassword']") WebElement textPassHienTai;
    @FindBy(xpath = "//input[@id='txtnewpass']") WebElement textPassMoi;
    @FindBy(xpath = "//input[@id='txtrenewpass']") WebElement textRePassMoi;
    @FindBy(xpath = "//button[contains(text(),'Lưu mật khẩu mới')]") WebElement buttonLuuMK;
    @FindBy(xpath = "//a[contains(text(),'Thoát')]") WebElement buttonThoat;
    @FindBy(xpath = "//div[@class='avatar2']/child::i") WebElement avatar;
    @FindBy(xpath = "//a[text()='Thoát']") WebElement buttonLogout;


    public PageBTVN14(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void chucnangRegBTVN_Day14(String hoten, String email, String cemail, String pass, String cpass, String SDT )
    {
        buttonDangKy.click();
        textHoTenReg.clear();
        textHoTenReg.sendKeys(hoten);
        textEmailReg.clear();
        textEmailReg.sendKeys(email);
        textCEmailReg.clear();
        textCEmailReg.sendKeys(cemail);
        textPassReg.clear();
        textPassReg.sendKeys(pass);
        textCPassReg.clear();
        textCPassReg.sendKeys(cpass);
        textFoneReg.clear();
        textFoneReg.sendKeys(SDT);

        buttonConfirmReg.click();

    }

    public void chucnangLoginBTVN_Day14(String email, String password){
        buttonDangNhap.click();
        textEmail.clear();
        textEmail.sendKeys(email);
        textPassword.clear();
        textPassword.sendKeys(password);
        buttonLogin.click();
    }

    public void chucnangDoiMKMoi(String passHienTai, String passMoi, String nhaplaipassMoi){
        dropdownavatar.click();
        buttonEditInfo.click();
        textPassHienTai.clear();
        textPassHienTai.sendKeys(passHienTai);
        textPassMoi.clear();
        textPassMoi.sendKeys(passMoi);
        textRePassMoi.clear();
        textRePassMoi.sendKeys(nhaplaipassMoi);
        buttonLuuMK.click();
    }
    public void logOut(){
        avatar.click();
        buttonLogout.click();
    }

}
