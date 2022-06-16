using FluentAssertions;
using UITestFramework.Tests.objects;
using UITestFramework.Tests.utils;
using Xunit;

namespace UITestFramework.Tests
{
    public class BjssHomePage : TestBase, IClassFixture<BrowserFactory>
    {
        public BjssHomePage(BrowserFactory factory) : base(factory.Driver)
        {
        }

        [Fact]
        public void BjssHomePage_PageTitleDisplayed()
        {
            commonActions.ElementDisplayed(CommonObjects.PageTitle).Should().BeTrue();
        }
    }
}