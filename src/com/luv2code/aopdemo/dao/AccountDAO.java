package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	// add a new method: findAccounts()	
	public List<Account> findAccounts(boolean tripWire){
		
		// for academic purpose ... simulate an exception
		if(tripWire) {
			throw new RuntimeException("No soup for you!!!");
		}
		
		List<Account> myAccounts = new ArrayList<Account>();
		
		// create sample accounts
		Account acc1 = new Account("John", "Silver");
		Account acc2 = new Account("Madhu", "Platinum");
		Account acc3 = new Account("Luca", "Gold");		
		
		// add them to our list
		myAccounts.add(acc1);
		myAccounts.add(acc2);
		myAccounts.add(acc3);
		
		return myAccounts;
	}
			
	public void addAccount() {		
		System.out.println(getClass() + " addAccount()");		
	}
	
	public void addAccount(Account theAccount) {		
		System.out.println(getClass() + " addAccount(Account theAccount)");		
	}
	
	public void addAccount(Account theAccount, boolean vipFlag) {		
		System.out.println(getClass() + " addAccount(Account theAccount, boolean vipFlag)");		
	}
	
	public boolean doWork() {
		System.out.println(getClass() + " doWork()");
		return true;
	}

	public String getName() {
		System.out.println(getClass() + " getName()");		
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + " setName(String name)");		
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + " getServiceCode()");		
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + " setServiceCode(String serviceCode)");		
		this.serviceCode = serviceCode;
	}		
}
