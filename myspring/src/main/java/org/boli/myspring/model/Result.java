package org.boli.myspring.model;

public class Result {

	boolean success = true;

	String status = "SUCCESS";

	Object data;

	public Result() {
	}

	public Result(Object data) {
		super();
		this.data = data;
	}

	public Result(boolean success, Object data) {
		super();
		setSuccess(success);
		setData(data);
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
		if (!success) {
			status = "FAILURE";
		}
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
