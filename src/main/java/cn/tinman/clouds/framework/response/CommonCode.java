package cn.tinman.clouds.framework.response;

/**
 * Created by tinman on 2016/4/19.
 */
public enum CommonCode {
	SUCCESS(200, "Success");

	private final int status;
	private final String info;

	CommonCode(int status, String info) {
		this.status = status;
		this.info = info;
	}

	public int getStatus() {
		return status;
	}

	public String getInfo() {
		return info;
	}
}
