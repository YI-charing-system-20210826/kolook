package com.example.kolook.customer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.kolook.customer.domain.model.Customer;
import com.example.kolook.customer.domain.service.CustomerServiceSelectOne;

//顧客詳細画面のGET用メソッド
@Controller
public class CustomerDetailController {
	@Autowired
	CustomerServiceSelectOne esso;

	@GetMapping("/customerDetail/{id}")
	public String getEmployeeDetail(Model model,@PathVariable("id") String id) {
		System.out.println("詳細コントローラー起動");
	//customer_Idのチェック(空でない、0以上)
		if(id != null) {
		}else {
			return "/customerDetail/error";
		}
	//顧客情報の取得(1件) 
		Customer customer = esso.selectOne(id);
	//データが格納されているか確認
		System.out.println("Controller:取得されたか確認："+customer.getUsername());
	//Customerクラスをフォームクラスに変換
		model.addAttribute("customer", customer);
	//詳細画面に遷移
		model.addAttribute("contents", "detail::detail_contents");
		System.out.println("詳細Controller終了");
		return "layout";
	}

	@PostMapping("/customerDetail/{id}")
	//顧客詳細画面 Post用コントローラー
	public String postCustomerDetail(Model model,@PathVariable("id") String id) {
		System.out.println("詳細コントローラー起動");
	//customer_idのチェック(空でない、0以上)
		if(id != null) {
		}else {
			return "/customerDetail/error";
		}
	//顧客情報の取得(1件) Employee employee = ...
		Customer customer = esso.selectOne(id);
		System.out.println(customer);
	//Customerクラスをフォームクラスに変換
		model.addAttribute("customer", customer);
	//詳細画面に遷移
		model.addAttribute("contents", "detail::detail_contents");
		System.out.println("詳細Controller終了");
		return "layout";
	}
}
