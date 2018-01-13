/**
 * 
 */
package com.xyd.dem04.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.security.auth.login.AccountException;

import com.xyd.dem04.bean.Account;
import com.xyd.dem04.dao.AccounDaoImpl;
import com.xyd.demo01.utils.JdbcUtils;

/**
 * @author scott
 * @date 2018年1月9日下午5:02:01
 * @version 
 * @description 
 */
public class AccountService {

	/**
	 *  转账操作  
	 *  
	 *  设置自动提交
	 *  accountIn()    转入
	 *  accountOut()   转出
	 *  
	 *  commit() 提交事物
	 *  
	 *  catch{
	 *    rollback()
	 *  }
	 * @throws AccountException 
	 *  
	 */
	public void  account(Account in,Account out,int money) throws AccountException {
		
		Connection conn = JdbcUtils.getConn();
		AccounDaoImpl accounDaoImpl = new AccounDaoImpl();
		
		try {
			//设置手动提交
			conn.setAutoCommit(false);
			accounDaoImpl.accountIn(in, money);
			accounDaoImpl.accountOut(out, money);
			//提交 
			conn.commit();
			
		} catch (Exception e) {
			
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			throw new AccountException("转账失败....");
		}
		finally {
			JdbcUtils.close(null, null, conn);
		}
	}
	
}
