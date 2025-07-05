import Pages.P01_LoginPage;
import Utilities.DataUtil;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TC01_LoginPage {

    private WebDriver driver;

    String USERNAME = new Faker().name().username();

    @BeforeMethod
    public void setupDriver() throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(DataUtil.getPropertyValue("environment", "LOGIN_URL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void validLoginTC() throws IOException {
    new P01_LoginPage(driver).enterUserName(DataUtil.getJsonValue("validLoginData", "username"))
            .enterPassWord(DataUtil.getJsonValue("validLoginData","password"))
            .clickOnSubmitButton();
        Assert.assertEquals(driver.getCurrentUrl(), DataUtil.getPropertyValue("environment", "HOME_URL"));
    }

    @Test
    public void inValidLoginTC() throws IOException {
        new P01_LoginPage(driver).enterUserName(USERNAME)
                .enterPassWord(DataUtil.getJsonValue("validLoginData","password"))
                .clickOnSubmitButton();
        Assert.assertNotEquals(driver.getCurrentUrl(), DataUtil.getPropertyValue("environment", "HOME_URL"));

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
