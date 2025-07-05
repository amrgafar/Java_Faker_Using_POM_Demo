package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_HomePage {

    private WebDriver driver;

    public P02_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By logoutButton = By.cssSelector("a.wp-block-button__link");

    public P01_LoginPage clickLogoutButton(){

        driver.findElement(logoutButton).click();
        return new P01_LoginPage(driver);
    }
}
