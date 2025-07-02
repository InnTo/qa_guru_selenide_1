package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

import static com.codeborne.selenide.Selectors.byText;


public class BestContributorSelenide {

    @BeforeAll
    static void setUp() {  //аннотация BeforeAll должна идти с методом static
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void findBestContributorTest() {
        open("https://github.com/selenide/selenide");
        $("div.Layout-sidebar").$(byText("Contributors"))
                .closest("h2").sibling(0).$$("li").first().hover();
        $$(".Popover").findBy(visible).shouldHave(text("Andrei Solntsev"));
    }
}
