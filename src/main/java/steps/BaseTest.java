package steps;

import org.junit.Before;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @Before
    public void setUp() {
        open("http://youtube.com");
    }

}
