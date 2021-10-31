package com.example.security.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

	@Autowired
	private CustomerRepository repository;

	public List<Customer> get() {
		return (List<Customer>) repository.findAll();
	}
    //全体処理の入り口(top.htmlを表示している)
	@RequestMapping("/")
	public String index() {
		return "redirect:/top";
	}
    //localhost/8000を開いた瞬間の画面
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	//顧客情報一覧画面
	@GetMapping("/customer/list")
	public String displayList(Model model) {
		List<Customer> customerList = CustomerRepository.searchAll();
		model.addAttribute("customerList",customerList);
		return "/customer/list";
	}
	
	//顧客新規登録画面の表示
	@GetMapping(value = "customer/add")
	public String displayAdd(Model model) {
		return "customer/add";
	}
	
	//顧客情報詳細画面の表示
	@GetMapping("/customer/{id}")
	public String displayView(@PathVariable Long id, Model model) {
		return "customer/view";
	}
	
    //投稿の処理、新しいデータを登録したりする。
	@PostMapping("/login")
	public String loginPost() {
		return "redirect:/login-error";
	}

	@GetMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "login";
	}

	//ここもtop.htmlの表示に関わっている
	@RequestMapping("/top")
	public String top() {
		return "/top";
	}
	
	/*@Autowired
	CustomerServiceSelectAll<?> customerService;
	
	@GetMapping("/list")
	//顧客一覧画面　GET用コントローラー
	public String getEmployeeList(Model model) {
		System.out.println("Get:ListController起動");
	
		model.addAttribute("contents", "list::list_contents");
		
		//ユーザー一覧の生成(List<> customerListに入れる)
		List<Customer> customerList = customerService.SelectAllSQL();
		model.addAttribute("customerList", customerList);
		
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
		List<Customer> customerList = customerService.SelectAllSQL();
		model.addAttribute("customerList", customerList);
		//employee/list.htmlに遷移
		System.out.println("layoutへ移動");
		return "layout";
	}*/

}