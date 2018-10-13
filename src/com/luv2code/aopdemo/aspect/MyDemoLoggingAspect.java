package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
		
	@AfterThrowing(
			pointcut="execution(java.util.List<com.luv2code.aopdemo.Account> com.luv2code.aopdemo.dao.AccountDAO.findAccounts(boolean))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);	
		
		// log the exception
		System.out.println("\n=====>>> The Exception is: " + theExc);
	}
			
	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(
			pointcut="execution(java.util.List<com.luv2code.aopdemo.Account> com.luv2code.aopdemo.dao.AccountDAO.findAccounts(boolean))",
			returning="result")	
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJoinPoint,
			List<Account> result) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);
		
		// print out the results of the method call
		System.out.println("\n=====>>> result is: " + result);
		
		// let's post-process the data ... let's modify it :-)		
		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n=====>>> modified result is: " + result);		
	}
		
	private void convertAccountNamesToUpperCase(List<Account> result) {
		// loop through accounts
		for (Account account : result) {
			
			// get upperCase version of the Account name
			String theUpperName = account.getName().toUpperCase();
			
			// update the name of the Account
			account.setName(theUpperName);			
		}		
	}

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAnyMethodInDaoPackage(JoinPoint theJoinPoint) {
		System.out.println("\n=====>>> Executing @Before any method of any class in com.luv2code.aopdemo.dao");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature(); 
		
		System.out.println("Method: " + methodSig);
		
		// display the method arguments
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop through args
		for (Object arg : args) {			
			if(arg instanceof Account) {
				// downcast and print Account specific stuff
				Account theAccount = (Account)arg;
				System.out.println("account name: " + theAccount.getName());
				System.out.println("account level: " + theAccount.getLevel());				
			}else {
				System.out.println(arg);				
			}
		}
	}		
}
