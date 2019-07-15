package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class YTLoginPage extends BasePage {

    public static void createAccountLink() {
        $(By.xpath("//span[text()='Создать аккаунт']")).click();
    }

    public static void personalAccountOption() {
        $(By.xpath("//div[@role='menu']/div/div/span[1]")).pressEnter();
    }

    public static void insertRegistrationInfo (String name, String surname, String email, String password,
                                               String confirmation) {
        insertName(name);
        insertSurname(surname);
        insertEmail(email);
        insertPassword(password);
        confirmPassword(confirmation);
        confirmRegistrationData();
    }

    public static void navigateToRegistrationForm () {
        pressLoginButton();
        createAccountLink();
        personalAccountOption();
    }

    public static void emptyFormNotify() {
        emptyNameError();
        emptySurnameError();
        emptyEmailError();
        emptyPasswordError();
    }

    public static void emptyNameError() {
        $(By.tagName("body")).shouldHave(text("Укажите имя"));
    }

    public static void emptySurnameError() {
        $(By.tagName("body")).shouldHave(text("Укажите фамилию"));
    }

    public static void emptyEmailError() {
        $(By.tagName("body")).shouldHave(text("Укажите адрес Gmail"));
    }

    public static void emptyPasswordError() {
        $(By.tagName("body")).shouldHave(text("Введите пароль"));
    }

    public static void emptyConfirmationError() {
        $(By.tagName("body")).shouldHave(text("Подтвердите пароль"));
    }

    public static void wrongEmailMaskError() {
        $(By.tagName("body")).shouldHave(text("Не забудьте указать символ \"@\"."));
    }

    public static void usedEmailError() {
        $(By.tagName("body")).shouldHave(text("Это имя пользователя уже занято. Попробуйте другое."));
    }

    public static void invalidSymbolInPasswordError() {
        $(By.tagName("body")).shouldHave(text("Разрешены только буквы, цифры и общие символы пунктуации."));
    }

    public static void sickPasswordError() {
        $(By.tagName("body"))
                .shouldHave(text("Пароль недостаточно надежен. Попробуйте сочетание букв, цифр и символов."));
    }

    public static void shortPasswordError() {
        $(By.tagName("body")).shouldHave(text("Пароль не может быть короче 8 символов"));
    }

    public static void wrongConfirmationError() {
        $(By.tagName("body")).shouldHave(text("Пароли не совпадают. Повторите попытку."));
    }

    public static void emailConfirmationState() {
        $(By.xpath("//*[@id=\"headingText\"]")).shouldHave(text("Подтвердите адрес электронной почты"));
    }

    public static void sendConfirmationCodeState() {
        $(By.xpath("//*[@id=\"code\"]")).sendKeys("1111111");
        $(By.xpath("//*[@id=\"code\"]")).pressEnter();
    }

    public static void wrongConfirmationCodeError() {
        $(By.tagName("body")).shouldHave(text("Неверный код. Повторите попытку."));
    }

    public static void insertName(String username) {
        $(By.xpath("//*[@id=\"firstName\"]")).sendKeys(username);
    }

    public static void insertSurname(String surname) {
        $(By.xpath("//*[@id=\"lastName\"]")).sendKeys(surname);
    }

    public static void insertEmail(String email) {
        $(By.xpath("//*[@id=\"username\"]")).sendKeys(email);
    }

    public static void insertPassword(String password) {
        $(By.xpath("//*[@id=\"passwd\"]/div[1]/div/div[1]/input")).sendKeys(password);
    }

    public static void confirmPassword(String passwordConfirmation) {
        $(By.xpath("//*[@id=\"confirm-passwd\"]/div[1]/div/div[1]/input")).sendKeys(passwordConfirmation);
    }

    public static void confirmRegistrationData() {
        $(By.xpath("//span[text()='Далее']")).click();
    }

}
