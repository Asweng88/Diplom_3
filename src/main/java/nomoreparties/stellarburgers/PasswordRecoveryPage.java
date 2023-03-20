package nomoreparties.stellarburgers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {

    private WebDriver webDriver;

    public PasswordRecoveryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // поле Email
    private static By inputEmail = By.xpath("//input[@name=\"name\"]");

    // Кнопка Восстановить
    private static By buttonRecovery = By.xpath("//button[text()=\"Восстановить\"]");

    // Кнопка Войти
    private static By buttonInter = By.xpath("//a[text()=\"Войти\"]");

    public void fillInputEmail(String email) {
        webDriver.findElement(inputEmail).sendKeys(email);
    }

    public void clickButtonRecovery(){
        webDriver.findElement(buttonRecovery).click();
    }

    public void clickButtonInter(){
        webDriver.findElement(buttonInter).click();
    }

}
