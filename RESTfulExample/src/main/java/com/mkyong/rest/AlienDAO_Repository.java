package com.mkyong.rest;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//GET : get
//POST : insert
//PUT : update
//DELETE : delete

//This is DB MODULE --> this data is coming from db
public class AlienDAO_Repository {
	
	static List<Alien> listAliens = new LinkedList<Alien>();
	
	public AlienDAO_Repository() {
		
		Alien obj = new Alien();
		obj.id = 1001;
		obj.name = "hariom";
		
		//this data is coming from db
		Alien obj2 = new Alien();
		obj2.id = 200;
		obj2.name = "hariom yadav";
		
		listAliens.add(obj);
		listAliens.add(obj2);
		//listAliens =  Arrays.asList(obj,obj2);
	}
	
	public List<Alien> getList(){
		return listAliens;
	}
	
	public Alien getSinleNode(int id) {
		Alien t = null;
		
		Iterator<Alien> it = listAliens.iterator();
		while(it.hasNext()) {
			t = it.next();
			if(t.id == id) {
				return t;
			}
		}
		return t;
	}

	public void createAlien(Alien a1) {
		
		listAliens.add(a1);
		
		System.out.println("crateAlien(): new alien obj added to list...");
		
	}

	public Alien getByID(int i) {
		
		for(int i1=0; i1<listAliens.size(); i1++) {
			
			if(listAliens.get(i1).id == i) {
				System.out.println("found");
				return listAliens.get(i1);
			}
		}
		System.out.println("not found");
		
		return null;
	}
	
}
