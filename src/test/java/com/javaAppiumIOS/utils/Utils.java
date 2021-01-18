package com.javaAppiumIOS.utils;

import com.javaAppiumIOS.GlobalParameters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.testng.ITestResult;

public class Utils {

    public static String getMethodNameByLevel(int level){
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        return stackTrace[level].getMethodName();
    }
    public static String getScreenshot(String name, String path){
        File scrFile = ((TakesScreenshot)DriveFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        String filePathAndName = path + "/" +name + ".png";
        try {
            FileUtils.copyFile(scrFile, new File(filePathAndName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePathAndName;
    }
    public static void createFolderReport(String folderName){
        File dir = new File(Utils.returnPathProjectIOS() + "/target/reports/" + folderName);
        dir.mkdir();
    }
    public static String getAllStackTrace(ITestResult result){
        String allStackTrace = "";
        for(StackTraceElement stackTrace : result.getThrowable().getStackTrace()){
            allStackTrace = allStackTrace + "<br>" + stackTrace.toString();
        }
        return allStackTrace;
    }
    public static String getNowDate(String mask){
        DateFormat dateFormat = new SimpleDateFormat(mask);
        Date date = new Date();
        return dateFormat.format(date);
    }
    public static String getFileContent(String filePath) {
        BufferedReader br=null;
        StringBuilder sb=null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            br.close();
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    public static void setContextToWebview(){
        Set<String> availableContexts = DriveFactory.getDriver().getContextHandles();
        availableContexts.stream()
                .filter(context -> context.toLowerCase().contains("webview"))
                .forEach(newcontext -> DriveFactory.getDriver().context(newcontext));
    }
    public String getDeviceDate(){
        return DriveFactory.getDriver().getDeviceTime();
    }


    public static String returnPathProject(){
        if(GlobalParameters.isLocal){
            return System.getProperty("user.dir") + "\\";
        }
        else{
            return "";
        }
    }
    public static String returnPathProjectIOS(){
        if(GlobalParameters.isLocal){
            return System.getProperty("user.dir") + "/";
        }
        else{
            return "";
        }
    }


}

