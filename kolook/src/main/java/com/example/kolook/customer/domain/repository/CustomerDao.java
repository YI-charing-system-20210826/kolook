package com.example.kolook.customer.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.kolook.customer.domain.model.Customer;

public interface CustomerDao {
	//従業員テーブルの件数取得
	//public int count() throws DataAccessException;

	//従業員テーブルにデータを1件insert
	//public int insertOne(Customer customer) throws DataAccessException;

	//従業員テーブルのデータを1件取得
	//public Customer selectOne(String customer_id) throws DataAccessException;

	//従業員テーブルの全データを取得
	public List<Customer> selectAll() throws DataAccessException;

	//従業員テーブルを1件更新
	//public int updateOne(Customer customer) throws DataAccessException;

	//従業員テーブルを1件削除　

	//public void deleteOne(String customer_id) throws DataAccessException;
}