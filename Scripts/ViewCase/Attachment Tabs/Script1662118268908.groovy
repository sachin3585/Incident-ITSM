import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebDriver driver = DriverFactory.getWebDriver()

//WebUI.callTestCase(findTestCase('ViewCase/Internal Notes'), [:], FailureHandling.STOP_ON_FAILURE)
filepath = RunConfiguration.getProjectDir()

WebUI.mouseOver(findTestObject('ViewCase/tabs'))

WebUI.click(findTestObject('ViewCase/Attachments-Tabs/Attachments Tabs'))

WebUI.delay(2)

WebUI.mouseOver(findTestObject('ViewCase/Notes/MouseHOver'))

WebUI.delay(2)

String AttachmentTAB__AttachmentName = WebUI.getText(findTestObject('ViewCase/Attachments-Tabs/AttachmentTab--AttachmentName'))

if (AttachmentTAB__AttachmentName.equalsIgnoreCase(GlobalVariable.Attachment_Text)) {
    println('ATTACHMENT ADDED IN NOTES HAS BEEN ADDED TO ATTACHMENT TAB')
} else {
    println('ATTACHMENT DOESN\'T ADDED TO ATTACHMENT TAB')
}

WebUI.uploadFile(findTestObject('ViewCase/Attachments-Tabs/Add File ---Attachment Tab'), filepath + '\\Image\\Kat.txt')

try {
    WebUI.click(findTestObject('ViewCase/Notes/PopUPYesButton'))
}
catch (Exception e) {
    println('POPUP DOESN\'T DISPLAYED')
} 

WebUI.delay(5)

String AttachmentTAB__Before = WebUI.getText(findTestObject('ViewCase/Attachments-Tabs/AttachmentTab--AttachmentName'))

println(AttachmentTAB__Before)

File file = new File((filepath + '\\Downloaded attachment\\') + AttachmentTAB__Before)

WebUI.delay(8)

if (file.exists()) {
    println(('ATTACHMENT IN ATTACHMENT TAB HAS BEEN DOWNLOADED SUCCESSFULLY' + ' ') + AttachmentTAB__Before)
} else {
    println('ATTACHMENT IN ATTACHMENT TAB DOES NOT DOWNLOADED')
}

WebUI.click(findTestObject('ViewCase/Attachments-Tabs/Attachment Delete button'))

WebUI.click(findTestObject('ViewCase/Attachments-Tabs/Delete confirm button'))

WebUI.delay(5)

String AttachmentTAB__After = WebUI.getText(findTestObject('ViewCase/Attachments-Tabs/AttachmentTab--AttachmentName'))

if (AttachmentTAB__Before.equalsIgnoreCase(AttachmentTAB__After)) {
    println('ATTACHMENT DOESN\'T DELETED IN ATTACHMNET TAB')
} else {
    println('ATTACHMENT HAS BEEN DELETED IN ATTACHMNET TAB')
}

WebUI.delay(2)

WebUI.scrollToElement(findTestObject('ViewCase/Attachments-Tabs/Pagination'), 0)

WebUI.delay(6)

String noOfCasesPaginator = WebUI.getText(findTestObject('ViewCase/Attachments-Tabs/Pagination'))

println(noOfCasesPaginator)

String[] paginator = noOfCasesPaginator.split(' ')

int arraysize = paginator.length

paginaorCount = (paginator[(arraysize - 1)]).toInteger()

println(paginaorCount)

int totalItem