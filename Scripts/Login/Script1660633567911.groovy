import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(loginUrl)

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Login/username'), userName)

WebUI.setText(findTestObject('Login/password'), password)

WebUI.click(findTestObject('Login/span_Login'))

WebUI.delay(20)

currentUrlHome = WebUI.getUrl()

WebUI.verifyMatch(currentUrlHome, 'https://brdcmitsmbst.wolkenservicedesk.com/wolken/esd/dynamic_filter', false)

WebUI.click(findTestObject('Home/userNameBox'))

GlobalVariable.LoggedInUser = WebUI.getText(findTestObject('Login/LoggedIn Username'))

println(GlobalVariable.LoggedInUser)

GlobalVariable.LoggedInUser = WebUI.getText(findTestObject('Login/LoggedIn Username'))

println(GlobalVariable.LoggedInUser)

GlobalVariable.LoggedInUser = WebUI.getText(findTestObject('Login/LoggedIn Username'))

println(GlobalVariable.LoggedInUser)

GlobalVariable.LoggedInUserEmail = WebUI.getText(findTestObject('Home/userEmailLoggedIn'))

if (userName == GlobalVariable.LoggedInUserEmail) {
    println('Logged in with' + ' ' + GlobalVariable.LoggedInUser)

    WebUI.delay(3)

    WebUI.click(findTestObject('Home/nameWindow'))
} else {
    println('Home Screen has not been loaded yet or some issue with login')
}