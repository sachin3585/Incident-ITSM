import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.interactions.Actions as Actions
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
//       , ('password') : 'welcome123'], FailureHandling.STOP_ON_FAILURE)
//WebUI.callTestCase(findTestCase('CreateCase/CreateCaseIncident'), [:], FailureHandling.STOP_ON_FAILURE)

//WebUI.click(findTestObject('DynamicFilters/firstCase'))
WebUI.delay(3)

caseWindowTitle = (WebUI.getWindowTitle().split('-')[0])

println(caseWindowTitle)

caseIdInWorkbench = WebUI.getText(findTestObject('ViewCase/caseIdWorkbench'))

println(caseIdInWorkbench)

GlobalVariable.TicketIDHeader = WebUI.getText(findTestObject('ViewCase/caseHeader'))

println(GlobalVariable.TicketIDHeader)

if (caseWindowTitle.contains(caseIdInWorkbench) && caseWindowTitle.contains(GlobalVariable.TicketIDHeader)) {
    println('Viewing Case Id - ' + GlobalVariable.TicketIDHeader)

    WebUI.delay(5)

    GlobalVariable.vcBusinessService = WebUI.getText(findTestObject('ViewCase/TicketSummary/BusinessService'))

    GlobalVariable.vcPriority = WebUI.getText(findTestObject('ViewCase/TicketSummary/Priority'))

    requesterEmail = WebUI.getText(findTestObject('ViewCase/TicketSummary/vcRequesterEmail'))

    println(GlobalVariable.ccBusinessService + ' Create Case - BS')

    println(GlobalVariable.vcBusinessService + ' View Case - BS')

    println(GlobalVariable.ccPriority + ' Create Case - Priority')

    println(GlobalVariable.vcPriority + ' View Case - Priority')

    println(requesterEmail + ' Create Case - Email')

    if ((GlobalVariable.ccBusinessService.contains(GlobalVariable.vcBusinessService) && GlobalVariable.ccPriority.contains(
        GlobalVariable.vcPriority)) && GlobalVariable.LoggedInUserEmail.contains(requesterEmail)) {
        println('Business Service, Requester and Priority are matching')
    }
} else {
    println('Please Check Case Id')
}