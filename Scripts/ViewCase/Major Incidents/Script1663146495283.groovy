import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

//WebUI.callTestCase(findTestCase('Login'), [('loginUrl') : 'https://brdcmitsmbst.wolkenservicedesk.com/wolken/login', ('userName') : 'harshitha.hs@broadcom.com'
//        , ('password') : 'welcome123'], FailureHandling.STOP_ON_FAILURE)
//
//WebUI.callTestCase(findTestCase('GlobalSearch'), [:], FailureHandling.STOP_ON_FAILURE)
//WebUI.callTestCase(findTestCase('Headers'), [:], FailureHandling.STOP_ON_FAILURE)

//WebUI.callTestCase(findTestCase('ViewCase/Attachment Tabs'), [:], FailureHandling.STOP_ON_FAILURE)
WebDriver driver = DriverFactory.getWebDriver()

WebUI.mouseOver(findTestObject('ViewCase/tabs'))

WebUI.delay(2)

WebUI.click(findTestObject('Major Incidents/Major Incidents tab'))

WebUI.delay(2)

WebUI.mouseOver(findTestObject('ViewCase/Notes/MouseHOver'))

WebUI.delay(2)

WebUI.click(findTestObject('Major Incidents/Propose button'))

WebUI.delay(2)

WebUI.setText(findTestObject('Major Incidents/Propose notes button'), 'propose notes from katalon')

WebUI.click(findTestObject('Major Incidents/Propose submit button'))

WebUI.delay(10)

List<WebElement> buttons = driver.findElements(By.xpath('//e-major-incident //div[@class=\'ng-star-inserted\']/button'))

//eeee = driver.findElements(By.xpath('//e-major-incident //div[@class=\'ng-star-inserted\']/button')).size()
println(buttons.size())

//println(eeee)
if (buttons.size() > 0) {
    WebUI.click(findTestObject('Major Incidents/Reject Button'))

    WebUI.setText(findTestObject('Major Incidents/Reject Notes'), 'katalon Reject notes')

    WebUI.click(findTestObject('Major Incidents/Reject submit button'))

    WebUI.delay(3)

    currentstatus = WebUI.getText(findTestObject('Major Incidents/major Incidents Status'))

    println(currentstatus)

    WebUI.mouseOver(findTestObject('ViewCase/tabs'))

    WebUI.delay(2)

    WebUI.click(findTestObject('Major Incidents/Ticket summary'))

    WebUI.delay(2)

    WebUI.mouseOver(findTestObject('ViewCase/Notes/MouseHOver'))

    WebUI.delay(2)

    WebUI.scrollToElement(findTestObject('Major Incidents/Major Incidents in Ticket summery'), 10)

    WebUI.delay(2)

    TicketCase = WebUI.getText(findTestObject('Major Incidents/Rejected status'))

    println(TicketCase)

    if (currentstatus.equalsIgnoreCase(TicketCase)) {
        println('Major Incidents has been successfully rejected successfully')
    } else {
        println('Major Incidents status error')
    }
    
    WebUI.mouseOver(findTestObject('ViewCase/tabs'))

    WebUI.delay(2)

    WebUI.click(findTestObject('Major Incidents/Major Incidents tab'))

    WebUI.delay(2)

    WebUI.mouseOver(findTestObject('ViewCase/Notes/MouseHOver'))

    WebUI.delay(2)

    WebUI.click(findTestObject('Major Incidents/Propose button'))

    WebUI.setText(findTestObject('Major Incidents/Propose notes button'), 'propose notes from katalon')

    WebUI.click(findTestObject('Major Incidents/Propose submit button'))

    WebUI.delay(4)

    WebUI.click(findTestObject('Major Incidents/promote button'))

    WebUI.setText(findTestObject('Major Incidents/promote testarea'), 'Promote notes from katakon')

    WebUI.click(findTestObject('Major Incidents/Propose submit button'))

    WebUI.click(findTestObject('Major Incidents/Incidents Demote'))

    WebUI.setText(findTestObject('Major Incidents/Demote Text area'), 'Katalon Demote Text area')

    WebUI.click(findTestObject('Major Incidents/Propose submit button'))

    WebUI.mouseOver(findTestObject('ViewCase/tabs'))

    currentstatus1 = WebUI.getText(findTestObject('Major Incidents/major Incidents Status'))

    println(currentstatus1)

    WebUI.mouseOver(findTestObject('ViewCase/tabs'))

    WebUI.delay(2)

    WebUI.click(findTestObject('Major Incidents/Ticket summary'))

    WebUI.delay(2)

    WebUI.mouseOver(findTestObject('ViewCase/Notes/MouseHOver'))

    WebUI.delay(2)

    WebUI.scrollToElement(findTestObject('Major Incidents/Major Incidents in Ticket summery'), 10)

    WebUI.delay(2)

    TicketCase1 = WebUI.getText(findTestObject('Major Incidents/Demoted'))

    println(TicketCase1)

    if (currentstatus1.equalsIgnoreCase(TicketCase1)) {
        println('Major Incidents has been successfully rejected successfully')
    } else {
        println('Major Incidents status error')
    }
} else {
    println('No access to promote or reject major incidence')
}



