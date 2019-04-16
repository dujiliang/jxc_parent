package com.jxc.common.bean;

import java.util.HashMap;
import java.util.Map;

public class R {

    private int code = 0;
    private int error_code = 0;
    private String msg = "";
    private Map<String,Object> data = new HashMap<String,Object>();

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getError_code() {
		return error_code;
	}

	public void setError_code(int error_code) {
		this.error_code = error_code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public static R ok(){
        return new R(){{
            setCode(1);
        }};
    }

    public static R ok(Map<String, Object> data){
        return new R(){{
            setCode(1);
            setData(data);
        }};
    }

    public static R error(){
        return new R(){{
            setCode(0);
            setError_code(-1);
            setMsg("未知的错误");
        }};
    }

    public static R error(int errorCode,String msg){
        return new R(){{
            setCode(0);
            setError_code(errorCode);
            setMsg(msg);
        }};
    }
}
