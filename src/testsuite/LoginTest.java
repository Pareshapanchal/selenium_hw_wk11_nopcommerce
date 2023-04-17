package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl =  "https://demo.nopcommerce.com/";// initalise base URL
   // public String browser="Chrome"; // Option to choose Chrome browser please remove comment"//"
    //public String browser="FireFox";// Option to choose FireFox browser please remove comment"//"
    public String browser="Edge";// Option to choose Edge browser "
    @Before
    //loaunching different browser
    public void setUp(){
        openBrowser(baseUrl,browser);
    }
    @Test
    //1.method to check user should navigate to login page successfully
    public void userShouldNavigateToLoginPageSuccessfully(){
        String expectedMessage = "Welcome, Please Sign In!";
        //click on the ‘Login’ link
        driver.findElement(By.linkText("Log in")).click();
        //after click Log in button user should nevigate to Log in page and
        WebElement actualMessage = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        //Verify the text ‘Welcome, Please Sign In!’
        String actMessage = actualMessage.getText();
        Assert.assertEquals("Not Matching",expectedMessage,actMessage);
    }
    @Test
     //2. userShouldLoginSuccessfullyWithValidCredentials
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Click on 'Login' link
        driver.findElement(By.linkText("Log in")).click();
        //Enter valid username
        driver.findElement(By.id("Email")).sendKeys("susandavis@gmail.com");
        //Enter valid password
        driver.findElement(By.name("Password")).sendKeys("susan123");
        //Click on 'LOGIN' button
        driver.findElement(By.xpath("//button[@class = 'button-1 login-button']")).click();
        //Verify the ‘Log out’ text is display
        WebElement logOut = driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
        String actualMesseage = logOut.getText();
        String expectedMessage ="Log out";
        Assert.assertEquals("Not Match",expectedMessage,actualMesseage);
    }
    @Test
    //3. verifyTheErrorMessage
    public void verifyTheErrorMessage() {
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actualErrorMessage;
        //click on the ‘Login’ link
        driver.findElement(By.linkText("Log in")).click();
        //Enter valid username
        driver.findElement(By.id("Email")).sendKeys("susadavis@gmail.com");
        //Enter valid usernameEnter invalid password
        driver.findElement(By.name("Password")).sendKeys("susan123");
        //Click on Login button
        driver.findElement(By.xpath("//button[@class = 'button-1 login-button']")).click();
        //Verify the error message ‘Login was unsuccessful.
        //Please correct the errors and try again. No customer account found’
        actualErrorMessage = driver.findElement(By.xpath("//div[@class ='message-error validation-summary-errors']")).getText();
       Assert.assertEquals("Not Match",expectedErrorMessage,actualErrorMessage);
    }
    @After// closing browser
    public void tearDown(){closeBrowser();}
}
