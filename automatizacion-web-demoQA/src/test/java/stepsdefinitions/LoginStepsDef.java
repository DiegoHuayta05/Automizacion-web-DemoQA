package stepsdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import steps.LoginSteps;
import steps.PrincipalSteps;

public class LoginStepsDef {

    private WebDriver driver;
    private Scenario scenario;

    private LoginSteps loginSteps(WebDriver driver){
        return new LoginSteps(driver);
    }

    @Before(order = 0)
    public void setUp(){
        //setUp
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        //crear el driver
        driver = new ChromeDriver();
        //max
        driver.manage().window().maximize();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void quitDriver(){
        //driver.quit();
    }
    @Given("me encuentro en la pàgina principal de demoqa")
    public void me_encuentro_en_la_pàgina_principal_de_demoqa() {
        driver.get("https://demoqa.com/");
        screenShot();

    }
    @And("se da click en Book Store Application")
    public void se_da_click_en_book_store_application() throws InterruptedException {
        PrincipalSteps principalsteps = new PrincipalSteps(driver);
        principalsteps.storeApplication();
        screenShot();
    }
    @And("se da click en Login y New User")
    public void se_da_click_en_login_y_new_user()  {
        LoginSteps loginsteps = new LoginSteps(driver);
        loginsteps.login();
        loginsteps.newUser();
        screenShot();
    }
    @When("ingreso en First Name: {string},Last Name: {string}")
    public void ingreso_en_first_name_last_name(String firstname, String lastname) {
        LoginSteps loginsteps = new LoginSteps(driver);
        loginsteps.inputFirstName(firstname);
        loginsteps.inputLastName(lastname);

    }
    @And("UserName: {string} y Password: {string}")
    public void user_name_y_password(String username, String password) {
        LoginSteps loginsteps = new LoginSteps(driver);
        loginsteps.inputUserName(username);
        loginsteps.inputPassword(password);
    }
    @And("se da click en I'm not a robot y Register")
    public void se_da_click_en_i_m_not_a_robot_y_register() throws InterruptedException {
        LoginSteps loginsteps = new LoginSteps(driver);
        loginsteps.NotRobot();
        screenShot();
    }
    @Then("aparece un mensaje con la confirmación exitosa")
    public void aparece_un_mensaje_con_la_confirmación_exitosa() throws InterruptedException {
        LoginSteps loginsteps = new LoginSteps(driver);
        loginsteps.register();
        screenShot();
    }

    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }

}
