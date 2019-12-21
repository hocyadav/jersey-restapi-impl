package com.mkyong.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/aliens")
public class AlienResource {
	
	static AlienDAO_Repository repo = new AlienDAO_Repository();
	
	@GET //Get is for fetching/getting a OLD resource
	@Produces( {MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON} )
	public List<Alien> funForList() {//this method is sending response
		
		System.out.println("inside fun");
		return repo.getList();
	}
	
	
	@GET
	@Path("/alien/1001")
	@Produces( {MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON} )
	public Alien oneDataFromDB() {
		
		Alien t = new Alien();
		t.id = 99;
		t.name = "aisha";
		
		if(repo.getByID(1001) != null)
			t = repo.getByID(1001);
		
		return t;
		
	}

	
	@POST //Post is for Creating a NEW resource, PUT - updating a resource , DELETE - deleting a resou
	@Path("/add")
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
	public Alien funForSingleList(Alien a1) {
		
		System.out.println("Post data from postman : "+a1);
		
		System.out.println(AlienDAO_Repository.listAliens.size());
		repo.createAlien(a1);
		
		return a1;
	}
}
