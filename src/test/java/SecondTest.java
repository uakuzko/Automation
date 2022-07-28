import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SecondTest {

    WebDriver driver;

    @BeforeMethod
    void chromeDriverSetup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @Test
    void setupTest() {

        driver.get("http://google.com");

        driver.findElement(By.name("q")).sendKeys("Hentai");
        driver.findElement(By.xpath("//img[@class=\"lnXdpd\"]")).click();
        driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']")).click();

        String actualResult = driver.findElement(By.name("q")).getAttribute("value");
        String expectedResult = "Hentai";

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }
}

