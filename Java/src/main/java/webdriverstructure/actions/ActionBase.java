package webdriverstructure.actions;

import org.openqa.selenium.WebDriver;

public class ActionBase {
    protected final WebDriver driver;

    public ActionBase(WebDriver driver){
        this.driver = driver;
    }
}
