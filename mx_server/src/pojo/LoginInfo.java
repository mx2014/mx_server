/**
 * 
 */
package pojo;

public class LoginInfo {
	
	private boolean success;
	
	private String key;
	
	private String msg;
	
	private Login content;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Login getContent() {
		return content;
	}

	public void setContent(Login content) {
		this.content = content;
	}


	
}