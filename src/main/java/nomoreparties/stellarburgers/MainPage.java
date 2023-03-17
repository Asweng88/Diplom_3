package nomoreparties.stellarburgers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver webDriver;

    static String baseURI = "https://stellarburgers.nomoreparties.site/";

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

    // Ингредиент булка
    private static By rolls = By.xpath("//img[@alt=\"Флюоресцентная булка R2-D3\"]");

    // Ингредиент соус
    private static By sauces = By.xpath("//img[@alt=\"Соус традиционный галактический\"]");

    // Ингредиент Начинка
    private static By toppings = By.xpath("//img[@alt=\"Биокотлета из марсианской Магнолии\"]");


    public static By getButtonCreateOrder() {
        return buttonCreateOrder;
    }
    public static By getDivWorkdayRolls() {
        return divWorkdayRolls;
    }
    public static By getDivWorkdaySauces() {
        return divWorkdaySauces;
    }
    public static By getDivWorkdayToppings() {
        return divWorkdayToppings;
    }
    public static By getRolls() {
        return rolls;
    }
    public static By getSauces() {
        return sauces;
    }
    public static By getToppings() {
        return toppings;
    }

    public MainPage open() {
        webDriver.get(baseURI);
        return this;
    }

    public void clickButtonPersonalAccount() {
        webDriver.findElement(buttonPersonalAccount).click();
    }

    public void clickButtonInterAccount() {
        webDriver.findElement(buttonInterAccount).click();
    }

    public void clickButtonCreateOrder() {
        webDriver.findElement(buttonCreateOrder).click();
    }

    public void clickButtonTransitionWorkdayRolls() {
        webDriver.findElement(buttonTransitionWorkdayRolls).click();
    }

    public void clickTransitionWorkdaySauces() {
        webDriver.findElement(buttonTransitionWorkdaySauces).click();
    }

    public void clickButtonTransitionWorkdayToppings() {
        webDriver.findElement(buttonTransitionWorkdayToppings).click();
    }
}
