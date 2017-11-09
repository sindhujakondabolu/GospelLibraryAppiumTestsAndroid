import com.sun.tools.xjc.gen.Var;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.lang.model.element.Element;
import java.net.URL;

public class GospelLibrary {
    AppiumDriver driver;

    @Before
    public void setUp() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("app", "/Users/dexterdrysdale/Documents/GitHub/GospelLibraryAppiumTestsAndroid/APK/gospel-library-alpha-43005.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    //Enter Text to a field by ID
    //click field, clear field, enter text
    public void sendText(String elementID, String text) throws Exception {
        WebElement textfield = driver.findElementById(elementID);
        textfield.click();
        textfield.clear();
        textfield.sendKeys(text);
        Thread.sleep(1000);
    }

    //Login with
    String user = "support2";
    String password = "ldssaldssa";



    @Test
    public void skipTips() throws InterruptedException {
        Thread.sleep(3000);
        Boolean isPresent = driver.findElements(By.id("org.lds.ldssa.dev:id/tipToolbar")).size() > 0;
        while ((isPresent)) {
            System.out.println("Tips Screen is Present");
            //click on skip
            WebElement skipTips = driver.findElement(By.id("org.lds.ldssa.dev:id/skip"));
            skipTips.click();
            isPresent = driver.findElements(By.id("org.lds.ldssa.dev:id/tipToolbar")).size() > 0;
        }

    }

    @Test
    public void skipLogin() throws InterruptedException {

        skipTips();
        //click skip
        Thread.sleep(1000);
        WebElement skipLogin = driver.findElementById("org.lds.ldssa.dev:id/done");
        skipLogin.click();
        Thread.sleep(3000);
    }

    @Test
    public void allTips() throws InterruptedException {

        Thread.sleep(3000);
        Boolean isPresent = driver.findElements(By.id("org.lds.ldssa.dev:id/tipToolbar")).size() > 0;
        while ((isPresent)) {
            System.out.println("Element is Present");
            WebElement tipToolbar = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView");
            //Expected
            String tipToolbarTitle = "What’s New";
            //Actual
            String tipToolbarAsText = tipToolbar.getText();
            Assert.assertEquals(tipToolbarTitle, tipToolbarAsText);
            WebElement next = driver.findElementById("org.lds.ldssa.dev:id/next");
            next.click();
            Thread.sleep(1000);
            isPresent = driver.findElements(By.id("org.lds.ldssa.dev:id/tipToolbar")).size() > 0;
        }

    }

    @Test
    public void login() throws Exception {
        skipTips();
        sendText("org.lds.ldssa.dev:id/usernameEditText", user);
        sendText("org.lds.ldssa.dev:id/passwordEditText", password);
        WebElement signIn = driver.findElementById("org.lds.ldssa.dev:id/ldsAccountSignInButton");
        signIn.click();
        Thread.sleep(1000);


    }

    @Test
    public void Bookmarks() throws Exception {

        skipLogin();

        //click Scriptures
        WebElement Scriptures = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView");
        Scriptures.click();
        Thread.sleep(1000);

        //click Book of Mormon
        WebElement BoM = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[3]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView");
        BoM.click();
        Thread.sleep(1000);

        //click 1 Nephi
        WebElement firstNephi = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        firstNephi.click();
        Thread.sleep(1000);

        //click chapter
        WebElement chapter = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        chapter.click();
        Thread.sleep(1000);

        //get book and chapter title
        WebElement chapterTitle = driver.findElementById("org.lds.ldssa.dev:id/mainToolbarTitleTextView");
        String chapterTitleAsText = chapterTitle.getText();

        //click bookmark
        WebElement bookmark = driver.findElementById("org.lds.ldssa.dev:id/menu_item_bookmark");
        bookmark.click();
        Thread.sleep(1000);

        //click new bookmark
        WebElement newBookmark = driver.findElementById("org.lds.ldssa.dev:id/locationsFab");
        newBookmark.click();
        Thread.sleep(1000);

        //Verify Bookmark text is same as book and chapter title
        WebElement actualBookmarkTitle = driver.findElementById("android:id/input");
        String actualBookmarkTitleAsText = actualBookmarkTitle.getText();
        //System.out.println(chapterTitleAsText);
        //System.out.println(actualBookmarkTitle.getText());
        Assert.assertEquals(chapterTitleAsText, actualBookmarkTitleAsText);
        Thread.sleep(2000);

        //Click add
        WebElement add = driver.findElementById("org.lds.ldssa.dev:id/md_buttonDefaultPositive");
        add.click();

        //Verify that the new bookmark name matches
        WebElement completedBookmarkTitle = driver.findElementById("org.lds.ldssa.dev:id/titleTextView");
        String completedBookmarkTitleAsText = completedBookmarkTitle.getText();
        Assert.assertEquals(chapterTitleAsText, completedBookmarkTitleAsText);

        //Navigate back
        WebElement back = driver.findElementById("Navigate up");
        back.click();
        Thread.sleep(2000);

        //Check for sign in popup
        WebElement signInPopupTitle = driver.findElementById("org.lds.ldssa.dev:id/md_title");
        String signInPopupTitleAsText = signInPopupTitle.getText();
        //Verify Title is "Back Up Annotations"
        Assert.assertEquals(signInPopupTitleAsText, "Back Up Annotations");
        Thread.sleep(1000);

        //Click "No Thanks"
        WebElement noThanks = driver.findElementById("org.lds.ldssa.dev:id/md_buttonDefaultNegative");
        noThanks.click();

        //Verify that the bookmark icon is present
        WebElement bookMarkIcon = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.support.v4.view.ViewPager/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[23]\n");

        back.click();
        Thread.sleep(1000);
        back.click();
        Thread.sleep(1000);

        //Open Bookmarks Tab
        WebElement bookMarkPage = driver.findElementByAccessibilityId("Bookmark");
        bookMarkPage.click();
        Thread.sleep(1000);

        //Verify that the bookmark is titled correctly
        completedBookmarkTitleAsText = completedBookmarkTitle.getText();
        Assert.assertEquals(chapterTitleAsText, completedBookmarkTitleAsText);

        //Click the Bookmark
        completedBookmarkTitle.click();
        Thread.sleep(1000);

        //Verify that navigation goes to the bookmark location
        Assert.assertEquals(completedBookmarkTitleAsText, chapterTitle.getText());

        //Open Nav Bar
        chapterTitle.click();
        Thread.sleep(1000);

        //Click Library
        WebElement library = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[4]/android.widget.TextView");
        library.click();
        Thread.sleep(1000);

        //Click General Conference
        WebElement generalConference = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[3]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView");
        //Opens the Conference catalog
        generalConference.click();
        Thread.sleep(1000);

        //Click on the latest conference
        WebElement latestConference = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView");
        //downloads the latest conference
        latestConference.click();
        Thread.sleep(2000);
        //opens the conference
        latestConference.click();
        Thread.sleep(1000);

        //Click on a talk
        WebElement talk = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        String talkTitleAsText = talk.getText();
        talk.click();
        Thread.sleep(2000);

        //open bookmarks tab
        bookMarkPage.click();
        newBookmark.click();
        String actualBookmarkTitleAsText2 = actualBookmarkTitle.getText();
        //Checks that the name of the bookmark matches the talk title
        Assert.assertEquals(actualBookmarkTitleAsText2, talkTitleAsText);
        add.click();
        back.click();
        Thread.sleep(1000);

        chapterTitle.click();
        Thread.sleep(1000);
        library = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[3]");
        library.click();
        Thread.sleep(1000);

        //Open the bookmarks tab
        bookMarkPage.click();
        Thread.sleep(1000);

        //create web elemets and title stings for the first and second bookmarks on the page
        WebElement bookmarkOne = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]");
        WebElement bookmarkOneMoreOptionsMenu = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.ImageButton");
        WebElement bookmarkTwo = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]");
        WebElement bookmarkTwoMoreOptionsMenu = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.ImageButton");
        String bookmarkOneTitleAsText = bookmarkOne.getText();
        String bookmarkTwoTitleAsText = bookmarkTwo.getText();

