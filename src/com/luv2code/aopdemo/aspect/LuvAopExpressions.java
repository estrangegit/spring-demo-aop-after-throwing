package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// create pointcut for getter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void forDaoPackageGetters() {}
	
	// create pointcut for setter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void forDaoPackageSetters() {}	
	
	// create point: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(forDaoPackageGetters() || forDaoPackageSetters())")
	public void forDaoPackageNoGetterSetter() {}	
}
