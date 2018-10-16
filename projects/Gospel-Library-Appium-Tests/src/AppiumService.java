
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.io.FileOutputStream;

public class AppiumService {
	public static AppiumDriverLocalService myAppiumService;


	public static void startAppiumService(String os, int myPort) throws Exception {
		System.out.println("OS: " + os);
		System.out.println("PORT: " + myPort);

		System.out.println("Creating Appium Service");
		File appiumLogFile = new File("screenshot/myAppiumLog.txt");
		new FileOutputStream(appiumLogFile, false).close();
		myAppiumService = new AppiumServiceBuilder()
				.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.usingPort(myPort)
				.withIPAddress("127.0.0.1")
				.withLogFile(appiumLogFile)
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
				.withArgument(GeneralServerFlag.LOG_LEVEL, "error")
				.build();
		System.out.println("Starting Appium");
		myAppiumService.start();
		Thread.sleep(3000);

	}
	
	public boolean appiumServiceRunning() {
		boolean runningStatus = false;
		
		runningStatus = myAppiumService.isRunning();
		System.out.println("Appium Service Running: " + runningStatus);
		
		return runningStatus;
		
	}
	
	public String appiumServiceURL() {
		String stringURL;
		
		stringURL = myAppiumService.getUrl().toString();
		System.out.println("Appium Service URL: " + stringURL);
		
		return stringURL;
		
	}
	
	public void stopAppiumService() {
		myAppiumService.stop();
	}

}