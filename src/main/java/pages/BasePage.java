package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    public static void searchYT(String searchText) {
        $(By.id("search")).sendKeys(searchText);
        $(By.id("search-icon-legacy")).click();
    }

    public static void pressLoginButton() {
        $(By.xpath("//paper-button[@aria-label='Войти']")).click();
    }

}
