package com.ezen.springdata.fruit.repository;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.ezen.springdata.dto.FruitDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class FruitOrderRepository {
	private final SqlSessionTemplate sql;
	
	public List<FruitDTO> getAll() {
		return sql.selectList("Fruits.getAll");
	}
	
	public boolean reduceFruit(Integer fid, Integer qty) {
		HashMap<String, Object> paraMap = new HashMap<>();
		
		paraMap.put("fid", fid);
		paraMap.put("qty", qty);
		
		return sql.update("Fruits.reduceFruit", paraMap) > 0;
	}
	
	public boolean addHistory(Integer fid, Integer qty) {
		HashMap<String, Object> paraMap = new HashMap<>();
		
		paraMap.put("fid", fid);
		paraMap.put("qty", qty);
		
		return sql.insert("Fruits.addHistory", paraMap) > 0;
	}
}
