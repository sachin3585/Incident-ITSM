import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
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
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

//WebUI.callTestCase(findTestCase('Login'), [('loginUrl') : 'https://brdcmitsmbst.wolkenservicedesk.com/wolken/login', ('userName') : 'harshitha.hs@broadcom.com'
//        , ('password') : 'welcome123'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Home/CreateTicketButton'))

WebUI.delay(4)

createTicketurl = WebUI.getUrl()

println(createTicketurl)

if (createTicketurl.contains('create_incident')) {
    println('Navigated to Create Case Page')

    WebUI.click(findTestObject('CreateCase/ticketType'))

    WebUI.delay(5)

    WebDriver driver = DriverFactory.getWebDriver()

    List<WebElement> requestTypeName = driver.findElements(By.xpath('//mat-option'))

    println(driver.findElements(By.xpath('//mat-option')).size() + '00000000000')

    for (WebElement reqType : requestTypeName) {
        println(reqType.getText())

        if (reqType.getText().contains('Incident')) {
            println(reqType.getText())

            reqType.click()

            WebUI.click(findTestObject('CreateCase/searchBusinessService'))

            WebUI.delay(2)

            GlobalVariable.ccBusinessService = WebUI.getText(findTestObject('CreateCase/firstBusinessService'))

            println(GlobalVariable.ccBusinessService)

            WebUI.click(findTestObject('CreateCase/firstBusinessService'))

            GlobalVariable.ccPriority = WebUI.getText(findTestObject('CreateCase/ccPriority'))

            println(GlobalVariable.ccPriority)

            if (GlobalVariable.ccPriority.equals('Medium - P3')) {
                println('Priority is P3 by default')
            } else {
                println('Priority is  - ' + GlobalVariable.ccPriority)
            }
            
            WebUI.click(findTestObject('CreateCase/ticketOriginField'))

            WebUI.click(findTestObject('CreateCase/matOption'))

            requester = WebUI.getText(findTestObject('CreateCase/Requester'))

            GlobalVariable.ccRequesterEmail = WebUI.getText(findTestObject('CreateCase/RequesterEmail'))

            println(GlobalVariable.ccRequesterEmail)

            if (GlobalVariable.ccRequesterEmail.contains(GlobalVariable.LoggedInUser)) {
                println('Requester is logged in user')
            } else {
                println('Requester is different from Logged in User')
            }
            
            WebUI.setText(findTestObject('CreateCase/subject'), 'Incident from Katalon')

            WebUI.setText(findTestObject('CreateCase/body_id(tinymce)'), 'Katalon - Incident Description')

            WebUI.click(findTestObject('CreateCase/WatchersIcon'))

            WebUI.setText(findTestObject('ViewCase/Watchers/External Watcher Input'), GlobalVariable.CCWatchers)

            WebUI.delay(5)

            List<WebElement> externalwatcher = driver.findElements(By.xpath('(//div[@class=\'cdk-overlay-pane\'])[2]//mat-option//span'))

            println(externalwatcher.size() + 'This is Size')

            if (externalwatcher.size() > 0) {
                for (WebElement external : externalwatcher) {
                    external1 = external.getText()

                    if (external1.trim().equalsIgnoreCase(GlobalVariable.CCWatchers)) {
                        external.click()
                    }
                }
                
                WebUI.click(findTestObject('CreateCase/watcherSubmit'))
            }
            
            submitButton = WebUI.verifyElementClickable(findTestObject('CreateCase/ccSubmitButton'))

            if (submitButton == true) {
                WebUI.click(findTestObject('CreateCase/ccSubmitButton'))

                WebUI.delay(5 //                createCaseAlertMessage = WebUI.getText(findTestObject('CreateCase/CaseCreationAlert'))
                    ) //
                //                println(createCaseAlertMessage)
                //
                //                if (createCaseAlertMessage.contains('Successfully created Ticket')) {
                //                    caseId = (createCaseAlertMessage.split('-')[1]).trim()
                //
                //                    println(caseId)
                //
                //                    WebUI.delay(3)
                //}
            }
            
            break
        }
    }
} else {
    println('Some error in landing in Create Case Page')
}