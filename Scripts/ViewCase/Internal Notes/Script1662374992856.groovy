import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//WebUI.callTestCase(findTestCase('ViewCase/Notes without Template'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('ViewCase/tabs'))

WebUI.delay(2)

WebUI.click(findTestObject('ViewCase/Notes/Internal Notes'))

WebUI.delay(2)

WebUI.mouseOver(findTestObject('ViewCase/Notes/MouseHOver'))

WebUI.delay(2)

WebUI.click(findTestObject('ViewCase/Notes/Internal Notes Add Comments Button'))

WebUI.delay(2)

myText = 'Internal comments\nhas been added successfully\nby user'

myText = myText.replace('\n', Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('CreateCase/body_id(tinymce)'), myText)

WebUI.delay(4)

WebUI.click(findTestObject('ViewCase/Notes/Internal Comments Submit Button'))

String InternalNotesAddedUserName = WebUI.getText(findTestObject('ViewCase/Notes/InternalNotesAddedBy'))

println(GlobalVariable.LoggedInUser)

if (InternalNotesAddedUserName.equalsIgnoreCase(GlobalVariable.LoggedInUser)) {
    println(('RECENT INTERNAL NOTES HAS BEEN ADDED BY LOGGEDIN USER' + ' ') + GlobalVariable.LoggedInUser)
} else {
    println(('INTERNAL NOTES ERROR' + ' ') + GlobalVariable.LoggedInUser)
}



