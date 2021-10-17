package com.example.kolook.customer.domain.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.kolook.customer.domain.model.Customer;

@Service
@Component
public class CustomerServiceSelectOne {
	/**
	 * @
	 * 一覧のデータを取得、詳細や編集に送信するサービスクラス
	 * @param id
	 * @return employee
	 */

	@Autowired
	PostgresDriverSQLData pdsql;

	public Customer selectOne(String customer_id) {
		Customer customer = null;

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;

		try {
			System.out.print("Class型:" + customer_id.getClass().getSimpleName());
			System.out.println(":中身:" + customer_id);
			System.out.println(Integer.parseInt(customer_id));
		} catch (NumberFormatException e) {
			System.out.println("selectOneの引数に正しくない引数が使用されています");
		}

		try {
			//データベースに接続
			try {
				System.out.println("Postgres_Driverでデータベース接続");
				Class.forName(pdsql.getPOSTGRES_DRIVER());
				connection = DriverManager.getConnection(pdsql.getJDBC_CONNECTION(), pdsql.getUSER(), pdsql.getPASS());
				statement = connection.createStatement();
			} catch (NullPointerException e) {
				System.out.println("PostgresDriverがNullです");
			}
			System.out.println("SQL文作成開始");
			//SQL文の作成と実行
			preparedStatement = connection.prepareStatement(pdsql.getSELECT_SQL_ONE_ID());
			preparedStatement.setInt(1, Integer.parseInt(customer_id));
			System.out.println(preparedStatement);
			resultSet = preparedStatement.executeQuery();
			System.out.println("SQLデータの格納");
			//取得したSQLデータをEmployeeに格納(ResultSetで格納)
			while (resultSet.next()) {
				customer = new Customer(resultSet);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQLが正常に使用されませんでした");
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
		System.out.println("Service:取得されたか確認：" + customer.getUsername());
		System.out.println("SQL一件取得終了");
		System.out.println();
		System.out.println();
		return customer;
	}
}
