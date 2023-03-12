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


public class TestPersonalAccountButtonExit {

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
                .clickButtonInterAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillInputEmail(email);
        loginPage.fillInputPassword(password);
        loginPage.clickButtonInter();
        new MainPage(driver)
                .clickButtonPersonalAccount();
    }

    @Test
    public void transitionPersonalAccount() {

        new PersonalAccount(driver).clickButtonExit();

        assertTrue("Ожидаемый элемент не найден", driver.findElement(LoginPage.getHeaderInter()).isEnabled());
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
