package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.UUID;

public class RegisterTest extends BaseTest {
    String baseUrl =  "https://demo.nopcommerce.com/";
    // public String browser="Chrome"; // Option to choose Chrome browser please remove comment"//"
    //public String browser="FireFox";// Option to choose FireFox browser please remove comment"//"
    public String browser="Edge";
    @Before
    //launch different browsers
    public void setUp(){openBrowser(baseUrl,browser); }
    @Test
    //1. userShouldNavigateToRegisterPageSuccessfully
    public void userShouldRegisterAccountSuccessfully(){
        //click on the ‘Register’ link
        driver.findElement(By.linkText("Register")).click();
        // Verify the text ‘Register’
        WebElement register = driver.findElement(By.xpath("//div[@class ='page-title']"));
        String acctualRegister = register.getText();
        String expectedRegister = "Register";
        Assert.assertEquals("Not Match",expectedRegister,acctualRegister);
    }
    @Test
    //2. userSholdRegisterAccountSuccessfully
    public void usershouldRegisterAccountSuccessfully(){
        //click on the ‘Register’ link
        driver.findElement(By.linkText("Register")).click();
        //Select gender radio button
        driver.findElement(By.xpath("//input[@id='gender-female']")).click();
        //Enter First name
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Suran");
        //Enter Last name
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Davis");
        //Select Day Month and Year
        Select day = new Select(driver.findElement(By.name("DateOfBirthDay")));
        //select day from dropdown list
        day.selectByVisibleText("2");
        //select month from dropdown list
        Select month = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        month.selectByVisibleText("January");
        //select year from dropdown list
        Select year = new Select(driver.findElement(By.name("DateOfBirthYear")));
        year.selectByVisibleText("1977");
        // random email address will be generated
        final String randomEmail = randomEmail();
        //Enter Email address
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(randomEmail);
        //Enter Password
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("suran123");
        // Enter Confirm password
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("suran123");
        //Click on REGISTER button
        driver.findElement(By.xpath("//button[@id ='register-button']")).click();
        //Verify the text 'Your registration completed’
        String result = driver.findElement(By.xpath("//div[@class='result']")).getText();
        String expectedResult ="Your registration completed";
        Assert.assertEquals("Not Match",expectedResult,result);
    }
    //this method will generate random email address
    private static String randomEmail(){
        return "random-"+ UUID.randomUUID().toString()+"@example.com";
    }
    @After
    //closing browser
    public void tearDown(){
        closeBrowser();
    }
}
