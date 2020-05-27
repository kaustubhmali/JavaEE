package com.kkm.demoRest;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/aliens")
public class AlienResources {
	
	AlienRepository repo = new AlienRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Aliens> getAliens() {
		
		return repo.getAliens();
		
	}
	
	@GET
	@Path("alien/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Aliens getAlien(@PathParam("id") int id) {
		System.out.println(id);
		return repo.getAlien(id);
	}
	
	@POST
	@Path("createAlien")
	public Aliens createAlien(Aliens a) {
		System.out.println(a);
		repo.createAlien(a);
		return a;
	}

}
