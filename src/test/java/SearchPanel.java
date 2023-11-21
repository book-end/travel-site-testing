import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;


public class SearchPanel {
    @Test
    public void SearchPanelTest() {
        System.setProperty("webdriver.chrome.driver", "D:\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://easyjet.com/en");
        driver.findElement(By.id("ensCloseBanner")).click();

        driver.findElement(By.cssSelector("input[name='origin']")).click();
        driver.findElement(By.cssSelector("input[name='origin']")).sendKeys("London");

        // li > a > span (parent > child)
        // get list of airports
        List<WebElement> origins = driver.findElements(By.cssSelector("#ui-id-1 li>a>span"));

        for(WebElement origin : origins) {
            if (origin.getText().contains("Luton")) {
                origin.click();
            }
        }

        
    }
}
