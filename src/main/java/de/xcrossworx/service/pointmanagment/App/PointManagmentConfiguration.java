package de.xcrossworx.service.pointmanagment.App;

import io.dropwizard.Configuration;

public class PointManagmentConfiguration extends Configuration {

    private static String serviceName = "Point Managment Service";

    public static String getServicename(){
        return serviceName;
    }


}
