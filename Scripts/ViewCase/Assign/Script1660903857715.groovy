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

//WebUI.callTestCase(findTestCase('TicketValidation'), [:], FailureHandling.STOP_ON_FAILURE)

currentStatusSubStatus = WebUI.getText(findTestObject('ViewCase/Status/currentStatus'))

println(currentStatusSubStatus)

if (currentStatusSubStatus.contains('Un')) {
    WebUI.click(findTestObject('ViewCase/AssignTransfer/AssignIcon'))

    WebUI.delay(1)

    WebUI.click(findTestObject('ViewCase/AssignTransfer/assignToMeButton'))

    assignAlertMessage = WebUI.getText(findTestObject('ViewCase/alertMessage'))

    println(assignAlertMessage)

    assigneeMe = WebUI.getText(findTestObject('ViewCase/AssignTransfer/currentAssignee'))

    println(assigneeMe)

    statusAfterAssigning = WebUI.getText(findTestObject('ViewCase/Status/currentStatus'))

    println(statusAfterAssigning)

    if (assignAlertMessage.contains('Success') && (statusAfterAssigning == 'Open/Assigned')) {
        println('Case is assigned to me and Status is Open/Assigned - ' + assignAlertMessage)
    }
} else {
    assignee = WebUI.getText(findTestObject('ViewCase/AssignTransfer/currentAssignee'))

    println(assignee)

    'Check Assignee and if it is logged in user Assign to Others(1st row in wolken)'
    if (assignee.contains(GlobalVariable.LoggedInUser)) {
        println('Assigned to Logged in user and buttons should be enabled')

        WebUI.click(findTestObject('ViewCase/AssignTransfer/AssignIcon'))

        WebUI.setText(findTestObject('ViewCase/AssignTransfer/Search'), 'wolken')
		WebUI.delay(3)

        WebUI.click(findTestObject('ViewCase/AssignTransfer/firstUserAssignWindow'))

        WebUI.click(findTestObject('ViewCase/AssignTransfer/assignButton'))

        alertAssigningOthers = WebUI.getText(findTestObject('ViewCase/alertMessage'))
		println(alertAssigningOthers)
		
    } else {
        println('Assigned to - ' + assignee)
    }
}

