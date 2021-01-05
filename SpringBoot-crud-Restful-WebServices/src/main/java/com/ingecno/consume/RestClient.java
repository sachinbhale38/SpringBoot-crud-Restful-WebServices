package com.ingecno.consume;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ingecno.entity.UserDetails;

public class RestClient {
	private static final String url="https://jsonplaceholder.typicode.com/comments";
	private static final String GET_ALL_USERS_API="http://localhost:8089/api/users";
	private static final String GET_USER_BY_ID_API="http://localhost:8089/api/users/{id}";
	private static final String CREATE_USER_API="http://localhost:8089/api/users";
	private static final String UPDATE_USER_API="http://localhost:8089/api/users/{id}";
	private static final String DELETE_USER_API="http://localhost:8089/api/users/{id}";
	
	static RestTemplate restTemplate=new RestTemplate();
	
	public static void main(String[] args) {
		callGetAllUsersApi();
		callGetUserByIdApi();
		callExternalApi();
		
	}
	private static void callGetAllUsersApi() {
		HttpHeaders headers=new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity=new HttpEntity<String>("parameters",headers);
		
		ResponseEntity<String>  result=restTemplate.exchange(GET_ALL_USERS_API,HttpMethod.GET,entity,String.class);
		
		System.err.println(result);
		
	}
	private static void callGetUserByIdApi() {
		
		Map<String, Integer> param=new HashMap<String, Integer>();
		param.put("id", 69);
		
		UserDetails user=restTemplate.getForObject(GET_USER_BY_ID_API, UserDetails.class, param);
		System.err.println(user.getFirstName());
		System.err.println(user.getLastName());
		System.err.println(user.getEmail());
		
	}
	private static void callExternalApi() {
		HttpHeaders headers=new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity=new HttpEntity<String>("parameters",headers);
		
		ResponseEntity<String>  result12=restTemplate.exchange(url,HttpMethod.GET,entity,String.class);
		System.out.println("=====================");
//		System.err.println(result12);
		//System.out.println(result12.getBody());
		System.out.println(result12.getStatusCodeValue());
		System.out.println(result12.getStatusCode());
		System.out.println(result12.getHeaders());
		
	}
	

}
