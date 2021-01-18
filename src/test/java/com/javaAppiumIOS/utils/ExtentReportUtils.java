package com.javaAppiumIOS.utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.javaAppiumIOS.GlobalParameters;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import static org.apache.logging.log4j.util.PropertiesUtil.getSystemProperties;

public class ExtentReportUtils {

    public static ExtentReports EXTENT_REPORT = null;
    public static ExtentTest TEST;
    public static ExtentHtmlReporter  HTML_REPORTER = null;
    static String reportName = GlobalParameters.REPORT_NAME + "_" + Utils.getNowDate("yyyy-MM-dd_HH-mm-ss");
    static String reportsPath = GlobalParameters.REPORT_PATH;
    static String fileName = reportName+".html";
    static String fullReportFilePath = reportsPath + "/"+ reportName +"/" + fileName;
    static String fullScreenShotPath = reportsPath + "/"+ reportName;
    private static String testNameMemory = null;

    public static void createReport() {
        new GlobalParameters();
        EXTENT_REPORT = null;

        if (EXTENT_REPORT == null)
        {
            Utils.createFolderReport(reportName);
            HTML_REPORTER = new ExtentHtmlReporter(fullReportFilePath);
            EXTENT_REPORT = new ExtentReports();
            EXTENT_REPORT.attachReporter(HTML_REPORTER);
        }
    }

    public static void addTestEnvironment(){
        Properties systemProperties = getSystemProperties();

        EXTENT_REPORT.setSystemInfo("Appium Server:", GlobalParameters.AppiumServer);

        if(GlobalParameters.isAndroid){
            EXTENT_REPORT.setSystemInfo("Plataforma:",  GlobalParameters.AndroidPlatformName);
            EXTENT_REPORT.setSystemInfo("Versão:",  GlobalParameters.AndroidPlatformVersion);
            EXTENT_REPORT.setSystemInfo("App:", GlobalParameters.AndroidAppPath);
            EXTENT_REPORT.setSystemInfo("AndroidUDID:", GlobalParameters.AndroidUDID);
        }
        else{
            EXTENT_REPORT.setSystemInfo("Plataforma", GlobalParameters.IOSPlatformName);
            EXTENT_REPORT.setSystemInfo("Versão", GlobalParameters.IOSPlatformVersion);
            EXTENT_REPORT.setSystemInfo("App:", GlobalParameters.IOSBundleId);
            EXTENT_REPORT.setSystemInfo("iOSUDID:", GlobalParameters.IOSUDID);
        }

        EXTENT_REPORT.setSystemInfo("OS.Nome:",  systemProperties.getProperty("os.name"));
        EXTENT_REPORT.setSystemInfo("OS.Arq::", systemProperties.getProperty("os.arch"));
        EXTENT_REPORT.setSystemInfo("OS.Java:", systemProperties.getProperty("java.version"));
    }

    public static void addTest(String testName, String testCategory){
        testNameMemory = testName;
        TEST = EXTENT_REPORT.createTest(testName).assignCategory(testCategory.replace("Tests",""));

    }
    public static void addTestInfo(int methodLevel, String text){
        String methodName = Utils.getMethodNameByLevel(methodLevel);
        String testName = testNameMemory;
        if(GlobalParameters.GET_SCREENSHOT_FOR_EACH_STEP /*&& !GlobalParameters.isDeviceFarm*/) {
            TEST.log(Status.PASS, methodName + " || " + text, getScreenShotMedia(testName+"_"+methodName+"_"+Utils.getNowDate("yyyy-MM-dd_HH-mm-ss-SSS")));
        }else {
            TEST.log(Status.PASS, methodName + " || " + text);
        }
    }
    public static MediaEntityModelProvider getScreenShotMedia(String testName){
        String screenshotPath = Utils.getScreenshot(testName, fullScreenShotPath);
        MediaEntityModelProvider media = null;
        try {
            media = MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath.replace(fullScreenShotPath,".")).build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return media;
    }
    public static void addTestResult(ITestResult result){
        switch (result.getStatus())
        {
            case ITestResult.FAILURE:
                if(GlobalParameters.isDeviceFarm && !GlobalParameters.isLocal)
                    TEST.log(Status.FAIL, "Test Result: " + Status.FAIL + "<pre>" + "Message: " + result.getThrowable().toString() + "</pre>" + "<pre>" + "Stack Trace: " + Utils.getAllStackTrace(result) + "</pre>");
                else{
                    TEST.log(Status.FAIL, "Test Result: " + Status.FAIL + "<pre>" + "Message: " + result.getThrowable().toString() + "</pre>" + "<pre>" + "Stack Trace: " + Utils.getAllStackTrace(result) + "</pre>", getScreenShotMedia(testNameMemory));
                }

                break;
            case ITestResult.SKIP:
                TEST.log(Status.SKIP, "Test Result: " + Status.SKIP + "<pre>" + "Message: " + result.getThrowable().toString() + "</pre>" + "<pre>" + "Stack Trace: " + Utils.getAllStackTrace(result) + "</pre>", getScreenShotMedia(testNameMemory));
                break;
            default:
                TEST.log(Status.PASS, "Test Result: " + Status.PASS);
                break;
        }
    }
    public static void generateReport(){
        EXTENT_REPORT.flush();

    }
}
