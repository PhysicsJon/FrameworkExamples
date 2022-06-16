package webdriverstructure.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonActions extends ActionBase{
    public CommonActions(WebDriver driver) {
        super(driver);
    }

    public void ClickElement(By by){
        driver.findElement(by).click();
    }

    public void EnterText(By by, String text){
        WebElement element = driver.findElement(by);
        element.clear();
        element.sendKeys(text);
    }

    public String GetTextFromElement(By by){
        return driver.findElement(by).getText();
    }

    public boolean ElementDisplayed(By by){
        try{
            driver.findElement(by);
            return true;
        } catch(Exception ex) {
            return false;
        }
    }

    public int GetNumberOfElementsMatching(By by){
        return driver.findElements(by).size();
    }
}
