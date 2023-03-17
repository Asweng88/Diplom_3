import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.ValidatableResponse;
import nomoreparties.stellarburgers.LoginPage;
import nomoreparties.stellarburgers.MainPage;
import nomoreparties.stellarburgers.PersonalAccount;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import url.ApiUserRegister;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;


public class TestTransitionPersonalAccount {
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
        new MainPage(driver)
                .open()
                .clickButtonInterAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillInputEmail(email);
        loginPage.fillInputPassword(password);
        loginPage.clickButtonInter();
    }

    @Test
    public void transitionPersonalAccount() {

        new MainPage(driver)
                .clickButtonPersonalAccount();
        new PersonalAccount(driver);

        assertTrue("Ожидаемый элемент не найден", driver.findElement(PersonalAccount.getButtonExit()).isEnabled());
    }


    @After
    public void tearDown() {
        driver.quit();
        ValidatableResponse response = api.deleteUser(token);
    }
}
