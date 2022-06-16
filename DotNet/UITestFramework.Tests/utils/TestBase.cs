using OpenQA.Selenium;
using UITestFramework.Tests.actions;

namespace UITestFramework.Tests.utils
{
    public abstract class TestBase
    {
        private readonly IWebDriver driver;
        public readonly CommonActions commonActions;

        private string BaseUrl = "https://www.bjss.com";

        public TestBase(IWebDriver driver)
        {
            this.driver = driver;
            this.commonActions = new CommonActions(this.driver);

            GoToUrl();
        }

        private void GoToUrl()
        {
            driver.Navigate().GoToUrl(BaseUrl);
        }
    }
}
