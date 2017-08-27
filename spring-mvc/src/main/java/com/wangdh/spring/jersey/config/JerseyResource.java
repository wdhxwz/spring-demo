package com.wangdh.spring.jersey.config;

import java.util.Random;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wangdh.spring.mvc.models.User;
import com.wangdh.spring.mvc.service.UserService;

@Path("jersey")
@Produces({ MediaType.APPLICATION_JSON })
//@RequestScoped
//@PerLookup
@Singleton
public class JerseyResource {
	private static final Logger LOGGER = LoggerFactory.getLogger(JerseyResource.class);

	@Autowired
	private UserService userService;

	@Inject
	private DateTimeService timeService;

	public JerseyResource() {
		LOGGER.info("HelloWorldResource()");
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getHello() {
		User user = userService.get("1");
		if (user != null) {
			return String.format("%s: %s", timeService.getDateTime(), user.getUserName());
		}

		return String.format("%s: %s", timeService.getDateTime(), "wangdh");
	}

	public static final String MESSAGE = "Hello World!";

	@GET
	@Path("/helloWorld")
	@Produces({ MediaType.APPLICATION_JSON })
	public String helloWorld() {
		return MESSAGE;
	}

	@GET
	@Path("user/{userId}")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public User getUser(@PathParam("userId") String userId) {
		return userService.get(userId);
	}
	
	private static final Random random = new Random();
	
	@GET
	@Path("getUser")
	@Produces({ MediaType.APPLICATION_JSON })
	public User get(@Context UriInfo uriInfo , @Context HttpHeaders httpHeaders){
		MultivaluedMap<String, String> pathParams = uriInfo.getPathParameters();
		MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
		String key = "userId";
		String userId = pathParams.getFirst(key);
		if(StringUtils.isEmpty(userId)){
			userId = queryParams.getFirst(key);
		}
		if(StringUtils.isEmpty(userId)){
			return null;
		}
		
		User user = userService.get(userId);
		if(user == null){
			user = new User();
			user.setId(userId);
			user.setUserName("user" + random.nextInt());
			userService.add(user);
		}
		
		return user;
	}
}