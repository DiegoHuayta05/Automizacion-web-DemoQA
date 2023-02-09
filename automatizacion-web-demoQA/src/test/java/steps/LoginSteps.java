package steps;

import org.openqa.selenium.WebDriver;
import page.LoginPage;

public class LoginSteps {
    private WebDriver driver;

    //constructor
    public LoginSteps(WebDriver driver){
        this.driver = driver;
    }

    public void login() {
        this.driver.findElement(LoginPage.buttonLogin).click();
    }

    public void newUser(){
        this.driver.findElement(LoginPage.buttonnewUser).click();
    }

    public void inputFirstName(String firstName){
        this.driver.findElement(LoginPage.inputfirstName).sendKeys(firstName);
    }
    public void inputLastName(String lastName){
        this.driver.findElement(LoginPage.inputlastName).sendKeys(lastName);
    }

    public void inputUserName(String userName){
        this.driver.findElement(LoginPage.inputuserName).sendKeys(userName);
    }

    public void inputPassword(String password){
        this.driver.findElement(LoginPage.inputpassword).sendKeys(password);
    }

    public void NotRobot() throws InterruptedException {
        Thread.sleep(13000);
    }

    public void register() throws InterruptedException {
        this.driver.findElement(LoginPage.buttonRegister).click();
        Thread.sleep(2000);

    }


}
