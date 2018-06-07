import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import javafx.util.Pair;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static java.lang.Integer.parseInt;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class GospelLibrary {
    AppiumDriver driver;

    public GospelLibrary() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("app", "/Users/dexterdrysdale/Documents/GitHub/GospelLibraryAppiumTestsAndroid/APK/gospel-library-alpha-20180321-2038.apk");
        capabilities.setCapability("automationName","UiAutomator2");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        setBooks();

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }


    //Login with
    String user = "support2";
    String password = "ldssaldssa";
    String wrongPassword = "ldssaldssaa";
    int AndroidVersion = 7;
    public int milliseconds_1 = 3600;
    public int milliseconds_2 = milliseconds_1 * 2;
    public int milliseconds_3 = milliseconds_1 * 3;
    public int milliseconds_4 = milliseconds_1 * 4;
    public int milliseconds_5 = milliseconds_1 * 5;

    //String idString = "org.lds.ldssa.dev";
    String idString = "org.lds.ldssa";


    //*************************************************************** UI STRINGS ***************************************************************
    //New Notebook 1
    String NotebookName1 = "Test Notebook 1";

    //email
    String email = "WaltDisney@TheWaltDisneyCompany.com";
    //sendto email
    String sendtoemail = "dexterdrysdale@gmail.com";
    //name
    String name = "Walt Disney";

    //Scripture Lists

    public ArrayList<Pair<String, Integer>> BooksInOldTestament = new ArrayList<>();
    public ArrayList<Pair<String, Integer>> BooksInNewTestament = new ArrayList<>();
    public ArrayList<Pair<String, Integer>> BooksInBom = new ArrayList<>();
    public ArrayList<Pair<String, Integer>> BooksInDAndC = new ArrayList<>();
    public ArrayList<Pair<String, Integer>> BooksInPearlOfGreatPrice = new ArrayList<>();

    public void setBooks() throws Exception {
        //Books in the Old Testament
        BooksInOldTestament.add(new Pair<>("Title Page", 0));
        BooksInOldTestament.add(new Pair<>("Epistle Dedicatory", 0));
        BooksInOldTestament.add(new Pair<>("Genesis", 50));
        BooksInOldTestament.add(new Pair<>("Exodus", 40));
        BooksInOldTestament.add(new Pair<>("Leviticus", 27));
        BooksInOldTestament.add(new Pair<>("Numbers", 36));
        BooksInOldTestament.add(new Pair<>("Deuteronomy", 34));
        BooksInOldTestament.add(new Pair<>("Joshua", 24));
        BooksInOldTestament.add(new Pair<>("Judges", 21));
        BooksInOldTestament.add(new Pair<>("Ruth", 4));
        BooksInOldTestament.add(new Pair<>("1 Samuel", 31));
        BooksInOldTestament.add(new Pair<>("2 Samuel", 24));
        BooksInOldTestament.add(new Pair<>("1 Kings", 22));
        BooksInOldTestament.add(new Pair<>("2 Kings", 25));
        BooksInOldTestament.add(new Pair<>("1 Chronicles", 29));
        BooksInOldTestament.add(new Pair<>("2 Chronicles", 36));
        BooksInOldTestament.add(new Pair<>("Ezra", 10));
        BooksInOldTestament.add(new Pair<>("Nehemiah", 13));
        BooksInOldTestament.add(new Pair<>("Esther", 10));
        BooksInOldTestament.add(new Pair<>("Job", 42));
        BooksInOldTestament.add(new Pair<>("Psalms", 150));
        BooksInOldTestament.add(new Pair<>("Proverbs", 31));
        BooksInOldTestament.add(new Pair<>("Ecclesiastes", 12));
        BooksInOldTestament.add(new Pair<>("Song of Solomon", 8));
        BooksInOldTestament.add(new Pair<>("Isaiah", 66));
        BooksInOldTestament.add(new Pair<>("Jeremiah", 52));
        BooksInOldTestament.add(new Pair<>("Lamentations", 5));
        BooksInOldTestament.add(new Pair<>("Ezekiel", 48));
        BooksInOldTestament.add(new Pair<>("Daniel", 12));
        BooksInOldTestament.add(new Pair<>("Hosea", 14));
        BooksInOldTestament.add(new Pair<>("Joel", 3));
        BooksInOldTestament.add(new Pair<>("Amos", 9));
        BooksInOldTestament.add(new Pair<>("Obadiah", 1));
        BooksInOldTestament.add(new Pair<>("Jonah", 4));
        BooksInOldTestament.add(new Pair<>("Micah", 7));
        BooksInOldTestament.add(new Pair<>("Nahum", 3));
        BooksInOldTestament.add(new Pair<>("Habakkuk", 3));
        BooksInOldTestament.add(new Pair<>("Zephaniah", 3));
        BooksInOldTestament.add(new Pair<>("Haggai", 2));
        BooksInOldTestament.add(new Pair<>("Zechariah", 14));
        BooksInOldTestament.add(new Pair<>("Malachi", 4));
        //Books in the New Testament
        BooksInNewTestament.add(new Pair<>("Title Page", 0));
        BooksInNewTestament.add(new Pair<>("Matthew", 28));
        BooksInNewTestament.add(new Pair<>("Mark", 16));
        BooksInNewTestament.add(new Pair<>("Luke", 24));
        BooksInNewTestament.add(new Pair<>("John", 21));
        BooksInNewTestament.add(new Pair<>("Acts", 28));
        BooksInNewTestament.add(new Pair<>("Romans", 16));
        BooksInNewTestament.add(new Pair<>("1 Corinthians", 16));
        BooksInNewTestament.add(new Pair<>("2 Corinthians", 13));
        BooksInNewTestament.add(new Pair<>("Galatians", 6));
        BooksInNewTestament.add(new Pair<>("Ephesians", 6));
        BooksInNewTestament.add(new Pair<>("Philippians", 4));
        BooksInNewTestament.add(new Pair<>("Colossians", 4));
        BooksInNewTestament.add(new Pair<>("1 Thessalonians", 5));
        BooksInNewTestament.add(new Pair<>("2 Thessalonians", 3));
        BooksInNewTestament.add(new Pair<>("1 Timothy", 6));
        BooksInNewTestament.add(new Pair<>("2 Timothy", 4));
        BooksInNewTestament.add(new Pair<>("Titus", 3));
        BooksInNewTestament.add(new Pair<>("Philemon", 1));
        BooksInNewTestament.add(new Pair<>("Hebrews", 13));
        BooksInNewTestament.add(new Pair<>("James", 5));
        BooksInNewTestament.add(new Pair<>("1 Peter", 5));
        BooksInNewTestament.add(new Pair<>("2 Peter", 3));
        BooksInNewTestament.add(new Pair<>("1 John", 5));
        BooksInNewTestament.add(new Pair<>("2 John", 1));
        BooksInNewTestament.add(new Pair<>("3 John", 1));
        BooksInNewTestament.add(new Pair<>("Jude", 1));
        BooksInNewTestament.add(new Pair<>("Revelation", 22));
        //Books in the Book of Mormon
        BooksInBom.add(new Pair<>("Introduction and Witnesses", 0));//has 8 subsections, but they aren't numbered like chapters
        BooksInBom.add(new Pair<>("1 Nephi", 22));
        BooksInBom.add(new Pair<>("2 Nephi", 22));
        BooksInBom.add(new Pair<>("Jacob", 7));
        BooksInBom.add(new Pair<>("Enos", 1));
        BooksInBom.add(new Pair<>("Jarom", 1));
        BooksInBom.add(new Pair<>("Omni", 1));
        BooksInBom.add(new Pair<>("Words of Mormon", 1));
        BooksInBom.add(new Pair<>("Mosiah", 29));
        BooksInBom.add(new Pair<>("Alma", 63));
        BooksInBom.add(new Pair<>("Helaman", 16));
        BooksInBom.add(new Pair<>("3 Nephi", 22));
        BooksInBom.add(new Pair<>("4 Nephi", 1));
        BooksInBom.add(new Pair<>("Mormon", 9));
        BooksInBom.add(new Pair<>("Ether", 15));
        BooksInBom.add(new Pair<>("Moroni", 10));
        BooksInBom.add(new Pair<>("Book of Mormon Pronunciation Guide", 0));
        //Books in the Doctrine and Covenants
        BooksInDAndC.add(new Pair<>("Title Page", 0));
        BooksInDAndC.add(new Pair<>("Introduction", 0));
        BooksInDAndC.add(new Pair<>("Chronological Order of Contents", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 1", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 2", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 3", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 4", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 5", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 6", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 7", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 8", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 9", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 10", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 11", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 12", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 13", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 14", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 15", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 16", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 17", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 18", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 19", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 20", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 21", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 22", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 23", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 24", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 25", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 26", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 27", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 28", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 29", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 30", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 31", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 32", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 33", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 34", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 35", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 36", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 37", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 38", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 39", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 40", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 41", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 42", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 43", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 44", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 45", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 46", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 47", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 48", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 49", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 50", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 51", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 52", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 53", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 54", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 55", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 56", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 57", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 58", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 59", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 60", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 61", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 62", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 63", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 64", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 65", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 66", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 67", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 68", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 69", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 70", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 71", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 72", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 73", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 74", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 75", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 76", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 77", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 78", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 79", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 80", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 81", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 82", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 83", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 84", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 85", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 86", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 87", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 88", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 89", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 90", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 91", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 92", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 93", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 94", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 95", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 96", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 97", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 98", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 99", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 100", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 101", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 102", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 103", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 104", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 105", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 106", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 107", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 108", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 109", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 110", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 111", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 112", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 113", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 114", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 115", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 116", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 117", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 118", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 119", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 120", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 121", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 122", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 123", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 124", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 125", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 126", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 127", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 128", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 129", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 130", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 131", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 132", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 133", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 134", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 135", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 136", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 137", 0));
        BooksInDAndC.add(new Pair<>("Doctrine and Covenants 138", 0));
        BooksInDAndC.add(new Pair<>("Official Declaration 1", 0));
        BooksInDAndC.add(new Pair<>("Official Declaration 2", 0));
        //Books in the Pearl of Great Price
        BooksInPearlOfGreatPrice.add(new Pair<>("Title Page", 0));
        BooksInPearlOfGreatPrice.add(new Pair<>("Introduction", 0));
        BooksInPearlOfGreatPrice.add(new Pair<>("Moses", 8));
        BooksInPearlOfGreatPrice.add(new Pair<>("Abraham", 5));
        BooksInPearlOfGreatPrice.add(new Pair<>("Joseph Smith—Matthew", 1));
        BooksInPearlOfGreatPrice.add(new Pair<>("Joseph Smith—History", 1));
        BooksInPearlOfGreatPrice.add(new Pair<>("Articles of Faith", 1));
    }

    //*************************************************************** Functions ***************************************************************


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
        Set <java.lang.String> windowHandles = driver.getWindowHandles();
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
        driver.tap(1, screenWidth / 2, screenHeight / 2, 10);
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
        Thread.sleep(milliseconds_1);
        swipeRight();
        swipeLeft();
        System.out.println("Waited … Getting page source");
        Thread.sleep(milliseconds_2);
        driver.getPageSource();
        System.out.println("Page Source Recieved");
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
        skipLogin();
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


    //*************************************************************** Tests ***************************************************************
    @Test
    public void LaunchTest() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon","Jacob","5","10");
        assertNavBar("Jacob 5","Jacob", "Book of Mormon", "Scriptures","","",true);
    }

    //********** Tips Screen **********
    @Test
    public void skipTips() throws Exception {
        SplashScreenWait();
        driver.findElement(By.id("org.lds.ldssa.dev:id/skip")).click();
        Thread.sleep(milliseconds_1);

    }


    @Test
    public void allTips() throws Exception {
        SplashScreenWait();
        Boolean isPresent = driver.findElements(By.id("org.lds.ldssa.dev:id/tipToolbar")).size() > 0;
        while ((isPresent)) {
            System.out.println("Tips Screen is Present... Next Tip");
            WebElement tipToolbar = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView");
            //Expected
            String tipToolbarTitle = "What’s New";
            //Actual
            String tipToolbarAsText = tipToolbar.getText();
            Assert.assertEquals(tipToolbarTitle, tipToolbarAsText);
            WebElement next = driver.findElementById("org.lds.ldssa.dev:id/next");
            next.click();
            Thread.sleep(milliseconds_1);
            isPresent = driver.findElements(By.id("org.lds.ldssa.dev:id/tipToolbar")).size() > 0;
        }

    }

    //********** Login Screen *********

    @Test
    public void skipLogin() throws Exception {

        skipTips();
        //click skip
        Thread.sleep(milliseconds_3);
        driver.findElementById("org.lds.ldssa.dev:id/done").click();
        Thread.sleep(milliseconds_3);
    }

    @Test
    public void login() throws Exception {
        //This test checks valid login
        skipTips();
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/signInToolbar"));
        verifyText("Sign In", WebElementByText("Sign In", false),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/signInMessageTextView"));
        verifyText("An LDS Account is used to back up and synchronize your annotations across devices and on LDS.org.",WebElementById("org.lds.ldssa.dev:id/signInMessageTextView"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/usernameEditText"));
        //appium can't validate ! if Username not entered and SignIn clicked
        sendText("org.lds.ldssa.dev:id/usernameEditText", user);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/passwordEditText"));
        sendText("org.lds.ldssa.dev:id/passwordEditText", password);
        assertElementExistsBy(WebElementsByAccessibilityId("Toggle password visibility"));
        boolean passwordVisibility = Boolean.parseBoolean((WebElementByAccessibilityId("Toggle password visibility").getAttribute("checked")));
        System.out.println(passwordVisibility);
        assert !passwordVisibility;
        verifyText(hidePassword(password), WebElementById("org.lds.ldssa.dev:id/passwordEditText"),false);
        ClickUIElementByAccessibilityID("Toggle password visibility");
        Thread.sleep(milliseconds_1);
        passwordVisibility = Boolean.parseBoolean((WebElementByAccessibilityId("Toggle password visibility").getAttribute("checked")));
        System.out.println(passwordVisibility);
        assert (passwordVisibility);
        verifyText(password, WebElementById("org.lds.ldssa.dev:id/passwordEditText"),false);
        WebElement signInButton = driver.findElementById("org.lds.ldssa.dev:id/ldsAccountSignInButton");
        signInButton.click();
        Thread.sleep(milliseconds_3);
        verifyText("Library", WebElementByText("Library", false),false);

    }

    @Test
    public void invalidLogin() throws Exception {
        skipTips();
        verifyText("Sign In", WebElementByText("Sign In", false),false);
        sendText("org.lds.ldssa.dev:id/usernameEditText", user);
        sendText("org.lds.ldssa.dev:id/passwordEditText", wrongPassword);
        WebElement signInButton = driver.findElementById("org.lds.ldssa.dev:id/ldsAccountSignInButton");
        signInButton.click();
        Thread.sleep(milliseconds_1);
        verifyText("Error", WebElementByText("Error", false),false);
        ClickUIElementByText("OK", false);
        sendText("org.lds.ldssa.dev:id/passwordEditText", password);
        signInButton.click();
        Thread.sleep(milliseconds_3);
        verifyText("Library", WebElementByText("Library", false),false);

    }

    @Test
    public void troubleSigningIn() throws Exception {
        skipTips();
        verifyText("Sign In", WebElementByText("Sign In", false),false);
        verifyText("HAVING TROUBLE SIGNING IN?",WebElementById("org.lds.ldssa.dev:id/ldsAccountLoginForgotCredentialsButton"),false);
        ClickUIElementByID("org.lds.ldssa.dev:id/ldsAccountLoginForgotCredentialsButton");
        Thread.sleep(milliseconds_5);
        verifyText("https://ldsaccount.lds.org/recovery", WebElementById("com.android.chrome:id/url_bar"),false);
    }

    @Test
    public void signInCreateAccount() throws Exception {
        skipTips();
        verifyText("Sign In", WebElementByText("Sign In", false),false);
        verifyText("CREATE LDS ACCOUNT", WebElementById("org.lds.ldssa.dev:id/ldsAccountLoginCreateAccountButton"),false);
        ClickUIElementByID("org.lds.ldssa.dev:id/ldsAccountLoginCreateAccountButton");
        Thread.sleep(milliseconds_5);
        verifyText("https://ldsaccount.lds.org/register", WebElementById("com.android.chrome:id/url_bar"),false);
    }


    //*********** Library Screen ***********
    @Test
    public void LibraryContentScreen() throws Exception {
        //Skip Login
        skipLogin();
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText("Library", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"),false);
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmark"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        scrollDownTo("Scriptures");
        assertElementExistsBy(WebElementsByText("Scriptures", false));
        scrollDownTo("Jesus Christ");
        assertElementExistsBy(WebElementsByText("Jesus Christ", false));
        scrollDownTo("General Conference");
        assertElementExistsBy(WebElementsByText("General Conference", false));
        scrollDownTo("Teachings of Presidents");
        assertElementExistsBy(WebElementsByText("Teachings of Presidents", false));
        scrollDownTo("Notes");
        assertElementExistsBy(WebElementsByText("Notes", false));
        scrollDownTo("Lessons");
        assertElementExistsBy(WebElementsByText("Lessons", false));
        scrollDownTo("Magazines");
        assertElementExistsBy(WebElementsByText("Magazines", false));
        scrollDownTo("Music");
        assertElementExistsBy(WebElementsByText("Music", false));
        scrollDownTo("Videos");
        assertElementExistsBy(WebElementsByText("Videos", false));
        scrollDownTo("Missionary");
        assertElementExistsBy(WebElementsByText("Missionary", false));
        scrollDownTo("Temple and Family History");
        assertElementExistsBy(WebElementsByText("Temple and Family History", false));
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
        scrollDownTo("Self-Reliance");
        assertElementExistsBy(WebElementsByText("Self-Reliance", false));
        scrollDownTo("Religious Freedom");
        assertElementExistsBy(WebElementsByText("Religious Freedom", false));
        scrollDownTo("Church History");
        assertElementExistsBy(WebElementsByText("Church History", false));
        scrollDownTo("Seminaries and Institutes");
        assertElementExistsBy(WebElementsByText("Seminaries and Institutes", false));
        scrollDownTo("Tips");
        assertElementExistsBy(WebElementsByText("Tips", false));
        assertMoreOptionsMenu("Library",true);

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
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmark"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        assertTabs("Notes");
        assertElementExistsBy(WebElementsByText("No Notes", false));
        assertElementExistsBy(WebElementsByText("Record notes to preserve your thoughts.", false));
        assertElementExistsBy(WebElementsByText("Notes", false));

        assertMoreOptionsMenu("Notes",true);

        assertNavBar("Notes","","","","","",true);
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
//        verifyText("Spiritual Thoughts", WebElementById("org.lds.ldssa.dev:id/titleView"));
//        ClickUIElementByText("Spiritual Thoughts");
//        Thread.sleep(milliseconds_1);
//        //Verify note title and text preview then click on it
//        verifyText("Spiritual Thought", WebElementByText("Spiritual Thought"));
//        verifyText("Spiritual content", WebElementByText("Spiritual content"));
//        ClickUIElementByText("Spiritual Thought");
//        Thread.sleep(milliseconds_1);
//        //Verify note title and content
//        verifyText("Spiritual Thought", WebElementById("org.lds.ldssa.dev:id/noteTitleEditText"));
//        verifyText("Spiritual content", WebElementById("org.lds.ldssa.dev:id/markdownEditText"));
//        //Verify buttons are visible
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/note_menu_tag"));
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/note_menu_add_to_notebook"));
//        //Click Tag
//        ClickUIElementByID("org.lds.ldssa.dev:id/note_menu_tag");
//        Thread.sleep(milliseconds_3);
//        //Verify Tags element exists
//        verifyText("Tags", WebElementByText("Tags"));
//        //Verify tag sorting and navigation exists
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/menu_item_tag_sort"));
//        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
//        sendText("org.lds.ldssa.dev:id/tagNameEditText", "Spirit");
//        Thread.sleep(milliseconds_1);
//        ClickUIElementByAccessibilityID("Navigate up");
//        Thread.sleep(milliseconds_1);
//        ClickUIElementByID("org.lds.ldssa.dev:id/note_menu_tag");
//        Thread.sleep(milliseconds_1);
//        //Tag check
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/tag_text"));
//        verifyText("Spirit", WebElementById("org.lds.ldssa.dev:id/tag_text"));
//        Thread.sleep(milliseconds_1);
//        ClickUIElementByID("org.lds.ldssa.dev:id/tag_delete");
//
//
//    }

    @Test
    public void CreateNewNotebook() throws Exception {

        //Login
        skipLogin();
        //Verify "Notes item exists by text"
        verifyText("Notes", WebElementByText("Notes", false),false);
        //Click "Notes"
        ClickUIElementByText("Notes", false);
        Thread.sleep(milliseconds_1);
        //Verify Tabs in the notes section
        assertTabs("Notes");
        assertMoreOptionsMenu("Notes",true);
        //Click Notebooks
        ClickUIElementByText("Notebooks",true);
        Thread.sleep(milliseconds_1);
        CreateNotebookandAssert("Spiritual Impressions 1",true);

    }

    @Test
    public void CreateNewNoteInNewNotebook() throws Exception {
        skipLogin();
        verifyText("Notes",WebElementByText("Notes", false),false);
        ClickUIElementByText("Notes", false);
        assertTabs("Notes");
        assertMoreOptionsMenu("Notes",true);
        ClickUIElementByText("Notebooks", true);
        String notebookTitle = "Spiritual Impressions 1";
        CreateNotebookandAssert(notebookTitle, true);
        ClickUIElementByText(notebookTitle,false);
        verifyText("No Notes in This Notebook", WebElementById("org.lds.ldssa.dev:id/emptyStateTitleTextView"),false);
        verifyText("Record notes to preserve your thoughts.", WebElementById("org.lds.ldssa.dev:id/emptyStateSubTitleTextView"),false);
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmark"));
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertMoreOptionsMenu("Notebooks",true);
        assertNavBar("Notebooks","Spiritual Impressions 1","","","","",true);

        String NoteTitle = "My first note";
        String NoteBody = "This is a note.";

        CreateNewNoteFromNotebook(NoteTitle, NoteBody);
        Thread.sleep(milliseconds_1);

        Backup(false);

        //Check Note
        verifyText(NoteTitle, WebElementById("org.lds.ldssa.dev:id/noteTitleTextView"),false);
        verifyText(NoteBody, WebElementById("org.lds.ldssa.dev:id/noteMarkdownTextView"),false);
        ClickUIElementByID("org.lds.ldssa.dev:id/noteTitleTextView");
        Thread.sleep(milliseconds_1);
        verifyText(NoteTitle, WebElementById("org.lds.ldssa.dev:id/noteTitleEditText"),false);
        verifyText(NoteBody, WebElementById("org.lds.ldssa.dev:id/markdownEditText"),false);
        Thread.sleep(milliseconds_1);

    }

    //********** Bookmarks Landing Page **********
    @Test
    public void BookmarksLandingPageFromLibrary_NotSignedIn() throws Exception {
        //Skip Login
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmark"));
        ClickUIElementByAccessibilityID("Bookmark");
        assertTabs("Bookmarks");
        assertElementExistsBy(WebElementsByText("No Bookmarks", false));
        assertElementExistsBy(WebElementsByText("Add a bookmark to quickly return to where you left off.", false));
    }

    @Test
    public void BookmarksLandingPageFromNotes_NotSignedIn() throws Exception {
        // Skip Login
        skipLogin();
        ClickUIElementByText("Notes", false);
        Thread.sleep(milliseconds_1);
        assertMoreOptionsMenu("Notes",true);
        assertTabs("Notes");
        ClickUIElementByAccessibilityID("Bookmark");
        Thread.sleep(milliseconds_1);

        //verify all elements present on bookmarks screen
        assertTabs("Bookmarks");
        assertElementExistsBy(WebElementsByText("No Bookmarks", false));
        assertElementExistsBy(WebElementsByText("Add a bookmark to quickly return to where you left off.", false));
        //click Screens
        Thread.sleep(milliseconds_1);
        ClickUIElementByText("Screens",true);
        Thread.sleep(milliseconds_1);
        assertTabs("Bookmarks");
        assertMoreOptionsMenu("Screens",false);
        ClickUIElementByText("Screen Settings", false);
        //assert elements present on screens settings screen
        assertElementExistsBy(WebElementsByText("Show Screens as Separate Windows", false));
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertSettingsSwitchExpectedStateAndToggle("Show Screens as Separate Windows", true);
        ClickUIElementByAccessibilityID("Navigate up");
        //verify notes screen
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/screenTitleTextView"));
        verifyText("Notes", WebElementById("org.lds.ldssa.dev:id/screenTitleTextView"),false);
        //verify add screen fab
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/locationsFab"));
        //
        assertMoreOptionsMenu("Screens",false);
        ClickUIElementByText("Close All Screens", false);

        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/screenTitleTextView"));
        verifyText("Notes",WebElementById("org.lds.ldssa.dev:id/screenTitleTextView"),false);
        //verify add screen fab
        ClickUIElementByID("org.lds.ldssa.dev:id/locationsFab");
        ClickUIElementByAccessibilityID("Bookmark");
        assertElementExistsBy(WebElementsByText("Library", false));
        assertElementExistsBy(WebElementsByText("Notes", false));
        assertMoreOptionsMenu("Screens",false);
        ClickUIElementByText("Close All Screens", false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/screenTitleTextView"));
        verifyText("Library", WebElementById("org.lds.ldssa.dev:id/screenTitleTextView"),false);
        assertElementNotPresentBy(WebElementsByText("Notes", false));
        Thread.sleep(milliseconds_2);

        Thread.sleep(milliseconds_1);

        //Click History tab
        ClickUIElementByText("History",true);
        Thread.sleep(milliseconds_1);
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateImageView"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateTitleTextView"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateSubTitleTextView"));
        assertMoreOptionsMenu("History",true);
        verifyText("No History", WebElementById("org.lds.ldssa.dev:id/emptyStateTitleTextView"),false);
        verifyText("Explore content, find your path, and go back to it.", WebElementById("org.lds.ldssa.dev:id/emptyStateSubTitleTextView"),false);

        ClickUIElementByAccessibilityID("Navigate up");
        Thread.sleep(milliseconds_1);

    }

    @Test
    public void ScreensScreenFromNotesScreenItemOptions() throws Exception {
        skipLogin();
        ClickUIElementByText("Notes", false);
        Thread.sleep(milliseconds_1);
        ClickUIElementByAccessibilityID("Bookmark");
        Thread.sleep(milliseconds_1);

        //verify all elements present on bookmarks screen
        assertTabs("Bookmarks");
        assertElementExistsBy(WebElementsByText("No Bookmarks", false));
        assertElementExistsBy(WebElementsByText("Add a bookmark to quickly return to where you left off.", false));
        //click Screens
        Thread.sleep(milliseconds_1);
        ClickUIElementByText("Screens",true);
        assertScreenItemOptions("Notes",true);


    }

    @Test
    public void ScreensScreenFromLibrary() throws Exception {
        //Skip Login
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmark"));
        ClickUIElementByAccessibilityID("Bookmark");
        Thread.sleep(milliseconds_1);
        assertTabs("Bookmarks");
        ClickUIElementByText("Screens",true);
        Thread.sleep(milliseconds_1);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/screenTitleTextView"));
        verifyText("Library", WebElementById("org.lds.ldssa.dev:id/screenTitleTextView"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/screenImageView"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/screenTitleTextView"));
        verifyText("Library", WebElementById("org.lds.ldssa.dev:id/screenTitleTextView"),false);
        assertMoreOptionsMenu("Screens",false);
        ClickUIElementByText("Screen Settings", false);
        //assert elements present on screens settings screen
        assertElementExistsBy(WebElementsByText("Show Screens as Separate Windows", false));
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertSettingsSwitchExpectedStateAndToggle("Show Screens as Separate Windows", true);
        ClickUIElementByAccessibilityID("Navigate up");
        //verify notes screen
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/screenTitleTextView"));
        verifyText("Library", WebElementById("org.lds.ldssa.dev:id/screenTitleTextView"),false);

        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/locationsFab"));

        assertTabs("Bookmarks");
        //Click History tab
        ClickUIElementByText("History",true);
        assertMoreOptionsMenu("History",true);
        Thread.sleep(milliseconds_1);
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateImageView"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateTitleTextView"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateSubTitleTextView"));
        verifyText("No History", WebElementById("org.lds.ldssa.dev:id/emptyStateTitleTextView"),false);
        verifyText("Explore content, find your path, and go back to it.", WebElementById("org.lds.ldssa.dev:id/emptyStateSubTitleTextView"),false);

        ClickUIElementByAccessibilityID("Navigate up");
        Thread.sleep(milliseconds_1);

    }

//  need to figure out how to tap in the annotations menu
//    @Test
//    public void moreOptionsMenu() throws Exception {
//        skipLogin();
//        OpenScripture("Book of Mormon", "Helaman", "5","26");
//        Thread.sleep(milliseconds_1);
//        scrollToByResourceId("p15");
//        Thread.sleep(milliseconds_1);
//        driver.tap(1, WebElementByResourceId("p15"),1000);
//        ClickUIElementByID("markHighlightMenuTextView");
//        assertMoreOptionsMenu("Content",true);
//        Thread.sleep(milliseconds_1);
//    }


    //********** Settings Screen **********
    @Test
    public void settingsScreenLandingPageNotSignedIn() throws Exception {
        skipLogin();
        assertMoreOptionsMenu("Library",false);
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        assertElementExistsBy(WebElementsByText("LDS Account", false));
        assertElementExistsBy(WebElementsByText("Sign In", false));
        assertElementExistsBy(WebElementsByText("An LDS Account is used to back up and synchronize your annotations across devices and on LDS.org.", false));
        assertElementExistsBy(WebElementsByText("Create LDS Account", false));
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
        scrollDownTo("Additional Settings");
        assertElementExistsBy(WebElementsByText("Additional Settings", false));
        scrollDownTo("Featured Apps");
        assertElementExistsBy(WebElementsByText("Featured Apps", false));
        scrollDownTo("Send Feedback");
        assertElementExistsBy(WebElementsByText("Send Feedback", false));
        scrollDownTo("About");
        assertElementExistsBy(WebElementsByText("About", false));

    }

    @Test
    public void settingsScreenLoginCorrectUserNameAndPassword() throws Exception {
        skipLogin();
        assertMoreOptionsMenu("Library",false);
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        assertElementExistsBy(WebElementsByText("Sign In", false));
        ClickUIElementByText("Sign In", false);

        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/usernameEditText"));
        //appium can't validate ! if Username not entered and SignIn clicked
        sendText("org.lds.ldssa.dev:id/usernameEditText", user);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/passwordEditText"));
        sendText("org.lds.ldssa.dev:id/passwordEditText", password);
        assertElementExistsBy(WebElementsByAccessibilityId("Toggle password visibility"));
        boolean passwordVisibility = Boolean.parseBoolean((WebElementByAccessibilityId("Toggle password visibility").getAttribute("checked")));
        System.out.println(passwordVisibility);
        assert !passwordVisibility;
        verifyText(hidePassword(password), WebElementById("org.lds.ldssa.dev:id/passwordEditText"),false);
        ClickUIElementByAccessibilityID("Toggle password visibility");
        Thread.sleep(milliseconds_1);
        passwordVisibility = Boolean.parseBoolean((WebElementByAccessibilityId("Toggle password visibility").getAttribute("checked")));
        System.out.println(passwordVisibility);
        assert passwordVisibility;
        verifyText(password, WebElementById("org.lds.ldssa.dev:id/passwordEditText"),false);
        WebElement signInButton = driver.findElementById("org.lds.ldssa.dev:id/ldsAccountSignInButton");
        signInButton.click();
        Thread.sleep(milliseconds_5);
        assertElementExistsBy(WebElementsByText("LDS Account", false));
        assertElementExistsBy(WebElementsByText(user, false));
    }

    @Test
    public void settingsScreenLoginInvalidLogin() throws Exception {
        skipLogin();
        assertMoreOptionsMenu("Library",false);
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        assertElementExistsBy(WebElementsByText("Sign In", false));
        ClickUIElementByText("Sign In", false);

        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/usernameEditText"));
        //appium can't validate ! if Username not entered and SignIn clicked
        sendText("org.lds.ldssa.dev:id/usernameEditText", user);
        sendText("org.lds.ldssa.dev:id/passwordEditText", wrongPassword);
        WebElement signInButton = driver.findElementById("org.lds.ldssa.dev:id/ldsAccountSignInButton");
        signInButton.click();
        Thread.sleep(milliseconds_1);
        verifyText("Error", WebElementByText("Error", false),false);
        ClickUIElementByText("OK", false);
        sendText("org.lds.ldssa.dev:id/passwordEditText", password);
        signInButton.click();
        Thread.sleep(milliseconds_5);
        assertElementExistsBy(WebElementsByText("LDS Account", false));
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

        ClickUIElementByID("org.lds.ldssa.dev:id/ldsAccountLoginForgotCredentialsButton");
        Thread.sleep(milliseconds_5);
        verifyText("https://ldsaccount.lds.org/recovery", WebElementById("com.android.chrome:id/url_bar"),false);
    }


    @Test
    public void settingsScreenCreateLDSAccount() throws Exception {
        skipLogin();
        assertMoreOptionsMenu("Library", false);
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        assertElementExistsBy(WebElementsByText("Create LDS Account", false));
        ClickUIElementByText("Create LDS Account", false);
        Thread.sleep(milliseconds_5);
        verifyText("https://ldsaccount.lds.org/register", WebElementById("com.android.chrome:id/url_bar"),false);
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
        assertMoreOptionsMenu("DownloadsByItem",true);
        assertDownloadScreen(false);
        ClickUIElementByAccessibilityID("More options");
        ClickUIElementByText("Sort by Size", false);
        assertMoreOptionsMenu("DownloadsBySize",true);
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
        assertMoreOptionsMenu("DownloadsByItem",true);
        //when the empty state bug is fixed, change the following line to true
        assertDownloadScreen(false);
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertMoreOptionsMenu("DownloadsByItem",false);
        ClickUIElementByText("Sort by Size", false);
        //Current Downloads
        assertMoreOptionsMenu("DownloadsBySize",false);
        ClickUIElementByText("Current Downloads", false);
        assertElementExistsBy(WebElementsByText("Current Downloads", false));
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText("Current Downloads", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateImageView"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateTitleTextView"));
        verifyText("No Downloads in Progress", WebElementById("org.lds.ldssa.dev:id/emptyStateTitleTextView"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateSubTitleTextView"));
        verifyText("Content and media currently being downloaded.", WebElementById("org.lds.ldssa.dev:id/emptyStateSubTitleTextView"),false);
        ClickUIElementByAccessibilityID("Navigate up");
        Thread.sleep(milliseconds_1);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText("Downloaded Media", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"),false);
        ClickUIElementByAccessibilityID("Navigate up");
        Thread.sleep(milliseconds_3);
        assertElementExistsBy(WebElementsByText("LDS Account", false));
        Thread.sleep(milliseconds_1);
    }

    @Test
    public void settingsScreenDownloadedMediaGeneralConferenceDownloaded_AccessedThroughMoreOptionsMenu() throws Exception {
        skipLogin();
        OpenConference("October", "2017","General Women’s Session");
        ClickUIElementByXpath("//android.webkit.WebView[@text='General Women’s Session']/android.view.View/android.view.View/android.view.View/android.widget.Image[2]");
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_title"));
        verifyText("Download Video",WebElementById("org.lds.ldssa.dev:id/md_title"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/titleView"));
        verifyText("General Women's Session",WebElementById("org.lds.ldssa.dev:id/titleView"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/typeIcon"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"));
        verifyText("CANCEL",WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"));
        verifyText("DOWNLOAD",WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"),false);
        ClickUIElementByID("org.lds.ldssa.dev:id/md_buttonDefaultPositive");
        //assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/snackbar_text"));
        //verifyText("Downloading video for General Women's Session",WebElementById("org.lds.ldssa.dev:id/snackbar_text"));
        //assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/snackbar_action"));
        //verifyText("VIEW",WebElementById("org.lds.ldssa.dev:id/snackbar_action"));
        assertMoreOptionsMenu("Content Menu",false);
        ClickUIElementByText("Settings", false);
        assertElementExistsBy(WebElementsByText("Downloaded Media", false));
        ClickUIElementByText("Downloaded Media", false);
        assertMoreOptionsMenu("DownloadsByItem",false);
        ClickUIElementByText("Current Downloads", false);
        // Commented out because the download would complete before all assertions ran. assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText("Current Downloads (1)", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"),false);
        // Commented out because the download would complete before all assertions ran. assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/titleTextView"));
        verifyText("General Women's Session", WebElementById("org.lds.ldssa.dev:id/titleTextView"),false);
        // Commented out because the download would complete before all assertions ran. assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/installStatusTextView"));
        verifyText("Downloading…",WebElementById("org.lds.ldssa.dev:id/installStatusTextView"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/downloadCancelImageView"));
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
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_title"));
//
//        verifyText("Download Video",WebElementById("org.lds.ldssa.dev:id/md_title"));
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/titleView"));
//        verifyText("General Women's Session",WebElementById("org.lds.ldssa.dev:id/titleView"));
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/typeIcon"));
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"));
//        verifyText("CANCEL",WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"));
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"));
//        verifyText("DOWNLOAD",WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"));
//        ClickUIElementByID("org.lds.ldssa.dev:id/md_buttonDefaultPositive");
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/snackbar_text"));
//        verifyText("Downloading video for General Women's Session",WebElementById("org.lds.ldssa.dev:id/snackbar_text"));
//        // assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/snackbar_action"));
//        // verifyText("VIEW",WebElementById("org.lds.ldssa.dev:id/snackbar_action"));
//        ClickUIElementByID("org.lds.ldssa.dev:id/snackbar_action");
//        // Commented out because the download would complete before all assertions ran. assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
//        verifyText("Current Downloads (1)", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
//        // Commented out because the download would complete before all assertions ran. assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/titleTextView"));
//        verifyText("General Women's Session", WebElementById("org.lds.ldssa.dev:id/titleTextView"));
//        // Commented out because the download would complete before all assertions ran. assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/installStatusTextView"));
//        verifyText("Downloading…",WebElementById("org.lds.ldssa.dev:id/installStatusTextView"));
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/downloadCancelImageView"));
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
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_title"));
//
//        verifyText("Download Video",WebElementById("org.lds.ldssa.dev:id/md_title"));
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/titleView"));
//        verifyText("General Women's Session",WebElementById("org.lds.ldssa.dev:id/titleView"));
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/typeIcon"));
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"));
//        verifyText("CANCEL",WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"));
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"));
//        verifyText("DOWNLOAD",WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"));
//        ClickUIElementByID("org.lds.ldssa.dev:id/md_buttonDefaultPositive");
//        //snackbar almost always times out
//        //assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/snackbar_text"));
//        //verifyText("Downloading video for General Women's Session",WebElementById("org.lds.ldssa.dev:id/snackbar_text"));
//        // assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/snackbar_action"));
//        // verifyText("VIEW",WebElementById("org.lds.ldssa.dev:id/snackbar_action"));
//        ClickUIElementByID("org.lds.ldssa.dev:id/snackbar_action");
//        // Commented out because the download would complete before all assertions ran. assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
//        verifyText("Current Downloads (1)", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
//        // Commented out because the download would complete before all assertions ran. assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/titleTextView"));
//        verifyText("General Women's Session", WebElementById("org.lds.ldssa.dev:id/titleTextView"));
//        // Commented out because the download would complete before all assertions ran. assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/installStatusTextView"));
//        verifyText("Downloading…",WebElementById("org.lds.ldssa.dev:id/installStatusTextView"));
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/downloadCancelImageView"));
//        assertElementExistsBy(WebElementsByAccessibilityId("Cancel All"));
//        ClickUIElementByID("org.lds.ldssa.dev:id/downloadCancelImageView");
//        assertElementNotPresentBy(WebElementsById("org.lds.ldssa.dev:id/downloadCancelImageView"));
//        assertElementNotPresentBy(WebElementsById("Cancel All"));
//        assertElementNotPresentBy(WebElementsById("org.lds.ldssa.dev:id/installStatusTextView"));
//        assertElementNotPresentBy(WebElementsById("org.lds.ldssa.dev:id/titleTextView"));
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateImageView"));
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateTitleTextView"));
//        verifyText("No Downloads in Progress", WebElementById("org.lds.ldssa.dev:id/emptyStateTitleTextView"));
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateSubTitleTextView"));
//        verifyText("Content and media currently being downloaded.", WebElementById("org.lds.ldssa.dev:id/emptyStateSubTitleTextView"));
//        ClickUIElementByAccessibilityID("Navigate up");
//        ClickUIElementByAccessibilityID("More options");
//        ClickUIElementByText("Settings");
//        ClickUIElementByText("Downloaded Media");
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
//        verifyText("Downloaded Media", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateImageView"));
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateTitleTextView"));
//        verifyText("No Downloaded Media", WebElementById("org.lds.ldssa.dev:id/emptyStateTitleTextView"));
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateSubTitleTextView"));
//        verifyText("Download audio or video for offline access.", WebElementById("org.lds.ldssa.dev:id/emptyStateSubTitleTextView"));
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
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_title"));
        verifyText("Download Video",WebElementById("org.lds.ldssa.dev:id/md_title"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/titleView"));
        verifyText("General Women's Session",WebElementById("org.lds.ldssa.dev:id/titleView"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/typeIcon"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"));
        verifyText("CANCEL",WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"));
        verifyText("DOWNLOAD",WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"),false);
        ClickUIElementByID("org.lds.ldssa.dev:id/md_buttonDefaultPositive");
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        assertElementExistsBy(WebElementsByText("Downloaded Media", false));
        ClickUIElementByText("Downloaded Media", false);
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Sort by Size", false));
        assertElementExistsBy(WebElementsByText("Current Downloads", false));
        ClickUIElementByText("Current Downloads", false);
        // Commented out because the download would complete before all assertions ran. assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText("Current Downloads (1)", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"),false);
        // Commented out because the download would complete before all assertions ran. assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/titleTextView"));
        verifyText("General Women's Session", WebElementById("org.lds.ldssa.dev:id/titleTextView"),false);
        // Commented out because the download would complete before all assertions ran. assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/installStatusTextView"));
        verifyText("Downloading…",WebElementById("org.lds.ldssa.dev:id/installStatusTextView"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/downloadCancelImageView"));
        assertElementExistsBy(WebElementsByAccessibilityId("Cancel All"));
        ClickUIElementByAccessibilityID("Cancel All");
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_title"));
        verifyText("Cancel Download", WebElementById("org.lds.ldssa.dev:id/md_title"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_content"));
        verifyText("All current downloads will be canceled.\n" +
                "\n" +
                "Cancel downloads?",WebElementById("org.lds.ldssa.dev:id/md_content"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"));
        verifyText("NO",WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"));
        verifyText("YES",WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"),false);
        ClickUIElementByID("org.lds.ldssa.dev:id/md_buttonDefaultPositive");
        assertElementNotPresentBy(WebElementsById("org.lds.ldssa.dev:id/downloadCancelImageView"));
        assertElementNotPresentBy(WebElementsById("Cancel All"));
        assertElementNotPresentBy(WebElementsById("org.lds.ldssa.dev:id/installStatusTextView"));
        assertElementNotPresentBy(WebElementsById("org.lds.ldssa.dev:id/titleTextView"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateImageView"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateTitleTextView"));
        verifyText("No Downloads in Progress", WebElementById("org.lds.ldssa.dev:id/emptyStateTitleTextView"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateSubTitleTextView"));
        verifyText("Content and media currently being downloaded.", WebElementById("org.lds.ldssa.dev:id/emptyStateSubTitleTextView"),false);
        ClickUIElementByAccessibilityID("Navigate up");
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText("Downloaded Media", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"),false);
        //*************** These Assertions are broken because the Empty State of the Downloaded Media Page isn't working properly.
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateImageView"));
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateTitleTextView"));
//        verifyText("No Downloaded Media", WebElementById("org.lds.ldssa.dev:id/emptyStateTitleTextView"));
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateSubTitleTextView"));
//        verifyText("Download audio or video for offline access.", WebElementById("org.lds.ldssa.dev:id/emptyStateSubTitleTextView"));

    }

    @Test
    public void settingsScreenDownloadedMediaOTDownloaded_CancelAll_MultipleDownloads() throws Exception {
        skipLogin();
        OpenScripture("Old Testament","","","");
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Download Audio", false));
        ClickUIElementByText("Download Audio", false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_title"));
        verifyText("Download Audio",WebElementById("org.lds.ldssa.dev:id/md_title"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/titleView"));
        verifyText("Old Testament",WebElementById("org.lds.ldssa.dev:id/titleView"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/typeIcon"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"));
        verifyText("CANCEL",WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"));
        verifyText("DOWNLOAD",WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"),false);
        ClickUIElementByID("org.lds.ldssa.dev:id/md_buttonDefaultPositive");
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        assertElementExistsBy(WebElementsByText("Downloaded Media", false));
        ClickUIElementByText("Downloaded Media", false);
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Sort by Size", false));
        assertElementExistsBy(WebElementsByText("Current Downloads", false));
        ClickUIElementByText("Current Downloads", false);
        assertElementExistsBy(WebElementsByAccessibilityId("Cancel All"));
        ClickUIElementByAccessibilityID("Cancel All");
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_title"));
        verifyText("Cancel Download", WebElementById("org.lds.ldssa.dev:id/md_title"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_content"));
        verifyText("All current downloads will be canceled.\n" +
                "\n" +
                "Cancel downloads?",WebElementById("org.lds.ldssa.dev:id/md_content"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"));
        verifyText("NO",WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"));
        verifyText("YES",WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"),false);
        ClickUIElementByID("org.lds.ldssa.dev:id/md_buttonDefaultPositive");
        assertElementNotPresentBy(WebElementsById("org.lds.ldssa.dev:id/downloadCancelImageView"));
        assertElementNotPresentBy(WebElementsById("Cancel All"));
        assertElementNotPresentBy(WebElementsById("org.lds.ldssa.dev:id/installStatusTextView"));
        assertElementNotPresentBy(WebElementsById("org.lds.ldssa.dev:id/titleTextView"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateImageView"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateTitleTextView"));
        verifyText("No Downloads in Progress", WebElementById("org.lds.ldssa.dev:id/emptyStateTitleTextView"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateSubTitleTextView"));
        verifyText("Content and media currently being downloaded.", WebElementById("org.lds.ldssa.dev:id/emptyStateSubTitleTextView"),false);
        ClickUIElementByAccessibilityID("Navigate up");
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText("Downloaded Media", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"),false);
        //*************** These Assertions are broken because the Empty State of the Downloaded Media Page isn't working properly.
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateImageView"));
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateTitleTextView"));
//        verifyText("No Downloaded Media", WebElementById("org.lds.ldssa.dev:id/emptyStateTitleTextView"));
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateSubTitleTextView"));
//        verifyText("Download audio or video for offline access.", WebElementById("org.lds.ldssa.dev:id/emptyStateSubTitleTextView"));

    }



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
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/alertTitle"));
        verifyText("Theme", WebElementById("org.lds.ldssa.dev:id/alertTitle"),false);
        assertElementExistsBy(WebElementsByCheckedText("Default",false));
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
        assertElementExistsBy(WebElementsByText("LDS Account", false));
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
        assertElementExistsBy(WebElementsByText("LDS Account", false));
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
        assertElementExistsBy(WebElementsByText("LDS Account", false));
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
        assertElementExistsBy(WebElementsByText("LDS Account", false));
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
        verifyText("Cancel", WebElementById("android:id/button2"),true);
        ClickUIElementByID("android:id/button2");
        assertElementExistsBy(WebElementsByText("LDS Account", false));
        Thread.sleep(milliseconds_1);
    }


    @Test
    public void settingsScreenThemeAllThemesTextColorAndFootnoteColor() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "1", "1");
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println("Subtitle: " + WebElementById("title_number1").getCssValue("color"));
        assertEquals("rgba(33, 34, 37, 1)", WebElementById("title_number1").getCssValue("color"));
        assertEquals("rgb(23, 124, 156)", getComputedCssUsingXpath("//*[@id='p1']/span/sup", "color"));
        driver.context("NATIVE_APP");
        ChangeTheme("Default");
        driver.getPageSource();
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println("Default Text Color: " + WebElementById("title_number1").getCssValue("color"));
        assertEquals("rgba(33, 34, 37, 1)", WebElementById("title_number1").getCssValue("color"));
        assertEquals("rgb(23, 124, 156)", getComputedCssUsingXpath("//*[@id='p1']/span/sup", "color"));
        driver.context("NATIVE_APP");
        ChangeTheme("Sepia");
        driver.getPageSource();
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println("Sepia Text Color: " + WebElementById("title_number1").getCssValue("color"));
        assertEquals("rgb(23, 124, 156)", getComputedCssUsingXpath("//*[@id='p1']/span/sup", "color"));
        driver.context("NATIVE_APP");
        ChangeTheme("Night");
        driver.getPageSource();
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println("Night Text Color: " + WebElementById("title_number1").getCssValue("color"));
        assertEquals("rgba(186, 186, 186, 1)", WebElementById("title_number1").getCssValue("color"));
        assertEquals("rgb(138, 225, 237)", getComputedCssUsingXpath("//*[@id='p1']/span/sup", "color"));
        driver.context("NATIVE_APP");
        ChangeTheme("Dark Blue");
        driver.getPageSource();
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println("Dark Blue Text Color: " + WebElementById("title_number1").getCssValue("color"));
        assertEquals("rgba(33, 34, 37, 1)", WebElementById("title_number1").getCssValue("color"));
        assertEquals("rgb(23, 124, 156)", getComputedCssUsingXpath("//*[@id='p1']/span/sup", "color"));
        driver.context("NATIVE_APP");
        ChangeTheme("Magenta");
        driver.getPageSource();
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println("Magenta Text Color: " + WebElementById("title_number1").getCssValue("color"));
        assertEquals("rgba(33, 34, 37, 1)", WebElementById("title_number1").getCssValue("color"));
        assertEquals("rgb(23, 124, 156)", getComputedCssUsingXpath("//*[@id='p1']/span/sup", "color"));
        driver.context("NATIVE_APP");
        Thread.sleep(milliseconds_5);



    }


    @Test
    public void settingsScreenTextSize() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "1", "1");
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        Assert.assertEquals("18px", (WebElementById("p1").getCssValue("font-size")));
        driver.context("NATIVE_APP");
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
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_title"));
        verifyText("Text Size", WebElementById("org.lds.ldssa.dev:id/md_title"),false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/sampleTextView"));
        verifyText("… behold I say unto you, that by small and simple things are great things brought to pass; and small means in many instances doth confound the wise.", WebElementByResourceId("org.lds.ldssa.dev:id/sampleTextView"),false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/textSizeSeekbar"));
        ClickSeekBarAt(WebElementByResourceId("org.lds.ldssa.dev:id/textSizeSeekbar"), 4);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"));
        verifyText("Cancel", WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"),true);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"));
        verifyText("OK", WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"),false);
        ClickUIElementByID("org.lds.ldssa.dev:id/md_buttonDefaultPositive");
        ClickUIElementByAccessibilityID("Navigate up");
        OpenScripture("Book of Mormon", "Jacob", "1", "1");
        System.out.println(driver.getContextHandles());
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        Assert.assertEquals("21px", (WebElementById("p1").getCssValue("font-size")));

    }

    @Test
    public void settingsScreenTextSizeCancelSameContent() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Ether", "1", "1");
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        Assert.assertEquals("18px", WebElementById("p1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        ClickUIElementByText("Settings", false);
        scrollDownTo("Text Size");
        assertElementExistsBy(WebElementsByText("Text Size", false));
        ClickUIElementByText("Text Size", false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_title"));
        verifyText("Text Size", WebElementById("org.lds.ldssa.dev:id/md_title"),false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/sampleTextView"));
        verifyText("… behold I say unto you, that by small and simple things are great things brought to pass; and small means in many instances doth confound the wise.", WebElementByResourceId("org.lds.ldssa.dev:id/sampleTextView"),false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/textSizeSeekbar"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"));
        verifyText("Cancel", WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"),true);
        ClickUIElementByID("org.lds.ldssa.dev:id/md_buttonDefaultNegative");
        ClickUIElementByAccessibilityID("Navigate up");
        driver.getPageSource();
        Thread.sleep(milliseconds_3);
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        Assert.assertEquals("18px", (WebElementById("p1").getCssValue("font-size")));
        driver.context("NATIVE_APP");
    }

    @Test
    public void settingsScreenTextSizeChangeSliderThenCancelSameContent() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Ether", "1", "1");
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        Assert.assertEquals("18px", WebElementById("p1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        ClickUIElementByText("Settings", false);
        scrollDownTo("Text Size");
        assertElementExistsBy(WebElementsByText("Text Size", false));
        ClickUIElementByText("Text Size", false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_title"));
        verifyText("Text Size", WebElementById("org.lds.ldssa.dev:id/md_title"),false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/sampleTextView"));
        verifyText("… behold I say unto you, that by small and simple things are great things brought to pass; and small means in many instances doth confound the wise.", WebElementByResourceId("org.lds.ldssa.dev:id/sampleTextView"),false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/textSizeSeekbar"));
        ClickSeekBarAt(WebElementByResourceId("org.lds.ldssa.dev:id/textSizeSeekbar"), 7);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"));
        verifyText("Cancel", WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"),true);
        ClickUIElementByID("org.lds.ldssa.dev:id/md_buttonDefaultNegative");
        ClickUIElementByAccessibilityID("Navigate up");
        driver.getPageSource();
        Thread.sleep(milliseconds_3);
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        Assert.assertEquals("18px", (WebElementById("p1").getCssValue("font-size")));
        driver.context("NATIVE_APP");
    }


    @Test
    public void settingsScreenTextSizeAllSizesSameContent() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "1", "1");
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        Assert.assertEquals("18px", WebElementById("p1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        ChangeTextSize(1);
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        Assert.assertEquals("12px", getComputedCssUsingXpath("//*[@class='body-block']","font-size"));
        driver.context("NATIVE_APP");
        ChangeTextSize(2);
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println(WebElementById("p1").getCssValue("font-size"));
        Assert.assertEquals("15px", getComputedCssUsingXpath("//*[@class='body-block']","font-size"));
        driver.context("NATIVE_APP");
        ChangeTextSize(3);
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println(WebElementById("p1").getCssValue("font-size"));
        Assert.assertEquals("18px", getComputedCssUsingXpath("//*[@class='body-block']","font-size"));
        driver.context("NATIVE_APP");
        ChangeTextSize(4);
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println(WebElementById("p1").getCssValue("font-size"));
        Assert.assertEquals("21px", getComputedCssUsingXpath("//*[@class='body-block']","font-size"));
        driver.context("NATIVE_APP");
        ChangeTextSize(5);
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println(WebElementById("p1").getCssValue("font-size"));
        Assert.assertEquals("26px", getComputedCssUsingXpath("//*[@class='body-block']","font-size"));
        driver.context("NATIVE_APP");
        ChangeTextSize(6);
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println(WebElementById("p1").getCssValue("font-size"));
        Assert.assertEquals("40px", getComputedCssUsingXpath("//*[@class='body-block']","font-size"));
        driver.context("NATIVE_APP");
        ChangeTextSize(7);
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println(WebElementById("p1").getCssValue("font-size"));
        Assert.assertEquals("60px", getComputedCssUsingXpath("//*[@class='body-block']","font-size"));
        driver.context("NATIVE_APP");
    }

    @Test
    public void settingsScreenTextSizeAllSizesSameRelatedContentScripture() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "1", "1");
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        Assert.assertEquals("18px", WebElementById("p1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Related Content", false));
        ClickUIElementByText("Related Content", false);
        assertElementExistsBy(WebElementsByText("1a", false));
        ClickUIElementByText("1a", false);
        Assert.assertEquals("18px",getComputedCssUsingXpath("//*[@id='p27']","font-size"));
        ClickUIElementByXpath("//android.widget.TextView[@text='1a']/../android.widget.ImageButton");
        ClickUIElementByXpath("//android.widget.TextView[@text='Related Content']/../android.widget.ImageButton");
        ChangeTextSize(1);
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        Assert.assertEquals("12px", WebElementById("p1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Related Content", false));
        ClickUIElementByText("Related Content", false);
        assertElementExistsBy(WebElementsByText("1a", false));
        ClickUIElementByText("1a", false);
        driver.getPageSource();
        Assert.assertEquals("12px",getComputedCssUsingXpath("//*[@id='p27']","font-size"));
        ClickUIElementByXpath("//android.widget.TextView[@text='1a']/../android.widget.ImageButton");
        ClickUIElementByXpath("//android.widget.TextView[@text='Related Content']/../android.widget.ImageButton");
        ChangeTextSize(2);
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println(WebElementById("p1").getCssValue("font-size"));
        Assert.assertEquals("15px", WebElementById("p1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Related Content", false));
        ClickUIElementByText("Related Content", false);
        assertElementExistsBy(WebElementsByText("1a", false));
        ClickUIElementByText("1a", false);
        Assert.assertEquals("15px",getComputedCssUsingXpath("//*[@id='p27']","font-size"));
        ClickUIElementByXpath("//android.widget.TextView[@text='1a']/../android.widget.ImageButton");
        ClickUIElementByXpath("//android.widget.TextView[@text='Related Content']/../android.widget.ImageButton");
        ChangeTextSize(3);
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println(WebElementById("p1").getCssValue("font-size"));
        Assert.assertEquals("18px", WebElementById("p1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Related Content", false));
        ClickUIElementByText("Related Content", false);
        assertElementExistsBy(WebElementsByText("1a", false));
        ClickUIElementByText("1a", false);
        Assert.assertEquals("18px",getComputedCssUsingXpath("//*[@id='p27']","font-size"));
        ClickUIElementByXpath("//android.widget.TextView[@text='1a']/../android.widget.ImageButton");
        ClickUIElementByXpath("//android.widget.TextView[@text='Related Content']/../android.widget.ImageButton");
        ChangeTextSize(4);
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println(WebElementById("p1").getCssValue("font-size"));
        Assert.assertEquals("21px", WebElementById("p1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Related Content", false));
        ClickUIElementByText("Related Content", false);
        assertElementExistsBy(WebElementsByText("1a", false));
        ClickUIElementByText("1a", false);
        Assert.assertEquals("21px",getComputedCssUsingXpath("//*[@id='p27']","font-size"));
        ClickUIElementByXpath("//android.widget.TextView[@text='1a']/../android.widget.ImageButton");
        ClickUIElementByXpath("//android.widget.TextView[@text='Related Content']/../android.widget.ImageButton");
        ChangeTextSize(5);
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println(WebElementById("p1").getCssValue("font-size"));
        Assert.assertEquals("26px", WebElementById("p1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Related Content", false));
        ClickUIElementByText("Related Content", false);
        assertElementExistsBy(WebElementsByText("1a", false));
        ClickUIElementByText("1a", false);
        Assert.assertEquals("26px",getComputedCssUsingXpath("//*[@id='p27']","font-size"));
        ClickUIElementByXpath("//android.widget.TextView[@text='1a']/../android.widget.ImageButton");
        ClickUIElementByXpath("//android.widget.TextView[@text='Related Content']/../android.widget.ImageButton");
        ChangeTextSize(6);
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println(WebElementById("p1").getCssValue("font-size"));
        Assert.assertEquals("40px", WebElementById("p1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Related Content", false));
        ClickUIElementByText("Related Content", false);
        assertElementExistsBy(WebElementsByText("1a", false));
        ClickUIElementByText("1a", false);
        System.out.println(getComputedCssUsingXpath("//*[@id='p27']","font-size"));
        ClickUIElementByXpath("//android.widget.TextView[@text='1a']/../android.widget.ImageButton");
        ClickUIElementByXpath("//android.widget.TextView[@text='Related Content']/../android.widget.ImageButton");
        ChangeTextSize(7);
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println(WebElementById("p1").getCssValue("font-size"));
        Assert.assertEquals("60px", WebElementById("p1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Related Content", false));
        ClickUIElementByText("Related Content", false);
        assertElementExistsBy(WebElementsByText("1a", false));
        ClickUIElementByText("1a", false);
        Assert.assertEquals("60px",getComputedCssUsingXpath("//*[@id='p27']","font-size"));
        ClickUIElementByXpath("//android.widget.TextView[@text='1a']/../android.widget.ImageButton");
        ClickUIElementByXpath("//android.widget.TextView[@text='Related Content']/../android.widget.ImageButton");
    }

    @Test
    public void settingsScreenTextSizeAllSizesTitle_Subtitle_Body_SameContent() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Jacob", "1", "1");
//        swipeRight();
//        scrollToById("title1");
//        driver.context("WEBVIEW_org.lds.ldssa.dev");
//        System.out.println("Title: " + driver.findElementByClassName("dominant").getCssValue("font-size"));
//        driver.context("NATIVE_APP");
        scrollToByResourceId("title_number1");
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println("Subtitle: " + WebElementById("title_number1").getCssValue("font-size"));
        Assert.assertEquals("19.8px",WebElementById("title_number1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        scrollToByResourceId("study_summary1");
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println("Study Summary: " + WebElementById("study_summary1").getCssValue("font-size"));
        Assert.assertEquals("18px",WebElementById("study_summary1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        scrollToByResourceId("p1");
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println("p1: " + WebElementById("p1").getCssValue("font-size"));
        Assert.assertEquals("18px",WebElementById("p1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        ChangeTextSize(1);
        scrollToByResourceId("title1");
//        driver.context("WEBVIEW_org.lds.ldssa.dev");
//        System.out.println("Title: " + WebElementById("title1").getCssValue("font-size"));
//        driver.context("NATIVE_APP");
        scrollToByResourceId("title_number1");
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        driver.getPageSource();
        System.out.println("Subtitle: " + WebElementById("title_number1").getCssValue("font-size"));
        Assert.assertEquals("13.2px",WebElementById("title_number1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        scrollToByResourceId("study_summary1");
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println("Study Summary: " + WebElementById("study_summary1").getCssValue("font-size"));
        Assert.assertEquals("12px",WebElementById("study_summary1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        scrollToByResourceId("p1");
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println("p1: " + WebElementById("p1").getCssValue("font-size"));
        Assert.assertEquals("12px",WebElementById("p1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        ChangeTextSize(2);
        scrollToByResourceId("title1");
//        driver.context("WEBVIEW_org.lds.ldssa.dev");
//        System.out.println("Title: " + WebElementById("title1").getCssValue("font-size"));
//        driver.context("NATIVE_APP");
        scrollToByResourceId("title_number1");
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        driver.getPageSource();
        System.out.println("Subtitle: " + WebElementById("title_number1").getCssValue("font-size"));
        Assert.assertEquals("16.5px",WebElementById("title_number1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        scrollToByResourceId("study_summary1");
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println("Study Summary: " + WebElementById("study_summary1").getCssValue("font-size"));
        Assert.assertEquals("15px",WebElementById("study_summary1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        scrollToByResourceId("p1");
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println("p1: " + WebElementById("p1").getCssValue("font-size"));
        Assert.assertEquals("15px",WebElementById("ps").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        ChangeTextSize(3);
        scrollToByResourceId("title1");
//        driver.context("WEBVIEW_org.lds.ldssa.dev");
//        System.out.println("Title: " + WebElementById("title1").getCssValue("font-size"));
//        driver.context("NATIVE_APP");
        scrollToByResourceId("title_number1");
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        driver.getPageSource();
        System.out.println("Subtitle: " + WebElementById("title_number1").getCssValue("font-size"));
        Assert.assertEquals("19.8px",WebElementById("title_number1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        scrollToByResourceId("study_summary1");
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println("Study Summary: " + WebElementById("study_summary1").getCssValue("font-size"));
        Assert.assertEquals("18px",WebElementById("study_summary1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        scrollToByResourceId("p1");
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println("p1: " + WebElementById("p1").getCssValue("font-size"));
        Assert.assertEquals("18px",WebElementById("p1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        ChangeTextSize(4);
        scrollToByResourceId("title1");
//        driver.context("WEBVIEW_org.lds.ldssa.dev");
//        System.out.println("Title: " + WebElementById("title1").getCssValue("font-size"));
//        driver.context("NATIVE_APP");
        scrollToByResourceId("title_number1");
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        driver.getPageSource();
        System.out.println("Subtitle: " + WebElementById("title_number1").getCssValue("font-size"));
        Assert.assertEquals("23.1px",WebElementById("title_number1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        scrollToByResourceId("study_summary1");
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println("Study Summary: " + WebElementById("study_summary1").getCssValue("font-size"));
        Assert.assertEquals("21px",WebElementById("study_summary1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        scrollToByResourceId("p1");
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println("p1: " + WebElementById("p1").getCssValue("font-size"));
        Assert.assertEquals("21px",WebElementById("p1").getCssValue("font-size"));

        driver.context("NATIVE_APP");
        ChangeTextSize(5);
        scrollToByResourceId("title1");
//        driver.context("WEBVIEW_org.lds.ldssa.dev");
//        System.out.println("Title: " + WebElementById("title1").getCssValue("font-size"));
//        driver.context("NATIVE_APP");
        scrollToByResourceId("title_number1");
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        driver.getPageSource();
        System.out.println("Subtitle: " + WebElementById("title_number1").getCssValue("font-size"));
        Assert.assertEquals("28.6px",WebElementById("title_number1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        scrollToByResourceId("study_summary1");
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println("Study Summary: " + WebElementById("study_summary1").getCssValue("font-size"));
        Assert.assertEquals("26px",WebElementById("study_summary1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        scrollToByResourceId("p1");
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println("p1: " + WebElementById("p1").getCssValue("font-size"));
        Assert.assertEquals("26px",WebElementById("p1").getCssValue("font-size"));

        driver.context("NATIVE_APP");
        ChangeTextSize(6);
        scrollToByResourceId("title1");
//        driver.context("WEBVIEW_org.lds.ldssa.dev");
//        System.out.println("Title: " + WebElementById("title1").getCssValue("font-size"));
//        driver.context("NATIVE_APP");
        scrollToByResourceId("title_number1");
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        driver.getPageSource();
        System.out.println("Subtitle: " + WebElementById("title_number1").getCssValue("font-size"));
        Assert.assertEquals("44px",WebElementById("title_number1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        scrollToByResourceId("study_summary1");
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println("Study Summary: " + WebElementById("study_summary1").getCssValue("font-size"));
        Assert.assertEquals("40px",WebElementById("study_summary1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        scrollToByResourceId("p1");
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println("p1: " + WebElementById("p1").getCssValue("font-size"));
        Assert.assertEquals("40px",WebElementById("p1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        ChangeTextSize(7);
        scrollToByResourceId("title1");
//        driver.context("WEBVIEW_org.lds.ldssa.dev");
//        System.out.println("Title: " + WebElementById("title1").getCssValue("font-size"));
//        driver.context("NATIVE_APP");
        scrollToByResourceId("title_number1");
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        driver.getPageSource();
        System.out.println("Subtitle: " + WebElementById("title_number1").getCssValue("font-size"));
        Assert.assertEquals("66px",WebElementById("title_number1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        scrollToByResourceId("study_summary1");
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println("Study Summary: " + WebElementById("study_summary1").getCssValue("font-size"));
        Assert.assertEquals("60px",WebElementById("study_summary1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
        scrollToByResourceId("p1");
        driver.context("WEBVIEW_org.lds.ldssa.dev");
        System.out.println("p1: " + WebElementById("p1").getCssValue("font-size"));
        Assert.assertEquals("60px",WebElementById("p1").getCssValue("font-size"));
        driver.context("NATIVE_APP");
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
        scriptureParent = WebElementByXpath("(//android.widget.TextView[@text='Scriptures'])"+isAndroidVersion("[2]","[1]")+"/..");
        System.out.println("Screen width is: " + screenWidth + " Element width is: " + scriptureParent.getSize().getWidth());
        assertEquals(screenWidth,scriptureParent.getSize().getWidth());
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

        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText("Library", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"),false);
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmark"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        int screenWidth = driver.manage().window().getSize().getWidth();
        scrollDownTo("Scriptures");
        assertElementExistsBy(WebElementsByXpath("(//android.widget.TextView[@text=\""+isAllCaps("Scriptures")+"\"])[1]/.."));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text=\""+isAllCaps("Scriptures")+"\"])[1]/../..").getSize().getWidth());
        assertElementExistsBy(WebElementsByXpath("(//android.widget.TextView[@text=\"Scriptures\"])"+isAndroidVersion("[2]","[1]")+"/.."));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Scriptures'])"+isAndroidVersion("[2]","[1]")+"/..").getSize().getWidth());
        scrollDownTo("Jesus Christ");
        assertElementExistsBy(WebElementsByText("Jesus Christ", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Jesus Christ'])/..").getSize().getWidth());
        scrollDownTo("General Conference");
        assertElementExistsBy(WebElementsByText("General Conference", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='General Conference'])/..").getSize().getWidth());
        scrollDownTo("Teachings of Presidents");
        assertElementExistsBy(WebElementsByText("Teachings of Presidents", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Teachings of Presidents'])/..").getSize().getWidth());
        scrollDownTo("Notes");
        assertElementExistsBy(WebElementsByText("My Collections", true));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text=\""+isAllCaps("My Collections")+"\"])/../..").getSize().getWidth());
        assertElementExistsBy(WebElementsByText("Notes", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Notes'])/..").getSize().getWidth());
        scrollDownTo("Lessons");
        assertElementExistsBy(WebElementsByText("Inspiration", true));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text=\""+isAllCaps("Inspiration")+"\"])/../..").getSize().getWidth());
        assertElementExistsBy(WebElementsByText("Lessons", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Lessons'])/..").getSize().getWidth());
        scrollDownTo("Magazines");
        assertElementExistsBy(WebElementsByText("Magazines", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Magazines'])/..").getSize().getWidth());
        scrollDownTo("Music");
        assertElementExistsBy(WebElementsByText("Music", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Music'])/..").getSize().getWidth());
        scrollDownTo("Videos");
        assertElementExistsBy(WebElementsByText("Videos", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Videos'])/..").getSize().getWidth());
        scrollDownTo("Missionary");
        assertElementExistsBy(WebElementsByText("Missionary", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Missionary'])/..").getSize().getWidth());
        scrollDownTo("Temple and Family History");
        assertElementExistsBy(WebElementsByText("Temple and Family History", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Temple and Family History'])/..").getSize().getWidth());
        scrollDownTo("Individuals and Families");
        assertElementExistsBy(WebElementsByText("Audiences", true));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text=\""+isAllCaps("Audiences")+"\"])/../..").getSize().getWidth());
        assertElementExistsBy(WebElementsByText("Individuals and Families", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Individuals and Families'])/..").getSize().getWidth());
        scrollDownTo("Young Adults");
        assertElementExistsBy(WebElementsByText("Young Adults", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Young Adults'])/..").getSize().getWidth());
        scrollDownTo("Youth");
        assertElementExistsBy(WebElementsByText("Youth", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Youth'])/..").getSize().getWidth());
        scrollDownTo("Children");
        assertElementExistsBy(WebElementsByText("Children", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Children'])/..").getSize().getWidth());
        scrollDownTo("Leaders");
        assertElementExistsBy(WebElementsByText("Leaders", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Leaders'])/..").getSize().getWidth());
        scrollDownTo("Self-Reliance");
        assertElementExistsBy(WebElementsByText("Self-Reliance", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Self-Reliance'])/..").getSize().getWidth());
        scrollDownTo("Religious Freedom");
        assertElementExistsBy(WebElementsByText("Religious Freedom", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Religious Freedom'])/..").getSize().getWidth());
        scrollDownTo("Church History");
        assertElementExistsBy(WebElementsByText("Other", true));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text=\""+isAllCaps("Other")+"\"])/../..").getSize().getWidth());
        assertElementExistsBy(WebElementsByText("Church History", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Church History'])/..").getSize().getWidth());
        scrollDownTo("Seminaries and Institutes");
        assertElementExistsBy(WebElementsByText("Seminaries and Institutes", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Seminaries and Institutes'])/..").getSize().getWidth());
        scrollDownTo("Tips");
        assertElementExistsBy(WebElementsByXpath("(//android.widget.TextView[@text=\""+isAllCaps("Tips")+"\"])[1]"));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text=\""+isAllCaps("Tips")+"\"])[1]/../..").getSize().getWidth());
        assertElementExistsBy(WebElementsByXpath("(//android.widget.TextView[@text='Tips'])"+isAndroidVersion("[2]","[1]")));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Tips'])"+isAndroidVersion("[2]","[1]")+"/..").getSize().getWidth());


        ClickUIElementByAccessibilityID("More options");
        Thread.sleep(milliseconds_1);
        assertElementExistsBy(WebElementsByText("New Screen…", false));
        assertElementExistsBy(WebElementsByText("Custom Collections", false));
        assertElementExistsBy(WebElementsByText("Language…", false));
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

        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText("Library", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"),false);
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmark"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        int screenWidth = driver.manage().window().getSize().getWidth();
        scrollDownTo("Scriptures");
        assertElementExistsBy(WebElementsByXpath("(//android.widget.TextView[@text=\""+isAllCaps("Scriptures")+"\"])[1]/.."));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text=\""+isAllCaps("Scriptures")+"\"])[1]/../..").getSize().getWidth());
        assertElementExistsBy(WebElementsByXpath("(//android.widget.TextView[@text='Scriptures'])"+isAndroidVersion("[2]","[1]")+"/.."));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Scriptures'])"+isAndroidVersion("[2]","[1]")+"/..").getSize().getWidth());
        WebElementByXpath("(//android.widget.TextView[@text='Scriptures'])"+isAndroidVersion("[2]","[1]")+"/..").click();
        assertElementExistsBy(WebElementsByXpath("(//android.widget.TextView[@text='Scriptures'])[1]"));
        assertElementExistsBy(WebElementsByXpath("(//android.widget.TextView[@text='Scriptures'])"+isAndroidVersion("[2]","[1]")));
        scrollDownTo("Old Testament");
        assertElementExistsBy(WebElementsByText("Old Testament", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Old Testament'])/..").getSize().getWidth());
        scrollDownTo("New Testament");
        assertElementExistsBy(WebElementsByText("New Testament", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='New Testament'])/..").getSize().getWidth());
        scrollDownTo("Book of Mormon");
        assertElementExistsBy(WebElementsByText("Book of Mormon", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Book of Mormon'])/..").getSize().getWidth());
        scrollDownTo("Doctrine and Covenants");
        assertElementExistsBy(WebElementsByText("Doctrine and Covenants", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Doctrine and Covenants'])/..").getSize().getWidth());
        scrollDownTo("Pearl of Great Price");
        assertElementExistsBy(WebElementsByText("Pearl of Great Price", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Pearl of Great Price'])/..").getSize().getWidth());
        scrollDownTo(isAllCaps("Study Helps"));
        assertElementExistsBy(WebElementsByText("Study Helps", true));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text=\""+isAllCaps("Study Helps")+"\"])/../..").getSize().getWidth());
        scrollDownTo("Guide to the Scriptures");
        assertElementExistsBy(WebElementsByText("Guide to the Scriptures", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Guide to the Scriptures'])/..").getSize().getWidth());
        scrollDownTo("Topical Guide");
        assertElementExistsBy(WebElementsByText("Topical Guide", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Topical Guide'])/..").getSize().getWidth());
        scrollDownTo("Bible Dictionary");
        assertElementExistsBy(WebElementsByText("Bible Dictionary", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Bible Dictionary'])/..").getSize().getWidth());
        scrollDownTo("Bible Chronology");
        assertElementExistsBy(WebElementsByText("Bible Chronology", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Bible Chronology'])/..").getSize().getWidth());
        scrollDownTo("Harmony of the Gospels");
        assertElementExistsBy(WebElementsByText("Harmony of the Gospels", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Harmony of the Gospels'])/..").getSize().getWidth());
        scrollDownTo("Joseph Smith Translation Appendix");
        assertElementExistsBy(WebElementsByText("Joseph Smith Translation Appendix", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Joseph Smith Translation Appendix'])/..").getSize().getWidth());
        scrollDownTo("Bible Maps");
        assertElementExistsBy(WebElementsByText("Bible Maps", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Bible Maps'])/..").getSize().getWidth());
        scrollDownTo("Bible Photographs");
        assertElementExistsBy(WebElementsByText("Bible Photographs", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Bible Photographs'])/..").getSize().getWidth());
        scrollDownTo("Index to the Triple Combination");
        assertElementExistsBy(WebElementsByText("Index to the Triple Combination", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Index to the Triple Combination'])/..").getSize().getWidth());
        scrollDownTo("Church History Maps");
        assertElementExistsBy(WebElementsByText("Church History Maps", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Church History Maps'])/..").getSize().getWidth());
        scrollDownTo("Church History Photographs");
        assertElementExistsBy(WebElementsByText("Church History Photographs", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Church History Photographs'])/..").getSize().getWidth());
        scrollDownTo("Abbreviations");
        assertElementExistsBy(WebElementsByText("Abbreviations", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Abbreviations'])/..").getSize().getWidth());
        scrollDownTo("About the Scriptures");
        assertElementExistsBy(WebElementsByText("About the Scriptures", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='About the Scriptures'])/..").getSize().getWidth());
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

        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText("Library", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"),false);
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmark"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        int screenWidth = driver.manage().window().getSize().getWidth();
        scrollDownTo("Scriptures");
        assertElementExistsBy(WebElementsByXpath("(//android.widget.TextView[@text=\""+isAllCaps("Scriptures")+"\"])[1]/.."));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text=\""+isAllCaps("Scriptures")+"\"])[1]/../..").getSize().getWidth());
        assertElementExistsBy(WebElementsByXpath("(//android.widget.TextView[@text='Scriptures'])"+isAndroidVersion("[2]","[1]")+"/.."));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Scriptures'])"+isAndroidVersion("[2]","[1]")+"/..").getSize().getWidth());
        WebElementByXpath("(//android.widget.TextView[@text='Scriptures'])"+isAndroidVersion("[2]","[1]")+"/..").click();
        assertElementExistsBy(WebElementsByXpath("(//android.widget.TextView[@text='Scriptures'])[1]"));
        assertElementExistsBy(WebElementsByXpath("(//android.widget.TextView[@text=\""+isAllCaps("Scriptures")+"\"])"+isAndroidVersion("[2]","[1]")));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text=\""+isAllCaps("Scriptures")+"\"])"+isAndroidVersion("[2]","[1]")+"/../..").getSize().getWidth());
        scrollDownTo("Old Testament");
        assertElementExistsBy(WebElementsByText("Old Testament", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Old Testament'])/..").getSize().getWidth());
        scrollDownTo("New Testament");
        assertElementExistsBy(WebElementsByText("New Testament", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='New Testament'])/..").getSize().getWidth());
        scrollDownTo("Book of Mormon");
        assertElementExistsBy(WebElementsByText("Book of Mormon", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Book of Mormon'])/..").getSize().getWidth());
        scrollDownTo("Doctrine and Covenants");
        assertElementExistsBy(WebElementsByText("Doctrine and Covenants", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Doctrine and Covenants'])/..").getSize().getWidth());
        scrollDownTo("Pearl of Great Price");
        assertElementExistsBy(WebElementsByText("Pearl of Great Price", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Pearl of Great Price'])/..").getSize().getWidth());
        scrollDownTo(isAllCaps("Study Helps"));
        assertElementExistsBy(WebElementsByText("Study Helps", true));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text=\""+isAllCaps("Study Helps")+"\"])/../..").getSize().getWidth());
        scrollDownTo("Guide to the Scriptures");
        assertElementExistsBy(WebElementsByText("Guide to the Scriptures", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Guide to the Scriptures'])/..").getSize().getWidth());
        scrollDownTo("Topical Guide");
        assertElementExistsBy(WebElementsByText("Topical Guide", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Topical Guide'])/..").getSize().getWidth());
        scrollDownTo("Bible Dictionary");
        assertElementExistsBy(WebElementsByText("Bible Dictionary", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Bible Dictionary'])/..").getSize().getWidth());
        scrollDownTo("Bible Chronology");
        assertElementExistsBy(WebElementsByText("Bible Chronology", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Bible Chronology'])/..").getSize().getWidth());
        scrollDownTo("Harmony of the Gospels");
        assertElementExistsBy(WebElementsByText("Harmony of the Gospels", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Harmony of the Gospels'])/..").getSize().getWidth());
        scrollDownTo("Joseph Smith Translation Appendix");
        assertElementExistsBy(WebElementsByText("Joseph Smith Translation Appendix", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Joseph Smith Translation Appendix'])/..").getSize().getWidth());
        scrollDownTo("Bible Maps");
        assertElementExistsBy(WebElementsByText("Bible Maps", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Bible Maps'])/..").getSize().getWidth());
        scrollDownTo("Bible Photographs");
        assertElementExistsBy(WebElementsByText("Bible Photographs", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Bible Photographs'])/..").getSize().getWidth());
        scrollDownTo("Index to the Triple Combination");
        assertElementExistsBy(WebElementsByText("Index to the Triple Combination", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Index to the Triple Combination'])/..").getSize().getWidth());
        scrollDownTo("Church History Maps");
        assertElementExistsBy(WebElementsByText("Church History Maps", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Church History Maps'])/..").getSize().getWidth());
        scrollDownTo("Church History Photographs");
        assertElementExistsBy(WebElementsByText("Church History Photographs", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Church History Photographs'])/..").getSize().getWidth());
        scrollDownTo("Abbreviations");
        assertElementExistsBy(WebElementsByText("Abbreviations", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='Abbreviations'])/..").getSize().getWidth());
        scrollDownTo("About the Scriptures");
        assertElementExistsBy(WebElementsByText("About the Scriptures", false));
        assertEquals(screenWidth,WebElementByXpath("(//android.widget.TextView[@text='About the Scriptures'])/..").getSize().getWidth());
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
        assertElementExistsBy(WebElementsByText("New Screen…", false));
        ClickUIElementByText("New Screen…", false);
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
        assertElementExistsBy(WebElementsByText("Gospel Library", false));
        assertElementNotPresentBy(WebElementsByText("Library", false));
        assertElementNotPresentBy(WebElementsByText("Scriptures", false));
        Thread.sleep(milliseconds_2);
    }

    @Test
    public void settingsScreenShowScreensAsSeparateWindowsSwitchCheckTwoScreensOptionOnToOffFromSecondaryScreen() throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("New Screen…", false));
        ClickUIElementByText("New Screen…", false);
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
        assertElementNotPresentBy(WebElementsByText("Gospel Library", false));
        assertElementNotPresentBy(WebElementsByText("Scriptures", false));
        Thread.sleep(milliseconds_2);
    }

    @Test
    public void settingsScreenShowScreensAsSeparateWindowsSwitchCheckOffToOnAddScreen() throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("New Screen…", false));
        ClickUIElementByText("New Screen…", false);
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
        assertElementExistsBy(WebElementsByText("Gospel Library", false));
        assertElementNotPresentBy(WebElementsByText("Library", false));
        assertElementNotPresentBy(WebElementsByText("Scriptures", false));
        Thread.sleep(milliseconds_2);
        ClickUIElementByText("Gospel Library", false);
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
        assertElementExistsBy(WebElementsByText("New Screen…", false));
        ClickUIElementByText("New Screen…", false);
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
        assertElementExistsBy(WebElementsByText("New Screen…", false));
        ClickUIElementByText("New Screen…", false);
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
        assertElementExistsBy(WebElementsByText("Gospel Library", false));
        assertElementNotPresentBy(WebElementsByText("Library", false));
        assertElementNotPresentBy(WebElementsByText("Scriptures", false));
        Thread.sleep(milliseconds_2);
        ClickUIElementByText("Gospel Library", false);
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("New Screen…", false));
        ClickUIElementByText("New Screen…", false);
        ClickUIElementByText("Lessons", false);
        verifyText("Lessons", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"),false);
        ((AndroidDriver) driver).pressKeyCode(187);
        Thread.sleep(milliseconds_1);
        assertElementExistsBy(WebElementsByText("Gospel Library", false));
        assertElementNotPresentBy(WebElementsByText("Lessons", false));
        assertElementNotPresentBy(WebElementsByText("Library", false));
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
        scrollDownTo("Lessons");
        ClickUIElementByText("Lessons", false);
        scrollDownTo("Primary");
        ClickUIElementByText("Primary", false);
        assertElementNotPresentBy(WebElementsByText("2017 Outline for Sharing Time", false));
        assertElementNotPresentBy(WebElementsByText("2016 Outline for Sharing Time", false));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Settings", false));
        ClickUIElementByText("Settings", false);
        scrollDownTo("Show Obsolete Content");
        assertElementExistsBy(WebElementsByText("Show Obsolete Content", false));
        assertSettingsSwitchExpectedStateAndToggle("Show Obsolete Content", false);
        ClickUIElementByAccessibilityID("Navigate up");
        scrollDownTo("2016 Outline for Sharing Time");
        assertElementExistsBy(WebElementsByText("2016 Outline for Sharing Time", false));
        scrollDownTo("2017 Outline for Sharing Time");
        assertElementExistsBy(WebElementsByText("2017 Outline for Sharing Time", false));

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
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbar"));
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText("Featured Apps", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"),false);
        appCheck("Bible Videos");
        appCheck("Book of Mormon");
        appCheck("Doctrinal Mastery");
        appCheck("FamilySearch Memories");
        appCheck("FamilySearch Tree");
        appCheck("LDS Media Library");
        appCheck("LDS Music");
        appCheck("LDS Tools");
        appCheck("LDS Youth");
        appCheck("Mormon Channel");
        appCheck("Mormon Tabernacle Choir");
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
        //Verify Exit Button
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        //Verify Page Title
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText("Send Feedback", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"),false);
        //Verify Attach Image
        assertElementExistsBy(WebElementsByAccessibilityId("Attach Image"));
        WebElement test = WebElementByAccessibilityId("Attach Image");
        //Verify Submit
        assertElementExistsBy(WebElementsByAccessibilityId("Submit"));
        //Verify Name Field
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackNameTextInputLayout"));
        verifyText("Name (Optional)", WebElementById("org.lds.ldssa.dev:id/feedbackNameTextInputLayout"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackNameTextInputEditText"));
        //Verify Email field
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackEmailTextInputLayout"));
        verifyText("Email",WebElementById("org.lds.ldssa.dev:id/feedbackEmailTextInputLayout"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackEmailTextInputEditText"));
        //Verify Category Spinner
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackCategorySpinner"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackCategorySpinnerTextView"));
        verifyText("Category",WebElementById("org.lds.ldssa.dev:id/feedbackCategorySpinnerTextView"),false);
        //Verify Description Field
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackDescriptionTextInputLayout"));
        verifyText("Description", WebElementById("org.lds.ldssa.dev:id/feedbackDescriptionTextInputLayout"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackDescriptionEditText"));
        //Verify text field counter
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/textinput_counter"));
        verifyText("0 / 1000", WebElementById("org.lds.ldssa.dev:id/textinput_counter"),false);

        //enter text into form
        sendText("org.lds.ldssa.dev:id/feedbackNameTextInputEditText", name);
        sendText("org.lds.ldssa.dev:id/feedbackEmailTextInputEditText", email);

        //verify category wheel options
        List category = new ArrayList();
        category.add("How do I…?");
        category.add("Compliment");
        category.add("Feature request");
        category.add("Functionality issue (Bug)");
        category.add("Content issue");
        category.add("Sign in or syncing issue");
        category.add("Other");

        for (int x = 0; x < category.size(); x++){
            ClickUIElementByID("org.lds.ldssa.dev:id/feedbackCategorySpinner");
            assertElementExistsBy(WebElementsByCheckedText((String) category.get(x), false));
            ClickUIElementByCheckedText((String) category.get(x), false);
            assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackCategorySpinner"));
            verifyText((String) category.get(x), WebElementById("android:id/text1"),false);
            Thread.sleep(milliseconds_1);

        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String description = ("sendto:"+ sendtoemail + " This is a test support email from automation sent on " + dateFormat.format(date) + " test: " + (new Exception().getStackTrace()[0].getMethodName()) + "");
        sendText("org.lds.ldssa.dev:id/feedbackDescriptionEditText",description);
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        driver.swipe(screenWidth / 2, screenHeight / 2, screenWidth / 2, screenHeight / 10 * 2, 2000);
        verifyText("" + description.length() + " / 1000", WebElementById("org.lds.ldssa.dev:id/textinput_counter"),false);
        Thread.sleep(milliseconds_1);
        ClickUIElementByAccessibilityID("Submit");
        Thread.sleep(milliseconds_5);
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
        //Verify Exit Button
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        //Verify Page Title
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText("Send Feedback", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"),false);
        //Verify Attach Image
        assertElementExistsBy(WebElementsByAccessibilityId("Attach Image"));
        WebElement test = WebElementByAccessibilityId("Attach Image");
        //Verify Submit
        assertElementExistsBy(WebElementsByAccessibilityId("Submit"));
        //Verify Name Field
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackNameTextInputLayout"));
        verifyText("Name (Optional)", WebElementById("org.lds.ldssa.dev:id/feedbackNameTextInputLayout"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackNameTextInputEditText"));
        //Verify Email field
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackEmailTextInputLayout"));
        verifyText("Email",WebElementById("org.lds.ldssa.dev:id/feedbackEmailTextInputLayout"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackEmailTextInputEditText"));
        //Verify Category Spinner
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackCategorySpinner"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackCategorySpinnerTextView"));
        verifyText("Category",WebElementById("org.lds.ldssa.dev:id/feedbackCategorySpinnerTextView"),false);
        //Verify Description Field
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackDescriptionTextInputLayout"));
        verifyText("Description", WebElementById("org.lds.ldssa.dev:id/feedbackDescriptionTextInputLayout"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackDescriptionEditText"));
        //Verify text field counter
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/textinput_counter"));
        verifyText("0 / 1000", WebElementById("org.lds.ldssa.dev:id/textinput_counter"),false);

        //enter text into form
        sendText("org.lds.ldssa.dev:id/feedbackEmailTextInputEditText", email);

        //verify category wheel options
        List category = new ArrayList();
        category.add("Content issue");

        for (int x = 0; x < category.size(); x++){
            ClickUIElementByID("org.lds.ldssa.dev:id/feedbackCategorySpinner");
            assertElementExistsBy(WebElementsByCheckedText((String) category.get(x), false));
            ClickUIElementByCheckedText((String) category.get(x), false);
            assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackCategorySpinner"));
            verifyText((String) category.get(x), WebElementById("android:id/text1"),false);
            Thread.sleep(milliseconds_1);

        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String description = ("sendto:"+ sendtoemail + " This is a test support email from automation sent on " + dateFormat.format(date) + " test: " + (new Exception().getStackTrace()[0].getMethodName()) + "");
        sendText("org.lds.ldssa.dev:id/feedbackDescriptionEditText",description);
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        driver.swipe(screenWidth / 2, screenHeight / 2, screenWidth / 2, screenHeight / 10 * 2, 2000);
        verifyText("" + description.length() + " / 1000", WebElementById("org.lds.ldssa.dev:id/textinput_counter"),false);
        Thread.sleep(milliseconds_1);
        ClickUIElementByAccessibilityID("Submit");
        Thread.sleep(milliseconds_5);
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
        //Verify Exit Button
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        //Verify Page Title
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText("Send Feedback", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"),false);
        //Verify Attach Image
        assertElementExistsBy(WebElementsByAccessibilityId("Attach Image"));
        WebElement test = WebElementByAccessibilityId("Attach Image");
        //Verify Submit
        assertElementExistsBy(WebElementsByAccessibilityId("Submit"));
        //Verify Name Field
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackNameTextInputLayout"));
        verifyText("Name (Optional)", WebElementById("org.lds.ldssa.dev:id/feedbackNameTextInputLayout"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackNameTextInputEditText"));
        //Verify Email field
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackEmailTextInputLayout"));
        verifyText("Email",WebElementById("org.lds.ldssa.dev:id/feedbackEmailTextInputLayout"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackEmailTextInputEditText"));
        //Verify Category Spinner
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackCategorySpinner"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackCategorySpinnerTextView"));
        verifyText("Category",WebElementById("org.lds.ldssa.dev:id/feedbackCategorySpinnerTextView"),false);
        //Verify Description Field
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackDescriptionTextInputLayout"));
        verifyText("Description", WebElementById("org.lds.ldssa.dev:id/feedbackDescriptionTextInputLayout"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackDescriptionEditText"));
        //Verify text field counter
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/textinput_counter"));
        verifyText("0 / 1000", WebElementById("org.lds.ldssa.dev:id/textinput_counter"),false);

        //enter text into form
        sendText("org.lds.ldssa.dev:id/feedbackNameTextInputEditText", name);
        sendText("org.lds.ldssa.dev:id/feedbackEmailTextInputEditText", email);

        //verify category wheel options
        List category = new ArrayList();
        category.add("Compliment");

        for (int x = 0; x < category.size(); x++){
            ClickUIElementByID("org.lds.ldssa.dev:id/feedbackCategorySpinner");
            assertElementExistsBy(WebElementsByCheckedText((String) category.get(x), false));
            ClickUIElementByCheckedText((String) category.get(x), false);
            assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackCategorySpinner"));
            verifyText((String) category.get(x), WebElementById("android:id/text1"),false);
            Thread.sleep(milliseconds_1);
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String description = ("sendto:"+ sendtoemail + " This is a test support email from automation sent on " + dateFormat.format(date) + " test: " + (new Exception().getStackTrace()[0].getMethodName()) + "");
        sendText("org.lds.ldssa.dev:id/feedbackDescriptionEditText",description);
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        driver.swipe(screenWidth / 2, screenHeight / 2, screenWidth / 2, screenHeight / 10 * 2, 2000);
        verifyText("" + description.length() + " / 1000", WebElementById("org.lds.ldssa.dev:id/textinput_counter"),false);
        ClickUIElementByAccessibilityID("Attach Image");
        ClickUIElementByAccessibilityID("More options");
        if (WebElementsByText("List view", false).size() > 0){
            ClickUIElementByText("List view", false);
        } else {
            TapCenterScreen();
        }
        String photoTitle = WebElementByXpath("//android.widget.ImageView/../android.widget.TextView").getText();
        System.out.println(photoTitle);
        ClickUIElementByXpath("//android.widget.ImageView");
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/bubbleLayout"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/bubbleTextView"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/bubbleDeleteImageView"));
        verifyText(photoTitle, WebElementById("org.lds.ldssa.dev:id/bubbleTextView"),false);
        Thread.sleep(milliseconds_1);
        ClickUIElementByAccessibilityID("Submit");
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
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
//        verifyText("Send Feedback", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
//        //Verify Attach Image
//        assertElementExistsBy(WebElementsByAccessibilityId("Attach Image"));
//        WebElement test = WebElementByAccessibilityId("Attach Image");
//        //Verify Submit
//        assertElementExistsBy(WebElementsByAccessibilityId("Submit"));
//        //Verify Name Field
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackNameTextInputLayout"));
//        verifyText("Name (Optional)", WebElementById("org.lds.ldssa.dev:id/feedbackNameTextInputLayout"));
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackNameTextInputEditText"));
//        //Verify Email field
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackEmailTextInputLayout"));
//        verifyText("Email",WebElementById("org.lds.ldssa.dev:id/feedbackEmailTextInputLayout"));
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackEmailTextInputEditText"));
//        //Verify Category Spinner
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackCategorySpinner"));
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackCategorySpinnerTextView"));
//        verifyText("Category",WebElementById("org.lds.ldssa.dev:id/feedbackCategorySpinnerTextView"));
//        //Verify Description Field
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackDescriptionTextInputLayout"));
//        verifyText("Description", WebElementById("org.lds.ldssa.dev:id/feedbackDescriptionTextInputLayout"));
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackDescriptionEditText"));
//        //Verify text field counter
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/textinput_counter"));
//        verifyText("0 / 1000", WebElementById("org.lds.ldssa.dev:id/textinput_counter"));
//
//        //enter text into form
//        sendText("org.lds.ldssa.dev:id/feedbackNameTextInputEditText", name);
//        sendText("org.lds.ldssa.dev:id/feedbackEmailTextInputEditText", email);
//
//        //verify category wheel options
//        List category = new ArrayList();
//        category.add("Compliment");
//
//        for (int x = 0; x < category.size(); x++){
//            ClickUIElementByID("org.lds.ldssa.dev:id/feedbackCategorySpinner");
//            assertElementExistsBy(WebElementsByCheckedText((String) category.get(x)));
//            ClickUIElementByCheckedText((String) category.get(x));
//            assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackCategorySpinner"));
//            verifyText((String) category.get(x), WebElementById("android:id/text1"));
//            Thread.sleep(milliseconds_1);
//        }
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Date date = new Date();
//        String description = ("sendto:"+ sendtoemail + " This is a test support email from automation sent on " + dateFormat.format(date) + " test: " + (new Exception().getStackTrace()[0].getMethodName()) + "");
//        sendText("org.lds.ldssa.dev:id/feedbackDescriptionEditText",description);
//        int screenHeight = driver.manage().window().getSize().getHeight();
//        int screenWidth = driver.manage().window().getSize().getWidth();
//        driver.swipe(screenWidth / 2, screenHeight / 2, screenWidth / 2, screenHeight / 10 * 2, 2000);
//        verifyText("" + description.length() + " / 1000", WebElementById("org.lds.ldssa.dev:id/textinput_counter"));
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
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/bubbleLayout"));
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/bubbleTextView"));
//        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/bubbleDeleteImageView"));
//        verifyText(photoTitle, WebElementById("org.lds.ldssa.dev:id/bubbleTextView"));
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
        //Verify Exit Button
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        //Verify Page Title
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText("Send Feedback", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"),false);
        //Verify Attach Image
        assertElementExistsBy(WebElementsByAccessibilityId("Attach Image"));
        WebElement test = WebElementByAccessibilityId("Attach Image");
        //Verify Submit
        assertElementExistsBy(WebElementsByAccessibilityId("Submit"));
        //Verify Name Field
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackNameTextInputLayout"));
        verifyText("Name (Optional)", WebElementById("org.lds.ldssa.dev:id/feedbackNameTextInputLayout"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackNameTextInputEditText"));
        //Verify Email field
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackEmailTextInputLayout"));
        verifyText("Email",WebElementById("org.lds.ldssa.dev:id/feedbackEmailTextInputLayout"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackEmailTextInputEditText"));
        //Verify Category Spinner
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackCategorySpinner"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackCategorySpinnerTextView"));
        verifyText("Category",WebElementById("org.lds.ldssa.dev:id/feedbackCategorySpinnerTextView"),false);
        //Verify Description Field
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackDescriptionTextInputLayout"));
        verifyText("Description", WebElementById("org.lds.ldssa.dev:id/feedbackDescriptionTextInputLayout"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackDescriptionEditText"));
        //Verify text field counter
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/textinput_counter"));
        verifyText("0 / 1000", WebElementById("org.lds.ldssa.dev:id/textinput_counter"),false);

        //enter text into form
        sendText("org.lds.ldssa.dev:id/feedbackNameTextInputEditText", name);
        sendText("org.lds.ldssa.dev:id/feedbackEmailTextInputEditText", email);

        //verify category wheel options
        List category = new ArrayList();
        category.add("Compliment");

        for (int x = 0; x < category.size(); x++){
            ClickUIElementByID("org.lds.ldssa.dev:id/feedbackCategorySpinner");
            assertElementExistsBy(WebElementsByCheckedText((String) category.get(x), false));
            ClickUIElementByCheckedText((String) category.get(x), false);
            assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackCategorySpinner"));
            verifyText((String) category.get(x), WebElementById("android:id/text1"),false);
            Thread.sleep(milliseconds_1);
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String description = ("sendto:"+ sendtoemail + " This is a test support email from automation sent on " + dateFormat.format(date) + " test: " + (new Exception().getStackTrace()[0].getMethodName()) + "");
        sendText("org.lds.ldssa.dev:id/feedbackDescriptionEditText",description);
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        driver.swipe(screenWidth / 2, screenHeight / 2, screenWidth / 2, screenHeight / 10 * 2, 2000);
        verifyText("" + description.length() + " / 1000", WebElementById("org.lds.ldssa.dev:id/textinput_counter"),false);
        ClickUIElementByAccessibilityID("Attach Image");
        ClickUIElementByAccessibilityID("More options");
        if (WebElementsByText("List view", false).size() > 0){
            ClickUIElementByText("List view", false);
        } else {
            TapCenterScreen();
        }
        String photoTitle = WebElementByXpath("//android.widget.ImageView/../android.widget.TextView").getText();
        System.out.println(photoTitle);
        ClickUIElementByXpath("//android.widget.ImageView");
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/bubbleLayout"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/bubbleTextView"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/bubbleDeleteImageView"));
        verifyText(photoTitle, WebElementById("org.lds.ldssa.dev:id/bubbleTextView"),false);
        Thread.sleep(milliseconds_1);
        ClickUIElementByID("org.lds.ldssa.dev:id/bubbleDeleteImageView");
        assertElementNotPresentBy(WebElementsById("org.lds.ldssa.dev:id/bubbleLayout"));
        ClickUIElementByAccessibilityID("Submit");
        Thread.sleep(milliseconds_5);
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
        //Verify Exit Button
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        //Verify Page Title
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText("Send Feedback", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"),false);
        //Verify Attach Image
        assertElementExistsBy(WebElementsByAccessibilityId("Attach Image"));
        WebElement test = WebElementByAccessibilityId("Attach Image");
        //Verify Submit
        assertElementExistsBy(WebElementsByAccessibilityId("Submit"));
        //Verify Name Field
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackNameTextInputLayout"));
        verifyText("Name (Optional)", WebElementById("org.lds.ldssa.dev:id/feedbackNameTextInputLayout"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackNameTextInputEditText"));
        //Verify Email field
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackEmailTextInputLayout"));
        verifyText("Email",WebElementById("org.lds.ldssa.dev:id/feedbackEmailTextInputLayout"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackEmailTextInputEditText"));
        //Verify Category Spinner
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackCategorySpinner"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackCategorySpinnerTextView"));
        verifyText("Category",WebElementById("org.lds.ldssa.dev:id/feedbackCategorySpinnerTextView"),false);
        //Verify Description Field
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackDescriptionTextInputLayout"));
        verifyText("Description", WebElementById("org.lds.ldssa.dev:id/feedbackDescriptionTextInputLayout"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackDescriptionEditText"));
        //Verify text field counter
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/textinput_counter"));
        verifyText("0 / 1000", WebElementById("org.lds.ldssa.dev:id/textinput_counter"),false);

        //enter text into form
        sendText("org.lds.ldssa.dev:id/feedbackNameTextInputEditText", name);
        //enter invalid email into email address
        sendText("org.lds.ldssa.dev:id/feedbackEmailTextInputEditText", name);

        //verify category wheel options
        List category = new ArrayList();
        category.add("How do I…?");

        for (int x = 0; x < category.size(); x++){
            ClickUIElementByID("org.lds.ldssa.dev:id/feedbackCategorySpinner");
            assertElementExistsBy(WebElementsByCheckedText((String) category.get(x), false));
            ClickUIElementByCheckedText((String) category.get(x), false);
            assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackCategorySpinner"));
            verifyText((String) category.get(x), WebElementById("android:id/text1"),false);
            Thread.sleep(milliseconds_1);

        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String description = ("sendto:"+ sendtoemail + " This is a test support email from automation sent on " + dateFormat.format(date) + " Test: " + (new Exception().getStackTrace()[0].getMethodName()) + "");
        sendText("org.lds.ldssa.dev:id/feedbackDescriptionEditText",description);
        Thread.sleep(milliseconds_1);
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        driver.swipe(screenWidth / 2, screenHeight / 2, screenWidth / 2, screenHeight / 10 * 2, 2000);
        verifyText("" + description.length() + " / 1000", WebElementById("org.lds.ldssa.dev:id/textinput_counter"),false);
        ClickUIElementByAccessibilityID("Submit");
        Thread.sleep(milliseconds_1);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText("Send Feedback", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"),false);
        sendText("org.lds.ldssa.dev:id/feedbackEmailTextInputEditText", email);
        ClickUIElementByAccessibilityID("Submit");
        Thread.sleep(milliseconds_5);
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
        //Verify Exit Button
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        //Verify Page Title
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText("Send Feedback", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"),false);
        //Verify Attach Image
        assertElementExistsBy(WebElementsByAccessibilityId("Attach Image"));
        WebElement test = WebElementByAccessibilityId("Attach Image");
        //Verify Submit
        assertElementExistsBy(WebElementsByAccessibilityId("Submit"));
        //Verify Name Field
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackNameTextInputLayout"));
        verifyText("Name (Optional)", WebElementById("org.lds.ldssa.dev:id/feedbackNameTextInputLayout"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackNameTextInputEditText"));
        //Verify Email field
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackEmailTextInputLayout"));
        verifyText("Email",WebElementById("org.lds.ldssa.dev:id/feedbackEmailTextInputLayout"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackEmailTextInputEditText"));
        //Verify Category Spinner
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackCategorySpinner"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackCategorySpinnerTextView"));
        verifyText("Category",WebElementById("org.lds.ldssa.dev:id/feedbackCategorySpinnerTextView"),false);
        //Verify Description Field
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackDescriptionTextInputLayout"));
        verifyText("Description", WebElementById("org.lds.ldssa.dev:id/feedbackDescriptionTextInputLayout"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackDescriptionEditText"));
        //Verify text field counter
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/textinput_counter"));
        verifyText("0 / 1000", WebElementById("org.lds.ldssa.dev:id/textinput_counter"),false);

        //enter text into form
        sendText("org.lds.ldssa.dev:id/feedbackNameTextInputEditText", name);

        //verify category wheel options
        List category = new ArrayList();
        category.add("How do I…?");

        for (int x = 0; x < category.size(); x++){
            ClickUIElementByID("org.lds.ldssa.dev:id/feedbackCategorySpinner");
            assertElementExistsBy(WebElementsByCheckedText((String) category.get(x), false));
            ClickUIElementByCheckedText((String) category.get(x), false);
            assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackCategorySpinner"));
            verifyText((String) category.get(x), WebElementById("android:id/text1"),false);
            Thread.sleep(milliseconds_1);

        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String description = ("sendto:"+ sendtoemail + " This is a test support email from automation sent on " + dateFormat.format(date) + " Test: " + (new Exception().getStackTrace()[0].getMethodName()) + "");
        sendText("org.lds.ldssa.dev:id/feedbackDescriptionEditText",description);
        Thread.sleep(milliseconds_1);
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        driver.swipe(screenWidth / 2, screenHeight / 2, screenWidth / 2, screenHeight / 10 * 2, 2000);
        verifyText("" + description.length() + " / 1000", WebElementById("org.lds.ldssa.dev:id/textinput_counter"),false);
        ClickUIElementByAccessibilityID("Submit");
        Thread.sleep(milliseconds_1);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText("Send Feedback", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"),false);
        sendText("org.lds.ldssa.dev:id/feedbackEmailTextInputEditText", email);
        ClickUIElementByAccessibilityID("Submit");
        Thread.sleep(milliseconds_5);
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
        //Verify Exit Button
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        //Verify Page Title
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText("Send Feedback", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"),false);
        //Verify Attach Image
        assertElementExistsBy(WebElementsByAccessibilityId("Attach Image"));
        WebElement test = WebElementByAccessibilityId("Attach Image");
        //Verify Submit
        assertElementExistsBy(WebElementsByAccessibilityId("Submit"));
        //Verify Name Field
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackNameTextInputLayout"));
        verifyText("Name (Optional)", WebElementById("org.lds.ldssa.dev:id/feedbackNameTextInputLayout"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackNameTextInputEditText"));
        //Verify Email field
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackEmailTextInputLayout"));
        verifyText("Email",WebElementById("org.lds.ldssa.dev:id/feedbackEmailTextInputLayout"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackEmailTextInputEditText"));
        //Verify Category Spinner
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackCategorySpinner"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackCategorySpinnerTextView"));
        verifyText("Category",WebElementById("org.lds.ldssa.dev:id/feedbackCategorySpinnerTextView"),false);
        //Verify Description Field
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackDescriptionTextInputLayout"));
        verifyText("Description", WebElementById("org.lds.ldssa.dev:id/feedbackDescriptionTextInputLayout"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackDescriptionEditText"));
        //Verify text field counter
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/textinput_counter"));
        verifyText("0 / 1000", WebElementById("org.lds.ldssa.dev:id/textinput_counter"),false);

        //enter text into form
        sendText("org.lds.ldssa.dev:id/feedbackNameTextInputEditText", name);
        sendText("org.lds.ldssa.dev:id/feedbackEmailTextInputEditText", email);

        //verify category wheel options
        List category = new ArrayList();
        category.add("How do I…?");

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String description = ("sendto:"+ sendtoemail + " This is a test support email from automation sent on " + dateFormat.format(date) + " Test: " + (new Exception().getStackTrace()[0].getMethodName()) + "");
        sendText("org.lds.ldssa.dev:id/feedbackDescriptionEditText",description);
        Thread.sleep(milliseconds_1);
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        driver.swipe(screenWidth / 2, screenHeight / 2, screenWidth / 2, screenHeight / 10 * 2, 2000);
        verifyText("" + description.length() + " / 1000", WebElementById("org.lds.ldssa.dev:id/textinput_counter"),false);
        ClickUIElementByAccessibilityID("Submit");
        Thread.sleep(milliseconds_1);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText("Send Feedback", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"),false);
        for (int x = 0; x < category.size(); x++){
            ClickUIElementByID("org.lds.ldssa.dev:id/feedbackCategorySpinner");
            assertElementExistsBy(WebElementsByCheckedText((String) category.get(x), false));
            ClickUIElementByCheckedText((String) category.get(x), false);
            assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackCategorySpinner"));
            verifyText((String) category.get(x), WebElementById("android:id/text1"),false);
            Thread.sleep(milliseconds_1);

        }
        ClickUIElementByAccessibilityID("Submit");
        Thread.sleep(milliseconds_5);
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
        //Verify Exit Button
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        //Verify Page Title
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText("Send Feedback", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"),false);
        //Verify Attach Image
        assertElementExistsBy(WebElementsByAccessibilityId("Attach Image"));
        WebElement test = WebElementByAccessibilityId("Attach Image");
        //Verify Submit
        assertElementExistsBy(WebElementsByAccessibilityId("Submit"));
        //Verify Name Field
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackNameTextInputLayout"));
        verifyText("Name (Optional)", WebElementById("org.lds.ldssa.dev:id/feedbackNameTextInputLayout"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackNameTextInputEditText"));
        //Verify Email field
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackEmailTextInputLayout"));
        verifyText("Email",WebElementById("org.lds.ldssa.dev:id/feedbackEmailTextInputLayout"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackEmailTextInputEditText"));
        //Verify Category Spinner
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackCategorySpinner"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackCategorySpinnerTextView"));
        verifyText("Category",WebElementById("org.lds.ldssa.dev:id/feedbackCategorySpinnerTextView"),false);
        //Verify Description Field
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackDescriptionTextInputLayout"));
        verifyText("Description", WebElementById("org.lds.ldssa.dev:id/feedbackDescriptionTextInputLayout"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackDescriptionEditText"));
        //Verify text field counter
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/textinput_counter"));
        verifyText("0 / 1000", WebElementById("org.lds.ldssa.dev:id/textinput_counter"),false);

        //enter text into form
        sendText("org.lds.ldssa.dev:id/feedbackNameTextInputEditText", name);
        sendText("org.lds.ldssa.dev:id/feedbackEmailTextInputEditText", email);

        //verify category wheel options
        List category = new ArrayList();
        category.add("How do I…?");
        for (int x = 0; x < category.size(); x++){
            ClickUIElementByID("org.lds.ldssa.dev:id/feedbackCategorySpinner");
            assertElementExistsBy(WebElementsByCheckedText((String) category.get(x), false));
            ClickUIElementByCheckedText((String) category.get(x), false);
            assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackCategorySpinner"));
            verifyText((String) category.get(x), WebElementById("android:id/text1"),false);
            Thread.sleep(milliseconds_1);

        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Thread.sleep(milliseconds_1);
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        verifyText("0 / 1000", WebElementById("org.lds.ldssa.dev:id/textinput_counter"),false);
        ClickUIElementByAccessibilityID("Submit");
        Thread.sleep(milliseconds_1);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText("Send Feedback", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"),false);
        String description = ("sendto:"+ sendtoemail + " This is a test support email from automation sent on " + dateFormat.format(date) + " Test: " + (new Exception().getStackTrace()[0].getMethodName()) + "");
        sendText("org.lds.ldssa.dev:id/feedbackDescriptionEditText",description);
        driver.swipe(screenWidth / 2, screenHeight / 2, screenWidth / 2, screenHeight / 10 * 2, 2000);
        verifyText("" + description.length() + " / 1000", WebElementById("org.lds.ldssa.dev:id/textinput_counter"),false);
        ClickUIElementByAccessibilityID("Submit");
        Thread.sleep(milliseconds_5);
        assertElementExistsBy(WebElementsByText("Settings", false));


    }

    @Test
    public void SendFeedbackScreenAutofillFields() throws Exception {
        SendFeedbackScreenSendFeedbackWithphoto();
        scrollDownTo("Send Feedback");
        //Verify Send Feedback Option
        assertElementExistsBy(WebElementsByText("Send Feedback", false));
        ClickUIElementByText("Send Feedback", false);
        verifyText(name, WebElementById("org.lds.ldssa.dev:id/feedbackNameTextInputEditText"),false);
        verifyText(email, WebElementById("org.lds.ldssa.dev:id/feedbackEmailTextInputEditText"),false);
        verifyText("Category", WebElementById("org.lds.ldssa.dev:id/feedbackCategorySpinnerTextView"),false);
        verifyText("",WebElementById("org.lds.ldssa.dev:id/feedbackDescriptionEditText"),false);
        verifyText("0 / 1000", WebElementById("org.lds.ldssa.dev:id/textinput_counter"),false);
        //verify category wheel options
        List category = new ArrayList();
        category.add("Feature request");

        for (int x = 0; x < category.size(); x++){
            ClickUIElementByID("org.lds.ldssa.dev:id/feedbackCategorySpinner");
            assertElementExistsBy(WebElementsByCheckedText((String) category.get(x), false));
            ClickUIElementByCheckedText((String) category.get(x), false);
            assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/feedbackCategorySpinner"));
            verifyText((String) category.get(x), WebElementById("android:id/text1"),false);
            Thread.sleep(milliseconds_1);

        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String description = ("sendto:"+ sendtoemail + " This is a test support email from automation sent on " + dateFormat.format(date) + " test: " + (new Exception().getStackTrace()[0].getMethodName()) + "");
        sendText("org.lds.ldssa.dev:id/feedbackDescriptionEditText",description);
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        driver.swipe(screenWidth / 2, screenHeight / 2, screenWidth / 2, screenHeight / 10 * 2, 2000);
        verifyText("" + description.length() + " / 1000", WebElementById("org.lds.ldssa.dev:id/textinput_counter"),false);
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
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText("About",WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"),false);
        assertElementExistsBy(WebElementsByText("Rights and Use Information", false));
        assertElementExistsBy(WebElementsByText("Privacy Policy", false));
        assertElementExistsBy(WebElementsByText("Acknowledgements", false));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/aboutLogo"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/aboutCopyright"));

        //Verify Rights and Use Date
        ClickUIElementByText("Rights and Use Information", false);
        verifyText("https://www.lds.org/legal/terms?lang=eng", WebElementById("com.android.chrome:id/url_bar"),false);
        String RightsAndUse = WebElementByXpath("//android.view.View[contains(@text, 'Updated')]").getText();
        System.out.println(RightsAndUse);
        RightsAndUse = RightsAndUse.replace("Rights and Use Information (Updated ","");
        RightsAndUse = RightsAndUse.replace(")","");
        int year = Integer.parseInt(RightsAndUse.substring(0,4));
        int day = Integer.parseInt(RightsAndUse.substring(8,10));
        int month = Integer.parseInt(RightsAndUse.substring(5,7));
        if (day < 10){
            day = Integer.parseInt(String.valueOf(RightsAndUse.charAt(9)));
        }
        if (month < 10){
            month = Integer.parseInt(String.valueOf(RightsAndUse.charAt(6)));
        }
        driver.navigate().back();
        RightsAndUse = "Updated " + month + "/"+ day + "/" + year + "";
        System.out.println(RightsAndUse);
        verifyText(RightsAndUse,WebElementByXpath("//android.widget.TextView[@text='Rights and Use Information']/../android.widget.TextView[contains(@text, 'Updated')]"),false);

        //Verify Privacy Policy Date
        ClickUIElementByText("Privacy Policy", false);
        verifyText("https://www.lds.org/legal/privacy?lang=eng", WebElementById("com.android.chrome:id/url_bar"),false);
        String PrivacyPolicy = WebElementByXpath("//android.view.View[contains(@text, 'Updated')]").getText();
        System.out.println(PrivacyPolicy);
        PrivacyPolicy = PrivacyPolicy.replace("Privacy Policy (Updated ","");
        PrivacyPolicy = PrivacyPolicy.replace(")","");
        System.out.println(PrivacyPolicy);
        year = Integer.parseInt(PrivacyPolicy.substring(0,4));
        day = Integer.parseInt(PrivacyPolicy.substring(8,10));
        month = Integer.parseInt(PrivacyPolicy.substring(5,7));
        if (day < 10){
            day = Integer.parseInt(String.valueOf(PrivacyPolicy.charAt(9)));
        }
        if (month < 10){
            month = Integer.parseInt(String.valueOf(PrivacyPolicy.charAt(6)));
        }
        driver.navigate().back();
        PrivacyPolicy = "Updated " + month + "/"+ day + "/" + year + "";
        System.out.println(PrivacyPolicy);
        verifyText(PrivacyPolicy,WebElementByXpath("//android.widget.TextView[@text='Privacy Policy']/../android.widget.TextView[contains(@text, 'Updated')]"),false);

        //verify Acknowledgements
        ClickUIElementByText("Acknowledgements", false);
        assertElementExistsBy(WebElementsByText("Acknowledgements", false));
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/aboutLibrariesRecyclerView"));
        ClickUIElementByAccessibilityID("Navigate up");
        verifyText("About",WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"),false);


        //verify year in copyright
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        Date date = new Date();
        String Copyright = "© " + dateFormat.format(date) + " by Intellectual Reserve, Inc. All rights reserved.";
        verifyText(Copyright,WebElementById("org.lds.ldssa.dev:id/aboutCopyright"),false);

        driver.navigate().back();
        assertElementExistsBy(WebElementsByText("Settings", false));



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
//        ClickUIElementByText("Scriptures");
//        ClickUIElementByText("Book of Mormon");
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
    public void AnnotationMenuTapMark() throws Exception{
        skipLogin();
        OpenScripture("Book of Mormon","Jacob","5","1");
        OpenAnnotationMenu("p1","Mark");
        AnnotationsSyncCheck("No Thanks");
        assertElementInWebviewExistsBy("//div[contains(@class, 'hl-yellow-box')]");

    }

    @Test
    public void AnnotationMenuTapMarkAndStyle() throws Exception{
        skipLogin();
        OpenScripture("Book of Mormon","Jacob","5","");
        OpenAnnotationMenu("p1","Mark");
        AnnotationsSyncCheck("No Thanks");
        assertElementInWebviewExistsBy("//div[contains(@class, 'hl-yellow-box')]");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size())+"]");
        OpenAnnotationMenuFromAnnotation(WebElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size())+"]"),"Style");
        assertHighlightStyleScreen();
        assertHighlightStyleScreenStyleAndColor("solid","yellow");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleClear() throws Exception{
        TestCheckAnnotationStyleAndColor("clear","");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleRedUnderline() throws Exception{
        TestCheckAnnotationStyleAndColor("underline","red");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleOrangeUnderline() throws Exception{
        TestCheckAnnotationStyleAndColor("underline","orange");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleYellowUnderline() throws Exception{
        TestCheckAnnotationStyleAndColor("underline","yellow");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleGreenUnderlined() throws Exception{
        TestCheckAnnotationStyleAndColor("underline","green");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleBlueUnderline() throws Exception{
        TestCheckAnnotationStyleAndColor("underline","blue");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleDarkBlueUnderline() throws Exception{
        TestCheckAnnotationStyleAndColor("underline","dark_blue");
    }

    @Test
    public void AnnotationMenuTapMarkAndStylePurpleUnderline() throws Exception{
        TestCheckAnnotationStyleAndColor("underline","purple");
    }

    @Test
    public void AnnotationMenuTapMarkAndStylePinkUnderline() throws Exception{
        TestCheckAnnotationStyleAndColor("underline","pink");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleBrownUnderline() throws Exception{
        TestCheckAnnotationStyleAndColor("underline","brown");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleGrayUnderline() throws Exception{
        TestCheckAnnotationStyleAndColor("underline","gray");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleRedSolid() throws Exception{
        TestCheckAnnotationStyleAndColor("solid","red");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleOrangeSolid() throws Exception{
        TestCheckAnnotationStyleAndColor("solid","orange");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleYellowSolid() throws Exception{
        TestCheckAnnotationStyleAndColor("solid","yellow");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleGreenSolid() throws Exception{
        TestCheckAnnotationStyleAndColor("solid","green");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleBlueSolid() throws Exception{
        TestCheckAnnotationStyleAndColor("solid","blue");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleDarkBlueSolid() throws Exception{
        TestCheckAnnotationStyleAndColor("solid","dark_blue");
    }

    @Test
    public void AnnotationMenuTapMarkAndStylePurpleSolid() throws Exception{
        TestCheckAnnotationStyleAndColor("solid","purple");
    }

    @Test
    public void AnnotationMenuTapMarkAndStylePinkSolid() throws Exception{
        TestCheckAnnotationStyleAndColor("solid","pink");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleBrownSolid() throws Exception{
        TestCheckAnnotationStyleAndColor("solid","brown");
    }

    @Test
    public void AnnotationMenuTapMarkAndStyleGraySolid() throws Exception{
        TestCheckAnnotationStyleAndColor("solid","gray");
    }

    @Test
    public void AnnotationMenuTapNote() throws Exception{
        skipLogin();
        OpenScripture("Book of Mormon","Jacob","5","1");
        OpenAnnotationMenu("p1","Note");
        assertNoteScreen(true);
    }

    @Test
    public void AnnotationMenuCreateNoteAnnotationIndicatorIcon() throws Exception{
        AnnotationMenuCreateNote();
        ClickUIElementByAccessibilityID("Navigate up");
        assertElementInWebviewExistsBy("//div[contains(@class,'stickyNote')]");
        assertEquals("url(\"file:///android_asset/images/annotation_note.png\")",getComputedCssUsingXpath("//div[contains(@class,'stickyNote')]","background-image"));

    }

    @Test
    public void AnnotationMenuCreateNote() throws Exception{
        skipLogin();
        OpenScripture("Book of Mormon","Jacob","5","1");
        OpenAnnotationMenu("p1","Note");
        assertNoteScreen(true);
        sendText("org.lds.ldssa.dev:id/noteTitleEditText","Spiritual Thought Title");
        sendText("org.lds.ldssa.dev:id/markdownEditText","Spiritual thought expounded on");
        verifyText("Spiritual Thought Title",WebElementByResourceId("org.lds.ldssa.dev:id/noteTitleEditText"),false);
        verifyText("Spiritual thought expounded on", WebElementByResourceId("org.lds.ldssa.dev:id/markdownEditText"),false);
        ClickUIElementByAccessibilityID("Navigate up");
        AnnotationsSyncCheck("No Thanks");
        assertElementInWebviewExistsBy("//div[contains(@class, 'hl-yellow-box')]");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size()-1)+"]");
        OpenAnnotationMenuFromAnnotation(WebElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size()-1)+"]"),"Note");
        verifyText("Spiritual Thought Title",WebElementByResourceId("org.lds.ldssa.dev:id/noteTitleEditText"),false);
        verifyText("Spiritual thought expounded on", WebElementByResourceId("org.lds.ldssa.dev:id/markdownEditText"),false);
    }

    @Test
    public void AnnotationMenuCreateNoteWithLink() throws Exception{
        skipLogin();
        OpenScripture("Book of Mormon","Jacob","5","1");
        OpenAnnotationMenu("p1","Note");
        assertNoteScreen(true);
        sendText("org.lds.ldssa.dev:id/noteTitleEditText","Spiritual Thought Title");
        sendText("org.lds.ldssa.dev:id/markdownEditText","Spiritual thought expounded on");
        verifyText("Spiritual Thought Title",WebElementByResourceId("org.lds.ldssa.dev:id/noteTitleEditText"),false);
        verifyText("Spiritual thought expounded on", WebElementByResourceId("org.lds.ldssa.dev:id/markdownEditText"),false);
        ClickUIElementByAccessibilityID("Link");
        assertLinksScreen();
        sendText("org.lds.ldssa.dev:id/searchEditText","Jarom");
        ClickUIElementByXpath("(//*[@text=\"Jarom\"]/../../android.widget.ImageView[2])[1]");
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/bubbleTextView"));
        verifyText("Jarom",WebElementByResourceId("org.lds.ldssa.dev:id/bubbleTextView"),false);
        ClickUIElementByAccessibilityID("Navigate up");
        ClickUIElementByAccessibilityID("Navigate up");
        AnnotationsSyncCheck("No Thanks");
        assertElementInWebviewExistsBy("//div[contains(@class, 'hl-yellow-box')]");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size()-1)+"]");
        OpenAnnotationMenuFromAnnotation(WebElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size()-1)+"]"),"Note");
        verifyText("Spiritual Thought Title",WebElementByResourceId("org.lds.ldssa.dev:id/noteTitleEditText"),false);
        verifyText("Spiritual thought expounded on", WebElementByResourceId("org.lds.ldssa.dev:id/markdownEditText"),false);
        ClickUIElementByAccessibilityID("Link");
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/bubbleTextView"));
        verifyText("Jarom",WebElementByResourceId("org.lds.ldssa.dev:id/bubbleTextView"),false);
    }

    @Test
    public void AnnotationMenuTapTag() throws Exception{
        skipLogin();
        OpenScripture("Book of Mormon","Jacob","5","1");
        OpenAnnotationMenu("p1","Tag");
        assertTagScreen(true);
    }

    @Test
    public void AnnotationMenuCreateTag() throws Exception{
        skipLogin();
        OpenScripture("Book of Mormon","Jacob","5","1");
        OpenAnnotationMenu("p1","Tag");
        assertTagScreen(true);
        sendText("org.lds.ldssa.dev:id/tagNameEditText","Test Tag");
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/linearLayout3"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/listItemImageView"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/listItemTextView"));
        verifyText("Create “Test Tag”",WebElementByResourceId("org.lds.ldssa.dev:id/listItemTextView"),false);
        ClickUIElementByResourceID("org.lds.ldssa.dev:id/listItemImageView");
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/bubbleTextView"));
        verifyText("Test Tag",WebElementByResourceId("org.lds.ldssa.dev:id/bubbleTextView"),false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/bubbleDeleteImageView"));
        ClickUIElementByAccessibilityID("Navigate up");
        AnnotationsSyncCheck("No Thanks");
        assertElementInWebviewExistsBy("//div[contains(@class, 'hl-yellow-box')]");
        assertElementInWebviewExistsBy("//div[contains(@class,'stickyTag')]");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size()-1)+"]");
        OpenAnnotationMenuFromAnnotation(WebElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size()-1)+"]"),"Tag");
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/bubbleTextView"));
        verifyText("Test Tag",WebElementByResourceId("org.lds.ldssa.dev:id/bubbleTextView"),false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/bubbleDeleteImageView"));
    }

    @Test
    public void AnnotationMenuCreateTagAnnotationIndicatorIcon() throws Exception{
        AnnotationMenuCreateTag();
        ClickUIElementByAccessibilityID("Navigate up");
        assertElementInWebviewExistsBy("//div[contains(@class,'stickyTag')]");
        assertEquals("url(\"file:///android_asset/images/annotation_tag.png\")",getComputedCssUsingXpath("//div[contains(@class,'stickyTag')]","background-image"));

    }

    @Test
    public void AnnotationMenuOpenTagInSidebarGoToTag() throws Exception{
        AnnotationMenuCreateTag();
        ClickUIElementByAccessibilityID("Navigate up");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size()-1)+"]");
        ClickUIElementInWebviewByXPath("//div[contains(@class,'stickyTag')]");

        //assert sidebar
        assertSideBar("Tag",true,"Tag","Test Tag");
        //click tag
        ClickUIElementByText("Test Tag",false);
        //assert menu bar
        assertMenuBar("Test Tag","Tags");

        //assert tag
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/lastModifiedTextView"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/annotationMenuImageButton"));
        //assert tag content
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/highlightLayout"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/bubbleLayout"));
        verifyText("Test Tag",WebElementByResourceId("org.lds.ldssa.dev:id/bubbleTextView"),false);
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/tag_text"));
    }

    @Test
    public void AnnotationMenuTapAddTo() throws Exception{
        skipLogin();
        OpenScripture("Book of Mormon","Jacob","5","1");
        OpenAnnotationMenu("p1","Add to");
        assertAddToNotebookScreen(true);
    }

    @Test
    public void AnnotationMenuAddToNotebook() throws Exception{
        skipLogin();
        OpenScripture("Book of Mormon","Jacob","5","1");
        OpenAnnotationMenu("p1","Add to");
        assertAddToNotebookScreen(true);
        ClickUIElementByResourceID("org.lds.ldssa.dev:id/notebookSelectionFloatingActionButton");
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/md_title"));
        verifyText("Create Notebook",WebElementByResourceId("org.lds.ldssa.dev:id/md_title"),false);
        assertElementExistsBy(WebElementsById("android:id/input"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/md_minMax"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/md_buttonDefaultNegative"));
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/md_buttonDefaultPositive"));
        assert !Boolean.parseBoolean(WebElementByResourceId("org.lds.ldssa.dev:id/md_buttonDefaultPositive").getAttribute("enabled"));
        sendText("android:id/input","Test Notebook");
        assert Boolean.parseBoolean(WebElementByResourceId("org.lds.ldssa.dev:id/md_buttonDefaultPositive").getAttribute("enabled"));
        ClickUIElementByResourceID("org.lds.ldssa.dev:id/md_buttonDefaultPositive");
        ClickUIElementByResourceID("org.lds.ldssa.dev:id/notebookCheckBox");
        ClickUIElementByAccessibilityID("Navigate up");
        AnnotationsSyncCheck("No Thanks");
        assertElementInWebviewExistsBy("//div[contains(@class, 'hl-yellow-box')]");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size()-1)+"]");
        OpenAnnotationMenuFromAnnotation(WebElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size()-1)+"]"),"Add to");
        assert Boolean.parseBoolean(WebElementByResourceId("org.lds.ldssa.dev:id/notebookCheckBox").getAttribute("checked"));

    }

    @Test
    public void AnnotationMenuCreateAddToAnnotationIndicatorIcon() throws Exception{
        AnnotationMenuAddToNotebook();
        ClickUIElementByAccessibilityID("Navigate up");
        assertElementInWebviewExistsBy("//div[contains(@class,'stickyNotebook')]");
        assertEquals("url(\"file:///android_asset/images/annotation_notebook.png\")",getComputedCssUsingXpath("//div[contains(@class,'stickyNotebook')]","background-image"));

    }

    @Test
    public void AnnotationMenuTapLink() throws Exception{
        skipLogin();
        OpenScripture("Book of Mormon","Jacob","5","1");
        OpenAnnotationMenu("p1","Link");
    }

    @Test
    public void AnnotationMenuCreateLinkToSingleChapterBook() throws Exception{
        skipLogin();
        OpenScripture("Book of Mormon","Jacob","5","1");
        OpenAnnotationMenu("p1","Link");
        sendText("org.lds.ldssa.dev:id/searchEditText","Jarom");
        ClickUIElementByXpath("(//*[@text=\"Jarom\"]/../../android.widget.ImageView[2])[1]");
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/bubbleTextView"));
        verifyText("Jarom",WebElementByResourceId("org.lds.ldssa.dev:id/bubbleTextView"),false);
        ClickUIElementByAccessibilityID("Navigate up");
        AnnotationsSyncCheck("No Thanks");
        assertElementInWebviewExistsBy("//div[contains(@class, 'hl-yellow-box')]");
        List templist = WebElementsByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)");
        ClickUIElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size()-1)+"]");
        OpenAnnotationMenuFromAnnotation(WebElementByXpath("(//*[@resource-id=\"p1\"]/../android.view.View/android.view.View)[" + (templist.size()-1)+"]"),"Link");
        assertElementExistsBy(WebElementsByResourceId("org.lds.ldssa.dev:id/bubbleTextView"));
        verifyText("Jarom",WebElementByResourceId("org.lds.ldssa.dev:id/bubbleTextView"),false);
    }

    @Test
    public void AnnotationMenuCreateLinkAnnotationIndicatorIcon() throws Exception{
        AnnotationMenuCreateLinkToSingleChapterBook();
        ClickUIElementByAccessibilityID("Navigate up");
        assertElementInWebviewExistsBy("//div[contains(@class,'stickyLink')]");
        assertEquals("url(\"file:///android_asset/images/annotation_link.png\")",getComputedCssUsingXpath("//div[contains(@class,'stickyLink')]","background-image"));

    }

    @Test
    public void AnnotationMenuTapCopy() throws Exception{
        skipLogin();
        OpenScripture("Book of Mormon","Jacob","5","1");
        OpenAnnotationMenu("p1","Copy");
    }

    @Test
    public void AnnotationMenuTapShare() throws Exception{
        skipLogin();
        OpenScripture("Book of Mormon","Jacob","5","1");
        OpenAnnotationMenu("p1","Share");
    }

    @Test
    public void AnnotationMenuTapSearch() throws Exception{
        skipLogin();
        OpenScripture("Book of Mormon","Jacob","5","1");
        OpenAnnotationMenu("p1","Search");
    }

    @Test
    public void AnnotationMenuTapDefine() throws Exception{
        skipLogin();
        OpenScripture("Book of Mormon","Jacob","5","1");
        OpenAnnotationMenu("p1","Define");
    }

    @Test
    public void AnnotationMenuTapRemove() throws Exception{
        skipLogin();
        OpenScripture("Book of Mormon","Jacob","5","1");
        OpenAnnotationMenu("p1","Remove");
    }

    //********** General Conference Section **********

    @Test
    public void generalConferenceVerifyAll() throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByText("General Conference", false));
        ClickUIElementByText("General Conference",false);
        int cYear = parseInt(getLatestConferenceYear());
        String cMonth = getLatestConferenceMonth();
        if (cMonth == "April"){
            scrollDownTo( "April " + cYear);
            assertElementExistsBy(WebElementsByText("April " + cYear, false));
            ClickUIElementByXpath("//*[@text=\"April "+cYear+"\"]/../../android.widget.ImageView[2]");
            assertElementExistsBy(WebElementsByText("Download", false));
            assertElementExistsBy(WebElementsByText("Add to…", false));
            ClickUIElementByText("Download", false);
            cYear = cYear - 1;
        }
        while (cYear >= 1971){
            scrollDownTo( "October " + cYear);
            assertElementExistsBy(WebElementsByText("October " + cYear, false));
            assertElementExistsBy(WebElementsByXpath("//*[@text=\"October "+cYear+"\"]/../../android.widget.ImageView[2]"));
            ClickUIElementByXpath("//*[@text=\"October "+cYear+"\"]/../../android.widget.ImageView[2]");
            assertElementExistsBy(WebElementsByText("Download", false));
            assertElementExistsBy(WebElementsByText("Add to…", false));
            ClickUIElementByText("Download", false);
            scrollDownTo( "April " + cYear);
            assertElementExistsBy(WebElementsByText("April " + cYear, false));
            assertElementExistsBy(WebElementsByXpath("//*[@text=\"April "+cYear+"\"]/../../android.widget.ImageView[2]"));
            ClickUIElementByXpath("//*[@text=\"April "+cYear+"\"]/../../android.widget.ImageView[2]");
            assertElementExistsBy(WebElementsByText("Download", false));
            assertElementExistsBy(WebElementsByText("Add to…", false));
            ClickUIElementByText("Download", false);
            cYear = cYear - 1;
        }

    }

    @Test
    public void generalConferenceDownloadAllFromMoreOptionsMenu() throws Exception{
        // Just checks 1 download to save time
        skipLogin();
        assertElementExistsBy(WebElementsByText("General Conference", false));
        ClickUIElementByText("General Conference", false);
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Download All", false));
        ClickUIElementByText("Download All", false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_title"));
        verifyText("Download All",WebElementById("org.lds.ldssa.dev:id/md_title"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_content"));
        // Can't be sure of number of item to download verifyText("94 items will be downloaded. Download selected items?",WebElementById("org.lds.ldssa.dev:id/md_content"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"));
        verifyText("CANCEL",WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"));
        verifyText("DOWNLOAD ALL",WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"),false);
        ClickUIElementByID("org.lds.ldssa.dev:id/md_buttonDefaultPositive");
        Thread.sleep(milliseconds_5);
        Thread.sleep(milliseconds_5);
        String latestConference = getLatestConference();
        int cYear = parseInt(getLatestConferenceYear());
        scrollDownTo(latestConference);
        assertElementExistsBy(WebElementsByText(latestConference, false));
        ClickUIElementByXpath("//*[@text=\""+latestConference+"\"]/../../android.widget.ImageView[2]");
        assertElementExistsBy(WebElementsByText("Remove", false));
        assertElementExistsBy(WebElementsByText("Add to…", false));
        dismissDialog(WebElementByXpath("/hierarchy/android.widget.FrameLayout"));

    }


    @Test
    public void generalConferenceRemoveAllFromMoreOptionsMenu() throws Exception{
        // Just checks 1 download to save time
        skipLogin();
        assertElementExistsBy(WebElementsByText("General Conference", false));
        ClickUIElementByText("General Conference", false);
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Download All", false));
        ClickUIElementByText("Download All", false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_title"));
        verifyText("Download All",WebElementById("org.lds.ldssa.dev:id/md_title"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_content"));
        // Can't be sure of number of item to download verifyText("94 items will be downloaded. Download selected items?",WebElementById("org.lds.ldssa.dev:id/md_content"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"));
        verifyText("CANCEL",WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"));
        verifyText("DOWNLOAD ALL",WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"),false);
        ClickUIElementByID("org.lds.ldssa.dev:id/md_buttonDefaultPositive");
        Thread.sleep(milliseconds_5);
        Thread.sleep(milliseconds_5);
        Thread.sleep(milliseconds_5);
        Thread.sleep(milliseconds_5);
        String latestConference = getLatestConference();
        int cYear = parseInt(getLatestConferenceYear());
        scrollDownTo( latestConference);
        assertElementExistsBy(WebElementsByText(latestConference, false));
        ClickUIElementByXpath("//*[@text=\""+latestConference+"\"]/../../android.widget.ImageView[2]");
        assertElementExistsBy(WebElementsByText("Remove", false));
        assertElementExistsBy(WebElementsByText("Add to…", false));
        dismissDialog(WebElementByXpath("/hierarchy/android.widget.FrameLayout"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        ClickUIElementByAccessibilityID("More options");
        assertElementExistsBy(WebElementsByText("Remove All", false));
        ClickUIElementByText("Remove All", false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_title"));
        verifyText("Remove All",WebElementById("org.lds.ldssa.dev:id/md_title"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_content"));
        verifyText("Are you sure you want to remove the selected items?",WebElementById("org.lds.ldssa.dev:id/md_content"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"));
        verifyText("CANCEL",WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"));
        verifyText("REMOVE ALL",WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"),false);
        ClickUIElementByID("org.lds.ldssa.dev:id/md_buttonDefaultPositive");
        Thread.sleep(milliseconds_5);
        Thread.sleep(milliseconds_5);
        Thread.sleep(milliseconds_5);
        scrollDownTo( latestConference);
        assertElementExistsBy(WebElementsByText(latestConference, false));
        ClickUIElementByXpath("//*[@text=\""+latestConference+"\"]/../../android.widget.ImageView[2]");
        assertElementExistsBy(WebElementsByText("Download", false));
        assertElementExistsBy(WebElementsByText("Add to…", false));


    }


    @Test
    public void generalConferenceDownloadAllFromLibraryContextMenu() throws Exception{
        // Just checks 1 download to save time
        skipLogin();
        assertElementExistsBy(WebElementsByText("General Conference", false));
        assertElementExistsBy(WebElementsByXpath("//*[@text='General Conference']/../../android.widget.ImageView[2]"));
        ClickUIElementByXpath("//*[@text='General Conference']/../../android.widget.ImageView[2]");
        assertElementExistsBy(WebElementsByText("Download All", false));
        assertElementExistsBy(WebElementsByText("Remove All", false));
        ClickUIElementByText("Download All", false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_title"));
        verifyText("Download All",WebElementById("org.lds.ldssa.dev:id/md_title"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_content"));
        // Can't be sure of number of item to download verifyText("94 items will be downloaded. Download selected items?",WebElementById("org.lds.ldssa.dev:id/md_content"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"));
        verifyText("CANCEL",WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"));
        verifyText("DOWNLOAD ALL",WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"),false);
        ClickUIElementByID("org.lds.ldssa.dev:id/md_buttonDefaultPositive");
        ClickUIElementByText("General Conference", false);
        Thread.sleep(milliseconds_5);
        Thread.sleep(milliseconds_5);
        Thread.sleep(milliseconds_5);
        String latestConference = getLatestConference();
        int cYear = parseInt(getLatestConferenceYear());
        scrollDownTo( latestConference);
        assertElementExistsBy(WebElementsByText(latestConference, false));
        ClickUIElementByXpath("//*[@text=\""+latestConference+"\"]/../../android.widget.ImageView[2]");
        assertElementExistsBy(WebElementsByText("Remove", false));
        assertElementExistsBy(WebElementsByText("Add to…", false));
        dismissDialog(WebElementByXpath("/hierarchy/android.widget.FrameLayout"));

    }


    @Test
    public void generalConferenceRemoveAllFromLibraryContextMenu() throws Exception{
        //Just checks 1 removal to save time
        skipLogin();
        assertElementExistsBy(WebElementsByText("General Conference", false));
        assertElementExistsBy(WebElementsByXpath("//*[@text='General Conference']/../../android.widget.ImageView[2]"));
        ClickUIElementByXpath("//*[@text='General Conference']/../../android.widget.ImageView[2]");
        assertElementExistsBy(WebElementsByText("Download All", false));
        assertElementExistsBy(WebElementsByText("Remove All", false));
        ClickUIElementByText("Download All", false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_title"));
        verifyText("Download All",WebElementById("org.lds.ldssa.dev:id/md_title"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_content"));
        // Can't be sure of number of item to download verifyText("94 items will be downloaded. Download selected items?",WebElementById("org.lds.ldssa.dev:id/md_content"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"));
        verifyText("CANCEL",WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"));
        verifyText("DOWNLOAD ALL",WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"),false);
        ClickUIElementByID("org.lds.ldssa.dev:id/md_buttonDefaultPositive");
        ClickUIElementByText("General Conference", false);
        Thread.sleep(milliseconds_5);
        Thread.sleep(milliseconds_5);
        Thread.sleep(milliseconds_5);
        String latestConference = getLatestConference();
        int cYear = parseInt(getLatestConferenceYear());
        scrollDownTo( latestConference);
        assertElementExistsBy(WebElementsByText(latestConference, false));
        ClickUIElementByXpath("//*[@text=\""+latestConference+"\"]/../../android.widget.ImageView[2]");
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
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_title"));
        verifyText("Remove All",WebElementById("org.lds.ldssa.dev:id/md_title"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_content"));
        verifyText("Are you sure you want to remove the selected items?",WebElementById("org.lds.ldssa.dev:id/md_content"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"));
        verifyText("CANCEL",WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"));
        verifyText("REMOVE ALL",WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"),false);
        ClickUIElementByID("org.lds.ldssa.dev:id/md_buttonDefaultPositive");
        assertElementExistsBy(WebElementsByText("General Conference", false));
        ClickUIElementByText("General Conference", false);
        Thread.sleep(milliseconds_5);
        Thread.sleep(milliseconds_5);
        Thread.sleep(milliseconds_5);
        scrollDownTo( latestConference);
        assertElementExistsBy(WebElementsByText(latestConference, false));
        ClickUIElementByXpath("//*[@text=\""+latestConference+"\"]/../../android.widget.ImageView[2]");
        assertElementExistsBy(WebElementsByText("Download", false));
        assertElementExistsBy(WebElementsByText("Add to…", false));





    }

    @Test
    public void generalConferenceDownloadLatestConferenceViaContextMenu() throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByText("General Conference", false));
        ClickUIElementByText("General Conference", false);
        String latestConference = getLatestConference();
        ClickUIElementByXpath("//*[@text=\""+latestConference+"\"]/../../android.widget.ImageView[2]");
        assertElementExistsBy(WebElementsByText("Download", false));
        assertElementExistsBy(WebElementsByText("Add to…", false));
        ClickUIElementByText("Download", false);
        Thread.sleep(milliseconds_5);
        ClickUIElementByXpath("//*[@text=\""+latestConference+"\"]/../../android.widget.ImageView[2]");
        assertElementExistsBy(WebElementsByText("Remove", false));
        assertElementExistsBy(WebElementsByText("Add to…", false));
        ClickUIElementByText("Remove", false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_title"));
        verifyText("Remove",WebElementById("org.lds.ldssa.dev:id/md_title"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_content"));
        verifyText("Are you sure you want to remove the selected items?",WebElementById("org.lds.ldssa.dev:id/md_content"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"));
        verifyText("CANCEL",WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"));
        verifyText("REMOVE",WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"),false);
        ClickUIElementByText("REMOVE", false);
        Thread.sleep(milliseconds_1);
        ClickUIElementByXpath("//*[@text=\""+latestConference+"\"]/../../android.widget.ImageView[2]");
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
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTextLayout"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText("General Women’s Session",WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarSubTitleTextView"));
        verifyText("October 2017",WebElementById("org.lds.ldssa.dev:id/mainToolbarSubTitleTextView"),false);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/dropArrowImageView"));
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmark"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        //Play Button
        assertElementExistsBy(WebElementsByXpath("//*[@text = \"General Women’s Session\"]/android.view.View/android.view.View/android.view.View/android.widget.Image[1]"));
        //Download Button
        assertElementExistsBy(WebElementsByXpath("//*[@text = \"General Women’s Session\"]/android.view.View/android.view.View/android.view.View/android.widget.Image[2]"));
        //Audio FAB
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mediaFab"));
        ClickUIElementByID("org.lds.ldssa.dev:id/mediaFab");
        assertAudioPlayerUI("General Women’s Session","October 2017","00:00","1:25:25",true,false);
        ClickSeekBarAt(WebElementById("org.lds.ldssa.dev:id/seekBar"),7);
        Thread.sleep(milliseconds_1);
        verifyText("1:25:25",WebElementById("org.lds.ldssa.dev:id/currentPositionTextView"),false);
        WebElementById("org.lds.ldssa.dev:id/playPauseButton").click();
        Thread.sleep(500);
        WebElementById("org.lds.ldssa.dev:id/playPauseButton").click();
        assertAudioPlayerUI("Saturday Morning Session","October 2017",WebElementById("org.lds.ldssa.dev:id/currentPositionTextView").getText(),"2:01:59",false,false);




    }



    //********** Search Section **********

    @Test
    public void ElementsOnSearchScreen() throws Exception {
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        ClickUIElementByAccessibilityID("Search");
        // Back button on search screen
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/backImageView"));
        // Search box
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/searchEditText"));
        // Placeholder text
        verifyText("Search All Content", WebElementById("org.lds.ldssa.dev:id/searchEditText"),false);
    }

}



