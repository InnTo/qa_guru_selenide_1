package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class SelenideRepositorySearch {

    @BeforeAll
    static void setUp() {  //аннотация BeforeAll должна идти с методом static
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void shouldFindSelenideRepositoryAtTheTopTest() {
        open("https://github.com/");
        $(".search-input").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();
        $$("[data-testid=results-list]").first().$("a").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
    }
}