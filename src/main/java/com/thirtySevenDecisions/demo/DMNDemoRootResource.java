package com.thirtySevenDecisions.demo;

import javax.ws.rs.Path;
import javax.ws.rs.GET;

@Path("")
public class DMNDemoRootResource {

    @Path("/health")
    @GET
    public String healthcheck() {
        return "Ok";
    }
}