import io.github.bonigarcia.wdm.WebDriverManager;
import nomoreparties.stellarburgers.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class TestTransitionWorkday {
    private WebDriver driver;
    private final String element;

    public TestTransitionWorkday(String element) {
        this.element = element;
    }

    @Parameterized.Parameters
    public static Object[][] testTransitionWorkday() {
        //Сгенерируй тестовые данные
        return new Object[][]{
                {"rolls"},
                {"sauces"},
                {"toppings"},
        };
    }

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
    }

    @Test
    public void testButtonTransitionWorkdayRolls() {

        MainPage mainPage = new MainPage(driver);
        mainPage.clickTransitionWorkday(element);
        assertTrue("Элемент не выбран", MainPage.checkDivWorkdayAttribute(element));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
