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


public class TestTransitionPersonalAccount {

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
    }
}
