package com.example.kolook.customer.domain.model;

import java.sql.ResultSet;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customer")
public class Customer implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false, unique = true)
	private int customer_id;

	// 各カラムをフェールド変数に設定
	@Id
	@Column(nullable = false)
	private String last_name; //姓
	//パスワード
	@Column(nullable = false)
	private String first_name; //名

	@Column(nullable = false) 
	private String last_name_Kana; //セイ

	@Column(nullable = false)
	private String first_name_Kana; //メイ

	@Column(nullable = false)
	private String gender; //性別

	@Column(nullable = false)
	private String tel_no; //電話番号
	
	@Column(nullable = false)
	private String email; //アドレス
	
	@Column(nullable = false)
	private String post_no; //郵便番号
	
	@Column(nullable = false)
	private String address; //市区町村
	
	@Column(nullable = false)
	private String address_detail; //番地以降
	
	@Column(nullable = false)
	private String remarks; //備考欄
	
	/**
	 //* 一覧表示するために使用するコンストラクタ
	 * @param customer_id
	 * @param last_name
	 */
	public Customer(int customer_id,String last_name) {
		this.customer_id = customer_id;
		this.last_name = last_name;
	}

	/**
	 * 全権取得の為に使用するコンストラクタ
	 * SQLのResultSetを入れることで全てのデータが入った、
	 * Customerクラスを簡単に作れます
	 * @author 畑中 悠希
	 * @param customer_id
	 * @param last_name
	 */

	/*public Customer(ResultSet resultSet) {
		try {
		this.last_name = check("last_name",resultSet.getInt("last_name"));
		this.first_name = check("first_name",resultSet.getString("first_name"));
		this.last_name_Kana = check("last_name_Kana",resultSet.getString("last_name_Kana"));
		this.first_name_Kana = check("first_name_Kana",resultSet.getString("first_name_Kana"));
		this.gender =check("gender",resultSet.getInt("gender"));
		this.tel_no = check("tel_no",resultSet.getDate("tel_no"));
		this.email = check("email",resultSet.getInt("email"));
		this.post_no = check("post_no",resultSet.getString("post_no"));
		this.address = check("address",resultSet.getString("address"));
		this.address_detail = check("address_detail",resultSet.getString("address_detail"));
		this.remarks = check("remarks",resultSet.getString("remarks"));
		
		} catch (SQLException e) {
			System.out.println("SQLデータを正しく格納することが出来ませんでした");
			e.printStackTrace();
		}
	}*/

	/*//null回避用メソッド
	public String check(String s,int c) {
		try {
			System.out.println(s+":"+c);
		if(c != -1) {
			return c;
			}
		} catch(NullPointerException e) {
			c = -1;
		}
		return c;
	}
	public String check(String s,String b) {
		System.out.println(s+":"+b);
		if(b != null) {
			return b;
		}else {
			return "未定義";
		}
	}
	public String check(String s,Date d) {
			System.out.println(s+":"+d);
		if(d != null) {
			return d;
		}else {
			return new Date(-31536000000L);
		}
	}*/
	
	/***
	 * @id customer
	 * @param 
	 * customerの中に格納されているデータを確認する為のプログラム（編集用）
	 */
	
	/*public void editTest(String point) {
		System.out.println("起動場所:"+point);
		System.out.println("last_name:"+this.getLast_name());
		System.out.println("first_name:"+this.getFirst_name());
		System.out.println("last_name_Kana:"+this.getLast_name_Kana());
		System.out.println("first_name_Kana:"+this.getFirst_name_Kana());
		System.out.println("gender:"+this.getGender());
		System.out.println("tel_no:"+this.getTel_no());
		System.out.println("email:"+this.getEmail());
		System.out.println("post_no:"+this.getPost_no());
		System.out.println("addores:"+this.getAddress());
		System.out.println("address_detail:"+this.getAddress_detail());
		System.out.println("remarks:"+this.getRemarks());
		System.out.println();
		System.out.println();
	}*/

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String getPassword() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String getUsername() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	public Customer(ResultSet resultSet) {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
}
