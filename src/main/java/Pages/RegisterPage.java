package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends PageBase {


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    private final By firstName = By.name("fname");
    private final By lastName = By.name("lname");
    private final By email = By.name("email");
    private final By phoneNumber = By.id("nf-field-20");
    private final By coursesDropDown = By.id("nf-field-22");
    private final By monthsDropDown = By.id("nf-field-24");
    private final By linkedInRadioButton = By.id("nf-label-class-field-23-1");
    private final By registerButton = By.id("nf-field-15");
    private final By responseMessage = By.cssSelector("div[class='nf-response-msg'] p");
    private final By firstNameErrorMessage = By.xpath("//*[@id=\"nf-error-17\"]/div");
    private final By lastNameErrorMessage = By.xpath("//div[@class='nf-error-msg nf-error-required-error']");
    private final By emailErrorMessage = By.xpath("//div[@id='nf-error-19']//div[@class='nf-error-msg nf-error-required-error'][normalize-space()='This is a required field.']");
    private final By phoneNumberErrorMessage = By.id("nf-error-20");


    public void enterFirstName(String fname) {

        driver.findElement(firstName).sendKeys(fname);
    }

    public void enterLastName(String lname) {

        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterEmail(String emailAddress) {

        driver.findElement(email).sendKeys(emailAddress);
    }

    public void enterPhoneNumber(String phone) {

        driver.findElement(phoneNumber).sendKeys(phone);
    }

    public void selectCourse(String value) {
        Select dropdown = new Select(driver.findElement(coursesDropDown));
        dropdown.selectByValue(value);
    }

    public void selectMonth(String month) {
        Select dropdown = new Select(driver.findElement(monthsDropDown));
        dropdown.selectByValue(month);
    }

    public void clickLinkedInRadioButton() {

        driver.findElement(linkedInRadioButton).click();
    }

    public void clickRegisterButton() {

        driver.findElement(registerButton).click();
    }

    public String getResponseMessage() {

        return driver.findElement(responseMessage).getText();
    }


    public String getFirstNameErrorMessage() {

        return driver.findElement(firstNameErrorMessage).getText();
    }


    public String getLastNameErrorMessage() {

        return driver.findElement(lastNameErrorMessage).getText();
    }

    public String getEmailErrorMessage() {

        return driver.findElement(emailErrorMessage).getText();
    }

    public String getPhoneNUmberMessage() {

        return driver.findElement(phoneNumberErrorMessage).getText();
    }


    public void registerFormFunction(String firstName, String lastName, String email, String phoneNumber, String courseName, String month) {

        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterPhoneNumber(phoneNumber);
        selectCourse(courseName);
        selectMonth(month);
        clickLinkedInRadioButton();
        clickRegisterButton();

    }

}
