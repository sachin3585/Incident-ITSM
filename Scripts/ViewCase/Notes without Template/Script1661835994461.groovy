import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

WebUI.delay(4)

int paginaorCount

int numberofactuallyComments

int commentCreationTime

String myText

//WebUI.callTestCase(findTestCase('ViewCase/Notes with Template'), [:], FailureHandling.STOP_ON_FAILURE)
//WebUI.callTestCase(findTestCase('Login'), [('loginUrl') : 'https://brdcmitsmbst.wolkenservicedesk.com/wolken/login', ('userName') : 'harshitha.hs@broadcom.com'
//        , ('password') : 'welcome123'], FailureHandling.STOP_ON_FAILURE)

WebDriver driver = DriverFactory.getWebDriver()

//WebUI.callTestCase(findTestCase('GlobalSearch'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

filepath = RunConfiguration.getProjectDir()

List<WebElement> hearder = driver.findElements(By.xpath('//e-case-response//div[contains(@class,\'mat-tab-label mat-ripple\')]//div[@class=\'mat-tab-label-content\']'))

for (WebElement qwerty1 : hearder) {
    if (qwerty1.getText().contains('Notes')) {
        println('NOTES HAS BEEN SELECTED')

        qwerty1.click()

        WebUI.delay(4)

        noOfCasesPaginator = WebUI.getText(findTestObject('ViewCase/Notes/Pagination'))

        println(noOfCasesPaginator)

        String[] paginator = noOfCasesPaginator.split(' ')

        int arraysize = paginator.length

        paginaorCount = (paginator[(arraysize - 1)]).toInteger()

        if (paginaorCount == 0) {
            noDataFound = WebUI.getText(findTestObject('ViewCase/Notes/NoDataFound'))

            println((noDataFound + ' ') + 'FOR A NEWLY CREATED TICKECT')
        } else {
            println((paginaorCount + ' ') + 'comments are already added')
        }
        
        paginaorCount++

        WebUI.click(findTestObject('ViewCase/Notes/NewResponce'))

        WebUI.delay(2)

        myText = 'First line\nSecond line\nThird line'

        myText = myText.replace('\n', Keys.chord(Keys.ENTER))

        WebUI.setText(findTestObject('CreateCase/body_id(tinymce)'), myText)

        break
    }
}

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

WebUI.delay(5)

String LastUpdateOn = WebUI.getText(findTestObject('ViewCase/Notes/LastUpdateOn'))

GlobalVariable.Attachment_Text = WebUI.getText(findTestObject('ViewCase/Notes with template/Attachment Text'))

WebUI.click(findTestObject('ViewCase/Notes with template/DownloadButton'))

File file = new File((filepath + '\\Downloaded attachment\\') + GlobalVariable.Attachment_Text)

WebUI.delay(8)

if (file.exists()) {
    println(('ATTACHMENT HAS BEEN DOWNLOADED SUCCESSFULLY' + ' ') + GlobalVariable.Attachment_Text)
} else {
    println('ATTACHMENT DOES NOT DOWNLOADED')
}

noOfCasesPaginator1 = WebUI.getText(findTestObject('ViewCase/Notes/Pagination'))

println(noOfCasesPaginator1)

String[] paginator1 = noOfCasesPaginator1.split(' ')

int arraysize = paginator1.length

int TotalpaginaorCount = (paginator1[(arraysize - 1)]).toInteger()

WebUI.delay(2)

if (TotalpaginaorCount == paginaorCount) {
    println('PAGINATION IS INCREMENTED BY ONE COUNT AFTER ADDING ONE NEW RESPONCE')
} else {
    println('PAGINATION DOES NOT INCREMENTED')
}

WebUI.delay(3)

noOfCasesPaginator2 = WebUI.getText(findTestObject('ViewCase/Notes/Pagination'))

String[] paginator2 = noOfCasesPaginator2.split(' ')

int arraysize1 = paginator2.length

paginaorCountperPage = (paginator2[(arraysize1 - 3)]).toInteger()

int notesperpage = 0

if (TotalpaginaorCount <= 10) {
    println('RESPONCE ARE LESS THAN 10')

    List<WebElement> itemPerPage0 = driver.findElements(By.xpath('//div[@class=\'thread-card ng-star-inserted\']'))

    println('number of notes per page' + itemPerPage0.size())

    if (TotalpaginaorCount == itemPerPage0.size()) {
        println('PAGINATION PER PAGE ARE EQUAL' //    String SelectResponcePerPage1 = WebUI.getText(findTestObject('ViewCase/Notes/Iteen Per Page Count 10'))
            //	
            //	println(SelectResponsePerPage1)
            //    SelectResponsePerPage = SelectResponcePerPage1.toInteger()
            )
    } else {
        println('PAGINATION ERROR')
    }
} else if (TotalpaginaorCount > 10) {
    WebUI.click(findTestObject('ViewCase/Notes/Items per page count'))

    WebUI.delay(2)

    WebUI.delay(2)

    WebUI.click(findTestObject('ViewCase/Notes/Iteen Per Page Count 10'))

    int SelectResponsePerPage = 10

    int forloop = TotalpaginaorCount / SelectResponsePerPage

    println(('number of forrloop iterations' + ' ') + forloop)

    for (int i = 0; i <= forloop; i++) {
        List<WebElement> itemPerPage = driver.findElements(By.xpath('//div[@class=\'thread-card ng-star-inserted\']'))

        WebUI.delay(2)

        numberofactuallyComments = (numberofactuallyComments + itemPerPage.size())

        WebUI.delay(2)

        WebUI.click(findTestObject('ViewCase/Notes/NotesNextbotton'))

        WebUI.delay(1)

        if (numberofactuallyComments == TotalpaginaorCount) {
            break
        }
    }
    
    println(('TOTAL NUMBER OF COMMENTS AT END PAGE' + ' ') + numberofactuallyComments)

    println(('TOTAL NUMBER OF COMMENTS IN NOTES' + ' ') + TotalpaginaorCount)

    if (numberofactuallyComments == TotalpaginaorCount) {
        println('TOTAL COMMENTS PER PAGE AT LAST IS EQUAL TO TOTAL NUMBER OF COMMENTS')
    } else {
        println('PAGINATION ERROR IN NOTES')
    }
}

println(LastUpdateOn)

WebUI.mouseOver(findTestObject('ViewCase/tabs'))

WebUI.click(findTestObject('ViewCase/UnifiedHistoryTab'))

WebUI.delay(2)

WebUI.mouseOver(findTestObject('ViewCase/Notes/MouseHOver'))

WebUI.delay(2)

List<WebElement> unifiedHistory = driver.findElements(By.xpath('//e-unified-history[@class=\'ng-star-inserted\']//div[@class=\'thread-card-content wolken-padding-sm\']//span'))

String UnifiedHistoryThread

for (WebElement qwerty : unifiedHistory) {
    UnifiedHistoryThread = qwerty.getText()

    break
}

if (UnifiedHistoryThread.equals(LastUpdateOn)) {
    println('RECENTLY ADDED NOTES THREAD HAS BEEN ADDED TO UNIFIED HISTORY')
} else {
    println('RECENT THREAD DOESNOT ADDED TO UNIFIED HISTORY')
}