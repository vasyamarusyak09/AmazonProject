package com.atqa2020.framework.utils;

import org.testng.Reporter;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Helper {

    public static class Logger {

        public static void LogInfo(String logText) {
            String logInfo = ("INFO: [" + logText + "]");
            //Output to TestNG log and Standard log
            Reporter.log(logInfo, true);
        }

        public static void LogError(String logText) {
            String logErr = ("ERROR: [" + logText + "]");
            //Output to TestNG log and Standard log
            Reporter.log(logErr, true);
        }

        public static void LogError(String logText, Exception e) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);

            String logErr = ("ERROR: [" + logText + "]\n" +
                    stringWriter.toString());

            //Output to TestNG log and Standard log
            Reporter.log(logErr, true);
        }
    }
}
