package com.javaAppiumIOS.utils;

import com.javaAppiumIOS.GlobalParameters;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.net.URL;
import static com.javaAppiumIOS.GlobalParameters.*;

public class DriveFactory {

    public static AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;
    private static String path = System.getProperty("user.dir");

    public static AppiumDriver<MobileElement> getDriver(){
        if (driver == null)
            throw new NullPointerException("The Driver instance was not initialized.");
        return driver;
    }
    public void setDriver(AppiumDriver<MobileElement> driver)
    {
        this.driver = driver;
    }
    public static void InitApp(String testName) throws IOException, InterruptedException {

        if (isAndroid)
        {
            //Se for Android e for DeviceFarm
            if(isDeviceFarm){
                String accessKey = AccessKeyBrowserStack;
                String userName = UsernameBrowserStack;
                String buildNumber = BuildNumberBrowserStack;
                String apkUploadPath = AppAndroidUploadBrowserStack;

                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("device", AndroidDeviceBrowserStack);
                caps.setCapability("os_version", AndroidOSVersionBrowserStack);
                caps.setCapability("project", AndroidProjectBrowserStack);
                caps.setCapability("build", "Android - Build ["+buildNumber+"]");
                caps.setCapability("name", testName);
                caps.setCapability("app","bs://" + apkUploadPath);
                caps.setCapability("automationName", "UiAutomator2");

                driver = new AndroidDriver<MobileElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);
            }

            //Se for Android, não for DeviceFarm
            else {
                //Se for Android, não for DeviceFarm e for utilizar o aplicativo já instalado
                if(isInstalado){
                    DesiredCapabilities caps = new DesiredCapabilities();
                    caps.setCapability(MobileCapabilityType.PLATFORM_NAME, AndroidPlatformName);
                    caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, AndroidPlatformVersion);
                    caps.setCapability(MobileCapabilityType.DEVICE_NAME, AndroidDeviceName);
                    caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, AndroidAppPackage);
                    caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, AndroidAppActivity);
                    caps.setCapability(MobileCapabilityType.BROWSER_NAME, AndroidBrowserName);
                    caps.setCapability(MobileCapabilityType.UDID, AndroidUDID);
                    caps.setCapability(MobileCapabilityType.ORIENTATION, AndroidOrientation);

