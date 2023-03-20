package nomoreparties.stellarburgers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccount {

    private static WebDriver webDriver;

    public PersonalAccount(WebDriver webDriver) {
        this.webDriver=webDriver;
    }

    // логотип Stellar Burgers
    private static By labelStellarBurgers = By.xpath("//a[@href=\"/\"]");
    // Кнопка Конструктор
    private static By buttonConstructor = By.xpath("//p[text()=\"Конструктор\"]");

    // кнопка Выход
    private static By buttonExit = By.xpath("//button[text()=\"Выход\"]");


    public static By getButtonExit() {
        return buttonExit;
    }

    public void clickLabelStellarBurgers() {
        webDriver.findElement(labelStellarBurgers).click();
    }

    public void clickButtonConstructor() {
        webDriver.findElement(buttonConstructor).click();
    }

    public void clickButtonExit() {
        webDriver.findElement(buttonExit).click();
    }

    public static boolean checkButtonExitIsEnable(){
        boolean result = webDriver.findElement(buttonExit).isEnabled();
        return result;
    }

 }
