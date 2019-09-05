package UI;

//Create this file in the UI Package titled "EnvironmentConfig"
//the Environment Config File is set to GitIgnore so your environment shouldn't change when you update the project
public class EnvironmentConfigExample {

    //Appium Port
    public static String theAppiumPort = "4723";

    //Android Device UDID
    public static String theUDID = "05157df5a1394b1c";

    //Android version number
    public static int AndroidVersion = 7;

    //Build of Gospel Library
    public static String GospelLibraryBuild = "alpha";
    //    public static String GospelLibraryBuild = "preview";

    //WebView Constructor
    public static String WebView = "WEBVIEW_org.lds.ldssa." + GospelLibraryBuild + "";

    //millisecond standards
    //for slower devices use 4600, for faster devices use 1600
    public static int milliseconds_1 = 1600;
//    public static int milliseconds_1 = 2600;
//    public static int milliseconds_1 = 8600;

    public static int milliseconds_2 = milliseconds_1 * 2;
    public static int milliseconds_3 = milliseconds_1 * 3;
    public static int milliseconds_4 = milliseconds_1 * 4;
    public static int milliseconds_5 = milliseconds_1 * 5;

}
