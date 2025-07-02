package selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LoginPO {

    public void loginWithPassportaAndCard(String card, String password) {

    }

    public void loginWirhUserNameAndPassword(String username, String password) {
        $("#username").setValue(username);
        $("#password").setValue(password);
        $("submit").click();
    }

    public void loginWirhUserNameAndPasswordNegative(String username, String password) {
        $("#username").setValue(username);
        $("#password").setValue(password);
        $("submit").click();
    }
}
