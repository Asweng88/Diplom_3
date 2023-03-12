import io.github.bonigarcia.wdm.WebDriverManager;
import nomoreparties.stellarburgers.LoginPage;
import nomoreparties.stellarburgers.MainPage;
import nomoreparties.stellarburgers.PersonalAccount;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class TestTransitionFromPersonalAccountToMainPage {


    private WebDriver driver;

    private String email = "Clubber@mail.ru";
    private String password = "Clubber";

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        new MainPage(driver)
                .open()
                .clickButtonPersonalAccount();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillInputEmail(email);
        loginPage.fillInputPassword(password);
        loginPage.clickButtonInter();
    }

    @Test
    public void transitionLabelStellarBurgers() {

        new PersonalAccount(driver)
                .clickLabelStellarBurgers();

        assertTrue("Ожидаемый элемент не найден", driver.findElement(MainPage.getButtonCreateOrder()).isEnabled());
    }

    @Test
    public void transitionButtonConstructor() {

        new PersonalAccount(driver)
                .clickButtonConstructor();

        assertTrue("Ожидаемый элемент не найден", driver.findElement(MainPage.getButtonCreateOrder()).isEnabled());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
