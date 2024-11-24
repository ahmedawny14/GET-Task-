package Tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Data.ReadingFromExcelSheet;
import Pages.RegisterPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class RegisterTests extends TestBase {

    RegisterPage registerPage;

    @Test(priority = 1)
    @Attachment
    public void registerWithValidData() throws IOException, InterruptedException {

        registerPage = new RegisterPage(driver);
        ReadingFromExcelSheet readingFromExcelSheet = new ReadingFromExcelSheet();
        String firstName = readingFromExcelSheet.getCellData(0, 0);
        String lastName = readingFromExcelSheet.getCellData(0, 1);
        String email = readingFromExcelSheet.getCellData(0, 2);
        String phoneNumber = readingFromExcelSheet.getCellData(0, 3);
        String courseName = readingFromExcelSheet.getCellData(0, 4);
        String month = readingFromExcelSheet.getCellData(0, 5);

        registerPage.registerFormFunction(firstName, lastName, email, phoneNumber, courseName, month);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String expectedResult = "Your registration is completed. We will contact with you soon. Thank you !";
        String actualResult = registerPage.getResponseMessage();
        assertEquals(actualResult, expectedResult);
        driver.navigate().refresh();

    }


    @Test(priority = 2)
    @Attachment
    public void registerWithoutFirstName() throws IOException {

        registerPage = new RegisterPage(driver);
        ReadingFromExcelSheet readingFromExcelSheet = new ReadingFromExcelSheet();
        String firstName = " ";
        String lastName = readingFromExcelSheet.getCellData(1, 1);
        String email = readingFromExcelSheet.getCellData(1, 2);
        String phoneNumber = readingFromExcelSheet.getCellData(1, 3);
        String courseName = readingFromExcelSheet.getCellData(1, 4);
        String month = readingFromExcelSheet.getCellData(1, 5);
        registerPage.registerFormFunction(firstName, lastName, email, phoneNumber, courseName, month);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String expectedResult = "This is a required field.";
        String actualResult = registerPage.getFirstNameErrorMessage();
        assertEquals(actualResult, expectedResult);


    }


    @Test(priority = 3)
    @Attachment
    public void registerWithFirstNameStartedWithASmallCharacter() throws IOException {

        registerPage = new RegisterPage(driver);
        ReadingFromExcelSheet readingFromExcelSheet = new ReadingFromExcelSheet();
        String firstName = readingFromExcelSheet.getCellData(2, 0);
        String lastName = readingFromExcelSheet.getCellData(2, 1);
        String email = readingFromExcelSheet.getCellData(2, 2);
        String phoneNumber = readingFromExcelSheet.getCellData(2, 3);
        String courseName = readingFromExcelSheet.getCellData(2, 4);
        String month = readingFromExcelSheet.getCellData(2, 5);
        registerPage.registerFormFunction(firstName, lastName, email, phoneNumber, courseName, month);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String expectedResult = "First Name must start with capital letter.";
        String actualResult = registerPage.getFirstNameErrorMessage();
        assertEquals(actualResult, expectedResult);


    }

    @Test(priority = 4)
    @Attachment
    public void registerWithoutLastName() throws IOException, InterruptedException {

        registerPage = new RegisterPage(driver);
        ReadingFromExcelSheet readingFromExcelSheet = new ReadingFromExcelSheet();
        String firstName = readingFromExcelSheet.getCellData(3, 0);
        String lastName = " ";
        String email = readingFromExcelSheet.getCellData(3, 2);
        String phoneNumber = readingFromExcelSheet.getCellData(3, 3);
        String courseName = readingFromExcelSheet.getCellData(3, 4);
        String month = readingFromExcelSheet.getCellData(3, 5);
        registerPage.registerFormFunction(firstName, lastName, email, phoneNumber, courseName, month);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Thread.sleep(3000);
        String expectedResult = "This is a required field.";
        String actualResult = registerPage.getLastNameErrorMessage();
        assertEquals(actualResult, expectedResult);


    }


    @Test(priority = 5)
    @Attachment
    public void registerWithLastNAmeEqualsFirstName() throws IOException {


        registerPage = new RegisterPage(driver);
        ReadingFromExcelSheet readingFromExcelSheet = new ReadingFromExcelSheet();
        String firstName = readingFromExcelSheet.getCellData(4, 0);
        String lastName = readingFromExcelSheet.getCellData(4, 1);
        String email = readingFromExcelSheet.getCellData(4, 2);
        String phoneNumber = readingFromExcelSheet.getCellData(4, 3);
        String courseName = readingFromExcelSheet.getCellData(4, 4);
        String month = readingFromExcelSheet.getCellData(4, 5);
        registerPage.registerFormFunction(firstName, lastName, email, phoneNumber, courseName, month);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        String expectedResult = "Last Name can’t be equal First Name.";
        String actualResult = registerPage.getLastNameErrorMessage();
        assertEquals(actualResult, expectedResult);


    }

    @Test(priority = 6)
    @Attachment
    public void registerWithoutEmail() throws IOException {
        {
            registerPage = new RegisterPage(driver);
            ReadingFromExcelSheet readingFromExcelSheet = new ReadingFromExcelSheet();
            String firstName = readingFromExcelSheet.getCellData(5, 0);
            String lastName = readingFromExcelSheet.getCellData(5, 1);
            String email = readingFromExcelSheet.getCellData(5, 2);
            String phoneNumber = readingFromExcelSheet.getCellData(5, 3);
            String courseName = readingFromExcelSheet.getCellData(5, 4);
            String month = readingFromExcelSheet.getCellData(5, 5);
            registerPage.registerFormFunction(firstName, lastName, email, phoneNumber, courseName, month);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            String expectedResult = "This is a required field.";
            String actualResult = registerPage.getEmailErrorMessage();
            assertEquals(actualResult, expectedResult);
        }
    }


    @Test(priority = 7)
    @Attachment()
    public void registerWithExistedEmail() throws IOException, InterruptedException {


        registerPage = new RegisterPage(driver);
        ReadingFromExcelSheet readingFromExcelSheet = new ReadingFromExcelSheet();
        String firstName = readingFromExcelSheet.getCellData(6, 0);
        String lastName = readingFromExcelSheet.getCellData(6, 1);
        String email = readingFromExcelSheet.getCellData(6, 2);
        String phoneNumber = readingFromExcelSheet.getCellData(6, 3);
        String courseName = readingFromExcelSheet.getCellData(6, 4);
        String month = readingFromExcelSheet.getCellData(6, 5);
        registerPage.registerFormFunction(firstName, lastName, email, phoneNumber, courseName, month);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String expectedResult = "Email is already existed";
        String actualResult = registerPage.getEmailErrorMessage();
        assertEquals(actualResult, expectedResult);
        driver.navigate().refresh();


    }

    @Test(priority = 8)
    @Attachment

    public void registerWithoutPhoneNumber() throws IOException, InterruptedException {


        registerPage = new RegisterPage(driver);
        ReadingFromExcelSheet readingFromExcelSheet = new ReadingFromExcelSheet();
        String firstName = readingFromExcelSheet.getCellData(7, 0);
        String lastName = readingFromExcelSheet.getCellData(7, 1);
        String email = readingFromExcelSheet.getCellData(7, 2);
        String phoneNumber = "";
        String courseName = readingFromExcelSheet.getCellData(7, 4);
        String month = readingFromExcelSheet.getCellData(7, 5);
        registerPage.registerFormFunction(firstName, lastName, email, phoneNumber, courseName, month);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String expectedResult = "This is a required field.";
        String actualResult = registerPage.getPhoneNUmberMessage();
        assertEquals(actualResult, expectedResult);
        driver.navigate().refresh();


    }

    @Test(priority = 9)
    public void registerWithInvalidPhoneNumber() throws IOException, InterruptedException {

        registerPage = new RegisterPage(driver);
        ReadingFromExcelSheet readingFromExcelSheet = new ReadingFromExcelSheet();
        String firstName = readingFromExcelSheet.getCellData(8, 0);
        String lastName = readingFromExcelSheet.getCellData(8, 1);
        String email = readingFromExcelSheet.getCellData(8, 2);
        String phoneNumber = readingFromExcelSheet.getCellData(8, 3);
        String courseName = readingFromExcelSheet.getCellData(8, 4);
        String month = readingFromExcelSheet.getCellData(8, 5);
        registerPage.registerFormFunction(firstName, lastName, email, phoneNumber, courseName, month);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String expectedResult = "Phone Number is invalid";
        String actualResult = registerPage.getPhoneNUmberMessage();
        assertEquals(actualResult, expectedResult);


    }

    @AfterMethod
    public void takeScreenShot(ITestResult result) throws IOException {


        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String filePath = "./Screenshots/" + result.getName() + ".png";
            FileUtils.copyFile(source, new File(filePath));

            try (FileInputStream inputStream = new FileInputStream(filePath)) {
                Allure.addAttachment(result.getName() + " - Screenshot", "image/png", inputStream, ".png");
            }
        }
        driver.navigate().refresh();

    }


}
