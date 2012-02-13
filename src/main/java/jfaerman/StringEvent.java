package jfaerman;

public class StringEvent extends AbstractEvent{
	private String value;

	public StringEvent(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
