package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SoftAssertionsAndJUnit5InRepository {

    @BeforeAll
    static void setUp() {  //аннотация BeforeAll должна идти с методом static
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void shouldHaveSoftAssertionsAndJUnit5InRepositoryTest() {
        open("https://github.com/selenide/selenide");
        $("#repository-container-header").$(byText("Wiki"))
                .closest("a").click();
        $(".markdown-body").$("ul").shouldHave(text("Soft assertions"));

        $(".markdown-body").$(byText("Soft assertions")).click();
        $$(".markdown-heading").findBy(text("Using JUnit5 extend test class:"))
                .sibling(0).shouldHave(text("""
                        @ExtendWith({SoftAssertsExtension.class})
                        class Tests {
                          @Test
                          void test() {
                            Configuration.assertionMode = SOFT;
                            open("page.html");
                        
                            $("#first").should(visible).click();
                            $("#second").should(visible).click();
                          }
                        }""".trim()));
    }
}
