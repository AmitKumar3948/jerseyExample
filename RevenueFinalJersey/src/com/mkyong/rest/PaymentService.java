package com.mkyong.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amit.entity.district;
import com.amit.services.districtService;
import com.mkyong.transaction.TransactionBo;

@Component
@Path("/payment")
public class PaymentService {

	@Autowired
	TransactionBo transactionBo;
	
	@Autowired
	private districtService distSer;

	@GET
	@Path("/mkyong")
	public Response savePayment() {

		String result = transactionBo.save();
		
		List<district> dis=distSer.getAllDistrict();
		result =dis.get(0).toString();

		return Response.status(200).entity(result).build();

	}

}