package org.daniels.examples.dropwizard.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.daniels.examples.dropwizard.core.Saying;
import org.daniels.examples.dropwizard.views.SayingView;

import com.codahale.metrics.annotation.Timed;

@Path("/saying/{id}")
@Produces(MediaType.TEXT_HTML)
public class SayingResource {

    public SayingResource() {
    }

	@GET
	@Timed
	public SayingView getSaying(@PathParam("id") Long id) {
		return new SayingView(new Saying(id, "do something: " + id));
	}
}

