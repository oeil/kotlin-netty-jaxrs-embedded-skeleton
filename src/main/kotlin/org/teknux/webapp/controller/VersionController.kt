package org.teknux.webapp.controller

import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType.APPLICATION_JSON

@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@Path("/api/version")
class VersionController {

    @GET
    fun get(): String {
        return "0.1.0"
    }
}