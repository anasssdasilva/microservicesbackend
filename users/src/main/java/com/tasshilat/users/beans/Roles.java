package com.tasshilat.users.beans;

public class Roles {
	
	private int id;
	private boolean isAdmin;
	
	public Roles() {
		super();
	}
	
	
	public Roles(int id, boolean isAdmin) {
		super();
		this.id = id;
		this.isAdmin = isAdmin;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	
	

}
