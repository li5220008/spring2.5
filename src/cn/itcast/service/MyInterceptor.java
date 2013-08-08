package cn.itcast.service;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class MyInterceptor {
	@Pointcut("execution(* cn.itcast.service.impl.PersonServiceBean.*(..))")
	private void anyMethod() {}//声明一个切入点
	
	@Before("anyMethod()")
	public void doAccessCheck() {
		System.out.println("前置通知！");
	}
	@AfterReturning("anyMethod()")
	public void doReturning() {
		System.out.println("后置通知！");
	}
	@After("anyMethod()")
	public void doAfer() {
		System.out.println("最终通知！");
	}
	@AfterThrowing("anyMethod()")
	public void doThrowing() {
		System.out.println("异常通知！");
	}
	
	
}
