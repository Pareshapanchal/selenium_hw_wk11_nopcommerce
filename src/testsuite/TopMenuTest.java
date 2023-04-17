package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class TopMenuTest extends BaseTest {
    String baseUrl =  "https://demo.nopcommerce.com/";
    // public String browser="Chrome"; // Option to choose Chrome browser please remove comment"//"
    //public String browser="FireFox";// Option to choose FireFox browser please remove comment"//"
    public String browser="Edge";
@Before
    //launch different browser
    public void setUp() {
        openBrowser(baseUrl,browser);
    }
    @Test
    //1. userShouldNavigateToComputerPageSuccessfully
    public void userShouldNavigateToComputerPageSuccessfully(){
    //click on the ‘Computers’ Tab
       driver.findElement(By.linkText("Computers")).click();
    //Verify the text ‘Computers’
        WebElement computers = driver.findElement(By.xpath("//div[@class = 'page-title']"));
        String acctual_Computers = computers.getText();
        String expected_Compuers = "Computers";
        Assert.assertEquals("Not Match",expected_Compuers,acctual_Computers);
    }
    @Test
    //2. userShouldNavigateToElectronicsPageSuccessfully
    public void userShouldNavigateToElectronicsPageSuccessfully(){
        //click on the ‘Electronics’ Tab
        driver.findElement(By.linkText("Electronics")).click();
       // Verify the text ‘Electronics’
        WebElement electronics = driver.findElement(By.xpath("//div[@class='page-title']"));
        String acctualElectronics = electronics.getText();
        String expectedElectronics = "Electronics";
        Assert.assertEquals("Not Match",expectedElectronics,acctualElectronics);
    }
    @Test
    //3. userShouldNavigateToApparelPageSuccessfully
    public void userShouldNavigateToApparelPageSuccessfully(){
        //click on the ‘Apparel’Tab
        driver.findElement(By.linkText("Apparel")).click();
        //Verify the text ‘Apparel’
        WebElement apparel = driver.findElement(By.xpath("//div[@class='page-title']"));
        String acctualApparel = apparel.getText();
        String expectedApparel = "Apparel";
        Assert.assertEquals("Not Match",expectedApparel,acctualApparel);
    }
    @Test
    //4.userShouldNavigateToDigitalDownloadsPageSuccessfully
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully(){
        //click on the ‘Digital downloads’ Tab
        driver.findElement(By.linkText("Digital downloads ")).click();
        //Verify the text ‘Digital downloads’
        WebElement apparel = driver.findElement(By.xpath("//div[@class='page-title']"));
        String acctualApparel = apparel.getText();
        String expectedApparel = "Apparel";
        Assert.assertEquals("Not Match",expectedApparel,acctualApparel);
    }
    @Test
    //5. userShouldNavigateToBooksPageSuccessfully
    public void userShouldNavigateToBooksPageSuccessfully(){
        //click on the ‘Books’ Tab
        driver.findElement(By.linkText("Books ")).click();
        //Verify the text ‘Books’
        WebElement books = driver.findElement(By.xpath("//div[@class='page-title']"));
        String acctualBooks = books.getText();
        String expectedBooks = "Books";
        Assert.assertEquals("Not Match",expectedBooks,acctualBooks);
    }
    @Test
    //6. userShouldNavigateToJewelryPageSuccessfully
    public void userShouldNavigateToJewelryPageSuccessfully(){
        //click on the ‘Jewelry’ Tab
        driver.findElement(By.linkText("Jewelry")).click();
        //Verify the text ‘Jewelry’
        WebElement jewelry = driver.findElement(By.xpath("//div[@class='page-title']"));
        String acctualJewelry = jewelry.getText();
        String expectedJewelry = "Jewelry";
        Assert.assertEquals("Not Match",expectedJewelry,acctualJewelry);
    }
    @Test
    //7. userShouldNavigateToGiftCardsPageSuccessfully
    public void userShouldNavigateToGiftCardsPageSuccessfully(){
        //click on the ‘Gift Cards’ Tab
       driver.findElement(By.partialLinkText("Gift Cards")).click();
       //Verify the text ‘Gift Cards’
       WebElement giftCard = driver.findElement(By.xpath("//div[@class='page-title']"));
       String acctualGiftCard = giftCard.getText();
       String expectedGiftCard = "Gift Cards";
       Assert.assertEquals("Not Match",expectedGiftCard,acctualGiftCard);
    }
   @After
    //closing browser
    public void teardown(){
       closeBrowser();
    }
}