                    driver = new AndroidDriver<MobileElement>(new URL(AppiumServer), caps);
                }

                //Se for Android, não for DeviceFarm e for utilizado um apk
                else{
                    DesiredCapabilities caps = new DesiredCapabilities();
                    caps.setCapability(MobileCapabilityType.PLATFORM_NAME, AndroidPlatformName);
                    caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, AndroidPlatformVersion);
                    caps.setCapability(MobileCapabilityType.DEVICE_NAME, AndroidDeviceName);
                    caps.setCapability(MobileCapabilityType.APP, AndroidAppPath);
                    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
                    caps.setCapability(MobileCapabilityType.UDID, AndroidUDID);
                    caps.setCapability(MobileCapabilityType.NO_RESET, AndroidNoReset);
                    caps.setCapability(MobileCapabilityType.FULL_RESET, AndroidFullReset);
                    caps.setCapability(MobileCapabilityType.ORIENTATION, AndroidOrientation);

                    driver = new AndroidDriver<MobileElement>(new URL(AppiumServer), caps);
                }
            }
        }

        //Se for iOS
        else {
            //Se for iOS e for DeviceFarm
            if(isDeviceFarm){
                String accessKey = AccessKeyBrowserStack;
                String userName = UsernameBrowserStack;
                String buildNumber = BuildNumberBrowserStack;
                String ipaUploadPath = AppIOSUploadBrowserStack;

                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("device", IOSDeviceBrowserStack);
                caps.setCapability("os_version", IOSOSVersionBrowserStack);
                caps.setCapability("project", IOSProjectBrowserStack);
                caps.setCapability("build", "iOS - Build ["+buildNumber+"]");
                caps.setCapability("name", testName);
                caps.setCapability("app","bs://" + ipaUploadPath);
                caps.setCapability("automationName", "XCUITest");
                caps.setCapability("autoAcceptAlerts", "true");
                caps.setCapability(IOSMobileCapabilityType.START_IWDP, "true");

                driver = new IOSDriver<MobileElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);
            }

            //Se for iOS e não for DeviceFarm
            else {

                //Se for iOS, não for DeviceFarm e for MacOS (Appium puro)
                if(isMacOS){

                    DesiredCapabilities caps = new DesiredCapabilities();
                    caps.setCapability(MobileCapabilityType.DEVICE_NAME, IOSDeviceName);
                    caps.setCapability(IOSMobileCapabilityType.PLATFORM_NAME, IOSPlatformName);
                    caps.setCapability(IOSMobileCapabilityType.VERSION, IOSPlatformVersion);
                    caps.setCapability(MobileCapabilityType.APP, IOSAppPath);
                    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                    caps.setCapability(MobileCapabilityType.UDID, IOSUDID);
                    caps.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, IOSAuto_Accept_Alerts);
                    caps.setCapability(IOSMobileCapabilityType.SEND_KEY_STRATEGY, IOSSendKeyStrategy);

                    caps.setCapability(MobileCapabilityType.NO_RESET, AndroidNoReset);
                    caps.setCapability(MobileCapabilityType.FULL_RESET, AndroidFullReset);
                    caps.setCapability(IOSMobileCapabilityType.START_IWDP, "true");
                    caps.setCapability(IOSMobileCapabilityType.WDA_LAUNCH_TIMEOUT,"240000");
                    caps.setCapability(IOSMobileCapabilityType.WDA_CONNECTION_TIMEOUT, "240000");
                    caps.setCapability(IOSMobileCapabilityType.XCODE_ORG_ID, IOSXcodeCodeId);
                    caps.setCapability(IOSMobileCapabilityType.XCODE_SIGNING_ID,"iPhone Developer");
                    caps.setCapability(IOSMobileCapabilityType.USE_NEW_WDA, "true");


                }
                //se for simulador de IOS
                if(isIosSimulator){

                    DesiredCapabilities caps = new DesiredCapabilities();
                    caps.setCapability("deviceName", IOSDeviceName);
                    caps.setCapability("platformName", IOSPlatformName);
                    caps.setCapability("platformVersion", IOSPlatformVersion);
                    caps.setCapability("app", IOSAppPath);
                    caps.setCapability("automationName", "XCUITest");
                    caps.setCapability("sendKeysStrategy", IOSSendKeyStrategy);

                    driver = new IOSDriver<MobileElement>(new URL(GlobalParameters.AppiumServer), caps);
                }

                //Se for iOS, não for DeviceFarm e for Appium Studio/Appium
                else {
                    DesiredCapabilities caps = new DesiredCapabilities();
                    caps.setCapability(MobileCapabilityType.DEVICE_NAME, IOSDeviceName);
                    caps.setCapability(IOSMobileCapabilityType.PLATFORM_NAME, IOSPlatformName);
                    caps.setCapability(IOSMobileCapabilityType.VERSION, IOSPlatformVersion);
                    caps.setCapability(MobileCapabilityType.APP, IOSAppPath);
                    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                    //caps.setCapability(MobileCapabilityType.UDID, IOSUDID);
                    caps.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, IOSAuto_Accept_Alerts);
                    caps.setCapability(IOSMobileCapabilityType.SEND_KEY_STRATEGY, IOSSendKeyStrategy);
                    caps.setCapability(MobileCapabilityType.NO_RESET, AndroidNoReset);
                    caps.setCapability(MobileCapabilityType.FULL_RESET, AndroidFullReset);
                    caps.setCapability(IOSMobileCapabilityType.START_IWDP, "true");
                    caps.setCapability(IOSMobileCapabilityType.WDA_LAUNCH_TIMEOUT, "240000");
                    caps.setCapability(IOSMobileCapabilityType.WDA_CONNECTION_TIMEOUT, "240000");
                    caps.setCapability("report.disable",true);

                    driver = new IOSDriver<MobileElement>(new URL(AppiumServer), caps);

                }
            }
        }
    }
}
