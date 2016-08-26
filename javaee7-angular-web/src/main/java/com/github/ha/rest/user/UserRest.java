package com.github.ha.rest.user;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.ha.entity.User;

@Path("/user")
public class UserRest {
	
	private static List<User> list = new ArrayList<User>();

	@GET
	@Path("/list")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response list() {
		return Response.ok(list).build();
	}

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvar(User user) {
 		list.add(user);
		return Response.ok(user).build();
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(User user) {
		//TODO
		return Response.ok(user).build();
	}

	@DELETE
	@Path("/delete/{index}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvar(@PathParam("index") int index) {
		list.remove(index);
		return Response.ok().build();
	}

}
