package org.librairy.bluebottle.harvest;

import java.io.Serializable;

public class Annotation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
