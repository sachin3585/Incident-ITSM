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

WebUI.openBrowser(url)

WebUI.maximizeWindow()

WebUI.delay(5)

currentUrl = WebUI.getUrl()

println(currentUrl)

WebUI.setText(findTestObject('OktaLogin/username'), username)

WebUI.click(findTestObject('OktaLogin/NextButton'))

WebUI.delay(3)

currentUrlPassword = WebUI.getUrl()

println(currentUrlPassword)

if (currentUrlPassword.contains('password')) {
    WebUI.setText(findTestObject('OktaLogin/password'), password)

    WebUI.click(findTestObject('OktaLogin/verifyButton'))

    WebUI.delay(2)

    WebUI.click(findTestObject('OktaLogin/sendCode'))

    WebUI.delay(40)

    homePageUrl = WebUI.getUrl()

    println(homePageUrl)

    if (homePageUrl.contains('dynamic_filter')) {
        println('It is in Dynamic Filter page')

        WebUI.click(findTestObject('Home/userNameBox'))
		
		

        loggedInUserEmail = WebUI.getText(findTestObject('Home/userEmailLoggedIn'))

        println(loggedInUserEmail)

        if (loggedInUserEmail == 'harshitha.hs@broadcom.com') {
            println('Logged in to Harshitha Account')

            WebUI.delay(3)

            WebUI.click(findTestObject('Home/nameWindow'))
        }
    }
} else {
    println('Not in Password page')
}

