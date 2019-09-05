package UI;

        import io.appium.java_client.AppiumDriver;
        import io.appium.java_client.TouchAction;
        import javafx.util.Pair;
        import org.junit.Assert;
        import org.openqa.selenium.By;
        import org.openqa.selenium.JavascriptExecutor;
        import org.openqa.selenium.WebElement;

        import java.text.DateFormat;
        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;
        import java.util.Set;

        import static UI.Strings.*;
        import static UI.EnvironmentConfig.*;
        import static java.lang.Integer.parseInt;
        import static org.junit.jupiter.api.Assertions.fail;


public class mainFunctions {
    AppiumDriver driver;


    //Replaces letters with dots
    public String hidePassword(String password) throws Exception {
        String passwordDotted = "";
        if (AndroidVersion > 6) {
            int passwordLength = password.length();
            for (int i = 0; i < passwordLength; i++) {
                passwordDotted = passwordDotted.concat("•");
            }
        }
        return passwordDotted;
    }

    //Changes text to caps if on android 7 or higher
    public String isAllCaps(String text) throws Exception{
        if (AndroidVersion > 6) {
            text = text.toUpperCase();
        }
        System.out.println(text);
        return text;
    };

    public String isAndroidVersion(String androidSixAndBelow, String androidSevenAndUp){
        if (AndroidVersion > 6){
            return androidSevenAndUp;
        }else{
            return androidSixAndBelow;
        }
    }
    //Get Element by text
    public String FindElementByText(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized){
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
        if (isCapitalized){
            text = isAllCaps(text);
        }
        String xPathofText = "//android.widget.TextView[@text='" + text + "']";
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        WebElement tempElement = driver.findElement(By.xpath(xPathofText));
        return tempElement;
    }

