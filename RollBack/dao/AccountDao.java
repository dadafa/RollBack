/**
 * 
 */
package com.xyd.dem04.dao;

import com.xyd.dem04.bean.Account;

/**
 * @author scott
 * @date 2018年1月9日下午4:59:19
 * @version 
 * @description 
 */
public interface AccountDao {

	/**
	 * 转入    aa 的 钱  转到  bb 中 
	 * 
	 *     aa - moeny
	 *     bb + money
	 *      
	 */
	public void accountIn(Account in,int money) throws Exception;
	/**
	 * 转入    aa 的 钱  转到  bb 中 
	 * 
	 *     aa - moeny
	 *     bb + money
	 *      
	 */
	public void accountOut(Account out,int money) throws Exception;
	
}
