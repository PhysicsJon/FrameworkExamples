using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Firefox;
using System;
using System.Diagnostics;
using System.IO;

namespace UITestFramework.Tests.utils
{
    public sealed class BrowserFactory: IDisposable
    {
        string browserType = "chrome";

        public BrowserFactory()
        {
            Driver = GetBrowser(browserType);
        }

        public IWebDriver Driver { get; }

        private static IWebDriver GetLocalChromeDriver()
        {
            return new ChromeDriver(
                Path.GetDirectoryName(AppDomain.CurrentDomain.BaseDirectory),
                GetChromeOptions(!Debugger.IsAttached));
        }

        private static IWebDriver GetChromeDriver()
        {
            return new ChromeDriver(GetChromeOptions(true));
        }

        private static IWebDriver GetFirefoxDriver()
        {
            var options = new FirefoxOptions();
            options.AddArguments("headless", "window-size=1920,1080", "no-sandbox", "acceptInsecureCerts");

            return new FirefoxDriver(options);
        }

        private static ChromeOptions GetChromeOptions(bool headless)
        {
            var options = new ChromeOptions();

            if (headless)
            {
                options.AddArguments("headless", "window-size=1920,1080", "no-sandbox", "ignore-certificate-errors", "log-level=3");
            }
            else
            {
                options.AddArguments("start-maximized", "no-sandbox", "auto-open-devtools-for-tabs", "ignore-certificate-errors", "log-level=3");
            }

            options.AddUserProfilePreference("download.default_directory", Path.GetTempPath());

            return options;
        }

        private IWebDriver GetBrowser(string browser)
        {
            IWebDriver driver = Debugger.IsAttached 
                ? GetLocalChromeDriver()
                : browser.ToLower() switch
                {
                    "chrome" or "googlechrome" => GetChromeDriver(),
                    "firefox" or "ff" or "mozilla" => GetFirefoxDriver(),
                    _ => GetLocalChromeDriver(),
                };

            return driver;
        }

        public void Dispose()
        {
            Driver?.Dispose();
        }
    }
}