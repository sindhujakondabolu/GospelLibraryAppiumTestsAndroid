
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumDriver;
import javafx.util.Pair;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.getInteger;
import static java.lang.Integer.valueOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class GospelLibrary {
    AppiumDriver driver;

    @Before
    public void setUp() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("app", "/Users/dexterdrysdale/Documents/GitHub/GospelLibraryAppiumTestsAndroid/APK/gospel-library-alpha-43005.apk");
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

    public int milliseconds_1 = 1100;
    public int milliseconds_2 = milliseconds_1 * 2;
    public int milliseconds_3 = milliseconds_1 * 3;
    public int milliseconds_4 = milliseconds_1 * 4;
    public int milliseconds_5 = milliseconds_1 * 5;



    //*************************************************************** UI STRINGS ***************************************************************
    //New Notebook 1
    String NotebookName1 = "Test Notebook 1";



    //Scripture Lists

    public ArrayList <Pair<String, Integer> > BooksInOldTestiment = new ArrayList<>();
    public ArrayList <Pair<String, Integer> > BooksInNewTestiment = new ArrayList<>();
    public ArrayList <Pair<String, Integer> > BooksInBom = new ArrayList<>();
    public ArrayList <Pair<String, Integer> > BooksInDAndC = new ArrayList<>();
    public ArrayList <Pair<String, Integer> > BooksInPearlOfGreatPrice = new ArrayList<>();

    public void setBooks () throws Exception {
        //Books in the Old Testiment
        BooksInOldTestiment.add(new Pair<>("Title Page", 0));
        BooksInOldTestiment.add(new Pair<>("Epistle Dedicatory", 0));
        BooksInOldTestiment.add(new Pair<>("Genesis", 50));
        BooksInOldTestiment.add(new Pair<>("Exodus", 40));
        BooksInOldTestiment.add(new Pair<>("Leviticus", 27));
        BooksInOldTestiment.add(new Pair<>("Numbers", 36));
        BooksInOldTestiment.add(new Pair<>("Deuteronomy", 34));
        BooksInOldTestiment.add(new Pair<>("Joshua", 24));
        BooksInOldTestiment.add(new Pair<>("Judges", 21));
        BooksInOldTestiment.add(new Pair<>("Ruth", 4));
        BooksInOldTestiment.add(new Pair<>("1 Samuel", 31));
        BooksInOldTestiment.add(new Pair<>("2 Samuel", 24));
        BooksInOldTestiment.add(new Pair<>("1 Kings", 22));
        BooksInOldTestiment.add(new Pair<>("2 Kings", 25));
        BooksInOldTestiment.add(new Pair<>("1 Chronicles", 29));
        BooksInOldTestiment.add(new Pair<>("2 Chronicles", 36));
        BooksInOldTestiment.add(new Pair<>("Ezra", 10));
        BooksInOldTestiment.add(new Pair<>("Nehemiah", 13));
        BooksInOldTestiment.add(new Pair<>("Esther", 10));
        BooksInOldTestiment.add(new Pair<>("Job", 42));
        BooksInOldTestiment.add(new Pair<>("Psalms", 150));
        BooksInOldTestiment.add(new Pair<>("Proverbs", 31));
        BooksInOldTestiment.add(new Pair<>("Ecclesiastes", 12));
        BooksInOldTestiment.add(new Pair<>("Song of Solomon", 8));
        BooksInOldTestiment.add(new Pair<>("Isaiah", 66));
        BooksInOldTestiment.add(new Pair<>("Jeremiah", 52));
        BooksInOldTestiment.add(new Pair<>("Lamentations", 5));
        BooksInOldTestiment.add(new Pair<>("Ezekiel", 48));
        BooksInOldTestiment.add(new Pair<>("Daniel", 12));
        BooksInOldTestiment.add(new Pair<>("Hosea", 14));
        BooksInOldTestiment.add(new Pair<>("Joel", 3));
        BooksInOldTestiment.add(new Pair<>("Amos", 9));
        BooksInOldTestiment.add(new Pair<>("Obadiah", 1));
        BooksInOldTestiment.add(new Pair<>("Jonah", 4));
        BooksInOldTestiment.add(new Pair<>("Micah", 7));
        BooksInOldTestiment.add(new Pair<>("Nahum", 3));
        BooksInOldTestiment.add(new Pair<>("Habakkuk", 3));
        BooksInOldTestiment.add(new Pair<>("Zephaniah", 3));
        BooksInOldTestiment.add(new Pair<>("Haggai", 2));
        BooksInOldTestiment.add(new Pair<>("Zechariah", 14));
        BooksInOldTestiment.add(new Pair<>("Malachi", 4));
        //Books in the New Testiment
        BooksInNewTestiment.add(new Pair<>("Title Page", 0));
        BooksInNewTestiment.add(new Pair<>("Matthew", 28));
        BooksInNewTestiment.add(new Pair<>("Mark", 16));
        BooksInNewTestiment.add(new Pair<>("Luke", 24));
        BooksInNewTestiment.add(new Pair<>("John", 21));
        BooksInNewTestiment.add(new Pair<>("Acts", 28));
        BooksInNewTestiment.add(new Pair<>("Romans", 16));
        BooksInNewTestiment.add(new Pair<>("1 Corinthians", 16));
        BooksInNewTestiment.add(new Pair<>("2 Corinthians", 13));
        BooksInNewTestiment.add(new Pair<>("Galatians", 6));
        BooksInNewTestiment.add(new Pair<>("Ephesians", 6));
        BooksInNewTestiment.add(new Pair<>("Philippians", 4));
        BooksInNewTestiment.add(new Pair<>("Colossians", 4));
        BooksInNewTestiment.add(new Pair<>("1 Thessalonians", 5));
        BooksInNewTestiment.add(new Pair<>("2 Thessalonians", 3));
        BooksInNewTestiment.add(new Pair<>("1 Timothy", 6));
        BooksInNewTestiment.add(new Pair<>("2 Timothy", 4));
        BooksInNewTestiment.add(new Pair<>("Titus", 3));
        BooksInNewTestiment.add(new Pair<>("Philemon", 1));
        BooksInNewTestiment.add(new Pair<>("Hebrews", 13));
        BooksInNewTestiment.add(new Pair<>("James", 5));
        BooksInNewTestiment.add(new Pair<>("1 Peter", 5));
        BooksInNewTestiment.add(new Pair<>("2 Peter", 3));
        BooksInNewTestiment.add(new Pair<>("1 John", 5));
        BooksInNewTestiment.add(new Pair<>("2 John", 1));
        BooksInNewTestiment.add(new Pair<>("3 John", 1));
        BooksInNewTestiment.add(new Pair<>("Jude", 1));
        BooksInNewTestiment.add(new Pair<>("Revelation", 22));
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

    //Get Element by text
    public String FindElementByText(String text) throws Exception{
        String xPathofText = "//android.widget.TextView[@text='"+text+"']";
        //System.out.println("Xpath is: '"+xPathofText+"");
        return xPathofText;
    }


    //Get Element by text contains
    public String FindElementByContainsText(String text) throws Exception{
        String xPathofText = "//android.widget.TextView[contains(@text, '"+text+"')]";
        //System.out.println("Xpath is: '"+xPathofText+"'");
        return xPathofText;
    }

    //Create WebElement by text
    public WebElement WebElementByText(String text) throws Exception{
        String xPathofText = "//android.widget.TextView[@text='"+text+"']";
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        WebElement tempElement = driver.findElement(By.xpath(xPathofText));
        return tempElement;
    }

    //Create WebElements by text (List)
    public List WebElementsByText(String text) throws Exception{
        String xPathofText = "//android.widget.TextView[@text='"+text+"']";
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        List tempElement = driver.findElements(By.xpath(xPathofText));
        return tempElement;
    }

    //Create WebElements by id
    public List WebElementsById(String text) throws Exception {
        List tempElement = driver.findElementsById(text);
        return tempElement;
    }

    //Create WebElements by accessibility id
    public List WebElementsByAccessibilityId(String text) throws Exception {
        List tempElement = driver.findElementsByAccessibilityId(text);
        return tempElement;
    }

    //Create WebElement by id
    public WebElement WebElementById(String text) throws Exception{
        WebElement tempElement = driver.findElementById(text);
        return tempElement;
    }

    //Create WebElement by AccessibilityId
    public WebElement WebElementByAccessibilityId(String text) throws Exception{
        WebElement tempElement = driver.findElementByAccessibilityId(text);
        return tempElement;
    }

    //Click Element by Text
    public void ClickUIElementByText (String text) throws Exception{
        String xPathofText = "//android.widget.TextView[@text='"+text+"']";
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        WebElement itemToClick = driver.findElement(By.xpath(xPathofText));
        itemToClick.click();
        System.out.println("Clicking: '"+text+"' using text by xPath");
        Thread.sleep(milliseconds_2);
    }

    //Click Element by 2 text items
    public void ClickUIElementBy2TextStings (String book, String number) throws Exception {
        String xPathofText = "//android.widget.TextView[contains(@text, '"+book+"')][contains(@text, '"+number+"')]";
        //System.out.println("Xpath of current item is: "+xPathofText+"");
        WebElement itemToClick = driver.findElement(By.xpath(xPathofText));
        itemToClick.click();
        System.out.println("Clicking: '"+book+" "+number+"' using 2 text contains by xPath");
        Thread.sleep(milliseconds_2);
    }

    //Click Element by Accessibility ID
    public void ClickUIElementByAccessibilityID (String elementAccessibilityID) throws Exception{
        WebElement itemToClick = driver.findElementByAccessibilityId(elementAccessibilityID);
        itemToClick.click();
        System.out.println("Clicking: '"+elementAccessibilityID+"' by Accessibility ID");
        Thread.sleep(milliseconds_2);
    }

    //Click Element by ID
    public void ClickUIElementByID (String elementID) throws Exception{
        WebElement itemToClick = driver.findElementById(elementID);
        itemToClick.click();
        System.out.println("Clicking: '"+elementID+"' by ID");
        Thread.sleep(milliseconds_2);
    }

    //Click Element by Xpath
    public void ClickUIElementByXpath (String xpath) throws Exception{
        WebElement itemToClick = driver.findElementByXPath(xpath);
        itemToClick.click();
        System.out.println("Clicking: '"+xpath+"' by xPath");
        Thread.sleep(milliseconds_2);
    }

    //Tap in the center of the screen
    public void TapCenterScreen () throws Exception{
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        driver.tap(1,screenWidth / 2, screenHeight / 2, 10);
        System.out.println("Tapping center of screen");
    }

    //Enter Text to a field by ID
    //click field, clear field, enter text
    public void sendText(String elementID, String text) throws Exception {
        WebElement textfield = driver.findElementById(elementID);
        textfield.clear();
        textfield.sendKeys(text);
        System.out.println("Sending Text: '"+text+"'");
        Thread.sleep(milliseconds_1);
    }

    //Scroll down the page
    public void scrollDown ()  {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        driver.swipe(screenWidth / 2, screenHeight / 10 * 9, screenWidth / 2, screenHeight / 10 * 2, 2000);
        System.out.println("Scrolling Down...");

    }

    //Scroll up the page
    public void scrollUp ()  {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        driver.swipe(screenWidth / 2, screenHeight / 10 * 2, screenWidth / 2, screenHeight / 10 * 9, 2000);
        System.out.println("Scrolling Up...");

    }

    //Swipe right
    public void swipeRight () throws Exception {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        driver.swipe(screenWidth / 20 * 18, screenHeight / 2, screenWidth / 20 * 2, screenHeight / 2, 300);
        System.out.println("Swiping right...");
        Thread.sleep(milliseconds_1);
    }

    //Swipe left
    public void swipeLeft () throws Exception {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        driver.swipe(screenWidth / 20 * 3, screenHeight / 2, screenWidth / 20 * 19, screenHeight / 2, 300);
        System.out.println("Swing left...");
        Thread.sleep(milliseconds_1);
    }

    //Scroll to
    public void scrollTo(String text){
        Boolean isNotPresent = driver.findElements(By.xpath("//android.widget.TextView[@text='" + text + "']")).size() <= 0;
        while ((isNotPresent)) {
            System.out.println("" + text + " isn't on the screen... Scrolling to find");
            scrollDown();
            isNotPresent = driver.findElements(By.xpath("//android.widget.TextView[@text='" + text + "']")).size() <= 0;
            while((isNotPresent)) {
                System.out.println(""+ text +" wasn't found on first scroll... Scrolling full page to find");
                driver.scrollTo(text);
                isNotPresent = driver.findElements(By.xpath("//android.widget.TextView[@text='" + text + "']")).size() <= 0;
            }
        }
    }

    //Scroll to by id
    public void scrollToById(String id){
        System.out.println(id);
        WebElement idIsPresent = driver.findElementById(id);
        int screenHeight = driver.manage().window().getSize().getHeight();
        int upperY = idIsPresent.getLocation().getY();
        System.out.println("Screen Height is "+screenHeight+"");
        System.out.println("upper Y is "+upperY+"");
        while (upperY >= screenHeight / 2){
            System.out.println("scrolling down y '"+upperY+"' is >= "+ screenHeight / 2 +"");
            scrollDown();
            upperY = idIsPresent.getLocation().getY();
        }
        while (upperY <= screenHeight / 8){
            System.out.println("scrolling up y '"+upperY+"' is <= "+ screenHeight / 8+"");
            scrollUp();
            upperY = idIsPresent.getLocation().getY();
        }

    }

    //Scroll to by
    public void scrollToBy(WebElement TempElement){
        System.out.println(TempElement);
        int screenHeight = driver.manage().window().getSize().getHeight();
        int upperY = TempElement.getLocation().getY();
        System.out.println("Screen Height is "+screenHeight+"");
        System.out.println("upper Y is "+upperY+"");
        while (upperY >= screenHeight / 2){
            System.out.println("scrolling down y '"+upperY+"' is >= "+ screenHeight / 2 +"");
            scrollDown();
            upperY = TempElement.getLocation().getY();
        }
        while (upperY <= screenHeight / 8){
            System.out.println("scrolling up y '"+upperY+"' is <= "+ screenHeight / 8+"");
            scrollUp();
            upperY = TempElement.getLocation().getY();
        }

    }



    //Verify Text
    public void verifyText(String expectedText, WebElement webelementActual) throws Exception {
        String webelementActualAsText = webelementActual.getText();
        Assert.assertEquals(expectedText, webelementActualAsText);
        System.out.println("Validating text Expected: '"+expectedText+"' Actual: '"+webelementActualAsText+"'");

    }

    //Verify Object Exists Using WebElementsBy
    public void assertElementExistsBy(List webElementsBy){
        Boolean tempElement = webElementsBy.size() > 0;
        System.out.println(""+webElementsBy.toString()+" "+tempElement+"");
        assert tempElement == true;
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
    public void assertElementNotPresentBy(List webElementsBy ){
        Boolean tempElement = webElementsBy.size() > 0;
        System.out.println("assert element is not present. Expected: false [] Actual: "+tempElement+" "+webElementsBy.toString()+"");
        assert tempElement == false;
    }


    //Check Nav Book Title
    public void verifyNavBookTitle(ArrayList<Pair<String, Integer> > bookList)throws Exception {


        for (int i = 0; i < bookList.size() ; i++) {
            Pair <String,Integer> currentBook = bookList.get(i);
            String bookTitle = currentBook.getKey();
            int numberOfChapters = currentBook.getValue();
            System.out.println("");
            System.out.println("************************************** Starting  Check for "+bookTitle+" **************************************");
            System.out.println("Book Title: "+bookTitle+"");
            System.out.println("Number of Chapters: "+numberOfChapters+"");
            String titlebarBookTitle = "";

            if (numberOfChapters == 1) {
                titlebarBookTitle = ""+bookTitle+" 1";
            } else {
                titlebarBookTitle = ""+bookTitle+"";
            }
            System.out.println("Title bar book title to look for: "+titlebarBookTitle+"");

            scrollTo(bookTitle);

            System.out.println(""+bookTitle+" is on the screen");
            ClickUIElementByText(bookTitle);
            verifyText(titlebarBookTitle, driver.findElementByXPath(FindElementByContainsText(bookTitle)));
            if (numberOfChapters > 1) {
                //Check Title bar when Chapter is displayed
                ClickUIElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout");
                Thread.sleep(milliseconds_1);
                String titlebarBookTitle2 = "";
                if (bookTitle == "Psalms"){
                    titlebarBookTitle2 = "Psalm "+"1";
                    verifyText(titlebarBookTitle2, driver.findElementByXPath(FindElementByContainsText("Psalm")));
                } else {
                    titlebarBookTitle2 = "" + bookTitle + " 1";
                    verifyText(titlebarBookTitle2, driver.findElementByXPath(FindElementByContainsText(titlebarBookTitle2)));
                }

                ClickUIElementByID("Navigate up");
                Thread.sleep(milliseconds_1);

                //Verify all of the chapters are present
                for (int j = 1; j <= numberOfChapters; j++) {
                    String chapterNumberString = String.valueOf(j);
                    scrollTo(chapterNumberString);

                    WebElement chapterNumber = driver.findElement(By.xpath(FindElementByText(chapterNumberString)));
                    verifyText(chapterNumberString, chapterNumber);

                }


            }


            ClickUIElementByID("Navigate up");
            Thread.sleep(milliseconds_1);
            System.out.println("************************************** Completed Check for "+bookTitle+" **************************************");
            System.out.println("");
        }

    }

    public void OpenScripture (String work, String book, String chapter, String verse) throws Exception {
        ClickUIElementByText("Scriptures");
        Thread.sleep(milliseconds_1);
        ClickUIElementByText(work);
        Thread.sleep(milliseconds_1);
        scrollTo(book);
        ClickUIElementByText(book);
        Thread.sleep(milliseconds_1);
        scrollTo(chapter);
        ClickUIElementByText(chapter);
        Thread.sleep(milliseconds_1);
        scrollToById("p"+verse+"");

    }


    //*************************************************************** Tests ***************************************************************

    //********** Tips Screen **********
    @Test
    public void skipTips() throws InterruptedException {
        Thread.sleep(milliseconds_3);
        Boolean isPresent = driver.findElements(By.id("org.lds.ldssa.dev:id/tipToolbar")).size() > 0;
        while ((isPresent)) {
            System.out.println("Tips Screen is Present... Skipping");
            //click on skip
            WebElement skipTips = driver.findElement(By.id("org.lds.ldssa.dev:id/skip"));
            skipTips.click();
            isPresent = driver.findElements(By.id("org.lds.ldssa.dev:id/tipToolbar")).size() > 0;
        }

    }


    @Test
    public void allTips() throws InterruptedException {

        Thread.sleep(milliseconds_3);
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
    public void skipLogin() throws InterruptedException {

        skipTips();
        //click skip
        Thread.sleep(milliseconds_2);
        WebElement skipLogin = driver.findElementById("org.lds.ldssa.dev:id/done");
        skipLogin.click();
        Thread.sleep(milliseconds_3);
    }

    @Test
    public void login() throws Exception {
        //This test checks valid login
        skipTips();
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/signInToolbar"));
        verifyText("Sign In", WebElementByText("Sign In"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/signInMessageTextView"));
        verifyText("An LDS Account is used to back up and synchronize your annotations across devices and on LDS.org.",WebElementById("org.lds.ldssa.dev:id/signInMessageTextView"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/usernameEditText"));
        //appium can't validate ! if Username not entered and SignIn clicked
        sendText("org.lds.ldssa.dev:id/usernameEditText", user);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/passwordEditText"));
        sendText("org.lds.ldssa.dev:id/passwordEditText", password);
        assertElementExistsBy(WebElementsByAccessibilityId("Toggle password visibility"));
        boolean passwordVisibility = Boolean.parseBoolean((WebElementByAccessibilityId("Toggle password visibility").getAttribute("checked")));
        System.out.println(passwordVisibility);
        assert (passwordVisibility == false);
        verifyText("",WebElementById("org.lds.ldssa.dev:id/passwordEditText"));
        ClickUIElementByAccessibilityID("Toggle password visibility");
        Thread.sleep(milliseconds_1);
        passwordVisibility = Boolean.parseBoolean((WebElementByAccessibilityId("Toggle password visibility").getAttribute("checked")));
        System.out.println(passwordVisibility);
        assert (passwordVisibility == true);
        verifyText(password, WebElementById("org.lds.ldssa.dev:id/passwordEditText"));
        WebElement signInButton = driver.findElementById("org.lds.ldssa.dev:id/ldsAccountSignInButton");
        signInButton.click();
        Thread.sleep(milliseconds_1);
        verifyText("Library", WebElementByText("Library"));

    }

    @Test
    public void invalidLogin() throws Exception {
        skipTips();
        verifyText("Sign In", WebElementByText("Sign In"));
        sendText("org.lds.ldssa.dev:id/usernameEditText", user);
        sendText("org.lds.ldssa.dev:id/passwordEditText", wrongPassword);
        WebElement signInButton = driver.findElementById("org.lds.ldssa.dev:id/ldsAccountSignInButton");
        signInButton.click();
        Thread.sleep(milliseconds_1);
        verifyText("Error", WebElementByText("Error"));
        ClickUIElementByText("OK");
        sendText("org.lds.ldssa.dev:id/passwordEditText", password);
        signInButton.click();
        Thread.sleep(milliseconds_1);
        verifyText("Library", WebElementByText("Library"));

    }

    @Test
    public void troubleSigningIn() throws Exception {
        skipTips();
        verifyText("Sign In", WebElementByText("Sign In"));
        ClickUIElementByID("org.lds.ldssa.dev:id/ldsAccountLoginForgotCredentialsButton");
        Thread.sleep(milliseconds_5);
        verifyText("https://ldsaccount.lds.org/recovery", WebElementById("com.android.chrome:id/url_bar"));
    }

    @Test
    public void signInCreateAccount() throws Exception {
        skipTips();
        verifyText("Sign In", WebElementByText("Sign In"));
        verifyText("Create LDS Account", WebElementById("org.lds.ldssa.dev:id/ldsAccountLoginCreateAccountButton"));
        ClickUIElementByID("org.lds.ldssa.dev:id/ldsAccountLoginCreateAccountButton");
        Thread.sleep(milliseconds_5);
        verifyText("https://ldsaccount.lds.org/register", WebElementById("com.android.chrome:id/url_bar"));
    }


    //*********** Library Screen ***********
    @Test
    public void LibraryContentScreen() throws Exception {
        //Skip Login
        skipLogin();
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText("Library", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmark"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        scrollTo("Scriptures");
        assertElementExistsBy(WebElementsByText("Scriptures"));
        scrollTo("Jesus Christ");
        assertElementExistsBy(WebElementsByText("Jesus Christ"));
        scrollTo("General Conference");
        assertElementExistsBy(WebElementsByText("General Conference"));
        scrollTo("Teachings of Presidents");
        assertElementExistsBy(WebElementsByText("Teachings of Presidents"));
        scrollTo("Notes");
        assertElementExistsBy(WebElementsByText("Notes"));
        scrollTo("Lessons");
        assertElementExistsBy(WebElementsByText("Lessons"));
        scrollTo("Magazines");
        assertElementExistsBy(WebElementsByText("Magazines"));
        scrollTo("Music");
        assertElementExistsBy(WebElementsByText("Music"));
        scrollTo("Videos");
        assertElementExistsBy(WebElementsByText("Videos"));
        scrollTo("Missionary");
        assertElementExistsBy(WebElementsByText("Missionary"));
        scrollTo("Temple and Family History");
        assertElementExistsBy(WebElementsByText("Temple and Family History"));
        scrollTo("Families");
        assertElementExistsBy(WebElementsByText("Families"));
        scrollTo("Young Adults");
        assertElementExistsBy(WebElementsByText("Young Adults"));
        scrollTo("Youth");
        assertElementExistsBy(WebElementsByText("Youth"));
        scrollTo("Children");
        assertElementExistsBy(WebElementsByText("Children"));
        scrollTo("Leaders");
        assertElementExistsBy(WebElementsByText("Leaders"));
        scrollTo("Self-Reliance");
        assertElementExistsBy(WebElementsByText("Self-Reliance"));
        scrollTo("Religious Freedom");
        assertElementExistsBy(WebElementsByText("Religious Freedom"));
        scrollTo("Church History");
        assertElementExistsBy(WebElementsByText("Church History"));
        scrollTo("Seminaries and Institutes");
        assertElementExistsBy(WebElementsByText("Seminaries and Institutes"));
        scrollTo("Tips");
        assertElementExistsBy(WebElementsByText("Tips"));


        ClickUIElementByAccessibilityID("More options");
        Thread.sleep(milliseconds_1);
        assertElementExistsBy(WebElementsByText("New Screen…"));
        assertElementExistsBy(WebElementsByText("Custom Collections"));
        assertElementExistsBy(WebElementsByText("Language"));
        assertElementExistsBy(WebElementsByText("Settings"));

    }


    //********** Notes Landing Page **********
    @Test
    public void NotesLandingPage_NotSignedIn() throws Exception {
        //Skip Login
        skipLogin();
        ClickUIElementByText("Notes");
        Thread.sleep(milliseconds_1);

        //Verify all elements present
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmark"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        assertElementExistsBy(WebElementsByText("All"));
        assertElementExistsBy(WebElementsByText("Tags"));
        assertElementExistsBy(WebElementsByText("Notebooks"));
        assertElementExistsBy(WebElementsByText("No Notes"));
        assertElementExistsBy(WebElementsByText("Record notes to preserve your thoughts."));
        assertElementExistsBy(WebElementsByText("Notes"));

        //Click More Options Menu
        ClickUIElementByAccessibilityID("More options");
        Thread.sleep(milliseconds_1);

        //Verify all elements present in More Options Menu
        assertElementExistsBy(WebElementsByText("New Screen…"));
        assertElementExistsBy(WebElementsByText("Restore Journal"));
        assertElementExistsBy(WebElementsByText("Language"));
        assertElementExistsBy(WebElementsByText("Settings"));

        //Tap Center of the Screen
        TapCenterScreen();
        Thread.sleep(milliseconds_1);

        //Verify More Options Menu items not present
        assertElementNotPresentBy(WebElementsByText("New Screen…"));
        assertElementNotPresentBy(WebElementsByText("Restore Journal"));
        assertElementNotPresentBy(WebElementsByText("Language"));
        assertElementNotPresentBy(WebElementsByText("Settings"));

        //Click Main Toolbar
        ClickUIElementByID("org.lds.ldssa.dev:id/mainToolbarTitleTextView");
        Thread.sleep(milliseconds_1);

        //Dismis the toolbar
        ClickUIElementByID("org.lds.ldssa.dev:id/allAnnotationsRecyclerView");
        Thread.sleep(milliseconds_1);

        //Click back
        ClickUIElementByAccessibilityID("Navigate up");
        Thread.sleep(milliseconds_1);

        //Verify Note Tabs Not Present
        assertElementNotPresentBy(WebElementsByAccessibilityId("All"));
        assertElementNotPresentBy(WebElementsByAccessibilityId("Tags"));
        assertElementNotPresentBy(WebElementsByAccessibilityId("Notebooks"));
    }

    @Test
    public void SignInCheckNotebookAndNote() throws Exception {

        //Login
        login();

        //Verify "Notes item exists by text"
        verifyText("Notes", WebElementByText("Notes"));
        //Click "Notes"
        ClickUIElementByText("Notes");
        Thread.sleep(milliseconds_1);
        //Verify Tabs in the notes section
        verifyText("All",WebElementByText("All"));
        verifyText("Tags", WebElementByText("Tags"));
        verifyText("Notebooks", WebElementByText("Notebooks"));
        //Click Notebooks
        ClickUIElementByText("Notebooks");
        Thread.sleep(milliseconds_1);
        //Check notebook title and click on it
        verifyText("Spiritual Thoughts", WebElementById("org.lds.ldssa.dev:id/titleView"));
        ClickUIElementByText("Spiritual Thoughts");
        Thread.sleep(milliseconds_1);
        //Verify note title and text preview then click on it
        verifyText("Spiritual Thought", WebElementByText("Spiritual Thought"));
        verifyText("Spiritual content", WebElementByText("Spiritual content"));
        ClickUIElementByText("Spiritual Thought");
        Thread.sleep(milliseconds_1);
        //Verify note title and content
        verifyText("Spiritual Thought", WebElementById("org.lds.ldssa.dev:id/noteTitleEditText"));
        verifyText("Spiritual content", WebElementById("org.lds.ldssa.dev:id/markdownEditText"));
        //Verify buttons are visible
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/note_menu_tag"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/note_menu_add_to_notebook"));
        //Click Tag
        ClickUIElementByID("org.lds.ldssa.dev:id/note_menu_tag");
        Thread.sleep(milliseconds_3);
        //Verify Tags element exists
        verifyText("Tags", WebElementByText("Tags"));
        //Verify tag sorting and navigation exists
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/menu_item_tag_sort"));
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        sendText("org.lds.ldssa.dev:id/tagNameEditText","Spirit");
        Thread.sleep(milliseconds_1);
        ClickUIElementByAccessibilityID("Navigate up");
        Thread.sleep(milliseconds_1);
        ClickUIElementByID("org.lds.ldssa.dev:id/note_menu_tag");
        Thread.sleep(milliseconds_1);
        //Tag check
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/tag_text"));
        verifyText("Spirit", WebElementById("org.lds.ldssa.dev:id/tag_text"));
        Thread.sleep(milliseconds_1);
        ClickUIElementByID("org.lds.ldssa.dev:id/tag_delete");




    }

    @Test
    public void CreateNewNotebook() throws Exception {

        //Login
        skipLogin();
        //Verify "Notes item exists by text"
        verifyText("Notes", WebElementByText("Notes"));
        //Click "Notes"
        ClickUIElementByText("Notes");
        Thread.sleep(milliseconds_1);
        //Verify Tabs in the notes section
        verifyText("All", WebElementByText("All"));
        verifyText("Tags", WebElementByText("Tags"));
        verifyText("Notebooks", WebElementByText("Notebooks"));
        //Click Notebooks
        ClickUIElementByText("Notebooks");
        Thread.sleep(milliseconds_1);
        ClickUIElementByID("org.lds.ldssa.dev:id/notesFloatingActionButton");
        Thread.sleep(milliseconds_1);
        verifyText("Create Notebook", WebElementByText("Create Notebook"));
        verifyText("Cancel", WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"));
        verifyText("Add", WebElementById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"));
        sendText("android:id/input", NotebookName1);
        ClickUIElementByID("org.lds.ldssa.dev:id/md_buttonDefaultPositive");
        Thread.sleep(milliseconds_5);
        verifyText(NotebookName1, WebElementByText(NotebookName1));
    }

    @Test
    public void CreateNewNoteInNewNotebook() throws Exception {
        CreateNewNotebook();
        ClickUIElementByText(NotebookName1);
        verifyText("No Notes in This Notebook",WebElementById("org.lds.ldssa.dev:id/emptyStateTitleTextView"));
        verifyText("Record notes to preserve your thoughts.", WebElementById("org.lds.ldssa.dev:id/emptyStateSubTitleTextView"));
        assertElementExistsBy(WebElementsByAccessibilityId("More options"));
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmark"));
        assertElementExistsBy(WebElementsByAccessibilityId("Search"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText(NotebookName1, WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/dropArrowImageView"));
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
        String NoteTitle = "Test Note Title";
        String NoteBody = "Test Note Body";
        sendText("org.lds.ldssa.dev:id/noteTitleEditText", NoteTitle);
        sendText("org.lds.ldssa.dev:id/markdownEditText", NoteBody);

        ClickUIElementByAccessibilityID("Navigate up");
        Thread.sleep(milliseconds_1);

        //Back Up Annotations?
        verifyText("Back Up Annotations", WebElementByText("Back Up Annotations"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultPositive"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultNegative"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/md_buttonDefaultNeutral"));
        ClickUIElementByID("org.lds.ldssa.dev:id/md_buttonDefaultNegative");
        Thread.sleep(milliseconds_1);

        //Check Note
        verifyText(NoteTitle, WebElementById("org.lds.ldssa.dev:id/noteTitleTextView"));
        verifyText(NoteBody, WebElementById("org.lds.ldssa.dev:id/noteMarkdownTextView"));
        ClickUIElementByID("org.lds.ldssa.dev:id/noteTitleTextView");
        Thread.sleep(milliseconds_1);
        verifyText(NoteTitle, WebElementById("org.lds.ldssa.dev:id/noteTitleEditText"));
        verifyText(NoteBody, WebElementById("org.lds.ldssa.dev:id/markdownEditText"));
        Thread.sleep(milliseconds_1);

    }

    //********** Bookmarks Landing Page **********
    @Test
    public void BookmarksLandingPageFromLibrary_NotSignedIn() throws Exception {
        //Skip Login
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmark"));
        ClickUIElementByAccessibilityID("Bookmark");
        assertElementExistsBy(WebElementsByText("Bookmarks"));
        assertElementExistsBy(WebElementsByText("Screens"));
        assertElementExistsBy(WebElementsByText("History"));
        assertElementExistsBy(WebElementsByText("No Bookmarks"));
        assertElementExistsBy(WebElementsByText("Add a bookmark to quickly return to where you left off."));
    }

    @Test
    public void BookmarksLandingPageFromNotes_NotSignedIn() throws Exception {
    // Skip Login
        skipLogin();
        ClickUIElementByText("Notes");
        Thread.sleep(milliseconds_1);
        ClickUIElementByAccessibilityID("Bookmark");
        Thread.sleep(milliseconds_1);

        //verify all elements present on bookmarks screen
        assertElementExistsBy(WebElementsByText("Bookmarks"));
        assertElementExistsBy(WebElementsByText("Screens"));
        assertElementExistsBy(WebElementsByText("History"));
        assertElementExistsBy(WebElementsByText("No Bookmarks"));
        assertElementExistsBy(WebElementsByText("Add a bookmark to quickly return to where you left off."));
        //click Screens
        Thread.sleep(milliseconds_1);
        ClickUIElementByText("Screens");
        Thread.sleep(milliseconds_1);
        //assert elements present on screens screen
        assertElementExistsBy(WebElementsByAccessibilityId("Show Screens as Separate Windows"));
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        //verify notes screen
        verifyText("Notes", WebElementById("org.lds.ldssa.dev:id/screenTitleTextView"));
        assertElementExistsBy(WebElementsByAccessibilityId("Notes"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/screen_menu"));
        //verify add screen fab
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/locationsFab"));

        //click "Show Screens as Separate Windows"
        ClickUIElementByAccessibilityID("Show Screens as Separate Windows");
        Thread.sleep(milliseconds_1);

        //assert elements present on Screen Settings Screen
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/action_bar"));
        assertElementExistsBy(WebElementsByText("Screen Settings"));
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsByText("Show Screens as Separate Windows"));
        assertElementExistsBy(WebElementsById("android:id/widget_frame"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/switchWidget"));
        verifyText("ON", WebElementById("org.lds.ldssa.dev:id/switchWidget"));
        ClickUIElementByID("org.lds.ldssa.dev:id/switchWidget");
        Thread.sleep(milliseconds_1);
        verifyText("OFF", WebElementById("org.lds.ldssa.dev:id/switchWidget"));

        //click back
        ClickUIElementByAccessibilityID("Navigate up");
        Thread.sleep(milliseconds_1);
        assertElementNotPresentBy(WebElementsByText("Screen Settings"));
        assertElementExistsBy(WebElementsByText("Bookmarks"));

        //Click History tab
        ClickUIElementByText("History");
        Thread.sleep(milliseconds_1);
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateImageView"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateTitleTextView"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/emptyStateSubTitleTextView"));
        verifyText("No History", WebElementById("org.lds.ldssa.dev:id/emptyStateTitleTextView"));
        verifyText("Explore content, find your path, and go back to it.", WebElementById("org.lds.ldssa.dev:id/emptyStateSubTitleTextView"));

        ClickUIElementByAccessibilityID("Navigate up");
        Thread.sleep(milliseconds_1);
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
        verifyText("Notes", WebElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView"));
    }

    @Test
    public void ScreensScreenFromLibrary() throws Exception {
        //Skip Login
        skipLogin();
        assertElementExistsBy(WebElementsByAccessibilityId("Bookmark"));
        ClickUIElementByAccessibilityID("Bookmark");
        Thread.sleep(milliseconds_1);
        assertElementExistsBy(WebElementsByText("Screens"));
        ClickUIElementByText("Screens");
        Thread.sleep(milliseconds_1);
        assertElementExistsBy(WebElementsByAccessibilityId("Library"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/screenImageView"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/screenTitleTextView"));
        verifyText("Library", WebElementById("org.lds.ldssa.dev:id/screenTitleTextView"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/screen_menu"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/locationsFab"));
        assertElementExistsBy(WebElementsByAccessibilityId("Show Screens as Separate Windows"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/menu_item_tabs_in_overview"));
        ClickUIElementByID("org.lds.ldssa.dev:id/menu_item_tabs_in_overview");
        assertElementExistsBy(WebElementsById("android:id/title"));
        verifyText("Show Screens as Separate Windows", WebElementById("android:id/title"));
        assertElementExistsBy(WebElementsById("org.lds.ldssa.dev:id/switchWidget"));
        verifyText("ON", WebElementById("org.lds.ldssa.dev:id/switchWidget"));
        assertElementExistsBy(WebElementsByAccessibilityId("Navigate up"));
        assertElementExistsBy(WebElementsByText("Screen Settings"));
        verifyText("Screen Settings", WebElementByText("Screen Settings"));
        ClickUIElementByID("org.lds.ldssa.dev:id/switchWidget");
        Thread.sleep(milliseconds_1);
        verifyText("OFF",WebElementById("org.lds.ldssa.dev:id/switchWidget"));
        Thread.sleep(milliseconds_4);

    }


    @Test
    public void Bookmark() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon","Helaman", "5","1");
        Thread.sleep(milliseconds_1);
        //get book and chapter title
        WebElement chapterTitle = driver.findElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView");
        String chapterTitleAsText = chapterTitle.getText();

        //click bookmark
        ClickUIElementByID("org.lds.ldssa.dev:id/menu_item_bookmark");

        //click new bookmark
        ClickUIElementByID("org.lds.ldssa.dev:id/locationsFab");

        //Verify Bookmark text is same as book and chapter title
        WebElement actualBookmarkTitle = driver.findElementById("android:id/input");
        String actualBookmarkTitleAsText = actualBookmarkTitle.getText();
        //System.out.println(chapterTitleAsText);
        //System.out.println(actualBookmarkTitle.getText());
        Assert.assertEquals(chapterTitleAsText, actualBookmarkTitleAsText);
        Thread.sleep(milliseconds_2);

        //Click add
        ClickUIElementByID("org.lds.ldssa.dev:id/md_buttonDefaultPositive");
        //Verify that the new bookmark name matches
        WebElement completedBookmarkTitle = driver.findElementById("org.lds.ldssa.dev:id/titleTextView");
        String completedBookmarkTitleAsText = completedBookmarkTitle.getText();
        Assert.assertEquals(chapterTitleAsText, completedBookmarkTitleAsText);

        //Navigate back
        ClickUIElementByID("Navigate up");

        //Check for sign in popup
        WebElement signInPopupTitle = driver.findElementById("org.lds.ldssa.dev:id/md_title");
        String signInPopupTitleAsText = signInPopupTitle.getText();
        //Verify Title is "Back Up Annotations"
        Assert.assertEquals(signInPopupTitleAsText, "Back Up Annotations");
        Thread.sleep(milliseconds_2);

        //Click "No Thanks"
        ClickUIElementByID("org.lds.ldssa.dev:id/md_buttonDefaultNegative");

        ClickUIElementByID("Navigate up");
        ClickUIElementByID("Navigate up");
        ClickUIElementByID("Navigate up");
        ClickUIElementByID("org.lds.ldssa.dev:id/menu_item_bookmark");
        completedBookmarkTitle.click();
        swipeRight();
        swipeRight();
        swipeLeft();
        swipeLeft();
        Thread.sleep(milliseconds_1);
        ClickUIElementByID("mediaFab");
        Thread.sleep(milliseconds_5);


    }

//    @Test
//    public void moreOptionsMenu() throws Exception {
//        skipLogin();
//        OpenScripture("Book of Mormon", "Helaman", "5","26");
//        Thread.sleep(milliseconds_1);
//        scrollToById("p15");
//        Thread.sleep(milliseconds_1);
//        driver.tap(1, driver.findElementById("p15"),1000);
//        ClickUIElementByID("markHighlightMenuTextView");
//
//        driver.tap(1, driver.findElementByAccessibilityId("More options"),1);
//        Thread.sleep(1000);
//        assertElementExistsByText("New Screen…");
//        assertElementExistsByText("Related Content");
//        assertElementExistsByText("Share");
//        assertElementExistsByText("Play Audio");
//        assertElementExistsByText("Language");
//        assertElementExistsByText("Settings");
//        Thread.sleep(milliseconds_1);
//
//    }


    @Test
    public void annotationsMenu() throws Exception {
        skipLogin();
        OpenScripture("Book of Mormon", "Helaman", "5","26");
        Thread.sleep(milliseconds_1);
        scrollToById("p15");
        Thread.sleep(milliseconds_1);
        driver.tap(1, driver.findElementById("p15"),1000);

    }

    @Test
    public void allBooksInTheOldTestiment() throws Exception {
        skipLogin();

        ClickUIElementByText("Scriptures");
        ClickUIElementByText("Old Testament");


        //Calls verifyNavBookTitle and passes in the books in the Old Testiment
        verifyNavBookTitle(BooksInOldTestiment);

    }

    @Test
    public void allBooksInTheNewTestiment() throws Exception {
        skipLogin();

        ClickUIElementByText("Scriptures");
        ClickUIElementByText("New Testament");
        //Calls verifyNavBookTitle and passes in the books in the New Testiment
        verifyNavBookTitle(BooksInNewTestiment);

    }


    @Test
    public void allBooksInTheBoM() throws Exception {
        skipLogin();

        ClickUIElementByText("Scriptures");
        ClickUIElementByText("Book of Mormon");
        //Calls verifyNavBookTitle and passes in the books in the Book of Mormon
        verifyNavBookTitle(BooksInBom);


    }

    @Test
    public void allBooksInTheDAndC() throws Exception {
        skipLogin();

        ClickUIElementByText("Scriptures");
        ClickUIElementByText("Doctrine and Covenants");
        //Calls verifyNavBookTitle and passes in the books in the Doctrine and Covenants
        verifyNavBookTitle(BooksInDAndC);


    }


    @Test
    public void allBooksInThePearlOfGreatPrice() throws Exception {
        skipLogin();

        ClickUIElementByText("Scriptures");
        ClickUIElementByText("Pearl of Great Price");
        //Calls verifyNavBookTitle and passes in the books in the Pearl of Great Price
        verifyNavBookTitle(BooksInPearlOfGreatPrice);


    }


    @Test
    public void Bookmarks() throws Exception {

        skipLogin();

        ClickUIElementByText("Scriptures");
        ClickUIElementByText("Book of Mormon");
        ClickUIElementByText("Jacob");
        ClickUIElementByText("1");

        //get book and chapter title
        WebElement chapterTitle = driver.findElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView");
        String chapterTitleAsText = chapterTitle.getText();

        //click bookmark
        ClickUIElementByID("org.lds.ldssa.dev:id/menu_item_bookmark");

        //click new bookmark
        ClickUIElementByID("org.lds.ldssa.dev:id/locationsFab");

        //Verify Bookmark text is same as book and chapter title
        WebElement actualBookmarkTitle = driver.findElementById("android:id/input");
        String actualBookmarkTitleAsText = actualBookmarkTitle.getText();
        //System.out.println(chapterTitleAsText);
        //System.out.println(actualBookmarkTitle.getText());
        Assert.assertEquals(chapterTitleAsText, actualBookmarkTitleAsText);
        Thread.sleep(milliseconds_2);

        //Click add
        ClickUIElementByID("org.lds.ldssa.dev:id/md_buttonDefaultPositive");
        //Verify that the new bookmark name matches
        WebElement completedBookmarkTitle = driver.findElementById("org.lds.ldssa.dev:id/titleTextView");
        String completedBookmarkTitleAsText = completedBookmarkTitle.getText();
        Assert.assertEquals(chapterTitleAsText, completedBookmarkTitleAsText);

        //Navigate back
        ClickUIElementByID("Navigate up");

        //Check for sign in popup
        WebElement signInPopupTitle = driver.findElementById("org.lds.ldssa.dev:id/md_title");
        String signInPopupTitleAsText = signInPopupTitle.getText();
        //Verify Title is "Back Up Annotations"
        Assert.assertEquals(signInPopupTitleAsText, "Back Up Annotations");
        Thread.sleep(milliseconds_2);

        //Click "No Thanks"
        ClickUIElementByID("org.lds.ldssa.dev:id/md_buttonDefaultNegative");

        //Verify that the bookmark icon is present

        //back
        ClickUIElementByID("Navigate up");
        //back
        ClickUIElementByID("Navigate up");


        //Open Bookmarks Tab
        ClickUIElementByID("Bookmark");

        //Verify that the bookmark is titled correctly
        completedBookmarkTitleAsText = completedBookmarkTitle.getText();
        Assert.assertEquals(chapterTitleAsText, completedBookmarkTitleAsText);

        //Click the Bookmark
        completedBookmarkTitle.click();
        Thread.sleep(milliseconds_1);

        //Verify that navigation goes to the bookmark location
        Assert.assertEquals(completedBookmarkTitleAsText, chapterTitle.getText());

        //Open Nav Bar
        chapterTitle.click();
        Thread.sleep(milliseconds_1);

        //Click Library

        WebElement library = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[4]/android.widget.TextView");
        library.click();
        Thread.sleep(milliseconds_1);

        //Click General Conference
        ClickUIElementByText("General Conference");
        Thread.sleep(milliseconds_1);

        //Click on the latest conference
        ClickUIElementByText("October 2017");
        Thread.sleep(milliseconds_2);
        //opens the conference
        ClickUIElementByText("October 2017");
        Thread.sleep(milliseconds_1);

        //Click on a talk
        WebElement talk = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        String talkTitleAsText = talk.getText();
        talk.click();
        Thread.sleep(milliseconds_2);

        //open bookmarks tab
        ClickUIElementByID("Bookmark");
        ClickUIElementByID("org.lds.ldssa.dev:id/locationsFab");
        String actualBookmarkTitleAsText2 = actualBookmarkTitle.getText();
        //Checks that the name of the bookmark matches the talk title
        Assert.assertEquals(actualBookmarkTitleAsText2, talkTitleAsText);
        ClickUIElementByID("org.lds.ldssa.dev:id/md_buttonDefaultPositive");
        ClickUIElementByID("Navigate up");
        Thread.sleep(milliseconds_1);

        chapterTitle.click();
        Thread.sleep(milliseconds_1);
        ClickUIElementByText("Library");

        //Open the bookmarks tab
        ClickUIElementByID("Bookmark");
        Thread.sleep(milliseconds_1);

        //create web elemets and title stings for the first and second bookmarks on the page
        WebElement bookmarkOne = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]");
        WebElement bookmarkOneMoreOptionsMenu = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.ImageButton");
        WebElement bookmarkTwo = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]");
        WebElement bookmarkTwoMoreOptionsMenu = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.ImageButton");
        String bookmarkOneTitleAsText = bookmarkOne.getText();
        String bookmarkTwoTitleAsText = bookmarkTwo.getText();

        //click the first bookmark on the page
        bookmarkOne.click();
        Thread.sleep(milliseconds_1);

        //Open the bookmarks tab
        ClickUIElementByID("Bookmark");
        Thread.sleep(milliseconds_1);
        //click the second bookmark on the page
        bookmarkTwo.click();
        Thread.sleep(milliseconds_1);

        //Open the bookmarks tab
        ClickUIElementByID("Bookmark");
        Thread.sleep(milliseconds_1);
        //click the More Options Menu for bookmarkTwo
        bookmarkTwoMoreOptionsMenu.click();
        Thread.sleep(milliseconds_1);

        //create webelements for the more options menu items
        WebElement bookmarkUpdate = driver.findElementByXPath("//android.widget.TextView[@text='Update']");
        WebElement bookmarkRename = driver.findElementByXPath("//android.widget.TextView[@text='Rename']");
        WebElement bookmarkDelete = driver.findElementByXPath("//android.widget.TextView[@text='Delete']");

        //all items in more options menu for bookmark two
        bookmarkUpdate.click();
        Thread.sleep(milliseconds_1);

        //open bookmarks page
        ClickUIElementByID("Bookmark");
        Thread.sleep(milliseconds_1);
        bookmarkTwoMoreOptionsMenu.click();
        Thread.sleep(milliseconds_1);

        //bookmark two rename cancel
        bookmarkRename.click();
        //get bookmark name
        WebElement newBookmarkName = driver.findElementById("android:id/input");

        //Same ID for (rename > ok) and (delete > delete)
        WebElement ok = driver.findElementById("org.lds.ldssa.dev:id/md_buttonDefaultPositive");
        //Same ID for (rename > cancel) and (delete > cancel)
        WebElement cancel = driver.findElementById("org.lds.ldssa.dev:id/md_buttonDefaultNegative");
        cancel.click();

        //bookmark two rename ok
        bookmarkTwoMoreOptionsMenu.click();
        Thread.sleep(milliseconds_1);
        bookmarkRename.click();
        Thread.sleep(milliseconds_1);
        sendText("android:id/input", "Hello World");
        //add checks for name
        ok.click();
        Thread.sleep(milliseconds_1);

        //bookmark two delete cancel
        bookmarkTwoMoreOptionsMenu.click();
        Thread.sleep(milliseconds_1);
        bookmarkDelete.click();
        Thread.sleep(milliseconds_1);
        cancel.click();
        Thread.sleep(milliseconds_1);

        //bookmark two delete > delete
        bookmarkTwoMoreOptionsMenu.click();
        Thread.sleep(milliseconds_1);
        bookmarkDelete.click();
        Thread.sleep(milliseconds_1);
        ok.click();
        //add check for delete
        Thread.sleep(milliseconds_1);


        //all items in more options menu for bookmark one

        bookmarkOneMoreOptionsMenu.click();

        //Update bookmark one
        bookmarkUpdate.click();
        Thread.sleep(milliseconds_1);

        //open bookmarks page
        ClickUIElementByID("Bookmark");
        Thread.sleep(milliseconds_1);
        bookmarkOneMoreOptionsMenu.click();
        Thread.sleep(milliseconds_1);

        //bookmark one rename ok
        bookmarkRename.click();
        Thread.sleep(milliseconds_1);
        sendText("android:id/input", "Hello World");
        //add checks for name
        ok.click();
        Thread.sleep(milliseconds_1);

        //bookmark one rename cancel
        bookmarkOneMoreOptionsMenu.click();
        Thread.sleep(milliseconds_1);
        bookmarkRename.click();
        Thread.sleep(milliseconds_1);
        cancel.click();
        Thread.sleep(milliseconds_1);

        //bookmark one delete cancel
        bookmarkOneMoreOptionsMenu.click();
        Thread.sleep(milliseconds_1);
        bookmarkDelete.click();
        Thread.sleep(milliseconds_1);
        cancel.click();
        Thread.sleep(milliseconds_1);

        //bookmark one delete > delete
        bookmarkOneMoreOptionsMenu.click();
        Thread.sleep(milliseconds_1);
        bookmarkDelete.click();
        Thread.sleep(milliseconds_1);
        ok.click();
        //add check for delete
        Thread.sleep(milliseconds_5);



















    }

}
