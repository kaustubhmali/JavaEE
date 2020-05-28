package com.kkm.demoRest;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/aliens")
public class AlienResources {
	
	AlienRepository repo = new AlienRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Aliens> getAliens() {
		
		return repo.getAliens();
		
	}
	
	@GET
	@Path("alien/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Aliens getAlien(@PathParam("id") int id) {
		System.out.println(id);
		return repo.getAlien(id);
	}
	
	@POST
	@Path("createAlien")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Aliens createAlien(Aliens a) {
		System.out.println(a);
		repo.createAlien(a);
		return a;
	}
	
	@PUT
	@Path("updateAlien")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Aliens updateAlien(Aliens a ) {
		System.out.println(a);
		repo.updateAlien(a);
		return a;
	}
	
	@DELETE
	@Path("deleteAlien/{id}")
	public Aliens deleteAlien(@PathParam("id") int id) {
		Aliens a = repo.getAlien(id);
		if (a.getId()!=0)
			repo.delelteAlien(id);
		
		return a;
	}

}
