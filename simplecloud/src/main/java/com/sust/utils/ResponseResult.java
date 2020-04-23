package tzw.sust.entitys;

/**
 * @author TianZhengwei
 * @date 2020/04/16 19:30
 * @description
 */
public class ResponseResult {
	private static final long serialVersionUID = 1L;
	private int code;
	private String message;

	public ResponseResult() {
		super();
	}

	public ResponseResult(int code, String message) {
		super();
		this.setCode(code);
		this.setMessage(message);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
