package webdrivertests;

import org.junit.jupiter.api.Test;
import webdriverstructure.objects.BJSS;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BjssTests extends WebDriverTestCase {
    @Test
    /**
     * description here
     */
    public void BjssTests_PageLoaded(){
        assertTrue(commonActions.ElementDisplayed(BJSS.HeaderLogo));
    }

    @Test
    public void BjssTests_CorrectNumberOfHeaderMenuItemsDisplayed(){
        assertEquals(14, commonActions.GetNumberOfElementsMatching(BJSS.HeaderMenuItem));
    }
}
