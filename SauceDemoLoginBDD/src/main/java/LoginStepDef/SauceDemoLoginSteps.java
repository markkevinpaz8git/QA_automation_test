package LoginStepDef;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertTrue;



public class SauceDemoLoginSteps {
    WebDriver driver;

    @Given("the user is on the Newspaper login page")
    public void user_is_on_login_page() throws InterruptedException {
    	String driverPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", driverPath + "/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().window().maximize();

    }

    @When("the user enters valid credentials ([^\\\"]*)$")
    public void user_enters_valid_credentials(String userid ) throws InterruptedException {
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys(userid);
        Thread.sleep(50);
        password.sendKeys("secret_sauce");
        Thread.sleep(50);
    }

    @And("user clicks on the login button")
    public void user_clicks_the_login_button()  {
        driver.findElement(By.id("login-button")).click();
    }
    
    @Then("the user is redirected to the homepage")
    public void user_is_redirected_to_homepage() throws InterruptedException {
    	assertTrue("Failed to Login.", driver.getCurrentUrl().contains("inventory"));
        Thread.sleep(1000);

    }
    
    @And("the user logout successfully")
    public void user_logout_successfully() throws InterruptedException {
    	WebElement menuIcon = driver.findElement(By.id("react-burger-menu-btn"));
    	menuIcon.click();
    	Thread.sleep(500);
    	WebElement logOut = driver.findElement(By.id("logout_sidebar_link"));
    	logOut.click();
        driver.quit();
    }

}

