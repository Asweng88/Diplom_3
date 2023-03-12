import io.github.bonigarcia.wdm.WebDriverManager;
import nomoreparties.stellarburgers.LoginPage;
import nomoreparties.stellarburgers.MainPage;
import nomoreparties.stellarburgers.PasswordRecoveryPage;
import nomoreparties.stellarburgers.RegisterPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestTransitionWorkday {

    private WebDriver driver;
    private String email = "Clubber@mail.ru";
    private String password = "Clubber";

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
    }

    @Test
    public void TestButtonTransitionWorkdayRolls() {

        MainPage mainPage = new MainPage(driver);
        mainPage.clickTransitionWorkdaySauces();
        mainPage.clickButtonTransitionWorkdayRolls();
        assertTrue("Элемент не выбран", driver.findElement(MainPage.getDivWorkdayRolls()).getAttribute("class").contains("tab_tab_type_current__2BEPc"));
    }

    @Test
    public void TestButtonTransitionWorkdaySauces() {

        MainPage mainPage = new MainPage(driver);
        mainPage.clickTransitionWorkdaySauces();
        assertTrue("Элемент не выбран", driver.findElement(MainPage.getDivWorkdaySauces()).getAttribute("class").contains("tab_tab_type_current__2BEPc"));
    }

    @Test
    public void TestButtonTransitionWorkdayToppings() {

        MainPage mainPage = new MainPage(driver);
        mainPage.clickButtonTransitionWorkdayToppings();
        assertTrue("Элемент не выбран", driver.findElement(MainPage.getDivWorkdayToppings()).getAttribute("class").contains("tab_tab_type_current__2BEPc"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
