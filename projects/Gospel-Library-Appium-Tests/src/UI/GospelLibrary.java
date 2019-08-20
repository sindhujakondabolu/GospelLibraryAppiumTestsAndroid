package UI;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.AndroidKeyMetastate;
import io.appium.java_client.touch.WaitOptions;
import javafx.util.Pair;
import org.apache.bcel.generic.NEWARRAY;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static UI.Content.setBooks;
import static UI.Strings.*;
import static java.lang.Integer.parseInt;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class GospelLibrary {
    AppiumDriver driver;
    mainFunctions main;


    @Before
    public void setUp() throws Exception {
        Thread.sleep(milliseconds_2);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("app", System.getProperty("user.dir") + "/../../APK/gospel-library-" + GospelLibraryBuild + ".apk");
        if (AndroidVersion > 5) {
            capabilities.setCapability("automationName", "UiAutomator2");
        }
        capabilities.setCapability("chromedriverChromeMappingFile", System.getProperty("user.dir") + "/../../ChromeDriver/chromeDriverMappings.json");
        capabilities.setCapability("chromedriverExecutableDir", System.getProperty("user.dir") + "/../../ChromeDriver");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        setBooks();

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }


    //********************************************** Functions **********************************************

    //creates app specific id

    public String AppId(String id) throws Exception {
        String theNewId = "org.lds.ldssa." + GospelLibraryBuild + ":id/" + id;
        return theNewId;
    }

    public void log(String theStringToLog) throws Exception{
        System.out.println(theStringToLog);
    }

    //Replaces letters with dots
    public String hidePassword(String password) throws Exception {
        String passwordDotted = "";
//        if (AndroidVersion > 6) {
//            int passwordLength = password.length();
//            for (int i = 0; i < passwordLength; i++) {
//                passwordDotted = passwordDotted.concat("•");
//            }
//        }
        passwordDotted = password;
        return passwordDotted;
    }

    //Changes text to caps if on android 7 or higher
    public String isAllCaps(String text) throws Exception {
        if (AndroidVersion > 6) {
            text = text.toUpperCase();
        }
        System.out.println(text);
        return text;
    }

    ;

    public String isAndroidVersion(String androidSixAndBelow, String androidSevenAndUp) {
        if (AndroidVersion > 6) {
            return androidSevenAndUp;
        } else {
            return androidSixAndBelow;
        }
    }

    //Get Element by text
    public String FindElementByText(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized) {
            text = isAllCaps(text);
        }
        String xPathofText = "//android.widget.TextView[@text='" + text + "']";
        //System.out.println("Xpath is: '"+xPathofText+"");
        return xPathofText;
    }


    //Get Element by text contains
    public String FindElementByContainsText(String text) throws Exception {
        String xPathofText = "//android.widget.TextView[contains(@text, '" + text + "')]";
        //System.out.println("Xpath is: '"+xPathofText+"'");
        return xPathofText;
    }

    //Create WebElement by text
    public WebElement WebElementByText(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized) {
            text = isAllCaps(text);
        }
        String xPathofText = "//android.widget.TextView[@text='" + text + "']";
        if (AndroidVersion < 6) {
            xPathofText = "//android.widget.TextView[contains(@text, '" + text + "')]";
        }
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        WebElement tempElement = driver.findElement(By.xpath(xPathofText));
        return tempElement;
    }

    //Create WebElement by text view.View
    public WebElement WebElementByTextViewView(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized) {
            text = isAllCaps(text);
        }
        String xPathofText = "//android.view.View[@text='" + text + "']";
        if (AndroidVersion < 6) {
            xPathofText = "//android.view.View[contains(@text, '" + text + "')]";
        }
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        WebElement tempElement = driver.findElement(By.xpath(xPathofText));
        return tempElement;
    }

    //Create WebElement by CheckedTextView
    public WebElement WebElementByCheckedText(String text) throws Exception {
        String xPathofText = "//android.widget.CheckedTextView[@text='" + text + "']";
        if (AndroidVersion < 6) {
            xPathofText = "//android.widget.CheckedTextView[contains(@text, '" + text + "')]";
        }
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        WebElement tempElement = driver.findElement(By.xpath(xPathofText));
        return tempElement;
    }

    //Create WebElements by text (List)
    public List WebElementsByText(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized) {
            text = isAllCaps(text);
        }
        String xPathofText = "//android.widget.TextView[@text='" + text + "']";
        if (AndroidVersion < 6) {
            xPathofText = "//android.widget.TextView[contains(@text, '" + text + "')]";
        }
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        List tempElement = driver.findElements(By.xpath(xPathofText));
        if (tempElement.size() < 1) {
            swipeDown();
            tempElement = driver.findElements(By.xpath(xPathofText));
            if (tempElement.size() < 1) {
                System.out.println("\n" + text + " was not found on the screen. xpath was: " + xPathofText);
            }
        }
        return tempElement;
    }

    //Create WebElements by text in a webview (List) (doesn't swipe if no element is found on the screen)
    public List WebElementsByTextWebview(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized) {
            text = isAllCaps(text);
        }
        String xPathofText = "//android.widget.TextView[@text='" + text + "']";
        if (AndroidVersion < 6) {
            xPathofText = "//android.widget.TextView[contains(@text, '" + text + "')]";
        }
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        List tempElement = driver.findElements(By.xpath(xPathofText));
        if (tempElement.size() < 1) {
            System.out.println("\n" + text + " was not found on the screen. xpath was: " + xPathofText);
        }
        return tempElement;
    }

    //Create WebElements by text contains (List)
    public List WebElementsByTextContains(String text) throws Exception {
        String xPathofText = "//android.widget.TextView[contains(@text, '" + text + "')]";
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        List tempElement = driver.findElements(By.xpath(xPathofText));
        if (tempElement.size() < 1) {
            swipeDown();
            tempElement = driver.findElements(By.xpath(xPathofText));
            if (tempElement.size() < 1) {
                System.out.println("\n" + text + " was not found on the screen. xpath was: " + xPathofText);
            }
        }
        return tempElement;
    }

    //Create WebElements by Checked text (List)
    public List WebElementsByCheckedText(String CheckedText, Boolean isCapitalized) throws Exception {
        if (isCapitalized) {
            CheckedText = isAllCaps(CheckedText);
        }
        String xPathofText = "//android.widget.CheckedTextView[@text='" + CheckedText + "']";
        if (AndroidVersion < 6) {
            xPathofText = "//android.widget.CheckedTextView[contains(@text, '" + CheckedText + "')]";
        }
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        List tempElement = driver.findElements(By.xpath(xPathofText));
        if (tempElement.size() < 1) {
            swipeDown();
            tempElement = driver.findElements(By.xpath(xPathofText));
            if (tempElement.size() < 1) {
                System.out.println("\n" + CheckedText + " was not found on the screen. xpath was: " + xPathofText);
            }
        }
        return tempElement;
    }

    //Create WebElements by id
    public List WebElementsById(String id) throws Exception {
        List tempElement = driver.findElementsById(id);
        if (tempElement.size() < 1) {
            swipeDown();
            tempElement = driver.findElementsById(id);
            if (tempElement.size() < 1) {
                System.out.println("\n" + id + " was not found on the screen.");
            }
        }
        return tempElement;
    }

    //Create WebElements by id
    public List WebElementsByIdExpectFalse(String id) throws Exception {
        List tempElement = driver.findElementsById(id);
        if (tempElement.size() < 1) {
            System.out.println("\n" + id + " was not found on the screen.");
        }
        return tempElement;
    }

    //Create WebElements by resource-id
    public List WebElementsByResourceId(String id) throws Exception {
        List tempElement = WebElementsByXpath("//*[@resource-id=\"" + id + "\"]");
        if (tempElement.size() < 1) {
            swipeDown();
            tempElement = WebElementsByXpath("//*[@resource-id=\"" + id + "\"]");
            if (tempElement.size() < 1) {
                System.out.println("\n" + id + " was not found on the screen.");
            }
        }
        return tempElement;
    }

    //Create WebElements by accessibility id
    public List WebElementsByAccessibilityId(String id) throws Exception {
        List tempElement = driver.findElementsByAccessibilityId(id);
        if (tempElement.size() < 1) {
            swipeDown();
            tempElement = driver.findElementsByAccessibilityId(id);
            if (tempElement.size() < 1) {
                System.out.println("\n" + id + " was not found on the screen.");
            }
        }
        return tempElement;
    }

    //Create WebElements by xpath (list)
    public List WebElementsByXpath(String xpath) throws Exception {
        String xPathofText = xpath;
        System.out.println("Xpath of current item is: " + xPathofText + "");
        List tempElement = driver.findElements(By.xpath(xPathofText));
        if (tempElement.size() < 1) {
            swipeDown();
            tempElement = driver.findElements(By.xpath(xPathofText));
            if (tempElement.size() < 1) {
                System.out.println("\n" + xpath + " was not found on the screen. xpath was: " + xPathofText);
            }
        }
        return tempElement;
    }

    //Create WebElements by xpath in webview (list)
    public List WebElementsByXpathWebview(String xpath) throws Exception {
        String xPathofText = xpath;
        System.out.println("Xpath of current item is: " + xPathofText + "");
        List tempElement = driver.findElements(By.xpath(xPathofText));
        if (tempElement.size() < 1) {
            System.out.println("\n" + xpath + " was not found on the screen. xpath was: " + xPathofText);
        }
        return tempElement;
    }

    //Create WebElement by id
    public WebElement WebElementById(String id) throws Exception {
        WebElement tempElement = driver.findElementById(id);
        return tempElement;
    }

    //Create WebElement by resource-id
    public WebElement WebElementByResourceId(String id) throws Exception {
        WebElement tempElement = WebElementByXpath("//*[@resource-id='" + id + "']");
        return tempElement;
    }

    //Create WebElement by AccessibilityId
    public WebElement WebElementByAccessibilityId(String accessibilityid) throws Exception {
        WebElement tempElement = driver.findElementByAccessibilityId(accessibilityid);
        return tempElement;
    }

    //Create WebElement for settings Switch by text
    public WebElement WebElementSettingSwitchByText(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized) {
            text = isAllCaps(text);
        }
        WebElement tempElement = driver.findElementByXPath("//android.widget.TextView[@text='" + text + "']/../../android.widget.LinearLayout/android.widget.Switch");
        return tempElement;
    }

    //Click Element in Webview
    public void ClickUIElementInWebviewByXPath(String xPath) throws Exception {
        driver.context("WEBVIEW_org.lds.ldssa." + GospelLibraryBuild + "");
        Set<String> windowHandles = driver.getWindowHandles();
        windowHandles.size();
        for (String window : windowHandles) {
            driver.switchTo().window(window);
            System.out.println("Window handle is now: " + window);
        }

        ClickUIElementByXpath(xPath);
        driver.context("NATIVE_APP");
    }

    //Click Element by Text
    public void ClickUIElementByText(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized) {
            text = isAllCaps(text);
        }
        String xPathofText = "//android.widget.TextView[@text='" + text + "']";
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        WebElement itemToClick = driver.findElement(By.xpath(xPathofText));
        itemToClick.click();
        System.out.println("Clicking: '" + text + "' using text by xPath with TextView");
        Thread.sleep(milliseconds_1);
    }

    //Click Element by Text
    public void ClickUIElementByTextContains(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized) {
            text = isAllCaps(text);
        }
        String xPathofText = "//android.widget.TextView[contains(@text, '" + text + "')]";
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        WebElement itemToClick = driver.findElement(By.xpath(xPathofText));
        itemToClick.click();
        System.out.println("Clicking: '" + text + "' using text by xPath with TextView");
        Thread.sleep(milliseconds_1);
    }

    //Click Element by Text view.View
    public void ClickUIElementByTextViewView(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized) {
            text = isAllCaps(text);
        }
        String xPathofText = "//android.view.View[@text='" + text + "']";
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        WebElement itemToClick = driver.findElement(By.xpath(xPathofText));
        itemToClick.click();
        System.out.println("Clicking: '" + text + "' using text by xPath with view.View");
        Thread.sleep(milliseconds_1);
    }

    //Click Element by Checked Text
    public void ClickUIElementByCheckedText(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized) {
            text = isAllCaps(text);
        }
        String xPathofText = "//android.widget.CheckedTextView[@text='" + text + "']";
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        WebElement itemToClick = driver.findElement(By.xpath(xPathofText));
        itemToClick.click();
        System.out.println("Clicking: '" + text + "' using text by xPath with CheckedTextView");
        Thread.sleep(milliseconds_1);
    }

    //Create WebElement by xPath
    public WebElement WebElementByXpath(String text) throws Exception {
        WebElement tempElement = driver.findElementByXPath(text);
        return tempElement;
    }

    //Click Element by 2 text items
    public void ClickUIElementBy2TextStings(String book, String number) throws Exception {
        String xPathofText = "//android.widget.TextView[contains(@text, '" + book + "')][contains(@text, '" + number + "')]";
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        WebElement itemToClick = driver.findElement(By.xpath(xPathofText));
        itemToClick.click();
        System.out.println("Clicking: '" + book + " " + number + "' using 2 text contains by xPath");
        Thread.sleep(milliseconds_1);
    }

    //Click Element by Accessibility ID
    public void ClickUIElementByAccessibilityID(String elementAccessibilityID) throws Exception {
        WebElement itemToClick = driver.findElementByAccessibilityId(elementAccessibilityID);
        itemToClick.click();
        System.out.println("Clicking: '" + elementAccessibilityID + "' by Accessibility ID");
        Thread.sleep(milliseconds_1);
    }

    //Click Element by ID
    public void ClickUIElementByID(String elementID) throws Exception {
        WebElement itemToClick = driver.findElementById(elementID);
        itemToClick.click();
        System.out.println("Clicking: '" + elementID + "' by ID");
        Thread.sleep(milliseconds_1);
    }

    //Click Element by ResourceID
    public void ClickUIElementByResourceID(String elementID) throws Exception {
        WebElement itemToClick = WebElementByResourceId(elementID);
        itemToClick.click();
        System.out.println("Clicking: '" + elementID + "' by ResourceID");
        Thread.sleep(milliseconds_1);
    }

    //Click Element by Xpath
    public void ClickUIElementByXpath(String xpath) throws Exception {
        WebElement itemToClick = driver.findElementByXPath(xpath);
        itemToClick.click();
        System.out.println("Clicking: '" + xpath + "' by xPath");
        Thread.sleep(milliseconds_1);
    }

    //Tap in the center of the screen
    public void TapCenterScreen() throws Exception {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        TouchAction action = new TouchAction(driver);
        action.tap(screenWidth / 2, screenHeight / 2).perform();
        System.out.println("Tapping center of screen");
    }

    public void Tap(int tapX, int tapY) throws Exception {
        TouchAction action = new TouchAction(driver);
        action.tap(tapX, tapY).perform();
        System.out.println("Tapping center of screen");
    }


    public void TapAndDrag(WebElement startPoint, WebElement endPoint) throws Exception {
        int tapX = startPoint.getLocation().getX();
        int tapY = startPoint.getLocation().getY();
        int tapElementWidth = startPoint.getSize().getWidth();
        int tapElementHeight = startPoint.getSize().getHeight();
        int startX = tapX + (tapElementWidth / 2);
        int startY = tapY + (tapElementHeight / 2);

        tapX = endPoint.getLocation().getX();
        tapY = endPoint.getLocation().getY();
        tapElementWidth = endPoint.getSize().getWidth();
        tapElementHeight = endPoint.getSize().getHeight();
        int endX = tapX + (tapElementWidth / 2);
        int endY = tapY;

        TouchAction action = new TouchAction(driver);

        action
                .longPress(startX, startY)
                .moveTo(endX, endY)
                .release()
                .perform();

        driver.getPageSource();
    }

    //Enter Text to a field by ID
    //click field, clear field, enter text
    public void sendText(String elementID, String text) throws Exception {
        WebElement textfield = driver.findElementById(elementID);
        textfield.clear();
        textfield.sendKeys(text);
        System.out.println("Sending Text: '" + text + "'");
        Thread.sleep(milliseconds_1);
    }

    //Convert String into keyboard keys
    public void sendTextFromKeyboard(String elementID, String text, Boolean clickOnElement) throws Exception {
        if (clickOnElement) {
            ClickUIElementByID(elementID);
        }
        int i = 0;
        Character currentChar = text.charAt(i);
        while (i < text.length()) {
            currentChar = text.charAt(i);
            switch (currentChar) {
                case 'a':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_A);
                    break;
                case 'b':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_B);
                    break;
                case 'c':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_C);
                    break;
                case 'd':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_D);
                    break;
                case 'e':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_E);
                    break;
                case 'f':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_F);
                    break;
                case 'g':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_G);
                    break;
                case 'h':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_H);
                    break;
                case 'i':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_I);
                    break;
                case 'j':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_J);
                    break;
                case 'k':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_K);
                    break;
                case 'l':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_L);
                    break;
                case 'm':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_M);
                    break;
                case 'n':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_N);
                    break;
                case 'o':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_O);
                    break;
                case 'p':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_P);
                    break;
                case 'q':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_Q);
                    break;
                case 'r':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_R);
                    break;
                case 's':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_S);
                    break;
                case 't':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_T);
                    break;
                case 'u':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_U);
                    break;
                case 'v':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_V);
                    break;
                case 'w':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_W);
                    break;
                case 'x':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_X);
                    break;
                case 'y':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_Y);
                    break;
                case 'z':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_Z);
                    break;
                case 'A':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_A, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'B':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_B, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'C':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_C, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'D':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_D, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'E':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_E, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'F':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_F, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'G':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_G, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'H':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_H, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'I':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_I, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'J':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_J, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'K':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_K, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'L':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_L, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'M':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_M, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'N':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_N, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'O':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_O, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'P':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_P, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'Q':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_Q, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'R':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_R, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'S':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_S, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'T':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_T, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'U':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_U, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'V':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_V, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'W':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_W, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'X':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_X, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'Y':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_Y, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case 'Z':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_Z, AndroidKeyMetastate.META_SHIFT_LEFT_ON);
                    break;
                case ' ':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_SPACE);
                    break;
                case '.':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_PERIOD);
                    break;
                case ',':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_COMMA);
                    break;
                case '¶':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);
                    break;
                case '0':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_0);
                    break;
                case '1':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_1);
                    break;
                case '2':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_2);
                    break;
                case '3':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_3);
                    break;
                case '4':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_4);
                    break;
                case '5':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_5);
                    break;
                case '6':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_6);
                    break;
                case '7':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_7);
                    break;
                case '8':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_8);
                    break;
                case '9':
                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_9);
                    break;

            }

            i = i + 1;
        }
    }

    //Scroll down the page
    public void scrollDown() {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        driver.swipe(screenWidth / 2, screenHeight / 10 * 9, screenWidth / 2, screenHeight / 10 * 3, 2000);
        System.out.println("Scrolling Down...");

    }

    //Scroll down the page
    public void swipeDown() {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        driver.swipe(screenWidth / 2, screenHeight / 10 * 6, screenWidth / 2, screenHeight / 10 * 5, 2000);
        System.out.println("Scrolling Down...");

    }

    //Scroll up the page
    public void scrollUp() {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        driver.swipe(screenWidth / 2, screenHeight / 10 * 2, screenWidth / 2, screenHeight / 10 * 8, 2000);
        System.out.println("Scrolling Up...");

    }

    //Swipe right
    public void swipeRight() throws Exception {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        driver.swipe(screenWidth / 20 * 18, screenHeight / 2, screenWidth / 20 * 2, screenHeight / 2, 300);
        System.out.println("Swiping right...");
        Thread.sleep(milliseconds_1);
    }

    //Swipe left
    public void swipeLeft() throws Exception {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        driver.swipe(screenWidth / 20 * 3, screenHeight / 2, screenWidth / 20 * 19, screenHeight / 2, 300);
        System.out.println("Swiping left...");
        Thread.sleep(milliseconds_1);
    }

    //Dismiss Dialog
    public void dismissDialog(WebElement dialogBox) throws Exception {
        int dialogYLocation = (dialogBox.getLocation().getY());
        int dialogXLocation = (dialogBox.getLocation().getX());
        int dialogHeight = (dialogBox.getSize().height);
        int dialogWidth = (dialogBox.getSize().width);
        int screenWidth = driver.manage().window().getSize().getWidth();
        int screenHeight = driver.manage().window().getSize().getHeight();
        int yTapPoint = (screenHeight / 2);
        int xTapPoint = (screenWidth / 2);
        if (dialogYLocation + dialogHeight + 10 < screenHeight) {
            yTapPoint = ((screenHeight - (dialogYLocation + dialogHeight)) / 2 + (dialogYLocation + dialogHeight));
        } else if (dialogYLocation - 10 > 1) {
            yTapPoint = (dialogYLocation / 2);
        } else if (dialogXLocation - 10 > 1) {
            xTapPoint = (dialogXLocation / 2);
        } else if (dialogXLocation + dialogWidth + 10 < screenWidth) {
            xTapPoint = ((screenWidth - (dialogXLocation + dialogWidth)) / 2 + (dialogXLocation + dialogWidth));
        }
        System.out.println("Screen Height is: " + screenHeight);
        System.out.println("Y Tap Point is:   " + yTapPoint);
        System.out.println("Screen Width is: " + screenWidth);
        System.out.println("X Tap Point is:  " + xTapPoint);
        TouchAction action = new TouchAction(driver);
        action.tap(xTapPoint, yTapPoint).perform();
        Thread.sleep(1000);
    }


    //

    public void ClickSeekBarAt(WebElement webelement, int positionOf7) throws Exception {
        int upperY = webelement.getLocation().getY();
        int upperX = webelement.getLocation().getX();
        int seekbarWidth = webelement.getSize().getWidth();
        int seekbarHeight = webelement.getSize().getHeight();
        int TapTarget = (upperY + (seekbarHeight / 2));
        //Seekbar positions
        int setting1 = (upperX + (seekbarWidth / 20));
        int setting2 = (int) (upperX + (seekbarWidth / 7) * 1.16);
        int setting3 = (int) (upperX + (seekbarWidth / 7) * 2.33);
        int setting4 = (upperX + (seekbarWidth / 2));
        int setting5 = (int) (upperX + ((seekbarWidth / 7) * 4.66));
        int setting6 = (int) (upperX + ((seekbarWidth / 7) * 5.84));
        int setting7 = (upperX + ((seekbarWidth / 20) * 19));


        if (positionOf7 == 1) {
            //12px
            driver.tap(1, setting1, TapTarget, 1);
            Thread.sleep(milliseconds_1);
        } else if (positionOf7 == 2) {
            //18px
            driver.tap(1, setting2, TapTarget, 1);
            Thread.sleep(milliseconds_1);
        } else if (positionOf7 == 3) {
            //21px
            driver.tap(1, setting3, TapTarget, 1);
            Thread.sleep(milliseconds_1);
        } else if (positionOf7 == 4) {
            driver.tap(1, setting4, TapTarget, 1);
            Thread.sleep(milliseconds_1);
        } else if (positionOf7 == 5) {
            driver.tap(1, setting5, TapTarget, 1);
            Thread.sleep(milliseconds_1);
        } else if (positionOf7 == 6) {
            driver.tap(1, setting6, TapTarget, 1);
            Thread.sleep(milliseconds_1);
        } else if (positionOf7 == 7) {
            driver.tap(1, setting7, TapTarget, 1);
            Thread.sleep(milliseconds_1);
        } else {
            driver.tap(1, setting3, TapTarget, 1);
            Thread.sleep(milliseconds_1);
        }
    }

    public String addTimetoPlaybackTime(String time, int secondsToAdd, int minutesToAdd) {
        if (time.length() < 6) {
            time = "00:" + time;
        } else if (time.length() < 8) {
            time = "0" + time;
        }
        System.out.println(time);
        int seconds = parseInt(time.substring(6, 8));
        int minutes = parseInt(time.substring(3, 5));
        int hours = parseInt(time.substring(0, 2));
        System.out.println(seconds);
        System.out.println(minutes);
        System.out.println(hours);
        seconds = seconds + secondsToAdd;
        System.out.println(seconds);
        minutes = minutes + minutesToAdd;
        System.out.println(minutes);

        if (seconds >= 60) {
            seconds = (seconds - 60);
            minutes = (minutes + 1);
        }
        if (minutes >= 60) {
            minutes = (minutes - 60);
            hours = (hours + 1);
        }
        String nSeconds = "";
        String nMinutes = "";
        String nHours = String.valueOf(hours);
        if (seconds < 10) {
            nSeconds = "0" + String.valueOf(seconds);
        } else {
            nSeconds = String.valueOf(seconds);
        }
        if (minutes < 10) {
            nMinutes = "0" + String.valueOf(minutes);
        } else {
            nMinutes = String.valueOf(minutes);
        }

        String nTime = nHours + ":" + nMinutes + ":" + nSeconds;
        if (parseInt(String.valueOf(nTime.charAt(0))) == 0) {
            nTime = nTime.substring(2, 7);
        }
        return nTime;

    }


    //assert Audio Player
    public void assertAudioPlayerUI(String title, String subtitle, String startTime, String endTime, boolean isFirstItem, boolean isLastItem) throws Exception {
        assertElementExistsBy(WebElementsById(AppId("miniPlaybackControls")));
        assertElementExistsBy(WebElementsByXpath("//android.view.ViewGroup[@resource-id='org.lds.ldssa." + GospelLibraryBuild + ":id/mediaPlaybackToolbar']/android.widget.TextView[1]"));
        verifyText(title, WebElementByXpath("//android.view.ViewGroup[@resource-id='org.lds.ldssa." + GospelLibraryBuild + ":id/mediaPlaybackToolbar']/android.widget.TextView[1]"), false);
        assertElementExistsBy(WebElementsByXpath("//android.view.ViewGroup[@resource-id='org.lds.ldssa." + GospelLibraryBuild + ":id/mediaPlaybackToolbar']/android.widget.TextView[2]"));
        verifyText(subtitle, WebElementByXpath("//android.view.ViewGroup[@resource-id='org.lds.ldssa." + GospelLibraryBuild + ":id/mediaPlaybackToolbar']/android.widget.TextView[2]"), false);
        assertElementExistsBy(WebElementsByXpath("//android.view.ViewGroup[@resource-id='org.lds.ldssa." + GospelLibraryBuild + ":id/mediaPlaybackToolbar']/android.widget.ImageButton"));
        assertElementExistsBy(WebElementsByXpath("//android.view.ViewGroup[@resource-id='org.lds.ldssa." + GospelLibraryBuild + ":id/mediaPlaybackToolbar']/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ImageView[@content-desc=\"More options\"]"));
        assertElementExistsBy(WebElementsById(AppId("controlsLayout")));
        if (!isFirstItem) {
            assertElementExistsBy(WebElementsById(AppId("previousButton")));
        }
        assertElementExistsBy(WebElementsById(AppId("replayButton")));
        assertElementExistsBy(WebElementsById(AppId("playPauseButton")));
        assertElementExistsBy(WebElementsById(AppId("forwardButton")));
        if (!isLastItem) {
            assertElementExistsBy(WebElementsById(AppId("nextButton")));
        }
        assertElementExistsBy(WebElementsById(AppId("progressLayout")));
        assertElementExistsBy(WebElementsById(AppId("seekBar")));
        assertElementExistsBy(WebElementsById(AppId("currentPositionTextView")));
        verifyText(startTime, WebElementById(AppId("currentPositionTextView")), false);
        assertElementExistsBy(WebElementsById(AppId("durationTextView")));
        verifyText(endTime, WebElementById(AppId("durationTextView")), false);
        //Can't run these because back and forward 10 seconds doesn't work correctly when paused
//        ClickUIElementByID(AppId("forwardButton");
//        //add 10 to startTime
//        startTime = addTimetoPlaybackTime(startTime,10,0);
//        verifyText(startTime, WebElementById(AppId("currentPositionTextView"));
//        ClickUIElementByID(AppId("forwardButton");
//        ClickUIElementByID(AppId("forwardButton");
//        //add another 10 to startTime
//        startTime = addTimetoPlaybackTime(startTime,10,0);
//        verifyText(startTime,WebElementById(AppId("currentPositionTextView"));
//        ClickUIElementByID(AppId("replayButton");
//        //minus 10 from startTime
//        startTime = addTimetoPlaybackTime(startTime,-10,0);
//        verifyText(startTime,WebElementById(AppId("currentPositionTextView"));

    }

    //assert Tabs
    public void assertTabs(String screen) throws Exception {
        if (screen == "Notes") {
            assertElementExistsBy(WebElementsByText("All", true));
            assertElementExistsBy(WebElementsByText("Tags", true));
            assertElementExistsBy(WebElementsByText("Notebooks", true));
        } else if (screen == "Bookmarks") {
            assertElementExistsBy(WebElementsByText("Bookmarks", true));
            assertElementExistsBy(WebElementsByText("Screens", true));
            assertElementExistsBy(WebElementsByText("History", true));
        } else {
            fail(screen + " is not a valid option for assertTabs." +
                    "Available screens are:" +
                    "Notes" +
                    "Bookmarks");
        }
    }

    //assert more options menu
    public void assertMoreOptionsMenu(String screen, Boolean close) throws Exception {

        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        if (screen == "Library") {
            assertElementExistsBy(WebElementsByText("New Screen", false));
            assertElementExistsBy(WebElementsByText("Custom Collections", false));
            assertElementExistsBy(WebElementsByText("Language", false));
            assertElementExistsBy(WebElementsByText("Settings", false));
        } else if (screen == "Collection Menu") {
            assertElementExistsBy(WebElementsByText("New Screen", false));
            assertElementExistsBy(WebElementsByText("Download All", false));
            assertElementExistsBy(WebElementsByText("Remove All", false));
            assertElementExistsBy(WebElementsByText("Language", false));
            assertElementExistsBy(WebElementsByText("Settings", false));
        } else if (screen == "Book Menu") {
            assertElementExistsBy(WebElementsByText("New Screen", false));
            assertElementExistsBy(WebElementsByText("Download Audio", false));
            assertElementExistsBy(WebElementsByText("Language", false));
            assertElementExistsBy(WebElementsByText("Settings", false));
        } else if (screen == "Content Menu") {
            assertElementExistsBy(WebElementsByText("New Screen", false));
            assertElementExistsBy(WebElementsByText("Related Content", false));
            assertElementExistsBy(WebElementsByText("Share", false));
            assertElementExistsBy(WebElementsByText("Play Audio", false));
            assertElementExistsBy(WebElementsByText("Language", false));
            assertElementExistsBy(WebElementsByText("Settings", false));
        } else if (screen == "Note") {
            assertElementExistsBy(WebElementsByText("Add to Notebook", false));
            assertElementExistsBy(WebElementsByText("Delete Note", false));
            assertElementExistsBy(WebElementsByText("Show Annotation Info", false));
        } else if (screen == "Note No Highlight") {
            assertElementExistsBy(WebElementsByText("Delete Note", false));
            assertElementExistsBy(WebElementsByText("Show Annotation Info", false));
        } else if (screen == "Notes") {
            assertElementExistsBy(WebElementsByText("New Screen", false));
            assertElementExistsBy(WebElementsByText("Restore Journal", false));
            assertElementExistsBy(WebElementsByText("Language", false));
            assertElementExistsBy(WebElementsByText("Settings", false));
        } else if (screen == "Notebooks") {
            assertElementExistsBy(WebElementsByText("New Screen", false));
            assertElementExistsBy(WebElementsByText("Language", false));
            assertElementExistsBy(WebElementsByText("Settings", false));
        } else if (screen == "Screens") {
            assertElementExistsBy(WebElementsByText("Screen Settings", false));
            assertElementExistsBy(WebElementsByText("Close All Screens", false));
        } else if (screen == "History") {
            assertElementExistsBy(WebElementsByText("Clear History", false));
        } else if (screen == "DownloadsByItem") {
            assertElementExistsBy(WebElementsByText("Current Downloads", false));
        } else if (screen == "DownloadsBySize") {
            assertElementExistsBy(WebElementsByText("Current Downloads", false));
        } else {
            fail(screen + " is not a valid option for assertMoreOptionsMenu." +
                    "Available screens are:" +
                    "Library" +
                    "Collection Menu" +
                    "Book Menu" +
                    "Content Menu" +
                    "Note" +
                    "Note No Highlight" +
                    "Notes" +
                    "Notebooks" +
                    "Screens" +
                    "History" +
                    "DownloadsByItem" +
                    "DownloadsBySize");
        }
        if (close) {
            dismissDialog(WebElementByXpath("*//android.widget.FrameLayout"));
            assertElementNotPresentBy(WebElementsByTextWebview("New Screen", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Custom Collections", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Download All", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Remove All", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Download Audio", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Related Content", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Share", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Play Audio", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Restore Journal", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Language", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Settings", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Screen Settings", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Close All Screens", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Clear History", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Sort by Size", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Sort by Item", false));
            assertElementNotPresentBy(WebElementsByTextWebview("Current Downloads", false));
        }
    }

    //assert Note options menu
    public void assertNoteOptionsMenu() throws Exception {
        assertElementExistsBy(WebElementsByText("Edit Note", false));
        assertElementExistsBy(WebElementsByText("Share", false));
        assertElementExistsBy(WebElementsByText("Add to Notebook", false));
        assertElementExistsBy(WebElementsByText("Delete", false));
        assertElementExistsBy(WebElementsByText("Show Annotation Info", false));
    }

    //assert Annotation options menu on an annotation in the Notes section without a note
    public void assertAnnotationOptionsMenu() throws Exception {
        assertElementExistsBy(WebElementsByText("Create Note", false));
        assertElementExistsBy(WebElementsByText("Share", false));
        assertElementExistsBy(WebElementsByText("Add to Notebook", false));
        assertElementExistsBy(WebElementsByText("Delete", false));
        assertElementExistsBy(WebElementsByText("Show Annotation Info", false));
    }

    //assert Notebook Multiselect Mode
    public void assertNotebookMultiselectMode(String title) throws Exception {
        assertElementExistsBy(WebElementsById(AppId("action_mode_bar")));
        assertElementExistsBy(WebElementsByAccessibilityId("Done"));
        assertElementExistsBy(WebElementsById(AppId("action_bar_title")));
        assertElementExistsBy(WebElementsByAccessibilityId("Delete"));
        assertElementExistsBy(WebElementsById(AppId("notesFloatingActionButton")));
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id =\"org.lds.ldssa." + GospelLibraryBuild + ":id/listItemImageView\"])[1]"));
        verifyText(title, WebElementById(AppId("action_bar_title")), false);
    }

    //assert Sort Notebooks Menu and Click
    public void assertSortNotebooksMenuAndClick(String startedSortAs, String sortBy) throws Exception {
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/title\"])[1]"));
        verifyText("Sort by Most Recent", WebElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/title\"])[1]"), false);
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/title\"])[2]"));
        verifyText("Sort by Name", WebElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/title\"])[2]"), false);
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/title\"])[3]"));
        verifyText("Sort by Count", WebElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/title\"])[3]"), false);
        if (startedSortAs == "Recent") {
            assert Boolean.parseBoolean(WebElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/radio\"])[1]").getAttribute("checked"));
            assert !Boolean.parseBoolean(WebElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/radio\"])[2]").getAttribute("checked"));
            assert !Boolean.parseBoolean(WebElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/radio\"])[3]").getAttribute("checked"));
        } else if (startedSortAs == "Name") {
            assert !Boolean.parseBoolean(WebElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/radio\"])[1]").getAttribute("checked"));
            assert Boolean.parseBoolean(WebElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/radio\"])[2]").getAttribute("checked"));
            assert !Boolean.parseBoolean(WebElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/radio\"])[3]").getAttribute("checked"));
        } else if (startedSortAs == "Count") {
            assert !Boolean.parseBoolean(WebElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/radio\"])[1]").getAttribute("checked"));
            assert !Boolean.parseBoolean(WebElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/radio\"])[2]").getAttribute("checked"));
            assert Boolean.parseBoolean(WebElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/radio\"])[3]").getAttribute("checked"));
        } else {
            fail("This Function only accepts the strings \"Recent\" \"Name\" and \"Count\"");
        }
        if (sortBy == "Recent") {
            ClickUIElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/title\"])[1]");
        } else if (sortBy == "Name") {
            ClickUIElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/title\"])[2]");
        } else if (sortBy == "Count") {
            ClickUIElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/title\"])[3]");
        } else {
            fail("This Function only accepts the strings \"Recent\" \"Name\" and \"Count\"");
        }
    }


    //assert merge notebook popup
    public void assertMergeNotebookPopup(String NewNotebookName, Boolean Continue) throws Exception {
        assertElementExistsBy(WebElementsById(AppId("md_text_title")));
        verifyText("Merged Notebook Name", WebElementById(AppId("md_text_title")), false);
        assertElementExistsBy(WebElementsById(AppId("md_text_message")));
        verifyText("The selected notebooks will be merged. Please enter a name for the resulting notebook.", WebElementById(AppId("md_text_message")), false);
        assertElementExistsBy(WebElementsById(AppId("md_input_message")));
        assertElementExistsBy(WebElementsById(AppId("textinput_counter")));
        verifyText("0 / 256", WebElementById(AppId("textinput_counter")), false);
        assertElementExistsBy(WebElementsById(AppId("md_button_negative")));
        verifyText("Cancel", WebElementById(AppId("md_button_negative")), true);
        assertElementExistsBy(WebElementsById(AppId("md_button_positive")));
        verifyText("Merge", WebElementById(AppId("md_button_positive")), true);
        //assert !Boolean.parseBoolean((WebElementById(AppId("md_button_positive")).getAttribute("enabled"));
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/md_input_message", NewNotebookName);
        verifyText(NewNotebookName.length() + " / 256", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/textinput_counter"), false);
        driver.getPageSource();
        assert Boolean.parseBoolean((WebElementById(AppId("md_button_positive"))).getAttribute("enabled"));
        if (Continue) {
            ClickUIElementByID(AppId("md_button_positive"));
        } else {
            ClickUIElementByID(AppId("md_button_negative"));
        }
    }

    //assert downloads screen
    public void assertDownloadScreen(boolean empty) throws Exception {
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsById(AppId("mainToolbarTitleTextView")));
        verifyText("Downloaded Media", WebElementById(AppId("mainToolbarTitleTextView")), false);
        if (empty) {
            assertElementExistsBy(WebElementsById(AppId("emptyStateImageView")));
            assertElementExistsBy(WebElementsById(AppId("emptyStateTitleTextView")));
            verifyText("No Downloaded Media", WebElementById(AppId("emptyStateTitleTextView")), false);
            assertElementExistsBy(WebElementsById(AppId("emptyStateSubTitleTextView")));
            verifyText("Download audio or video for offline access.", WebElementById(AppId("emptyStateSubTitleTextView")), false);
        }
    }

    //assert Bookmark item options
    public void assertBookmarkItemOptions(String title, Boolean close) throws Exception {
        ClickUIElementByXpath("//android.widget.TextView[@text=\"" + title + "\"]/../../android.widget.ImageButton");
        assertElementExistsBy(WebElementsByText("Update", false));
        assertElementExistsBy(WebElementsByText("Rename", false));
        assertElementExistsBy(WebElementsByText("Delete", false));
        if (close) {
            dismissDialog(WebElementByXpath("*//android.widget.FrameLayout"));
        }
    }

    //assert bookmark screen
    public void assertBookmarkScreen(Boolean CheckEmptyState, Boolean isOnContent) throws Exception {
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertTabs("Bookmarks");
        if (isOnContent) {
            assertElementExistsBy(WebElementsById(AppId("locationsFab")));
        }
        if (CheckEmptyState) {
            assertElementExistsBy(WebElementsById(AppId("emptyStateImageView")));
            assertElementExistsBy(WebElementsById(AppId("emptyStateTitleTextView")));
            verifyText("No Bookmarks", WebElementById(AppId("emptyStateTitleTextView")), false);
            assertElementExistsBy(WebElementsById(AppId("emptyStateSubTitleTextView")));
            verifyText("Add a bookmark to quickly return to where you left off.", WebElementById(AppId("emptyStateSubTitleTextView")), false);
        }
    }

    //assert screen item options
    public void assertScreenItemOptions(String title, Boolean close) throws Exception {
        ClickUIElementByXpath("//android.widget.TextView[@text=\"" + title + "\"]/../../android.widget.ImageButton");
        assertElementExistsBy(WebElementsByText("Rename", false));
        assertElementExistsBy(WebElementsByText("Duplicate", false));
        assertElementExistsBy(WebElementsByText("Delete", false));
        if (close) {
            dismissDialog(WebElementByXpath("*//android.widget.FrameLayout"));
        }
    }

    //assert the Nav bar
    public void assertNavBar(String title1, String title2, String title3, String title4, String title5, String title6, Boolean close) throws Exception {

        //Click Main Toolbar
        ClickUIElementByID(AppId("mainToolbarTitleTextView"));
        Thread.sleep(milliseconds_1);
        assertElementExistsBy(WebElementsByText("Library", false));
        if (title1 != "") {
            assertElementExistsBy(WebElementsByText(title1, false));
            if (title2 != "") {
                assertElementExistsBy(WebElementsByText(title2, false));
                if (title3 != "") {
                    assertElementExistsBy(WebElementsByText(title3, false));
                    if (title4 != "") {
                        assertElementExistsBy(WebElementsByText(title4, false));
                        if (title5 != "") {
                            assertElementExistsBy(WebElementsByText(title5, false));
                            if (title6 != "") {
                                assertElementExistsBy(WebElementsByText(title6, false));
                            }
                        }
                    }
                }
            }
        }

        if (close) {
            //Dismiss the toolbar
            ClickUIElementByID(AppId("mainToolbarTitleTextView"));
            Thread.sleep(milliseconds_1);
        }
    }

    //Assert Download Audio Popup
    public void assertDownloadAudioPopup(String title, Boolean download) throws Exception {
        assertElementExistsBy(WebElementsById(AppId("md_icon_title")));
        assertElementExistsBy(WebElementsById(AppId("md_text_title")));
        verifyText("Download Audio", WebElementById(AppId("md_text_title")), false);
        assertElementExistsBy(WebElementsById(AppId("md_text_message")));
        verifyText(title, WebElementById(AppId("md_text_message")), false);
        assertElementExistsBy(WebElementsById(AppId("md_button_negative")));
        verifyText("Cancel", WebElementById(AppId("md_button_negative")), true);
        assertElementExistsBy(WebElementsById(AppId("md_button_positive")));
        verifyText("Download", WebElementById(AppId("md_button_positive")), true);
        if (download) {
            ClickUIElementByID(AppId("md_button_positive"));
        } else {
            ClickUIElementByID(AppId("md_button_negative"));
        }
    }

    //Create Notebook and Assert
    public void CreateNotebookandAssert(String title, boolean add) throws Exception {
        ClickUIElementByID(AppId("notesFloatingActionButton"));
        //ClickUIElementByID(AppId("notebookSectionFloatingActionButton");
        Thread.sleep(milliseconds_1);
        verifyText("Create Notebook", WebElementByText("Create Notebook", false), false);
        verifyText("0 / 256", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/textinput_counter"), false);
        verifyText("Cancel", WebElementById(AppId("md_button_negative")), true);
        verifyText("Add", WebElementById(AppId("md_button_positive")), true);
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/md_input_message", title);
        verifyText(title.length() + " / 256", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/textinput_counter"), false);
        if (add) {
            ClickUIElementByID(AppId("md_button_positive"));
            Thread.sleep(milliseconds_2);
            verifyText(title, WebElementByText(title, false), false);
        } else {
            ClickUIElementByID(AppId("md_button_negative"));
            Thread.sleep(milliseconds_2);
            assertElementNotPresentBy(WebElementsByText(title, false));
        }
    }

    //Create Notebook and Assert
    public void CreateNotebookFromAddToNotebookAndAssert(String title, boolean add) throws Exception {
        assertAddToNotebookScreen(true);
        ClickUIElementByID(AppId("notebookSelectionFloatingActionButton"));
        Thread.sleep(milliseconds_1);
        verifyText("Create Notebook", WebElementByText("Create Notebook", false), false);
        verifyText("0 / 256", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/textinput_counter"), false);
        verifyText("CANCEL", WebElementById(AppId("md_button_negative")), true);
        verifyText("ADD", WebElementById(AppId("md_button_positive")), true);
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/md_input_message", title);
        verifyText(title.length() + " / 256", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/textinput_counter"), false);
        if (add) {
            ClickUIElementByID(AppId("md_button_positive"));
            Thread.sleep(milliseconds_2);
            verifyText(title, WebElementByText(title, false), false);
            assertAddToNotebookScreen(false);
        } else {
            ClickUIElementByID(AppId("md_button_negative"));
            Thread.sleep(milliseconds_2);
            assertElementNotPresentBy(WebElementsByText(title, false));
            assertAddToNotebookScreen(true);
        }
    }

    //Create new note from notebook
    public void CreateNewNoteFromNotebook(String title, String body) throws Exception {
        assertElementExistsBy(WebElementsById(AppId("newFloatingActionButton")));
        ClickUIElementByID(AppId("newFloatingActionButton"));
        Thread.sleep(milliseconds_1);
        //Verify controls present
        assertNoteScreen(false, true);
        //Type Note Text
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/noteTitleEditText", title);
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText", body);

        ClickUIElementByAccessibilityID("Navigate up");
    }

    //assertDeleteNotePopup
    public void assertDeleteNotebooksPopup() throws Exception {
        assertElementExistsBy(WebElementsById(AppId("md_text_title")));
        verifyText("Delete Notebooks", WebElementById(AppId("md_text_title")), false);
        assertElementExistsBy(WebElementsById(AppId("md_text_message")));
        verifyText("Delete selected notebooks?", WebElementById(AppId("md_text_message")), false);
        assertElementExistsBy(WebElementsById(AppId("md_button_negative")));
        verifyText("Cancel", WebElementById(AppId("md_button_negative")), true);
        assertElementExistsBy(WebElementsById(AppId("md_button_positive")));
        verifyText("Delete", WebElementById(AppId("md_button_positive")), true);
    }

    //assertDeleteBookmarkPopup
    public void assertDeleteBookmarkPopupAndTap(String bookmarkTitle, Boolean delete) throws Exception {
        assertElementExistsBy(WebElementsById(AppId("md_text_title")));
        verifyText("Delete", WebElementById(AppId("md_text_title")), false);
        assertElementExistsBy(WebElementsById(AppId("md_text_message")));
        verifyText("Delete “" + bookmarkTitle + "”?", WebElementById(AppId("md_text_message")), false);
        assertElementExistsBy(WebElementsById(AppId("md_button_negative")));
        verifyText("Cancel", WebElementById(AppId("md_button_negative")), true);
        assertElementExistsBy(WebElementsById(AppId("md_button_positive")));
        verifyText("Delete", WebElementById(AppId("md_button_positive")), true);
        if (delete) {
            ClickUIElementByID(AppId("md_button_positive"));
        } else {
            ClickUIElementByID(AppId("md_button_negative"));
        }
    }

    //Add Bookmark Popup
    public void assertAddBookmarkPopup(String expectedStartTitle, String title, Boolean add) throws Exception {
        assertElementExistsBy(WebElementsById(AppId("md_text_title")));
        verifyText("Add Bookmark", WebElementById(AppId("md_text_title")), false);
        assertElementExistsBy(WebElementsById(AppId("md_input_message")));
        if (expectedStartTitle.length() > 0) {
            verifyText(expectedStartTitle, WebElementById(AppId("md_input_message")), false);
            assertElementExistsBy(WebElementsById(AppId("textinput_counter")));
        }
        verifyText(expectedStartTitle.length() + " / 256", WebElementById(AppId("textinput_counter")), false);
        assertElementExistsBy(WebElementsById(AppId("md_button_neutral")));
        verifyText("Default", WebElementById(AppId("md_button_neutral")), true);
        assertElementExistsBy(WebElementsById(AppId("md_button_negative")));
        verifyText("Cancel", WebElementById(AppId("md_button_negative")), true);
        assertElementExistsBy(WebElementsById(AppId("md_button_positive")));
        verifyText("Add", WebElementById(AppId("md_button_positive")), true);
        if (title == "Default") {
            ClickUIElementByID(AppId("md_button_neutral"));
        } else {
            sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/md_input_message", title);
            verifyText(title.length() + " / 256", WebElementById(AppId("textinput_counter")), false);
            if (add) {
                ClickUIElementByID(AppId("md_button_positive"));
            } else {
                ClickUIElementByID(AppId("md_button_negative"));
            }
        }
    }

    //Add Bookmark Popup
    public void assertRenameBookmarkPopup(String expectedStartTitle, String title, Boolean ClickOk) throws Exception {
        assertElementExistsBy(WebElementsById(AppId("md_text_title")));
        verifyText("Rename Bookmark", WebElementById(AppId("md_text_title")), false);
        assertElementExistsBy(WebElementsById(AppId("md_input_message")));
        if (expectedStartTitle.length() > 0) {
            verifyText(expectedStartTitle, WebElementById(AppId("md_input_message")), false);
            assertElementExistsBy(WebElementsById(AppId("textinput_counter")));
        }
        verifyText(expectedStartTitle.length() + " / 256", WebElementById(AppId("textinput_counter")), false);
        assertElementExistsBy(WebElementsById(AppId("md_button_neutral")));
        verifyText("Default", WebElementById(AppId("md_button_neutral")), true);
        assertElementExistsBy(WebElementsById(AppId("md_button_negative")));
        verifyText("Cancel", WebElementById(AppId("md_button_negative")), true);
        assertElementExistsBy(WebElementsById(AppId("md_button_positive")));
        verifyText("Ok", WebElementById(AppId("md_button_positive")), true);
        if (title == "Default") {
            ClickUIElementByID(AppId("md_button_neutral"));
        } else {
            sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/md_input_message", title);
            verifyText(title.length() + " / 256", WebElementById(AppId("textinput_counter")), false);
            if (ClickOk) {
                ClickUIElementByID(AppId("md_button_positive"));
            } else {
                ClickUIElementByID(AppId("md_button_negative"));
            }
        }
    }

    //Change Text Size
    public void ChangeTextSize(int sizeOneThroughSeven) throws Exception {
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Text Size");
        assertElementExistsBy(WebElementsByText("Text Size", false));
        ClickUIElementByText("Text Size", false);
        assertElementExistsBy(WebElementsById(AppId("md_text_title")));
        verifyText("Text Size", WebElementById(AppId("md_text_title")), false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/sampleTextView"));
        verifyText("… behold I say unto you, that by small and simple things are great things brought to pass; and small means in many instances doth confound the wise.", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/sampleTextView"), false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/textSizeSeekbar"));
        ClickSeekBarAt(WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/textSizeSeekbar"), sizeOneThroughSeven);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/md_button_negative"));
        verifyText("Cancel", WebElementById(AppId("md_button_negative")), true);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/md_button_positive"));
        verifyText("OK", WebElementById(AppId("md_button_positive")), false);
        ClickUIElementByID(AppId("md_button_positive"));
        ClickUIElementByAccessibilityID("Navigate up");
        Thread.sleep(milliseconds_2);
        driver.getPageSource();
    }

    //Change Theme
    public void ChangeTheme(String Theme) throws Exception {
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Theme");
        assertElementExistsBy(WebElementsByText("Theme", false));
        ClickUIElementByText("Theme", false);
        assertElementExistsBy(WebElementsById(AppId("alertTitle")));
        verifyText("Theme", WebElementById(AppId("alertTitle")), false);
        assertElementExistsBy(WebElementsByCheckedText(Theme, false));
        ClickUIElementByCheckedText(Theme, false);
        ClickUIElementByText("Theme", false);

        Boolean ThemeDefault = Boolean.parseBoolean(WebElementByCheckedText("Default").getAttribute("checked"));
        Boolean ThemeSepia = Boolean.parseBoolean(WebElementByCheckedText("Sepia").getAttribute("checked"));
        Boolean ThemeNight = Boolean.parseBoolean(WebElementByCheckedText("Night").getAttribute("checked"));
        Boolean ThemeDarkBlue = Boolean.parseBoolean(WebElementByCheckedText("Dark Blue").getAttribute("checked"));
        Boolean ThemeMagenta = Boolean.parseBoolean(WebElementByCheckedText("Magenta").getAttribute("checked"));
        switch (Theme.toLowerCase()) {
            case "default":
                assert ThemeDefault;
                assert !ThemeSepia;
                assert !ThemeNight;
                assert !ThemeDarkBlue;
                assert !ThemeMagenta;
                break;
            case "sepia":
                assert !ThemeDefault;
                assert ThemeSepia;
                assert !ThemeNight;
                assert !ThemeDarkBlue;
                assert !ThemeMagenta;
                break;
            case "night":
                assert !ThemeDefault;
                assert !ThemeSepia;
                assert ThemeNight;
                assert !ThemeDarkBlue;
                assert !ThemeMagenta;
                break;
            case "dark blue":
                assert !ThemeDefault;
                assert !ThemeSepia;
                assert !ThemeNight;
                assert ThemeDarkBlue;
                assert !ThemeMagenta;
                break;
            case "magenta":
                assert !ThemeDefault;
                assert !ThemeSepia;
                assert !ThemeNight;
                assert !ThemeDarkBlue;
                assert ThemeMagenta;
                break;
        }

        ClickUIElementByCheckedText(Theme, false);
        ClickUIElementByAccessibilityID("Navigate up");

    }


    //Scroll to
    public void scrollDownTo(String text) {
        Boolean isNotPresent = driver.findElements(By.xpath("//android.widget.TextView[contains(@text, '" + text + "')]")).size() <= 0;
        int i = 0;
        while ((isNotPresent)) {
            if (i == 15) {
                fail("The item was not found on the screen within " + i + " downward scrolls");
                break;
            }
            System.out.println("" + text + " isn't on the screen... Scrolling to find");
            System.out.println("Scroll " + i + " of 15");
            scrollDown();
            isNotPresent = driver.findElements(By.xpath("//android.widget.TextView[@text='" + text + "']")).size() <= 0;
            i = i + 1;
        }
    }

    //Scroll to
    public void scrollDownToWithMaxScroll(String text, int MaxScroll) {
        Boolean isNotPresent = driver.findElements(By.xpath("//android.widget.TextView[contains(@text, '" + text + "')]")).size() <= 0;
        int i = 0;
        while ((isNotPresent)) {
            if (i == MaxScroll) {
                fail("The item was not found on the screen within " + i + " downward scrolls");
                break;
            }
            System.out.println("" + text + " isn't on the screen... Scrolling to find");
            System.out.println("Scroll " + i + " of " + MaxScroll);
            scrollDown();
            isNotPresent = driver.findElements(By.xpath("//android.widget.TextView[@text='" + text + "']")).size() <= 0;
            i = i + 1;
        }
    }

    //Scroll to by Resource id
    public void scrollToByResourceId(String id) throws Exception {
        System.out.println("Scrolling to: " + id);
        WebElement idIsPresent = WebElementByResourceId(id);
        int screenHeight = driver.manage().window().getSize().getHeight();
        int upperY = idIsPresent.getLocation().getY();
        System.out.println("Screen Height is " + screenHeight + "");
        System.out.println("upper Y is " + upperY + "");
        while (upperY >= screenHeight / 2) {
            System.out.println("scrolling down y '" + upperY + "' is >= " + screenHeight / 2 + "");
            scrollDown();
            upperY = idIsPresent.getLocation().getY();
        }
        while (upperY <= screenHeight / 7) {
            System.out.println("scrolling up y '" + upperY + "' is <= " + screenHeight / 8 + "");
            scrollUp();
            upperY = idIsPresent.getLocation().getY();
        }

    }


    //Scroll to by id
    public void scrollToById(String id) throws Exception {
        System.out.println("Scrolling to: " + id);
        WebElement idIsPresent = WebElementById(id);
        int screenHeight = driver.manage().window().getSize().getHeight();
        int upperY = idIsPresent.getLocation().getY();
        System.out.println("Screen Height is " + screenHeight + "");
        System.out.println("upper Y is " + upperY + "");
        while (upperY >= screenHeight / 2) {
            System.out.println("scrolling down y '" + upperY + "' is >= " + screenHeight / 2 + "");
            scrollDown();
            upperY = idIsPresent.getLocation().getY();
        }
        while (upperY <= screenHeight / 7) {
            System.out.println("scrolling up y '" + upperY + "' is <= " + screenHeight / 8 + "");
            scrollUp();
            upperY = idIsPresent.getLocation().getY();
        }

    }

    //Scroll to by
    public void scrollToBy(WebElement TempElement) {
        System.out.println(TempElement);
        int screenHeight = driver.manage().window().getSize().getHeight();
        int upperY = TempElement.getLocation().getY();
        System.out.println("Screen Height is " + screenHeight + "");
        System.out.println("upper Y is " + upperY + "");
        while (upperY >= screenHeight / 2) {
            System.out.println("scrolling down y '" + upperY + "' is >= " + screenHeight / 2 + "");
            scrollDown();
            upperY = TempElement.getLocation().getY();
        }
        while (upperY <= screenHeight / 8) {
            System.out.println("scrolling up y '" + upperY + "' is <= " + screenHeight / 8 + "");
            scrollUp();
            upperY = TempElement.getLocation().getY();
        }

    }


    //Verify Text
    public void verifyText(String expectedText, WebElement webelementActual, boolean isCapitalized) throws Exception {
        if (isCapitalized) {
            expectedText = isAllCaps(expectedText);
        }
        String webelementActualAsText = webelementActual.getText();
        System.out.println("Validating text Expected: '" + expectedText + "' Actual: '" + webelementActualAsText + "'");
        if (AndroidVersion < 6) {
            System.out.println("Android version is less than Android 6. Verifying that element contains expected text instead of verifying exact string.");
            Assert.assertTrue(webelementActualAsText.contains(expectedText));
        } else {
            Assert.assertEquals(expectedText, webelementActualAsText);
        }


    }

    //Verify Object Exists Using WebElementsBy
    public void assertElementExistsBy(List webElementsBy) {
        Boolean tempElement = webElementsBy.size() > 0;
        System.out.println("assert element is present. Expected: true [] Actual: " + tempElement + " Element: " + webElementsBy.toString() + "");
        if (tempElement == false) {
            System.out.println("Found " + webElementsBy.size() + ". List of Elements Found: " + webElementsBy);
        }
        assert tempElement == true;
    }

    public void assertElementInWebviewExactCount(String xPath, int itemCount) throws Exception {
        driver.context("WEBVIEW_org.lds.ldssa." + GospelLibraryBuild + "");
        Set<java.lang.String> windowHandles = driver.getWindowHandles();
        windowHandles.size();
        Boolean tempElement = false;

        for (String window : windowHandles) {
            driver.switchTo().window(window);
            System.out.println("Window handle is now: " + window);
            try {
                System.out.println("Count of elements in current window handle: " + WebElementsByXpath(xPath).size());
                Boolean webElementCount = (WebElementsByXpath(xPath).size() == itemCount);
                if (webElementCount) {
                    tempElement = true;
                    System.out.println("assert element is present. Expected: true [] Actual: " + tempElement + " Element: " + xPath.toString() + "");
                    break;
                } else {
                    System.out.println("WebElement not found in this context");
                    System.out.println("assert element is present. Expected: true [] Actual: " + tempElement + " Element: " + xPath.toString() + "");
                }
            } catch (Exception e) {
                System.out.println("Exception Occured");
            }

        }
        assert tempElement;
        driver.context("NATIVE_APP");
    }

    public void assertElementInWebviewExistsBy(String xPath) throws Exception {
        driver.context("WEBVIEW_org.lds.ldssa." + GospelLibraryBuild + "");
        Set<java.lang.String> windowHandles = driver.getWindowHandles();
        windowHandles.size();
        Boolean tempElement = false;

        for (String window : windowHandles) {
            driver.switchTo().window(window);
            System.out.println("Window handle is now: " + window);
            try {
                System.out.println(WebElementsByXpath(xPath).size());
                Boolean webElementList = WebElementsByXpath(xPath).size() > 0;
                if (webElementList) {
                    tempElement = true;
                    System.out.println("assert element is present. Expected: true [] Actual: " + tempElement + " Element: " + xPath.toString() + "");
                } else {
                    System.out.println("WebElement not found in this context");
                    System.out.println("assert element is present. Expected: true [] Actual: " + tempElement + " Element: " + xPath.toString() + "");
                }
            } catch (Exception e) {
                System.out.println("Exception Occured");
                System.out.println("WebElement not found in this context");
                System.out.println("assert element is present. Expected: true [] Actual: " + tempElement + " Element: " + xPath.toString() + "");
            }

        }
        assert tempElement;
        log("Setting driver context back to NATIVE_APP");
        driver.context("NATIVE_APP");
    }

    public void assertElementInWebviewDoesNotExistBy(String xPath) throws Exception {
        driver.context("WEBVIEW_org.lds.ldssa." + GospelLibraryBuild + "");
        Set<java.lang.String> windowHandles = driver.getWindowHandles();
        windowHandles.size();
        for (String window : windowHandles) {
            driver.switchTo().window(window);
            System.out.println("Window handle is now: " + window);
        }

        Boolean tempElement = WebElementsByXpathWebview(xPath).size() == 0;
        System.out.println("assert element is not present. Expected: true [] Actual: " + tempElement + " Element: " + xPath.toString() + "");
        assert tempElement;
        driver.context("NATIVE_APP");
    }


//    //Verify Object Exists and scroll to it
//    public void assertAndScrollToElementExistsBy(List webElementsBy, WebElement webElementBy){
//        scrollToBy(webElementBy);
//        Boolean tempElement = webElementsBy.size() > 0;
//        System.out.println(""+webElementsBy.toString()+" "+tempElement+"");
//        assert tempElement == true;
//
//    }


    //Verify Object Does Not Exist Using WebElementsBy
    public void assertElementNotPresentBy(List webElementsBy) {
        Boolean tempElement = webElementsBy.size() > 0;
        System.out.println("assert element is not present. Expected: false [] Actual: " + tempElement + " " + webElementsBy.toString() + "");
        assert tempElement == false;
    }

    //Assert Settings Switch and toggle
    public void assertSettingsSwitchExpectedStateAndToggle(String SwitchTitle, Boolean ExpectedState) throws Exception {
        scrollDownTo(SwitchTitle);
        assertElementExistsBy(WebElementsByText(SwitchTitle, false));
        // Toggle on and off verification (doesn't check that the settings work, just checks that the toggle works
        // toggle verification is currently by xpath because no other identifier is available
        WebElement CurrentSettingsSwitch = WebElementSettingSwitchByText(SwitchTitle, false);
        Boolean CurrentSettingSwitchBool = Boolean.parseBoolean(CurrentSettingsSwitch.getAttribute("checked"));
        if (ExpectedState) {
            verifyText("ON", CurrentSettingsSwitch, false);
            assert CurrentSettingSwitchBool;
            CurrentSettingsSwitch.click();
            verifyText("OFF", CurrentSettingsSwitch, false);
            CurrentSettingSwitchBool = Boolean.parseBoolean(CurrentSettingsSwitch.getAttribute("checked"));
            assert !CurrentSettingSwitchBool;
        } else {
            verifyText("OFF", CurrentSettingsSwitch, false);
            assert CurrentSettingSwitchBool == false;
            CurrentSettingsSwitch.click();
            verifyText("ON", CurrentSettingsSwitch, false);
            CurrentSettingSwitchBool = Boolean.parseBoolean(CurrentSettingsSwitch.getAttribute("checked"));
            assert CurrentSettingSwitchBool == true;
        }
    }


    //Assert Settings Switch Persists
    public void assertSettingsSwitchExpectedStateAndTogglePersists(String SwitchTitle, Boolean ExpectedState) throws Exception {
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        if (ExpectedState) {
            assertSettingsSwitchExpectedStateAndToggle(SwitchTitle, true);
            ClickUIElementByAccessibilityID("Navigate up");
            assertElementExistsBy(WebElementsByAccessibilityId("More options"));
            ClickUIElementByAccessibilityID("More options");
            assertElementExistsBy(WebElementsByText("Settings", false));
            ClickUIElementByText("Settings", false);
            assertSettingsSwitchExpectedStateAndToggle(SwitchTitle, false);
        } else {
            assertSettingsSwitchExpectedStateAndToggle(SwitchTitle, false);
            ClickUIElementByAccessibilityID("Navigate up");
            assertElementExistsBy(WebElementsByAccessibilityId("More options"));
            ClickUIElementByAccessibilityID("More options");
            assertElementExistsBy(WebElementsByText("Settings", false));
            ClickUIElementByText("Settings", false);
            assertSettingsSwitchExpectedStateAndToggle(SwitchTitle, true);
        }
    }

    //Check Nav Book Title
    public void verifyNavBookTitle(ArrayList<Pair<String, Integer>> bookList) throws Exception {


        for (int i = 0; i < bookList.size(); i++) {
            Pair<String, Integer> currentBook = bookList.get(i);
            String bookTitle = currentBook.getKey();
            int numberOfChapters = currentBook.getValue();
            System.out.println("");
            System.out.println("************************************** Starting  Check for " + bookTitle + " **************************************");
            System.out.println("Book Title: " + bookTitle + "");
            System.out.println("Number of Chapters: " + numberOfChapters + "");
            String titlebarBookTitle = "";

            if (numberOfChapters == 1) {
                titlebarBookTitle = "" + bookTitle + " 1";
            } else {
                titlebarBookTitle = "" + bookTitle + "";
            }
            System.out.println("Title bar book title to look for: " + titlebarBookTitle + "");

            scrollDownTo(bookTitle);

            System.out.println("" + bookTitle + " is on the screen");
            ClickUIElementByText(bookTitle, false);
            verifyText(titlebarBookTitle, driver.findElementByXPath(FindElementByContainsText(bookTitle)), false);
            if (numberOfChapters > 1) {
                //Check Title bar when Chapter is displayed
                ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout");
                Thread.sleep(milliseconds_1);
                String titlebarBookTitle2 = "";
                if (bookTitle == "Psalms") {
                    titlebarBookTitle2 = "Psalm " + "1";
                    verifyText(titlebarBookTitle2, driver.findElementByXPath(FindElementByContainsText("Psalm")), false);
                } else {
                    titlebarBookTitle2 = "" + bookTitle + " 1";
                    verifyText(titlebarBookTitle2, driver.findElementByXPath(FindElementByContainsText(titlebarBookTitle2)), false);
                }

                ClickUIElementByID("Navigate up");
                Thread.sleep(milliseconds_1);

                //Verify all of the chapters are present
                for (int j = 1; j <= numberOfChapters; j++) {
                    String chapterNumberString = String.valueOf(j);
                    scrollDownTo(chapterNumberString);

                    WebElement chapterNumber = driver.findElement(By.xpath(FindElementByText(chapterNumberString, false)));
                    verifyText(chapterNumberString, chapterNumber, false);

                }


            }


            ClickUIElementByID("Navigate up");
            Thread.sleep(milliseconds_1);
            System.out.println("************************************** Completed Check for " + bookTitle + " **************************************");
            System.out.println("");
        }

    }

    public void OpenScripture(String work, String book, String chapter, String verse) throws Exception {
        assertElementExistsBy(WebElementsByText("Scriptures", false));
        ClickUIElementByText("Scriptures", false);
        Thread.sleep(milliseconds_1);


        ClickUIElementByText(work, false);
        Thread.sleep(milliseconds_1);
        if (book != "") {
            scrollDownTo(book);
            ClickUIElementByText(book, false);
            Thread.sleep(milliseconds_2);
            if (chapter != "") {
                scrollDownTo(chapter);
                ClickUIElementByText(chapter, false);
                Thread.sleep(milliseconds_1);
            }
            if (verse != "") {
                Thread.sleep(milliseconds_1);
                System.out.println("Scrolling to p" + verse);
                scrollToByResourceId("p" + verse);
            }
        }

    }

    public void OpenConference(String month, String year, String talkTitle) throws Exception {
        assertElementExistsBy(WebElementsByText("General Conference", false));
        ClickUIElementByText("General Conference", false);
        Thread.sleep(milliseconds_1);

        if (month != "") {
            scrollDownTo(month + " " + year);
            assertElementExistsBy(WebElementsByText(month + " " + year, false));
            ClickUIElementByText(month + " " + year, false);
            Thread.sleep(milliseconds_1);
            ClickUIElementByText(month + " " + year, false);
            if (talkTitle != "") {
                scrollDownTo(talkTitle);
                ClickUIElementByText(talkTitle, false);
            }
        }
    }

    public void signInPage(String LoginUserName, String LoginPassword, String button, Boolean validLogin) throws Exception {
        //Username field
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/ldsaccount_login_username_layout"));
        verifyText("Username", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/ldsaccount_login_username_layout"), false);
        assertElementExistsBy(WebElementsById(AppId("usernameEditText")));
        //Password field
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/ldsaccount_login_password_layout"));
        verifyText("Password", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/ldsaccount_login_password_layout"), false);
        assertElementExistsBy(WebElementsById(AppId("passwordEditText")));
        //Password visibility
        assertElementExistsBy(WebElementsByAccessibilityId("Show password"));
        //Sign in Button
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/ldsAccountSignInButton"));
        verifyText("Sign In", WebElementByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/ldsAccountSignInButton\"]/android.widget.TextView"), true);
        //Having Trouble Signing In
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/ldsAccountLoginForgotCredentialsButton"));
        verifyText("Having Trouble Signing In?", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/ldsAccountLoginForgotCredentialsButton"), true);
        //Create an Account
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/ldsAccountLoginCreateAccountButton"));
        verifyText("Create an Account", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/ldsAccountLoginCreateAccountButton"), true);


        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/usernameEditText", LoginUserName);
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/passwordEditText", LoginPassword);
        boolean passwordVisibility = Boolean.parseBoolean((WebElementByAccessibilityId("Show password").getAttribute("checked")));
        System.out.println(passwordVisibility);
        assert !passwordVisibility;
        verifyText(hidePassword(LoginPassword), WebElementById(AppId("passwordEditText")), false);
        ClickUIElementByAccessibilityID("Show password");
        Thread.sleep(milliseconds_1);
        passwordVisibility = Boolean.parseBoolean((WebElementByAccessibilityId("Show password").getAttribute("checked")));
        System.out.println(passwordVisibility);
        assert passwordVisibility;
        verifyText(LoginPassword, WebElementById(AppId("passwordEditText")), false);
        if (button == "Sign In") {
            if (validLogin) {
                ClickUIElementByID(AppId("ldsAccountSignInButton"));
            } else {
                sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/passwordEditText", "MabelWasHere");
                ClickUIElementByID(AppId("ldsAccountSignInButton"));
                //appium can't validate ! if Username not entered and SignIn clicked
                Thread.sleep(milliseconds_1);
                verifyText("Error", WebElementByText("Error", false), false);
                ClickUIElementByText("OK", false);
                sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/passwordEditText", LoginPassword);
                ClickUIElementByID(AppId("ldsAccountSignInButton"));
            }
        } else if (button == "Having Trouble Signing In") {
            //Having Trouble Signing in
            ClickUIElementByID(AppId("ldsAccountLoginForgotCredentialsButton"));
            Thread.sleep(milliseconds_5);
            verifyText("https://ldsaccount.lds.org/recovery", WebElementById("com.android.chrome:id/url_bar"), false);
        } else if (button.toLowerCase() == "create an account") {
            //Create an Account
            ClickUIElementByText("Create an Account", true);
            Thread.sleep(milliseconds_5);
            verifyText("https://ldsaccount.lds.org/register", WebElementById("com.android.chrome:id/url_bar"), false);
        } else {
            fail("\"" + button + "\" is not a valid button for the Sign In Page. Valid entries are \"Sign In\", \"Having Trouble Signing In\", and \"Create an Account\"");
        }


    }

    public void assertMenuBar(String title, String subTitle, Boolean CheckNavigateUp) throws Exception {
        //assert menu bar
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/mainToolbar"));
        if (CheckNavigateUp) {
            assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        }
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/mainToolbarTextLayout"));
        if (CheckNavigateUp) {
            assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/dropArrowImageView"));
        }
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/mainToolbarTitleTextView"));
        verifyText(title, WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/mainToolbarTitleTextView"), false);
        if (CheckNavigateUp) {
            assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/mainToolbarSubTitleTextView"));
        }
        if (CheckNavigateUp) {
            verifyText(subTitle, WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/mainToolbarSubTitleTextView"), false);
        }
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmarks"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
    }

    public void assertSideBar(String title, Boolean isAnnotation, String annotationType, String TagName) throws Exception {
        //assert sidebar
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/sideBarDrawerContainer"));
        //assert close icon
        assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/sideBarToolbarInclude\"]/android.widget.ImageButton"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/sideBarToolbarTitleTextView"));
        verifyText(title, WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/sideBarToolbarTitleTextView"), false);
        assertElementExistsBy(WebElementsByAccessibilityId("Related Content"));
        assertElementExistsBy(WebElementsByXpath("(//android.widget.ImageView[@content-desc=\"More options\"])[2]"));
        if (isAnnotation) {
            assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/annotationView"));
            assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/lastModifiedTextView"));
        }
        if (annotationType == "Tag") {
            assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/bubbleLayout"));
            assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/bubbleTextView"));
            verifyText(TagName, WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/bubbleTextView"), false);
            assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/tag_text"));
        } else if (annotationType == "") {
        } else {
            fail(annotationType + " is not supported. Supported annotations are \"Tag\"");
        }
    }


    public void AnnotationsSyncCheck(String buttonToPress) throws Exception {
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/md_text_title"));
        verifyText("Back Up", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/md_text_title"), false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/md_text_message"));
        verifyText("Signing in with a Church Account backs up all your personal data, keeping it safe and making it available on the web or any mobile device.", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/md_text_message"), false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/md_button_positive"));
        verifyText("Sign In", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/md_button_positive"), true);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/md_button_negative"));
        verifyText("No Thanks", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/md_button_negative"), true);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/md_button_neutral"));
        verifyText(CreateAccountString, WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/md_button_neutral"), true);
        if (buttonToPress == "Sign In") {
            ClickUIElementByResourceID("org.lds.ldssa." + GospelLibraryBuild + ":id/md_button_positive");
            signInPage(user, password, "Sign In", true);
        } else if (buttonToPress == "No Thanks") {
            ClickUIElementByResourceID("org.lds.ldssa." + GospelLibraryBuild + ":id/md_button_negative");
        } else if (buttonToPress == CreateAccountString) {
            ClickUIElementByResourceID("org.lds.ldssa." + GospelLibraryBuild + ":id/md_button_neutral");
            Thread.sleep(milliseconds_5);
            verifyText("https://ldsaccount.lds.org/register", WebElementById("com.android.chrome:id/url_bar"), false);
        } else {
            fail("\"" + buttonToPress + "\" is not a valid selection. valid buttons are \"Sign In\", \"No Thanks\", and \"Create an Account\"");
        }

    }

    public List TapParagraph(String id, int duration) throws Exception {

        WebElement element = WebElementByResourceId(id);
        int eHeight = element.getSize().getHeight();
        int eWidth = element.getSize().getWidth();
        int eUpperX = element.getLocation().x;
        int eUpperY = element.getLocation().y;
        driver.context("WEBVIEW_org.lds.ldssa." + GospelLibraryBuild + "");
        WebElement wElement = WebElementById(id);
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        String script = "var s = getComputedStyle(arguments[0],null).getPropertyValue(arguments[1]);" +
                "return s;";

        String scriptReturnLineHeight = executor.executeScript(script, wElement, "line-height").toString();
        scriptReturnLineHeight = scriptReturnLineHeight.substring(0, (scriptReturnLineHeight.length() - 2));
        double LineHeight = Double.parseDouble(scriptReturnLineHeight);
        int scriptReturnLineHeightAsInt = (int) LineHeight;
        System.out.println(scriptReturnLineHeightAsInt);
        String scriptReturnFontHeight = executor.executeScript(script, wElement, "font-size").toString();
        scriptReturnFontHeight = scriptReturnFontHeight.substring(0, (scriptReturnFontHeight.length() - 2));
        double FontHeight = Double.parseDouble(scriptReturnFontHeight);
        int scriptReturnFontHeightAsInt = (int) FontHeight;
        System.out.println(scriptReturnFontHeightAsInt);
        driver.context("NATIVE_APP");
        int tapX = eUpperX + (eWidth / 5);
        int tapY = eUpperY + scriptReturnFontHeightAsInt + scriptReturnLineHeightAsInt;
        driver.tap(1, tapX, tapY, duration);
        List TapXYList = new ArrayList();
        TapXYList.add(tapX);
        TapXYList.add(tapY);
        return TapXYList;
    }

    public List LocationOfTapParagraph(String id) throws Exception {
        WebElement element = WebElementByResourceId(id);
        int eHeight = element.getSize().getHeight();
        int eWidth = element.getSize().getWidth();
        int eUpperX = element.getLocation().x;
        int eUpperY = element.getLocation().y;
        driver.context("WEBVIEW_org.lds.ldssa." + GospelLibraryBuild + "");
        WebElement wElement = WebElementById(id);
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        String script = "var s = getComputedStyle(arguments[0],null).getPropertyValue(arguments[1]);" +
                "return s;";

        String scriptReturnLineHeight = executor.executeScript(script, wElement, "line-height").toString();
        scriptReturnLineHeight = scriptReturnLineHeight.substring(0, (scriptReturnLineHeight.length() - 2));
        double LineHeight = Double.parseDouble(scriptReturnLineHeight);
        int scriptReturnLineHeightAsInt = (int) LineHeight;
        System.out.println(scriptReturnLineHeightAsInt);
        String scriptReturnFontHeight = executor.executeScript(script, wElement, "font-size").toString();
        scriptReturnFontHeight = scriptReturnFontHeight.substring(0, (scriptReturnFontHeight.length() - 2));
        double FontHeight = Double.parseDouble(scriptReturnFontHeight);
        int scriptReturnFontHeightAsInt = (int) FontHeight;
        System.out.println(scriptReturnFontHeightAsInt);
        driver.context("NATIVE_APP");
        int tapX = eUpperX + (eWidth / 5);
        int tapY = eUpperY + scriptReturnFontHeightAsInt + scriptReturnLineHeightAsInt;
        List TapXYList = new ArrayList();
        TapXYList.add(tapX);
        TapXYList.add(tapY);
        return TapXYList;
    }

    public void assertChooseHighlightScreen() throws Exception {
        assertElementExistsBy(WebElementsById(AppId("md_text_title")));
        verifyText("Choose Highlight", WebElementById(AppId("md_text_title")), false);
        assertElementExistsBy(WebElementsById(AppId("md_button_negative")));
        verifyText("Cancel", WebElementById(AppId("md_button_negative")), true);
    }

    public void assertRemoveAnnotationPopup() throws Exception {
        assertElementExistsBy(WebElementsById(AppId("md_text_title")));
        verifyText("Remove Annotation", WebElementById(AppId("md_text_title")), false);
        assertElementExistsBy(WebElementsById(AppId("md_text_message")));
        verifyText("Any notes, tags, or links attached to this highlight will also be removed.", WebElementById(AppId("md_text_message")), false);
        assertElementExistsBy(WebElementsById(AppId("md_button_negative")));
        verifyText("Cancel", WebElementById(AppId("md_button_negative")), true);
        assertElementExistsBy(WebElementsById(AppId("md_button_positive")));
        verifyText("Delete", WebElementById(AppId("md_button_positive")), true);
    }

    //******************************** Empty State assertions ***********************************
    public void assertEmptyNoteText() throws Exception {
        verifyText("Note Title", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/noteTitleEditText"), false);
        String placeHolderText = WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText").getText();
        List defaultPlaceHolderText = new ArrayList();
        defaultPlaceHolderText.add("Note");
//        defaultPlaceHolderText.add("And it came to pass…");
//        defaultPlaceHolderText.add("And thus we see…");
//        defaultPlaceHolderText.add("And now, behold…");
        Boolean placeHolder;
        if (placeHolderText.contentEquals(defaultPlaceHolderText.get(0).toString()) || placeHolderText.contentEquals(defaultPlaceHolderText.get(1).toString()) || placeHolderText.contentEquals(defaultPlaceHolderText.get(2).toString())) {
            placeHolder = true;
            System.out.println("Placeholder text was one of the preset values");
        } else {
            placeHolder = false;
//            System.out.println("Placeholder text was not one of the three preset values");
            System.out.println("Placeholder text didn't match expected text");
        }
        assert placeHolder;
    }

    public void assertEmptyStateTagScreen() throws Exception {
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/emptyStateImageView"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/emptyStateTitleTextView"));
        verifyText("No Tags", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/emptyStateTitleTextView"), false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/emptyStateSubTitleTextView"));
        verifyText("Create a tag to group content from anywhere in the app.", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/emptyStateSubTitleTextView"), false);
    }

    public void assertEmptyStateAddToNotebookScreen() throws Exception {
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/emptyStateImageView"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/emptyStateTitleTextView"));
        verifyText("No Notebooks", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/emptyStateTitleTextView"), false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/emptyStateSubTitleTextView"));
        verifyText("Create as many notebooks as desired to organize all your notes.", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/emptyStateSubTitleTextView"), false);
    }

    //******************************** Annotation screen assertions ***********************************

    public void assertNoteScreen(Boolean hasHighlight, Boolean CheckEmptyState) throws Exception {
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsByAccessibilityId("Tag"));
        if (hasHighlight) {
            assertElementExistsBy(WebElementsByAccessibilityId("Link"));
            assertMoreOptionsMenu("Note", true);
        } else {
            assertMoreOptionsMenu("Note No Highlight", true);
        }
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/noteTitleEditText"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/boldImageView"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/italicImageView"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/unorderedListImageView"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/orderedListImageView"));
        if (CheckEmptyState) {
            assertEmptyNoteText();
        }
    }

    public void assertTagScreen(Boolean CheckEmptyState) throws Exception {
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsByText("Tag", false));
        assertElementExistsBy(WebElementsByAccessibilityId("Sort"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/tagNameEditText"));
        verifyText("Add tag", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/tagNameEditText"), false);
        if (CheckEmptyState) {
            assertEmptyStateTagScreen();
        }
    }

    public void assertAddToNotebookScreen(Boolean CheckEmptyState) throws Exception {
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsByText("Add to Notebook", false));
        assertElementExistsBy(WebElementsByAccessibilityId("Sort"));
        ClickUIElementByAccessibilityID("Sort");
        assertSortNotebooksMenuAndClick("Recent", "Recent");
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/textFilterLayout"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/filterEditText"));
        verifyText("Find by name", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/filterEditText"), false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/notebookSelectionFloatingActionButton"));
        if (CheckEmptyState) {
            assertEmptyStateAddToNotebookScreen();
        }

    }

    public void assertLinksScreen() throws Exception {
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsByText("Link", false));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/searchEditText"));
        verifyText("Search for keywords, verses, or titles.", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/searchEditText"), false);
    }

    public void assertShareScreen() throws Exception {
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/mainToolbarTitleTextView"));
        verifyText("Share", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/mainToolbarTitleTextView"), false);
    }

    public void assertSearchScreen() throws Exception {
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/backImageView"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/searchEditText"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/searchClearTextImageView"));
    }

    public void assertHighlightStyleScreen() throws Exception {
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/mainToolbar"));
        assertElementExistsBy(WebElementsByText("Highlight Style", false));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/textView2"));
        verifyText("Recent", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/textView2"), true);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/indicatorImageView"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/fillIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/underlineIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/clearIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/underlineView"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/highlightStyleImageView"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/redColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/orangeColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/yellowColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/greenColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/blueColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/darkBlueColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/purpleColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/pinkColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/brownColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/grayColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/recentSeparatorView"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/recent1ColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/recent2ColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/recent3ColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/recent4ColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/recent5ColorIndicator"));
    }

    public void assertHighlightStyleScreenStyleAndColor(String Style, String Color) throws Exception {
        if (Style == "solid") {
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/fillIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/indicatorImageView\"]"));
        } else if (Style == "underline") {
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/underlineIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/indicatorImageView\"]"));
        } else if (Style == "clear") {
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/clearIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/indicatorImageView\"]"));
            Color = "clear";
        } else {
            fail(Style + " is not a valid style. Valid styles are \"solid\" \"underline\" and \"clear\"");
        }

        if (Color == "red") {
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/redColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/checkmarkImageView\"]"));
        } else if (Color == "orange") {
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/orangeColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/checkmarkImageView\"]"));
        } else if (Color == "yellow") {
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/yellowColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/checkmarkImageView\"]"));
        } else if (Color == "green") {
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/greenColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/checkmarkImageView\"]"));
        } else if (Color == "blue") {
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/blueColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/checkmarkImageView\"]"));
        } else if (Color == "dark_blue") {
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/darkBlueColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/checkmarkImageView\"]"));
        } else if (Color == "purple") {
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/purpleColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/checkmarkImageView\"]"));
        } else if (Color == "pink") {
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/pinkColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/checkmarkImageView\"]"));
        } else if (Color == "brown") {
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/brownColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/checkmarkImageView\"]"));
        } else if (Color == "gray") {
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/grayColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/checkmarkImageView\"]"));
        } else if (Color == "clear") {
        } else {
            fail(Color + " is not a valid color. Valid colors are \"red\" \"orange\" \"yellow\" \"blue\" \"dark_blue\" \"purple\" \"pink\" \"brown\" \"gray\"");
        }
    }

    public String ChangeHighlightColorAndStyle(String Style, String Color) throws Exception {
        if (Style == "solid") {
            ClickUIElementByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/fillIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/fillIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/indicatorImageView\"]"));
            Style = "box";
        } else if (Style == "underline") {
            ClickUIElementByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/underlineIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/underlineIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/indicatorImageView\"]"));
            Style = "underline";
        } else if (Style == "clear") {
            ClickUIElementByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/clearIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/clearIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/indicatorImageView\"]"));
            Style = "box";
            Color = "clear";
        } else {
            fail(Style + " is not a valid style. Valid styles are \"solid\" \"underline\" and \"clear\"");
        }

        if (Color == "red") {
            ClickUIElementByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/redColorIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/redColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/checkmarkImageView\"]"));
        } else if (Color == "orange") {
            ClickUIElementByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/orangeColorIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/orangeColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/checkmarkImageView\"]"));
        } else if (Color == "yellow") {
            ClickUIElementByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/yellowColorIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/yellowColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/checkmarkImageView\"]"));
        } else if (Color == "green") {
            ClickUIElementByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/greenColorIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/greenColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/checkmarkImageView\"]"));
        } else if (Color == "blue") {
            ClickUIElementByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/blueColorIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/blueColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/checkmarkImageView\"]"));
        } else if (Color == "dark_blue") {
            ClickUIElementByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/darkBlueColorIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/darkBlueColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/checkmarkImageView\"]"));
        } else if (Color == "purple") {
            ClickUIElementByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/purpleColorIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/purpleColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/checkmarkImageView\"]"));
        } else if (Color == "pink") {
            ClickUIElementByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/pinkColorIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/pinkColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/checkmarkImageView\"]"));
        } else if (Color == "brown") {
            ClickUIElementByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/brownColorIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/brownColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/checkmarkImageView\"]"));
        } else if (Color == "gray") {
            ClickUIElementByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/grayColorIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/grayColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/checkmarkImageView\"]"));
        } else if (Color == "clear") {
            System.out.println("Style was \"clear\" skipping color");
        } else {
            fail(Color + " is not a valid color. Valid colors are \"red\" \"orange\" \"yellow\" \"blue\" \"dark_blue\" \"purple\" \"pink\" \"brown\" \"gray\"");
        }
        String StyleAndColorClass = "hl-" + Color + "-" + Style;
        return StyleAndColorClass;
    }

    public void TestCheckAnnotationStyleAndColor(String Style, String Color) throws Exception {
        OpenScripture("Book of Mormon", "Jacob", "5", "");
        OpenAnnotationMenu("p1", "Mark");
        AnnotationsSyncCheck("No Thanks");
        log("asserting hl-yellow-box is in webview");
        assertElementInWebviewExistsBy("//div[contains(@class, 'hl-yellow-box')]");
        log("getting templist");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        log("clicking element by xPath to close annotation menu");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size()) + "]");
        log("getting temp list");
        templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        log("opening annotation menu by clicking annotation");
        OpenAnnotationMenuFromAnnotation(WebElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size()) + "]"), "Style");
        assertHighlightStyleScreen();
        assertHighlightStyleScreenStyleAndColor("solid", "yellow");
        String highlightClass = ChangeHighlightColorAndStyle(Style, Color);
        ClickUIElementByAccessibilityID("Navigate up");
        assertElementInWebviewExistsBy("//div[contains(@class, '" + highlightClass + "')]");
        templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size()) + "]");
        templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        OpenAnnotationMenuFromAnnotation(WebElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size()) + "]"), "Style");
        assertHighlightStyleScreenStyleAndColor(Style, Color);
    }


    //************************ Open Annotation Menu *********************************

    public void OpenAnnotationMenuFromAnnotation(WebElement element, String annotationType) throws Exception {
        driver.getPageSource();
        Thread.sleep(milliseconds_2);
        int windowHeight = driver.manage().window().getSize().height;
        log("the Window Height: " + windowHeight);
        int windowWidth = driver.manage().window().getSize().width;
        log("the Windot Width: "+ windowWidth);
        int elementWidth = element.getSize().width;
        log("the element Width: " + elementWidth);
        int elementHeight = element.getSize().height;
        log("the element Height: " + elementHeight);
        int elementUpperX = element.getLocation().getX();
        log("the element UpperX: " + elementUpperX);
        int elementUpperY = element.getLocation().getY();
        log("the element upperY: " + elementUpperY);
        int elementTapPointX = elementUpperX + (elementWidth / 2);
        log("the element Tap Point X: " + elementTapPointX);
        int elementTapPointY = elementUpperY + (elementHeight / 2);
        log("the element Tap Point Y: " + elementTapPointY);
        int annotationMenuWidth = 1184;
        int annotationMenuHeight = 560;
        int buttonWidth = 224;
        int buttonHeight = 224;
        int margin = 32;
        int headerFooter = 40;
        int menuBottomY = elementTapPointY - 140;
        if ((windowHeight / elementTapPointY) > 2.8) {
            menuBottomY = elementTapPointY + 140 + annotationMenuHeight;
            System.out.println("elementTapPoint is above 28% of the screen");
        }
        int menuBottomX = ((windowWidth / 2) - (annotationMenuWidth / 2));
        log("menuBottomX: " + menuBottomX);
        int bottomRowY = (menuBottomY - headerFooter - (buttonHeight / 2));
        log("bottomRowY: "+ bottomRowY);
        int topRowY = (menuBottomY - headerFooter - buttonHeight - margin - (buttonHeight / 2));
        log("topRowY: " + topRowY);
        int markX = (menuBottomX + margin + (buttonWidth / 2));
        int noteX = (menuBottomX + margin + buttonWidth + (buttonWidth / 2));
        int tagX = (menuBottomX + margin + (buttonWidth * 2) + (buttonWidth / 2));
        int addToX = (menuBottomX + margin + (buttonWidth * 3) + (buttonWidth / 2));
        int linkX = (menuBottomX + margin + (buttonWidth * 4) + (buttonWidth / 2));
        int copyX = (menuBottomX + margin + (buttonWidth / 2));
        int shareX = (menuBottomX + margin + buttonWidth + (buttonWidth / 2));
        int searchX = (menuBottomX + margin + (buttonWidth * 2) + (buttonWidth / 2));
        int defineX = (menuBottomX + margin + (buttonWidth * 3) + (buttonWidth / 2));
        int removeX = (menuBottomX + margin + (buttonWidth * 4) + (buttonWidth / 2));

        element.click();
        Thread.sleep(milliseconds_1);
        System.out.println("Width: " + elementWidth);
        System.out.println("Height: " + elementHeight);
        System.out.println("UpperX: " + elementUpperX);
        System.out.println("UpperY: " + elementUpperY);
        System.out.println("elementTapX: " + elementTapPointX);
        System.out.println("elementTapY: " + elementTapPointY);

        if (annotationType == "Style") {
            System.out.println("Clicking " + annotationType);
            Tap(markX,topRowY);
            System.out.println("markX is: " + markX);
            assertHighlightStyleScreen();
        } else if (annotationType == "Note") {
            System.out.println("Clicking " + annotationType);
            Tap( noteX, topRowY);
            Thread.sleep(milliseconds_1);
            assertNoteScreen(true, false);
        } else if (annotationType == "Tag") {
            System.out.println("Clicking " + annotationType);
            Tap( tagX, topRowY);
            Thread.sleep(milliseconds_1);
            assertTagScreen(false);
        } else if (annotationType == "Add to") {
            System.out.println("Clicking " + annotationType);
            Tap( addToX, topRowY);
            Thread.sleep(milliseconds_1);
            assertAddToNotebookScreen(false);
        } else if (annotationType == "Link") {
            System.out.println("Clicking " + annotationType);
            Tap( linkX, topRowY);
            Thread.sleep(milliseconds_1);
            assertLinksScreen();
        } else if (annotationType == "Copy") {
            System.out.println("Clicking " + annotationType);
            Tap( copyX, bottomRowY);
        } else if (annotationType == "Share") {
            System.out.println("Clicking " + annotationType);
            Tap( shareX, bottomRowY);
            Thread.sleep(milliseconds_1);
            assertShareScreen();
        } else if (annotationType == "Search") {
            System.out.println("Clicking " + annotationType);
            Tap( searchX, bottomRowY);
            Thread.sleep(milliseconds_1);
            assertSearchScreen();
        } else if (annotationType == "Define") {
            System.out.println("Clicking " + annotationType);
            Tap( defineX, bottomRowY);
        } else if (annotationType == "Remove") {
            System.out.println("Clicking " + annotationType);
            Tap( removeX, bottomRowY);
        } else {
            fail(annotationType + " is not a valid annotation menu item. Valid annotation items are: " +
                    "Style, " +
                    "Note, " +
                    "Tag, " +
                    "Add to, " +
                    "Link, " +
                    "Copy, " +
                    "Share, " +
                    "Search, " +
                    "Define, " +
                    "Remove");
        }


    }

    public void OpenAnnotationMenu(String id, String annotationType) throws Exception {
        driver.getPageSource();
        List TapXY = TapParagraph(id, 1000);
        WebElement element = WebElementByResourceId(id);
        Thread.sleep(milliseconds_2);
        int windowHeight = driver.manage().window().getSize().height;
        int windowWidth = driver.manage().window().getSize().width;
        int elementWidth = element.getSize().width;
        int elementHeight = element.getSize().height;
        int elementUpperX = element.getLocation().getX();
        int elementUpperY = element.getLocation().getY();
        int elementTapPointX = (int) TapXY.get(0);
        int elementTapPointY = (int) TapXY.get(1);
        int annotationMenuWidth = 1184;
        int annotationMenuHeight = 560;
        int buttonWidth = 224;
        int buttonHeight = 224;
        int margin = 32;
        int headerFooter = 40;
        int menuBottomY = elementTapPointY - 140;
        if ((windowHeight / elementTapPointY) > 2.8) {
            menuBottomY = elementTapPointY + 140 + annotationMenuHeight;
            System.out.println("elementTapPoint is above 28% of the screen");
        }
        int menuBottomX = ((windowWidth / 2) - (annotationMenuWidth / 2));
        int bottomRowY = (menuBottomY - headerFooter - (buttonHeight / 2));
        int topRowY = (menuBottomY - headerFooter - buttonHeight - margin - (buttonHeight / 2));
        int markX = (menuBottomX + margin + (buttonWidth / 2));
        int noteX = (menuBottomX + margin + buttonWidth + (buttonWidth / 2));
        int tagX = (menuBottomX + margin + (buttonWidth * 2) + (buttonWidth / 2));
        int addToX = (menuBottomX + margin + (buttonWidth * 3) + (buttonWidth / 2));
        int linkX = (menuBottomX + margin + (buttonWidth * 4) + (buttonWidth / 2));
        int copyX = (menuBottomX + margin + (buttonWidth / 2));
        int shareX = (menuBottomX + margin + buttonWidth + (buttonWidth / 2));
        int searchX = (menuBottomX + margin + (buttonWidth * 2) + (buttonWidth / 2));
        int defineX = (menuBottomX + margin + (buttonWidth * 3) + (buttonWidth / 2));
        int removeX = (menuBottomX + margin + (buttonWidth * 4) + (buttonWidth / 2));

        System.out.println("Width: " + elementWidth);
        System.out.println("Height: " + elementHeight);
        System.out.println("UpperX: " + elementUpperX);
        System.out.println("UpperY: " + elementUpperY);
        System.out.println("elementTapX: " + elementTapPointX);
        System.out.println("elementTapY: " + elementTapPointY);

        if (annotationType == "Mark") {
            System.out.println("Clicking " + annotationType);
            Tap( markX, topRowY);
            System.out.println("markX is: " + markX);
        } else if (annotationType == "Note") {
            System.out.println("Clicking " + annotationType);
            Tap( noteX, topRowY);
            Thread.sleep(milliseconds_1);
            assertNoteScreen(true, false);
        } else if (annotationType == "Tag") {
            System.out.println("Clicking " + annotationType);
            Tap( tagX, topRowY);
            Thread.sleep(milliseconds_1);
            assertTagScreen(false);
        } else if (annotationType == "Add to") {
            System.out.println("Clicking " + annotationType);
            Tap( addToX, topRowY);
            Thread.sleep(milliseconds_1);
            assertAddToNotebookScreen(false);
        } else if (annotationType == "Link") {
            System.out.println("Clicking " + annotationType);
            Tap( linkX, topRowY);
            Thread.sleep(milliseconds_1);
            assertLinksScreen();
        } else if (annotationType == "Copy") {
            System.out.println("Clicking " + annotationType);
            Tap( copyX, bottomRowY);
        } else if (annotationType == "Share") {
            System.out.println("Clicking " + annotationType);
            Tap( shareX, bottomRowY);
            Thread.sleep(milliseconds_1);
            assertShareScreen();
        } else if (annotationType == "Search") {
            System.out.println("Clicking " + annotationType);
            Tap( searchX, bottomRowY);
            Thread.sleep(milliseconds_1);
            assertSearchScreen();
        } else if (annotationType == "Define") {
            System.out.println("Clicking " + annotationType);
            Tap( defineX, bottomRowY);
        } else if (annotationType == "Remove") {
            System.out.println("Clicking " + annotationType);
            Tap( removeX, bottomRowY);
        } else {
            fail(annotationType + " is not a valid annotation menu item. Valid annotation items are: " +
                    "Mark, " +
                    "Note, " +
                    "Tag, " +
                    "Add to, " +
                    "Link, " +
                    "Copy, " +
                    "Share, " +
                    "Search, " +
                    "Define, " +
                    "Remove");
        }
    }

    public void TapAnnotationMenuItem(String id, String annotationType) throws Exception {
        driver.getPageSource();
        List TapXY = LocationOfTapParagraph(id);
        WebElement element = WebElementByResourceId(id);
        Thread.sleep(milliseconds_2);
        int windowHeight = driver.manage().window().getSize().height;
        int windowWidth = driver.manage().window().getSize().width;
        int elementWidth = element.getSize().width;
        int elementHeight = element.getSize().height;
        int elementUpperX = element.getLocation().getX();
        int elementUpperY = element.getLocation().getY();
        int elementTapPointX = (int) TapXY.get(0);
        int elementTapPointY = (int) TapXY.get(1);
        int annotationMenuWidth = 1184;
        int annotationMenuHeight = 560;
        int buttonWidth = 224;
        int buttonHeight = 224;
        int margin = 32;
        int headerFooter = 40;
        int menuBottomY = elementTapPointY - 140;
        if ((windowHeight / elementTapPointY) > 2.8) {
            menuBottomY = elementTapPointY + 140 + annotationMenuHeight;
            System.out.println("elementTapPoint is above 28% of the screen");
        }
        int menuBottomX = ((windowWidth / 2) - (annotationMenuWidth / 2));
        int bottomRowY = (menuBottomY - headerFooter - (buttonHeight / 2));
        int topRowY = (menuBottomY - headerFooter - buttonHeight - margin - (buttonHeight / 2));
        int markX = (menuBottomX + margin + (buttonWidth / 2));
        int noteX = (menuBottomX + margin + buttonWidth + (buttonWidth / 2));
        int tagX = (menuBottomX + margin + (buttonWidth * 2) + (buttonWidth / 2));
        int addToX = (menuBottomX + margin + (buttonWidth * 3) + (buttonWidth / 2));
        int linkX = (menuBottomX + margin + (buttonWidth * 4) + (buttonWidth / 2));
        int copyX = (menuBottomX + margin + (buttonWidth / 2));
        int shareX = (menuBottomX + margin + buttonWidth + (buttonWidth / 2));
        int searchX = (menuBottomX + margin + (buttonWidth * 2) + (buttonWidth / 2));
        int defineX = (menuBottomX + margin + (buttonWidth * 3) + (buttonWidth / 2));
        int removeX = (menuBottomX + margin + (buttonWidth * 4) + (buttonWidth / 2));

        System.out.println("Width: " + elementWidth);
        System.out.println("Height: " + elementHeight);
        System.out.println("UpperX: " + elementUpperX);
        System.out.println("UpperY: " + elementUpperY);
        System.out.println("elementTapX: " + elementTapPointX);
        System.out.println("elementTapY: " + elementTapPointY);

        if (annotationType == "Mark") {
            System.out.println("Clicking " + annotationType);
            Tap( markX, topRowY);
            System.out.println("markX is: " + markX);
        } else if (annotationType == "Note") {
            System.out.println("Clicking " + annotationType);
            Tap( noteX, topRowY);
            Thread.sleep(milliseconds_1);
            assertNoteScreen(true, false);
        } else if (annotationType == "Tag") {
            System.out.println("Clicking " + annotationType);
            Tap( tagX, topRowY);
            Thread.sleep(milliseconds_1);
            assertTagScreen(false);
        } else if (annotationType == "Add to") {
            System.out.println("Clicking " + annotationType);
            Tap( addToX, topRowY);
            Thread.sleep(milliseconds_1);
            assertAddToNotebookScreen(false);
        } else if (annotationType == "Link") {
            System.out.println("Clicking " + annotationType);
            Tap( linkX, topRowY);
            Thread.sleep(milliseconds_1);
            assertLinksScreen();
        } else if (annotationType == "Copy") {
            System.out.println("Clicking " + annotationType);
            Tap( copyX, bottomRowY);
        } else if (annotationType == "Share") {
            System.out.println("Clicking " + annotationType);
            Tap( shareX, bottomRowY);
            Thread.sleep(milliseconds_1);
            assertShareScreen();
        } else if (annotationType == "Search") {
            System.out.println("Clicking " + annotationType);
            Tap( searchX, bottomRowY);
            Thread.sleep(milliseconds_1);
            assertSearchScreen();
        } else if (annotationType == "Define") {
            System.out.println("Clicking " + annotationType);
            Tap( defineX, bottomRowY);
        } else if (annotationType == "Remove") {
            System.out.println("Clicking " + annotationType);
            Tap( removeX, bottomRowY);
        } else {
            fail(annotationType + " is not a valid annotation menu item. Valid annotation items are: " +
                    "Mark, " +
                    "Note, " +
                    "Tag, " +
                    "Add to, " +
                    "Link, " +
                    "Copy, " +
                    "Share, " +
                    "Search, " +
                    "Define, " +
                    "Remove");
        }
    }


    public String getLatestConferenceMonth() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String todaysDate = (dateFormat.format(date));
        int year = parseInt(todaysDate.substring(0, 4));
        int month = parseInt(todaysDate.substring(5, 7));
        String conferenceMonth = "";
        if (month <= 4) {
            conferenceMonth = "October";
        } else if (month > 4 && month < 11) {
            conferenceMonth = "April";
        } else if (month >= 11) {
            conferenceMonth = "October";
        }
        System.out.println(conferenceMonth);
        return conferenceMonth;
    }

    public String getLatestConferenceYear() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String todaysDate = (dateFormat.format(date));
        int year = parseInt(todaysDate.substring(0, 4));
        int month = parseInt(todaysDate.substring(5, 7));
        String conferenceMonth = "";
        if (month <= 4) {
            year = year - 1;
        }
        System.out.println(year);
        return String.valueOf(year);
    }


    public String getLatestConference() throws Exception {
        String latestConference = (getLatestConferenceMonth() + " " + getLatestConferenceYear());
        System.out.println(latestConference);
        return latestConference;
    }


    public void appCheck(String appTitle) throws Exception {
        scrollDownTo(appTitle);
        assertElementExistsBy(WebElementsByText(appTitle, false));
        ClickUIElementByText(appTitle, false);
        assertElementExistsBy(WebElementsByAccessibilityId("Search Google Play"));
        assertElementExistsBy(WebElementsByTextContains(appTitle));
        driver.navigate().back();
        Thread.sleep(milliseconds_1);
        assertElementExistsBy(WebElementsByText("Featured Apps", false));
    }

    public String getComputedCssUsingXpath(String xPath, String cssAttribute) throws Exception {
        driver.context("WEBVIEW_org.lds.ldssa." + GospelLibraryBuild + "");
        Set<java.lang.String> windowHandles = driver.getWindowHandles();
        windowHandles.size();
        System.out.println("Checking window handles");

        for (String window : windowHandles) {
            driver.switchTo().window(window);
            System.out.println("Window handle is now: " + window);
            if (WebElementsByXpathWebview(xPath).size() > 0) {
                break;
            }
        }
        WebElement we = WebElementByXpath(xPath);

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        String script = "var s = getComputedStyle(arguments[0],null).getPropertyValue(arguments[1]);" +
                "return s;";

        String scriptReturn = (executor.executeScript(script, we, cssAttribute)).toString();
        System.out.println(scriptReturn);
        driver.context("NATIVE_APP");
        return scriptReturn;

    }

    public void fillOutFeedbackFormAndAssert(String theName, String theEmail, String theCategory, Boolean checkAllCategories, String theDescription, Boolean attachImage, Boolean deletePhoto, Boolean submit) throws Exception {
        //Verify Exit Button
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        //Verify Page Title
        assertElementExistsBy(WebElementsById(AppId("mainToolbarTitleTextView")));
        verifyText("Send Feedback", WebElementById(AppId("mainToolbarTitleTextView")), false);
        //Verify Attach Image
        assertElementExistsBy(WebElementsByAccessibilityId("Attach Image"));
        WebElement test = WebElementByAccessibilityId("Attach Image");
        //Verify Submit
        assertElementExistsBy(WebElementsByAccessibilityId("Submit"));
        //Verify Name Field
        assertElementExistsBy(WebElementsById(AppId("feedbackNameTextInputEditText")));
        verifyText("Name (Optional)", WebElementById(AppId("feedbackNameTextInputEditText")), false);
        //Verify Email field
        assertElementExistsBy(WebElementsById(AppId("feedbackEmailTextInputEditText")));
        verifyText("Email", WebElementById(AppId("feedbackEmailTextInputEditText")), false);
        //Verify Category Spinner
        assertElementExistsBy(WebElementsById(AppId("feedbackCategorySpinner")));
        assertElementExistsBy(WebElementsById("android:id/text1"));
        verifyText("Category", WebElementById("android:id/text1"), false);
        //Verify Description Field
        assertElementExistsBy(WebElementsById(AppId("feedbackDescriptionEditText")));
        verifyText("Description", WebElementById(AppId("feedbackDescriptionEditText")), false);
        //Verify text field counter
        assertElementExistsBy(WebElementsById(AppId("textinput_counter")));
        verifyText("0 / 1000", WebElementById(AppId("textinput_counter")), false);

        //enter text into form
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/feedbackNameTextInputEditText", theName);
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/feedbackEmailTextInputEditText", theEmail);

        //verify category wheel options
        List category = new ArrayList();
        category.add("How do I…?");
        category.add("Compliment");
        category.add("Feature request");
        category.add("Functionality issue (Bug)");
        category.add("Content issue");
        category.add("Sign in or syncing issue");
        category.add("Other");

        if (checkAllCategories) {
            for (int x = 0; x < category.size(); x++) {
                ClickUIElementByID(AppId("feedbackCategorySpinner"));
                assertElementExistsBy(WebElementsByCheckedText((String) category.get(x), false));
                ClickUIElementByCheckedText((String) category.get(x), false);
                assertElementExistsBy(WebElementsById(AppId("feedbackCategorySpinner")));
                verifyText((String) category.get(x), WebElementById("android:id/text1"), false);
                Thread.sleep(milliseconds_1);
            }
        } else {
//            ((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.BACK);
            ClickUIElementByID(AppId("feedbackCategorySpinner"));
            for (int x = 0; x < category.size(); x++) {
                assertElementExistsBy(WebElementsByCheckedText((String) category.get(x), false));
            }
            if (theCategory == "How do I") {
                ClickUIElementByCheckedText((String) category.get(0), false);
                assertElementExistsBy(WebElementsById(AppId("feedbackCategorySpinner")));
                verifyText((String) category.get(0), WebElementById("android:id/text1"), false);
                Thread.sleep(milliseconds_1);
            } else if (theCategory == "Compliment") {
                ClickUIElementByCheckedText((String) category.get(1), false);
                assertElementExistsBy(WebElementsById(AppId("feedbackCategorySpinner")));
                verifyText((String) category.get(1), WebElementById("android:id/text1"), false);
                Thread.sleep(milliseconds_1);
            } else if (theCategory == "Feature request") {
                ClickUIElementByCheckedText((String) category.get(2), false);
                assertElementExistsBy(WebElementsById(AppId("feedbackCategorySpinner")));
                verifyText((String) category.get(2), WebElementById("android:id/text1"), false);
                Thread.sleep(milliseconds_1);
            } else if (theCategory == "Bug") {
                ClickUIElementByCheckedText((String) category.get(3), false);
                assertElementExistsBy(WebElementsById(AppId("feedbackCategorySpinner")));
                verifyText((String) category.get(3), WebElementById("android:id/text1"), false);
                Thread.sleep(milliseconds_1);
            } else if (theCategory == "Content") {
                ClickUIElementByCheckedText((String) category.get(4), false);
                assertElementExistsBy(WebElementsById(AppId("feedbackCategorySpinner")));
                verifyText((String) category.get(4), WebElementById("android:id/text1"), false);
                Thread.sleep(milliseconds_1);
            } else if (theCategory == "Sync") {
                ClickUIElementByCheckedText((String) category.get(5), false);
                assertElementExistsBy(WebElementsById(AppId("feedbackCategorySpinner")));
                verifyText((String) category.get(5), WebElementById("android:id/text1"), false);
                Thread.sleep(milliseconds_1);
            } else if (theCategory == "Other") {
                ClickUIElementByCheckedText((String) category.get(6), false);
                assertElementExistsBy(WebElementsById(AppId("feedbackCategorySpinner")));
                verifyText((String) category.get(6), WebElementById("android:id/text1"), false);
                Thread.sleep(milliseconds_1);
            } else if (theCategory == "") {
                ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
                assertElementExistsBy(WebElementsById(AppId("feedbackCategorySpinner")));
                System.out.println("Category was left blank");
            } else {
                fail(theCategory + " isn't a valid category. Valid categories are \"How do I\", \"Compliment\", \"Feature request\", \"Bug\", \"Content\", \"Sync\" and, \"Other\"");
            }
        }


        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();


        if (theDescription == "default") {
            String description = ("sendto:" + sendtoemail + " This is a test support email from automation sent on " + dateFormat.format(date) + " test: " + (new Exception().getStackTrace()[0].getMethodName()) + "");
            sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/feedbackDescriptionEditText", description);
            int screenHeight = driver.manage().window().getSize().getHeight();
            int screenWidth = driver.manage().window().getSize().getWidth();
            driver.swipe(screenWidth / 2, screenHeight / 2, screenWidth / 2, screenHeight / 10 * 2, 2000);
            verifyText("" + description.length() + " / 1000", WebElementById(AppId("textinput_counter")), false);
            Thread.sleep(milliseconds_1);
        } else if (theDescription == "") {
            System.out.println("Leaving Description Blank");
        } else {
            String description = ("sendto:" + sendtoemail + " " + theDescription);
            sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/feedbackDescriptionEditText", description);
            int screenHeight = driver.manage().window().getSize().getHeight();
            int screenWidth = driver.manage().window().getSize().getWidth();
            driver.swipe(screenWidth / 2, screenHeight / 2, screenWidth / 2, screenHeight / 10 * 2, 2000);
            verifyText("" + description.length() + " / 1000", WebElementById(AppId("textinput_counter")), false);
            Thread.sleep(milliseconds_1);
        }

        if (attachImage) {
            ClickUIElementByAccessibilityID("Attach Image");
            ClickUIElementByID("com.android.packageinstaller:id/permission_allow_button");
            ClickUIElementByText("Gallery", false);
//            ClickUIElementByAccessibilityID("More options");
//            if (WebElementsByTextWebview("List view", false).size() > 0){
//                ClickUIElementByText("List view", false);
//            } else {
//                TapCenterScreen();
//            }
//            String photoTitle = WebElementByXpath("//android.widget.ImageView/../android.widget.TextView").getText();
//            System.out.println(photoTitle);
            ClickUIElementByXpath("//android.widget.ImageView");
            assertElementExistsBy(WebElementsById(AppId("bubbleLayout")));
            assertElementExistsBy(WebElementsById(AppId("bubbleTextView")));
            assertElementExistsBy(WebElementsById(AppId("bubbleDeleteImageView")));
//            verifyText(photoTitle, WebElementById(AppId("bubbleTextView"),false);

            if (deletePhoto) {
                ClickUIElementByID(AppId("bubbleDeleteImageView"));
                assertElementNotPresentBy(WebElementsById(AppId("bubbleLayout")));
            }
            ;

        }


        if (submit) {
            ClickUIElementByAccessibilityID("Submit");

            if (theEmail == "") {
                Thread.sleep(milliseconds_1);
                System.out.println("Email was empty, checking that error message is present");
                verifyText("Please enter a valid email address", WebElementByXpath("(//*[@resource-id='org.lds.ldssa." + GospelLibraryBuild + ":id/textinput_error'])[1]"), false);
                sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/feedbackEmailTextInputEditText", email);
                if (theDescription != "" || theCategory != "") {
                    ClickUIElementByAccessibilityID("Submit");
                    Thread.sleep(milliseconds_3);
                }
            }

            if (theCategory == "") {
                ClickUIElementByID(AppId("feedbackCategorySpinner"));
                ClickUIElementByCheckedText((String) category.get(1), false);
                assertElementExistsBy(WebElementsById(AppId("feedbackCategorySpinner")));
                verifyText((String) category.get(1), WebElementById("android:id/text1"), false);
                Thread.sleep(milliseconds_1);
                if (theDescription != "") {
                    ClickUIElementByAccessibilityID("Submit");
                    Thread.sleep(milliseconds_3);
                }
            }


            if (theDescription == "") {
                Thread.sleep(milliseconds_1);
                System.out.println("Description was empty, checking that error message is present");
                //if theEmail is blank, then the description error will be the second in the list.
                if (theEmail == "") {
                    verifyText("Please enter a description", WebElementByXpath("(//*[@resource-id='org.lds.ldssa." + GospelLibraryBuild + ":id/textinput_error'])[2]"), false);
                } else {
                    verifyText("Please enter a description", WebElementByXpath("(//*[@resource-id='org.lds.ldssa." + GospelLibraryBuild + ":id/textinput_error'])[1]"), false);
                }
                String description = ("sendto:" + sendtoemail + " This is a test support email from automation sent on " + dateFormat.format(date) + " test: " + (new Exception().getStackTrace()[0].getMethodName()) + "");
                sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/feedbackDescriptionEditText", description);
                int screenHeight = driver.manage().window().getSize().getHeight();
                int screenWidth = driver.manage().window().getSize().getWidth();
                driver.swipe(screenWidth / 2, screenHeight / 2, screenWidth / 2, screenHeight / 10 * 2, 2000);
                verifyText("" + description.length() + " / 1000", WebElementById(AppId("textinput_counter")), false);
                Thread.sleep(milliseconds_1);
                ClickUIElementByAccessibilityID("Submit");
                Thread.sleep(milliseconds_3);
            }


        }
    }

    public void SplashScreenWait() throws Exception {
        System.out.println("Splash Screen Wait Start…");
        Thread.sleep((milliseconds_1 / 2));
        System.out.println("Waited for " + (milliseconds_1 / 2) + " milliseconds");
        Boolean isPresent = driver.findElementsByXPath("//android.widget.ProgressBar").size() > 0;
        while (isPresent) {
            System.out.println("On Splash Screen… Waiting " + milliseconds_1 / 2 + " milliseconds");
            Thread.sleep(milliseconds_1 / 2);
            isPresent = driver.findElementsByXPath("//android.widget.ProgressBar").size() > 0;
        }
        System.out.println("Continuing Test…");
    }

    //*************************************************************** Tests ***************************************************************

    @Test
    public void launchTest() throws Exception {
        SplashScreenWait();
        skipLogin();
        OpenScripture("Book of Mormon", "Enos", "", "");
        System.out.println(driver.getContextHandles());
    }

    //********** Tips Screen **********
    @Test
    public void skipTips() throws Exception {
        SplashScreenWait();
        System.out.println("Skipping Tips");
        driver.findElement(By.id("org.lds.ldssa." + GospelLibraryBuild + ":id/skip")).click();
        Thread.sleep(milliseconds_1);

    }


    @Test
    public void allTips() throws Exception {
        SplashScreenWait();
        List theList = WebElementsByXpath("//*[@resource-id='org.lds.ldssa." + GospelLibraryBuild + ":id/indicator_container']/android.widget.LinearLayout/android.widget.ImageView");
        int i = 1;
        while ((i < theList.size())) {
            System.out.println("Tips Screen is Present... Next Tip");
            //Expected
            String tipToolbarTitle = "What’s New";
            //Actual
            verifyText("What’s New", WebElementByXpath("//*[@resource-id='org.lds.ldssa." + GospelLibraryBuild + ":id/tipToolbar']/android.widget.TextView"), false);
            assertElementExistsBy(WebElementsById(AppId("next")));
            ClickUIElementByID(AppId("next"));
            Thread.sleep(milliseconds_1);
            i++;
        }

    }

    //********** Login Screen *********

    @Test
    public void skipLogin() throws Exception {

        skipTips();
        //click skip
        System.out.println("Skipping Login Screen");
        driver.findElementById("org.lds.ldssa." + GospelLibraryBuild + ":id/done").click();
        Thread.sleep(milliseconds_1);
    }

    @Test
    public void login() throws Exception {
        //This test checks valid login
        skipTips();
        assertElementExistsBy(WebElementsById(AppId("signInToolbar")));
        verifyText("Sign In", WebElementByText("Sign In", false), false);
        assertElementExistsBy(WebElementsById(AppId("signInMessageTextView")));
        verifyText("A Church Account is used to back up and synchronize your data between devices and the Church website.", WebElementById(AppId("signInMessageTextView")), false);
        assertElementExistsBy(WebElementsById(AppId("usernameEditText")));
        //appium can't validate ! if Username not entered and SignIn clicked
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/usernameEditText", user);
        assertElementExistsBy(WebElementsById(AppId("passwordEditText")));
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/passwordEditText", password);
        assertElementExistsBy(WebElementsByAccessibilityId("Show password"));
        boolean passwordVisibility = Boolean.parseBoolean((WebElementByAccessibilityId("Show password").getAttribute("checked")));
        System.out.println(passwordVisibility);
        assert !passwordVisibility;
        verifyText(hidePassword(password), WebElementById(AppId("passwordEditText")), false);
        ClickUIElementByAccessibilityID("Show password");
        Thread.sleep(milliseconds_1);
        passwordVisibility = Boolean.parseBoolean((WebElementByAccessibilityId("Show password").getAttribute("checked")));
        System.out.println(passwordVisibility);
        assert (passwordVisibility);
        verifyText(password, WebElementById(AppId("passwordEditText")), false);
        WebElement signInButton = driver.findElementById("org.lds.ldssa." + GospelLibraryBuild + ":id/ldsAccountSignInButton");
        signInButton.click();
        Thread.sleep(milliseconds_3);
        verifyText("Library", WebElementByText("Library", false), false);

    }

    @Test
    public void invalidLogin() throws Exception {
        skipTips();
        verifyText("Sign In", WebElementByText("Sign In", false), false);
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/usernameEditText", user);
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/passwordEditText", wrongPassword);
        WebElement signInButton = driver.findElementById("org.lds.ldssa." + GospelLibraryBuild + ":id/ldsAccountSignInButton");
        signInButton.click();
        Thread.sleep(milliseconds_3);
        verifyText("Error", WebElementByText("Error", false), false);
        assertElementExistsBy(WebElementsById("android:id/button1"));
        verifyText("OK", WebElementById("android:id/button1"), true);
        ClickUIElementByID("android:id/button1");
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/passwordEditText", password);
        signInButton.click();
        Thread.sleep(milliseconds_3);
        verifyText("Library", WebElementByText("Library", false), false);


    }

    @Test
    public void troubleSigningIn() throws Exception {
        skipTips();
        verifyText("Sign In", WebElementByText("Sign In", false), false);
        verifyText("HAVING TROUBLE SIGNING IN?", WebElementById(AppId("ldsAccountLoginForgotCredentialsButton")), false);
        ClickUIElementByID(AppId("ldsAccountLoginForgotCredentialsButton"));
        Thread.sleep(milliseconds_5);
        verifyText("https://settings.churchofjesuschrist.org/recovery", WebElementById("com.android.chrome:id/url_bar"), false);
    }

    @Test
    public void signInCreateAccount() throws Exception {
        skipTips();
        verifyText("Sign In", WebElementByText("Sign In", false), false);
        verifyText(CreateAccountString, WebElementById(AppId("ldsAccountLoginCreateAccountButton")), true);
        ClickUIElementByID(AppId("ldsAccountLoginCreateAccountButton"));
        Thread.sleep(milliseconds_5);
        verifyText("https://settings.churchofjesuschrist.org/register", WebElementById("com.android.chrome:id/url_bar"), false);
    }


    //*********** Library Screen ***********
    @Test
    public void LibraryContentScreen() throws Exception {
        //Skip Login
        skipLogin();
        assertElementExistsBy(WebElementsById(AppId("mainToolbarTitleTextView")));
        verifyText("Library", WebElementById(AppId("mainToolbarTitleTextView")), false);
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmarks"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        scrollDownTo("Scriptures");
        assertElementExistsBy(WebElementsByText("Scriptures", false));
        scrollDownTo("Come, Follow Me");
        assertElementExistsBy(WebElementsByText("Come, Follow Me", false));
        scrollDownTo("General Conference");
        assertElementExistsBy(WebElementsByText("General Conference", false));
        scrollDownTo("Notes");
        assertElementExistsBy(WebElementsByText("Notes", false));
        scrollDownTo("Study Plans");
        assertElementExistsBy(WebElementsByText("Study Plans", false));
        scrollDownTo("Music");
        assertElementExistsBy(WebElementsByText("Music", false));
        scrollDownTo("Magazines");
        assertElementExistsBy(WebElementsByText("Magazines", false));
        scrollDownTo("Seminaries and Institutes");
        assertElementExistsBy(WebElementsByText("Seminaries and Institutes", false));
        scrollDownTo("Teachings of Presidents");
        assertElementExistsBy(WebElementsByText("Teachings of Presidents", false));
        scrollDownTo("Videos");
        assertElementExistsBy(WebElementsByText("Videos", false));
        scrollDownTo("Topics");
        assertElementExistsBy(WebElementsByText("Topics", false));
        scrollDownTo("Jesus Christ");
        assertElementExistsBy(WebElementsByText("Jesus Christ", false));
        scrollDownTo("Missionary");
        assertElementExistsBy(WebElementsByText("Missionary", false));
        scrollDownTo("Individuals and Families");
        assertElementExistsBy(WebElementsByText("Individuals and Families", false));
        scrollDownTo("Young Adults");
        assertElementExistsBy(WebElementsByText("Young Adults", false));
        scrollDownTo("Youth");
        assertElementExistsBy(WebElementsByText("Youth", false));
        scrollDownTo("Children");
        assertElementExistsBy(WebElementsByText("Children", false));
        scrollDownTo("Leaders");
        assertElementExistsBy(WebElementsByText("Leaders", false));
        scrollDownTo("Church History");
        assertElementExistsBy(WebElementsByText("Church History", false));
        scrollDownTo("Temple and Family History");
        assertElementExistsBy(WebElementsByText("Temple and Family History", false));
        scrollDownTo("Life Help");
        assertElementExistsBy(WebElementsByText("Life Help", false));
        scrollDownTo("Self-Reliance");
        assertElementExistsBy(WebElementsByText("Self-Reliance", false));
        assertMoreOptionsMenu("Library", true);

    }


    //********** Notes Landing Page **********
    @Test
    public void NotesLandingPage_NotSignedIn() throws Exception {
        //Skip Login
        skipLogin();
        ClickUIElementByText("Notes", false);
        Thread.sleep(milliseconds_1);

        //Verify all elements present
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmarks"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        assertTabs("Notes");
        assertElementExistsBy(WebElementsByText("No Notes", false));
        assertElementExistsBy(WebElementsByText("Record notes to preserve your thoughts.", false));
        assertElementExistsBy(WebElementsByText("Notes", false));

        assertMoreOptionsMenu("Notes", true);

        //assertNavBar("Notes","","","","","",true);
        //Click back
        ClickUIElementByAccessibilityID("Navigate up");
        Thread.sleep(milliseconds_1);

    }

    //Have to create a reliable notebook
//    @Test
//    public void SignInCheckNotebookAndNote() throws Exception {
//
//        //Login
//        login();
//
//        //Verify "Notes item exists by text"
//        verifyText("Notes", WebElementByText("Notes"));
//        //Click "Notes"
//        ClickUIElementByText("Notes");
//        Thread.sleep(milliseconds_1);
//        //Verify Tabs in the notes section
//        verifyText("All", WebElementByText("All"));
//        verifyText("Tags", WebElementByText("Tags"));
//        verifyText("Notebooks", WebElementByText("Notebooks"));
//        //Click Notebooks
//        ClickUIElementByText("Notebooks");
//        Thread.sleep(milliseconds_1);
//        //Check notebook title and click on it
//        verifyText("Spiritual Thoughts", WebElementById(AppId("titleView"));
//        ClickUIElementByText("Spiritual Thoughts");
//        Thread.sleep(milliseconds_1);
//        //Verify note title and text preview then click on it
//        verifyText("Spiritual Thought", WebElementByText("Spiritual Thought"));
//        verifyText("Spiritual content", WebElementByText("Spiritual content"));
//        ClickUIElementByText("Spiritual Thought");
//        Thread.sleep(milliseconds_1);
//        //Verify note title and content
//        verifyText("Spiritual Thought", WebElementById(AppId("noteTitleEditText"));
//        verifyText("Spiritual content", WebElementById(AppId("markdownEditText"));
//        //Verify buttons are visible
//        assertElementExistsBy(WebElementsById(AppId("note_menu_tag"));

//        assertElementExistsBy(WebElementsById(AppId("note_menu_add_to_notebook"));
//        //Click Tag
//        ClickUIElementByID(AppId("note_menu_tag");
//        Thread.sleep(milliseconds_3);
//        //Verify Tags element exists
//        verifyText("Tags", WebElementByText("Tags"));
//        //Verify tag sorting and navigation exists
//        assertElementExistsBy(WebElementsById(AppId("menu_item_tag_sort"));
//        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
//        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/tagNameEditText", "Spirit");
//        Thread.sleep(milliseconds_1);
//        ClickUIElementByAccessibilityID("Navigate up");
//        Thread.sleep(milliseconds_1);
//        ClickUIElementByID(AppId("note_menu_tag");
//        Thread.sleep(milliseconds_1);
//        //Tag check
//        assertElementExistsBy(WebElementsById(AppId("tag_text"));
//        verifyText("Spirit", WebElementById(AppId("tag_text"));
//        Thread.sleep(milliseconds_1);
//        ClickUIElementByID(AppId("tag_delete");
//
//
//    }

    @Test
    public void CreateNewNotebook() throws Exception {

        //Login
        skipLogin();
        //Verify "Notes item exists by text"
        verifyText("Notes", WebElementByText("Notes", false), false);
        //Click "Notes"
        ClickUIElementByText("Notes", false);
        Thread.sleep(milliseconds_1);
        //Verify Tabs in the notes section
        assertTabs("Notes");
        assertMoreOptionsMenu("Notes", true);
        //Click Notebooks
        ClickUIElementByText("Notebooks", true);
        Thread.sleep(milliseconds_1);
        CreateNotebookandAssert(NotebookTitle1, true);

    }

    @Test
    public void RenameANotebook() throws Exception {
        fail("Test not written yet");
    }

    @Test
    public void CancelRenamingANotebook() throws Exception {
        fail("Test not written yet");
    }

    @Test
    public void DeleteANotebook() throws Exception {
        CreateNewNotebook();
        ClickUIElementByID(AppId("menuButton"));
        assertElementExistsBy(WebElementsByText("Rename", false));
        assertElementExistsBy(WebElementsByText("Delete", false));
        ClickUIElementByText("Delete", false);
        assertDeleteNotebooksPopup();
        ClickUIElementByID(AppId("md_button_positive"));
        assertElementNotPresentBy(WebElementsByText(NotebookTitle1, false));
    }

    @Test
    public void CancelDeleteANotebook() throws Exception {
        CreateNewNotebook();
        ClickUIElementByID(AppId("menuButton"));
        assertElementExistsBy(WebElementsByText("Rename", false));
        assertElementExistsBy(WebElementsByText("Delete", false));
        ClickUIElementByText("Delete", false);
        assertDeleteNotebooksPopup();
        ClickUIElementByID(AppId("md_button_negative"));
        assertElementExistsBy(WebElementsByText(NotebookTitle1, false));
    }

    @Test
    public void CreateNewNoteInNewNotebook() throws Exception {
        skipLogin();
        verifyText("Notes", WebElementByText("Notes", false), false);
        ClickUIElementByText("Notes", false);
        assertTabs("Notes");
        assertMoreOptionsMenu("Notes", true);
        ClickUIElementByText("Notebooks", true);
        CreateNotebookandAssert(NotebookTitle1, true);
        ClickUIElementByText(NotebookTitle1, false);
        verifyText("No Notes in This Notebook", WebElementById(AppId("emptyStateTitleTextView")), false);
        verifyText("Record notes to preserve your thoughts.", WebElementById(AppId("emptyStateSubTitleTextView")), false);
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmarks"));
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertMoreOptionsMenu("Notebooks", true);
        assertNavBar("Notebooks", NotebookTitle1, "", "", "", "", true);

        CreateNewNoteFromNotebook(NoteTitle, NoteBody);
        Thread.sleep(milliseconds_1);

        //Check Note
        verifyText(NoteTitle, WebElementById(AppId("noteTitleTextView")), false);
        verifyText(NoteBody, WebElementById(AppId("noteMarkdownTextView")), false);
        ClickUIElementByID(AppId("noteTitleTextView"));
        Thread.sleep(milliseconds_1);
        verifyText(NoteTitle, WebElementById(AppId("noteTitleEditText")), false);
        verifyText(NoteBody, WebElementById(AppId("markdownEditText")), false);
        Thread.sleep(milliseconds_1);

    }

    @Test
    public void CreateNew20000CharacterNoteInNewNotebook() throws Exception {
        skipLogin();
        verifyText("Notes", WebElementByText("Notes", false), false);
        ClickUIElementByText("Notes", false);
        assertTabs("Notes");
        assertMoreOptionsMenu("Notes", true);
        ClickUIElementByText("Notebooks", true);
        CreateNotebookandAssert(NotebookTitle1, true);
        ClickUIElementByText(NotebookTitle1, false);
        verifyText("No Notes in This Notebook", WebElementById(AppId("emptyStateTitleTextView")), false);
        verifyText("Record notes to preserve your thoughts.", WebElementById(AppId("emptyStateSubTitleTextView")), false);
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmarks"));
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertMoreOptionsMenu("Notebooks", true);
        assertNavBar("Notebooks", NotebookTitle1, "", "", "", "", true);

        CreateNewNoteFromNotebook(NoteTitle, Note20000Character);
        Thread.sleep(milliseconds_2);

        //Check Note
        verifyText(NoteTitle, WebElementById(AppId("noteTitleTextView")), false);
        verifyText(Note20000Character, WebElementById(AppId("noteMarkdownTextView")), false);
        ClickUIElementByID(AppId("noteTitleTextView"));
        Thread.sleep(milliseconds_1);
        scrollUp();
        verifyText(NoteTitle, WebElementById(AppId("noteTitleEditText")), false);
        verifyText(Note20000Character, WebElementById(AppId("markdownEditText")), false);
        Thread.sleep(milliseconds_1);
    }

    @Test
    public void NotesSectionDeleteNote() throws Exception {
        CreateNewNoteInNewNotebook();
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByID(AppId("annotationMenuImageButton"));
        assertNoteOptionsMenu();
        ClickUIElementByText("Delete", false);
        assertRemoveAnnotationPopup();
        ClickUIElementByID(AppId("md_button_positive"));
        assertElementNotPresentBy(WebElementsById(AppId("noteTitleTextView")));
        assertElementNotPresentBy(WebElementsById(AppId("noteMarkdownTextView")));
        verifyText("No Notes in This Notebook", WebElementById(AppId("emptyStateTitleTextView")), false);
        verifyText("Record notes to preserve your thoughts.", WebElementById(AppId("emptyStateSubTitleTextView")), false);
    }

    @Test
    public void NotesSectionCancelDeleteNote() throws Exception {
        CreateNewNoteInNewNotebook();
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByID(AppId("annotationMenuImageButton"));
        assertNoteOptionsMenu();
        ClickUIElementByText("Delete", false);
        assertRemoveAnnotationPopup();
        ClickUIElementByID(AppId("md_button_negative"));
        assertElementExistsBy(WebElementsById(AppId("noteTitleTextView")));
        assertElementExistsBy(WebElementsById(AppId("noteMarkdownTextView")));

        //Check Note
        verifyText(NoteTitle, WebElementById(AppId("noteTitleTextView")), false);
        verifyText(NoteBody, WebElementById(AppId("noteMarkdownTextView")), false);

    }

    @Test
    public void NotesSectionEditNote() throws Exception {
        CreateNewNoteInNewNotebook();
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByID(AppId("annotationMenuImageButton"));
        assertNoteOptionsMenu();
        ClickUIElementByText("Edit Note", false);
        assertElementExistsBy(WebElementsById(AppId("boldImageView")));
        assertElementExistsBy(WebElementsById(AppId("italicImageView")));
        assertElementExistsBy(WebElementsById(AppId("unorderedListImageView")));
        assertElementExistsBy(WebElementsById(AppId("orderedListImageView")));
        assertElementExistsBy(WebElementsByAccessibilityId("Add to Notebook"));
        assertElementExistsBy(WebElementsByAccessibilityId("Tag"));
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        verifyText(NoteTitle, WebElementById(AppId("noteTitleEditText")), false);
        verifyText(NoteBody, WebElementById(AppId("markdownEditText")), false);
        //Type Note Text
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/noteTitleEditText", "Title Edited");
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText", "Body Edited");
        ClickUIElementByAccessibilityID("Navigate up");

        assertElementExistsBy(WebElementsById(AppId("noteTitleTextView")));
        assertElementExistsBy(WebElementsById(AppId("noteMarkdownTextView")));

        //Check Note
        verifyText("Title Edited", WebElementById(AppId("noteTitleTextView")), false);
        verifyText("Body Edited", WebElementById(AppId("noteMarkdownTextView")), false);

    }

    @Test
    public void NotesSectionAddNoteToNotebook() throws Exception {
        AnnotationMenuCreateNote();
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByAccessibilityID("Navigate up");
        assertMenuBar("Library", "", false);
        assertMoreOptionsMenu("Library", true);
        ClickUIElementByText("Notes", false);
        assertTabs("Notes");
        assertMoreOptionsMenu("Notes", true);
        //Click Notebooks
        ClickUIElementByText("Notebooks", true);
        Thread.sleep(milliseconds_1);
        CreateNotebookandAssert(NotebookTitle1, true);
        ClickUIElementByText("All", true);
        ClickUIElementByID(AppId("annotationMenuImageButton"));
        assertNoteOptionsMenu();
        ClickUIElementByText("Add to Notebook", false);
        ClickUIElementByResourceID("org.lds.ldssa." + GospelLibraryBuild + ":id/notebookCheckBox");
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByText("Notebooks", true);
        ClickUIElementByText(NotebookTitle1, false);
        verifyText("Spiritual Thought Title", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/noteTitleTextView"), false);
        verifyText("Spiritual thought expounded on", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/noteMarkdownTextView"), false);
    }

    @Test
    public void NotesSectionMergeTwoNotebooks() throws Exception {
        CreateNewNoteInNewNotebook();
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByText("Notebooks", true);
        CreateNotebookandAssert(NotebookTitle2, true);
        ClickUIElementByText(NotebookTitle2, false);
        verifyText("No Notes in This Notebook", WebElementById(AppId("emptyStateTitleTextView")), false);
        verifyText("Record notes to preserve your thoughts.", WebElementById(AppId("emptyStateSubTitleTextView")), false);
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmarks"));
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertMoreOptionsMenu("Notebooks", true);
        assertNavBar("Notebooks", NotebookTitle2, "", "", "", "", true);
        CreateNewNoteFromNotebook(NoteTitle2, NoteBody2);
        Thread.sleep(milliseconds_1);
        //Check Note
        verifyText(NoteBody2, WebElementById(AppId("noteMarkdownTextView")), false);
        ClickUIElementByID(AppId("noteTitleTextView"));
        Thread.sleep(milliseconds_1);
        verifyText(NoteTitle2, WebElementById(AppId("noteTitleEditText")), false);
        verifyText(NoteBody2, WebElementById(AppId("markdownEditText")), false);
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByAccessibilityID("Navigate up");
        driver.tap(1, WebElementByXpath("(//*[@resource-id =\"org.lds.ldssa." + GospelLibraryBuild + ":id/listItemImageView\"])[1]"), 500);
        assertNotebookMultiselectMode("1 item");
        ClickUIElementByXpath("(//*[@resource-id =\"org.lds.ldssa." + GospelLibraryBuild + ":id/listItemImageView\"])[2]");
        assertElementExistsBy(WebElementsByAccessibilityId("Merge"));
        ClickUIElementByAccessibilityID("Merge");
        //assert Merge Notebook Popup
        assertMergeNotebookPopup("Merged Notebook", true);
        verifyText("Merged Notebook", WebElementByXpath("//*[@resource-id =\"org.lds.ldssa." + GospelLibraryBuild + ":id/titleView\"]"), false);
        verifyText("2 items", WebElementByXpath("//*[@resource-id =\"org.lds.ldssa." + GospelLibraryBuild + ":id/subTitleView\"]"), false);
        ClickUIElementByXpath("//*[@resource-id =\"org.lds.ldssa." + GospelLibraryBuild + ":id/subTitleView\"]");
        verifyText(NoteTitle, WebElementByXpath("(//*[@resource-id =\"org.lds.ldssa." + GospelLibraryBuild + ":id/noteTitleTextView\"])[1]"), false);
        verifyText(NoteTitle2, WebElementByXpath("(//*[@resource-id =\"org.lds.ldssa." + GospelLibraryBuild + ":id/noteTitleTextView\"])[2]"), false);
    }

    @Test
    public void NotesSectionCancelMergeTwoNotebooks() throws Exception {
        CreateNewNoteInNewNotebook();
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByText("Notebooks", true);
        CreateNotebookandAssert(NotebookTitle2, true);
        ClickUIElementByText(NotebookTitle2, false);
        verifyText("No Notes in This Notebook", WebElementById(AppId("emptyStateTitleTextView")), false);
        verifyText("Record notes to preserve your thoughts.", WebElementById(AppId("emptyStateSubTitleTextView")), false);
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmarks"));
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertMoreOptionsMenu("Notebooks", true);
        assertNavBar("Notebooks", NotebookTitle2, "", "", "", "", true);
        CreateNewNoteFromNotebook(NoteTitle2, NoteBody2);
        Thread.sleep(milliseconds_1);
        //Check Note
        verifyText(NoteBody2, WebElementById(AppId("noteMarkdownTextView")), false);
        ClickUIElementByID(AppId("noteTitleTextView"));
        Thread.sleep(milliseconds_1);
        verifyText(NoteTitle2, WebElementById(AppId("noteTitleEditText")), false);
        verifyText(NoteBody2, WebElementById(AppId("markdownEditText")), false);
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByAccessibilityID("Navigate up");
        driver.tap(1, WebElementByXpath("(//*[@resource-id =\"org.lds.ldssa." + GospelLibraryBuild + ":id/listItemImageView\"])[1]"), 500);
        assertNotebookMultiselectMode("1 item");
        ClickUIElementByXpath("(//*[@resource-id =\"org.lds.ldssa." + GospelLibraryBuild + ":id/listItemImageView\"])[2]");
        assertElementExistsBy(WebElementsByAccessibilityId("Merge"));
        ClickUIElementByAccessibilityID("Merge");
        //assert Merge Notebook Popup
        assertMergeNotebookPopup("Merged Notebook", false);
        verifyText(NotebookTitle2, WebElementByXpath("//*[@resource-id =\"org.lds.ldssa." + GospelLibraryBuild + ":id/titleView\"]"), false);
        verifyText("1 item", WebElementByXpath("//*[@resource-id =\"org.lds.ldssa." + GospelLibraryBuild + ":id/subTitleView\"]"), false);
        ClickUIElementByXpath("(//*[@resource-id =\"org.lds.ldssa." + GospelLibraryBuild + ":id/subTitleView\"])[1]");
        verifyText(NoteTitle2, WebElementByXpath("//*[@resource-id =\"org.lds.ldssa." + GospelLibraryBuild + ":id/noteTitleTextView\"]"), false);
    }

    @Test
    public void NotesSectionSortNotebooksByCount() throws Exception {
        CreateNewNoteInNewNotebook();
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByText("Notebooks", true);
        CreateNotebookandAssert(NotebookTitle2, true);
        ClickUIElementByID(AppId("filterMenuImageButton"));
        driver.getPageSource();
        //assert Sort Notebooks Menu
        assertSortNotebooksMenuAndClick("Recent", "Count");
        verifyText(NotebookTitle1, WebElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/titleView\"])[1]"), false);
        verifyText(NotebookTitle2, WebElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/titleView\"])[2]"), false);
    }

    @Test
    public void NotesSectionSortNotebooksByRecent() throws Exception {
        CreateNewNotebook();
        CreateNotebookandAssert(NotebookTitle2, true);
        ClickUIElementByID(AppId("filterMenuImageButton"));
        driver.getPageSource();
        //assert Sort Notebooks Menu
        assertSortNotebooksMenuAndClick("Recent", "Recent");
        verifyText(NotebookTitle1, WebElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/titleView\"])[2]"), false);
        verifyText(NotebookTitle2, WebElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/titleView\"])[1]"), false);
    }

    @Test
    public void NotesSectionSortNotebooksByName() throws Exception {
        CreateNewNotebook();
        CreateNotebookandAssert(NotebookTitle2, true);
        ClickUIElementByID(AppId("filterMenuImageButton"));
        driver.getPageSource();
        //assert Sort Notebooks Menu
        assertSortNotebooksMenuAndClick("Recent", "Name");
        verifyText(NotebookTitle1, WebElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/titleView\"])[1]"), false);
        verifyText(NotebookTitle2, WebElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/titleView\"])[2]"), false);
    }

    @Test
    public void NotesSectionUseBoldFormatting() throws Exception {
        skipLogin();
        verifyText("Notes", WebElementByText("Notes", false), false);
        ClickUIElementByText("Notes", false);
        assertTabs("Notes");
        assertMoreOptionsMenu("Notes", true);
        ClickUIElementByText("Notebooks", true);
        CreateNotebookandAssert(NotebookTitle1, true);
        ClickUIElementByText(NotebookTitle1, false);
        verifyText("No Notes in This Notebook", WebElementById(AppId("emptyStateTitleTextView")), false);
        verifyText("Record notes to preserve your thoughts.", WebElementById(AppId("emptyStateSubTitleTextView")), false);
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmarks"));
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertMoreOptionsMenu("Notebooks", true);
        assertNavBar("Notebooks", NotebookTitle1, "", "", "", "", true);
        CreateNewNoteFromNotebook(NoteTitle, NoteBody);
        Thread.sleep(milliseconds_1);
        //Check Note
        verifyText(NoteTitle, WebElementById(AppId("noteTitleTextView")), false);
        verifyText(NoteBody, WebElementById(AppId("noteMarkdownTextView")), false);
        ClickUIElementByID(AppId("noteTitleTextView"));
        Thread.sleep(milliseconds_1);
        verifyText(NoteTitle, WebElementById(AppId("noteTitleEditText")), false);
        verifyText(NoteBody, WebElementById(AppId("markdownEditText")), false);
        sendTextFromKeyboard("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText", " ", true);
        ClickUIElementByID(AppId("boldImageView"));
        sendTextFromKeyboard("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText", "This should be Bold ", true);
        ClickUIElementByID(AppId("boldImageView"));
        sendTextFromKeyboard("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText", "This should not be Bold", false);
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByID(AppId("noteTitleTextView"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Show Annotation Info", false));
        ClickUIElementByText("Show Annotation Info", false);
        assertElementExistsBy(WebElementsById(AppId("infoTextView")));
        String theAnnotationInfo = WebElementById(AppId("infoTextView")).getText();
        System.out.println(theAnnotationInfo);
        int noteBodyOffset = theAnnotationInfo.indexOf("content\"");
        noteBodyOffset = noteBodyOffset + 11;
        System.out.println("noteBodyOffset is " + noteBodyOffset);
        int noteTitleOffset = theAnnotationInfo.indexOf("title");
        noteTitleOffset = noteTitleOffset - 8;
        System.out.println("noteTitleOffset is " + noteTitleOffset);
        String noteBody = theAnnotationInfo.substring(noteBodyOffset, noteTitleOffset);
        System.out.println(noteBody);
        Assert.assertEquals("This is a note\\\\. **This should be Bold** This should not be Bold", noteBody);
    }

    @Test
    public void NotesSectionUseItalicFormatting() throws Exception {
        skipLogin();
        ;
        verifyText("Notes", WebElementByText("Notes", false), false);
        ClickUIElementByText("Notes", false);
        assertTabs("Notes");
        assertMoreOptionsMenu("Notes", true);
        ClickUIElementByText("Notebooks", true);
        CreateNotebookandAssert(NotebookTitle1, true);
        ClickUIElementByText(NotebookTitle1, false);
        verifyText("No Notes in This Notebook", WebElementById(AppId("emptyStateTitleTextView")), false);
        verifyText("Record notes to preserve your thoughts.", WebElementById(AppId("emptyStateSubTitleTextView")), false);
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmarks"));
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertMoreOptionsMenu("Notebooks", true);
        assertNavBar("Notebooks", NotebookTitle1, "", "", "", "", true);
        CreateNewNoteFromNotebook(NoteTitle, NoteBody);
        Thread.sleep(milliseconds_1);
        //Check Note
        verifyText(NoteTitle, WebElementById(AppId("noteTitleTextView")), false);
        verifyText(NoteBody, WebElementById(AppId("noteMarkdownTextView")), false);
        ClickUIElementByID(AppId("noteTitleTextView"));
        Thread.sleep(milliseconds_1);
        verifyText(NoteTitle, WebElementById(AppId("noteTitleEditText")), false);
        verifyText(NoteBody, WebElementById(AppId("markdownEditText")), false);
        sendTextFromKeyboard("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText", " ", true);
        ClickUIElementByID(AppId("italicImageView"));
        sendTextFromKeyboard("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText", "This should be Italic ", true);
        ClickUIElementByID(AppId("italicImageView"));
        sendTextFromKeyboard("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText", "This should not be Italic", false);
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByID(AppId("noteTitleTextView"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Show Annotation Info", false));
        ClickUIElementByText("Show Annotation Info", false);
        assertElementExistsBy(WebElementsById(AppId("infoTextView")));
        String theAnnotationInfo = WebElementById(AppId("infoTextView")).getText();
        System.out.println(theAnnotationInfo);
        int noteBodyOffset = theAnnotationInfo.indexOf("content\"");
        noteBodyOffset = noteBodyOffset + 11;
        System.out.println("noteBodyOffset is " + noteBodyOffset);
        int noteTitleOffset = theAnnotationInfo.indexOf("title");
        noteTitleOffset = noteTitleOffset - 8;
        System.out.println("noteTitleOffset is " + noteTitleOffset);
        String noteBody = theAnnotationInfo.substring(noteBodyOffset, noteTitleOffset);
        System.out.println(noteBody);
        Assert.assertEquals("This is a note\\\\. _This should be Italic_ This should not be Italic", noteBody);
    }


    @Test
    public void NotesSectionUseItalicAndBoldFormattingInSameNote() throws Exception {
        skipLogin();
        verifyText("Notes", WebElementByText("Notes", false), false);
        ClickUIElementByText("Notes", false);
        assertTabs("Notes");
        assertMoreOptionsMenu("Notes", true);
        ClickUIElementByText("Notebooks", true);
        CreateNotebookandAssert(NotebookTitle1, true);
        ClickUIElementByText(NotebookTitle1, false);
        verifyText("No Notes in This Notebook", WebElementById(AppId("emptyStateTitleTextView")), false);
        verifyText("Record notes to preserve your thoughts.", WebElementById(AppId("emptyStateSubTitleTextView")), false);
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmarks"));
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertMoreOptionsMenu("Notebooks", true);
        assertNavBar("Notebooks", NotebookTitle1, "", "", "", "", true);
        CreateNewNoteFromNotebook(NoteTitle, NoteBody);
        Thread.sleep(milliseconds_1);
        //Check Note
        verifyText(NoteTitle, WebElementById(AppId("noteTitleTextView")), false);
        verifyText(NoteBody, WebElementById(AppId("noteMarkdownTextView")), false);
        ClickUIElementByID(AppId("noteTitleTextView"));
        Thread.sleep(milliseconds_1);
        verifyText(NoteTitle, WebElementById(AppId("noteTitleEditText")), false);
        verifyText(NoteBody, WebElementById(AppId("markdownEditText")), false);
        sendTextFromKeyboard("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText", " ", true);
        ClickUIElementByID(AppId("italicImageView"));
        sendTextFromKeyboard("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText", "This should be Italic ", true);
        ClickUIElementByID(AppId("italicImageView"));
        sendTextFromKeyboard("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText", "This should not be Italic ", false);
        ClickUIElementByID(AppId("boldImageView"));
        sendTextFromKeyboard("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText", "This should be Bold ", false);
        ClickUIElementByID(AppId("boldImageView"));
        sendTextFromKeyboard("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText", "This should not be Bold", false);
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByID(AppId("noteTitleTextView"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Show Annotation Info", false));
        ClickUIElementByText("Show Annotation Info", false);
        assertElementExistsBy(WebElementsById(AppId("infoTextView")));
        String theAnnotationInfo = WebElementById(AppId("infoTextView")).getText();
        System.out.println(theAnnotationInfo);
        int noteBodyOffset = theAnnotationInfo.indexOf("content\"");
        noteBodyOffset = noteBodyOffset + 11;
        System.out.println("noteBodyOffset is " + noteBodyOffset);
        int noteTitleOffset = theAnnotationInfo.indexOf("title");
        noteTitleOffset = noteTitleOffset - 8;
        System.out.println("noteTitleOffset is " + noteTitleOffset);
        String noteBody = theAnnotationInfo.substring(noteBodyOffset, noteTitleOffset);
        System.out.println(noteBody);
        Assert.assertEquals("This is a note\\\\. _This should be Italic_ This should not be Italic **This should be Bold** This should not be Bold", noteBody);
    }

    @Test
    public void NotesSectionUseItalicAndBoldFormattingOnSameWord() throws Exception {
        skipLogin();
        verifyText("Notes", WebElementByText("Notes", false), false);
        ClickUIElementByText("Notes", false);
        assertTabs("Notes");
        assertMoreOptionsMenu("Notes", true);
        ClickUIElementByText("Notebooks", true);
        CreateNotebookandAssert(NotebookTitle1, true);
        ClickUIElementByText(NotebookTitle1, false);
        verifyText("No Notes in This Notebook", WebElementById(AppId("emptyStateTitleTextView")), false);
        verifyText("Record notes to preserve your thoughts.", WebElementById(AppId("emptyStateSubTitleTextView")), false);
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmarks"));
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertMoreOptionsMenu("Notebooks", true);
        assertNavBar("Notebooks", NotebookTitle1, "", "", "", "", true);
        CreateNewNoteFromNotebook(NoteTitle, NoteBody);
        Thread.sleep(milliseconds_1);
        //Check Note
        verifyText(NoteTitle, WebElementById(AppId("noteTitleTextView")), false);
        verifyText(NoteBody, WebElementById(AppId("noteMarkdownTextView")), false);
        ClickUIElementByID(AppId("noteTitleTextView"));
        Thread.sleep(milliseconds_1);
        verifyText(NoteTitle, WebElementById(AppId("noteTitleEditText")), false);
        verifyText(NoteBody, WebElementById(AppId("markdownEditText")), false);
        sendTextFromKeyboard("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText", " ", true);
        ClickUIElementByID(AppId("italicImageView"));
        ClickUIElementByID(AppId("boldImageView"));
        sendTextFromKeyboard("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText", "This should be Italic and Bold ", true);
        ClickUIElementByID(AppId("italicImageView"));
        ClickUIElementByID(AppId("boldImageView"));
        sendTextFromKeyboard("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText", "This should not be Italic or Bold", false);
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByID(AppId("noteTitleTextView"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Show Annotation Info", false));
        ClickUIElementByText("Show Annotation Info", false);
        assertElementExistsBy(WebElementsById(AppId("infoTextView")));
        String theAnnotationInfo = WebElementById(AppId("infoTextView")).getText();
        System.out.println(theAnnotationInfo);
        int noteBodyOffset = theAnnotationInfo.indexOf("content\"");
        noteBodyOffset = noteBodyOffset + 11;
        System.out.println("noteBodyOffset is " + noteBodyOffset);
        int noteTitleOffset = theAnnotationInfo.indexOf("title");
        noteTitleOffset = noteTitleOffset - 8;
        System.out.println("noteTitleOffset is " + noteTitleOffset);
        String noteBody = theAnnotationInfo.substring(noteBodyOffset, noteTitleOffset);
        System.out.println(noteBody);
        Assert.assertEquals("This is a note\\\\. **_This should be Italic and Bold_** This should not be Italic or Bold", noteBody);
    }


    @Test
    public void NotesSectionUseNumberedAndBulletedLists() throws Exception {
        skipLogin();
        verifyText("Notes", WebElementByText("Notes", false), false);
        ClickUIElementByText("Notes", false);
        assertTabs("Notes");
        assertMoreOptionsMenu("Notes", true);
        ClickUIElementByText("Notebooks", true);
        CreateNotebookandAssert(NotebookTitle1, true);
        ClickUIElementByText(NotebookTitle1, false);
        verifyText("No Notes in This Notebook", WebElementById(AppId("emptyStateTitleTextView")), false);
        verifyText("Record notes to preserve your thoughts.", WebElementById(AppId("emptyStateSubTitleTextView")), false);
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmarks"));
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertMoreOptionsMenu("Notebooks", true);
        assertNavBar("Notebooks", NotebookTitle1, "", "", "", "", true);
        CreateNewNoteFromNotebook(NoteTitle, NoteBody);
        Thread.sleep(milliseconds_1);
        //Check Note
        verifyText(NoteTitle, WebElementById(AppId("noteTitleTextView")), false);
        verifyText(NoteBody, WebElementById(AppId("noteMarkdownTextView")), false);
        ClickUIElementByID(AppId("noteTitleTextView"));
        Thread.sleep(milliseconds_1);
        verifyText(NoteTitle, WebElementById(AppId("noteTitleEditText")), false);
        verifyText(NoteBody, WebElementById(AppId("markdownEditText")), false);

        sendTextFromKeyboard("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText", "¶", true);
        ClickUIElementByID(AppId("unorderedListImageView"));
        sendTextFromKeyboard("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText", "bulleted list 1¶bulleted list 2¶¶", false);
        ClickUIElementByID(AppId("orderedListImageView"));
        sendTextFromKeyboard("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText", "numbered list 1¶numbered list 2¶numbered list 3¶¶not numbered", false);
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByID(AppId("noteTitleTextView"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Show Annotation Info", false));
        ClickUIElementByText("Show Annotation Info", false);
        assertElementExistsBy(WebElementsById(AppId("infoTextView")));
        String theAnnotationInfo = WebElementById(AppId("infoTextView")).getText();
        System.out.println(theAnnotationInfo);
        int noteBodyOffset = theAnnotationInfo.indexOf("content\"");
        noteBodyOffset = noteBodyOffset + 11;
        System.out.println("noteBodyOffset is " + noteBodyOffset);
        int noteTitleOffset = theAnnotationInfo.indexOf("title");
        noteTitleOffset = noteTitleOffset - 8;
        System.out.println("noteTitleOffset is " + noteTitleOffset);
        String noteBody = theAnnotationInfo.substring(noteBodyOffset, noteTitleOffset);
        System.out.println(noteBody);
        Assert.assertEquals("This is a note\\\\.&nbsp;  \\n* bulleted list 1&nbsp;  \\n* bulleted list 2&nbsp;  \\n* \\n\\n&nbsp;  \\n&nbsp;  \\n1. numbered list 1&nbsp;  \\n2. numbered list 2&nbsp;  \\n3. numbered list 3&nbsp;  \\n4. \\n\\n&nbsp;  \\n&nbsp;  \\nnot numbered", noteBody);
    }

    @Test
    public void NotesSectionUseBulletedList() throws Exception {
        skipLogin();
        verifyText("Notes", WebElementByText("Notes", false), false);
        ClickUIElementByText("Notes", false);
        assertTabs("Notes");
        assertMoreOptionsMenu("Notes", true);
        ClickUIElementByText("Notebooks", true);
        CreateNotebookandAssert(NotebookTitle1, true);
        ClickUIElementByText(NotebookTitle1, false);
        verifyText("No Notes in This Notebook", WebElementById(AppId("emptyStateTitleTextView")), false);
        verifyText("Record notes to preserve your thoughts.", WebElementById(AppId("emptyStateSubTitleTextView")), false);
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmarks"));
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertMoreOptionsMenu("Notebooks", true);
        assertNavBar("Notebooks", NotebookTitle1, "", "", "", "", true);
        CreateNewNoteFromNotebook(NoteTitle, NoteBody);
        Thread.sleep(milliseconds_1);
        //Check Note
        verifyText(NoteTitle, WebElementById(AppId("noteTitleTextView")), false);
        verifyText(NoteBody, WebElementById(AppId("noteMarkdownTextView")), false);
        ClickUIElementByID(AppId("noteTitleTextView"));
        Thread.sleep(milliseconds_1);
        verifyText(NoteTitle, WebElementById(AppId("noteTitleEditText")), false);
        verifyText(NoteBody, WebElementById(AppId("markdownEditText")), false);

        sendTextFromKeyboard("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText", "¶", true);
        ClickUIElementByID(AppId("unorderedListImageView"));
        sendTextFromKeyboard("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText", "bulleted list 1¶bulleted list 2", false);
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByID(AppId("noteTitleTextView"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Show Annotation Info", false));
        ClickUIElementByText("Show Annotation Info", false);
        assertElementExistsBy(WebElementsById(AppId("infoTextView")));
        String theAnnotationInfo = WebElementById(AppId("infoTextView")).getText();
        System.out.println(theAnnotationInfo);
        int noteBodyOffset = theAnnotationInfo.indexOf("content\"");
        noteBodyOffset = noteBodyOffset + 11;
        System.out.println("noteBodyOffset is " + noteBodyOffset);
        int noteTitleOffset = theAnnotationInfo.indexOf("title");
        noteTitleOffset = noteTitleOffset - 8;
        System.out.println("noteTitleOffset is " + noteTitleOffset);
        String noteBody = theAnnotationInfo.substring(noteBodyOffset, noteTitleOffset);
        System.out.println(noteBody);
        Assert.assertEquals("This is a note\\\\.&nbsp;  \\n* bulleted list 1&nbsp;  \\n* bulleted list 2\\n\\n", noteBody);
    }

    @Test
    public void NotesSectionUseNumberedList() throws Exception {
        skipLogin();
        verifyText("Notes", WebElementByText("Notes", false), false);
        ClickUIElementByText("Notes", false);
        assertTabs("Notes");
        assertMoreOptionsMenu("Notes", true);
        ClickUIElementByText("Notebooks", true);
        CreateNotebookandAssert(NotebookTitle1, true);
        ClickUIElementByText(NotebookTitle1, false);
        verifyText("No Notes in This Notebook", WebElementById(AppId("emptyStateTitleTextView")), false);
        verifyText("Record notes to preserve your thoughts.", WebElementById(AppId("emptyStateSubTitleTextView")), false);
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmarks"));
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertMoreOptionsMenu("Notebooks", true);
        assertNavBar("Notebooks", NotebookTitle1, "", "", "", "", true);
        CreateNewNoteFromNotebook(NoteTitle, NoteBody);
        Thread.sleep(milliseconds_1);
        //Check Note
        verifyText(NoteTitle, WebElementById(AppId("noteTitleTextView")), false);
        verifyText(NoteBody, WebElementById(AppId("noteMarkdownTextView")), false);
        ClickUIElementByID(AppId("noteTitleTextView"));
        Thread.sleep(milliseconds_1);
        verifyText(NoteTitle, WebElementById(AppId("noteTitleEditText")), false);
        verifyText(NoteBody, WebElementById(AppId("markdownEditText")), false);

        sendTextFromKeyboard("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText", "¶", true);

        ClickUIElementByID(AppId("orderedListImageView"));
        sendTextFromKeyboard("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText", "numbered list 1¶numbered list 2¶numbered list 3", false);
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByID(AppId("noteTitleTextView"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Show Annotation Info", false));
        ClickUIElementByText("Show Annotation Info", false);
        assertElementExistsBy(WebElementsById(AppId("infoTextView")));
        String theAnnotationInfo = WebElementById(AppId("infoTextView")).getText();
        System.out.println(theAnnotationInfo);
        int noteBodyOffset = theAnnotationInfo.indexOf("content\"");
        noteBodyOffset = noteBodyOffset + 11;
        System.out.println("noteBodyOffset is " + noteBodyOffset);
        int noteTitleOffset = theAnnotationInfo.indexOf("title");
        noteTitleOffset = noteTitleOffset - 8;
        System.out.println("noteTitleOffset is " + noteTitleOffset);
        String noteBody = theAnnotationInfo.substring(noteBodyOffset, noteTitleOffset);
        System.out.println(noteBody);
        Assert.assertEquals("This is a note\\\\.&nbsp;  \\n1. numbered list 1&nbsp;  \\n2. numbered list 2&nbsp;  \\n3. numbered list 3\\n\\n", noteBody);
    }


    //********** Bookmarks Landing Page **********
    @Test
    public void BookmarksLandingPageFromLibrary_NotSignedIn() throws Exception {
        //Skip Login
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmarks"));
        ClickUIElementByAccessibilityID("Bookmarks");
        assertBookmarkScreen(true, false);
    }

    @Test
    public void BookmarksLandingPageFromContent_NotSignedIn() throws Exception {
        //Skip Login
        skipLogin();
        OpenScripture("Book of Mormon", "Enos", "", "");
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmarks"));
        ClickUIElementByAccessibilityID("Bookmarks");
        assertBookmarkScreen(true, false);
    }

    @Test
    public void BookmarksCreateBookmarkFromScripture() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "5", "");
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmarks"));
        ClickUIElementByAccessibilityID("Bookmarks");
        assertBookmarkScreen(true, true);
        ClickUIElementByID(AppId("locationsFab"));
        assertAddBookmarkPopup("Jacob 5", BookmarkOneTitle, true);
        ClickUIElementByAccessibilityID("Bookmarks");
        assertElementExistsBy(WebElementsById(AppId("titleTextView")));
        verifyText(BookmarkOneTitle, WebElementById(AppId("titleTextView")), false);
        assertElementExistsBy(WebElementsById(AppId("subTitleTextView")));
        verifyText("Jacob 5", WebElementById(AppId("subTitleTextView")), false);
        ClickUIElementByID(AppId("titleTextView"));
        assertNavBar("Jacob 5", "Jacob", "Book of Mormon", "Scriptures", "Library", "", true);
    }

    @Test
    public void BookmarksCreateBookmarkFromScriptureCancel() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "5", "");
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmarks"));
        ClickUIElementByAccessibilityID("Bookmarks");
        assertTabs("Bookmarks");
        assertElementExistsBy(WebElementsById(AppId("locationsFab")));
        ClickUIElementByID(AppId("locationsFab"));
        assertAddBookmarkPopup("Jacob 5", BookmarkOneTitle, false);
        assertBookmarkScreen(true, true);
    }

    @Test
    public void BookmarksCreateBookmarkFromScriptureDefault() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "5", "");
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmarks"));
        ClickUIElementByAccessibilityID("Bookmarks");
        assertTabs("Bookmarks");
        assertElementExistsBy(WebElementsById(AppId("locationsFab")));
        ClickUIElementByID(AppId("locationsFab"));
        assertAddBookmarkPopup("Jacob 5", "Default", true);
        ClickUIElementByAccessibilityID("Bookmarks");
        assertElementExistsBy(WebElementsById(AppId("titleTextView")));
        verifyText("Jacob 5", WebElementById(AppId("titleTextView")), false);
        assertElementExistsBy(WebElementsById(AppId("subTitleTextView")));
        verifyText("Book of Mormon", WebElementById(AppId("subTitleTextView")), false);
        ClickUIElementByID(AppId("titleTextView"));
        assertNavBar("Jacob 5", "Jacob", "Book of Mormon", "Scriptures", "Library", "", true);
    }

    @Test
    public void BookmarksDefaultBookmarkTitleUpdatesItself() throws Exception {
        BookmarksCreateBookmarkFromScriptureDefault();
        swipeRight();
        ClickUIElementByAccessibilityID("Bookmarks");
        assertBookmarkItemOptions("Jacob 5", false);
        ClickUIElementByText("Update", false);
        assertNavBar("Jacob 6", "Jacob", "Book of Mormon", "Scriptures", "Library", "", true);
        ClickUIElementByAccessibilityID("Bookmarks");
        assertElementExistsBy(WebElementsById(AppId("titleTextView")));
        verifyText("Jacob 6", WebElementById(AppId("titleTextView")), false);
        assertElementExistsBy(WebElementsById(AppId("subTitleTextView")));
        verifyText("Book of Mormon", WebElementById(AppId("subTitleTextView")), false);

    }

    @Test
    public void BookmarkMoveNamedBookmarkToNewChapter() throws Exception {
        BookmarksCreateBookmarkFromScripture();
        swipeRight();
        ClickUIElementByAccessibilityID("Bookmarks");
        assertBookmarkItemOptions("Jacob 5", false);
        ClickUIElementByText("Update", false);
        assertNavBar("Jacob 6", "Jacob", "Book of Mormon", "Scriptures", "Library", "", true);
        ClickUIElementByAccessibilityID("Bookmarks");
        assertElementExistsBy(WebElementsById(AppId("titleTextView")));
        verifyText(BookmarkOneTitle, WebElementById(AppId("titleTextView")), false);
        assertElementExistsBy(WebElementsById(AppId("subTitleTextView")));
        verifyText("Jacob 6", WebElementById(AppId("subTitleTextView")), false);

    }

    @Test
    public void BookmarksRenameABookmark() throws Exception {
        BookmarksCreateBookmarkFromScripture();
        ClickUIElementByAccessibilityID("Bookmarks");
        assertBookmarkItemOptions(BookmarkOneTitle, false);
        ClickUIElementByText("Rename", false);
        assertRenameBookmarkPopup(BookmarkOneTitle, BookmarkTwoTitle, true);
        assertElementExistsBy(WebElementsById(AppId("titleTextView")));
        verifyText(BookmarkTwoTitle, WebElementById(AppId("titleTextView")), false);
        assertElementExistsBy(WebElementsById(AppId("subTitleTextView")));
        verifyText("Jacob 5", WebElementById(AppId("subTitleTextView")), false);
        ClickUIElementByID(AppId("titleTextView"));
        assertNavBar("Jacob 5", "Jacob", "Book of Mormon", "Scriptures", "Library", "", true);
    }

    @Test
    public void BookmarksRenameABookmarkCancel() throws Exception {
        BookmarksCreateBookmarkFromScripture();
        ClickUIElementByAccessibilityID("Bookmarks");
        assertBookmarkItemOptions(BookmarkOneTitle, false);
        ClickUIElementByText("Rename", false);
        assertRenameBookmarkPopup(BookmarkOneTitle, BookmarkTwoTitle, false);
        assertElementExistsBy(WebElementsById(AppId("titleTextView")));
        verifyText(BookmarkOneTitle, WebElementById(AppId("titleTextView")), false);
        assertElementExistsBy(WebElementsById(AppId("subTitleTextView")));
        verifyText("Jacob 5", WebElementById(AppId("subTitleTextView")), false);
        ClickUIElementByID(AppId("titleTextView"));
        assertNavBar("Jacob 5", "Jacob", "Book of Mormon", "Scriptures", "Library", "", true);
    }

    @Test
    public void BookmarksRenameABookmarkDefault() throws Exception {
        BookmarksCreateBookmarkFromScripture();
        ClickUIElementByAccessibilityID("Bookmarks");
        assertBookmarkItemOptions(BookmarkOneTitle, false);
        ClickUIElementByText("Rename", false);
        assertRenameBookmarkPopup(BookmarkOneTitle, "Default", true);
        assertElementExistsBy(WebElementsById(AppId("titleTextView")));
        verifyText("Jacob 5", WebElementById(AppId("titleTextView")), false);
        assertElementExistsBy(WebElementsById(AppId("subTitleTextView")));
        verifyText("Book of Mormon", WebElementById(AppId("subTitleTextView")), false);
        ClickUIElementByID(AppId("titleTextView"));
        assertNavBar("Jacob 5", "Jacob", "Book of Mormon", "Scriptures", "Library", "", true);
    }

    @Test
    public void BookmarksRenameABookmarkDefaultBookmarkUpdatesToNewChapterTitle() throws Exception {
        BookmarksCreateBookmarkFromScripture();
        ClickUIElementByAccessibilityID("Bookmarks");
        assertBookmarkItemOptions(BookmarkOneTitle, false);
        ClickUIElementByText("Rename", false);
        assertRenameBookmarkPopup(BookmarkOneTitle, "Default", true);
        assertElementExistsBy(WebElementsById(AppId("titleTextView")));
        verifyText("Jacob 5", WebElementById(AppId("titleTextView")), false);
        assertElementExistsBy(WebElementsById(AppId("subTitleTextView")));
        verifyText("Book of Mormon", WebElementById(AppId("subTitleTextView")), false);
        ClickUIElementByID(AppId("titleTextView"));
        assertNavBar("Jacob 5", "Jacob", "Book of Mormon", "Scriptures", "Library", "", true);
        swipeRight();
        ClickUIElementByAccessibilityID("Bookmarks");
        assertBookmarkItemOptions("Jacob 5", false);
        ClickUIElementByText("Update", false);
        assertNavBar("Jacob 6", "Jacob", "Book of Mormon", "Scriptures", "Library", "", true);
        ClickUIElementByAccessibilityID("Bookmarks");
        assertElementExistsBy(WebElementsById(AppId("titleTextView")));
        verifyText("Jacob 6", WebElementById(AppId("titleTextView")), false);
        assertElementExistsBy(WebElementsById(AppId("subTitleTextView")));
        verifyText("Book of Mormon", WebElementById(AppId("subTitleTextView")), false);
    }

    @Test
    public void BookmarksDeleteBookmark() throws Exception {
        BookmarksCreateBookmarkFromScripture();
        ClickUIElementByAccessibilityID("Bookmarks");
        assertBookmarkItemOptions(BookmarkOneTitle, false);
        ClickUIElementByText("Delete", false);
        assertDeleteBookmarkPopupAndTap(BookmarkOneTitle, true);
        assertBookmarkScreen(true, true);
    }

    @Test
    public void BookmarksCancelDeleteBookmark() throws Exception {
        BookmarksCreateBookmarkFromScripture();
        ClickUIElementByAccessibilityID("Bookmarks");
        assertBookmarkItemOptions(BookmarkOneTitle, false);
        ClickUIElementByText("Delete", false);
        assertDeleteBookmarkPopupAndTap(BookmarkOneTitle, false);
        assertBookmarkScreen(false, true);
        assertElementExistsBy(WebElementsById(AppId("titleTextView")));
        verifyText(BookmarkOneTitle, WebElementById(AppId("titleTextView")), false);
        assertElementExistsBy(WebElementsById(AppId("subTitleTextView")));
        verifyText("Jacob 5", WebElementById(AppId("subTitleTextView")), false);
    }

    @Test
    public void BookmarksHideAddAndUpdateButtonsWhenNotOnChapter() throws Exception {
        BookmarksCreateBookmarkFromScripture();
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByAccessibilityID("Bookmarks");
        ClickUIElementByXpath("//android.widget.TextView[@text=\"" + BookmarkOneTitle + "\"]/../../android.widget.ImageButton");
        assertElementExistsBy(WebElementsByText("Rename", false));
        assertElementExistsBy(WebElementsByText("Delete", false));
        assertElementNotPresentBy(WebElementsByTextWebview("Update", false));
        dismissDialog(WebElementByXpath("*//android.widget.FrameLayout"));
        assertElementNotPresentBy(WebElementsByIdExpectFalse("org.lds.ldssa." + GospelLibraryBuild + ":id/locationsFab"));
    }

    @Test
    public void BookmarksReorderBookmarks() throws Exception {
        BookmarksCreateBookmarkFromScripture();
        swipeRight();
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmarks"));
        ClickUIElementByAccessibilityID("Bookmarks");
        assertBookmarkScreen(false, true);
        ClickUIElementByID(AppId("locationsFab"));
        assertAddBookmarkPopup("Jacob 6", BookmarkTwoTitle, true);
        ClickUIElementByAccessibilityID("Bookmarks");
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/titleTextView\"])[1]"));
        verifyText(BookmarkTwoTitle, WebElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/titleTextView\"])[1]"), false);
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/subTitleTextView\"])[1]"));
        verifyText("Jacob 6", WebElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/subTitleTextView\"])[1]"), false);
        ClickUIElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/titleTextView\"])[1]");
        assertNavBar("Jacob 6", "Jacob", "Book of Mormon", "Scriptures", "Library", "", true);
        ClickUIElementByAccessibilityID("Bookmarks");
        verifyText(BookmarkTwoTitle, WebElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/titleTextView\"])[1]"), false);
        verifyText(BookmarkOneTitle, WebElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/titleTextView\"])[2]"), false);
        TapAndDrag(WebElementByXpath("//android.widget.TextView[@text=\"" + BookmarkOneTitle + "\"]/../../android.widget.ImageButton"), WebElementByXpath("//android.widget.TextView[@text=\"" + BookmarkTwoTitle + "\"]/../../android.widget.ImageButton"));
        verifyText(BookmarkOneTitle, WebElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/titleTextView\"])[1]"), false);
        verifyText(BookmarkTwoTitle, WebElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/titleTextView\"])[2]"), false);
        ClickUIElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/titleTextView\"])[1]");
        assertNavBar("Jacob 5", "Jacob", "Book of Mormon", "Scriptures", "Library", "", true);

    }


    @Test
    public void BookmarksLandingPageFromNotes_NotSignedIn() throws Exception {
        // Skip Login
        skipLogin();
        ClickUIElementByText("Notes", false);
        Thread.sleep(milliseconds_1);
        assertMoreOptionsMenu("Notes", true);
        assertTabs("Notes");
        ClickUIElementByAccessibilityID("Bookmarks");
        Thread.sleep(milliseconds_1);

        //verify all elements present on bookmarks screen
        assertTabs("Bookmarks");
        assertElementExistsBy(WebElementsByText("No Bookmarks", false));
        assertElementExistsBy(WebElementsByText("Add a bookmark to quickly return to where you left off.", false));
        //click Screens
        Thread.sleep(milliseconds_1);
        ClickUIElementByText("Screens", true);
        Thread.sleep(milliseconds_1);
        assertTabs("Bookmarks");
        assertMoreOptionsMenu("Screens", false);
        ClickUIElementByText("Screen Settings", false);
        //assert elements present on screens settings screen
        assertElementExistsBy(WebElementsByText("Show Screens as Separate Windows", false));
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertSettingsSwitchExpectedStateAndToggle("Show Screens as Separate Windows", true);
        ClickUIElementByAccessibilityID("Navigate up");
        //verify notes screen
        assertElementExistsBy(WebElementsById(AppId("screenTitleTextView")));
        verifyText("Notes", WebElementById(AppId("screenTitleTextView")), false);
        //verify add screen fab
        assertElementExistsBy(WebElementsById(AppId("locationsFab")));
        //
        assertMoreOptionsMenu("Screens", false);
        ClickUIElementByText("Close All Screens", false);

        assertElementExistsBy(WebElementsById(AppId("screenTitleTextView")));
        verifyText("Notes", WebElementById(AppId("screenTitleTextView")), false);
        //verify add screen fab
        ClickUIElementByID(AppId("locationsFab"));
        ClickUIElementByAccessibilityID("Bookmarks");
        assertElementExistsBy(WebElementsByText("Library", false));
        assertElementExistsBy(WebElementsByText("Notes", false));
        assertMoreOptionsMenu("Screens", false);
        ClickUIElementByText("Close All Screens", false);
        assertElementExistsBy(WebElementsById(AppId("screenTitleTextView")));
        verifyText("Library", WebElementById(AppId("screenTitleTextView")), false);
        assertElementNotPresentBy(WebElementsByText("Notes", false));
        Thread.sleep(milliseconds_2);

        Thread.sleep(milliseconds_1);

        //Click History tab
        ClickUIElementByText("History", true);
        Thread.sleep(milliseconds_1);
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsById(AppId("emptyStateImageView")));
        assertElementExistsBy(WebElementsById(AppId("emptyStateTitleTextView")));
        assertElementExistsBy(WebElementsById(AppId("emptyStateSubTitleTextView")));
        assertMoreOptionsMenu("History", true);
        verifyText("No History", WebElementById(AppId("emptyStateTitleTextView")), false);
        verifyText("Explore content, find your path, and go back to it.", WebElementById(AppId("emptyStateSubTitleTextView")), false);

        ClickUIElementByAccessibilityID("Navigate up");
        Thread.sleep(milliseconds_1);

    }

    @Test
    public void ScreensScreenFromNotesScreenItemOptions() throws Exception {
        skipLogin();
        ClickUIElementByText("Notes", false);
        Thread.sleep(milliseconds_1);
        ClickUIElementByAccessibilityID("Bookmarks");
        Thread.sleep(milliseconds_1);

        //verify all elements present on bookmarks screen
        assertTabs("Bookmarks");
        assertElementExistsBy(WebElementsByText("No Bookmarks", false));
        assertElementExistsBy(WebElementsByText("Add a bookmark to quickly return to where you left off.", false));
        //click Screens
        Thread.sleep(milliseconds_1);
        ClickUIElementByText("Screens", true);
        assertScreenItemOptions("Notes", true);


    }

    @Test
    public void ScreensScreenFromLibrary() throws Exception {
        //Skip Login
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmarks"));
        ClickUIElementByAccessibilityID("Bookmarks");
        Thread.sleep(milliseconds_1);
        assertTabs("Bookmarks");
        ClickUIElementByText("Screens", true);
        Thread.sleep(milliseconds_1);
        assertElementExistsBy(WebElementsById(AppId("screenTitleTextView")));
        verifyText("Library", WebElementById(AppId("screenTitleTextView")), false);
        assertElementExistsBy(WebElementsById(AppId("screenImageView")));
        assertElementExistsBy(WebElementsById(AppId("screenTitleTextView")));
        verifyText("Library", WebElementById(AppId("screenTitleTextView")), false);
        assertMoreOptionsMenu("Screens", false);
        ClickUIElementByText("Screen Settings", false);
        //assert elements present on screens settings screen
        assertElementExistsBy(WebElementsByText("Show Screens as Separate Windows", false));
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertSettingsSwitchExpectedStateAndToggle("Show Screens as Separate Windows", true);
        ClickUIElementByAccessibilityID("Navigate up");
        //verify notes screen
        assertElementExistsBy(WebElementsById(AppId("screenTitleTextView")));
        verifyText("Library", WebElementById(AppId("screenTitleTextView")), false);

        assertElementExistsBy(WebElementsById(AppId("locationsFab")));

        assertTabs("Bookmarks");
        //Click History tab
        ClickUIElementByText("History", true);
        assertMoreOptionsMenu("History", true);
        Thread.sleep(milliseconds_1);
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsById(AppId("emptyStateImageView")));
        assertElementExistsBy(WebElementsById(AppId("emptyStateTitleTextView")));
        assertElementExistsBy(WebElementsById(AppId("emptyStateSubTitleTextView")));
        verifyText("No History", WebElementById(AppId("emptyStateTitleTextView")), false);
        verifyText("Explore content, find your path, and go back to it.", WebElementById(AppId("emptyStateSubTitleTextView")), false);

        ClickUIElementByAccessibilityID("Navigate up");
        Thread.sleep(milliseconds_1);

    }


    //********** Settings Screen **********
    @Test
    public void settingsScreenLandingPageNotSignedIn() throws Exception {
        skipLogin();
        assertMoreOptionsMenu("Library", false);
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        assertElementExistsBy(WebElementsByText("Account", false));
        assertElementExistsBy(WebElementsByText("Sign In", false));
        assertElementExistsBy(WebElementsByText("A Church Account is used to back up and synchronize your data between devices and the Church website.", false));
        assertElementExistsBy(WebElementsByText(CreateAccountString, false));
        assertElementExistsBy(WebElementsByText("Content", false));
        assertElementExistsBy(WebElementsByText("Downloaded Media", false));
        assertElementExistsBy(WebElementsByText("None", false));
        assertElementExistsBy(WebElementsByText("Limit Mobile Network Use", false));
        assertElementExistsBy(WebElementsByText("Only Download and Stream on Wi-Fi", false));

        // Toggle on and off verification (doesn't check that the settings work, just checks that the toggle works
        // toggle verification is currently by xpath because no other identifier is available
        assertSettingsSwitchExpectedStateAndToggle("Limit Mobile Network Use", false);
        assertElementExistsBy(WebElementsByText("Display", false));
        assertElementExistsBy(WebElementsByText("Theme", false));
        assertElementExistsBy(WebElementsByText("Default", false));
        scrollDownTo("Text Size");
        assertElementExistsBy(WebElementsByText("Text Size", false));

        scrollDownTo("List Mode");
        assertElementExistsBy(WebElementsByText("List Mode", false));
        // Toggle on and off verification (doesn't check that the settings work, just checks that the toggle works
        // toggle verification is currently by xpath because no other identifier is available
        assertSettingsSwitchExpectedStateAndToggle("List Mode", false);
        scrollDownTo("Hide Footnotes");
        assertElementExistsBy(WebElementsByText("Hide Footnotes", false));
        // Toggle on and off verification (doesn't check that the settings work, just checks that the toggle works
        // toggle verification is currently by xpath because no other identifier is available
        assertSettingsSwitchExpectedStateAndToggle("Hide Footnotes", false);
        scrollDownTo("Audio Settings");
        assertElementExistsBy(WebElementsByText("Audio Settings", false));
        scrollDownTo("Screen Settings");
        assertElementExistsBy(WebElementsByText("Screen Settings", false));
        // Toggle on and off verification (doesn't check that the settings work, just checks that the toggle works
        // toggle verification is currently by xpath because no other identifier is available
        scrollDownTo("Allow In-App Notifications");
        assertElementExistsBy(WebElementsByText("Allow In-App Notifications", false));
        // Toggle on and off verification (doesn't check that the settings work, just checks that the toggle works
        // toggle verification is currently by xpath because no other identifier is available
        scrollDownTo("Show Obsolete Content");
        assertElementExistsBy(WebElementsByText("Show Obsolete Content", false));
        // Toggle on and off verification (doesn't check that the settings work, just checks that the toggle works
        // toggle verification is currently by xpath because no other identifier is available
        assertSettingsSwitchExpectedStateAndToggle("Show Obsolete Content", false);
        assertSettingsSwitchExpectedStateAndToggle("Allow In-App Notifications", true);
        scrollDownTo("Additional Info");
        assertElementExistsBy(WebElementsByText("Additional Info", false));
        scrollDownTo("Featured Apps");
        assertElementExistsBy(WebElementsByText("Featured Apps", false));
        scrollDownTo("Send Feedback");
        assertElementExistsBy(WebElementsByText("Send Feedback", false));
        scrollDownTo("About");
        assertElementExistsBy(WebElementsByText("About", false));
        scrollDownTo("App Details");
        assertElementExistsBy(WebElementsByText("App Details", false));

    }

    @Test
    public void settingsScreenLoginCorrectUserNameAndPassword() throws Exception {
        skipLogin();
        assertMoreOptionsMenu("Library", false);
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        assertElementExistsBy(WebElementsByText("Sign In", false));
        ClickUIElementByText("Sign In", false);

        assertElementExistsBy(WebElementsById(AppId("usernameEditText")));
        //appium can't validate ! if Username not entered and SignIn clicked
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/usernameEditText", user);
        assertElementExistsBy(WebElementsById(AppId("passwordEditText")));
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/passwordEditText", password);
        assertElementExistsBy(WebElementsByAccessibilityId("Show password"));
        boolean passwordVisibility = Boolean.parseBoolean((WebElementByAccessibilityId("Show password").getAttribute("checked")));
        System.out.println(passwordVisibility);
        assert !passwordVisibility;
        verifyText(hidePassword(password), WebElementById(AppId("passwordEditText")), false);
        ClickUIElementByAccessibilityID("Show password");
        Thread.sleep(milliseconds_1);
        passwordVisibility = Boolean.parseBoolean((WebElementByAccessibilityId("Show password").getAttribute("checked")));
        System.out.println(passwordVisibility);
        assert passwordVisibility;
        verifyText(password, WebElementById(AppId("passwordEditText")), false);
        WebElement signInButton = driver.findElementById("org.lds.ldssa." + GospelLibraryBuild + ":id/ldsAccountSignInButton");
        signInButton.click();
        Thread.sleep(milliseconds_5);
        assertElementExistsBy(WebElementsByText("Account", false));
        assertElementExistsBy(WebElementsByText(user, false));
    }

    @Test
    public void settingsScreenLoginInvalidLogin() throws Exception {
        skipLogin();
        assertMoreOptionsMenu("Library", false);
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        assertElementExistsBy(WebElementsByText("Sign In", false));
        ClickUIElementByText("Sign In", false);

        assertElementExistsBy(WebElementsById(AppId("usernameEditText")));
        //appium can't validate ! if Username not entered and SignIn clicked
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/usernameEditText", user);
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/passwordEditText", wrongPassword);
        WebElement signInButton = driver.findElementById("org.lds.ldssa." + GospelLibraryBuild + ":id/ldsAccountSignInButton");
        signInButton.click();
        Thread.sleep(milliseconds_3);
        verifyText("Error", WebElementByText("Error", false), false);
        assertElementExistsBy(WebElementsById("android:id/button1"));
        verifyText("OK", WebElementById("android:id/button1"), true);
        ClickUIElementByID("android:id/button1");
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/passwordEditText", password);
        signInButton.click();
        Thread.sleep(milliseconds_5);
        assertElementExistsBy(WebElementsByText("Account", false));
        assertElementExistsBy(WebElementsByText(user, false));
    }

    @Test
    public void settingsScreenLoginTroubleSigningIn() throws Exception {
        skipLogin();
        assertMoreOptionsMenu("Library", false);
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        assertElementExistsBy(WebElementsByText("Sign In", false));
        ClickUIElementByText("Sign In", false);

        ClickUIElementByID(AppId("ldsAccountLoginForgotCredentialsButton"));
        Thread.sleep(milliseconds_5);
        verifyText("https://settings.churchofjesuschrist.org/recovery", WebElementById("com.android.chrome:id/url_bar"), false);
    }


    @Test
    public void settingsScreenCreateLDSAccount() throws Exception {
        skipLogin();
        assertMoreOptionsMenu("Library", false);
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        assertElementExistsBy(WebElementsByText(CreateAccountString, false));
        ClickUIElementByText(CreateAccountString, false);
        Thread.sleep(milliseconds_5);
        verifyText("https://settings.churchofjesuschrist.org/register", WebElementById("com.android.chrome:id/url_bar"), false);
    }

    @Test
    public void settingsScreenDownloadedMediaLandingPage_Empty() throws Exception {
        skipLogin();
        assertMoreOptionsMenu("Library", false);
        ClickUIElementByText("Settings", false);
        assertElementExistsBy(WebElementsByText("Downloaded Media", false));
        assertElementExistsBy(WebElementsByText("None", false));
        ClickUIElementByText("Downloaded Media", false);
        Thread.sleep(milliseconds_1);
        //when the empty state bug is fixed, change the following line to true
        assertMoreOptionsMenu("DownloadsByItem", true);
        //when the empty state bug is fixed, change the following line to true
        assertDownloadScreen(false);
    }

    @Test
    public void settingsScreenDownloadedMediaLandingPage_Empty_MoreOptionsMenu() throws Exception {
        skipLogin();
        assertMoreOptionsMenu("Library", false);
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        assertElementExistsBy(WebElementsByText("Downloaded Media", false));
        ClickUIElementByText("Downloaded Media", false);
        Thread.sleep(milliseconds_1);
        assertMoreOptionsMenu("DownloadsByItem", true);
        //when the empty state bug is fixed, change the following line to true
        assertDownloadScreen(false);
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertMoreOptionsMenu("DownloadsByItem", false);
        ClickUIElementByText("Current Downloads", false);
        assertElementExistsBy(WebElementsByText("Current Downloads", false));
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsById(AppId("mainToolbarTitleTextView")));
        verifyText("Current Downloads", WebElementById(AppId("mainToolbarTitleTextView")), false);
        assertElementExistsBy(WebElementsById(AppId("emptyStateImageView")));
        assertElementExistsBy(WebElementsById(AppId("emptyStateTitleTextView")));
        verifyText("No Downloads in Progress", WebElementById(AppId("emptyStateTitleTextView")), false);
        assertElementExistsBy(WebElementsById(AppId("emptyStateSubTitleTextView")));
        verifyText("Content and media currently being downloaded.", WebElementById(AppId("emptyStateSubTitleTextView")), false);
        ClickUIElementByAccessibilityID("Navigate up");
        Thread.sleep(milliseconds_1);
        assertElementExistsBy(WebElementsById(AppId("mainToolbarTitleTextView")));
        verifyText("Downloaded Media", WebElementById(AppId("mainToolbarTitleTextView")), false);
        ClickUIElementByAccessibilityID("Navigate up");
        Thread.sleep(milliseconds_3);
        assertElementExistsBy(WebElementsByText("Account", false));
        Thread.sleep(milliseconds_1);
    }

    @Test
    public void settingsScreenDownloadedMediaGeneralConferenceDownloaded_AccessedThroughMoreOptionsMenu() throws Exception {
        skipLogin();
        OpenConference("October", "2017", "General Women’s Session");
        ClickUIElementByXpath("//android.webkit.WebView[@text='General Women’s Session']/android.view.View/android.view.View/android.view.View/android.widget.Image[2]");
        assertElementExistsBy(WebElementsById(AppId("md_text_title")));
        verifyText("Download Video", WebElementById(AppId("md_text_title")), false);
        assertElementExistsBy(WebElementsById(AppId("md_text_message")));
        verifyText("General Women’s Session" + "\n" +
                "2 GB", WebElementById(AppId("md_text_message")), false);
        assertElementExistsBy(WebElementsById(AppId("md_icon_title")));
        assertElementExistsBy(WebElementsById(AppId("md_button_negative")));
        verifyText("CANCEL", WebElementById(AppId("md_button_negative")), false);
        assertElementExistsBy(WebElementsById(AppId("md_button_positive")));
        verifyText("DOWNLOAD", WebElementById(AppId("md_button_positive")), false);
        ClickUIElementByID(AppId("md_button_positive"));
        //assertElementExistsBy(WebElementsById(AppId("snackbar_text"));
        //verifyText("Downloading video for General Women's Session",WebElementById(AppId("snackbar_text"));
        //assertElementExistsBy(WebElementsById(AppId("snackbar_action"));
        //verifyText("VIEW",WebElementById(AppId("snackbar_action"));
        assertMoreOptionsMenu("Content Menu", false);
        ClickUIElementByText("Settings", false);
        assertElementExistsBy(WebElementsByText("Downloaded Media", false));
        ClickUIElementByText("Downloaded Media", false);
        assertMoreOptionsMenu("DownloadsByItem", false);
        ClickUIElementByText("Current Downloads", false);
        // Commented out because the download would complete before all assertions ran. assertElementExistsBy(WebElementsById(AppId("mainToolbarTitleTextView"));
        //
        verifyText("Current Downloads (1)", WebElementById(AppId("mainToolbarTitleTextView")), false);
        // Commented out because the download would complete before all assertions ran. assertElementExistsBy(WebElementsById(AppId("titleTextView"));
        //
        verifyText("General Women’s Session", WebElementById(AppId("titleTextView")), false);
        // Commented out because the download would complete before all assertions ran. assertElementExistsBy(WebElementsById(AppId("installStatusTextView"));
        //
        verifyText("Downloading…", WebElementById(AppId("installStatusTextView")), false);
        assertElementExistsBy(WebElementsById(AppId("downloadCancelImageView")));
        assertElementExistsBy(WebElementsByAccessibilityId("Cancel All"));

    }

    //Commented out while figuring out snack bar
    //    @Test
//    public void settingsScreenDownloadedMediaGeneralConferenceDownloaded_AccessedThroughSnackBar() throws Exception {
//        skipLogin();
//        assertElementExistsBy(WebElementsByText("General Conference"));
//        ClickUIElementByText("General Conference");
//        scrollDownTo("October 2017");
//        assertElementExistsBy(WebElementsByText("October 2017"));
//        ClickUIElementByText("October 2017");
//        ClickUIElementByText("October 2017");
//        Thread.sleep(milliseconds_1);
//        assertElementExistsBy(WebElementsByText("General Women’s Session"));
//        ClickUIElementByText("General Women’s Session");
//        ClickUIElementByXpath("//android.webkit.WebView[@text='General Women’s Session']/android.view.View/android.view.View/android.view.View/android.widget.Image[2]");
//        assertElementExistsBy(WebElementsById(AppId("md_text_title"));
//
//        verifyText("Download Video",WebElementById(AppId("md_text_title"));
//        assertElementExistsBy(WebElementsById(AppId("titleView"));
//        verifyText("General Women's Session",WebElementById(AppId("titleView"));
//        assertElementExistsBy(WebElementsById(AppId("typeIcon"));
//        assertElementExistsBy(WebElementsById(AppId("md_button_negative"));
//        verifyText("CANCEL",WebElementById(AppId("md_button_negative"));
//        assertElementExistsBy(WebElementsById(AppId("md_button_positive"));
//        verifyText("DOWNLOAD",WebElementById(AppId("md_button_positive"));
//        ClickUIElementByID(AppId("md_button_positive");
//        assertElementExistsBy(WebElementsById(AppId("snackbar_text"));
//        verifyText("Downloading video for General Women's Session",WebElementById(AppId("snackbar_text"));
//        // assertElementExistsBy(WebElementsById(AppId("snackbar_action"));
//        // verifyText("VIEW",WebElementById(AppId("snackbar_action"));
//        ClickUIElementByID(AppId("snackbar_action");
//        // Commented out because the download would complete before all assertions ran. assertElementExistsBy(WebElementsById(AppId("mainToolbarTitleTextView"));
//        verifyText("Current Downloads (1)", WebElementById(AppId("mainToolbarTitleTextView"));
//        // Commented out because the download would complete before all assertions ran. assertElementExistsBy(WebElementsById(AppId("titleTextView"));
//        verifyText("General Women's Session", WebElementById(AppId("titleTextView"));
//        // Commented out because the download would complete before all assertions ran. assertElementExistsBy(WebElementsById(AppId("installStatusTextView"));
//        verifyText("Downloading…",WebElementById(AppId("installStatusTextView"));
//        assertElementExistsBy(WebElementsById(AppId("downloadCancelImageView"));
//        assertElementExistsBy(WebElementsByAccessibilityId("Cancel All"));
//
//    }

    //Snackbar almost always fails because the test isn't fast enough to catch it before the snackbar goes away
//    @Test
//    public void settingsScreenDownloadedMediaGeneralConferenceDownloaded_AccessedThroughSnackBar_CancelWithIDdownloadCancelImageView() throws Exception {
//        skipLogin();
//        assertElementExistsBy(WebElementsByText("General Conference"));
//        ClickUIElementByText("General Conference");
//        scrollDownTo("October 2017");
//        assertElementExistsBy(WebElementsByText("October 2017"));
//        ClickUIElementByText("October 2017");
//        ClickUIElementByText("October 2017");
//        Thread.sleep(milliseconds_1);
//        assertElementExistsBy(WebElementsByText("General Women’s Session"));
//        ClickUIElementByText("General Women’s Session");
//        ClickUIElementByXpath("//android.webkit.WebView[@text='General Women’s Session']/android.view.View/android.view.View/android.view.View/android.widget.Image[2]");
//        assertElementExistsBy(WebElementsById(AppId("md_text_title"));
//
//        verifyText("Download Video",WebElementById(AppId("md_text_title"));
//        assertElementExistsBy(WebElementsById(AppId("titleView"));
//        verifyText("General Women's Session",WebElementById(AppId("titleView"));
//        assertElementExistsBy(WebElementsById(AppId("typeIcon"));
//        assertElementExistsBy(WebElementsById(AppId("md_button_negative"));
//        verifyText("CANCEL",WebElementById(AppId("md_button_negative"));
//        assertElementExistsBy(WebElementsById(AppId("md_button_positive"));
//        verifyText("DOWNLOAD",WebElementById(AppId("md_button_positive"));
//        ClickUIElementByID(AppId("md_button_positive");
//        //snackbar almost always times out
//        //assertElementExistsBy(WebElementsById(AppId("snackbar_text"));
//        //verifyText("Downloading video for General Women's Session",WebElementById(AppId("snackbar_text"));
//        // assertElementExistsBy(WebElementsById(AppId("snackbar_action"));
//        // verifyText("VIEW",WebElementById(AppId("snackbar_action"));
//        ClickUIElementByID(AppId("snackbar_action");
//        // Commented out because the download would complete before all assertions ran. assertElementExistsBy(WebElementsById(AppId("mainToolbarTitleTextView"));
//        verifyText("Current Downloads (1)", WebElementById(AppId("mainToolbarTitleTextView"));
//        // Commented out because the download would complete before all assertions ran. assertElementExistsBy(WebElementsById(AppId("titleTextView"));
//        verifyText("General Women's Session", WebElementById(AppId("titleTextView"));
//        // Commented out because the download would complete before all assertions ran. assertElementExistsBy(WebElementsById(AppId("installStatusTextView"));
//        verifyText("Downloading…",WebElementById(AppId("installStatusTextView"));
//        assertElementExistsBy(WebElementsById(AppId("downloadCancelImageView"));
//        assertElementExistsBy(WebElementsByAccessibilityId("Cancel All"));
//        ClickUIElementByID(AppId("downloadCancelImageView");
//        assertElementNotPresentBy(WebElementsById(AppId("downloadCancelImageView"));
//        assertElementNotPresentBy(WebElementsById("Cancel All"));
//        assertElementNotPresentBy(WebElementsById(AppId("installStatusTextView"));
//        assertElementNotPresentBy(WebElementsById(AppId("titleTextView"));
//        assertElementExistsBy(WebElementsById(AppId("emptyStateImageView"));
//        assertElementExistsBy(WebElementsById(AppId("emptyStateTitleTextView"));
//        verifyText("No Downloads in Progress", WebElementById(AppId("emptyStateTitleTextView"));
//        assertElementExistsBy(WebElementsById(AppId("emptyStateSubTitleTextView"));
//        verifyText("Content and media currently being downloaded.", WebElementById(AppId("emptyStateSubTitleTextView"));
//        ClickUIElementByAccessibilityID("Navigate up");
//        ClickUIElementByAccessibilityID("More options");
//        ClickUIElementByText("Settings");
//        ClickUIElementByText("Downloaded Media");
//        assertElementExistsBy(WebElementsById(AppId("mainToolbarTitleTextView"));
//        verifyText("Downloaded Media", WebElementById(AppId("mainToolbarTitleTextView"));
//        assertElementExistsBy(WebElementsById(AppId("emptyStateImageView"));
//        assertElementExistsBy(WebElementsById(AppId("emptyStateTitleTextView"));
//        verifyText("No Downloaded Media", WebElementById(AppId("emptyStateTitleTextView"));
//        assertElementExistsBy(WebElementsById(AppId("emptyStateSubTitleTextView"));
//        verifyText("Download audio or video for offline access.", WebElementById(AppId("emptyStateSubTitleTextView"));
//
//    }


    @Test
    public void settingsScreenDownloadedMediaGeneralConferenceDownloaded_CancelAllWithOneDownload() throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByText("General Conference", false));
        ClickUIElementByText("General Conference", false);
        scrollDownTo("October 2017");
        assertElementExistsBy(WebElementsByText("October 2017", false));
        ClickUIElementByText("October 2017", false);
        ClickUIElementByText("October 2017", false);
        Thread.sleep(milliseconds_1);
        assertElementExistsBy(WebElementsByText("General Women’s Session", false));
        ClickUIElementByText("General Women’s Session", false);
        ClickUIElementByXpath("//android.webkit.WebView[@text='General Women’s Session']/android.view.View/android.view.View/android.view.View/android.widget.Image[2]");
        assertElementExistsBy(WebElementsById(AppId("md_text_title")));
        verifyText("Download Video", WebElementById(AppId("md_text_title")), false);
        assertElementExistsBy(WebElementsById(AppId("md_text_message")));
        verifyText("General Women’s Session\n" + "2 GB", WebElementById(AppId("md_text_message")), false);
        assertElementExistsBy(WebElementsById(AppId("md_icon_title")));
        assertElementExistsBy(WebElementsById(AppId("md_button_negative")));
        verifyText("Cancel", WebElementById(AppId("md_button_negative")), true);
        assertElementExistsBy(WebElementsById(AppId("md_button_positive")));
        verifyText("Download", WebElementById(AppId("md_button_positive")), true);
        ClickUIElementByID(AppId("md_button_positive"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        assertElementExistsBy(WebElementsByText("Downloaded Media", false));
        ClickUIElementByText("Downloaded Media", false);
        assertMoreOptionsMenu("DownloadsByItem", false);
        ClickUIElementByText("Current Downloads", false);
        // Commented out because the download would complete before all assertions ran. assertElementExistsBy(WmainToolbarTitleTextView"));
        verifyText("Current Downloads (1)", WebElementById(AppId("mainToolbarTitleTextView")), false);
        // Commented out because the download would complete before all assertions ran. assertElementExistsBy(WebElementsById(AppId("titleTextView"));
        //
        verifyText("General Women’s Session", WebElementById(AppId("titleTextView")), false);
        verifyText("Downloading…", WebElementById(AppId("installStatusTextView")), false);
        assertElementExistsBy(WebElementsById(AppId("downloadCancelImageView")));
        assertElementExistsBy(WebElementsByAccessibilityId("Cancel All"));
        ClickUIElementByAccessibilityID("Cancel All");
        assertElementExistsBy(WebElementsById(AppId("md_text_title")));
        verifyText("Cancel Download", WebElementById(AppId("md_text_title")), false);
        assertElementExistsBy(WebElementsById(AppId("md_text_message")));
        verifyText("All current downloads will be canceled.\n" +
                "\n" +
                "Cancel downloads?", WebElementById(AppId("md_text_message")), false);
        assertElementExistsBy(WebElementsById(AppId("md_button_negative")));
        verifyText("NO", WebElementById(AppId("md_button_negative")), false);
        assertElementExistsBy(WebElementsById(AppId("md_button_positive")));
        verifyText("YES", WebElementById(AppId("md_button_positive")), false);
        ClickUIElementByID(AppId("md_button_positive"));
        assertElementNotPresentBy(WebElementsById(AppId("downloadCancelImageView")));
        assertElementNotPresentBy(WebElementsById("Cancel All"));
        assertElementNotPresentBy(WebElementsById(AppId("installStatusTextView")));
        assertElementNotPresentBy(WebElementsById(AppId("titleTextView")));
        assertElementExistsBy(WebElementsById(AppId("emptyStateImageView")));
        assertElementExistsBy(WebElementsById(AppId("emptyStateTitleTextView")));
        verifyText("No Downloads in Progress", WebElementById(AppId("emptyStateTitleTextView")), false);
        assertElementExistsBy(WebElementsById(AppId("emptyStateSubTitleTextView")));
        verifyText("Content and media currently being downloaded.", WebElementById(AppId("emptyStateSubTitleTextView")), false);
        ClickUIElementByAccessibilityID("Navigate up");
        assertElementExistsBy(WebElementsById(AppId("mainToolbarTitleTextView")));
        verifyText("Downloaded Media", WebElementById(AppId("mainToolbarTitleTextView")), false);
        //*************** These Assertions are broken because the Empty State of the Downloaded Media Page isn't working properly.
//        assertElementExistsBy(WebElementsById(AppId("emptyStateImageView"));
//        assertElementExistsBy(WebElementsById(AppId("emptyStateTitleTextView"));
//        verifyText("No Downloaded Media", WebElementById(AppId("emptyStateTitleTextView"));
//        assertElementExistsBy(WebElementsById(AppId("emptyStateSubTitleTextView"));
//        verifyText("Download audio or video for offline access.", WebElementById(AppId("emptyStateSubTitleTextView"));

    }

//    @Test
//    public void settingsScreenDownloadedMediaOTDownloaded_CancelAll_MultipleDownloads() throws Exception {
//        skipLogin();
//        OpenScripture("Old Testament","","","");
//        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
//        ClickUIElementByAccessibilityID("More options");
//        assertElementExistsBy(WebElementsByText("Download Audio", false));
//        ClickUIElementByText("Download Audio", false);
//        assertDownloadAudioPopup("Old Testament\n" +"2.1 GB",true);
//        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
//        ClickUIElementByAccessibilityID("More options");
//        assertElementExistsBy(WebElementsByText("Settings", false));
//        ClickUIElementByText("Settings", false);
//        assertElementExistsBy(WebElementsByText("Downloaded Media", false));
//        ClickUIElementByText("Downloaded Media", false);
//        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
//        ClickUIElementByAccessibilityID("More options");
//        assertElementExistsBy(WebElementsByText("Sort by Size", false));
//        assertElementExistsBy(WebElementsByText("Current Downloads", false));
//        ClickUIElementByText("Current Downloads", false);
//        assertElementExistsBy(WebElementsByAccessibilityId("Cancel All"));
//        ClickUIElementByAccessibilityID("Cancel All");
//        assertElementExistsBy(WebElementsById(AppId("md_text_title"));
//        verifyText("Cancel Download", WebElementById(AppId("md_text_title"),false);
//        assertElementExistsBy(WebElementsById(AppId("md_text_message"));
//        verifyText("All current downloads will be canceled.\n" +
//                "\n" +
//                "Cancel downloads?",WebElementById(AppId("md_text_message"),false);
//        assertElementExistsBy(WebElementsById(AppId("md_button_negative"));
//        verifyText("NO",WebElementById(AppId("md_button_negative"),false);
//        assertElementExistsBy(WebElementsById(AppId("md_button_positive"));
//        verifyText("YES",WebElementById(AppId("md_button_positive"),false);
//        ClickUIElementByID(AppId("md_button_positive");
//        assertElementNotPresentBy(WebElementsById(AppId("downloadCancelImageView"));
//        assertElementNotPresentBy(WebElementsById("Cancel All"));
//        assertElementNotPresentBy(WebElementsById(AppId("installStatusTextView"));
//        assertElementNotPresentBy(WebElementsById(AppId("titleTextView"));
//        assertElementExistsBy(WebElementsById(AppId("emptyStateImageView"));
//        assertElementExistsBy(WebElementsById(AppId("emptyStateTitleTextView"));
//        verifyText("No Downloads in Progress", WebElementById(AppId("emptyStateTitleTextView"),false);
//        assertElementExistsBy(WebElementsById(AppId("emptyStateSubTitleTextView"));
//        verifyText("Content and media currently being downloaded.", WebElementById(AppId("emptyStateSubTitleTextView"),false);
//        ClickUIElementByAccessibilityID("Navigate up");
//        assertElementExistsBy(WebElementsById(AppId("mainToolbarTitleTextView"));
//        verifyText("Downloaded Media", WebElementById(AppId("mainToolbarTitleTextView"),false);
//        //*************** These Assertions are broken because the Empty State of the Downloaded Media Page isn't working properly.
////        assertElementExistsBy(WebElementsById(AppId("emptyStateImageView"));
////        assertElementExistsBy(WebElementsById(AppId("emptyStateTitleTextView"));
////        verifyText("No Downloaded Media", WebElementById(AppId("emptyStateTitleTextView"));
////        assertElementExistsBy(WebElementsById(AppId("emptyStateSubTitleTextView"));
////        verifyText("Download audio or video for offline access.", WebElementById(AppId("emptyStateSubTitleTextView"));
//
//    }


    @Test
    public void settingsScreenLimitMobileNetworkUseSwitch() throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Limit Mobile Network Use");
        assertElementExistsBy(WebElementsByText("Limit Mobile Network Use", false));
        assertSettingsSwitchExpectedStateAndToggle("Limit Mobile Network Use", false);
    }

    //Can't turn off wifi yet
//    @Test
//    public void settingsScreenLimitMobileNetworkUseAttemptToDownloadBook() throws Exception {
//        skipLogin();
//        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
//        ClickUIElementByAccessibilityID("More options");
//        assertElementExistsBy(WebElementsByText("Settings"));
//        ClickUIElementByText("Settings");
//        scrollDownTo("Limit Mobile Network Use");
//        assertElementExistsBy(WebElementsByText("Limit Mobile Network Use"));
//        assertSettingsSwitchExpectedStateAndToggle("Limit Mobile Network Use", false);
//        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
//        ClickUIElementByAccessibilityID("Navigate up");
//        AndroidDriver driver = null;
//
//
//    }

    @Test
    public void settingsScreenThemeRadioButtons() throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        assertElementExistsBy(WebElementsByText("Theme", false));
        assertElementExistsBy(WebElementsByText("Default", false));
        ClickUIElementByText("Theme", false);
        assertElementExistsBy(WebElementsById(AppId("alertTitle")));
        verifyText("Theme", WebElementById(AppId("alertTitle")), false);
        assertElementExistsBy(WebElementsByCheckedText("Default", false));
        Boolean ThemeDefault = Boolean.parseBoolean(WebElementByCheckedText("Default").getAttribute("checked"));
        Boolean ThemeSepia = Boolean.parseBoolean(WebElementByCheckedText("Sepia").getAttribute("checked"));
        Boolean ThemeNight = Boolean.parseBoolean(WebElementByCheckedText("Night").getAttribute("checked"));
        Boolean ThemeDarkBlue = Boolean.parseBoolean(WebElementByCheckedText("Dark Blue").getAttribute("checked"));
        Boolean ThemeMagenta = Boolean.parseBoolean(WebElementByCheckedText("Magenta").getAttribute("checked"));
        assert ThemeDefault;
        assert !ThemeSepia;
        assert !ThemeNight;
        assert !ThemeDarkBlue;
        assert !ThemeMagenta;
        ClickUIElementByCheckedText("Sepia", false);
        assertElementExistsBy(WebElementsByText("Account", false));
        Thread.sleep(milliseconds_1);
        ClickUIElementByText("Theme", false);
        ThemeDefault = Boolean.parseBoolean(WebElementByCheckedText("Default").getAttribute("checked"));
        ThemeSepia = Boolean.parseBoolean(WebElementByCheckedText("Sepia").getAttribute("checked"));
        ThemeNight = Boolean.parseBoolean(WebElementByCheckedText("Night").getAttribute("checked"));
        ThemeDarkBlue = Boolean.parseBoolean(WebElementByCheckedText("Dark Blue").getAttribute("checked"));
        ThemeMagenta = Boolean.parseBoolean(WebElementByCheckedText("Magenta").getAttribute("checked"));
        assert !ThemeDefault;
        assert ThemeSepia;
        assert !ThemeNight;
        assert !ThemeDarkBlue;
        assert !ThemeMagenta;
        ClickUIElementByCheckedText("Night", false);
        assertElementExistsBy(WebElementsByText("Account", false));
        Thread.sleep(milliseconds_1);
        ClickUIElementByText("Theme", false);
        ThemeDefault = Boolean.parseBoolean(WebElementByCheckedText("Default").getAttribute("checked"));
        ThemeSepia = Boolean.parseBoolean(WebElementByCheckedText("Sepia").getAttribute("checked"));
        ThemeNight = Boolean.parseBoolean(WebElementByCheckedText("Night").getAttribute("checked"));
        ThemeDarkBlue = Boolean.parseBoolean(WebElementByCheckedText("Dark Blue").getAttribute("checked"));
        ThemeMagenta = Boolean.parseBoolean(WebElementByCheckedText("Magenta").getAttribute("checked"));
        assert !ThemeDefault;
        assert !ThemeSepia;
        assert ThemeNight;
        assert !ThemeDarkBlue;
        assert !ThemeMagenta;
        ClickUIElementByCheckedText("Dark Blue", false);
        assertElementExistsBy(WebElementsByText("Account", false));
        Thread.sleep(milliseconds_1);
        ClickUIElementByText("Theme", false);
        ThemeDefault = Boolean.parseBoolean(WebElementByCheckedText("Default").getAttribute("checked"));
        ThemeSepia = Boolean.parseBoolean(WebElementByCheckedText("Sepia").getAttribute("checked"));
        ThemeNight = Boolean.parseBoolean(WebElementByCheckedText("Night").getAttribute("checked"));
        ThemeDarkBlue = Boolean.parseBoolean(WebElementByCheckedText("Dark Blue").getAttribute("checked"));
        ThemeMagenta = Boolean.parseBoolean(WebElementByCheckedText("Magenta").getAttribute("checked"));
        assert !ThemeDefault;
        assert !ThemeSepia;
        assert !ThemeNight;
        assert ThemeDarkBlue;
        assert !ThemeMagenta;
        ClickUIElementByCheckedText("Magenta", false);
        assertElementExistsBy(WebElementsByText("Account", false));
        Thread.sleep(milliseconds_1);
        ClickUIElementByText("Theme", false);
        ThemeDefault = Boolean.parseBoolean(WebElementByCheckedText("Default").getAttribute("checked"));
        ThemeSepia = Boolean.parseBoolean(WebElementByCheckedText("Sepia").getAttribute("checked"));
        ThemeNight = Boolean.parseBoolean(WebElementByCheckedText("Night").getAttribute("checked"));
        ThemeDarkBlue = Boolean.parseBoolean(WebElementByCheckedText("Dark Blue").getAttribute("checked"));
        ThemeMagenta = Boolean.parseBoolean(WebElementByCheckedText("Magenta").getAttribute("checked"));
        assert !ThemeDefault;
        assert !ThemeSepia;
        assert !ThemeNight;
        assert !ThemeDarkBlue;
        assert ThemeMagenta;
        Thread.sleep(milliseconds_1);
        verifyText("Cancel", WebElementById("android:id/button2"), true);
        ClickUIElementByID("android:id/button2");
        assertElementExistsBy(WebElementsByText("Account", false));
        Thread.sleep(milliseconds_1);
    }


    @Test
    public void settingsScreenThemeAllThemesTextColorAndFootnoteColor() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "1", "");
        Assert.assertEquals("rgb(33, 34, 37)", getComputedCssUsingXpath("//*[@id='title_number1']", "color"));
        Assert.assertEquals("rgb(23, 124, 156)", getComputedCssUsingXpath("//*[@id='p1']/span/sup", "color"));
        ChangeTheme("Default");
        driver.getPageSource();
        Assert.assertEquals("rgb(33, 34, 37)", getComputedCssUsingXpath("//*[@id='title_number1']", "color"));
        Assert.assertEquals("rgb(23, 124, 156)", getComputedCssUsingXpath("//*[@id='p1']/span/sup", "color"));
        ChangeTheme("Sepia");
        driver.getPageSource();
        Assert.assertEquals("rgb(63, 43, 24)", getComputedCssUsingXpath("//*[@id='title_number1']", "color"));
        Assert.assertEquals("rgb(23, 124, 156)", getComputedCssUsingXpath("//*[@id='p1']/span/sup", "color"));
        ChangeTheme("Night");
        driver.getPageSource();
        Assert.assertEquals("rgb(186, 186, 186)", getComputedCssUsingXpath("//*[@id='title_number1']", "color"));
        Assert.assertEquals("rgb(138, 225, 237)", getComputedCssUsingXpath("//*[@id='p1']/span/sup", "color"));
        ChangeTheme("Dark Blue");
        driver.getPageSource();
        Assert.assertEquals("rgb(33, 34, 37)", getComputedCssUsingXpath("//*[@id='title_number1']", "color"));
        Assert.assertEquals("rgb(23, 124, 156)", getComputedCssUsingXpath("//*[@id='p1']/span/sup", "color"));
        ChangeTheme("Magenta");
        driver.getPageSource();
        Assert.assertEquals("rgb(33, 34, 37)", getComputedCssUsingXpath("//*[@id='title_number1']", "color"));
        Assert.assertEquals("rgb(23, 124, 156)", getComputedCssUsingXpath("//*[@id='p1']/span/sup", "color"));
    }


    @Test
    public void settingsScreenTextSize() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "1", "");
        Assert.assertEquals("18px", getComputedCssUsingXpath("//*[@id='p1']", "font-size"));
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByAccessibilityID("Navigate up");
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Text Size");
        assertElementExistsBy(WebElementsByText("Text Size", false));
        ClickUIElementByText("Text Size", false);
        assertElementExistsBy(WebElementsById(AppId("md_text_title")));
        verifyText("Text Size", WebElementById(AppId("md_text_title")), false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/sampleTextView"));
        verifyText("… behold I say unto you, that by small and simple things are great things brought to pass; and small means in many instances doth confound the wise.", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/sampleTextView"), false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/textSizeSeekbar"));
        ClickSeekBarAt(WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/textSizeSeekbar"), 4);
        assertElementExistsBy(WebElementsById(AppId("md_button_negative")));
        verifyText("Cancel", WebElementById(AppId("md_button_negative")), true);
        assertElementExistsBy(WebElementsById(AppId("md_button_positive")));
        verifyText("OK", WebElementById(AppId("md_button_positive")), false);
        ClickUIElementByID(AppId("md_button_positive"));
        ClickUIElementByAccessibilityID("Navigate up");
        OpenScripture("Book of Mormon", "Jacob", "1", "");
        Assert.assertEquals("21px", getComputedCssUsingXpath("//*[@id='p1']", "font-size"));
    }

    @Test
    public void settingsScreenTextSizeCancelSameContent() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Ether", "1", "1");
        Assert.assertEquals("18px", getComputedCssUsingXpath("//*[@id='p1']", "font-size"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        ClickUIElementByText("Settings", false);
        scrollDownTo("Text Size");
        assertElementExistsBy(WebElementsByText("Text Size", false));
        ClickUIElementByText("Text Size", false);
        assertElementExistsBy(WebElementsById(AppId("md_text_title")));
        verifyText("Text Size", WebElementById(AppId("md_text_title")), false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/sampleTextView"));
        verifyText("… behold I say unto you, that by small and simple things are great things brought to pass; and small means in many instances doth confound the wise.", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/sampleTextView"), false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/textSizeSeekbar"));
        assertElementExistsBy(WebElementsById(AppId("md_button_negative")));
        verifyText("Cancel", WebElementById(AppId("md_button_negative")), true);
        ClickUIElementByID(AppId("md_button_negative"));
        ClickUIElementByAccessibilityID("Navigate up");
        Assert.assertEquals("18px", getComputedCssUsingXpath("//*[@id='p1']", "font-size"));
    }

    @Test
    public void settingsScreenTextSizeChangeSliderThenCancelSameContent() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Ether", "1", "");
        Assert.assertEquals("18px", getComputedCssUsingXpath("//*[@id='p1']", "font-size"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        ClickUIElementByText("Settings", false);
        scrollDownTo("Text Size");
        assertElementExistsBy(WebElementsByText("Text Size", false));
        ClickUIElementByText("Text Size", false);
        assertElementExistsBy(WebElementsById(AppId("md_text_title")));
        verifyText("Text Size", WebElementById(AppId("md_text_title")), false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/sampleTextView"));
        verifyText("… behold I say unto you, that by small and simple things are great things brought to pass; and small means in many instances doth confound the wise.", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/sampleTextView"), false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/textSizeSeekbar"));
        ClickSeekBarAt(WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/textSizeSeekbar"), 7);
        assertElementExistsBy(WebElementsById(AppId("md_button_negative")));
        verifyText("Cancel", WebElementById(AppId("md_button_negative")), true);
        ClickUIElementByID(AppId("md_button_negative"));
        ClickUIElementByAccessibilityID("Navigate up");
        Assert.assertEquals("18px", getComputedCssUsingXpath("//*[@id='p1']", "font-size"));
    }

    @Test
    public void settingsScreenTextSizeAllSizesSameRelatedContentScripture() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "1", "");
        Assert.assertEquals("18px", getComputedCssUsingXpath("//*[@id='p1']", "font-size"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Related Content", false));
        ClickUIElementByText("Related Content", false);
        assertElementExistsBy(WebElementsByText("1a", false));
        ClickUIElementByText("1a", false);
        //Assert.assertEquals("15px",getComputedCssUsingXpath("//*[@id='p27']","font-size"));
        ClickUIElementByXpath("//android.widget.TextView[@text='1a']/../android.widget.ImageButton");
        ClickUIElementByXpath("//android.widget.TextView[@text='Related Content']/../android.widget.ImageButton");
        ChangeTextSize(1);
        Thread.sleep(milliseconds_1);
        Assert.assertEquals("12px", getComputedCssUsingXpath("//*[@id='p1']", "font-size"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Related Content", false));
        ClickUIElementByText("Related Content", false);
        assertElementExistsBy(WebElementsByText("1a", false));
        ClickUIElementByText("1a", false);
        //Assert.assertEquals("12px",getComputedCssUsingXpath("//*[@id='p27']","font-size"));
        ClickUIElementByXpath("//android.widget.TextView[@text='1a']/../android.widget.ImageButton");
        ClickUIElementByXpath("//android.widget.TextView[@text='Related Content']/../android.widget.ImageButton");
        ChangeTextSize(2);
        Thread.sleep(milliseconds_1);
        Assert.assertEquals("15px", getComputedCssUsingXpath("//*[@id='p1']", "font-size"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Related Content", false));
        ClickUIElementByText("Related Content", false);
        assertElementExistsBy(WebElementsByText("1a", false));
        ClickUIElementByText("1a", false);
        //Assert.assertEquals("12px",getComputedCssUsingXpath("//*[@id='p27']","font-size"));
        ClickUIElementByXpath("//android.widget.TextView[@text='1a']/../android.widget.ImageButton");
        ClickUIElementByXpath("//android.widget.TextView[@text='Related Content']/../android.widget.ImageButton");
        ChangeTextSize(3);
        Thread.sleep(milliseconds_1);
        Assert.assertEquals("18px", getComputedCssUsingXpath("//*[@id='p1']", "font-size"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Related Content", false));
        ClickUIElementByText("Related Content", false);
        assertElementExistsBy(WebElementsByText("1a", false));
        ClickUIElementByText("1a", false);
        //Assert.assertEquals("15px",getComputedCssUsingXpath("//*[@id='p27']","font-size"));
        ClickUIElementByXpath("//android.widget.TextView[@text='1a']/../android.widget.ImageButton");
        ClickUIElementByXpath("//android.widget.TextView[@text='Related Content']/../android.widget.ImageButton");
        ChangeTextSize(4);
        Thread.sleep(milliseconds_1);
        Assert.assertEquals("21px", getComputedCssUsingXpath("//*[@id='p1']", "font-size"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Related Content", false));
        ClickUIElementByText("Related Content", false);
        assertElementExistsBy(WebElementsByText("1a", false));
        ClickUIElementByText("1a", false);
        //Assert.assertEquals("18px",getComputedCssUsingXpath("//*[@id='p27']","font-size"));
        ClickUIElementByXpath("//android.widget.TextView[@text='1a']/../android.widget.ImageButton");
        ClickUIElementByXpath("//android.widget.TextView[@text='Related Content']/../android.widget.ImageButton");
        ChangeTextSize(5);
        Thread.sleep(milliseconds_1);
        Assert.assertEquals("26px", getComputedCssUsingXpath("//*[@id='p1']", "font-size"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Related Content", false));
        ClickUIElementByText("Related Content", false);
        assertElementExistsBy(WebElementsByText("1a", false));
        ClickUIElementByText("1a", false);
        //Assert.assertEquals("21px",getComputedCssUsingXpath("//*[@id='p27']","font-size"));
        ClickUIElementByXpath("//android.widget.TextView[@text='1a']/../android.widget.ImageButton");
        ClickUIElementByXpath("//android.widget.TextView[@text='Related Content']/../android.widget.ImageButton");
        ChangeTextSize(6);
        Thread.sleep(milliseconds_1);
        Assert.assertEquals("40px", getComputedCssUsingXpath("//*[@id='p1']", "font-size"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Related Content", false));
        ClickUIElementByText("Related Content", false);
        assertElementExistsBy(WebElementsByText("1a", false));
        ClickUIElementByText("1a", false);
        //System.out.println(getComputedCssUsingXpath("//*[@id='p27']","font-size"));
        ClickUIElementByXpath("//android.widget.TextView[@text='1a']/../android.widget.ImageButton");
        ClickUIElementByXpath("//android.widget.TextView[@text='Related Content']/../android.widget.ImageButton");
        ChangeTextSize(7);
        Thread.sleep(milliseconds_1);
        Assert.assertEquals("60px", getComputedCssUsingXpath("//*[@id='p1']", "font-size"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Related Content", false));
        ClickUIElementByText("Related Content", false);
        assertElementExistsBy(WebElementsByText("1a", false));
        ClickUIElementByText("1a", false);
        //Assert.assertEquals("40px",getComputedCssUsingXpath("//*[@id='p27']","font-size"));
        ClickUIElementByXpath("//android.widget.TextView[@text='1a']/../android.widget.ImageButton");
        ClickUIElementByXpath("//android.widget.TextView[@text='Related Content']/../android.widget.ImageButton");
    }

    @Test
    public void settingsScreenTextSizeOneTitle_Subtitle_Body() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "1", "");
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@id='title1']", "font-size"));
        Assertions.assertEquals("19.8px", getComputedCssUsingXpath("//*[@id='title_number1']", "font-size"));
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@id='study_summary1']", "font-size"));
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@class='body-block']", "font-size"));
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@id='p1']", "font-size"));
        ChangeTextSize(1);
        Assertions.assertEquals("12px", getComputedCssUsingXpath("//*[@id='title1']", "font-size"));
        Assertions.assertEquals("13.2px", getComputedCssUsingXpath("//*[@id='title_number1']", "font-size"));
        Assertions.assertEquals("12px", getComputedCssUsingXpath("//*[@id='study_summary1']", "font-size"));
        Assertions.assertEquals("12px", getComputedCssUsingXpath("//*[@class='body-block']", "font-size"));
        Assertions.assertEquals("12px", getComputedCssUsingXpath("//*[@id='p1']", "font-size"));
    }

    @Test
    public void settingsScreenTextSizeTwoTitle_Subtitle_Body() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "1", "");
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@id='title1']", "font-size"));
        Assertions.assertEquals("19.8px", getComputedCssUsingXpath("//*[@id='title_number1']", "font-size"));
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@id='study_summary1']", "font-size"));
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@class='body-block']", "font-size"));
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@id='p1']", "font-size"));
        ChangeTextSize(2);
        Assertions.assertEquals("15px", getComputedCssUsingXpath("//*[@id='title1']", "font-size"));
        Assertions.assertEquals("16.5px", getComputedCssUsingXpath("//*[@id='title_number1']", "font-size"));
        Assertions.assertEquals("15px", getComputedCssUsingXpath("//*[@id='study_summary1']", "font-size"));
        Assertions.assertEquals("15px", getComputedCssUsingXpath("//*[@class='body-block']", "font-size"));
        Assertions.assertEquals("15px", getComputedCssUsingXpath("//*[@id='p1']", "font-size"));
    }

    @Test
    public void settingsScreenTextSizeThreeTitle_Subtitle_Body() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "1", "");
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@id='title1']", "font-size"));
        Assertions.assertEquals("19.8px", getComputedCssUsingXpath("//*[@id='title_number1']", "font-size"));
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@id='study_summary1']", "font-size"));
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@class='body-block']", "font-size"));
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@id='p1']", "font-size"));
        ChangeTextSize(3);
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@id='title1']", "font-size"));
        Assertions.assertEquals("19.8px", getComputedCssUsingXpath("//*[@id='title_number1']", "font-size"));
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@id='study_summary1']", "font-size"));
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@class='body-block']", "font-size"));
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@id='p1']", "font-size"));
    }

    @Test
    public void settingsScreenTextSizeFourTitle_Subtitle_Body() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "1", "");
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@id='title1']", "font-size"));
        Assertions.assertEquals("19.8px", getComputedCssUsingXpath("//*[@id='title_number1']", "font-size"));
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@id='study_summary1']", "font-size"));
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@class='body-block']", "font-size"));
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@id='p1']", "font-size"));
        ChangeTextSize(4);
        Assertions.assertEquals("21px", getComputedCssUsingXpath("//*[@id='title1']", "font-size"));
        Assertions.assertEquals("23.1px", getComputedCssUsingXpath("//*[@id='title_number1']", "font-size"));
        Assertions.assertEquals("21px", getComputedCssUsingXpath("//*[@id='study_summary1']", "font-size"));
        Assertions.assertEquals("21px", getComputedCssUsingXpath("//*[@class='body-block']", "font-size"));
        Assertions.assertEquals("21px", getComputedCssUsingXpath("//*[@id='p1']", "font-size"));
    }

    @Test
    public void settingsScreenTextSizeFiveTitle_Subtitle_Body() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "1", "");
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@id='title1']", "font-size"));
        Assertions.assertEquals("19.8px", getComputedCssUsingXpath("//*[@id='title_number1']", "font-size"));
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@id='study_summary1']", "font-size"));
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@class='body-block']", "font-size"));
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@id='p1']", "font-size"));
        ChangeTextSize(5);
        Assertions.assertEquals("26px", getComputedCssUsingXpath("//*[@id='title1']", "font-size"));
        Assertions.assertEquals("28.6px", getComputedCssUsingXpath("//*[@id='title_number1']", "font-size"));
        Assertions.assertEquals("26px", getComputedCssUsingXpath("//*[@id='study_summary1']", "font-size"));
        Assertions.assertEquals("26px", getComputedCssUsingXpath("//*[@class='body-block']", "font-size"));
        Assertions.assertEquals("26px", getComputedCssUsingXpath("//*[@id='p1']", "font-size"));
    }

    @Test
    public void settingsScreenTextSizeSixTitle_Subtitle_Body() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "1", "");
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@id='title1']", "font-size"));
        Assertions.assertEquals("19.8px", getComputedCssUsingXpath("//*[@id='title_number1']", "font-size"));
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@id='study_summary1']", "font-size"));
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@class='body-block']", "font-size"));
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@id='p1']", "font-size"));
        ChangeTextSize(6);
        Assertions.assertEquals("40px", getComputedCssUsingXpath("//*[@id='title1']", "font-size"));
        Assertions.assertEquals("44px", getComputedCssUsingXpath("//*[@id='title_number1']", "font-size"));
        Assertions.assertEquals("40px", getComputedCssUsingXpath("//*[@id='study_summary1']", "font-size"));
        Assertions.assertEquals("40px", getComputedCssUsingXpath("//*[@class='body-block']", "font-size"));
        Assertions.assertEquals("40px", getComputedCssUsingXpath("//*[@id='p1']", "font-size"));
    }

    @Test
    public void settingsScreenTextSizeSevenTitle_Subtitle_Body() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "1", "");
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@id='title1']", "font-size"));
        Assertions.assertEquals("19.8px", getComputedCssUsingXpath("//*[@id='title_number1']", "font-size"));
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@id='study_summary1']", "font-size"));
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@class='body-block']", "font-size"));
        Assertions.assertEquals("18px", getComputedCssUsingXpath("//*[@id='p1']", "font-size"));
        ChangeTextSize(7);
        Assertions.assertEquals("60px", getComputedCssUsingXpath("//*[@id='title1']", "font-size"));
        Assertions.assertEquals("66px", getComputedCssUsingXpath("//*[@id='title_number1']", "font-size"));
        Assertions.assertEquals("60px", getComputedCssUsingXpath("//*[@id='study_summary1']", "font-size"));
        Assertions.assertEquals("60px", getComputedCssUsingXpath("//*[@class='body-block']", "font-size"));
        Assertions.assertEquals("60px", getComputedCssUsingXpath("//*[@id='p1']", "font-size"));
    }

    @Test
    public void settingsScreenListModeSwitch() throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("List Mode");
        assertElementExistsBy(WebElementsByText("List Mode", false));
        assertSettingsSwitchExpectedStateAndToggle("List Mode", false);
    }

    @Test
    public void settingsScreenListModeSwitchPersists() throws Exception {
        skipLogin();
        assertSettingsSwitchExpectedStateAndTogglePersists("List Mode", false);
    }

    @Test
    public void settingsScreenListModeLibraryScreenScripturesWidth() throws Exception {
        skipLogin();
        int screenWidth = driver.manage().window().getSize().getWidth();
        WebElement scriptureParent = WebElementByXpath("(//android.widget.TextView[@text='Scriptures'])/..");
        assertNotEquals(screenWidth, scriptureParent.getSize().getWidth());
        System.out.println("Screen width is: " + screenWidth + " Element width is: " + scriptureParent.getSize().getWidth());
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("List Mode");
        assertElementExistsBy(WebElementsByText("List Mode", false));
        assertSettingsSwitchExpectedStateAndToggle("List Mode", false);
        ClickUIElementByAccessibilityID("Navigate up");
        screenWidth = driver.manage().window().getSize().getWidth();
        scriptureParent = WebElementByXpath("(//android.widget.TextView[@text='Scriptures'])" + isAndroidVersion("[2]", "[1]") + "/..");
        System.out.println("Screen width is: " + screenWidth + " Element width is: " + scriptureParent.getSize().getWidth());
        assertEquals(screenWidth, scriptureParent.getSize().getWidth());
    }

    @Test
    public void settingsScreenListModeLibraryContentScreenCategories() throws Exception {
        //Skip Login
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("List Mode");
        assertElementExistsBy(WebElementsByText("List Mode", false));
        assertSettingsSwitchExpectedStateAndToggle("List Mode", false);
        ClickUIElementByAccessibilityID("Navigate up");

        assertElementExistsBy(WebElementsById(AppId("mainToolbarTitleTextView")));
        verifyText("Library", WebElementById(AppId("mainToolbarTitleTextView")), false);
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmarks"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        int screenWidth = driver.manage().window().getSize().getWidth();
        scrollDownTo("Scriptures");
        assertElementExistsBy(WebElementsByXpath("(//android.widget.TextView[@text=\"" + isAllCaps("Scriptures") + "\"])[1]/.."));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text=\"" + isAllCaps("Scriptures") + "\"])[1]/../..").getSize().getWidth());
        assertElementExistsBy(WebElementsByXpath("(//android.widget.TextView[@text=\"Scriptures\"])" + isAndroidVersion("[2]", "[1]") + "/.."));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Scriptures'])" + isAndroidVersion("[2]", "[1]") + "/..").getSize().getWidth());
        scrollDownTo("Come, Follow Me");
        assertElementExistsBy(WebElementsByText("Come, Follow Me", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Come, Follow Me'])/..").getSize().getWidth());
        scrollDownTo("General Conference");
        assertElementExistsBy(WebElementsByText("General Conference", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='General Conference'])/..").getSize().getWidth());
        scrollDownTo("MY COLLECTIONS");
        assertElementExistsBy(WebElementsByText("My Collections", true));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text=\"" + isAllCaps("My Collections") + "\"])/../..").getSize().getWidth());
        scrollDownTo("Notes");
        assertElementExistsBy(WebElementsByText("Notes", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Notes'])/..").getSize().getWidth());
        scrollDownTo("Study Plans");
        assertElementExistsBy(WebElementsByText("Study Plans", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Study Plans'])/..").getSize().getWidth());
        scrollDownTo("INSPIRATION");
        assertElementExistsBy(WebElementsByText("Inspiration", true));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text=\"" + isAllCaps("Inspiration") + "\"])/../..").getSize().getWidth());
        scrollDownTo("Music");
        assertElementExistsBy(WebElementsByText("Music", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Music'])/..").getSize().getWidth());
        scrollDownTo("Magazines");
        assertElementExistsBy(WebElementsByText("Magazines", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Magazines'])/..").getSize().getWidth());
        scrollDownTo("Seminaries and Institutes");
        assertElementExistsBy(WebElementsByText("Seminaries and Institutes", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Seminaries and Institutes'])/..").getSize().getWidth());
        scrollDownTo("Teachings of Presidents");
        assertElementExistsBy(WebElementsByText("Teachings of Presidents", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Teachings of Presidents'])/..").getSize().getWidth());
        scrollDownTo("Videos");
        assertElementExistsBy(WebElementsByText("Videos", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Videos'])/..").getSize().getWidth());
        scrollDownTo("Topics");
        assertElementExistsBy(WebElementsByText("Topics", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Topics'])/..").getSize().getWidth());
        scrollDownTo("Jesus Christ");
        assertElementExistsBy(WebElementsByText("Jesus Christ", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Jesus Christ'])/..").getSize().getWidth());
        scrollDownTo("Missionary");
        assertElementExistsBy(WebElementsByText("Missionary", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Missionary'])/..").getSize().getWidth());
        scrollDownTo("AUDIENCES");
        assertElementExistsBy(WebElementsByText("Audiences", true));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text=\"" + isAllCaps("Audiences") + "\"])/../..").getSize().getWidth());
        scrollDownTo("Individuals and Families");
        assertElementExistsBy(WebElementsByText("Individuals and Families", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Individuals and Families'])/..").getSize().getWidth());
        scrollDownTo("Young Adults");
        assertElementExistsBy(WebElementsByText("Young Adults", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Young Adults'])/..").getSize().getWidth());
        scrollDownTo("Youth");
        assertElementExistsBy(WebElementsByText("Youth", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Youth'])/..").getSize().getWidth());
        scrollDownTo("Children");
        assertElementExistsBy(WebElementsByText("Children", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Children'])/..").getSize().getWidth());
        scrollDownTo("Leaders");
        assertElementExistsBy(WebElementsByText("Leaders", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Leaders'])/..").getSize().getWidth());
        scrollDownTo("OTHER");
        assertElementExistsBy(WebElementsByText("Other", true));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text=\"" + isAllCaps("Other") + "\"])/../..").getSize().getWidth());
        scrollDownTo("Church History");
        assertElementExistsBy(WebElementsByText("Church History", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Church History'])/..").getSize().getWidth());
        scrollDownTo("Temple and Family History");
        assertElementExistsBy(WebElementsByText("Temple and Family History", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Temple and Family History'])/..").getSize().getWidth());
        scrollDownTo("Life Help");
        assertElementExistsBy(WebElementsByText("Life Help", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Life Help'])/..").getSize().getWidth());
        scrollDownTo("Self-Reliance");
        assertElementExistsBy(WebElementsByText("Self-Reliance", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Self-Reliance'])/..").getSize().getWidth());


        ClickUIElementByAccessibilityID("More options");
        Thread.sleep(milliseconds_1);
        assertElementExistsBy(WebElementsByText("New Screen", false));
        assertElementExistsBy(WebElementsByText("Custom Collections", false));
        assertElementExistsBy(WebElementsByText("Language", false));
        assertElementExistsBy(WebElementsByText("Settings", false));
    }

    @Test
    public void settingsScreenListModeScripturesContentScreenCategories() throws Exception {
        //Skip Login
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("List Mode");
        assertElementExistsBy(WebElementsByText("List Mode", false));
        assertSettingsSwitchExpectedStateAndToggle("List Mode", false);
        ClickUIElementByAccessibilityID("Navigate up");

        assertElementExistsBy(WebElementsById(AppId("mainToolbarTitleTextView")));
        verifyText("Library", WebElementById(AppId("mainToolbarTitleTextView")), false);
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmarks"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        int screenWidth = driver.manage().window().getSize().getWidth();
        scrollDownTo("Scriptures");
        assertElementExistsBy(WebElementsByXpath("(//android.widget.TextView[@text=\"" + isAllCaps("Scriptures") + "\"])[1]/.."));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text=\"" + isAllCaps("Scriptures") + "\"])[1]/../..").getSize().getWidth());
        assertElementExistsBy(WebElementsByXpath("(//android.widget.TextView[@text='Scriptures'])" + isAndroidVersion("[2]", "[1]") + "/.."));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Scriptures'])" + isAndroidVersion("[2]", "[1]") + "/..").getSize().getWidth());
        WebElementByXpath("(//android.widget.TextView[@text='Scriptures'])" + isAndroidVersion("[2]", "[1]") + "/..").click();
        assertElementExistsBy(WebElementsByXpath("(//android.widget.TextView[@text='Scriptures'])[1]"));
        assertElementExistsBy(WebElementsByXpath("(//android.widget.TextView[@text='Scriptures'])" + isAndroidVersion("[2]", "[1]")));
        scrollDownTo("Old Testament");
        assertElementExistsBy(WebElementsByText("Old Testament", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Old Testament'])/..").getSize().getWidth());
        scrollDownTo("New Testament");
        assertElementExistsBy(WebElementsByText("New Testament", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='New Testament'])/..").getSize().getWidth());
        scrollDownTo("Book of Mormon");
        assertElementExistsBy(WebElementsByText("Book of Mormon", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Book of Mormon'])/..").getSize().getWidth());
        scrollDownTo("Doctrine and Covenants");
        assertElementExistsBy(WebElementsByText("Doctrine and Covenants", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Doctrine and Covenants'])/..").getSize().getWidth());
        scrollDownTo("Pearl of Great Price");
        assertElementExistsBy(WebElementsByText("Pearl of Great Price", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Pearl of Great Price'])/..").getSize().getWidth());
        scrollDownTo(isAllCaps("Study Helps"));
        assertElementExistsBy(WebElementsByText("Study Helps", true));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text=\"" + isAllCaps("Study Helps") + "\"])/../..").getSize().getWidth());
        scrollDownTo("Guide to the Scriptures");
        assertElementExistsBy(WebElementsByText("Guide to the Scriptures", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Guide to the Scriptures'])/..").getSize().getWidth());
        scrollDownTo("Topical Guide");
        assertElementExistsBy(WebElementsByText("Topical Guide", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Topical Guide'])/..").getSize().getWidth());
        scrollDownTo("Bible Dictionary");
        assertElementExistsBy(WebElementsByText("Bible Dictionary", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Bible Dictionary'])/..").getSize().getWidth());
        scrollDownTo("Bible Chronology");
        assertElementExistsBy(WebElementsByText("Bible Chronology", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Bible Chronology'])/..").getSize().getWidth());
        scrollDownTo("Harmony of the Gospels");
        assertElementExistsBy(WebElementsByText("Harmony of the Gospels", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Harmony of the Gospels'])/..").getSize().getWidth());
        scrollDownTo("Joseph Smith Translation Appendix");
        assertElementExistsBy(WebElementsByText("Joseph Smith Translation Appendix", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Joseph Smith Translation Appendix'])/..").getSize().getWidth());
        scrollDownTo("Bible Maps");
        assertElementExistsBy(WebElementsByText("Bible Maps", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Bible Maps'])/..").getSize().getWidth());
        scrollDownTo("Bible Photographs");
        assertElementExistsBy(WebElementsByText("Bible Photographs", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Bible Photographs'])/..").getSize().getWidth());
        scrollDownTo("Index to the Triple Combination");
        assertElementExistsBy(WebElementsByText("Index to the Triple Combination", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Index to the Triple Combination'])/..").getSize().getWidth());
        scrollDownTo("Church History Maps");
        assertElementExistsBy(WebElementsByText("Church History Maps", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Church History Maps'])/..").getSize().getWidth());
        scrollDownTo("Church History Photographs");
        assertElementExistsBy(WebElementsByText("Church History Photographs", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Church History Photographs'])/..").getSize().getWidth());
        scrollDownTo("Abbreviations");
        assertElementExistsBy(WebElementsByText("Abbreviations", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Abbreviations'])/..").getSize().getWidth());
        scrollDownTo("About the Scriptures");
        assertElementExistsBy(WebElementsByText("About the Scriptures", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='About the Scriptures'])/..").getSize().getWidth());
    }

    @Test
    public void settingsScreenListModeScripturesScripturesScreenCategories() throws Exception {
        //Skip Login
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("List Mode");
        assertElementExistsBy(WebElementsByText("List Mode", false));
        assertSettingsSwitchExpectedStateAndToggle("List Mode", false);
        ClickUIElementByAccessibilityID("Navigate up");

        assertElementExistsBy(WebElementsById(AppId("mainToolbarTitleTextView")));
        verifyText("Library", WebElementById(AppId("mainToolbarTitleTextView")), false);
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmarks"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        int screenWidth = driver.manage().window().getSize().getWidth();
        scrollDownTo("Scriptures");
        assertElementExistsBy(WebElementsByXpath("(//android.widget.TextView[@text=\"" + isAllCaps("Scriptures") + "\"])[1]/.."));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text=\"" + isAllCaps("Scriptures") + "\"])[1]/../..").getSize().getWidth());
        assertElementExistsBy(WebElementsByXpath("(//android.widget.TextView[@text='Scriptures'])" + isAndroidVersion("[2]", "[1]") + "/.."));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Scriptures'])" + isAndroidVersion("[2]", "[1]") + "/..").getSize().getWidth());
        WebElementByXpath("(//android.widget.TextView[@text='Scriptures'])" + isAndroidVersion("[2]", "[1]") + "/..").click();
        assertElementExistsBy(WebElementsByXpath("(//android.widget.TextView[@text='Scriptures'])[1]"));
        assertElementExistsBy(WebElementsByXpath("(//android.widget.TextView[@text=\"" + isAllCaps("Scriptures") + "\"])" + isAndroidVersion("[2]", "[1]")));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text=\"" + isAllCaps("Scriptures") + "\"])" + isAndroidVersion("[2]", "[1]") + "/../..").getSize().getWidth());
        scrollDownTo("Old Testament");
        assertElementExistsBy(WebElementsByText("Old Testament", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Old Testament'])/..").getSize().getWidth());
        scrollDownTo("New Testament");
        assertElementExistsBy(WebElementsByText("New Testament", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='New Testament'])/..").getSize().getWidth());
        scrollDownTo("Book of Mormon");
        assertElementExistsBy(WebElementsByText("Book of Mormon", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Book of Mormon'])/..").getSize().getWidth());
        scrollDownTo("Doctrine and Covenants");
        assertElementExistsBy(WebElementsByText("Doctrine and Covenants", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Doctrine and Covenants'])/..").getSize().getWidth());
        scrollDownTo("Pearl of Great Price");
        assertElementExistsBy(WebElementsByText("Pearl of Great Price", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Pearl of Great Price'])/..").getSize().getWidth());
        scrollDownTo(isAllCaps("Study Helps"));
        assertElementExistsBy(WebElementsByText("Study Helps", true));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text=\"" + isAllCaps("Study Helps") + "\"])/../..").getSize().getWidth());
        scrollDownTo("Guide to the Scriptures");
        assertElementExistsBy(WebElementsByText("Guide to the Scriptures", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Guide to the Scriptures'])/..").getSize().getWidth());
        scrollDownTo("Topical Guide");
        assertElementExistsBy(WebElementsByText("Topical Guide", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Topical Guide'])/..").getSize().getWidth());
        scrollDownTo("Bible Dictionary");
        assertElementExistsBy(WebElementsByText("Bible Dictionary", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Bible Dictionary'])/..").getSize().getWidth());
        scrollDownTo("Bible Chronology");
        assertElementExistsBy(WebElementsByText("Bible Chronology", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Bible Chronology'])/..").getSize().getWidth());
        scrollDownTo("Harmony of the Gospels");
        assertElementExistsBy(WebElementsByText("Harmony of the Gospels", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Harmony of the Gospels'])/..").getSize().getWidth());
        scrollDownTo("Joseph Smith Translation Appendix");
        assertElementExistsBy(WebElementsByText("Joseph Smith Translation Appendix", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Joseph Smith Translation Appendix'])/..").getSize().getWidth());
        scrollDownTo("Bible Maps");
        assertElementExistsBy(WebElementsByText("Bible Maps", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Bible Maps'])/..").getSize().getWidth());
        scrollDownTo("Bible Photographs");
        assertElementExistsBy(WebElementsByText("Bible Photographs", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Bible Photographs'])/..").getSize().getWidth());
        scrollDownTo("Index to the Triple Combination");
        assertElementExistsBy(WebElementsByText("Index to the Triple Combination", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Index to the Triple Combination'])/..").getSize().getWidth());
        scrollDownTo("Church History Maps");
        assertElementExistsBy(WebElementsByText("Church History Maps", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Church History Maps'])/..").getSize().getWidth());
        scrollDownTo("Church History Photographs");
        assertElementExistsBy(WebElementsByText("Church History Photographs", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Church History Photographs'])/..").getSize().getWidth());
        scrollDownTo("Abbreviations");
        assertElementExistsBy(WebElementsByText("Abbreviations", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='Abbreviations'])/..").getSize().getWidth());
        scrollDownTo("About the Scriptures");
        assertElementExistsBy(WebElementsByText("About the Scriptures", false));
        assertEquals(screenWidth, WebElementByXpath("(//android.widget.TextView[@text='About the Scriptures'])/..").getSize().getWidth());
    }


    @Test
    public void settingsScreenHideFootnotesSwitch() throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Hide Footnotes");
        assertElementExistsBy(WebElementsByText("Hide Footnotes", false));
        assertSettingsSwitchExpectedStateAndToggle("Hide Footnotes", false);
    }

    @Test
    public void settingsScreenHideFootnotesSwitchPersists() throws Exception {
        skipLogin();
        assertSettingsSwitchExpectedStateAndTogglePersists("Hide Footnotes", false);
    }

    @Test
    public void settingsScreenHideFootnotesInContent() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Enos", "", "1");
        assertEquals("inline", getComputedCssUsingXpath("//*[@id='p1']/span/sup", "display"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Hide Footnotes");
        assertElementExistsBy(WebElementsByText("Hide Footnotes", false));
        assertSettingsSwitchExpectedStateAndToggle("Hide Footnotes", false);
        ClickUIElementByAccessibilityID("Navigate up");
        Thread.sleep(milliseconds_1);
        assertEquals("none", getComputedCssUsingXpath("//*[@id='p1']/span/sup", "display"));
    }

    @Test
    public void settingsScreenHideFootnotesInContentTextColor() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Enos", "", "");
        assertEquals("rgb(23, 124, 156)", getComputedCssUsingXpath("//*[@class='study-note-ref']", "color"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Hide Footnotes");
        assertElementExistsBy(WebElementsByText("Hide Footnotes", false));
        assertSettingsSwitchExpectedStateAndToggle("Hide Footnotes", false);
        ClickUIElementByAccessibilityID("Navigate up");
        Thread.sleep(milliseconds_1);
        assertEquals("rgb(33, 34, 37)", getComputedCssUsingXpath("//*[@class='study-note-ref']", "color"));
    }

    @Test
    public void settingsScreenHideFootnotesInContentTextColorThenShow() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Enos", "", "");
        assertEquals("rgb(23, 124, 156)", getComputedCssUsingXpath("//*[@class='study-note-ref']", "color"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Hide Footnotes");
        assertElementExistsBy(WebElementsByText("Hide Footnotes", false));
        assertSettingsSwitchExpectedStateAndToggle("Hide Footnotes", false);
        ClickUIElementByAccessibilityID("Navigate up");
        Thread.sleep(milliseconds_1);
        assertEquals("rgb(33, 34, 37)", getComputedCssUsingXpath("//*[@class='study-note-ref']", "color"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Hide Footnotes");
        assertElementExistsBy(WebElementsByText("Hide Footnotes", false));
        assertSettingsSwitchExpectedStateAndToggle("Hide Footnotes", true);
        ClickUIElementByAccessibilityID("Navigate up");
        Thread.sleep(milliseconds_1);
        assertEquals("rgb(23, 124, 156)", getComputedCssUsingXpath("//*[@class='study-note-ref']", "color"));
    }


    @Test
    public void settingsScreenHideFootnotesInContentThenShow() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Enos", "", "1");
        assertEquals("inline", getComputedCssUsingXpath("//*[@id='p1']/span/sup", "display"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Hide Footnotes");
        assertElementExistsBy(WebElementsByText("Hide Footnotes", false));
        assertSettingsSwitchExpectedStateAndToggle("Hide Footnotes", false);
        ClickUIElementByAccessibilityID("Navigate up");
        Thread.sleep(milliseconds_1);
        assertEquals("none", getComputedCssUsingXpath("//*[@id='p1']/span/sup", "display"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Hide Footnotes");
        assertElementExistsBy(WebElementsByText("Hide Footnotes", false));
        assertSettingsSwitchExpectedStateAndToggle("Hide Footnotes", true);
        ClickUIElementByAccessibilityID("Navigate up");
        Thread.sleep(milliseconds_1);
        assertEquals("inline", getComputedCssUsingXpath("//*[@id='p1']/span/sup", "display"));
    }

    @Test
    public void settingsScreenHideFootnotesInContentDCJumpLinks() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Enos", "", "1");
        assertEquals("inline", getComputedCssUsingXpath("//*[@id='p1']/span/sup", "display"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Hide Footnotes");
        assertElementExistsBy(WebElementsByText("Hide Footnotes", false));
        assertSettingsSwitchExpectedStateAndToggle("Hide Footnotes", false);
        ClickUIElementByAccessibilityID("Navigate up");
        Thread.sleep(milliseconds_1);
        assertEquals("none", getComputedCssUsingXpath("//*[@id='p1']/span/sup", "display"));
    }

    @Test
    public void settingsScreenHideFootnotesInContentTextColorDCJumpLinks() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Enos", "", "");
        assertEquals("rgb(23, 124, 156)", getComputedCssUsingXpath("//*[@class='study-note-ref']", "color"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Hide Footnotes");
        assertElementExistsBy(WebElementsByText("Hide Footnotes", false));
        assertSettingsSwitchExpectedStateAndToggle("Hide Footnotes", false);
        ClickUIElementByAccessibilityID("Navigate up");
        Thread.sleep(milliseconds_1);
        swipeLeft();
        swipeRight();
        assertEquals("rgb(33, 34, 37)", getComputedCssUsingXpath("//*[@class='study-note-ref']", "color"));
    }


    @Test
    public void settingsScreenShowScreensAsSeparateWindowsSwitch() throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Screen Settings");
        ClickUIElementByText("Screen Settings", false);
        assertElementExistsBy(WebElementsByText("Show Screens as Separate Windows", false));
        assertSettingsSwitchExpectedStateAndToggle("Show Screens as Separate Windows", true);
    }

    @Test
    public void settingsScreenShowScreensAsSeparateWindowsSwitchPersists() throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Screen Settings");
        ClickUIElementByText("Screen Settings", false);
        assertSettingsSwitchExpectedStateAndToggle("Show Screens as Separate Windows", true);
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByAccessibilityID("Navigate up");
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Screen Settings");
        ClickUIElementByText("Screen Settings", false);
        assertSettingsSwitchExpectedStateAndToggle("Show Screens as Separate Windows", false);
    }

    @Test
    public void settingsScreenShowScreensAsSeparateWindowsSwitchCheckTwoScreensOptionOnToOffFromMainScreen() throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("New Screen", false));
        ClickUIElementByText("New Screen", false);
        ClickUIElementByText("Scriptures", false);
        ((AndroidDriver) driver).pressKeyCode(187);
        Thread.sleep(milliseconds_1);
        driver.getPageSource();
        assertElementExistsBy(WebElementsByText("Library", false));
        assertElementExistsBy(WebElementsByText("Scriptures", false));
        ClickUIElementByText("Library", false);
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Screen Settings");
        ClickUIElementByText("Screen Settings", false);
        assertElementExistsBy(WebElementsByText("Show Screens as Separate Windows", false));
        assertSettingsSwitchExpectedStateAndToggle("Show Screens as Separate Windows", true);
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByAccessibilityID("Navigate up");
        ((AndroidDriver) driver).pressKeyCode(187);
        Thread.sleep(milliseconds_1);
        driver.getPageSource();
        assertElementExistsBy(WebElementsByText("Library", false));
        assertElementNotPresentBy(WebElementsByText("Scriptures", false));
        Thread.sleep(milliseconds_2);
    }

    @Test
    public void settingsScreenShowScreensAsSeparateWindowsSwitchCheckTwoScreensOptionOnToOffFromSecondaryScreen() throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("New Screen", false));
        ClickUIElementByText("New Screen", false);
        ClickUIElementByText("Scriptures", false);
        ((AndroidDriver) driver).pressKeyCode(187);
        Thread.sleep(milliseconds_1);
        driver.getPageSource();
        assertElementExistsBy(WebElementsByText("Library", false));
        assertElementExistsBy(WebElementsByText("Scriptures", false));
        ClickUIElementByText("Scriptures", false);
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Screen Settings");
        ClickUIElementByText("Screen Settings", false);
        assertElementExistsBy(WebElementsByText("Show Screens as Separate Windows", false));
        assertSettingsSwitchExpectedStateAndToggle("Show Screens as Separate Windows", true);
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByAccessibilityID("Navigate up");
        ((AndroidDriver) driver).pressKeyCode(187);
        Thread.sleep(milliseconds_1);
        driver.getPageSource();
        assertElementExistsBy(WebElementsByText("Library", false));
        assertElementNotPresentBy(WebElementsByText("Scriptures", false));
        Thread.sleep(milliseconds_2);
    }

    @Test
    public void settingsScreenShowScreensAsSeparateWindowsSwitchCheckOffToOnAddScreen() throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("New Screen", false));
        ClickUIElementByText("New Screen", false);
        ClickUIElementByText("Scriptures", false);
        ((AndroidDriver) driver).pressKeyCode(187);
        Thread.sleep(milliseconds_1);
        driver.getPageSource();
        assertElementExistsBy(WebElementsByText("Library", false));
        assertElementExistsBy(WebElementsByText("Scriptures", false));
        ClickUIElementByText("Library", false);
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Screen Settings");
        ClickUIElementByText("Screen Settings", false);
        assertElementExistsBy(WebElementsByText("Show Screens as Separate Windows", false));
        assertSettingsSwitchExpectedStateAndToggle("Show Screens as Separate Windows", true);
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByAccessibilityID("Navigate up");
        ((AndroidDriver) driver).pressKeyCode(187);
        Thread.sleep(milliseconds_1);
        driver.getPageSource();
        assertElementExistsBy(WebElementsByText("Library", false));
        assertElementNotPresentBy(WebElementsByText("Scriptures", false));
        Thread.sleep(milliseconds_2);
        ClickUIElementByText("Library", false);
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Screen Settings");
        ClickUIElementByText("Screen Settings", false);
        assertElementExistsBy(WebElementsByText("Show Screens as Separate Windows", false));
        assertSettingsSwitchExpectedStateAndToggle("Show Screens as Separate Windows", false);
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByAccessibilityID("Navigate up");
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("New Screen", false));
        ClickUIElementByText("New Screen", false);
        ClickUIElementByText("General Conference", false);
        ((AndroidDriver) driver).pressKeyCode(187);
        assertElementExistsBy(WebElementsByText("General Conference", false));
        assertElementExistsBy(WebElementsByText("Library", false));

    }

    @Test
    public void settingsScreenShowScreensAsSeparateWindowsSwitchCheckOffAddScreen() throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("New Screen", false));
        ClickUIElementByText("New Screen", false);
        ClickUIElementByText("Scriptures", false);
        ((AndroidDriver) driver).pressKeyCode(187);
        Thread.sleep(milliseconds_1);
        driver.getPageSource();
        assertElementExistsBy(WebElementsByText("Library", false));
        assertElementExistsBy(WebElementsByText("Scriptures", false));
        ClickUIElementByText("Library", false);
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Screen Settings");
        ClickUIElementByText("Screen Settings", false);
        assertElementExistsBy(WebElementsByText("Show Screens as Separate Windows", false));
        assertSettingsSwitchExpectedStateAndToggle("Show Screens as Separate Windows", true);
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByAccessibilityID("Navigate up");
        ((AndroidDriver) driver).pressKeyCode(187);
        Thread.sleep(milliseconds_1);
        driver.getPageSource();
        assertElementExistsBy(WebElementsByText("Library", false));
        assertElementNotPresentBy(WebElementsByText("Scriptures", false));
        Thread.sleep(milliseconds_2);
        ClickUIElementByText("Library", false);
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("New Screen", false));
        ClickUIElementByText("New Screen", false);
        ClickUIElementByText("General Conference", false);
        verifyText("General Conference", WebElementById(AppId("mainToolbarTitleTextView")), false);
        ((AndroidDriver) driver).pressKeyCode(187);
        Thread.sleep(milliseconds_1);
        assertElementExistsBy(WebElementsByText("Library", false));
        assertElementNotPresentBy(WebElementsByText("General Conference", false));
        assertElementNotPresentBy(WebElementsByText("Scriptures", false));
    }

    //Show Obsolete Content
    @Test
    public void settingsScreenShowObsoleteContentSwitch() throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Show Obsolete Content");
        assertElementExistsBy(WebElementsByText("Show Obsolete Content", false));
        assertSettingsSwitchExpectedStateAndToggle("Show Obsolete Content", false);
    }

    @Test
    public void settingsScreenShowObsoleteContentSwitchPersists() throws Exception {
        skipLogin();
        assertSettingsSwitchExpectedStateAndTogglePersists("Show Obsolete Content", false);
    }

    @Test
    public void settingsScreenShowObsoleteContent() throws Exception {
        //Checks against Primary Sharing Time Manuals from previous years
        skipLogin();
        scrollDownTo("Come, Follow Me");
        ClickUIElementByText("Come, Follow Me", false);
        scrollDownTo("Other Resources");
        ClickUIElementByText("Other Resources", false);
        assertElementNotPresentBy(WebElementsByText("Instructions for Curriculum 2018", false));
        assertElementNotPresentBy(WebElementsByText("Instructions for Curriculum 2017", false));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Show Obsolete Content");
        assertElementExistsBy(WebElementsByText("Show Obsolete Content", false));
        assertSettingsSwitchExpectedStateAndToggle("Show Obsolete Content", false);
        ClickUIElementByAccessibilityID("Navigate up");
        scrollDownTo("Instructions for Curriculum 2018");
        assertElementExistsBy(WebElementsByText("Instructions for Curriculum 2018", false));
        scrollDownTo("Instructions for Curriculum 2017");
        assertElementExistsBy(WebElementsByText("Instructions for Curriculum 2017", false));

    }

    //No current way to guarantee an inapp notification will fire, can only test setting is on the screen, and can be switched
    @Test
    public void settingsScreenAllowInAppNotificationsSwitch() throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Allow In-App Notifications");
        assertElementExistsBy(WebElementsByText("Allow In-App Notifications", false));
        assertSettingsSwitchExpectedStateAndToggle("Allow In-App Notifications", true);

    }

    @Test
    public void settingsScreenAllowInAppNotificationsSwitchPersists() throws Exception {
        skipLogin();
        assertSettingsSwitchExpectedStateAndTogglePersists("Allow In-App Notifications", true);

    }

    @Test
    public void Test() throws Exception {
        skipLogin();
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        driver.swipe(screenWidth / 2, screenHeight / 1000, screenWidth / 2, screenHeight / 10 * 5, 2000);

    }

    @Test
    public void FeaturedAppsScreen() throws Exception {
        //Tests that each app redirects to the correct app in the google play store
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Featured Apps");
        assertElementExistsBy(WebElementsByText("Featured Apps", false));
        ClickUIElementByText("Featured Apps", false);
        assertElementExistsBy(WebElementsById(AppId("mainToolbar")));
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsById(AppId("mainToolbarTitleTextView")));
        verifyText("Featured Apps", WebElementById(AppId("mainToolbarTitleTextView")), false);
        appCheck("Bible Videos");
        appCheck("Book of Mormon");
        appCheck("Doctrinal Mastery");
        appCheck("Facility Issue Reporting");
        appCheck("FamilySearch Memories");
        appCheck("FamilySearch Tree");
        appCheck("Gospel Media");
        appCheck("JustServe");
        appCheck("LDS Youth");
        appCheck("Member Tools");
        appCheck("Mormon Channel");
        appCheck("Sacred Music");
        appCheck("Seminary & Institute");
        appCheck("The Tabernacle Choir");
        ClickUIElementByAccessibilityID("Navigate up");
        assertElementExistsBy(WebElementsByText("Settings", false));

    }

    @Test
    public void SendFeedbackScreenSendFeedback() throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Send Feedback");
        //Verify Send Feedback Option
        assertElementExistsBy(WebElementsByText("Send Feedback", false));
        ClickUIElementByText("Send Feedback", false);
        fillOutFeedbackFormAndAssert(name, email, "Compliment", true, "default", false, false, true);
        assertElementExistsBy(WebElementsByText("Settings", false));

    }

    @Test
    public void SendFeedbackScreenSendFeedbackWithoutName() throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Send Feedback");
        //Verify Send Feedback Option
        assertElementExistsBy(WebElementsByText("Send Feedback", false));
        ClickUIElementByText("Send Feedback", false);
        fillOutFeedbackFormAndAssert("", email, "Compliment", false, "default", false, false, true);
        assertElementExistsBy(WebElementsByText("Settings", false));

    }

    @Test
    public void SendFeedbackScreenSendFeedbackWithphoto() throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Send Feedback");
        //Verify Send Feedback Option
        assertElementExistsBy(WebElementsByText("Send Feedback", false));
        ClickUIElementByText("Send Feedback", false);
        fillOutFeedbackFormAndAssert(name, email, "Compliment", false, "default", true, false, true);
        Thread.sleep(milliseconds_5);
        assertElementExistsBy(WebElementsByText("Settings", false));

    }

    //Android update changed the picture picker
//    @Test
//    public void SendFeedbackScreenSendFeedbackWithTwoPhotos() throws Exception {
//        skipLogin();
//        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
//        ClickUIElementByAccessibilityID("More options");
//        assertElementExistsBy(WebElementsByText("Settings"));
//        ClickUIElementByText("Settings");
//        scrollDownTo("Send Feedback");
//        //Verify Send Feedback Option
//        assertElementExistsBy(WebElementsByText("Send Feedback"));
//        ClickUIElementByText("Send Feedback");
//        //Verify Exit Button
//        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
//        //Verify Page Title
//        assertElementExistsBy(WebElementsById(AppId("mainToolbarTitleTextView"));

//        verifyText("Send Feedback", WebElementById(AppId("mainToolbarTitleTextView"));
//        //Verify Attach Image
//        assertElementExistsBy(WebElementsByAccessibilityId("Attach Image"));
//        WebElement test = WebElementByAccessibilityId("Attach Image");
//        //Verify Submit
//        assertElementExistsBy(WebElementsByAccessibilityId("Submit"));
//        //Verify Name Field
//        assertElementExistsBy(WebElementsById(AppId("feedbackNameTextInputLayout"));
//        verifyText("Name (Optional)", WebElementById(AppId("feedbackNameTextInputLayout"));
//        assertElementExistsBy(WebElementsById(AppId("feedbackNameTextInputEditText"));
//        //Verify Email field
//        assertElementExistsBy(WebElementsById(AppId("feedbackEmailTextInputLayout"));
//        verifyText("Email",WebElementById(AppId("feedbackEmailTextInputLayout"));
//        assertElementExistsBy(WebElementsById(AppId("feedbackEmailTextInputEditText"));
//        //Verify Category Spinner
//        assertElementExistsBy(WebElementsById(AppId("feedbackCategorySpinner"));
//        assertElementExistsBy(WebElementsById("android:id/text1"));
//        verifyText("Category",WebElementById("android:id/text1"));
//        //Verify Description Field
//        assertElementExistsBy(WebElementsById(AppId("feedbackDescriptionTextInputLayout"));
//        verifyText("Description", WebElementById(AppId("feedbackDescriptionTextInputLayout"));
//        assertElementExistsBy(WebElementsById(AppId("feedbackDescriptionEditText"));
//        //Verify text field counter
//        assertElementExistsBy(WebElementsById(AppId("textinput_counter"));
//        verifyText("0 / 1000", WebElementById(AppId("textinput_counter"));
//
//        //enter text into form
//        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/feedbackNameTextInputEditText", name);
//        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/feedbackEmailTextInputEditText", email);
//
//        //verify category wheel options
//        List category = new ArrayList();
//        category.add("Compliment");
//
//        for (int x = 0; x < category.size(); x++){
//            ClickUIElementByID(AppId("feedbackCategorySpinner");
//            assertElementExistsBy(WebElementsByCheckedText((String) category.get(x)));
//            ClickUIElementByCheckedText((String) category.get(x));
//            assertElementExistsBy(WebElementsById(AppId("feedbackCategorySpinner"));
//            verifyText((String) category.get(x), WebElementById("android:id/text1"));
//            Thread.sleep(milliseconds_1);
//        }
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Date date = new Date();
//        String description = ("sendto:"+ sendtoemail + " This is a test support email from automation sent on " + dateFormat.format(date) + " test: " + (new Exception().getStackTrace()[0].getMethodName()) + "");
//        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/feedbackDescriptionEditText",description);
//        int screenHeight = driver.manage().window().getSize().getHeight();
//        int screenWidth = driver.manage().window().getSize().getWidth();
//        driver.swipe(screenWidth / 2, screenHeight / 2, screenWidth / 2, screenHeight / 10 * 2, 2000);
//        verifyText("" + description.length() + " / 1000", WebElementById(AppId("textinput_counter"));
//
//        //Attach the First Image
//        ClickUIElementByAccessibilityID("Attach Image");
//        ClickUIElementByAccessibilityID("More options");
//        if (WebElementsByText("List view").size() > 0){
//            ClickUIElementByText("List view");
//        } else {
//            TapCenterScreen();
//        }
//        String photoTitle = WebElementByXpath("//android.widget.ImageView/../android.widget.TextView").getText();
//        System.out.println(photoTitle);
//        ClickUIElementByXpath("//android.widget.ImageView");
//        assertElementExistsBy(WebElementsById(AppId("bubbleLayout"));
//        assertElementExistsBy(WebElementsById(AppId("bubbleTextView"));
//        assertElementExistsBy(WebElementsById(AppId("bubbleDeleteImageView"));
//        verifyText(photoTitle, WebElementById(AppId("bubbleTextView"));
//        Thread.sleep(milliseconds_1);
//
//        //attach the second image
//        ClickUIElementByAccessibilityID("Attach Image");
//        ClickUIElementByAccessibilityID("More options");
//        if (WebElementsByText("List view").size() > 0){
//            ClickUIElementByText("List view");
//        } else {
//            TapCenterScreen();
//        }
//        String photoTitle2 = WebElementByXpath("(//android.widget.ImageView/../android.widget.TextView)[2]").getText();
//        System.out.println(photoTitle2);
//        ClickUIElementByXpath("(//android.widget.ImageView)[3]");
//        Thread.sleep(milliseconds_1);
//        assertElementExistsBy(WebElementsByXpath("(//android.widget.ImageView)[1]"));
//        assertElementExistsBy(WebElementsByXpath("(//android.widget.ImageView)[2]"));
//        assertElementExistsBy(WebElementsByXpath("(//android.widget.ImageView/../android.widget.TextView)[1]"));
//        assertElementExistsBy(WebElementsByXpath("(//android.widget.ImageView/../android.widget.TextView)[2]"));
//        verifyText(photoTitle,WebElementByXpath("(//android.widget.ImageView/../android.widget.TextView)[1]"));
//        verifyText(photoTitle2,WebElementByXpath("(//android.widget.ImageView/../android.widget.TextView)[2]"));
//
//        Thread.sleep(milliseconds_1);
//        ClickUIElementByAccessibilityID("Submit");
//        Thread.sleep(milliseconds_5);
//        assertElementExistsBy(WebElementsByText("Settings"));
//
//    }

    @Test
    public void SendFeedbackScreenAddPhotoThenRemove() throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Send Feedback");
        //Verify Send Feedback Option
        assertElementExistsBy(WebElementsByText("Send Feedback", false));
        ClickUIElementByText("Send Feedback", false);
        fillOutFeedbackFormAndAssert("", email, "Compliment", false, "default", true, true, true);
        assertElementExistsBy(WebElementsByText("Settings", false));

    }

    @Test
    public void SendFeedbackScreenInvalidEmail() throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Send Feedback");
        //Verify Send Feedback Option
        assertElementExistsBy(WebElementsByText("Send Feedback", false));
        ClickUIElementByText("Send Feedback", false);
        fillOutFeedbackFormAndAssert(name, "", "Compliment", false, "default", false, false, true);
        assertElementExistsBy(WebElementsByText("Settings", false));
    }

    @Test
    public void SendFeedbackScreenMissingRequiredFieldEmail() throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Send Feedback");
        //Verify Send Feedback Option
        assertElementExistsBy(WebElementsByText("Send Feedback", false));
        ClickUIElementByText("Send Feedback", false);
        fillOutFeedbackFormAndAssert(name, "", "Compliment", false, "default", false, false, true);
        assertElementExistsBy(WebElementsByText("Settings", false));

    }

    @Test
    public void SendFeedbackScreenMissingRequiredFieldCategory() throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Send Feedback");
        //Verify Send Feedback Option
        assertElementExistsBy(WebElementsByText("Send Feedback", false));
        ClickUIElementByText("Send Feedback", false);
        fillOutFeedbackFormAndAssert(name, email, "", false, "default", false, false, true);
        assertElementExistsBy(WebElementsByText("Settings", false));

    }

    @Test
    public void SendFeedbackScreenMissingRequiredFieldDescription() throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Send Feedback");
        //Verify Send Feedback Option
        assertElementExistsBy(WebElementsByText("Send Feedback", false));
        ClickUIElementByText("Send Feedback", false);
        fillOutFeedbackFormAndAssert(name, email, "Compliment", false, "", false, false, true);
        assertElementExistsBy(WebElementsByText("Settings", false));
    }

    @Test
    public void SendFeedbackScreenAutofillFields() throws Exception {
        SendFeedbackScreenSendFeedback();
        scrollDownTo("Send Feedback");
        //Verify Send Feedback Option
        assertElementExistsBy(WebElementsByText("Send Feedback", false));
        ClickUIElementByText("Send Feedback", false);
        verifyText(name, WebElementById(AppId("feedbackNameTextInputEditText")), false);
        verifyText(email, WebElementById(AppId("feedbackEmailTextInputEditText")), false);
        verifyText("Category", WebElementById("android:id/text1"), false);
        verifyText("Description", WebElementById(AppId("feedbackDescriptionEditText")), false);
        verifyText("0 / 1000", WebElementById(AppId("textinput_counter")), false);
        //verify category wheel options
        List category = new ArrayList();
        category.add("Feature request");

        for (int x = 0; x < category.size(); x++) {
            ClickUIElementByID(AppId("feedbackCategorySpinner"));
            assertElementExistsBy(WebElementsByCheckedText((String) category.get(x), false));
            ClickUIElementByCheckedText((String) category.get(x), false);
            assertElementExistsBy(WebElementsById(AppId("feedbackCategorySpinner")));
            verifyText((String) category.get(x), WebElementById("android:id/text1"), false);
            Thread.sleep(milliseconds_1);

        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String description = ("sendto:" + sendtoemail + " This is a test support email from automation sent on " + dateFormat.format(date) + " test: " + (new Exception().getStackTrace()[0].getMethodName()) + "");
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/feedbackDescriptionEditText", description);
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        driver.swipe(screenWidth / 2, screenHeight / 2, screenWidth / 2, screenHeight / 10 * 2, 2000);
        verifyText("" + description.length() + " / 1000", WebElementById(AppId("textinput_counter")), false);
        Thread.sleep(milliseconds_1);
        ClickUIElementByAccessibilityID("Submit");
        Thread.sleep(milliseconds_5);
        assertElementExistsBy(WebElementsByText("Settings", false));

    }


    @Test
    public void AboutScreen() throws Exception {
        skipLogin();
        //Open More Options Menu
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        //Click Settings
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        //Click "About"
        scrollDownTo("About");
        ClickUIElementByText("About", false);
        //Check that all elements are present
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsById(AppId("mainToolbarTitleTextView")));
        verifyText("About", WebElementById(AppId("mainToolbarTitleTextView")), false);
        assertElementExistsBy(WebElementsByText("Terms of Use", false));
        assertElementExistsBy(WebElementsByText("Privacy Notice", false));
        assertElementExistsBy(WebElementsByText("Acknowledgements", false));
        assertElementExistsBy(WebElementsById(AppId("aboutLogo")));
        assertElementExistsBy(WebElementsById(AppId("aboutCopyright")));

        //Verify Rights and Use Date
        ClickUIElementByText("Terms of Use", false);
        verifyText("https://www.churchofjesuschrist.org/legal/terms-of-use?lang=eng&country=go", WebElementById("com.android.chrome:id/url_bar"), false);
        String RightsAndUse = WebElementByXpath("//android.view.View[contains(@text, 'Updated')]").getText();
        System.out.println(RightsAndUse);
        RightsAndUse = RightsAndUse.replace("Terms of Use (Updated ", "");
        RightsAndUse = RightsAndUse.replace(")", "");
        int year = Integer.parseInt(RightsAndUse.substring(0, 4));
        int day = Integer.parseInt(RightsAndUse.substring(8, 10));
        int month = Integer.parseInt(RightsAndUse.substring(5, 7));
        String dayString = String.valueOf(day);
        String monthString = String.valueOf(month);
        // adds a leading Zero from day and month
        if (day < 10) {
            dayString = "0" + String.valueOf(day);
        }
        if (month < 10) {
            monthString = "0" + String.valueOf(month);
        }
        driver.navigate().back();
        RightsAndUse = "Updated " + year + "-" + monthString + "-" + dayString + "";
        System.out.println(RightsAndUse);
        verifyText(RightsAndUse, WebElementByXpath("//android.widget.TextView[@text='Terms of Use']/../android.widget.TextView[contains(@text, 'Updated')]"), false);

        //Verify Privacy Notice Date
        ClickUIElementByText("Privacy Notice", false);
        verifyText("https://www.churchofjesuschrist.org/legal/privacy-notice?lang=eng&country=go", WebElementById("com.android.chrome:id/url_bar"), false);
        String PrivacyPolicy = WebElementByXpath("//android.view.View[contains(@text, 'Updated')]").getText();
        System.out.println(PrivacyPolicy);
        PrivacyPolicy = PrivacyPolicy.replace("Privacy Notice (Updated ", "");
        PrivacyPolicy = PrivacyPolicy.replace(")", "");
        System.out.println(PrivacyPolicy);
        year = Integer.parseInt(PrivacyPolicy.substring(0, 4));
        day = Integer.parseInt(PrivacyPolicy.substring(8, 10));
        month = Integer.parseInt(PrivacyPolicy.substring(5, 7));
        dayString = String.valueOf(day);
        monthString = String.valueOf(month);
        // adds a leading Zero from day and month
        if (day < 10) {
            dayString = "0" + String.valueOf(day);
        }
        if (month < 10) {
            monthString = "0" + String.valueOf(month);
        }
        driver.navigate().back();
        PrivacyPolicy = "Updated " + year + "-" + monthString + "-" + dayString + "";
        System.out.println(PrivacyPolicy);
        verifyText(PrivacyPolicy, WebElementByXpath("//android.widget.TextView[@text='Privacy Notice']/../android.widget.TextView[contains(@text, 'Updated')]"), false);

        //verify Acknowledgements
        ClickUIElementByText("Acknowledgements", false);
        assertElementExistsBy(WebElementsByText("Acknowledgements", false));
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsById(AppId("aboutLibrariesRecyclerView")));
        ClickUIElementByAccessibilityID("Navigate up");
        verifyText("About", WebElementById(AppId("mainToolbarTitleTextView")), false);


        //verify year in copyright
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        Date date = new Date();
        String Copyright = "© " + dateFormat.format(date) + " by Intellectual Reserve, Inc. All rights reserved.";
        verifyText(Copyright, WebElementById(AppId("aboutCopyright")), false);

        driver.navigate().back();
        assertElementExistsBy(WebElementsByText("Settings", false));


    }

    @Test
    public void turnOnDeveloperSettings() throws Exception {
        skipLogin();
        //Open More Options Menu
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        //Click Settings
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        //Click "About"
        scrollDownTo("About");
        ClickUIElementByText("About", false);
        driver.tap(1, WebElementById(AppId("aboutLogo")), 1);
        driver.tap(1, WebElementById(AppId("aboutLogo")), 1);
        driver.tap(1, WebElementById(AppId("aboutLogo")), 1);
        driver.tap(1, WebElementById(AppId("aboutLogo")), 1);
        driver.tap(1, WebElementById(AppId("aboutLogo")), 1);
        ClickUIElementByAccessibilityID("Navigate up");
        scrollDownTo("Developer Options");
        assertElementExistsBy(WebElementsByText("Developer Options", false));
    }


    //********** Standard Works Nav and Content **********
//    @Test
//    public void allBooksInTheOldTestiment() throws Exception {
//        skipLogin();
//
//        ClickUIElementByText("Scriptures");
//        ClickUIElementByText("Old Testament");
//
//
//        //Calls verifyNavBookTitle and passes in the books in the Old Testiment
//        verifyNavBookTitle(BooksInOldTestament);
//
//    }
//
//    @Test
//    public void allBooksInTheNewTestiment() throws Exception {
//        skipLogin();
//
//        ClickUIElementByText("Scriptures");
//        ClickUIElementByText("New Testament");
//        //Calls verifyNavBookTitle and passes in the books in the New Testiment
//        verifyNavBookTitle(BooksInNewTestament);
//
//    }
//
//
//    @Test
//    public void allBooksInTheBoM() throws Exception {
//        skipLogin();
//
//        ClickUIElementByText("Scriptures",false);
//        ClickUIElementByText("Book of Mormon",false);
//        //Calls verifyNavBookTitle and passes in the books in the Book of Mormon
//        verifyNavBookTitle(BooksInBom);
//
//
//    }
//
//    @Test
//    public void allBooksInTheDAndC() throws Exception {
//        skipLogin();
//
//        ClickUIElementByText("Scriptures");
//        ClickUIElementByText("Doctrine and Covenants");
//        //Calls verifyNavBookTitle and passes in the books in the Doctrine and Covenants
//        verifyNavBookTitle(BooksInDAndC);
//
//
//    }
//
//
//    @Test
//    public void allBooksInThePearlOfGreatPrice() throws Exception {
//        skipLogin();
//
//        ClickUIElementByText("Scriptures");
//        ClickUIElementByText("Pearl of Great Price");
//        //Calls verifyNavBookTitle and passes in the books in the Pearl of Great Price
//        verifyNavBookTitle(BooksInPearlOfGreatPrice);
//
//
//    }
//


    //********** Content Interaction **********

    @Test
    public void AnnotationMenuTapMark() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "5", "");
        OpenAnnotationMenu("p1", "Mark");
        AnnotationsSyncCheck("No Thanks");
        assertElementInWebviewExistsBy("//div[contains(@class, 'hl-yellow-box')]");

    }

    @Test
    public void AnnotationMenuTapMarkAndStyle() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "5", "");
        OpenAnnotationMenu("p1", "Mark");
        AnnotationsSyncCheck("No Thanks");
        assertElementInWebviewExistsBy("//div[contains(@class, 'hl-yellow-box')]");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]");
        templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        OpenAnnotationMenuFromAnnotation(WebElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]"), "Style");
        assertHighlightStyleScreen();
        assertHighlightStyleScreenStyleAndColor("solid", "yellow");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleClear() throws Exception {
        skipLogin();
        TestCheckAnnotationStyleAndColor("clear", "");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleRedUnderline() throws Exception {
        skipLogin();
        TestCheckAnnotationStyleAndColor("underline", "red");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleOrangeUnderline() throws Exception {
        skipLogin();
        TestCheckAnnotationStyleAndColor("underline", "orange");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleYellowUnderline() throws Exception {
        skipLogin();
        TestCheckAnnotationStyleAndColor("underline", "yellow");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleGreenUnderlined() throws Exception {
        skipLogin();
        TestCheckAnnotationStyleAndColor("underline", "green");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleBlueUnderline() throws Exception {
        skipLogin();
        TestCheckAnnotationStyleAndColor("underline", "blue");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleDarkBlueUnderline() throws Exception {
        skipLogin();
        TestCheckAnnotationStyleAndColor("underline", "dark_blue");
    }

    @Test
    public void AnnotationMenuTapMarkAndStylePurpleUnderline() throws Exception {
        skipLogin();
        TestCheckAnnotationStyleAndColor("underline", "purple");
    }

    @Test
    public void AnnotationMenuTapMarkAndStylePinkUnderline() throws Exception {
        skipLogin();
        TestCheckAnnotationStyleAndColor("underline", "pink");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleBrownUnderline() throws Exception {
        skipLogin();
        TestCheckAnnotationStyleAndColor("underline", "brown");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleGrayUnderline() throws Exception {
        skipLogin();
        TestCheckAnnotationStyleAndColor("underline", "gray");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleRedSolid() throws Exception {
        skipLogin();
        TestCheckAnnotationStyleAndColor("solid", "red");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleOrangeSolid() throws Exception {
        skipLogin();
        TestCheckAnnotationStyleAndColor("solid", "orange");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleYellowSolid() throws Exception {
        skipLogin();
        TestCheckAnnotationStyleAndColor("solid", "yellow");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleGreenSolid() throws Exception {
        skipLogin();
        TestCheckAnnotationStyleAndColor("solid", "green");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleBlueSolid() throws Exception {
        skipLogin();
        TestCheckAnnotationStyleAndColor("solid", "blue");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleDarkBlueSolid() throws Exception {
        skipLogin();
        TestCheckAnnotationStyleAndColor("solid", "dark_blue");
    }

    @Test
    public void AnnotationMenuTapMarkAndStylePurpleSolid() throws Exception {
        skipLogin();
        TestCheckAnnotationStyleAndColor("solid", "purple");
    }

    @Test
    public void AnnotationMenuTapMarkAndStylePinkSolid() throws Exception {
        skipLogin();
        TestCheckAnnotationStyleAndColor("solid", "pink");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleBrownSolid() throws Exception {
        skipLogin();
        TestCheckAnnotationStyleAndColor("solid", "brown");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleGraySolid() throws Exception {
        skipLogin();
        TestCheckAnnotationStyleAndColor("solid", "gray");
    }

    @Test
    public void AnnotationMenuTapNote() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "5", "");
        OpenAnnotationMenu("p1", "Note");
        assertNoteScreen(true, true);
    }

    @Test
    public void AnnotationMenuCreateNoteAnnotationIndicatorIcon() throws Exception {
        AnnotationMenuCreateNote();
        ClickUIElementByAccessibilityID("Navigate up");
        assertElementInWebviewExistsBy("//div[contains(@class,'stickyNote')]");
        assertEquals("url(\"file:///android_asset/images/annotation_note.png\")", getComputedCssUsingXpath("//div[contains(@class,'stickyNote')]", "background-image"));

    }

    @Test
    public void AnnotationMenuCreateNote() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "5", "");
        OpenAnnotationMenu("p1", "Note");
        assertNoteScreen(true, true);
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/noteTitleEditText", "Spiritual Thought Title");
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText", "Spiritual thought expounded on");
        verifyText("Spiritual Thought Title", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/noteTitleEditText"), false);
        verifyText("Spiritual thought expounded on", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText"), false);
        ClickUIElementByAccessibilityID("Navigate up");
        AnnotationsSyncCheck("No Thanks");
        assertElementInWebviewExistsBy("//div[contains(@class, 'hl-yellow-box')]");
        assertElementInWebviewExistsBy("//div[contains(@class,'stickyNote')]");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]");
        templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        OpenAnnotationMenuFromAnnotation(WebElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]"), "Note");
        verifyText("Spiritual Thought Title", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/noteTitleEditText"), false);
        verifyText("Spiritual thought expounded on", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText"), false);
    }

    @Test
    public void AnnotationMenuCreateNoteWithLink() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "5", "");
        OpenAnnotationMenu("p1", "Note");
        assertNoteScreen(true, true);
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/noteTitleEditText", "Spiritual Thought Title");
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText", "Spiritual thought expounded on");
        verifyText("Spiritual Thought Title", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/noteTitleEditText"), false);
        verifyText("Spiritual thought expounded on", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText"), false);
        ClickUIElementByAccessibilityID("Link");
        assertLinksScreen();
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/searchEditText", "Jarom");
        ClickUIElementByXpath("(//*[@text=\"Jarom\"]/../../android.widget.ImageView[2])[1]");
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/bubbleTextView"));
        verifyText("Jarom", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/bubbleTextView"), false);
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByAccessibilityID("Navigate up");
        AnnotationsSyncCheck("No Thanks");
        assertElementInWebviewExactCount("//div[contains(@class, 'hl-yellow-box')]", 1);
        assertElementInWebviewExactCount("//div[contains(@class,'stickyNote')]", 1);
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]");
        templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        OpenAnnotationMenuFromAnnotation(WebElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]"), "Note");
        verifyText("Spiritual Thought Title", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/noteTitleEditText"), false);
        verifyText("Spiritual thought expounded on", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText"), false);
        ClickUIElementByAccessibilityID("Link");
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/bubbleTextView"));
        verifyText("Jarom", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/bubbleTextView"), false);
    }

    @Test
    public void AnnotationMenuCreateNoteWithTag() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "5", "");
        OpenAnnotationMenu("p1", "Note");
        assertNoteScreen(true, true);
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/noteTitleEditText", "Spiritual Thought Title");
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText", "Spiritual thought expounded on");
        verifyText("Spiritual Thought Title", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/noteTitleEditText"), false);
        verifyText("Spiritual thought expounded on", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText"), false);
        ClickUIElementByAccessibilityID("Tag");
        assertTagScreen(true);
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/tagNameEditText", "Test Tag");
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/linearLayout3"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/listItemImageView"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/listItemTextView"));
        verifyText("Create “Test Tag”", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/listItemTextView"), false);
        ClickUIElementByResourceID("org.lds.ldssa." + GospelLibraryBuild + ":id/listItemImageView");
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/bubbleTextView"));
        verifyText("Test Tag", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/bubbleTextView"), false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/bubbleDeleteImageView"));
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByAccessibilityID("Navigate up");
        AnnotationsSyncCheck("No Thanks");
        assertElementInWebviewExistsBy("//div[contains(@class, 'hl-yellow-box')]");
        assertElementInWebviewExistsBy("//div[contains(@class,'stickyNote')]");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]");
        templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        OpenAnnotationMenuFromAnnotation(WebElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]"), "Note");
        verifyText("Spiritual Thought Title", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/noteTitleEditText"), false);
        verifyText("Spiritual thought expounded on", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText"), false);
        ClickUIElementByAccessibilityID("Tag");
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/bubbleTextView"));
        verifyText("Test Tag", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/bubbleTextView"), false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/bubbleDeleteImageView"));
    }

    @Test
    public void AnnotationMenuCreateNoteAddtoNotebook() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "5", "");
        OpenAnnotationMenu("p1", "Note");
        assertNoteScreen(true, true);
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/noteTitleEditText", "Spiritual Thought Title");
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText", "Spiritual thought expounded on");
        verifyText("Spiritual Thought Title", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/noteTitleEditText"), false);
        verifyText("Spiritual thought expounded on", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText"), false);
        assertMoreOptionsMenu("Note", false);
        ClickUIElementByText("Add to Notebook", false);
        assertAddToNotebookScreen(true);
        ClickUIElementByResourceID("org.lds.ldssa." + GospelLibraryBuild + ":id/notebookSelectionFloatingActionButton");
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/md_text_title"));
        verifyText("Create Notebook", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/md_text_title"), false);
        assertElementExistsBy(WebElementsById(AppId("md_input_message")));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/textinput_counter"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/md_button_negative"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/md_button_positive"));
        //commented out because of a bug that doesn't disable the add button when there isn't a name
        //assert !Boolean.parseBoolean(WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/md_button_positive").getAttribute("enabled"));
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/md_input_message", "Test Notebook");
        assert Boolean.parseBoolean(WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/md_button_positive").getAttribute("enabled"));
        ClickUIElementByResourceID("org.lds.ldssa." + GospelLibraryBuild + ":id/md_button_positive");
        ClickUIElementByResourceID("org.lds.ldssa." + GospelLibraryBuild + ":id/notebookCheckBox");
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByAccessibilityID("Navigate up");
        AnnotationsSyncCheck("No Thanks");
        assertElementInWebviewExistsBy("//div[contains(@class, 'hl-yellow-box')]");
        assertElementInWebviewExistsBy("//div[contains(@class,'stickyNote')]");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]");
        templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        OpenAnnotationMenuFromAnnotation(WebElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]"), "Note");
        verifyText("Spiritual Thought Title", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/noteTitleEditText"), false);
        verifyText("Spiritual thought expounded on", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText"), false);
        assertMoreOptionsMenu("Note", false);
        ClickUIElementByText("Add to Notebook", false);
        assert Boolean.parseBoolean(WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/notebookCheckBox").getAttribute("checked"));
    }

    @Test
    public void AnnotationMenuTapTag() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "5", "");
        OpenAnnotationMenu("p1", "Tag");
        assertTagScreen(true);
    }

    @Test
    public void AnnotationMenuCreateTag() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "5", "");
        OpenAnnotationMenu("p1", "Tag");
        assertTagScreen(true);
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/tagNameEditText", "Test Tag");
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/linearLayout3"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/listItemImageView"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/listItemTextView"));
        verifyText("Create “Test Tag”", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/listItemTextView"), false);
        ClickUIElementByResourceID("org.lds.ldssa." + GospelLibraryBuild + ":id/listItemImageView");
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/bubbleTextView"));
        verifyText("Test Tag", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/bubbleTextView"), false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/bubbleDeleteImageView"));
        ClickUIElementByAccessibilityID("Navigate up");
        AnnotationsSyncCheck("No Thanks");
        assertElementInWebviewExistsBy("//div[contains(@class, 'hl-yellow-box')]");
        assertElementInWebviewExistsBy("//div[contains(@class,'stickyTag')]");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]");
        templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        OpenAnnotationMenuFromAnnotation(WebElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]"), "Tag");
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/bubbleTextView"));
        verifyText("Test Tag", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/bubbleTextView"), false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/bubbleDeleteImageView"));
    }

    @Test
    public void AnnotationMenuCreateTagAnnotationIndicatorIcon() throws Exception {
        AnnotationMenuCreateTag();
        ClickUIElementByAccessibilityID("Navigate up");
        assertElementInWebviewExistsBy("//div[contains(@class,'stickyTag')]");
        assertEquals("url(\"file:///android_asset/images/annotation_tag.png\")", getComputedCssUsingXpath("//div[contains(@class,'stickyTag')]", "background-image"));

    }

    @Test
    public void AnnotationMenuOpenTagInSidebarGoToTag() throws Exception {
        AnnotationMenuCreateTag();
        ClickUIElementByAccessibilityID("Navigate up");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]");
        ClickUIElementInWebviewByXPath("//div[contains(@class,'stickyTag')]");

        //assert sidebar
        assertSideBar("Tag", true, "Tag", "Test Tag");
        //click tag
        ClickUIElementByText("Test Tag", false);
        //assert menu bar
        assertMenuBar("Test Tag", "Tags", true);

        //assert tag
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/lastModifiedTextView"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/annotationMenuImageButton"));
        //assert tag content
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/highlightLayout"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/bubbleLayout"));
        verifyText("Test Tag", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/bubbleTextView"), false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/tag_text"));
    }

    @Test
    public void AnnotationMenuTapAddTo() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "5", "");
        OpenAnnotationMenu("p1", "Add to");
        assertAddToNotebookScreen(true);
    }

    @Test
    public void AnnotationMenuAddToNotebook() throws Exception {
        CreateNewNotebook();
        ClickUIElementByAccessibilityID("Navigate up");
        OpenScripture("Book of Mormon", "Jacob", "5", "");
        OpenAnnotationMenu("p1", "Add to");
        assertAddToNotebookScreen(false);
        ClickUIElementByResourceID("org.lds.ldssa." + GospelLibraryBuild + ":id/notebookCheckBox");
        ClickUIElementByAccessibilityID("Navigate up");
        AnnotationsSyncCheck("No Thanks");
        assertElementInWebviewExistsBy("//div[contains(@class, 'hl-yellow-box')]");
        assertElementInWebviewExistsBy("//div[contains(@class,'stickyNotebook')]");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]");
        templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        OpenAnnotationMenuFromAnnotation(WebElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]"), "Add to");
        assert Boolean.parseBoolean(WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/notebookCheckBox").getAttribute("checked"));

    }

    @Test
    public void AnnotationMenuAddToAnnotationIndicatorIcon() throws Exception {
        AnnotationMenuAddToNotebook();
        ClickUIElementByAccessibilityID("Navigate up");
        assertElementInWebviewExistsBy("//div[contains(@class,'stickyNotebook')]");
        assertEquals("url(\"file:///android_asset/images/annotation_notebook.png\")", getComputedCssUsingXpath("//div[contains(@class,'stickyNotebook')]", "background-image"));

    }

    @Test
    public void AnnotationMenuTapLink() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "5", "");
        OpenAnnotationMenu("p1", "Link");
    }

    @Test
    public void AnnotationMenuCreateLinkToSingleChapterBook() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "5", "");
        OpenAnnotationMenu("p1", "Link");
        sendText("org.lds.ldssa." + GospelLibraryBuild + ":id/searchEditText", "Jarom");
        ClickUIElementByXpath("(//*[@text=\"Jarom\"]/../../android.widget.ImageView[2])[1]");
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/bubbleTextView"));
        verifyText("Jarom", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/bubbleTextView"), false);
        ClickUIElementByAccessibilityID("Navigate up");
        AnnotationsSyncCheck("No Thanks");
        assertElementInWebviewExistsBy("//div[contains(@class, 'hl-yellow-box')]");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]");
        templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        OpenAnnotationMenuFromAnnotation(WebElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]"), "Link");
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/bubbleTextView"));
        verifyText("Jarom", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/bubbleTextView"), false);
    }

    @Test
    public void AnnotationMenuCreateLinkAnnotationIndicatorIcon() throws Exception {
        AnnotationMenuCreateLinkToSingleChapterBook();
        ClickUIElementByAccessibilityID("Navigate up");
        assertElementInWebviewExistsBy("//div[contains(@class,'stickyLink')]");
        assertEquals("url(\"file:///android_asset/images/annotation_link.png\")", getComputedCssUsingXpath("//div[contains(@class,'stickyLink')]", "background-image"));

    }

    @Test
    public void AnnotationMenuTapCopy() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "5", "");
        OpenAnnotationMenu("p1", "Copy");
    }

    @Test
    public void AnnotationMenuTapShare() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "5", "");
        OpenAnnotationMenu("p1", "Share");
    }

    @Test
    public void AnnotationMenuTapSearch() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "5", "");
        OpenAnnotationMenu("p1", "Search");
    }

    @Test
    public void AnnotationMenuTapDefine() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "5", "");
        OpenAnnotationMenu("p1", "Define");
    }

    @Test
    public void AnnotationMenuTapRemove() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "5", "");
        OpenAnnotationMenu("p1", "Remove");
    }

    @Test
    public void AnnotationMenuTapCreateRemove() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "5", "");
        OpenAnnotationMenu("p1", "Remove");
    }

    @Test
    public void AnnotationChooseBetweenOverlappingHighlights() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "7", "");
        OpenAnnotationMenu("p1", "Mark");
        AnnotationsSyncCheck("No Thanks");
        assertElementInWebviewExistsBy("//div[contains(@class, 'hl-yellow-box')]");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size()) + "]");
        OpenAnnotationMenu("p1", "Mark");
        templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]");
        assertChooseHighlightScreen();
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/marginIndicatorImageView\"])[1]"));
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/marginIndicatorImageView\"])[2]"));
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/listItemTextView\"])[1]"));
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/listItemTextView\"])[2]"));
        ClickUIElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/listItemTextView\"])[1]");
    }

    @Test
    public void AnnotationChooseBetweenOverlappingHighlightsOfDifferentTypeTagAndMark() throws Exception {
        AnnotationMenuCreateTag();
        ClickUIElementByAccessibilityID("Navigate up");
        OpenAnnotationMenu("p1", "Mark");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 2) + "]");
        assertChooseHighlightScreen();
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/marginIndicatorImageView\"])[1]"));
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/marginIndicatorImageView\"])[2]"));
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/listItemTextView\"])[1]"));
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/listItemTextView\"])[2]"));
        ClickUIElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/listItemTextView\"])[2]");
        TapAnnotationMenuItem("p1", "Tag");
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/bubbleTextView"));
        verifyText("Test Tag", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/bubbleTextView"), false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/bubbleDeleteImageView"));

    }

    @Test
    public void AnnotationChooseBetweenOverlappingHighlightsOfDifferentTypeLinkAndMark() throws Exception {
        AnnotationMenuCreateLinkToSingleChapterBook();
        ClickUIElementByAccessibilityID("Navigate up");
        OpenAnnotationMenu("p1", "Mark");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 2) + "]");
        assertChooseHighlightScreen();
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/marginIndicatorImageView\"])[1]"));
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/marginIndicatorImageView\"])[2]"));
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/listItemTextView\"])[1]"));
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/listItemTextView\"])[2]"));
        ClickUIElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/listItemTextView\"])[2]");
        TapAnnotationMenuItem("p1", "Link");
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/bubbleTextView"));
        verifyText("Jarom", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/bubbleTextView"), false);
    }

    @Test
    public void AnnotationChooseBetweenOverlappingHighlightsOfDifferentTypeNoteAndMark() throws Exception {
        AnnotationMenuCreateNote();
        ClickUIElementByAccessibilityID("Navigate up");
        OpenAnnotationMenu("p1", "Mark");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 2) + "]");
        assertChooseHighlightScreen();
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/marginIndicatorImageView\"])[1]"));
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/marginIndicatorImageView\"])[2]"));
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/listItemTextView\"])[1]"));
        assertElementExistsBy(WebElementsByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/listItemTextView\"])[2]"));
        ClickUIElementByXpath("(//*[@resource-id=\"org.lds.ldssa." + GospelLibraryBuild + ":id/listItemTextView\"])[2]");
        TapAnnotationMenuItem("p1", "Note");
        verifyText("Spiritual Thought Title", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/noteTitleEditText"), false);
        verifyText("Spiritual thought expounded on", WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/markdownEditText"), false);
    }

    @Test
    public void AnnotationDeleteHighlightWithNote() throws Exception {
        AnnotationMenuCreateNote();
        ClickUIElementByAccessibilityID("Navigate up");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[\" + (templist.size()-1)+\"]");
        OpenAnnotationMenuFromAnnotation(WebElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]"), "Remove");
        assertRemoveAnnotationPopup();
        ClickUIElementByID(AppId("md_button_positive"));
        assertElementInWebviewDoesNotExistBy("//div[contains(@class, 'hl-yellow-box')]");
        assertElementInWebviewDoesNotExistBy("//div[contains(@class,'stickyNote')]");
    }

    @Test
    public void AnnotationCancelDeleteHighlightWithNote() throws Exception {
        AnnotationMenuCreateNote();
        ClickUIElementByAccessibilityID("Navigate up");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[\" + (templist.size()-1)+\"]");
        OpenAnnotationMenuFromAnnotation(WebElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]"), "Remove");
        assertRemoveAnnotationPopup();
        ClickUIElementByID(AppId("md_button_negative"));
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[\" + (templist.size()-1)+\"]");
        assertElementInWebviewExistsBy("//div[contains(@class, 'hl-yellow-box')]");
        assertElementInWebviewExistsBy("//div[contains(@class,'stickyNote')]");
    }

    @Test
    public void AnnotationDeleteHighlightWithLink() throws Exception {
        AnnotationMenuCreateLinkToSingleChapterBook();
        ClickUIElementByAccessibilityID("Navigate up");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[\" + (templist.size()-1)+\"]");
        OpenAnnotationMenuFromAnnotation(WebElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]"), "Remove");
        assertRemoveAnnotationPopup();
        ClickUIElementByID(AppId("md_button_positive"));
        assertElementInWebviewDoesNotExistBy("//div[contains(@class, 'hl-yellow-box')]");
        assertElementInWebviewDoesNotExistBy("//div[contains(@class,'stickyLink')]");
    }

    @Test
    public void AnnotationCancelDeleteHighlightWithLink() throws Exception {
        AnnotationMenuCreateLinkToSingleChapterBook();
        ClickUIElementByAccessibilityID("Navigate up");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[\" + (templist.size()-1)+\"]");
        OpenAnnotationMenuFromAnnotation(WebElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]"), "Remove");
        assertRemoveAnnotationPopup();
        ClickUIElementByID(AppId("md_button_negative"));
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[\" + (templist.size()-1)+\"]");
        assertElementInWebviewExistsBy("//div[contains(@class, 'hl-yellow-box')]");
        assertElementInWebviewExistsBy("//div[contains(@class,'stickyLink')]");
    }

    @Test
    public void AnnotationDeleteHighlightWithTag() throws Exception {
        AnnotationMenuCreateTag();
        ClickUIElementByAccessibilityID("Navigate up");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[\" + (templist.size()-1)+\"]");
        OpenAnnotationMenuFromAnnotation(WebElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]"), "Remove");
        assertRemoveAnnotationPopup();
        ClickUIElementByID(AppId("md_button_positive"));
        assertElementInWebviewDoesNotExistBy("//div[contains(@class, 'hl-yellow-box')]");
        assertElementInWebviewDoesNotExistBy("//div[contains(@class,'stickyTag')]");
    }

    @Test
    public void AnnotationCancelDeleteHighlightWithTag() throws Exception {
        AnnotationMenuCreateTag();
        ClickUIElementByAccessibilityID("Navigate up");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[\" + (templist.size()-1)+\"]");
        OpenAnnotationMenuFromAnnotation(WebElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]"), "Remove");
        assertRemoveAnnotationPopup();
        ClickUIElementByID(AppId("md_button_negative"));
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[\" + (templist.size()-1)+\"]");
        assertElementInWebviewExistsBy("//div[contains(@class, 'hl-yellow-box')]");
        assertElementInWebviewExistsBy("//div[contains(@class,'stickyTag')]");
    }

    @Test
    public void AnnotationDeleteHighlightNoteWithLink() throws Exception {
        AnnotationMenuCreateNoteWithLink();
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByAccessibilityID("Navigate up");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[\" + (templist.size()-1)+\"]");
        OpenAnnotationMenuFromAnnotation(WebElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]"), "Remove");
        assertRemoveAnnotationPopup();
        ClickUIElementByID(AppId("md_button_positive"));
        assertElementInWebviewDoesNotExistBy("//div[contains(@class, 'hl-yellow-box')]");
        assertElementInWebviewDoesNotExistBy("//div[contains(@class,'stickyNote')]");
    }

    @Test
    public void AnnotationCancelDeleteHighlightNoteWithLink() throws Exception {
        AnnotationMenuCreateNoteWithLink();
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByAccessibilityID("Navigate up");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[\" + (templist.size()-1)+\"]");
        OpenAnnotationMenuFromAnnotation(WebElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]"), "Remove");
        assertRemoveAnnotationPopup();
        ClickUIElementByID(AppId("md_button_negative"));
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[\" + (templist.size()-1)+\"]");
        assertElementInWebviewExistsBy("//div[contains(@class, 'hl-yellow-box')]");
        assertElementInWebviewExistsBy("//div[contains(@class,'stickyNote')]");
    }

    @Test
    public void AnnotationAddSelectionToNewNotebook() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "5", "");
        OpenAnnotationMenu("p1", "Add to");
        assertAddToNotebookScreen(true);
        CreateNotebookFromAddToNotebookAndAssert("Test Notebook", true);
        ClickUIElementByResourceID("org.lds.ldssa." + GospelLibraryBuild + ":id/notebookCheckBox");
        ClickUIElementByAccessibilityID("Navigate up");
        AnnotationsSyncCheck("No Thanks");
        assertElementInWebviewExistsBy("//div[contains(@class, 'hl-yellow-box')]");
        assertElementInWebviewExistsBy("//div[contains(@class,'stickyNotebook')]");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]");
        templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        OpenAnnotationMenuFromAnnotation(WebElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]"), "Add to");
        assert Boolean.parseBoolean(WebElementByResourceId("org.lds.ldssa." + GospelLibraryBuild + ":id/notebookCheckBox").getAttribute("checked"));
    }

    @Test
    public void AnnotationMenuRecentHighlightStyles() throws Exception {
        skipLogin();
        TestCheckAnnotationStyleAndColor("underline", "orange");
        ClickUIElementByAccessibilityID("Navigate up");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]");
        templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        OpenAnnotationMenuFromAnnotation(WebElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size() - 1) + "]"), "Remove");
        OpenAnnotationMenu("p1", "Mark");
        templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size()) + "]");
        assertElementInWebviewExistsBy("//div[contains(@class, '" + "hl-" + "orange" + "-" + "underline" + "')]");
    }


    //********** General Conference Section **********

    @Test
    public void generalConferenceVerifyAll() throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByText("General Conference", false));
        ClickUIElementByText("General Conference", false);
        int cYear = parseInt(getLatestConferenceYear());
        String cMonth = getLatestConferenceMonth();
        if (cMonth == "April") {
            scrollDownTo("April " + cYear);
            assertElementExistsBy(WebElementsByText("April " + cYear, false));
            ClickUIElementByXpath("//*[@text=\"April " + cYear + "\"]/../../android.widget.ImageView[2]");
            assertElementExistsBy(WebElementsByText("Download", false));
            assertElementExistsBy(WebElementsByText("Add to…", false));
            ClickUIElementByText("Download", false);
            cYear = cYear - 1;
        }
        while (cYear >= 1971) {
            scrollDownTo("October " + cYear);
            assertElementExistsBy(WebElementsByText("October " + cYear, false));
            assertElementExistsBy(WebElementsByXpath("//*[@text=\"October " + cYear + "\"]/../../android.widget.ImageView[2]"));
            ClickUIElementByXpath("//*[@text=\"October " + cYear + "\"]/../../android.widget.ImageView[2]");
            assertElementExistsBy(WebElementsByText("Download", false));
            assertElementExistsBy(WebElementsByText("Add to…", false));
            ClickUIElementByText("Download", false);
            scrollDownTo("April " + cYear);
            assertElementExistsBy(WebElementsByText("April " + cYear, false));
            assertElementExistsBy(WebElementsByXpath("//*[@text=\"April " + cYear + "\"]/../../android.widget.ImageView[2]"));
            ClickUIElementByXpath("//*[@text=\"April " + cYear + "\"]/../../android.widget.ImageView[2]");
            assertElementExistsBy(WebElementsByText("Download", false));
            assertElementExistsBy(WebElementsByText("Add to…", false));
            ClickUIElementByText("Download", false);
            cYear = cYear - 1;
        }

    }

    @Test
    public void generalConferenceDownloadAllFromMoreOptionsMenu() throws Exception {
        // Just checks 1 download to save time
        skipLogin();
        assertElementExistsBy(WebElementsByText("General Conference", false));
        ClickUIElementByText("General Conference", false);
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Download All", false));
        ClickUIElementByText("Download All", false);
        assertElementExistsBy(WebElementsById(AppId("md_text_title")));
        verifyText("Download All", WebElementById(AppId("md_text_title")), false);
        assertElementExistsBy(WebElementsById(AppId("md_text_message")));
        // Can't be sure of number of item to download verifyText("94 items will be downloaded. Download selected items?",WebElementById(AppId("md_text_message"));
        assertElementExistsBy(WebElementsById(AppId("md_button_negative")));
        verifyText("CANCEL", WebElementById(AppId("md_button_negative")), false);
        assertElementExistsBy(WebElementsById(AppId("md_button_positive")));
        verifyText("DOWNLOAD ALL", WebElementById(AppId("md_button_positive")), false);
        ClickUIElementByID(AppId("md_button_positive"));
        Thread.sleep(milliseconds_5);
        Thread.sleep(milliseconds_5);
        String latestConference = getLatestConference();
        int cYear = parseInt(getLatestConferenceYear());
        scrollDownTo(latestConference);
        assertElementExistsBy(WebElementsByText(latestConference, false));
        ClickUIElementByXpath("//*[@text=\"" + latestConference + "\"]/../../android.widget.ImageView[2]");
        assertElementExistsBy(WebElementsByText("Remove", false));
        assertElementExistsBy(WebElementsByText("Add to…", false));
        dismissDialog(WebElementByXpath("/hierarchy/android.widget.FrameLayout"));

    }


    @Test
    public void generalConferenceRemoveAllFromMoreOptionsMenu() throws Exception {
        // Just checks 1 download to save time
        skipLogin();
        assertElementExistsBy(WebElementsByText("General Conference", false));
        ClickUIElementByText("General Conference", false);
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Download All", false));
        ClickUIElementByText("Download All", false);
        assertElementExistsBy(WebElementsById(AppId("md_text_title")));
        verifyText("Download All", WebElementById(AppId("md_text_title")), false);
        assertElementExistsBy(WebElementsById(AppId("md_text_message")));
        // Can't be sure of number of item to download verifyText("94 items will be downloaded. Download selected items?",WebElementById(AppId("md_text_message"));
        assertElementExistsBy(WebElementsById(AppId("md_button_negative")));
        verifyText("CANCEL", WebElementById(AppId("md_button_negative")), false);
        assertElementExistsBy(WebElementsById(AppId("md_button_positive")));
        verifyText("DOWNLOAD ALL", WebElementById(AppId("md_button_positive")), false);
        ClickUIElementByID(AppId("md_button_positive"));
        Thread.sleep(milliseconds_5);
        Thread.sleep(milliseconds_5);
        Thread.sleep(milliseconds_5);
        String latestConference = getLatestConference();
        int cYear = parseInt(getLatestConferenceYear());
        scrollDownTo(latestConference);
        assertElementExistsBy(WebElementsByText(latestConference, false));
        ClickUIElementByXpath("//*[@text=\"" + latestConference + "\"]/../../android.widget.ImageView[2]");
        assertElementExistsBy(WebElementsByText("Remove", false));
        assertElementExistsBy(WebElementsByText("Add to…", false));
        dismissDialog(WebElementByXpath("/hierarchy/android.widget.FrameLayout"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Remove All", false));
        ClickUIElementByText("Remove All", false);
        assertElementExistsBy(WebElementsById(AppId("md_text_title")));
        verifyText("Remove All", WebElementById(AppId("md_text_title")), false);
        assertElementExistsBy(WebElementsById(AppId("md_text_message")));
        verifyText("Are you sure you want to remove the selected items?", WebElementById(AppId("md_text_message")), false);
        assertElementExistsBy(WebElementsById(AppId("md_button_negative")));
        verifyText("CANCEL", WebElementById(AppId("md_button_negative")), false);
        assertElementExistsBy(WebElementsById(AppId("md_button_positive")));
        verifyText("REMOVE ALL", WebElementById(AppId("md_button_positive")), false);
        ClickUIElementByID(AppId("md_button_positive"));
        Thread.sleep(milliseconds_5);
        scrollDownTo(latestConference);
        assertElementExistsBy(WebElementsByText(latestConference, false));
        ClickUIElementByXpath("//*[@text=\"" + latestConference + "\"]/../../android.widget.ImageView[2]");
        assertElementExistsBy(WebElementsByText("Download", false));
        assertElementExistsBy(WebElementsByText("Add to…", false));


    }


    @Test
    public void generalConferenceDownloadAllFromLibraryContextMenu() throws Exception {
        // Just checks 1 download to save time
        skipLogin();
        assertElementExistsBy(WebElementsByText("General Conference", false));
        assertElementExistsBy(WebElementsByXpath("//*[@text='General Conference']/../../android.widget.ImageView[2]"));
        ClickUIElementByXpath("//*[@text='General Conference']/../../android.widget.ImageView[2]");
        assertElementExistsBy(WebElementsByText("Download All", false));
        assertElementExistsBy(WebElementsByText("Remove All", false));
        ClickUIElementByText("Download All", false);
        assertElementExistsBy(WebElementsById(AppId("md_text_title")));
        verifyText("Download All", WebElementById(AppId("md_text_title")), false);
        assertElementExistsBy(WebElementsById(AppId("md_text_message")));
        // Can't be sure of number of item to download verifyText("94 items will be downloaded. Download selected items?",WebElementById(AppId("md_text_message"));
        assertElementExistsBy(WebElementsById(AppId("md_button_negative")));
        verifyText("CANCEL", WebElementById(AppId("md_button_negative")), false);
        assertElementExistsBy(WebElementsById(AppId("md_button_positive")));
        verifyText("DOWNLOAD ALL", WebElementById(AppId("md_button_positive")), false);
        ClickUIElementByID(AppId("md_button_positive"));
        ClickUIElementByText("General Conference", false);
        Thread.sleep(milliseconds_5);
        Thread.sleep(milliseconds_5);
        String latestConference = getLatestConference();
        int cYear = parseInt(getLatestConferenceYear());
        scrollDownTo(latestConference);
        assertElementExistsBy(WebElementsByText(latestConference, false));
        ClickUIElementByXpath("//*[@text=\"" + latestConference + "\"]/../../android.widget.ImageView[2]");
        assertElementExistsBy(WebElementsByText("Remove", false));
        assertElementExistsBy(WebElementsByText("Add to…", false));
        dismissDialog(WebElementByXpath("/hierarchy/android.widget.FrameLayout"));

    }


    @Test
    public void generalConferenceRemoveAllFromLibraryContextMenu() throws Exception {
        //Just checks 1 removal to save time
        skipLogin();
        assertElementExistsBy(WebElementsByText("General Conference", false));
        assertElementExistsBy(WebElementsByXpath("//*[@text='General Conference']/../../android.widget.ImageView[2]"));
        ClickUIElementByXpath("//*[@text='General Conference']/../../android.widget.ImageView[2]");
        assertElementExistsBy(WebElementsByText("Download All", false));
        assertElementExistsBy(WebElementsByText("Remove All", false));
        ClickUIElementByText("Download All", false);
        assertElementExistsBy(WebElementsById(AppId("md_text_title")));
        verifyText("Download All", WebElementById(AppId("md_text_title")), false);
        assertElementExistsBy(WebElementsById(AppId("md_text_message")));
        // Can't be sure of number of item to download verifyText("94 items will be downloaded. Download selected items?",WebElementById(AppId("md_text_message"));
        assertElementExistsBy(WebElementsById(AppId("md_button_negative")));
        verifyText("CANCEL", WebElementById(AppId("md_button_negative")), false);
        assertElementExistsBy(WebElementsById(AppId("md_button_positive")));
        verifyText("DOWNLOAD ALL", WebElementById(AppId("md_button_positive")), false);
        ClickUIElementByID(AppId("md_button_positive"));
        ClickUIElementByText("General Conference", false);
        Thread.sleep(milliseconds_5);
        Thread.sleep(milliseconds_5);
        String latestConference = getLatestConference();
        int cYear = parseInt(getLatestConferenceYear());
        scrollDownTo(latestConference);
        assertElementExistsBy(WebElementsByText(latestConference, false));
        ClickUIElementByXpath("//*[@text=\"" + latestConference + "\"]/../../android.widget.ImageView[2]");
        assertElementExistsBy(WebElementsByText("Remove", false));
        assertElementExistsBy(WebElementsByText("Add to…", false));
        dismissDialog(WebElementByXpath("/hierarchy/android.widget.FrameLayout"));
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        ClickUIElementByAccessibilityID("Navigate up");
        assertElementExistsBy(WebElementsByText("General Conference", false));
        assertElementExistsBy(WebElementsByXpath("//*[@text='General Conference']/../../android.widget.ImageView[2]"));
        ClickUIElementByXpath("//*[@text='General Conference']/../../android.widget.ImageView[2]");
        assertElementExistsBy(WebElementsByText("Download All", false));
        assertElementExistsBy(WebElementsByText("Remove All", false));
        ClickUIElementByText("Remove All", false);
        assertElementExistsBy(WebElementsById(AppId("md_text_title")));
        verifyText("Remove All", WebElementById(AppId("md_text_title")), false);
        assertElementExistsBy(WebElementsById(AppId("md_text_message")));
        verifyText("Are you sure you want to remove the selected items?", WebElementById(AppId("md_text_message")), false);
        assertElementExistsBy(WebElementsById(AppId("md_button_negative")));
        verifyText("CANCEL", WebElementById(AppId("md_button_negative")), false);
        assertElementExistsBy(WebElementsById(AppId("md_button_positive")));
        verifyText("REMOVE ALL", WebElementById(AppId("md_button_positive")), false);
        ClickUIElementByID(AppId("md_button_positive"));
        assertElementExistsBy(WebElementsByText("General Conference", false));
        ClickUIElementByText("General Conference", false);
        Thread.sleep(milliseconds_5);
        scrollDownTo(latestConference);
        assertElementExistsBy(WebElementsByText(latestConference, false));
        ClickUIElementByXpath("//*[@text=\"" + latestConference + "\"]/../../android.widget.ImageView[2]");
        assertElementExistsBy(WebElementsByText("Download", false));
        assertElementExistsBy(WebElementsByText("Add to…", false));


    }

    @Test
    public void generalConferenceDownloadLatestConferenceViaContextMenu() throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByText("General Conference", false));
        ClickUIElementByText("General Conference", false);
        String latestConference = getLatestConference();
        ClickUIElementByXpath("//*[@text=\"" + latestConference + "\"]/../../android.widget.ImageView[2]");
        assertElementExistsBy(WebElementsByText("Download", false));
        assertElementExistsBy(WebElementsByText("Add to…", false));
        ClickUIElementByText("Download", false);
        Thread.sleep(milliseconds_5);
        Thread.sleep(milliseconds_5);
        ClickUIElementByXpath("//*[@text=\"" + latestConference + "\"]/../../android.widget.ImageView[2]");
        assertElementExistsBy(WebElementsByText("Remove", false));
        assertElementExistsBy(WebElementsByText("Add to…", false));
        ClickUIElementByText("Remove", false);
        assertElementExistsBy(WebElementsById(AppId("md_text_title")));
        verifyText("Remove", WebElementById(AppId("md_text_title")), false);
        assertElementExistsBy(WebElementsById(AppId("md_text_message")));
        verifyText("Are you sure you want to remove the selected items?", WebElementById(AppId("md_text_message")), false);
        assertElementExistsBy(WebElementsById(AppId("md_button_negative")));
        verifyText("CANCEL", WebElementById(AppId("md_button_negative")), false);
        assertElementExistsBy(WebElementsById(AppId("md_button_positive")));
        verifyText("REMOVE", WebElementById(AppId("md_button_positive")), false);
        ClickUIElementByID(AppId("md_button_positive"));
        Thread.sleep(milliseconds_1);
        ClickUIElementByXpath("//*[@text=\"" + latestConference + "\"]/../../android.widget.ImageView[2]");
        assertElementExistsBy(WebElementsByText("Download", false));
        assertElementExistsBy(WebElementsByText("Add to…", false));
        dismissDialog(WebElementByXpath("/hierarchy/android.widget.FrameLayout"));

    }

    @Test
    public void generalConferenceListenToAudioSessionAutoProgress() throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByText("General Conference", false));
        ClickUIElementByText("General Conference", false);
        scrollDownTo("October 2017");
        assertElementExistsBy(WebElementsByText("October 2017", false));
        ClickUIElementByText("October 2017", false);
        Thread.sleep(milliseconds_2);
        ClickUIElementByText("October 2017", false);
        assertElementExistsBy(WebElementsByText("General Women’s Session", false));
        ClickUIElementByText("General Women’s Session", false);
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsById(AppId("mainToolbarTextLayout")));
        assertElementExistsBy(WebElementsById(AppId("mainToolbarTitleTextView")));
        verifyText("General Women’s Session", WebElementById(AppId("mainToolbarTitleTextView")), false);
        assertElementExistsBy(WebElementsById(AppId("mainToolbarSubTitleTextView")));
        verifyText("October 2017", WebElementById(AppId("mainToolbarSubTitleTextView")), false);
        assertElementExistsBy(WebElementsById(AppId("dropArrowImageView")));
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmarks"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        //Play Button
        assertElementExistsBy(WebElementsByXpath("//*[@text = \"General Women’s Session\"]/android.view.View/android.view.View/android.view.View/android.widget.Image[1]"));
        //Download Button
        assertElementExistsBy(WebElementsByXpath("//*[@text = \"General Women’s Session\"]/android.view.View/android.view.View/android.view.View/android.widget.Image[2]"));
        //Audio FAB
        assertElementExistsBy(WebElementsById(AppId("mediaFab")));
        ClickUIElementByID(AppId("mediaFab"));
        assertAudioPlayerUI("General Women’s Session", "October 2017", "00:00", "1:25:25", true, false);
        ClickSeekBarAt(WebElementById(AppId("seekBar")), 7);
        Thread.sleep(milliseconds_1);
        verifyText("1:25:25", WebElementById(AppId("currentPositionTextView")), false);
        WebElementById(AppId("playPauseButton")).click();
        Thread.sleep(500);
        ClickUIElementByID(AppId("playPauseButton"));
        assertAudioPlayerUI("Saturday Morning Session", "October 2017", WebElementById(AppId("currentPositionTextView")).getText(), "2:01:59", false, false);


    }

    //********** Search Section **********

    @Test
    public void ElementsOnSearchScreen() throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        ClickUIElementByAccessibilityID("Search");
        // Back button on search screen
        assertElementExistsBy(WebElementsById(AppId("backImageView")));
        // Search box
        assertElementExistsBy(WebElementsById(AppId("searchEditText")));
        // Placeholder text
        verifyText("Search All Content", WebElementById(AppId("searchEditText")), false);
    }

}



