/**
 * 
 */
package com.xyd.dem04.ui;

import java.util.Scanner;

import javax.security.auth.login.AccountException;

import com.xyd.dem04.bean.Account;
import com.xyd.dem04.service.AccountService;

/**
 * @author scott
 * @date 2018年1月9日下午5:04:26
 * @version 
 * @description 
 */
public class AccountApp {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);

		System.out.println("请输入要转出的账户");
		String nameOut = sc.next();
		
		System.out.println("请输入要转入的账户");
		String nameIn = sc.next();
		
		System.out.println("请输入要转账的金额:" );
		int money = sc.nextInt();
		
		Account accountIn = new Account(nameIn, money);
		Account accountOut = new Account(nameOut, money);
		
		AccountService service = new AccountService();
		
		try {
			service.account(accountIn, accountOut, money);
		} catch (AccountException e) {
			e.printStackTrace();
		}
		
	}
}
