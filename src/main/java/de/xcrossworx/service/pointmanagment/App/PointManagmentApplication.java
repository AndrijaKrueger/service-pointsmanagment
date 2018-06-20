package de.xcrossworx.service.pointmanagment.App;

import de.xcrossworx.service.pointmanagment.persistence.PointDao;
import de.xcrossworx.service.pointmanagment.resources.PointResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class PointManagmentApplication extends Application<PointManagmentConfiguration> {

    public static void main(String[] args) throws Exception {
        new PointManagmentApplication().run(args);
    }


    public void run(PointManagmentConfiguration pointManagmentConfiguration, Environment environment) throws Exception {
        final PointDao pointDao = new PointDao();

        final PointResource pointResource = new PointResource(pointDao);
        environment.jersey().register(pointResource);
    }

}
