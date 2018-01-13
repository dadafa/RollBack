/**
 * 
 */
package com.xyd.dem04.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.xyd.dem04.bean.Account;
import com.xyd.demo01.utils.JdbcUtils;

/**
 * @author scott
 * @date 2018年1月9日下午5:01:16
 * @version 
 * @description 
 */
public class AccounDaoImpl implements AccountDao{

	/**
	 * 转入的操作
	 */
	@Override
	public void accountIn(Account in,int money) throws Exception {
	
		Connection conn = JdbcUtils.getConn();
		
		String sql = "update account set money = money + ? where name = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, in.getMoney());
		ps.setString(2,in.getName());

		int executeUpdate = ps.executeUpdate();
		
		if (executeUpdate > 0) {
			
			System.out.println("成功了 ");
		}
		
		
	}

	@Override
	public void accountOut(Account out,int money) throws Exception {
		

		Connection conn = JdbcUtils.getConn();
		
		String sql = "update account set money = money + ? where name = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, out.getMoney());
		ps.setString(2,out.getName());

		int executeUpdate = ps.executeUpdate();
		
		if (executeUpdate > 0) {
			
			System.out.println("成功了 ");
		}
		
		
	}
}
