package flying.config.enums;

import flying.config.enums.nozzle.IntEnumI;

public enum SparrowValidateEnum implements IntEnumI {
	
	LOGIN_VALIDATE_TYPE(1), MOBILE_VALIDATE_ACCESS_TYPE(2), MOBILE_VALIDATE_SEND_TYPE(3);
	
	private int value;
	 
    private SparrowValidateEnum(int value) {
        this.value = value;
    }

	@Override
	public int getValue() {
		return value;
	}

}
