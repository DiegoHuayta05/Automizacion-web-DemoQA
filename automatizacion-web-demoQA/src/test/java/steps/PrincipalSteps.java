package steps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import page.PrincipalPage;

public class PrincipalSteps {

    private WebDriver driver;

    //constructor
    public PrincipalSteps(WebDriver driver){
        this.driver = driver;
    }

    public void storeApplication() throws InterruptedException {
        this.driver.findElement(PrincipalPage.buttonBookStore).click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,400)");
        Thread.sleep(3000);

    }
}
