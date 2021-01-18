package com.javaAppiumIOS;

import com.javaAppiumIOS.utils.Utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GlobalParameters {

    public static String BROWSER_DEFAULT;
    public static String EXECUTION;
    public static int TIMEOUT_DEFAULT;
    public static String SELENIUM_HUB;
    public static String URL_DEFAULT;
    public static String REPORT_NAME;
    public static boolean GET_SCREENSHOT_FOR_EACH_STEP;
    public static String DOWNLOAD_DEFAULT_PATH;
    public static String REPORT_PATH;
    public static String DB_URL;
    public static String DB_SID;
    public static String DB_USER;
    public static String DB_PASSWORD;

    public static String AppiumIPAddress;
    public static int AppiumPort;
    public static boolean isAndroid;
    public static boolean isDeviceFarm;
    public static boolean isLocal;
    public static boolean isInstalado;
    public static boolean isMacOS;
    public static boolean isEmulador;
    public static boolean isIosSimulator;

    public static String AccessKeyBrowserStack;
    public static String UsernameBrowserStack;
    public static String BuildNumberBrowserStack;
    public static String AppAndroidUploadBrowserStack;
    public static String AppIOSUploadBrowserStack;

    public static String AndroidDeviceName;
    public static String AndroidUDID;
    public static String AndroidPlatformName;
    public static String AndroidPlatformVersion;
    public static String AndroidAppPackage;
    public static String AndroidAppActivity;
    public static String AppiumServer;
    public static String AndroidAppPath;
    public static String AndroidBrowserName;
    public static String AndroidNoReset;
    public static String AndroidFullReset;
    public static String AndroidOrientation;

    public static String IOSPlatformName;
    public static String IOSPlatformVersion;
    public static String IOSBundleId;
    public static String IOSAppPath;
    public static String IOSUDID;
    public static String IOSNoReset;
    public static String IOSFullReset;
    public static String IOSSendKeyStrategy;
    public static String IOSAuto_Accept_Alerts;
    public static String IOSDeviceName;
    public static String IOSXcodeCodeId;

    public static String IOSDeviceBrowserStack;
    public static String IOSOSVersionBrowserStack;
    public static String IOSProjectBrowserStack;

    public static String AndroidDeviceBrowserStack;
    public static String AndroidOSVersionBrowserStack;
    public static String AndroidProjectBrowserStack;


    private Properties properties;

    public GlobalParameters(){
        properties = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("globalParameters.properties");
            properties.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BROWSER_DEFAULT = properties.getProperty("browser.default");
        EXECUTION = properties.getProperty("execution");
        TIMEOUT_DEFAULT = Integer.parseInt(properties.getProperty("timeout.default"));
        SELENIUM_HUB = properties.getProperty("selenium.hub");
        URL_DEFAULT = properties.getProperty("url.default");
        REPORT_NAME = properties.getProperty("report.name");
        GET_SCREENSHOT_FOR_EACH_STEP = Boolean.parseBoolean(properties.getProperty("get.screenshot.for.each.step"));
        DOWNLOAD_DEFAULT_PATH = properties.getProperty("download.defaul.path");
        REPORT_PATH = properties.getProperty("report.path");
        DB_URL = properties.getProperty("db.url");
        DB_SID = properties.getProperty("db.sid");
        DB_USER = properties.getProperty("db.user");
        DB_PASSWORD = properties.getProperty("db.password");

        //Appium Region
        AppiumServer = properties.getProperty("AppiumServer");
        AppiumIPAddress = properties.getProperty("AppiumIPAddress");
        AppiumPort = Integer.parseInt(properties.getProperty("AppiumPort"));

        isEmulador = Boolean.parseBoolean(properties.getProperty("isEmulador"));
        isAndroid = Boolean.parseBoolean(properties.getProperty("isAndroid"));
        isDeviceFarm = Boolean.parseBoolean(properties.getProperty("isDeviceFarm"));
        isLocal = Boolean.parseBoolean(properties.getProperty("isLocal"));
        isInstalado = Boolean.parseBoolean(properties.getProperty("isInstalado"));
        isMacOS = Boolean.parseBoolean(properties.getProperty("isMacOS"));
        isIosSimulator = Boolean.parseBoolean(properties.getProperty("isIosSimulator"));

        //BrowserStack Region
        AccessKeyBrowserStack = properties.getProperty("AccessKeyBrowserStack");
        UsernameBrowserStack = properties.getProperty("UsernameBrowserStack");
        BuildNumberBrowserStack = properties.getProperty("BuildNumberBrowserStack");
        AppAndroidUploadBrowserStack = properties.getProperty("AppAndroidUploadBrowserStack");
        AppIOSUploadBrowserStack = properties.getProperty("AppIOSUploadBrowserStack");

        IOSDeviceBrowserStack = properties.getProperty("IOSDeviceBrowserStack");
        IOSOSVersionBrowserStack = properties.getProperty("IOSOSVersionBrowserStack");
        IOSProjectBrowserStack = properties.getProperty("IOSProjectBrowserStack");

        AndroidDeviceBrowserStack = properties.getProperty("AndroidDeviceBrowserStack");
        AndroidOSVersionBrowserStack = properties.getProperty("AndroidOSVersionBrowserStack");
        AndroidProjectBrowserStack = properties.getProperty("AndroidProjectBrowserStack");

        //Android Region
        AndroidDeviceName  = properties.getProperty("AndroidDeviceName");
        AndroidUDID= properties.getProperty("AndroidUDID");
        AndroidPlatformName= properties.getProperty("AndroidPlatformName");
        AndroidPlatformVersion= properties.getProperty("AndroidPlatformVersion");
        AndroidAppPackage= properties.getProperty("AndroidAppPackage");
        AndroidAppActivity= properties.getProperty("AndroidAppActivity");
        AndroidAppPath = Utils.returnPathProject()+"\\src\\test\\java\\com\\templateJavaAppium\\resources\\app\\android\\"+properties.getProperty("AndroidApp");
        AndroidBrowserName=properties.getProperty("AndroidBrowserName");
        AndroidNoReset=properties.getProperty("AndroidNoReset");
        AndroidFullReset=properties.getProperty("AndroidFullReset");
        AndroidOrientation=properties.getProperty("AndroidOrientation");

        //iOS Region
        IOSPlatformName  = properties.getProperty("IOSPlatformName");
        IOSPlatformVersion= properties.getProperty("IOSPlatformVersion");
        IOSBundleId= properties.getProperty("IOSBundleId");
        IOSUDID= properties.getProperty("IOSUDID");
        IOSAuto_Accept_Alerts = properties.getProperty("IOSAuto_Accept_Alerts");
        IOSDeviceName = properties.getProperty("IOSDeviceName");
        IOSNoReset= properties.getProperty("IOSNoReset");
        IOSFullReset= properties.getProperty("IOSFullReset");
        IOSAppPath = Utils.returnPathProjectIOS()+"src/test/java/com/javaAppiumIOS/resources/app/ios/"+properties.getProperty("IOSAppPath");

        IOSSendKeyStrategy=properties.getProperty("IOSSendKeyStrategy");
        IOSXcodeCodeId = properties.getProperty("IOSXcodeCodeId");

    }
}
