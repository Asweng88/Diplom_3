package nomoreparties.stellarburgers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // Заголовок Войти
    private static By headerInter = By.xpath("//h2[text()=\"Вход\"]");

    // поле Email
    private static By inputEmail = By.xpath("//input[@name=\"name\"]");
    // поле Пароль
    private static By inputPassword = By.xpath("//input[@name=\"Пароль\"]");
    // Кнопка Войти
    private static By buttonInter = By.xpath("//button[text()=\"Войти\"]");

    // Кнопка Зарегистрироваться
    private static By buttonRegister = By.xpath("//a[text()=\"Зарегистрироваться\"]");
    // Кнопка Восстановить пароль
    private static By buttonRecoverPassword = By.xpath("//a[text()=\"Восстановить пароль\"]");

    public static By getHeaderInter() {
        return headerInter;
    }

    public void fillInputEmail(String email) {
        webDriver.findElement(inputEmail).sendKeys(email);
    }

    public void fillInputPassword(String password) {
        webDriver.findElement(inputPassword).sendKeys(password);
    }

    public void clickButtonInter(){
        webDriver.findElement(buttonInter).click();
    }

    public void clickButtonRegister(){
             webDriver.findElement(buttonRegister).click();
    }

    public void clickButtonRecoverPassword(){
        webDriver.findElement(buttonRecoverPassword).click();
    }

    public boolean checkHeaderInterIsEnable(){
        boolean result = webDriver.findElement(headerInter).isEnabled();
        return result;
    }

}
