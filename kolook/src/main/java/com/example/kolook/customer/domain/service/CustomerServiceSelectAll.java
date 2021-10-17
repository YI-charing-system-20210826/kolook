package com.example.kolook.customer.domain.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.kolook.customer.domain.model.Customer;

	@Service
	@Component
public class CustomerServiceSelectAll<PostgresDriverSQLData> {
	/**
	 * 一覧のデータを取得、送信するサービスクラス
	 */
		@Autowired
		PostgresDriverSQLData pdsql;
		@Autowired
		CustomerServiceNewCustomerId esnei;

	public List<Customer> SelectAllSQL() {
		System.out.println("EmployeeServiceSelectAll起動");
		List<Customer> employeeList = new ArrayList<>();

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;

		try {
			//データベースに接続
			System.out.println("Postgres_Driverでデータベース接続");
			Class.forName(pdsql.getPOSTGRES_DRIVER());
			connection = DriverManager.getConnection(pdsql.getJDBC_CONNECTION(), pdsql.getUSER(), pdsql.getPASS());
			statement = connection.createStatement();
			System.out.println("SQL文作成開始");
			//SQL文の作成と実行
			preparedStatement = connection.prepareStatement(pdsql.getSELECT_SQL_ALLID());
			System.out.println(preparedStatement);
			resultSet = preparedStatement.executeQuery();
			System.out.println("SQLデータの格納");
			//取得したSQLデータをList内に格納
			while (resultSet.next()) {
				employeeList.add(new Customer(resultSet.getInt(pdsql.getEMPLOYEE_ID()),resultSet.getString(pdsql.getEMPLOYEE_USERNAME()),resultSet.getString(pdsql.getEMPLOYEE_COMPANY_CODE()),resultSet.getString(pdsql.getEMPLOYEE_COMPANY_DEPART_CODE())));
			}

		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQLが正常に使用されませんでした");
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
		System.out.println("EmployeeServiceSelectAll終了");
		System.out.println();
		System.out.println();
		return employeeList;
	}
}
