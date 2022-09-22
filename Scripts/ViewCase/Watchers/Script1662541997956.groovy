import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

//WebUI.callTestCase(findTestCase('ViewCase/Assign'), [('variable') : '', ('variable_0') : '', ('variable_1') : '', ('variable_2') : ''],
//    FailureHandling.STOP_ON_FAILURE)
WebUI.delay(3)

WebUI.scrollToElement(findTestObject('ViewCase/Watchers/WatchesObjects'), 10)

WebDriver driver = DriverFactory.getWebDriver()

WebUI.click(findTestObject('ViewCase/Watchers/External Watcher List'))

WebUI.delay(2)

WebUI.click(findTestObject('ViewCase/Watchers/External Watcher Input'))

WebUI.delay(2)

WebUI.sendKeys(findTestObject('ViewCase/Watchers/Watcher Input Box'), GlobalVariable.ExternalWatcher)

WebUI.delay(8)

List<WebElement> externalwatcher = driver.findElements(By.xpath('(//div[@class=\'cdk-overlay-pane\'])[2]//mat-option//span'))

println(externalwatcher.size())

println(GlobalVariable.ExternalWatcher)

if (externalwatcher.size() > 0) {
    for (WebElement qwerty : externalwatcher) {
        external2 = qwerty.getText()

        println(external2)

        if (external2.trim().equalsIgnoreCase(GlobalVariable.ExternalWatcher)) {
            qwerty.click()
        }
    }
    
    WebUI.click(findTestObject('ViewCase/Watchers/External Watcher Submit button'))
} else {
    ErrorMessage1 = WebUI.getText(findTestObject('ViewCase/Watchers/External Watcher Error Message'))

    println(ErrorMessage1)

    WebUI.click(findTestObject('ViewCase/Watchers/External Watcher cancel button'))
}

WebUI.delay(3)

List<WebElement> externalwatchervalidate = driver.findElements(By.xpath('//e-cc-user-list //label[.=\'External Watcher List :\']/following-sibling::div[1]/span'))

println('externalwatchervalidate ' + externalwatchervalidate.size())

if (externalwatchervalidate.size() > 0) {
    for (WebElement externalwatchervalidate1 : externalwatchervalidate) {
        ext1 = externalwatchervalidate1.getText()

        if (ext1.trim().equalsIgnoreCase(GlobalVariable.ExternalWatcher)) {
            println('External watcher has been succesfully added ' + GlobalVariable.ExternalWatcher)
        }
    }
}

WebUI.click(findTestObject('ViewCase/Watchers/Internal Watcher'))

WebUI.click(findTestObject('ViewCase/Watchers/Internal Watcher input'))

WebUI.sendKeys(findTestObject('ViewCase/Watchers/Internal Watcher input Box'), GlobalVariable.InternalWatcher)

WebUI.delay(8)

List<WebElement> Internalwatcher = driver.findElements(By.xpath('(//div[@class=\'cdk-overlay-pane\'])[2]//mat-option//span'))

println(Internalwatcher.size())

if (Internalwatcher.size() > 0) {
    for (WebElement internal : Internalwatcher) {
        internal1 = internal.getText()

        if (internal1.trim().equalsIgnoreCase(GlobalVariable.InternalWatcher)) {
            internal.click()
        }
    }
    
    WebUI.click(findTestObject('ViewCase/Watchers/External Watcher Submit button'))
} else {
    ErrorMessage1 = WebUI.getText(findTestObject('ViewCase/Watchers/External Watcher Error Message'))

    println(ErrorMessage1)

    WebUI.click(findTestObject('ViewCase/Watchers/External Watcher cancel button'))
}

List<WebElement> internalwatchervalidate = driver.findElements(By.xpath('//e-cc-user-list //label[.=\'Internal Watchers :\']/following-sibling::div[1]/span'))

if (internalwatchervalidate.size() > 0) {
    for (WebElement internalwatchervalidate1 : internalwatchervalidate) {
        ext2 = internalwatchervalidate1.getText()

        if (ext2.trim().equalsIgnoreCase(GlobalVariable.InternalWatcher)) {
            println('Internal watcher has been succesfully added ' + GlobalVariable.InternalWatcher)
        }
    }
}

WebUI.click(findTestObject('ViewCase/Watchers/Custom External Watcher'))

WebUI.click(findTestObject('ViewCase/Watchers/Custom External Input'))

WebUI.sendKeys(findTestObject('ViewCase/Watchers/Custom external Input Box'), GlobalVariable.CustomExternalWatcher)

WebUI.click(findTestObject('ViewCase/Watchers/Custom Add Button'))

WebUI.delay(2)

WebUI.click(findTestObject('ViewCase/Watchers/Custom External Input'))

WebUI.sendKeys(findTestObject('ViewCase/Watchers/Custom external Input Box'), GlobalVariable.CustomExternalWatcher1)

WebUI.click(findTestObject('ViewCase/Watchers/Custom Add Button'))

List<WebElement> Customwatcher = driver.findElements(By.xpath('//div[@class=\'full-width ng-star-inserted\']//div[@fxlayout=\'row wrap\']//div[@class=\'ng-star-inserted\']//button'))

println('Customwatcher ' + Customwatcher.size())

if (Customwatcher.size()) {
    int i = 1

    for (WebElement custom : Customwatcher) {
        i++

        if (i == Customwatcher.size()) {
            custom.click()
        }
    }
}

WebUI.delay(2)

WebUI.click(findTestObject('ViewCase/Watchers/Custom External submit button'))

WebUI.delay(2)

List<WebElement> customexternalwatchervalidate = driver.findElements(By.xpath('//e-cc-user-list //label[.=\'External Watcher List :\']/following-sibling::div[1]/span'))

if (customexternalwatchervalidate.size() > 0) {
    for (WebElement customexternalwatchervalidate1 : customexternalwatchervalidate) {
        ext3 = customexternalwatchervalidate1.getText()

        if (ext3.trim().equalsIgnoreCase(GlobalVariable.CustomExternalWatcher) || ext3.trim().equalsIgnoreCase(GlobalVariable.CustomExternalWatcher1)) {
            println('Custom external watcher has been succesfully added ' + ext3)
        }
    }
}