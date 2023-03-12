package registration;

import io.github.bonigarcia.wdm.WebDriverManager;
import nomoreparties.stellarburgers.LoginPage;
import nomoreparties.stellarburgers.MainPage;
import nomoreparties.stellarburgers.RegisterPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TestErrorClientRegistration {

    private WebDriver driver;
    private String email = RandomStringUtils.randomAlphabetic(10) + "@mail.ru";
    private String name = RandomStringUtils.randomAlphabetic(10);
    private String password = RandomStringUtils.randomAlphabetic(5);

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void testErrorClientRegistration() {


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

        assertEquals("Некорректный пароль", driver.findElement(RegisterPage.getErrorMessage()).getText());
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
