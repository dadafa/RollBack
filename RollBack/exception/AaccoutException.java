/**
 * 
 */
package com.xyd.dem04.exception;

/**
 * @author scott
 * @date 2018年1月9日上午10:04:51
 * @version 
 * @description 
 *  
 *  1.继承 Exception
 *  
 *  2.重写构造
 *  
 *  3.使用   Throw new Exception();
 *  
 * 
 */
public class AaccoutException extends Exception{

	public AaccoutException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AaccoutException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AaccoutException(String message) {
		super(message);
	}
	
}
