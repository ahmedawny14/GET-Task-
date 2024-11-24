package Tests;

 import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

 public class TestBase
{
  WebDriver driver;
    @BeforeTest
    public void openUrl() {
        driver = new ChromeDriver();
        driver.get("https://codenboxautomationlab.com/registration-form/");
        driver.manage().window().maximize();

    }



    @AfterTest
    public void closeBrowser() {
        driver.quit();
     }
}


