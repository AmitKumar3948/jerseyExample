package com.mkyong.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.amit.entity.district;
import com.amit.services.districtService;
import com.mkyong.transaction.TransactionBo;


@Component
@Path("/user")
public class UserService {

	
	@Autowired
	TransactionBo transactionBo;
	
	@Autowired
	private districtService distSer;
	
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public district getSomeList() {
		
		List<district> dis=distSer.getAllDistrict();
	    
		district d=dis.get(0);
		return d;
	}
	
	
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(district dis) {
		
		//return Response.status(200)
			//	.entity("addUser is called, name : " + name + ", age : " + age)
				//.build();
		
		String result = "Track saved : " + dis;
		return Response.status(201).entity(result).build();

	}

}