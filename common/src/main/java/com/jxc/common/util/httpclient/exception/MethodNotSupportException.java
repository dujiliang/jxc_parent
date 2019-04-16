package com.jxc.common.util.httpclient.exception;


/**
 * mailto:xiaobenma020@gmail.com
 */
public class MethodNotSupportException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2905515411157008206L;

	public MethodNotSupportException(String methodName) {
        super("Method " + methodName + " not support!");
    }
}
