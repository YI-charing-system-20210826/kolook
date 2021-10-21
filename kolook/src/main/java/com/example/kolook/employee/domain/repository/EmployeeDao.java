package com.example.kolook.employee.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.kolook.employee.domain.model.Employee;

public interface EmployeeDao {
	

	//従業員テーブルのデータを1件取得
	public Employee selectOne(String customer_id) throws DataAccessException;

	//従業員テーブルの全データを取得
	public List<Employee> selectAll() throws DataAccessException;

	//従業員テーブルを1件削除　

	//public void deleteOne(String customer_id) throws DataAccessException;
}