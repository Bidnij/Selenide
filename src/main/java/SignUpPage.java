import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.impl.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.*;

public class SignUpPage {
    public final static String relativeOrAbsoluteUrl =  "/us/signup";

    private By emailFriend = cssSelector("#register-email");
    private By confirmEmailField = cssSelector("#register-confirm-email");
    private By passwordField = cssSelector("#register-password");
    private By displayNameField = cssSelector("#register-displayname");
    private By monthDropDown = cssSelector("#register-dob-month");
    private By dayField = cssSelector("#register-dob-day");
    private By yearField = cssSelector("#register-dob-year");
    private By shareCheckbox = cssSelector("#register-thirdparty");
    private By registerButton = cssSelector("#register-button-email-submit");
    private By emailError = cssSelector("#js-register-with-email > fieldset > ul > li:nth-child(1) > label.has-error");
    private By signUpButton = id("register-button-email-submit");
    private By logo = className("spotify-logo");
    private By gender = className("gender");
    private By genderError = cssSelector("#li-gender > label.has-error");

    public final String INVALID = "The email address you supplied is invalid.";
    public final String EMAILTAKEN = "We're sorry, that email is taken.";
    public final String EMPTYEMAIL = "Please enter your email.";
    public final Dimension SIZE = new Dimension (197, 59);


    public SignUpPage open() {
        Selenide.open(relativeOrAbsoluteUrl);
        return this;
    }

    public SignUpPage typeEmail(String email) {
        $(emailFriend).sendKeys(email);
        return this;
    }

    public SignUpPage typeConfirmEmailField(String email) {
        $(confirmEmailField).setValue(email);
        return this;
    }

    public SignUpPage typePassword(String password) {
        $(passwordField).val(password);
        return this;
    }

    //Метод выбора месяца
    public SignUpPage setMonth(String month) {
        $(monthDropDown).selectOption(month);
        return this;
    }

    //Метод для заполнения поля Day
    public SignUpPage typeDay(String day) {
        $(dayField).sendKeys(day);
        return this;
    }

    //Метод для заполнения поля Year
    public SignUpPage typeYear(String year) {
        $(yearField).sendKeys(year);
        return this;
    }
    //Метод проверки отображения ошибки
    public String getErrorEmail () {
       String s =  $(emailError).getText();
        return s;
    }

    public void signUpButtonClick() {
        $(signUpButton).click();
    }

    public void logoClick() {
        $(logo).click();
    }

    public Dimension getlogoSize() {
       Dimension size = $(logo).getSize();
        return size;
    }

    public SignUpPage typeGender (String genderType){
        $(gender).selectRadio(genderType);
        return this;
    }

    public boolean genderError () {
        boolean check = $(genderError).isDisplayed();
        return check;
    }



}
