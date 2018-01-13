/**
 * 
 */
package com.xyd.dem04.bean;

/**
 * @author scott
 * @date 2018年1月9日下午5:05:38
 * @version 
 * @description 
 */
public class Account {

	private String name;
	
	private int money;

	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	public Account(String name, int money) {
		this.name = name;
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	
	
	
}
