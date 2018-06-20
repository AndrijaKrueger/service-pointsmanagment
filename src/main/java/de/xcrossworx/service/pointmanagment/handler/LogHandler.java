package de.xcrossworx.service.pointmanagment.handler;

import de.xcrossworx.service.pointmanagment.App.PointManagmentConfiguration;
import de.xcrossworx.service.pointmanagment.model.Dto.LogMessage;
import de.xcrossworx.service.pointmanagment.model.Dto.LogType;

public class LogHandler {

    public static void logMessage(String method, String message, String jsonData) {
        new Thread(new LogDataRunnable(new LogMessage(PointManagmentConfiguration.getServicename(), LogType.INFO, method, message, jsonData, null, null))).start();
    }

    public static void logErrorMessage(String method, Exception ex) {
        StringBuilder builder = new StringBuilder();

        for (StackTraceElement stackTraceElement : ex.getStackTrace()) {
            builder.append(stackTraceElement.toString()+ "\n");
        }

        new Thread(new LogDataRunnable(new LogMessage(PointManagmentConfiguration.getServicename(), LogType.ERROR, method, null, null, ex.getMessage(), builder.toString()))).start();
    }
}
