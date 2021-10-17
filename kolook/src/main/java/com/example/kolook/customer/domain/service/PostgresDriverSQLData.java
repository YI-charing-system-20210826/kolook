package com.example.kolook.customer.domain.service;

import org.springframework.stereotype.Component;

import lombok.Data;


@Component
@Data
public class PostgresDriverSQLData {
	/**
	 * 	ドラーバー接続用
	 */

	/** ドライバーのクラス名 */
	private final String POSTGRES_DRIVER = "org.postgresql.Driver";
	/** JDMC接続先情報 */
	private final String JDBC_CONNECTION = "jdbc:postgresql://localhost:5433/kolook?characterEncoding=UTF-8";
	/** ユーザー名 */
	private final String USER = "postgres";
	/** パスワード */
	private final String PASS = "postgres";

	/**
	 * テーブル検索用
	 */

	/** 顧客テーブル */
	private final String CUSTOMER_DATA = "customer";
	/** 従業員テーブル */
	private final String EMPLOYEE_DATA = "employee";
	
	/**
	 
	 * SQL作成用
	 */

	/** 顧客の一覧を呼び出せるSQL文 */
	private String SELECT_SQL_ONE_ID = "SELECT * FROM "+"WHERE customer_id = ?";
	/** SQL文 */
	private final String SELECT_SQL_ALLID = "SELECT customer_id , last_name FROM " + "ORDER BY CUSTOMER_ID ASC";
	
}