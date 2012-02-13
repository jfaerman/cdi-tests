package jfaerman;

public class AbstractEvent  {
	private Long dateFired = System.currentTimeMillis();

	public Long getDateFired() {
		return dateFired;
	}

	public void setDateFired(Long dateFired) {
		this.dateFired = dateFired;
	}


	
}
