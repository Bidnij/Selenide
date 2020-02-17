import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class SignUpTest {
    private SignUpPage page;
    SignUpPage signUpPage = new SignUpPage();

    @BeforeClass
    public static void setUp() {
        Configuration.baseUrl= "https://www.spotify.com";
        Configuration.browser = "chrome";
    }

    @Test
    public void typeInvalidYear() {
         signUpPage.open().typeEmail("test@test")
                .typeConfirmEmailField("hhhhh")
                .typePassword("testtest")
                .setMonth("December")
                .typeDay("20")
                .typeYear("95");
        System.out.println(signUpPage.getErrorEmail());

    }

    @Test
    public void typeIndvalidEmail() { //проверка на валидность эмейла
        signUpPage.open().typeEmail("bidnaymina")
                    .typeConfirmEmailField(" "); //просто переключение фукуса на другое поле
        System.out.println(signUpPage.getErrorEmail());
        assertEquals(signUpPage.getErrorEmail() , signUpPage.INVALID ); //проверка на то что эмейл в правильном формате

        signUpPage.open().typeEmail("test@test.com")
                .typeConfirmEmailField(" "); //просто переключение фукуса на другое поле
        System.out.println(signUpPage.getErrorEmail());
        assertEquals(signUpPage.getErrorEmail() , signUpPage.EMAILTAKEN ); // проверка на то что такого эмейла нет

        signUpPage.open().signUpButtonClick();
        assertEquals(signUpPage.getErrorEmail() , signUpPage.EMPTYEMAIL );// проверка на пустоту эмейла
    }

    @Test
    public void checkLogo() { // проверка логотипа
        signUpPage.open();
        //System.out.println(signUpPage.getlogoSize());
        assertEquals(signUpPage.getlogoSize(), signUpPage.SIZE); // проверка размера логотипа

        signUpPage.open().logoClick();
        String currentLink = WebDriverRunner.url();
        assertEquals(currentLink, "https://www.spotify.com/us/"); // проверка перехода по клику на логотип
    }
    @Test
    public void checkGenderFill () {
        signUpPage.open().
                typeGender("male");
        assertFalse(signUpPage.genderError());

    }



}
