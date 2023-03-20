package registration;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.ValidatableResponse;
import nomoreparties.stellarburgers.LoginPage;
import nomoreparties.stellarburgers.RegisterPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import nomoreparties.stellarburgers.MainPage;
import url.ApiUserRegister;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;

public class TestClientRegistration {
    private final ApiUserRegister api = new ApiUserRegister();
    private WebDriver driver;
    private String email = RandomStringUtils.randomAlphabetic(10) + "@mail.ru";
    private String name = RandomStringUtils.randomAlphabetic(10);
    private String password = RandomStringUtils.randomAlphabetic(6);

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void testClientRegistration() {

        new MainPage(driver)
                .open()
                .clickButtonPersonalAccount();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickButtonRegister();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillInputName(name);
        registerPage.fillInputEmail(email);
        registerPage.fillInputPassword(password);
        registerPage.clickButtonRegister();

        assertTrue("Ожидаемый элемент не найден", loginPage.checkHeaderInterIsEnable());
    }


    @After
    public void tearDown() {
        driver.quit();
        ValidatableResponse response = api.loginUser(email, password);
        String token = response.extract().path("accessToken");
        response = api.deleteUser(token);
    }
}
