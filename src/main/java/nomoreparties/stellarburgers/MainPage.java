package nomoreparties.stellarburgers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private static WebDriver webDriver;

    private static final String BASE_URI = "https://stellarburgers.nomoreparties.site/";

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // кнопка Личный Кабинет
    private static By buttonPersonalAccount = By.xpath("//p[text()=\"Личный Кабинет\"]");
    // Кнопка Войти в аккаунт
    private static By buttonInterAccount = By.xpath("//button[text()=\"Войти в аккаунт\"]");
    // Кнопка Оформить заказ
    private static By buttonCreateOrder = By.xpath("//button[text()=\"Оформить заказ\"]");

    // Кнопка Переход к разделу Булки
    private static By buttonTransitionWorkdayRolls = By.xpath("//span[text()=\"Булки\"]");
    // Кнопка Переход к разделу Соусы
    private static By buttonTransitionWorkdaySauces = By.xpath("//span[text()=\"Соусы\"]");
    // Кнопка Переход к разделу Начинки
    private static By buttonTransitionWorkdayToppings = By.xpath("//span[text()=\"Начинки\"]");

    // Наименование раздела Булки
    private static By divWorkdayRolls = By.xpath("//span[text()=\"Булки\"]//parent::div");
    // Наименование раздела Соусы
    private static By divWorkdaySauces = By.xpath("//span[text()=\"Соусы\"]//parent::div");
    // Наименование раздела Начинки
    private static By divWorkdayToppings = By.xpath("//span[text()=\"Начинки\"]//parent::div");

    public static By getDivWorkdayRolls() {
        return divWorkdayRolls;
    }

    public static By getDivWorkdaySauces() {
        return divWorkdaySauces;
    }

    public static By getDivWorkdayToppings() {
        return divWorkdayToppings;
    }

    public MainPage open() {
        webDriver.get(BASE_URI);
        return this;
    }

    public void clickButtonPersonalAccount() {
        webDriver.findElement(buttonPersonalAccount).click();
    }

    public void clickButtonInterAccount() {
        webDriver.findElement(buttonInterAccount).click();
    }

    public void clickTransitionWorkday(String element) {
        switch (element) {
            case "rolls":
                webDriver.findElement(buttonTransitionWorkdaySauces).click();
                webDriver.findElement(buttonTransitionWorkdayRolls).click();
                break;
            case "sauces":
                webDriver.findElement(buttonTransitionWorkdaySauces).click();
                break;
            case "toppings":
                webDriver.findElement(buttonTransitionWorkdayToppings).click();
                break;
        }
    }

    public static boolean checkButtonCreateOrder() {
        boolean result = webDriver.findElement(buttonCreateOrder).isEnabled();
        return result;
    }

    public static boolean checkDivWorkdayAttribute(String element) {
        boolean result;
        switch (element) {
            case "rolls":
                result = webDriver.findElement(divWorkdayRolls).getAttribute("class").contains("tab_tab_type_current__2BEPc");
                break;
            case "sauces":
                result = webDriver.findElement(divWorkdaySauces).getAttribute("class").contains("tab_tab_type_current__2BEPc");
                break;
            case "toppings":
                result = webDriver.findElement(divWorkdayToppings).getAttribute("class").contains("tab_tab_type_current__2BEPc");
                break;
            default:
                result = false;

        }
        return result;
    }
}
