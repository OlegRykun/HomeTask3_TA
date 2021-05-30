package pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//input[@id='input_search']")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@class='header-bottom__right-icon']/i[@class='icon icon-cart-new']")
    private WebElement cartButton;

    @FindBy(xpath = "//a[text()='Оформить заказ']")
    private WebElement ordering;

    @FindBy(xpath = "//div[@id='modalAlert']")
    private WebElement noResult;

    @FindBy(xpath = "//div[@class='header-bottom search_mobile_display']//i[@class='icon icon-user-big']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='sign-holder clearfix']//input[@name='login']")
    private WebElement phoneNumber;

    @FindBy(xpath = "//input[@class='validate show-password']")
    private WebElement password;

    @FindBy(xpath = "//button[@class='button-reset main-btn submit main-btn--green']")
    private WebElement enterButton;

    @FindBy(xpath = "//div[@class = 'ttl js_title']")
    private WebElement noAccount;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(final String keyword) {
        searchInput.sendKeys(keyword, Keys.ENTER);
    }

    public void clickOnCart() {
        cartButton.click();
    }

    public void clickOnOrdering() {
        ordering.click();
    }

    public WebElement getNoResult() {
        return noResult;
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void clearPhoneNumberInput() {
        phoneNumber.clear();
    }

    public void inputPhoneNumber(final String keyword) {
        phoneNumber.sendKeys(keyword);
    }

    public void clearPasswordInput() {
        password.clear();
    }

    public void inputPassword(final String keyword) {
        password.sendKeys(keyword);
    }

    public void clickEnterButton() {
        enterButton.click();
    }

    public WebElement getNoAccountMessage() {
        return noAccount;
    }
}