    //Create WebElement by text view.View
    public WebElement WebElementByTextViewView(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized){
            text = isAllCaps(text);
        }
        String xPathofText = "//android.view.View[@text='" + text + "']";
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        WebElement tempElement = driver.findElement(By.xpath(xPathofText));
        return tempElement;
    }

    //Create WebElement by CheckedTextView
    public WebElement WebElementByCheckedText(String text) throws Exception {
        String xPathofText = "//android.widget.CheckedTextView[@text='" + text + "']";
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        WebElement tempElement = driver.findElement(By.xpath(xPathofText));
        return tempElement;
    }

    //Create WebElements by text (List)
    public List WebElementsByText(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized){
            text = isAllCaps(text);
        }
        String xPathofText = "//android.widget.TextView[@text='" + text + "']";
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        List tempElement = driver.findElements(By.xpath(xPathofText));
        return tempElement;
    }

    //Create WebElements by text contains (List)
    public List WebElementsByTextContains(String text) throws Exception {
        String xPathofText = "//android.widget.TextView[contains(@text, '" + text + "')]";
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        List tempElement = driver.findElements(By.xpath(xPathofText));
        return tempElement;
    }

    //Create WebElements by Checked text (List)
    public List WebElementsByCheckedText(String CheckedText, Boolean isCapitalized) throws Exception {
        if (isCapitalized){
            CheckedText = isAllCaps(CheckedText);
        }
        String xPathofText = "//android.widget.CheckedTextView[@text='" + CheckedText + "']";
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        List tempElement = driver.findElements(By.xpath(xPathofText));
        return tempElement;
    }

    //Create WebElements by id
    public List WebElementsById(String id) throws Exception {
        List tempElement = driver.findElementsById(id);
        return tempElement;
    }

    //Create WebElements by resource-id
    public List WebElementsByResourceId(String id) throws Exception {
        List tempElement = WebElementsByXpath("//*[@resource-id=\""+id+"\"]");
        return tempElement;
    }

    //Create WebElements by accessibility id
    public List WebElementsByAccessibilityId(String id) throws Exception {
        List tempElement = driver.findElementsByAccessibilityId(id);
        return tempElement;
    }

    //Create WebElements by xpath (list)
    public List WebElementsByXpath(String xpath) throws Exception {
        String xPathofText = xpath;
        System.out.println("Xpath of current item is: "+xPathofText+"");
        List tempElement = driver.findElements(By.xpath(xPathofText));
        return tempElement;
    }

    //Create WebElement by id
    public WebElement WebElementById(String id) throws Exception {
        WebElement tempElement = driver.findElementById(id);
        return tempElement;
    }

    //Create WebElement by resource-id
    public WebElement WebElementByResourceId(String id) throws Exception{
        WebElement tempElement = WebElementByXpath("//*[@resource-id='"+id+"']");
        return tempElement;
    }

    //Create WebElement by AccessibilityId
    public WebElement WebElementByAccessibilityId(String accessibilityid) throws Exception {
        WebElement tempElement = driver.findElementByAccessibilityId(accessibilityid);
        return tempElement;
    }

    //Create WebElement for settings Switch by text
    public WebElement WebElementSettingSwitchByText(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized){
            text = isAllCaps(text);
        }
        WebElement tempElement = driver.findElementByXPath("//android.widget.TextView[@text='" + text + "']/../../android.widget.LinearLayout/android.widget.Switch");
        return tempElement;
    }

    //Click Element in Webview
    public void ClickUIElementInWebviewByXPath(String xPath) throws Exception{
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        Set<String> windowHandles = driver.getWindowHandles();
        windowHandles.size();
        for (String window: windowHandles) {
            driver.switchTo().window(window);
            System.out.println("Window handle is now: "+ window);
        }

        ClickUIElementByXpath(xPath);
        driver.context("NATIVE_APP");
    }

    //Click Element by Text
    public void ClickUIElementByText(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized){
            text = isAllCaps(text);
        }
        String xPathofText = "//android.widget.TextView[@text='" + text + "']";
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        WebElement itemToClick = driver.findElement(By.xpath(xPathofText));
        itemToClick.click();
        System.out.println("Clicking: '" + text + "' using text by xPath with TextView");
        Thread.sleep(milliseconds_2);
    }

    //Click Element by Text
    public void ClickUIElementByTextContains(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized){
            text = isAllCaps(text);
        }
        String xPathofText = "//android.widget.TextView[contains(@text, '" + text + "')]";
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        WebElement itemToClick = driver.findElement(By.xpath(xPathofText));
        itemToClick.click();
        System.out.println("Clicking: '" + text + "' using text by xPath with TextView");
        Thread.sleep(milliseconds_2);
    }

    //Click Element by Text view.View
    public void ClickUIElementByTextViewView(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized){
            text = isAllCaps(text);
        }
        String xPathofText = "//android.view.View[@text='" + text + "']";
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        WebElement itemToClick = driver.findElement(By.xpath(xPathofText));
        itemToClick.click();
        System.out.println("Clicking: '" + text + "' using text by xPath with view.View");
        Thread.sleep(milliseconds_2);
    }

    //Click Element by Checked Text
    public void ClickUIElementByCheckedText(String text, Boolean isCapitalized) throws Exception {
        if (isCapitalized){
            text = isAllCaps(text);
        }
        String xPathofText = "//android.widget.CheckedTextView[@text='" + text + "']";
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        WebElement itemToClick = driver.findElement(By.xpath(xPathofText));
        itemToClick.click();
        System.out.println("Clicking: '" + text + "' using text by xPath with CheckedTextView");
        Thread.sleep(milliseconds_2);
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
        Thread.sleep(milliseconds_2);
    }

    //Click Element by Accessibility ID
    public void ClickUIElementByAccessibilityID(String elementAccessibilityID) throws Exception {
        WebElement itemToClick = driver.findElementByAccessibilityId(elementAccessibilityID);
        itemToClick.click();
        System.out.println("Clicking: '" + elementAccessibilityID + "' by Accessibility ID");
        Thread.sleep(milliseconds_2);
    }

    //Click Element by ID
    public void ClickUIElementByID(String elementID) throws Exception {
        WebElement itemToClick = driver.findElementById(elementID);
        itemToClick.click();
        System.out.println("Clicking: '" + elementID + "' by ID");
        Thread.sleep(milliseconds_2);
    }

    //Click Element by ResourceID
    public void ClickUIElementByResourceID(String elementID) throws Exception {
        WebElement itemToClick = WebElementByResourceId(elementID);
        itemToClick.click();
        System.out.println("Clicking: '" + elementID + "' by ResourceID");
        Thread.sleep(milliseconds_2);
    }

    //Click Element by Xpath
    public void ClickUIElementByXpath(String xpath) throws Exception {
        WebElement itemToClick = driver.findElementByXPath(xpath);
        itemToClick.click();
        System.out.println("Clicking: '" + xpath + "' by xPath");
        Thread.sleep(milliseconds_2);
    }

    //Tap in the center of the screen
    public void TapCenterScreen() throws Exception {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        TouchAction action = new TouchAction(driver);
        action.tap(screenWidth / 2, screenHeight / 2).perform();
        System.out.println("Tapping center of screen");
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

    //Scroll down the page
    public void scrollDown() {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        driver.swipe(screenWidth / 2, screenHeight / 10 * 9, screenWidth / 2, screenHeight / 10 * 2, 2000);
        System.out.println("Scrolling Down...");

    }

    //Scroll up the page
    public void scrollUp() {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        driver.swipe(screenWidth / 2, screenHeight / 10 * 2, screenWidth / 2, screenHeight / 10 * 9, 2000);
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
        if (dialogYLocation + dialogHeight +10 < screenHeight){
            yTapPoint = ((screenHeight - (dialogYLocation + dialogHeight)) / 2 + (dialogYLocation + dialogHeight));
        } else if (dialogYLocation - 10 > 1){
            yTapPoint = (dialogYLocation / 2);
        } else if (dialogXLocation -10 > 1){
            xTapPoint = (dialogXLocation / 2);
        } else if (dialogXLocation + dialogWidth +10 < screenWidth){
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

    public String addTimetoPlaybackTime (String time, int secondsToAdd, int minutesToAdd){
        if (time.length() < 6){
            time = "00:" + time;
        } else if (time.length() < 8) {
            time = "0" + time;
        }
        System.out.println(time);
        int seconds = parseInt(time.substring(6,8));
        int minutes = parseInt(time.substring(3,5));
        int hours = parseInt(time.substring(0,2));
        System.out.println(seconds);
        System.out.println(minutes);
        System.out.println(hours);
        seconds = seconds + secondsToAdd;
        System.out.println(seconds);
        minutes = minutes + minutesToAdd;
        System.out.println(minutes);

        if (seconds >= 60){
            seconds = (seconds - 60);
            minutes = (minutes + 1);
        }
        if (minutes >= 60){
            minutes = (minutes - 60);
            hours = (hours + 1);
        }
        String nSeconds = "";
        String nMinutes = "";
        String nHours = String.valueOf(hours);
        if (seconds < 10){
            nSeconds = "0" + String.valueOf(seconds);
        } else {
            nSeconds = String.valueOf(seconds);
        }
        if (minutes < 10){
            nMinutes = "0" + String.valueOf(minutes);
        } else {
            nMinutes = String.valueOf(minutes);
        }

        String nTime = nHours + ":" + nMinutes + ":" + nSeconds;
        if (parseInt(String.valueOf(nTime.charAt(0))) == 0){
            nTime = nTime.substring(2,7);
        }
        return nTime;

    }


    //assert Audio Player
    public void assertAudioPlayerUI(String title, String subtitle, String startTime, String endTime, boolean isFirstItem, boolean isLastItem) throws Exception{
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/miniPlaybackControls"));
        assertElementExistsBy(WebElementsByXpath("//android.view.ViewGroup[@resource-id='org.lds.ldssa.dev:id/mediaPlaybackToolbar']/android.widget.TextView[1]"));
        verifyText(title,WebElementByXpath("//android.view.ViewGroup[@resource-id='org.lds.ldssa.dev:id/mediaPlaybackToolbar']/android.widget.TextView[1]"),false);
        assertElementExistsBy(WebElementsByXpath("//android.view.ViewGroup[@resource-id='org.lds.ldssa.dev:id/mediaPlaybackToolbar']/android.widget.TextView[2]"));
        verifyText(subtitle, WebElementByXpath("//android.view.ViewGroup[@resource-id='org.lds.ldssa.dev:id/mediaPlaybackToolbar']/android.widget.TextView[2]"),false);
        assertElementExistsBy(WebElementsByXpath("//android.view.ViewGroup[@resource-id='org.lds.ldssa.dev:id/mediaPlaybackToolbar']/android.widget.ImageButton"));
        assertElementExistsBy(WebElementsByXpath("//android.view.ViewGroup[@resource-id='org.lds.ldssa.dev:id/mediaPlaybackToolbar']/android.support.v7.widget.LinearLayoutCompat/android.widget.ImageView[@content-desc=\"More options\"]"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/controlsLayout"));
        if (!isFirstItem) {
            assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/previousButton"));
        }
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/replayButton"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/playPauseButton"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/forwardButton"));
        if (!isLastItem) {
            assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/nextButton"));
        }
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/progressLayout"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/seekBar"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/currentPositionTextView"));
        verifyText(startTime,WebElementById("org.lds.ldssa.dev:id/currentPositionTextView"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/durationTextView"));
        verifyText(endTime,WebElementById("org.lds.ldssa.dev:id/durationTextView"),false);
        //Can't run these because back and forward 10 seconds doesn't work correctly when paused
//        ClickUIElementByID("org.lds.ldssa.dev:id/forwardButton");
//        //add 10 to startTime
//        startTime = addTimetoPlaybackTime(startTime,10,0);
//        verifyText(startTime, WebElementById("org.lds.ldssa.dev:id/currentPositionTextView"));
//        ClickUIElementByID("org.lds.ldssa.dev:id/forwardButton");
//        ClickUIElementByID("org.lds.ldssa.dev:id/forwardButton");
//        //add another 10 to startTime
//        startTime = addTimetoPlaybackTime(startTime,10,0);
//        verifyText(startTime,WebElementById("org.lds.ldssa.dev:id/currentPositionTextView"));
//        ClickUIElementByID("org.lds.ldssa.dev:id/replayButton");
//        //minus 10 from startTime
//        startTime = addTimetoPlaybackTime(startTime,-10,0);
//        verifyText(startTime,WebElementById("org.lds.ldssa.dev:id/currentPositionTextView"));

    }

    //assert Tabs
    public void assertTabs (String screen) throws Exception {
        if (screen == "Notes") {
            assertElementExistsBy(WebElementsByText("All",true));
            assertElementExistsBy(WebElementsByText("Tags", true));
            assertElementExistsBy(WebElementsByText("Notebooks",true));
        } else if (screen == "Bookmarks"){
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
    public void assertMoreOptionsMenu (String screen, Boolean close) throws Exception {

        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        if (screen == "Library") {
            assertElementExistsBy(WebElementsByText("New Screen…", false));
            assertElementExistsBy(WebElementsByText("Custom Collections", false));
            assertElementExistsBy(WebElementsByText("Language…", false));
            assertElementExistsBy(WebElementsByText("Settings", false));
        } else if (screen == "Collection Menu") {
            assertElementExistsBy(WebElementsByText("New Screen…", false));
            assertElementExistsBy(WebElementsByText("Download All", false));
            assertElementExistsBy(WebElementsByText("Remove All", false));
            assertElementExistsBy(WebElementsByText("Language…", false));
            assertElementExistsBy(WebElementsByText("Settings", false));
        } else if (screen == "Book Menu") {
            assertElementExistsBy(WebElementsByText("New Screen…", false));
            assertElementExistsBy(WebElementsByText("Download Audio", false));
            assertElementExistsBy(WebElementsByText("Language…", false));
            assertElementExistsBy(WebElementsByText("Settings", false));
        } else if (screen == "Content Menu") {
            assertElementExistsBy(WebElementsByText("New Screen…", false));
            assertElementExistsBy(WebElementsByText("Related Content", false));
            assertElementExistsBy(WebElementsByText("Share", false));
            assertElementExistsBy(WebElementsByText("Play Audio", false));
            assertElementExistsBy(WebElementsByText("Language…", false));
            assertElementExistsBy(WebElementsByText("Settings", false));
        } else if (screen == "Notes") {
            assertElementExistsBy(WebElementsByText("New Screen…", false));
            assertElementExistsBy(WebElementsByText("Restore Journal", false));
            assertElementExistsBy(WebElementsByText("Language…", false));
            assertElementExistsBy(WebElementsByText("Settings", false));
        } else if (screen == "Notebooks") {
            assertElementExistsBy(WebElementsByText("New Screen…", false));
            assertElementExistsBy(WebElementsByText("Language…", false));
            assertElementExistsBy(WebElementsByText("Settings", false));
        } else if (screen == "Screens") {
            assertElementExistsBy(WebElementsByText("Screen Settings", false));
            assertElementExistsBy(WebElementsByText("Close All Screens", false));
        } else if (screen == "History") {
            assertElementExistsBy(WebElementsByText("Clear History", false));
        } else if (screen == "DownloadsByItem") {
            assertElementExistsBy(WebElementsByText("Sort by Size", false));
            assertElementExistsBy(WebElementsByText("Current Downloads", false));
        } else if (screen == "DownloadsBySize") {
            assertElementExistsBy(WebElementsByText("Sort by Item", false));
            assertElementExistsBy(WebElementsByText("Current Downloads", false));
        } else {
            fail(screen + " is not a valid option for assertMoreOptionsMenu." +
                    "Available screens are:" +
                    "Library" +
                    "Collection Menu" +
                    "Book Menu" +
                    "Content Menu" +
                    "Notes" +
                    "Notebooks" +
                    "Screens" +
                    "History" +
                    "DownloadsByItem" +
                    "DownloadsBySize");
        }
        if (close) {
            dismissDialog(WebElementByXpath("*//android.widget.FrameLayout"));
            assertElementNotPresentBy(WebElementsByText("New Screen…", false));
            assertElementNotPresentBy(WebElementsByText("Cutsom Collections", false));
            assertElementNotPresentBy(WebElementsByText("Download All", false));
            assertElementNotPresentBy(WebElementsByText("Remove All", false));
            assertElementNotPresentBy(WebElementsByText("Download Audio", false));
            assertElementNotPresentBy(WebElementsByText("Related Content", false));
            assertElementNotPresentBy(WebElementsByText("Share", false));
            assertElementNotPresentBy(WebElementsByText("Play Audio", false));
            assertElementNotPresentBy(WebElementsByText("Restore Journal", false));
            assertElementNotPresentBy(WebElementsByText("Language…", false));
            assertElementNotPresentBy(WebElementsByText("Settings", false));
            assertElementNotPresentBy(WebElementsByText("Screen Settings", false));
            assertElementNotPresentBy(WebElementsByText("Close All Screens", false));
            assertElementNotPresentBy(WebElementsByText("Clear History", false));
            assertElementNotPresentBy(WebElementsByText("Sort by Size", false));
            assertElementNotPresentBy(WebElementsByText("Sort by Item", false));
            assertElementNotPresentBy(WebElementsByText("Current Downloads", false));
        }
    }

    //assert downloads screen
    public void assertDownloadScreen(boolean empty)throws Exception{
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText("Downloaded Media", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"),false);
        if (empty) {
            assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateImageView"));
            assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateTitleTextView"));
            verifyText("No Downloaded Media", WebElementById("org.lds.ldssa.dev:id/emptyStateTitleTextView"),false);
            assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateSubTitleTextView"));
            verifyText("Download audio or video for offline access.", WebElementById("org.lds.ldssa.dev:id/emptyStateSubTitleTextView"),false);
        }
    }

    //assert screen item options
    public void assertScreenItemOptions(String title, Boolean close) throws Exception {
        ClickUIElementByXpath("//android.widget.TextView[@text=\""+ title +"\"]/../../android.widget.ImageButton");
        assertElementExistsBy(WebElementsByText("Rename", false));
        assertElementExistsBy(WebElementsByText("Duplicate", false));
        assertElementExistsBy(WebElementsByText("Delete", false));
        if (close) {
            dismissDialog(WebElementByXpath("*//android.widget.FrameLayout"));
        }
    }

    //assert the Nav bar
    public void assertNavBar(String title1, String title2, String title3, String title4, String title5, String title6, Boolean close) throws Exception{

        //Click Main Toolbar
        ClickUIElementByID("org.lds.ldssa.dev:id/mainToolbarTitleTextView");
        Thread.sleep(milliseconds_1);
        assertElementExistsBy(WebElementsByText("Library", false));
        if (title1 != ""){
            assertElementExistsBy(WebElementsByText(title1, false));
            if (title2 != ""){
                assertElementExistsBy(WebElementsByText(title2, false));
                if (title3 != ""){
                    assertElementExistsBy(WebElementsByText(title3, false));
                    if (title4 != ""){
                        assertElementExistsBy(WebElementsByText(title4, false));
                        if (title5 != ""){
                            assertElementExistsBy(WebElementsByText(title5, false));
                            if (title6 != ""){
                                assertElementExistsBy(WebElementsByText(title6, false));
                            }
                        }
                    }
                }
            }
        }

        if (close) {
            //Dismiss the toolbar
            ClickUIElementByID("org.lds.ldssa.dev:id/mainToolbarTitleTextView");
            Thread.sleep(milliseconds_1);
        }
    }

    //Create Notebook and Assert Popup
    public void CreateNotebookandAssert(String title, boolean add) throws Exception{
        ClickUIElementByID("org.lds.ldssa.dev:id/notesFloatingActionButton");
        Thread.sleep(milliseconds_1);
        verifyText("Create Notebook", WebElementByText("Create Notebook", false),false);
        verifyText("0/256",WebElementByResourceId("org.lds.ldssa.dev:id/md_minMax"),false);
        verifyText("CANCEL", WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"),false);
        verifyText("ADD", WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"),false);
        sendText("android:id/input", title);
        verifyText(title.length() + "/256",WebElementByResourceId("org.lds.ldssa.dev:id/md_minMax"),false);
        if (add){
            ClickUIElementByID("org.lds.ldssa.dev:id/md_buttonDefaultPositive");
            Thread.sleep(milliseconds_2);
            verifyText(title, WebElementByText(title,false),false);
        } else {
            ClickUIElementByID("org.lds.ldssa.dev:id/md_buttonDefaultNegative");
            Thread.sleep(milliseconds_2);
            assertElementNotPresentBy(WebElementsByText(title, false));
        }
    }

    //Create new note from notebook
    public void CreateNewNoteFromNotebook(String title, String body) throws Exception{
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/newFloatingActionButton"));
        ClickUIElementByID("org.lds.ldssa.dev:id/newFloatingActionButton");
        Thread.sleep(milliseconds_1);
        //Verify controls present
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/markdown_controls_bold"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/markdown_controls_italic"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/markdown_controls_unordered_list"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/markdown_controls_ordered_list"));
        assertElementExistsBy(WebElementsByAccessibilityId("Add to Notebook"));
        assertElementExistsBy(WebElementsByAccessibilityId("Tag"));
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        //Type Note Text
        sendText("org.lds.ldssa.dev:id/noteTitleEditText", title);
        sendText("org.lds.ldssa.dev:id/markdownEditText", body);

        ClickUIElementByAccessibilityID("Navigate up");
    }

    //Backup
    public void Backup(Boolean signIn) throws Exception{
        //Back Up Annotations?
        verifyText("Back Up Annotations", WebElementByText("Back Up Annotations", false),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"));
        verifyText("SIGN IN",WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"));
        verifyText("NO THANKS",WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultNeutral"));
        verifyText("CREATE LDS ACCOUNT", WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultNeutral"),false);
        if (signIn) {
            ClickUIElementByID("org.lds.ldssa.dev:id/md_buttonDefaultPositive");
            fail("You need to add the login feature to this function to use 'true'");
        } else {
            ClickUIElementByID("org.lds.ldssa.dev:id/md_buttonDefaultNegative");
        }
        Thread.sleep(milliseconds_1);
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
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_title"));
        verifyText("Text Size", WebElementById("org.lds.ldssa.dev:id/md_title"),false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/sampleTextView"));
        verifyText("… behold I say unto you, that by small and simple things are great things brought to pass; and small means in many instances doth confound the wise.", WebElementByResourceId("org.lds.ldssa.dev:id/sampleTextView"),false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/textSizeSeekbar"));
        ClickSeekBarAt(WebElementByResourceId("org.lds.ldssa.dev:id/textSizeSeekbar"), sizeOneThroughSeven);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/md_buttonDefaultNegative"));
        verifyText("Cancel", WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"),true);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/md_buttonDefaultPositive"));
        verifyText("OK", WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"),false);
        ClickUIElementByID("org.lds.ldssa.dev:id/md_buttonDefaultPositive");
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
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/alertTitle"));
        verifyText("Theme", WebElementById("org.lds.ldssa.dev:id/alertTitle"),false);
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
        while ((isNotPresent)) {
            System.out.println("" + text + " isn't on the screen... Scrolling to find");
            scrollDown();
            isNotPresent = driver.findElements(By.xpath("//android.widget.TextView[@text='" + text + "']")).size() <= 0;
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
        if (isCapitalized){
            expectedText = isAllCaps(expectedText);
        }
        String webelementActualAsText = webelementActual.getText();
        System.out.println("Validating text Expected: '" + expectedText + "' Actual: '" + webelementActualAsText + "'");
        Assert.assertEquals(expectedText, webelementActualAsText);


    }




    //Verify Object Exists Using WebElementsBy
    public void assertElementExistsBy(List webElementsBy) {
        Boolean tempElement = webElementsBy.size() > 0;
        System.out.println("assert element is present. Expected: true [] Actual: " + tempElement + " Element: " + webElementsBy.toString() + "");
        assert tempElement == true;
    }

    public void assertElementInWebviewExistsBy(String xPath) throws Exception{
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        Set <java.lang.String> windowHandles = driver.getWindowHandles();
        windowHandles.size();
        for (String window: windowHandles) {
            driver.switchTo().window(window);
            System.out.println("Window handle is now: "+ window);
        }

        Boolean tempElement = WebElementsByXpath(xPath).size() > 0;
        System.out.println("assert element is present. Expected: true [] Actual: " + tempElement + " Element: " + xPath.toString() + "");
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
            verifyText("ON", CurrentSettingsSwitch,false);
            assert CurrentSettingSwitchBool;
            CurrentSettingsSwitch.click();
            verifyText("OFF", CurrentSettingsSwitch,false);
            CurrentSettingSwitchBool = Boolean.parseBoolean(CurrentSettingsSwitch.getAttribute("checked"));
            assert !CurrentSettingSwitchBool;
        } else {
            verifyText("OFF", CurrentSettingsSwitch,false);
            assert CurrentSettingSwitchBool == false;
            CurrentSettingsSwitch.click();
            verifyText("ON", CurrentSettingsSwitch,false);
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
            verifyText(titlebarBookTitle, driver.findElementByXPath(FindElementByContainsText(bookTitle)),false);
            if (numberOfChapters > 1) {
                //Check Title bar when Chapter is displayed
                ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout");
                Thread.sleep(milliseconds_1);
                String titlebarBookTitle2 = "";
                if (bookTitle == "Psalms") {
                    titlebarBookTitle2 = "Psalm " + "1";
                    verifyText(titlebarBookTitle2, driver.findElementByXPath(FindElementByContainsText("Psalm")),false);
                } else {
                    titlebarBookTitle2 = "" + bookTitle + " 1";
                    verifyText(titlebarBookTitle2, driver.findElementByXPath(FindElementByContainsText(titlebarBookTitle2)),false);
                }

                ClickUIElementByID("Navigate up");
                Thread.sleep(milliseconds_1);

                //Verify all of the chapters are present
                for (int j = 1; j <= numberOfChapters; j++) {
                    String chapterNumberString = String.valueOf(j);
                    scrollDownTo(chapterNumberString);

                    WebElement chapterNumber = driver.findElement(By.xpath(FindElementByText(chapterNumberString, false)));
                    verifyText(chapterNumberString, chapterNumber,false);

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

    public void signInPage(String LoginUserName, String LoginPassword, String button, Boolean validLogin)throws Exception{
        //Username field
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/ldsaccount_login_username_layout"));
        verifyText("Username",WebElementByResourceId("org.lds.ldssa.dev:id/ldsaccount_login_username_layout"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/usernameEditText"));
        //Password field
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/ldsaccount_login_password_layout"));
        verifyText("Password",WebElementByResourceId("org.lds.ldssa.dev:id/ldsaccount_login_password_layout"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/passwordEditText"));
        //Password visibility
        assertElementExistsBy(WebElementsByAccessibilityId("Toggle password visibility"));
        //Sign in Button
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/ldsAccountSignInButton"));
        verifyText("Sign In",WebElementByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/ldsAccountSignInButton\"]/android.widget.TextView"),true);
        //Having Trouble Signing In
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/ldsAccountLoginForgotCredentialsButton"));
        verifyText("Having Trouble Signing In?",WebElementByResourceId("org.lds.ldssa.dev:id/ldsAccountLoginForgotCredentialsButton"),true);
        //Create LDS Account
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/ldsAccountLoginCreateAccountButton"));
        verifyText("Create LDS Account", WebElementByResourceId("org.lds.ldssa.dev:id/ldsAccountLoginCreateAccountButton"),true);



        sendText("org.lds.ldssa.dev:id/usernameEditText", LoginUserName);
        sendText("org.lds.ldssa.dev:id/passwordEditText", LoginPassword);
        boolean passwordVisibility = Boolean.parseBoolean((WebElementByAccessibilityId("Toggle password visibility").getAttribute("checked")));
        System.out.println(passwordVisibility);
        assert !passwordVisibility;
        verifyText(hidePassword(LoginPassword), WebElementById("org.lds.ldssa.dev:id/passwordEditText"),false);
        ClickUIElementByAccessibilityID("Toggle password visibility");
        Thread.sleep(milliseconds_1);
        passwordVisibility = Boolean.parseBoolean((WebElementByAccessibilityId("Toggle password visibility").getAttribute("checked")));
        System.out.println(passwordVisibility);
        assert passwordVisibility;
        verifyText(LoginPassword, WebElementById("org.lds.ldssa.dev:id/passwordEditText"),false);
        if (button == "Sign In"){
            if (validLogin){
                ClickUIElementByID("org.lds.ldssa.dev:id/ldsAccountSignInButton");
            } else {
                sendText("org.lds.ldssa.dev:id/passwordEditText", "MabelWasHere");
                ClickUIElementByID("org.lds.ldssa.dev:id/ldsAccountSignInButton");
                //appium can't validate ! if Username not entered and SignIn clicked
                Thread.sleep(milliseconds_1);
                verifyText("Error", WebElementByText("Error", false),false);
                ClickUIElementByText("OK", false);
                sendText("org.lds.ldssa.dev:id/passwordEditText", LoginPassword);
                ClickUIElementByID("org.lds.ldssa.dev:id/ldsAccountSignInButton");
            }
        } else if (button == "Having Trouble Signing In") {
            //Having Trouble Signing in
            ClickUIElementByID("org.lds.ldssa.dev:id/ldsAccountLoginForgotCredentialsButton");
            Thread.sleep(milliseconds_5);
            verifyText("https://ldsaccount.lds.org/recovery", WebElementById("com.android.chrome:id/url_bar"),false);
        } else if (button.toLowerCase() == "Create LDS Account"){
            //Create LDS Account
            ClickUIElementByText("Create LDS Account", false);
            Thread.sleep(milliseconds_5);
            verifyText("https://ldsaccount.lds.org/register", WebElementById("com.android.chrome:id/url_bar"),false);
        } else {
            fail("\"" + button + "\" is not a valid button for the Sign In Page. Valid entries are \"Sign In\", \"Having Trouble Signing In\", and \"Create LDS Account\"");
        }


    }

    public void assertMenuBar(String title, String subTitle) throws Exception {
        //assert menu bar
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/mainToolbar"));
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/mainToolbarTextLayout"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/dropArrowImageView"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText(title,WebElementByResourceId("org.lds.ldssa.dev:id/mainToolbarTitleTextView"),false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/mainToolbarSubTitleTextView"));
        verifyText(subTitle,WebElementByResourceId("org.lds.ldssa.dev:id/mainToolbarSubTitleTextView"),false);
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmark"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/mainToolbarSubTitleTextView"));
    }
    public void assertSideBar(String title, Boolean isAnnotation, String annotationType, String TagName) throws Exception {
        //assert sidebar
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/contentDrawerToolbar"));
        //assert close icon
        assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/contentDrawerToolbar\"]/android.widget.ImageButton"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/contentDrawerToolbarTitleTextView"));
        verifyText(title,WebElementByResourceId("org.lds.ldssa.dev:id/contentDrawerToolbarTitleTextView"),false);
        assertElementExistsBy(WebElementsByAccessibilityId("Related Content"));
        assertElementExistsBy(WebElementsByXpath("(//android.widget.ImageView[@content-desc=\"More options\"])[2]"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/sideBarContainer"));
        if (isAnnotation) {
            assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/annotationView"));
            assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/lastModifiedTextView"));
        }
        if (annotationType == "Tag"){
            assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/bubbleLayout"));
            assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/bubbleTextView"));
            verifyText(TagName, WebElementByResourceId("org.lds.ldssa.dev:id/bubbleTextView"), false);
            assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/tag_text"));
        } else if (annotationType == ""){
        } else {
            fail(annotationType + " is not supported. Supported annotations are \"Tag\"");
        }
    }


    public void AnnotationsSyncCheck(String buttonToPress) throws Exception {
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/md_title"));
        verifyText("Back Up Annotations",WebElementByResourceId("org.lds.ldssa.dev:id/md_title"),false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/md_content"));
        verifyText("Signing in with an LDS Account backs up all your highlights, notes, and bookmarks, keeping them safe and making them available on the web or any mobile device.",WebElementByResourceId("org.lds.ldssa.dev:id/md_content"),false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/md_buttonDefaultPositive"));
        verifyText("Sign In",WebElementByResourceId("org.lds.ldssa.dev:id/md_buttonDefaultPositive"),true);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/md_buttonDefaultNegative"));
        verifyText("No Thanks",WebElementByResourceId("org.lds.ldssa.dev:id/md_buttonDefaultNegative"),true);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/md_buttonDefaultNeutral"));
        verifyText("Create LDS Account", WebElementByResourceId("org.lds.ldssa.dev:id/md_buttonDefaultNeutral"), true);
        if (buttonToPress == "Sign In"){
            ClickUIElementByResourceID("org.lds.ldssa.dev:id/md_buttonDefaultPositive");
            signInPage(user,password,"Sign In",true);
        } else if (buttonToPress == "No Thanks"){
            ClickUIElementByResourceID("org.lds.ldssa.dev:id/md_buttonDefaultNegative");
        } else if (buttonToPress == "Create LDS Account"){
            ClickUIElementByResourceID("org.lds.ldssa.dev:id/md_buttonDefaultNeutral");
            Thread.sleep(milliseconds_5);
            verifyText("https://ldsaccount.lds.org/register", WebElementById("com.android.chrome:id/url_bar"),false);
        } else {
            fail("\""+buttonToPress +"\" is not a valid selection. valid buttons are \"Sign In\", \"No Thanks\", and \"Create LDS Account\"");
        }

    }

    public List TapParagraph (String id, int duration) throws Exception{

        WebElement element = WebElementByResourceId(id);
        int eHeight = element.getSize().getHeight();
        int eWidth = element.getSize().getWidth();
        int eUpperX = element.getLocation().x;
        int eUpperY = element.getLocation().y;
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        WebElement wElement = WebElementById(id);
        JavascriptExecutor executor = (JavascriptExecutor)driver;

        String script = "var s = getComputedStyle(arguments[0],null).getPropertyValue(arguments[1]);" +
                "return s;";

        String scriptReturnLineHeight = executor.executeScript(script, wElement, "line-height").toString();
        scriptReturnLineHeight = scriptReturnLineHeight.substring(0,(scriptReturnLineHeight.length()-2));
        double LineHeight = Double.parseDouble(scriptReturnLineHeight);
        int scriptReturnLineHeightAsInt = (int) LineHeight;
        System.out.println(scriptReturnLineHeightAsInt);
        String scriptReturnFontHeight = executor.executeScript(script, wElement, "font-size").toString();
        scriptReturnFontHeight = scriptReturnFontHeight.substring(0,(scriptReturnFontHeight.length()-2));
        double FontHeight = Double.parseDouble(scriptReturnFontHeight);
        int scriptReturnFontHeightAsInt = (int) FontHeight;
        System.out.println(scriptReturnFontHeightAsInt);
        driver.context("NATIVE_APP");
        int tapX = eUpperX + (eWidth / 5);
        int tapY = eUpperY + scriptReturnFontHeightAsInt + scriptReturnLineHeightAsInt;
        driver.tap(1,tapX,tapY,1000);
        List TapXYList = new ArrayList();
        TapXYList.add(tapX);
        TapXYList.add(tapY);
        return TapXYList;
    }

    //******************************** Empty State assertions ***********************************
    public void assertEmptyNoteText() throws Exception{
        verifyText("Note Title",WebElementByResourceId("org.lds.ldssa.dev:id/noteTitleEditText"),false);
        String placeHolderText = WebElementByResourceId("org.lds.ldssa.dev:id/markdownEditText").getText();
        List defaultPlaceHolderText = new ArrayList();
        defaultPlaceHolderText.add("And it came to pass…");
        defaultPlaceHolderText.add("And thus we see…");
        defaultPlaceHolderText.add("And now, behold…");
        Boolean placeHolder;
        if (placeHolderText.contentEquals(defaultPlaceHolderText.get(0).toString()) || placeHolderText.contentEquals(defaultPlaceHolderText.get(1).toString()) || placeHolderText.contentEquals(defaultPlaceHolderText.get(2).toString())){
            placeHolder = true;
            System.out.println("Placeholder text was one of the preset values");
        } else {
            placeHolder = false;
            System.out.println("Placeholder text was not one of the three preset values");
        }
        assert placeHolder;
    }

    public void assertEmptyStateTagScreen() throws Exception{
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/emptyStateImageView"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/emptyStateTitleTextView"));
        verifyText("No Tags",WebElementByResourceId("org.lds.ldssa.dev:id/emptyStateTitleTextView"),false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/emptyStateSubTitleTextView"));
        verifyText("Create a tag to group content from anywhere in the app.",WebElementByResourceId("org.lds.ldssa.dev:id/emptyStateSubTitleTextView"),false);
    }

    public void assertEmptyStateAddToNotebookScreen() throws Exception{
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/emptyStateImageView"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/emptyStateTitleTextView"));
        verifyText("No Notebooks",WebElementByResourceId("org.lds.ldssa.dev:id/emptyStateTitleTextView"),false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/emptyStateSubTitleTextView"));
        verifyText("Create notebooks to collect and organize your notes for talks, lessons, and personal study.",WebElementByResourceId("org.lds.ldssa.dev:id/emptyStateSubTitleTextView"),false);
    }

    //******************************** Annotation screen assertions ***********************************

    public void assertNoteScreen(Boolean CheckEmptyState) throws Exception{
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsByAccessibilityId("Tag"));
        assertElementExistsBy(WebElementsByAccessibilityId("Link"));
        assertElementExistsBy(WebElementsByAccessibilityId("Add to Notebook"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/noteTitleEditText"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/markdownEditText"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/markdown_controls_bold"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/markdown_controls_italic"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/markdown_controls_unordered_list"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/markdown_controls_ordered_list"));
        if (CheckEmptyState){
            assertEmptyNoteText();
        }
    }

    public void assertTagScreen(Boolean CheckEmptyState) throws Exception{
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsByText("Tags",false));
        assertElementExistsBy(WebElementsByAccessibilityId("Sort"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/tagNameEditText"));
        verifyText("Add tag",WebElementByResourceId("org.lds.ldssa.dev:id/tagNameEditText"),false);
        if (CheckEmptyState){
            assertEmptyStateTagScreen();
        }
    }

    public void assertAddToNotebookScreen(Boolean CheckEmptyState) throws Exception{
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsByText("Add to Notebook",false));
        assertElementExistsBy(WebElementsByAccessibilityId("Sort"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/textFilterLayout"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/filterEditText"));
        verifyText("Find by name",WebElementByResourceId("org.lds.ldssa.dev:id/filterEditText"),false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/notebookSelectionFloatingActionButton"));
        if (CheckEmptyState){
            assertEmptyStateAddToNotebookScreen();
        }

    }

    public void assertLinksScreen() throws Exception{
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsByText("Links",false));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/searchEditText"));
        verifyText("Search for keywords, verses, or titles.",WebElementByResourceId("org.lds.ldssa.dev:id/searchEditText"),false);
    }

    public void assertShareScreen() throws Exception{
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText("Share",WebElementByResourceId("org.lds.ldssa.dev:id/mainToolbarTitleTextView"), false);
    }

    public void assertSearchScreen() throws Exception{
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/backImageView"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/searchEditText"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/searchClearTextImageView"));
    }

    public void assertHighlightStyleScreen() throws Exception {
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/mainToolbar"));
        assertElementExistsBy(WebElementsByText("Highlight Style",false));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/textView2"));
        verifyText("Recent",WebElementByResourceId("org.lds.ldssa.dev:id/textView2"),true);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/indicatorImageView"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/fillIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/underlineIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/clearIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/underlineView"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/highlightStyleImageView"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/redColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/orangeColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/yellowColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/greenColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/blueColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/darkBlueColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/purpleColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/pinkColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/brownColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/grayColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/recentSeparatorView"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/recent1ColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/recent2ColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/recent3ColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/recent4ColorIndicator"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/recent5ColorIndicator"));
    }

    public void assertHighlightStyleScreenStyleAndColor(String Style,String Color) throws Exception{
        if (Style == "solid"){
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/fillIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa.dev:id/indicatorImageView\"]"));
        } else if (Style == "underline"){
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/underlineIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa.dev:id/indicatorImageView\"]"));
        } else if (Style == "clear"){
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/clearIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa.dev:id/indicatorImageView\"]"));
            Color = "clear";
        } else {
            fail(Style + " is not a valid style. Valid styles are \"solid\" \"underline\" and \"clear\"");
        }

        if (Color == "red"){
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/redColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa.dev:id/checkmarkImageView\"]"));
        } else if (Color == "orange"){
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/orangeColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa.dev:id/checkmarkImageView\"]"));
        } else if (Color == "yellow"){
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/yellowColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa.dev:id/checkmarkImageView\"]"));
        } else if (Color == "green"){
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/greenColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa.dev:id/checkmarkImageView\"]"));
        } else if (Color == "blue"){
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/blueColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa.dev:id/checkmarkImageView\"]"));
        } else if (Color == "dark_blue"){
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/darkBlueColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa.dev:id/checkmarkImageView\"]"));
        } else if (Color == "purple") {
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/purpleColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa.dev:id/checkmarkImageView\"]"));
        } else if (Color == "pink"){
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/pinkColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa.dev:id/checkmarkImageView\"]"));
        } else if (Color == "brown"){
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/brownColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa.dev:id/checkmarkImageView\"]"));
        } else if (Color == "gray") {
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/grayColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa.dev:id/checkmarkImageView\"]"));
        } else if (Color == "clear"){
        }else {
            fail(Color + " is not a valid color. Valid colors are \"red\" \"orange\" \"yellow\" \"blue\" \"dark_blue\" \"purple\" \"pink\" \"brown\" \"gray\"");
        }
    }

    public String ChangeHighlightColorAndStyle(String Style,String Color) throws Exception{
        if (Style == "solid"){
            ClickUIElementByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/fillIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/fillIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa.dev:id/indicatorImageView\"]"));
            Style = "box";
        } else if (Style == "underline"){
            ClickUIElementByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/underlineIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/underlineIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa.dev:id/indicatorImageView\"]"));
            Style = "underline";
        } else if (Style == "clear"){
            ClickUIElementByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/clearIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/clearIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa.dev:id/indicatorImageView\"]"));
            Style = "box";
            Color = "clear";
        } else {
            fail(Style + " is not a valid style. Valid styles are \"solid\" \"underline\" and \"clear\"");
        }

        if (Color == "red"){
            ClickUIElementByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/redColorIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/redColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa.dev:id/checkmarkImageView\"]"));
        } else if (Color == "orange"){
            ClickUIElementByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/orangeColorIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/orangeColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa.dev:id/checkmarkImageView\"]"));
        } else if (Color == "yellow"){
            ClickUIElementByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/yellowColorIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/yellowColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa.dev:id/checkmarkImageView\"]"));
        } else if (Color == "green"){
            ClickUIElementByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/greenColorIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/greenColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa.dev:id/checkmarkImageView\"]"));
        } else if (Color == "blue"){
            ClickUIElementByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/blueColorIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/blueColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa.dev:id/checkmarkImageView\"]"));
        } else if (Color == "dark_blue"){
            ClickUIElementByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/darkBlueColorIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/darkBlueColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa.dev:id/checkmarkImageView\"]"));
        } else if (Color == "purple") {
            ClickUIElementByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/purpleColorIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/purpleColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa.dev:id/checkmarkImageView\"]"));
        } else if (Color == "pink"){
            ClickUIElementByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/pinkColorIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/pinkColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa.dev:id/checkmarkImageView\"]"));
        } else if (Color == "brown"){
            ClickUIElementByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/brownColorIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/brownColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa.dev:id/checkmarkImageView\"]"));
        } else if (Color == "gray") {
            ClickUIElementByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/grayColorIndicator\"]");
            driver.getPageSource();
            assertElementExistsBy(WebElementsByXpath("//*[@resource-id=\"org.lds.ldssa.dev:id/grayColorIndicator\"]/android.view.ViewGroup/android.widget.ImageView[@resource-id=\"org.lds.ldssa.dev:id/checkmarkImageView\"]"));
        } else if (Color == "clear"){
            System.out.println("Style was \"clear\" skipping color");
        } else {
            fail(Color + " is not a valid color. Valid colors are \"red\" \"orange\" \"yellow\" \"blue\" \"dark_blue\" \"purple\" \"pink\" \"brown\" \"gray\"");
        }
        String StyleAndColorClass = "hl-" + Color + "-" + Style;
        return StyleAndColorClass;
    }

    public void TestCheckAnnotationStyleAndColor(String Style, String Color) throws Exception{
        OpenScripture("Book of Mormon","Jacob","5","");
        OpenAnnotationMenu("p1","Mark");
        AnnotationsSyncCheck("No Thanks");
        assertElementInWebviewExistsBy("//div[contains(@class, 'hl-yellow-box')]");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size())+"]");
        OpenAnnotationMenuFromAnnotation(WebElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size())+"]"),"Style");
        assertHighlightStyleScreen();
        assertHighlightStyleScreenStyleAndColor("solid","yellow");
        String highlightClass = ChangeHighlightColorAndStyle(Style,Color);
        ClickUIElementByAccessibilityID("Navigate up");
        assertElementInWebviewExistsBy("//div[contains(@class, '"+highlightClass+"')]");
        templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size())+"]");
        OpenAnnotationMenuFromAnnotation(WebElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size())+"]"),"Style");
        assertHighlightStyleScreenStyleAndColor(Style,Color);
    }


    //************************ Open Annotation Menu *********************************

    public void OpenAnnotationMenuFromAnnotation(WebElement element, String annotationType) throws Exception{
        driver.getPageSource();
        Thread.sleep(milliseconds_2);
        int windowHeight = driver.manage().window().getSize().height;
        int windowWidth = driver.manage().window().getSize().width;
        int elementWidth = element.getSize().width;
        int elementHeight = element.getSize().height;
        int elementUpperX = element.getLocation().getX();
        int elementUpperY = element.getLocation().getY();
        int elementTapPointX = elementUpperX + (elementWidth / 2);
        int elementTapPointY = elementUpperY + (elementHeight / 2);
        int annotationMenuWidth = 1184;
        int annotationMenuHeight = 560;
        int buttonWidth = 224;
        int buttonHeight = 224;
        int margin = 32;
        int headerFooter = 40;
        int menuBottomY = elementTapPointY - 140 ;
        if ((windowHeight/elementTapPointY) > 2.8){
            menuBottomY = elementTapPointY + 140 + annotationMenuHeight;
            System.out.println("elementTapPoint is above 28% of the screen");
        }
        int menuBottomX = ((windowWidth / 2) - (annotationMenuWidth / 2));
        int bottomRowY = (menuBottomY - headerFooter - (buttonHeight/2));
        int topRowY = (menuBottomY - headerFooter - buttonHeight - margin - (buttonHeight/2));
        int markX = (menuBottomX + margin + (buttonWidth/2));
        int noteX = (menuBottomX + margin + buttonWidth + (buttonWidth/2));
        int tagX = (menuBottomX + margin + (buttonWidth * 2) + (buttonWidth/2));
        int addToX = (menuBottomX + margin + (buttonWidth * 3) + (buttonWidth/2));
        int linkX = (menuBottomX + margin + (buttonWidth * 4) + (buttonWidth/2));
        int copyX = (menuBottomX + margin + (buttonWidth/2));
        int shareX = (menuBottomX + margin + buttonWidth + (buttonWidth/2));
        int searchX = (menuBottomX + margin + (buttonWidth * 2) + (buttonWidth/2));
        int defineX = (menuBottomX + margin + (buttonWidth * 3) + (buttonWidth/2));
        int removeX = (menuBottomX + margin + (buttonWidth * 4) + (buttonWidth/2));

        element.click();
        Thread.sleep(milliseconds_1);
        System.out.println("Width: " + elementWidth);
        System.out.println("Height: " + elementHeight);
        System.out.println("UpperX: " + elementUpperX);
        System.out.println("UpperY: " + elementUpperY);
        System.out.println("elementTapX: " + elementTapPointX);
        System.out.println("elementTapY: " + elementTapPointY);

        if (annotationType == "Style"){
            System.out.println("Clicking " + annotationType);
            driver.tap(1, markX, topRowY,1000);
            System.out.println("markX is: " + markX);
            assertHighlightStyleScreen();
        } else if (annotationType == "Note"){
            System.out.println("Clicking " + annotationType);
            driver.tap(1, noteX, topRowY,10);
            Thread.sleep(milliseconds_1);
            assertNoteScreen(false);
        } else if (annotationType == "Tag"){
            System.out.println("Clicking " + annotationType);
            driver.tap(1, tagX, topRowY,10);
            Thread.sleep(milliseconds_1);
            assertTagScreen(false);
        } else if (annotationType == "Add to"){
            System.out.println("Clicking " + annotationType);
            driver.tap(1, addToX, topRowY,10);
            Thread.sleep(milliseconds_1);
            assertAddToNotebookScreen(false);
        } else if (annotationType == "Link"){
            System.out.println("Clicking " + annotationType);
            driver.tap(1, linkX, topRowY,10);
            Thread.sleep(milliseconds_1);
            assertLinksScreen();
        } else if (annotationType == "Copy"){
            System.out.println("Clicking " + annotationType);
            driver.tap(1, copyX, bottomRowY,10);
        } else if (annotationType == "Share"){
            System.out.println("Clicking " + annotationType);
            driver.tap(1, shareX, bottomRowY,10);
            Thread.sleep(milliseconds_1);
            assertShareScreen();
        } else if (annotationType == "Search"){
            System.out.println("Clicking " + annotationType);
            driver.tap(1, searchX, bottomRowY,10);
            Thread.sleep(milliseconds_1);
            assertSearchScreen();
        } else if (annotationType == "Define"){
            System.out.println("Clicking " + annotationType);
            driver.tap(1, defineX, bottomRowY,10);
        } else if (annotationType == "Remove"){
            System.out.println("Clicking " + annotationType);
            driver.tap(1, removeX, bottomRowY,10);
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

    public void OpenAnnotationMenu(String id, String annotationType) throws Exception{
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
        int menuBottomY = elementTapPointY - 140 ;
        if ((windowHeight/elementTapPointY) > 2.8){
            menuBottomY = elementTapPointY + 140 + annotationMenuHeight;
            System.out.println("elementTapPoint is above 28% of the screen");
        }
        int menuBottomX = ((windowWidth / 2) - (annotationMenuWidth / 2));
        int bottomRowY = (menuBottomY - headerFooter - (buttonHeight/2));
        int topRowY = (menuBottomY - headerFooter - buttonHeight - margin - (buttonHeight/2));
        int markX = (menuBottomX + margin + (buttonWidth/2));
        int noteX = (menuBottomX + margin + buttonWidth + (buttonWidth/2));
        int tagX = (menuBottomX + margin + (buttonWidth * 2) + (buttonWidth/2));
        int addToX = (menuBottomX + margin + (buttonWidth * 3) + (buttonWidth/2));
        int linkX = (menuBottomX + margin + (buttonWidth * 4) + (buttonWidth/2));
        int copyX = (menuBottomX + margin + (buttonWidth/2));
        int shareX = (menuBottomX + margin + buttonWidth + (buttonWidth/2));
        int searchX = (menuBottomX + margin + (buttonWidth * 2) + (buttonWidth/2));
        int defineX = (menuBottomX + margin + (buttonWidth * 3) + (buttonWidth/2));
        int removeX = (menuBottomX + margin + (buttonWidth * 4) + (buttonWidth/2));

        System.out.println("Width: " + elementWidth);
        System.out.println("Height: " + elementHeight);
        System.out.println("UpperX: " + elementUpperX);
        System.out.println("UpperY: " + elementUpperY);
        System.out.println("elementTapX: " + elementTapPointX);
        System.out.println("elementTapY: " + elementTapPointY);

        if (annotationType == "Mark"){
            System.out.println("Clicking " + annotationType);
            driver.tap(1, markX, topRowY,1000);
            System.out.println("markX is: " + markX);
        } else if (annotationType == "Note"){
            System.out.println("Clicking " + annotationType);
            driver.tap(1, noteX, topRowY,10);
            Thread.sleep(milliseconds_1);
            assertNoteScreen(false);
        } else if (annotationType == "Tag"){
            System.out.println("Clicking " + annotationType);
            driver.tap(1, tagX, topRowY,10);
            Thread.sleep(milliseconds_1);
            assertTagScreen(false);
        } else if (annotationType == "Add to"){
            System.out.println("Clicking " + annotationType);
            driver.tap(1, addToX, topRowY,10);
            Thread.sleep(milliseconds_1);
            assertAddToNotebookScreen(false);
        } else if (annotationType == "Link"){
            System.out.println("Clicking " + annotationType);
            driver.tap(1, linkX, topRowY,10);
            Thread.sleep(milliseconds_1);
            assertLinksScreen();
        } else if (annotationType == "Copy"){
            System.out.println("Clicking " + annotationType);
            driver.tap(1, copyX, bottomRowY,10);
        } else if (annotationType == "Share"){
            System.out.println("Clicking " + annotationType);
            driver.tap(1, shareX, bottomRowY,10);
            Thread.sleep(milliseconds_1);
            assertShareScreen();
        } else if (annotationType == "Search"){
            System.out.println("Clicking " + annotationType);
            driver.tap(1, searchX, bottomRowY,10);
            Thread.sleep(milliseconds_1);
            assertSearchScreen();
        } else if (annotationType == "Define"){
            System.out.println("Clicking " + annotationType);
            driver.tap(1, defineX, bottomRowY,10);
        } else if (annotationType == "Remove"){
            System.out.println("Clicking " + annotationType);
            driver.tap(1, removeX, bottomRowY,10);
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
        int year = parseInt(todaysDate.substring(0,4));
        int month = parseInt(todaysDate.substring(5,7));
        String conferenceMonth = "";
        if (month <= 4){
            conferenceMonth = "October";
        } else if (month > 4 && month < 11){
            conferenceMonth = "April";
        } else if (month >= 11){
            conferenceMonth = "October";
        }
        System.out.println(conferenceMonth);
        return conferenceMonth;
    }

    public String getLatestConferenceYear() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String todaysDate = (dateFormat.format(date));
        int year = parseInt(todaysDate.substring(0,4));
        int month = parseInt(todaysDate.substring(5,7));
        String conferenceMonth = "";
        if (month <= 4){
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


    public void appCheck(String appTitle) throws Exception{
        scrollDownTo(appTitle);
        assertElementExistsBy(WebElementsByText(appTitle, false));
        ClickUIElementByText(appTitle, false);
        assertElementExistsBy(WebElementsByAccessibilityId("Search Google Play"));
        assertElementExistsBy(WebElementsByTextContains(appTitle));
        driver.navigate().back();
        Thread.sleep(milliseconds_1);
        assertElementExistsBy(WebElementsByText("Featured Apps", false));
    }

    public String getComputedCssUsingXpath(String xPath, String cssAttribute) throws Exception{
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        Set <java.lang.String> windowHandles = driver.getWindowHandles();
        windowHandles.size();
        System.out.println("Getting foremost Webview");
        for (String window: windowHandles) {
            driver.switchTo().window(window);
            System.out.println("Window handle is now: "+ window);
        }
        WebElement we = WebElementByXpath(xPath);

        JavascriptExecutor executor = (JavascriptExecutor)driver;

        String script = "var s = getComputedStyle(arguments[0],null).getPropertyValue(arguments[1]);" +
                "return s;";

        String scriptReturn = (executor.executeScript(script, we, cssAttribute)).toString();
        System.out.println(scriptReturn);
        driver.context("NATIVE_APP");
        return scriptReturn;

    }

    public void SplashScreenWait() throws Exception{
        System.out.println("Splash Screen Wait Start…");
        Thread.sleep(milliseconds_1);
        System.out.println("Waited for " + milliseconds_1 + " milliseconds");
        Boolean isPresent = driver.findElementsByXPath("//android.widget.ProgressBar").size() > 0;
        while (isPresent){
            System.out.println("On Splash Screen… Waiting " + milliseconds_1 / 2 + " milliseconds");
            Thread.sleep(milliseconds_1 / 2);
            isPresent = driver.findElementsByXPath("//android.widget.ProgressBar").size() > 0;
        }
        System.out.println("Continuing Test…");
        Thread.sleep(milliseconds_2);
    }



}
