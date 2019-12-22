package com.mkyong.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/aliens")
public class AlienResource {
	
	static AlienDAO_Repository repo = new AlienDAO_Repository();
	AlienActualPostgresDB postgresObj = new AlienActualPostgresDB();
	
	@GET //Get is for fetching/getting a OLD resource
	@Produces( {MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON} )
	public List<Alien> funForList() {//this method is sending response
		
		System.out.println("inside fun");
		return repo.getList();
	}
	
	
	@GET
	@Path("/alien/{id}")//1st
	@Produces( {MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON} )//produce means output : server to client
	public Alien oneDataFromDB(@PathParam("id") int id) {//2nd
		
		Alien t = new Alien();
//		t.id = 99;
//		t.name = "aisha";
		
		if(repo.getByID(id) != null)
			t = repo.getByID(id);
		
		return t;
		
	}
	
	@POST //Post is for Creating a NEW resource, PUT - updating a resource , DELETE - deleting a resou
	@Path("/add")
	@Consumes( {MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON} )//Consume means accept input as json + xml
	public Alien funForSingleList(Alien a1) {
		
		System.out.println("Post data from local variable : "+a1);
		
		System.out.println(AlienDAO_Repository.listAliens.size());
		repo.createAlien(a1);
		
		return a1;
	}
	
	@GET //Get is for fetching/getting a OLD resource
	@Path("/fromdb")
	@Produces( {MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON} )
	public List<Alien> funForListFromDB() {//this method is sending response
		
		System.out.println("inside fun");
		return postgresObj.getList();
		
	}
	
	@POST //Post is for Creating a NEW resource, PUT - updating a resource , DELETE - deleting a resou
	@Path("/add-db")
	//@Consumes( {MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON} )//Consume means accept input as json + xml
	public Alien funForSingleListDB(Alien a1) {
		
		System.out.println("Post data from postman : "+a1);
		
		Alien t = postgresObj.createAlien(a1);
		
		return t;
	}
	
}
