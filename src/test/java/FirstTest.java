
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FirstTest {

    WebDriver driver;

    @Test
    void setupTest() {

        System.setProperty("webdriver.chrome.driver","C:/webdriver/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("http://google.com");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.click();
        searchBox.sendKeys("Mazafaka");

        WebElement googleLogo = driver.findElement(By.xpath("//img[@alt='Google']"));
        googleLogo.click();

        WebElement pressSearchButton = driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']"));
        pressSearchButton.click();

        String actualResult = driver.findElement(By.name("q")).getAttribute("value");

        String expectedResult = "Mazafaka";
        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }


}
