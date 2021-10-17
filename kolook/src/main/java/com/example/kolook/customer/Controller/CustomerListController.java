package com.example.kolook.customer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.kolook.customer.domain.model.Customer;
import com.example.kolook.customer.domain.service.CustomerServiceSelectAll;

/**
 * list画面のコントローラー
 * @author masuda
 */
	
@Controller
public class CustomerListController {
	@Autowired
	CustomerServiceSelectAll<?> customerService;

	@GetMapping("/list")
	//顧客一覧画面　GET用コントローラー
	public String getEmployeeList(Model model) {
		System.out.println("Get:ListController起動");

		model.addAttribute("contents", "list::list_contents");
		
		//ユーザー一覧の生成(List<> customerListに入れる)
		List<Customer> employeeList = customerService.SelectAllSQL();
		model.addAttribute("employeeList", employeeList);
		
		//employee/list.htmlに遷移
		System.out.println("layoutへ移動");
		return "layout";
	}

	@PostMapping("/list")
	//従業員一覧画面 Get用コントローラー
	public String postEmployeeList(Model model) {
		System.out.println("Post:ListController起動");

		model.addAttribute("contents", "list::list_contents");
		//ユーザー一覧の生成(List<> employeeListに入れる)
		//Modelにユーザーリストを登録(model.addAttribute("employeeList", employeeList))
		List<Customer> employeeList = customerService.SelectAllSQL();
		model.addAttribute("employeeList", employeeList);
		//employee/list.htmlに遷移
		System.out.println("layoutへ移動");
		return "layout";
	}
}
