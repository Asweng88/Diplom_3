package nomoreparties.stellarburgers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PersonalAccount {

    private static WebDriver webDriver;

    public PersonalAccount(WebDriver webDriver) {
        this.webDriver=webDriver;
    }

    // логотип Stellar Burgers
    private static By labelStellarBurgers = By.xpath("//*[@id=\"root\"]/div/header/nav/a");
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

 }
