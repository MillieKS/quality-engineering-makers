// Generated by Selenium IDE
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;


public class LocalNewsTest {
  private static WebDriver driver;

  @BeforeAll
  static void launchBrowser() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();

  }

  @AfterAll
  static void tearDown() {
    driver.quit();
  }

  @Test
  public void localNews() throws Exception {
    // Test name: LocalNews
    // Step # | name | target | value
    // 1 | open | /news/localnews | 
    driver.get("https://www.bbc.co.uk/news/localnews");
    // 2 | setWindowSize | 1040x930 | 
    driver.manage().window().setSize(new Dimension(1040, 930));
    // 3 | click | id=ls-c-search__input-label | 
    driver.findElement(By.id("ls-c-search__input-label")).click();
    // 4 | type | id=ls-c-search__input-label | Dagenham
    driver.findElement(By.id("ls-c-search__input-label")).sendKeys("Dagenham");
    // 5 | sendKeys | id=ls-c-search__input-label | ${KEY_ENTER}
    driver.findElement(By.id("ls-c-search__input-label")).sendKeys(Keys.ENTER);
    // 10 second delay
    Thread.sleep(10000);
    // 6 | click | linkText=More Local News | 
    driver.findElement(By.linkText("More Local News")).click();
    // driver.findElement(By.cssSelector("li[data-testid='styled-link-container'] a.ssrcss-k17ofw-InlineLink.e1kn3p7n0")).click();
    // Take a screenshot of what's currently on the page,
    // and store it in a file 'makers.png' in your project root
    takeScreenshot(driver, "localnews.png");

    //WebElement localNewsLink = driver.findElement(By.cssSelector("li[data-testid='styled-link-container'] a.ssrcss-k17ofw-InlineLink.e1kn3p7n0"));


    // driver.findElement(By.xpath("xpath=//a[@class='ssrcss-k17ofw-InlineLink e1kn3p7n0' and contains(text(), 'More Local News')]")).click();
    // driver.findElement(By.cssSelector("a.ssrcss-k17ofw-InlineLink.e1kn3p7n0")).click();

  }

  // Helper function for taking screenshots using WebDriver
  public static void takeScreenshot(WebDriver webdriver,String desiredPath) throws Exception{
    TakesScreenshot screenshot = ((TakesScreenshot)webdriver);
    File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
    File targetFile = new File(desiredPath);
    FileUtils.copyFile(screenshotFile, targetFile);
  }
}

///