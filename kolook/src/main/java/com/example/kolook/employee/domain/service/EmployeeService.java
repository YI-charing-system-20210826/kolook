package com.example.kolook.employee.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.kolook.employee.EmployeeRepository;
import com.example.kolook.employee.domain.model.Employee;

@Service
public class EmployeeService implements UserDetailsService {

    @Autowired
	private EmployeeRepository repository;

	//private PasswordEncoder passwordEncoder;

    private List<Employee> result;


//    Customerテーブルからauthoritiesカラム及びパスワードカラムが消えるため修正が必要
    public Employee loadUserByUsername(String name) throws UsernameNotFoundException {  //nameは従業員名
        if (name == null || "".equals(name)) {
        	System.out.println("引数：nameがnullです");
            throw new UsernameNotFoundException("Username is empty");
        }

        Employee user = repository.findByUsername(name);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + name);
        }

        return user;
    }

    public List<Employee> findAllList() {
    	result = repository.findAll();
		return result;
	}

	public static List<Employee> SelectAllSQL() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	   //adminを登録するメソッド
	//保留
	@Transactional
	  public void registerAdmin(String username, String password) {
	    //問３－３ 引数をもとにAccountクラスのインスタンスを生成する構文を記述（passwordはハッシュ化）
		Employee user = new Employee(username,passwordEncoder.encode(password));
	    user.setAdmin(true);
	    //userをもとにadmin情報の登録か更新を行う
	    repository.save(user);
	}
	
	//管理者を登録するメソッド
	//保留
	@Transactional
	public void registerManager(String username, String password) {
	    Employee user = new Employee(username,passwordEncoder.encode(password));
	    user.setManager(true);
	    repository.save(user);
	}
	
	//一般ユーザを登録するメソッド
	    @Transactional
	    public void registerUser(String username, String password) {
	        Employee user = new Employee(username,passwordEncoder.encode(password));
	        repository.save(user);
	    
	}


