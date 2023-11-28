import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Duolingo {
    public static void main(String[] args) throws Exception{

        // Create a new instance of Selenium
        WebDriverManager.firefoxdriver().setup();

        // Use WebDriver to open a new instance of Chrome
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriver driver = new FirefoxDriver();

        // Instruct the driver to browse to the Makers website
        driver.get("https://www.duolingo.com");

        // Take a screenshot of what's currently on the page,
        // and store it in a file 'makers.png' in your project root
        takeScreenshot(driver, "duo.png");

        // Find the title of the webpage (the value inside the HTML
        // <title> element) and print it to the terminal
        System.out.println(driver.getTitle());

        // Close down Selenium and end the test
        driver.quit();
    }

    // Helper function for taking screenshots using WebDriver
    public static void takeScreenshot(WebDriver webdriver,String desiredPath) throws Exception{
        TakesScreenshot screenshot = ((TakesScreenshot)webdriver);
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(desiredPath);
        FileUtils.copyFile(screenshotFile, targetFile);
    }
}

// https://www.duolingo.com