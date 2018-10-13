package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addAccount() {	
		System.out.println(getClass() + " addAccount()");		
	}
	
	public boolean addOtherAddMethod() {
		System.out.println(getClass() + " addOtherAddMethod()");
		return true;
	}
	
	public void goToSleep() {
		System.out.println(getClass() + " goToSleep()");
	}
}
