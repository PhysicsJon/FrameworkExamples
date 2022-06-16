using OpenQA.Selenium;

namespace UITestFramework.Tests.actions
{
    public sealed class CommonActions
    {
        private readonly IWebDriver driver;

        public CommonActions(IWebDriver driver)
        {
            this.driver = driver;
        }

        internal void ClickElement(By by) => driver.FindElement(by).Click();

        internal bool ElementDisplayed(By by)
        {
            try
            {
                driver.FindElement(by);
                return true;
            }
            catch
            {
                return false;
            }
        }

        internal string GetTextFromElement(By by) => driver.FindElement(by).Text;
    }
}
