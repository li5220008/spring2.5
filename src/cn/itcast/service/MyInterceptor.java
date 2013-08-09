package cn.itcast.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class MyInterceptor {
	@Pointcut("execution(* cn.itcast.service.impl.PersonServiceBean.*(..))")
	private void anyMethod() {}//声明一个切入点
	
	@Before("anyMethod() && args(userName)")
	public void doAccessCheck(String userName) {
		System.out.println("前置通知！"+userName);
	}
	@AfterReturning(pointcut="anyMethod()", returning="result")
	public void doReturning(String result) {
		System.out.println("后置通知！"+result);
	}
	@After("anyMethod()")
	public void doAfer() {
		System.out.println("最终通知！");
	}
	@AfterThrowing("anyMethod()")
	public void doThrowing() {
		System.out.println("异常通知！");
	}
	@Around("anyMethod()")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("进入方法");
		Object retVal = pjp.proceed();
		System.out.println("退出方法");
		return retVal;
  }
	
	
}
