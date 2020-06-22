package com.ssc.shop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.ssc.shop.dao.UserDao;
import com.ssc.shop.dao.UserDaoImpl;
import com.ssc.shop.model.UserInfo;
import com.sun.jersey.api.view.Viewable;

@Path("/hello")
public class RestController {
	
	UserDao userDao=new UserDaoImpl();
	/*
	 * @GET
	 * 
	 * @Path("/{name}") public Response getMsg(@PathParam("name") String name) {
	 * String output = "Welcome   : " + name; return
	 * Response.status(200).entity(output).build();
	 * 
	 * }
	 */
	@GET
	@Path("/view")
    @Produces(MediaType.TEXT_HTML)
    public Viewable index() {      
	      List<UserInfo> info = userDao.getAllUsers();
	      String result=new Gson().toJson(info);
	      Map<String, List<UserInfo>> params = new HashMap();
	      params.put("result", info);
        return new Viewable("/home", params);
    }
	
	@GET
	@Path("/all")
	public String show() {
//		UserDao service=new UserDaoImpl();
	      List<UserInfo> info = userDao.getAllUsers();
	      String result=new Gson().toJson(info);
	      return result;
	}

	@GET
	@Path("/user/{id}")
	public String getUser(@PathParam("id") Integer id) {
	      UserInfo info = userDao.getUserById(id);
	      String result=new Gson().toJson(info);
	      return result;
	}
	
	
}
