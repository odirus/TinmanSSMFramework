package cn.tinman.clouds.framework.customException;

public enum BusinessError {
	SAMPLE_ERROR(1001, "This is sample error");

	private final int status;
	private final String info;

	BusinessError(int status, String info) {
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
