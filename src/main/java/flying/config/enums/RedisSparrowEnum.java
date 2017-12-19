package flying.config.enums;

import flying.config.enums.nozzle.IntEnumI;

public enum RedisSparrowEnum implements IntEnumI {
	
	BASIC(1);
	
	private int value;
	
	private RedisSparrowEnum(int value) {
		this.value = value;
	}

	@Override
	public int getValue() {
		return value;
	}

}
