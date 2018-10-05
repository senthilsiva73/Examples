package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ClientInfo;
import com.example.demo.dao.ClientInfoDao;
import com.example.demo.model.ClientInfoRequestResponse;

@Service
public class ClientInfoServiceImpl implements ClientInfoService {

	@Autowired
	private ClientInfoDao clientInfoDao;
	
	public ClientInfoRequestResponse createClientInfo(ClientInfoRequestResponse request) {
		
		ClientInfo clientInfo = new ClientInfo();
		BeanUtils.copyProperties(request, clientInfo);
		clientInfo = clientInfoDao.save(clientInfo);
		BeanUtils.copyProperties(clientInfo, request);
		return request;
	}
	
	public ClientInfoRequestResponse getClientInfoById(int clientId) {
		ClientInfo clientInfo = clientInfoDao.findById(clientId);
		ClientInfoRequestResponse clientInfoRequestResponse = null;
		if(clientInfo != null) {
		
			clientInfoRequestResponse = new ClientInfoRequestResponse();
			BeanUtils.copyProperties(clientInfo, clientInfoRequestResponse);
		}
		return clientInfoRequestResponse;
	}
	
	public List<ClientInfoRequestResponse> getClientInfoByClientType(String clientType) {
		
		List<ClientInfo> clientInfoList = clientInfoDao.findByClientType(clientType);
		
		List<ClientInfoRequestResponse> responseList = new ArrayList<>();
		
		for(ClientInfo clientInfo : clientInfoList) {
			ClientInfoRequestResponse clientInfoRequestResponse = new ClientInfoRequestResponse();
			BeanUtils.copyProperties(clientInfo, clientInfoRequestResponse);
			responseList.add(clientInfoRequestResponse);
		}
		return responseList;
	}
}
