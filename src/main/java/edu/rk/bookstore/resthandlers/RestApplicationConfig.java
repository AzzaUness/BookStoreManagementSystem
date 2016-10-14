package edu.rk.bookstore.resthandlers;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.jackson.JacksonFeature;

@ApplicationPath("/")
public class RestApplicationConfig extends Application{
	private Set<Class<?>> restClassSet = new HashSet<Class<?>>();
	
	public RestApplicationConfig(){
		restClassSet.add(JacksonFeature.class);
		restClassSet.add(BookStoreRestHandler.class);
	}

	public Set<Class<?>> getClasses(){
		return restClassSet;
	}
}
