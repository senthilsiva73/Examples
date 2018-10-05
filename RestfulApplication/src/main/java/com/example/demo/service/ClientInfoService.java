package com.example.demo.service;

import java.util.List;

import com.example.demo.model.ClientInfoRequestResponse;

public interface ClientInfoService {

	public ClientInfoRequestResponse getClientInfoById(int clientId);
	public List<ClientInfoRequestResponse> getClientInfoByClientType(String clientType);
	public ClientInfoRequestResponse createClientInfo(ClientInfoRequestResponse request);
}
