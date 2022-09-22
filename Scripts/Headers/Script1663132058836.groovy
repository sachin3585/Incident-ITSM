import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.awt.Toolkit as Toolkit
import java.awt.datatransfer.DataFlavor as DataFlavor
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
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

//WebUI.callTestCase(findTestCase('GlobalSearch'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

filepath = RunConfiguration.getProjectDir()

WebUI.click(findTestObject('Headers/TickectPDFDownload'))

WebUI.delay(4)

String i = GlobalVariable.TicketIDHeader

File TicketPDFDownload = new File(((filepath + '\\Downloaded attachment\\IncidentReport_') + i) + '.pdf')

if (TicketPDFDownload.exists()) {
    println('Successfully Download the PDF')
} else {
    println('Download PDF Error')
}

WebUI.click(findTestObject('Headers/TicketWordDownload'))

WebUI.delay(4)

File TicketWORDDownload = new File(((filepath + '\\Downloaded attachment\\IncidentReport_') + i) + '.docx')

if (TicketWORDDownload.exists()) {
    println('Successfully Download the WORD')
} else {
    println('Download WORD Error')
}

WebUI.click(findTestObject('Headers/Copy URL'))

WebUI.delay(2)

String CopyLink = WebUI.getText(findTestObject('Headers/Asdgf'))

println(CopyLink)

WebDriver driver = DriverFactory.getWebDriver()

currentTab = WebUI.getWindowIndex()

String clipboard = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null).getTransferData(DataFlavor.stringFlavor)

JavascriptExecutor js = ((driver) as JavascriptExecutor)

js.executeScript('window.open();')

WebUI.switchToWindowIndex(currentTab + 1)

WebUI.navigateToUrl(clipboard)

String str = WebUI.getText(findTestObject('Headers/newTabTickectID'))

println(str)

WebUI.delay(2)

WebUI.switchToWindowIndex(currentTab)

String str88 = WebUI.getAttribute(findTestObject('Headers/AddToFavourite'), 'color')

println(str88)

if (str88 == null) {
    WebUI.click(findTestObject('Headers/AddToFavourite'))

    String favourtite = WebUI.getText(findTestObject('Headers/Asdgf'))

    WebUI.delay(2)

    println(favourtite)
} else {
    println('ticket has been all ready added to favourite list')
}

WebUI.click(findTestObject('Headers/HomePage Button'))

WebUI.click(findTestObject('Headers/Filters Button'))

WebUI.click(findTestObject('Headers/My favourite Case button'))

WebUI.click(findTestObject('Headers/Show Result button'))

String str11 = WebUI.getText(findTestObject('Headers/Favourite Case Ticket ID'))

println(str11)

WebUI.click(findTestObject('Headers/Favourite Case Ticket ID'))