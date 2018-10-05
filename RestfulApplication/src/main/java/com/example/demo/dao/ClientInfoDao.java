package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ClientInfoDao extends JpaRepository<ClientInfo, Integer> {

	ClientInfo findById(int id);
	List<ClientInfo> findByClientType(String clientType);
}
