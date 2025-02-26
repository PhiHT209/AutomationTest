package automation.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class loginCRMStar_Day14 {
    private WebDriver driver;
    @FindBy(xpath="//input[@id='email']") WebElement textEmail;
    @FindBy(xpath="//input[@id='password']") WebElement textPassword;
    @FindBy(xpath = "//button[@name='signin']") WebElement buttonLogin;
//    @FindBy(xpath = "//div[@class='avatar2']/child::i") WebElement avatar;
//    @FindBy(xpath = "//a[text()='Thoát']") WebElement buttonLogout;
    @FindBy(xpath = "//button[contains(text(),'Thêm mới')]") WebElement buttonThemmoi;
    @FindBy(id = "select_department_id") WebElement dropDownDepartment;
    @FindBy(id = "select_role_id") WebElement dropDownRole;
    @FindBy(id = "select_workarea_id") WebElement dropDownArea;
    @FindBy(xpath = "//input[@name='username']") WebElement inputName;
    @FindBy(xpath = "//input[@name='email']") WebElement inputEmail;
    @FindBy(xpath = "//input[@name='phone_number']") WebElement inputFone;
    @FindBy(xpath = "//input[@name='code_user']") WebElement inputManguoidung;

    public loginCRMStar_Day14(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void chucnangLogin(String email, String password){
        textEmail.clear();
        textEmail.sendKeys(email);
        textPassword.clear();
        textPassword.sendKeys(password);
        buttonLogin.click();
    }
    public void chucnangThemNhanVien(String phongBan, String role, String KVLV, String HovaTen, String Email, String SDT, String MND )
    {
        buttonThemmoi.click();
        inputName.sendKeys(HovaTen);
        inputEmail.sendKeys(Email);
        inputFone.sendKeys(SDT);
        inputManguoidung.sendKeys(MND);

        Select selectPhongBan = new Select(dropDownDepartment);
        selectPhongBan.selectByContainsVisibleText(phongBan);

        Select selectrole = new Select(dropDownRole);
        selectrole.selectByContainsVisibleText(role);

        Select selectArea = new Select(dropDownArea);
        selectArea.selectByContainsVisibleText(KVLV);
    }

}
