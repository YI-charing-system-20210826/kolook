package com.example.kolook.employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.kolook.employee.domain.model.Employee;
import com.example.kolook.employee.domain.service.EmployeerServiceSelectOne;

//従業員詳細画面のGET用メソッド
@Controller
public class EmployeeDetailController {
	@Autowired
	EmployeerServiceSelectOne esso;

	@GetMapping("/employeeDetail/{id}")
	public String getEmployeeDetail(Model model,@PathVariable("id") String id) {
		System.out.println("詳細コントローラー起動");
	//customer_Idのチェック(空でない、0以上)
		if(id != null) {
		}else {
			return "/customerDetail/error";
		}
	//従業員情報の取得(1件) 
		Employee employee = esso.selectOne(id);
	//データが格納されているか確認
		System.out.println("Controller:取得されたか確認："+employee.getUsername());
	//Customerクラスをフォームクラスに変換
		model.addAttribute("employee", employee);
	//詳細画面に遷移
		model.addAttribute("contents", "detail::detail_contents");
		System.out.println("詳細Controller終了");
		return "layout";
	}

	@PostMapping("/employeeDetail/{id}")
	//従業員詳細画面 Post用コントローラー
	public String postCustomerDetail(Model model,@PathVariable("id") String id) {
		System.out.println("詳細コントローラー起動");
	//member_idのチェック(空でない、0以上)
		if(id != null) {
		}else {
			return "/memberDetail/error";
		}
	//顧客情報の取得(1件) Employee employee = ...
		Employee employee = esso.selectOne(id);
		System.out.println(employee);
	//Customerクラスをフォームクラスに変換
		model.addAttribute("employee", employee);
	//詳細画面に遷移
		model.addAttribute("contents", "detail::detail_contents");
		System.out.println("詳細Controller終了");
		return "layout";
	}
}
