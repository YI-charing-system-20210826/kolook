package com.example.kolook.customer.domain.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

	@Service
public class CustomerMapService {

			@Autowired
			PostgresDriverSQLData pdsql;
			
			
			Map<String,String> mapString;
			
			Map<Integer,String> mapInteger;
			
			public Map<Integer,String> getSexMap() {
			mapInteger = employeeMapService(pdsql.getSELECT_SQL_SEX_TABLE(),pdsql.getEMPLOYEE_SEX(),pdsql.getEMPLOYEE_SEX_NAME(),"INT");
			return this.mapInteger;
			}
			public Map<String,String> getCompanyDepartMap() {
			mapString = employeeMapService(pdsql.getSELECT_SQL_DEPART_TABLE(), pdsql.getEMPLOYEE_COMPANY_DEPART_CODE(), pdsql.getEMPLOYEE_COMPANY_DEPART_NAME());
			return this.mapString;
			}
			
			public Map<String,String> customerMapService(String SQL,String Column1,String Column2) {
			System.out.println("外部テーブル作成開始");
			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;
			PreparedStatement preparedStatement = null;
			
			//Map null回避用newインスタンス
			mapString = new HashMap<String,String>();
			try {
			//データベースに接続
			try {
			System.out.println("Postgres_Driverでデータベース接続");
			Class.forName(pdsql.getPOSTGRES_DRIVER());
			connection = DriverManager.getConnection(pdsql.getJDBC_CONNECTION(), pdsql.getUSER(), pdsql.getPASS());
			statement = connection.createStatement();
			}catch(NullPointerException e) {
				System.out.println("PostgresDriverがNullです");
			}
			System.out.println("SQL文作成開始");
			//SQL文の作成と実行
			preparedStatement = connection.prepareStatement(SQL);
			System.out.println("外部テーブルSQL文:"+preparedStatement);
			resultSet = preparedStatement.executeQuery();
			System.out.println("SQLデータを格納");
			//取得したSQLデータをMapに格納(ResultSetで格納)
			while (resultSet.next()) {
				System.out.println(Column1 + "=" + resultSet.getString(Column1));
				System.out.println(Column2 + "=" + resultSet.getString(Column2));
				mapString.put(resultSet.getString(Column1), resultSet.getString(Column2));
			}
			} catch(ClassNotFoundException e) {
			e.printStackTrace();
			} catch (SQLException e) {
			System.out.println("外部SQLが正常に使用されませんでした");
			e.printStackTrace();
			} catch (NullPointerException e) {
			System.out.println("ResultSetか,HashMapに異常があります");
			e.printStackTrace();
			} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println("正常にSQLが閉じられませんでした");
			}
			}
			return mapString;
			}
			public Map<Integer,String> customerMapService(String SQL,String Column1,String Column2,String checkInteger) {
			System.out.println("外部テーブル作成開始");
			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;
			PreparedStatement preparedStatement = null;
			
			//Map null回避用newインスタンス
			mapInteger = new HashMap<Integer,String>();
			try {
			//データベースに接続
			try {
			System.out.println("Postgres_Driverでデータベース接続");
			Class.forName(pdsql.getPOSTGRES_DRIVER());
			connection = DriverManager.getConnection(pdsql.getJDBC_CONNECTION(), pdsql.getUSER(), pdsql.getPASS());
			statement = connection.createStatement();
			}catch(NullPointerException e) {
				System.out.println("PostgresDriverがNullです");
			}
			System.out.println("SQL文作成開始");
			//SQL文の作成と実行
			preparedStatement = connection.prepareStatement(SQL);
			System.out.println("外部テーブルSQL文:"+preparedStatement);
			resultSet = preparedStatement.executeQuery();
			System.out.println("SQLデータを格納");
			//取得したSQLデータをMapに格納(ResultSetで格納)
			while (resultSet.next()) {
				int a = resultSet.getInt(Column1);
				String s = resultSet.getString(Column2);
				System.out.println(a+":"+s);
				mapInteger.put(a, s);
			}
			} catch(ClassNotFoundException e) {
			e.printStackTrace();
			} catch (SQLException e) {
			System.out.println("外部SQLが正常に使用されませんでした");
			e.printStackTrace();
			} catch (NullPointerException e) {
			System.out.println("ResultSetか,HashMapに異常があります");
			e.printStackTrace();
			}
			finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println("正常にSQLが閉じられませんでした");
			}
			}
			return mapInteger;
			}
			}