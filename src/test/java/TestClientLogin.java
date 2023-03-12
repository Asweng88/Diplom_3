import io.github.bonigarcia.wdm.WebDriverManager;
import nomoreparties.stellarburgers.LoginPage;
import nomoreparties.stellarburgers.MainPage;
import nomoreparties.stellarburgers.PasswordRecoveryPage;
import nomoreparties.stellarburgers.RegisterPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;

public class TestClientLogin {

    private WebDriver driver;
    private String email = "Clubber@mail.ru";
    private String password = "Clubber";

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void TestClientLoginButtonInterAccount() {


        MainPage mainPage = new MainPage(driver);
        mainPage.open()
                .clickButtonInterAccount();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillInputEmail(email);
        loginPage.fillInputPassword(password);
        loginPage.clickButtonInter();

        assertTrue("Ожидаемый элемент не найден", driver.findElement(MainPage.getButtonCreateOrder()).isEnabled());
    }

    @Test
    public void TestClientLoginButtonPersonalAccount() {


        MainPage mainPage = new MainPage(driver);
        mainPage.open()
                .clickButtonPersonalAccount();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillInputEmail(email);
        loginPage.fillInputPassword(password);
        loginPage.clickButtonInter();

        assertTrue("Ожидаемый элемент не найден", driver.findElement(MainPage.getButtonCreateOrder()).isEnabled());
    }

    @Test
    public void TestClientLoginButtonRegisterPage() {

        new MainPage(driver)
                .open()
                .clickButtonPersonalAccount();

        new LoginPage(driver)
                .clickButtonRegister();

         new RegisterPage(driver)
                 .clickButtonInter();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillInputEmail(email);
        loginPage.fillInputPassword(password);
        loginPage.clickButtonInter();

        assertTrue("Ожидаемый элемент не найден", driver.findElement(MainPage.getButtonCreateOrder()).isEnabled());
    }

    @Test
    public void TestClientLoginButtonPasswordRecoveryPage() {

        new MainPage(driver)
                .open()
                .clickButtonPersonalAccount();

        new LoginPage(driver)
                .clickButtonRecoverPassword();

        new PasswordRecoveryPage(driver)
                .clickButtonInter();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillInputEmail(email);
        loginPage.fillInputPassword(password);
        loginPage.clickButtonInter();

        assertTrue("Ожидаемый элемент не найден", driver.findElement(MainPage.getButtonCreateOrder()).isEnabled());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
