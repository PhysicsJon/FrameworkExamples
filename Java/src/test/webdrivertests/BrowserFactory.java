package webdrivertests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;
import static io.github.bonigarcia.wdm.config.DriverManagerType.FIREFOX;

public class BrowserFactory {
    public WebDriver driver;
    private final String browserName = "chrome";

    public BrowserFactory(){
        SetDriver(browserName);
    }

    private void SetDriver(@NotNull String browserName){
        switch (browserName.toLowerCase(Locale.ROOT)) {
            case "firefox", "ff", "mozilla" -> SetFirefoxDriver();
            default -> SetChromeDriver();
        }
    }

    private void SetFirefoxDriver() {
        WebDriverManager.getInstance(FIREFOX).setup();
        driver = new FirefoxDriver();
    }

    private void SetChromeDriver() {
        WebDriverManager.getInstance(CHROME).setup();
        ChromeOptions options = new ChromeOptions();
        if(debuggerAttached()){
            options.addArguments("no-sandbox", "auto-open-devtools-for-tabs", "ignore-certificate-errors");
        }
        else{
            options.addArguments("headless", "no-sandbox", "ignore-certificate-errors");
        }
        driver = new ChromeDriver(options);
    }

    private static boolean debuggerAttached(){
        return java.lang.management
                .ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("jdwp") >= 0;
    }
}
