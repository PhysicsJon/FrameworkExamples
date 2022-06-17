package webdrivertests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.util.logging.Level;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NetworkLoggingTest {
    private final ChromeDriver driver;

    public NetworkLoggingTest() {
        WebDriverManager.getInstance(CHROME).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        options.setCapability("goog:loggingPrefs", logPrefs);
        driver = new ChromeDriver(options);
    }

    @Test
    public void NetworkLoggingTest1(){
        driver.get("https://google.com");

        System.out.println("Performance Log Entries");
        for(LogEntry log : driver.manage().logs().get(LogType.PERFORMANCE)){
            System.out.println(log.getMessage());
        }
    }

    @AfterAll
    public void dispose(){
        driver.quit();
    }
}
