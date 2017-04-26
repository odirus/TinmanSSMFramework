package cn.tinman.clouds.framework.customException;

/**
 * Created by tinman on 2016/3/16.
 */
public class BusinessException extends RuntimeException {
	private BusinessError businessError;

	public BusinessException(BusinessError businessError) {
		this.businessError = businessError;
	}

	public BusinessError getBusinessError() {
		return businessError;
	}
}
