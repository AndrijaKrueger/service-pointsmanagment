package de.xcrossworx.service.pointmanagment.resources;

import com.codahale.metrics.annotation.Timed;
import de.xcrossworx.service.pointmanagment.handler.LogHandler;
import de.xcrossworx.service.pointmanagment.persistence.PointDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/points-resource")
@Produces(MediaType.APPLICATION_JSON)
public class PointResource {

    private PointDao pointDao;

    public PointResource(PointDao pointDao) {
        this.pointDao = pointDao;
    }

    @GET
    @Timed
    public Response checkResource(){
        String message = "Points Service is here !!!";
        LogHandler.logMessage("checkResource", "Check if the Resource is available", message);
        return Response.ok().entity(message).build();
    }

    @GET
    @Timed
    @Path("/getAll")
    public Response getAllPoints(){
        String message = "Fetch all Points from Database";
        LogHandler.logMessage("getAllPoints", message, null);
        return Response.ok().entity(pointDao.getAll()).build();
    }

}
