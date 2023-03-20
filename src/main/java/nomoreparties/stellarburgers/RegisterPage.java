package nomoreparties.stellarburgers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private static WebDriver webDriver;

    public RegisterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // поле Имя
    private static By inputName = By.xpath("//form[@class=\"Auth_form__3qKeq mb-20\"]/fieldset[1]/div/div/input");
    // поле Email
    private static By inputEmail = By.xpath("//form[@class=\"Auth_form__3qKeq mb-20\"]/fieldset[2]/div/div/input");
    // поле Пароль
    private static By inputPassword = By.xpath("//form[@class=\"Auth_form__3qKeq mb-20\"]/fieldset[3]/div/div/input");
    // Ошибка Некорректный пароль
    private static By errorMessage = By.xpath("//p[text()=\"Некорректный пароль\"]");
    // Кнопка Зарегистрироватся
    private static By buttonRegister = By.xpath("//button[text()=\"Зарегистрироваться\"]");

    // Кнопка Войти
    private static By buttonInter = By.xpath("//a[text()=\"Войти\"]");

    public static By getErrorMessage() {
        return errorMessage;
    }

    public void fillInputName(String name) {
        webDriver.findElement(inputName).sendKeys(name);
    }

    public void fillInputEmail(String email) {
        webDriver.findElement(inputEmail).sendKeys(email);
    }

    public void fillInputPassword(String password) {
        webDriver.findElement(inputPassword).sendKeys(password);
    }

    public void clickButtonRegister(){
             webDriver.findElement(buttonRegister).click();
    }

    public void clickButtonInter(){
        webDriver.findElement(buttonInter).click();
    }

    public static String getErrorMessageText(){
        String result = webDriver.findElement(errorMessage).getText();
        return result;
    }

}
