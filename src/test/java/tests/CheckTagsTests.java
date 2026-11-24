package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.empty;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CheckTagsTests {

    @BeforeEach
    void setUp() {
        open("https://qaplayground.dev/apps/tags-input-box/");
    }

    @Test
    void pageShouldBeDisplayed() {
        $(".title h2")
                .shouldBe(visible)
                .shouldHave(exactText("Tags"));
    }

    @Test
    void shouldAddOneTag() {
        $("input")
                .setValue("Maven")
                .pressEnter();

        $$("li")
                .findBy(exactText("Maven"))
                .shouldBe(visible);
    }

    @Test
    void shouldBeDeleteAllTags() {
        $(".details button")
                .click();

        $$(".content li")
                .shouldBe(empty);
    }
}
