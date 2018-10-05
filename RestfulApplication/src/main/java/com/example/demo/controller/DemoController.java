package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ClientInfoRequestResponse;
import com.example.demo.service.ClientInfoServiceImpl;

@RestController
public class DemoController {

	@Autowired
	ClientInfoServiceImpl service;
	
	public DemoController() {}
	@RequestMapping(value = "/client", method = RequestMethod.POST)    
    public ResponseEntity<ClientInfoRequestResponse> createClient(@RequestBody ClientInfoRequestResponse request) {        
		ClientInfoRequestResponse response = service.createClientInfo(request);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "/clients/{clientType}", method = RequestMethod.GET)    
    public ResponseEntity<List<ClientInfoRequestResponse>> getClient(@PathVariable("clientType") String clientType) {
		
		List<ClientInfoRequestResponse> responseList = service.getClientInfoByClientType(clientType);
		return new ResponseEntity<>(responseList, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/client/{id}", method = RequestMethod.GET)    
    public ResponseEntity<ClientInfoRequestResponse> getClient(@PathVariable("id") int clientId) {
		
		ClientInfoRequestResponse response = service.getClientInfoById(clientId);
		return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
