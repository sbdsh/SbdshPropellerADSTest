package pages;


import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class YTSearchPage extends BasePage {

    public static void resultsExist() {
        $(By.xpath("//*[@id=\"contents\"]")).shouldBe(Condition.visible);
    }

    public static void emptySearchResults() {
        $(By.cssSelector("promo-title style-scope ytd-background-promo-renderer")).exists();
    }

}