        //click the first bookmark on the page
        bookmarkOne.click();
        Thread.sleep(1000);

        //Open the bookmarks tab
        bookMarkPage.click();
        Thread.sleep(1000);
        //click the second bookmark on the page
        bookmarkTwo.click();
        Thread.sleep(1000);

        //Open the bookmarks tab
        bookMarkPage.click();
        Thread.sleep(1000);
        //click the More Options Menu for bookmarkTwo
        bookmarkTwoMoreOptionsMenu.click();
        Thread.sleep(1000);

        //create webelements for the more options menu items
        WebElement bookmarkUpdate = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView");
        WebElement bookmarkRename = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView");
        WebElement bookmarkDelete = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.TextView");

        //all items in more options menu for bookmark two
        bookmarkUpdate.click();
        Thread.sleep(1000);

        //open bookmarks page
        bookMarkPage.click();
        Thread.sleep(1000);
        bookmarkTwoMoreOptionsMenu.click();
        Thread.sleep(1000);

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
        Thread.sleep(1000);
        bookmarkRename.click();
        Thread.sleep(1000);
        sendText("android:id/input", "Hello World");
        //add checks for name
        ok.click();
        Thread.sleep(1000);

        //bookmark two delete cancel
        bookmarkTwoMoreOptionsMenu.click();
        Thread.sleep(1000);
        bookmarkDelete.click();
        Thread.sleep(1000);
        cancel.click();
        Thread.sleep(1000);

        //bookmark two delete > delete
        bookmarkTwoMoreOptionsMenu.click();
        Thread.sleep(1000);
        bookmarkDelete.click();
        Thread.sleep(1000);
        ok.click();
        //add check for delete
        Thread.sleep(1000);


        //all items in more options menu for bookmark one

        bookmarkOneMoreOptionsMenu.click();

        //Update bookmark one
        bookmarkUpdate.click();
        Thread.sleep(1000);

        //open bookmarks page
        bookMarkPage.click();
        Thread.sleep(1000);
        bookmarkOneMoreOptionsMenu.click();
        Thread.sleep(1000);

        //bookmark one rename ok
        bookmarkRename.click();
        Thread.sleep(1000);
        sendText("android:id/input", "Hello World");
        //add checks for name
        ok.click();
        Thread.sleep(1000);

        //bookmark one rename cancel
        bookmarkOneMoreOptionsMenu.click();
        Thread.sleep(1000);
        bookmarkRename.click();
        Thread.sleep(1000);
        cancel.click();
        Thread.sleep(1000);

        //bookmark one delete cancel
        bookmarkOneMoreOptionsMenu.click();
        Thread.sleep(1000);
        bookmarkDelete.click();
        Thread.sleep(1000);
        cancel.click();
        Thread.sleep(1000);

        //bookmark one delete > delete
        bookmarkOneMoreOptionsMenu.click();
        Thread.sleep(1000);
        bookmarkDelete.click();
        Thread.sleep(1000);
        ok.click();
        //add check for delete
        Thread.sleep(5000);



















    }

}
