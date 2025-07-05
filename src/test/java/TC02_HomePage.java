import Pages.P01_LoginPage;
import Utilities.DataUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TC02_HomePage {

    private  WebDriver driver;

    @BeforeMethod
    public void setupDriver() throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(DataUtil.getPropertyValue("environment", "LOGIN_URL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void logoutTC() throws IOException {
        new P01_LoginPage(driver).enterUserName(DataUtil.getJsonValue("validLoginData", "username"))
                .enterPassWord(DataUtil.getJsonValue("validLoginData","password"))
                .clickOnSubmitButton()
                        .clickLogoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), DataUtil.getPropertyValue("environment", "LOGIN_URL"));
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
