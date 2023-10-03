package com.opencart.configuration;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Env {

    private static final String configPath = "config.json";

    private Env(){}

    private static ISettingsFile getCurrentEnvironment(String path) {
        String envName = (String) AqualityServices.get(ISettingsFile.class).getValue("/environment");
        Path resourcePath = Paths.get("environment", envName, path);
        return new JsonSettingsFile(resourcePath.toString());
    }

    public static String getConfig(String key){
        return getCurrentEnvironment(configPath).getValue(key).toString();
    }


}
