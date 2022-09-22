import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

int paginaorCount

int numberofactuallyComments

int commentCreationTime

//WebUI.callTestCase(findTestCase('ViewCase/Subject and description'), [:], FailureHandling.STOP_ON_FAILURE)
filepath = RunConfiguration.getProjectDir()

//WebUI.callTestCase(findTestCase('Login'), [('loginUrl') : 'https://brdcmitsmbst.wolkenservicedesk.com/wolken/login', ('userName') : 'harshitha.hs@broadcom.com'
//        , ('password') : 'welcome123'], FailureHandling.STOP_ON_FAILURE)
//WebUI.waitForElementClickable(findTestObject('ViewCase/Notes/SearchBox'), 30)
//WebUI.click(findTestObject('ViewCase/Notes/SearchBox'))
WebDriver driver = DriverFactory.getWebDriver()

//List<WebElement> dropDown = driver.findElements(By.xpath('//div[@class=\'mat-autocomplete-panel mat-autocomplete-visible ng-star-inserted\']//mat-option'))
//
//for (WebElement qwerty : dropDown) {
//    if (qwerty.getText().contains('All Incidents')) {
//        JavascriptExecutor js = ((driver) as JavascriptExecutor)
//
//        js.executeScript('document.querySelector(\'div.mat-autocomplete-panel\').scrollTop=2500')
//
//        qwerty.click()
//
//        break
//    }
//}
//
//WebUI.delay(5)
//
//WebUI.callTestCase(findTestCase('GlobalSearch'), [:], FailureHandling.STOP_ON_FAILURE)
//
//WebUI.delay(5)
List<WebElement> hearder = driver.findElements(By.xpath('//e-case-response//div[contains(@class,\'mat-tab-label mat-ripple\')]//div[@class=\'mat-tab-label-content\']'))

for (WebElement qwerty1 : hearder) {
    if (qwerty1.getText().contains('Notes')) {
        println('Notes has been selected')

        qwerty1.click()

        WebUI.delay(2)

        noOfCasesPaginator = WebUI.getText(findTestObject('ViewCase/Notes/Pagination'))

        println(noOfCasesPaginator)

        String[] paginator = noOfCasesPaginator.split(' ')

        int arraysize = paginator.length

        paginaorCount = (paginator[(arraysize - 1)]).toInteger()

        if (paginaorCount == 0) {
            noDataFound = WebUI.getText(findTestObject('ViewCase/Notes/NoDataFound'))

            println(noDataFound)
        } else {
            println((paginaorCount + ' ') + 'comments are already added')
        }
        
        paginaorCount++

        WebUI.click(findTestObject('ViewCase/Notes/NewResponce'))

        WebUI.delay(2)
    }
}

WebUI.click(findTestObject('ViewCase/Notes with template/Select Template Button'))

WebUI.delay(3)

WebUI.click(findTestObject('ViewCase/Notes with template/Template Search Button'))

WebUI.delay(3)

WebUI.sendKeys(findTestObject('ViewCase/Notes with template/Template Search Button Input Tag'), 'automation Testing')

WebUI.delay(5)

WebUI.click(findTestObject('ViewCase/Notes with template/Templates'))

WebUI.delay(2)

WebUI.click(findTestObject('ViewCase/Notes with template/Submit Button'))

//WebUI.uploadFile(findTestObject('ViewCase/Notes/AddFile'), filepath + '\\Image\\Kat.txt')
//
//WebUI.delay(5)
//
//try {
//    WebUI.click(findTestObject('ViewCase/Notes/PopUPYesButton'))
//}
//catch (Exception e) {
//    println('popup does not displayed')
//} 
//
//WebUI.uploadFile(findTestObject('ViewCase/Notes/AddFile'), filepath + '\\Image\\Image.png')
//
//try {
//    WebUI.click(findTestObject('ViewCase/Notes/PopUPYesButton'))
//}
//catch (Exception e) {
//    println('popup does not displayed')
//} 
//
String str1 = filepath + '\\Image\\Kat.txt'

String str2 = filepath + '\\Image\\Image.png'

String str3 = filepath + '\\Image\\Incidents.docx'

String str4 = filepath + '\\Image\\Incidents.pdf'

String str5 = filepath + '\\Image\\Image.png'

String str6 = filepath + '\\Image\\Incidents.pdf'

//String sixFiles = (((((((((str1 + '\n') + str2) + '\n') + str3) + '\n') + str4) + '\n') + str5) + '\n') + str6
String fivepath = (((((((str1 + '\n') + str2) + '\n') + str3) + '\n') + str4) + '\n') + str5

//try {
//    WebUI.uploadFile(findTestObject('ViewCase/Notes/AddFile'), sixFiles)
//
//    WebUI.delay(5)
//
//    String ErrorMessage = WebUI.getText(findTestObject('Headers/Asdgf'))
//
//    println(ErrorMessage + " eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee")
//}catch(Exception e)
//{
//
//    println('attachments upload error')
//}
WebUI.delay(8)

WebUI.uploadFile(findTestObject('ViewCase/Notes/AddFile'), fivepath)

WebUI.delay(5)

List<WebElement> popupButtons = driver.findElements(By.xpath('//button[@class="wolken-button-sm mat-stroked-button mat-button-base mat-primary"]'))

WebUI.delay(4)

size = popupButtons.size()

for (int i = size - 1; i >= 0; i--) {
    popupButtons.get(i).click()

    WebUI.delay(2)
}

WebUI.delay(2)

WebUI.mouseOver(findTestObject('ViewCase/Notes/EixtButtonDiv'))

WebUI.delay(2)

WebUI.click(findTestObject('ViewCase/Notes/ExitButton'))

WebUI.delay(2)

List<WebElement> DeleteButtons = driver.findElements(By.xpath('//div[@class=\'display_attach\']//button'))

lastbutton = (DeleteButtons.size() - 1)

println(lastbutton + ' DeleteButtons')

DeleteButtons.get(lastbutton).click()

WebUI.delay(2)

WebUI.click(findTestObject('ViewCase/Notes/SendKey'))

WebUI.delay(2)

String LastUpdateOn = WebUI.getText(findTestObject('ViewCase/Notes/LastUpdateOn'))

String Attachment_Text = WebUI.getText(findTestObject('ViewCase/Notes with template/Attachment Text'))

WebUI.click(findTestObject('ViewCase/Notes with template/DownloadButton'))

File file = new File((filepath + '\\Downloaded attachment\\') + Attachment_Text)

WebUI.delay(8)

if (file.exists()) {
    println(('Attachment has been downloaded successfully' + ' ') + Attachment_Text)
} else {
    println('Attachment has not been downloaded successfully')
}