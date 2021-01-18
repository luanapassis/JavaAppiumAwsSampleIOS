package com.javaAppiumIOS.utils;

import com.javaAppiumIOS.GlobalParameters;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BuilderAppium {

    AppiumDriverLocalService service;
    AppiumServiceBuilder builder;

    public void StartAppiumService(){
        builder = new AppiumServiceBuilder();
        builder.withIPAddress(GlobalParameters.AppiumIPAddress);
        builder.usingPort(GlobalParameters.AppiumPort);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
    }

    public void StopAppiumService(){
        service.stop();
    }
}
