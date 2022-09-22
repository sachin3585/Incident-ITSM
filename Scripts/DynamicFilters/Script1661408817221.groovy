import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Login'), [('loginUrl') : 'https://brdcmitsmbst.wolkenservicedesk.com/wolken/login', ('userName') : 'harshitha.hs@broadcom.com'
        , ('password') : 'welcome123'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DynamicFilters/Views'))

WebUI.clearText(findTestObject('DynamicFilters/ViewsInput'))

WebDriver driver = DriverFactory.getWebDriver()

List<WebElement> viewsName = driver.findElements(By.xpath('//mat-option'))

for (WebElement views : viewsName) {
    println(views.getText())

    if (views.getText().contains('All Incidents')) {
        JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("document.querySelector('div.mat-autocomplete-panel').scrollTop=5000");

        views.click()

        break
    }
}

