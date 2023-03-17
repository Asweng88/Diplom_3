import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.ValidatableResponse;
import nomoreparties.stellarburgers.LoginPage;
import nomoreparties.stellarburgers.MainPage;
import nomoreparties.stellarburgers.PasswordRecoveryPage;
import nomoreparties.stellarburgers.RegisterPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import url.ApiUserRegister;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;

public class TestClientLogin {
    private final ApiUserRegister api = new ApiUserRegister();
    private WebDriver driver;
    private String email = RandomStringUtils.randomAlphabetic(10) + "@mail.ru";
    private String password = RandomStringUtils.randomAlphabetic(10);
    private String name = RandomStringUtils.randomAlphabetic(10);
    private String token;

    @Before
    public void setUp() {
        ValidatableResponse response = api.createUser(email, password, name);
        token = response.extract().path("accessToken");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testClientLoginButtonInterAccount() {

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
    public void testClientLoginButtonPersonalAccount() {
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
    public void testClientLoginButtonRegisterPage() {

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
    public void testClientLoginButtonPasswordRecoveryPage() {

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
        ValidatableResponse response = api.deleteUser(token);
    }

}
