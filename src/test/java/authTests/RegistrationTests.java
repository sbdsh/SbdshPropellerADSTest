package authTests;

import org.junit.Test;
import pages.YTLoginPage;
import steps.BaseTest;

public class RegistrationTests extends BaseTest {

    public static final String VALID_NAME = "Leroy";
    public static final String VALID_SURNAME = "Jenkins";
    public static final String VALID_EMAIL = "1sbdshpropellertest@gmail.com";
    public static final String VALID_PASSWORD = "qaZ1wsX2";
    public static final String USED_EMAIL = "propellertest@gmail.com";
    public static final String INVALID_CONFIRMATION = "qaZ1wsX3";
    public static final String INVALID_EMAIL = "proptestcom";
    public static final String SHORT_PASSWORD = "qwe123";
    public static final String SICK_PASSWORD = "qwer1234";
    public static final String RU_PASSWORD = "йцАпяФ123";

    @Test
    public void validRegistrationTest() {
        YTLoginPage.navigateToRegistrationForm();
        YTLoginPage.insertRegistrationInfo(VALID_NAME, VALID_SURNAME, VALID_EMAIL, VALID_PASSWORD, VALID_PASSWORD);
        YTLoginPage.emailConfirmationState();
    }

    @Test
    public void wrongConfirmationCode() {
        YTLoginPage.navigateToRegistrationForm();
        YTLoginPage.insertRegistrationInfo(VALID_NAME, VALID_SURNAME, VALID_EMAIL, VALID_PASSWORD, VALID_PASSWORD);
        YTLoginPage.sendConfirmationCodeState();
        YTLoginPage.wrongConfirmationCodeError();
    }

    @Test
    public void emptyFormTest() {
        YTLoginPage.navigateToRegistrationForm();
        YTLoginPage.insertRegistrationInfo("", "", "", "", "");
        YTLoginPage.emptyFormNotify();
    }

    @Test
    public void emptyPasswordConfirmationTest() {
        YTLoginPage.navigateToRegistrationForm();
        YTLoginPage.insertRegistrationInfo(VALID_NAME, VALID_SURNAME, VALID_EMAIL, VALID_PASSWORD, "");
        YTLoginPage.emptyConfirmationError();
    }

    @Test
    public void wrongPasswordConfirmationTest() {
        YTLoginPage.navigateToRegistrationForm();
        YTLoginPage.insertRegistrationInfo(
                VALID_NAME, VALID_SURNAME, VALID_EMAIL, VALID_PASSWORD, INVALID_CONFIRMATION
        );
        YTLoginPage.wrongConfirmationError();
    }

    @Test
    public void wrongEmailMaskTest() {
        YTLoginPage.navigateToRegistrationForm();
        YTLoginPage.insertRegistrationInfo(VALID_NAME, VALID_SURNAME, INVALID_EMAIL, VALID_PASSWORD, VALID_PASSWORD);
        YTLoginPage.wrongEmailMaskError();
    }

    @Test
    public void invalidSymbolInPasswordTest() {
        YTLoginPage.navigateToRegistrationForm();
        YTLoginPage.insertRegistrationInfo(VALID_NAME, VALID_SURNAME, VALID_EMAIL, RU_PASSWORD, RU_PASSWORD);
        YTLoginPage.invalidSymbolInPasswordError();
    }

    @Test
    public void setSickPasswordTest() {
        YTLoginPage.navigateToRegistrationForm();
        YTLoginPage.insertRegistrationInfo(VALID_NAME, VALID_SURNAME, VALID_EMAIL, SICK_PASSWORD, SICK_PASSWORD);
        YTLoginPage.sickPasswordError();
    }

    @Test
    public void shortPasswordTest() {
        YTLoginPage.navigateToRegistrationForm();
        YTLoginPage.insertRegistrationInfo(VALID_NAME, VALID_SURNAME, VALID_EMAIL, SHORT_PASSWORD, SHORT_PASSWORD);
        YTLoginPage.shortPasswordError();
    }

    @Test
    public void usedEmailTest() {
        YTLoginPage.navigateToRegistrationForm();
        YTLoginPage.insertRegistrationInfo(VALID_NAME, VALID_SURNAME, USED_EMAIL, VALID_PASSWORD, VALID_PASSWORD);
        YTLoginPage.usedEmailError();
    }

}
