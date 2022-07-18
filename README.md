# lambda_test
Assignment Task: Selenium Advanced
Lambda certification test scenario
____________________________________________________________

1. Navigate to https://www.lambdatest.com/.
2. Perform an explicit wait till the time all the elements in the DOM are available.
3. Scroll to the WebElement ‘SEE ALL INTEGRATIONS’ using the scrollIntoView() method. You are free to use any of the available web locators (e.g., XPath, CssSelector, etc.)
4. Click on the link and ensure that it opens in a new Tab.
5. Save the window handles in a List (or array). Print the window handles of the opened windows (now there are two windows open).
6. Verify whether the URL is the same as the expected URL (if not, throw an Assert).
7. On that page, scroll to the page where the WebElement (Codeless Automation) is present.
8. Click the ‘LEARN MORE’ link for Testing Whiz. The page should open in the same window.
9. Check if the title of the page is ‘TestingWhiz Integration | LambdaTest’. If not, raise an Assert.
10. Close the current window using the window handle [which we obtained in step (5)]
11. Print the current window count.
12. On the current window, set the URL to
https://www.lambdatest.com/blog.
13. Click on the ‘Community’ link and verify whether the URL is
https://community.lambdatest.com/.
14. Close the current browser window.
