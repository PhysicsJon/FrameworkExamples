package webdrivertests;

import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import utils.DeviceSizes;
import webdriverstructure.actions.CommonActions;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class WebDriverTestCase {
    protected static WebDriver driver = new BrowserFactory().driver;
    protected CommonActions commonActions = new CommonActions(driver);

    private final DeviceSizes deviceSize = DeviceSizes.valueOf(StringUtils.defaultIfBlank("", "STANDARD").toUpperCase());

    @BeforeAll
    public void beforeAll(){
        driver.manage().window().setSize(deviceSize.getDimension());
        System.out.println("Window size is: " + driver.manage().window().getSize());
    }

    @BeforeEach
    public void beforeEach(){
        driver.get("https://www.bjss.com");
    }

    @AfterAll
    public void dispose(){
        driver.quit();
    }
}
