package pagefactory;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Tests extends BaseTest {
    private static final String SEARCH_KEYWORD = "iPhone 11";
    private static final String SEARCH_IPHONE = "iPhone";
    private static final String WRONG_SEARCH_KEYWORD = "asdfgh";
    private static final String EXPECTED_SEARCH_QUERY = "query=iPhone";
    private static final String NOTHING_FOUND = "Ничего не найдено";
    private static final String ADD_SOMETHING_TO_CART = "Чтобы сделать покупку, нужно добавить товары в корзину.";
    private static final String ERROR_MESSAGE = "Ошибка";

    @Test(priority = 1)
    public void checkThatUrlContainsSearchWord() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_SEARCH_QUERY));//проверяем что урла содержит кверю
    }

    @Test(priority = 2)
    public void checkThatAfterWrongSearchDataGivesNoResult() {
        getHomePage().searchByKeyword(WRONG_SEARCH_KEYWORD);
        getHomePage().implicitWait(30);
        assertTrue(getSearchResultsPage().getNothingFound().getText().contains(NOTHING_FOUND));
    }

    @Test(priority = 3)
    public void checkThatYouCantPlaceAnOrderWithEmptyCart() {
        getHomePage().clickOnCart();
        getHomePage().clickOnOrdering();
        assertTrue(getHomePage().getNoResult().getText().contains(ADD_SOMETHING_TO_CART));
    }

    @Test(priority = 4)
    public void checkThatProductsPriceInsideLimits() {
        getHomePage().searchByKeyword(SEARCH_IPHONE);
        getHomePage().implicitWait(30);
        getSearchResultsPage().clearMinInput();
        getSearchResultsPage().inputMinPrice("5000");
        getSearchResultsPage().clearMaxInput();
        getSearchResultsPage().inputMaxPrice("10000");
        getSearchResultsPage().clickFindButton();
        getHomePage().implicitWait(30);
        for (WebElement webElement : getSearchResultsPage().getSearchResultsList()) {
            String price = webElement.getText().substring(0, webElement.getText().indexOf(' '));
            assertTrue(5000 <= Integer.parseInt(price) && Integer.parseInt(price) <= 10000);
        }
    }

    @Test(priority = 5)
    public void checkErrorOnLoginToNonexistentAccount() {
        getHomePage().clickOnLoginButton();
        getHomePage().implicitWait(30);
        getHomePage().clearPhoneNumberInput();
        getHomePage().clearPasswordInput();
        getHomePage().inputPhoneNumber("1234567890");
        getHomePage().inputPassword("qwer1234567890");
        getHomePage().clickEnterButton();
        getHomePage().implicitWait(30);
        assertTrue(getHomePage().getNoAccountMessage().getText().contains(ERROR_MESSAGE));
    }
}
