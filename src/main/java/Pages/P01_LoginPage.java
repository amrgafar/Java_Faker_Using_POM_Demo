package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {
    //initialize my driver
    private WebDriver driver;

    // make a constructor
    public P01_LoginPage(WebDriver driver){
        this.driver = driver;
    }
    //locate my elements
    private final By userName = By.cssSelector("input[name=username]");
    private final By passWord = By.cssSelector("input[name=password]");
    private final By submitButton = By.cssSelector("#submit.btn");

    //define my methods
    public P01_LoginPage enterUserName(String userNameText){

        driver.findElement(userName).sendKeys(userNameText);
        return this;
    }

    public P01_LoginPage enterPassWord(String passWordText){

        driver.findElement(passWord).sendKeys(passWordText);
        return this;
    }

    public P02_HomePage clickOnSubmitButton(){

        driver.findElement(submitButton).click();
        return new P02_HomePage(driver);
    }



}
