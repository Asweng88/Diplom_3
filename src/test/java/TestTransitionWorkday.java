import io.github.bonigarcia.wdm.WebDriverManager;
import nomoreparties.stellarburgers.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class TestTransitionWorkday {
    private WebDriver driver;

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
        mainPage.clickTransitionWorkdaySauces();
        mainPage.clickButtonTransitionWorkdayRolls();
        assertTrue("Элемент на экране", driver.findElement(MainPage.getRolls()).isDisplayed());
    }

    @Test
    public void testButtonTransitionWorkdaySauces() {

        MainPage mainPage = new MainPage(driver);
        mainPage.clickTransitionWorkdaySauces();
        assertTrue("Элемент на экране", driver.findElement(MainPage.getRolls()).isDisplayed());
    }

    @Test
    public void testButtonTransitionWorkdayToppings() {

        MainPage mainPage = new MainPage(driver);
        mainPage.clickButtonTransitionWorkdayToppings();
        assertTrue("Элемент на экране", driver.findElement(MainPage.getRolls()).isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
