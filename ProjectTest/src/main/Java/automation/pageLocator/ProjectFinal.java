package automation.pageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectFinal {
    private WebDriver driver;

    // Login CRM
    @FindBy(xpath="//input[@id='email']") WebElement textEmail;
    @FindBy(xpath="//input[@id='password']") WebElement textPassword;
    @FindBy(xpath = "//button[@name='signin']") WebElement buttonLogin;

    // Funtion PhongBan
    @FindBy(xpath = "//a[contains(text(),'Quản lý phòng ban')]") WebElement buttonPhongBan;
    @FindBy(xpath = "//button[contains(text(),'Thêm mới')]") WebElement buttonThemMoi;
    @FindBy(xpath = "//input[@name='name']") WebElement textNhanphongban;
    @FindBy(xpath = "//button[contains(text(),'Lưu')]") WebElement buttonLuu;
    @FindBy(xpath = "//button[normalize-space()='Thêm']") WebElement buttonThem;

    // Sua Phong Ban
    @FindBy(xpath = "//tbody/tr[1]/td[5]/a[1]") WebElement buttonSua;

    //Xem Phong Ban
    @FindBy(xpath = "//tbody/tr[1]/td[6]/a[1]") WebElement buttonXem;
    @FindBy(xpath = "//a[contains(text(),'Hủy')]") WebElement buttonHuy;

    // Xoa Phong Ban
    @FindBy(xpath = "//tbody/tr[1]/td[7]/a[1]") WebElement buttonXoa;

    // Xuat Excel
    @FindBy(xpath = "//button[contains(text(),'Xuất ra Excel')]") WebElement buttonXuatexcel;

    // Tim Kiem
    @FindBy(xpath = "//input[@placeholder='Nhập từ khóa cần tìm kiếm']") WebElement textTimKiem;
    @FindBy(xpath = "//button[contains(text(),'Tìm kiếm')]") WebElement buttonTimKiem;

    public ProjectFinal(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void FuntionLogin(String email, String password){
        textEmail.clear();
        textEmail.sendKeys(email);
        textPassword.clear();
        textPassword.sendKeys(password);
        buttonLogin.click();
    }

    public void FuntionPhongBan(String nhapPhongban)
    {
        buttonPhongBan.click();
        buttonThemMoi.click();
        textNhanphongban.clear();
        textNhanphongban.sendKeys(nhapPhongban);
        buttonLuu.click();
        buttonThem.click();
    }

    public void FuntionSuaPhongBan(String nhapPhongban)
    {
        buttonPhongBan.click();
        buttonSua.click();
        textNhanphongban.clear();
        textNhanphongban.sendKeys(nhapPhongban);
        buttonLuu.click();
        buttonThem.click();

    }
    public void FuntionXemPhongBan()
    {
        buttonPhongBan.click();
        buttonXem.click();
        buttonHuy.click();
    }

    public void FuntionXoaPhongBan()
    {
        buttonPhongBan.click();
        buttonXoa.click();
    }

    public void FunctionXuatExcel()
    {
        buttonPhongBan.click();
        buttonXuatexcel.click();
    }

    public void FunctionTimKiem(String tenPhongBan)
    {
        buttonPhongBan.click();
        textTimKiem.clear();
        textTimKiem.sendKeys(tenPhongBan);
        buttonTimKiem.click();

    }
}
