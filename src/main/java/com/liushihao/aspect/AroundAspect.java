package com.liushihao.aspect;

import com.liushihao.entity.Log;
import com.liushihao.service.LogService;
import com.liushihao.util.WriteLogUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Slf4j
@Aspect
@Component
/**
  什么时间 执行了什么操作 操作的结果
 */
public class AroundAspect {

    /**
     * 注入logService
     */
    @Resource
    private LogService logService;

    /**
     * 组装切面
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "pc1()")
    public Object aroundAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("进入环绕通知");
        // 获取执行时间
        Date date = new Date();
        String result = null;
        // 获取方法名
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        // 获取注解对象
        LogAspect annotation = methodSignature.getMethod().getAnnotation(LogAspect.class);
        // 获取注解操作类型
        String operationName = annotation.operationName();
        // 获取日志文件
        String fileName = annotation.fileName();
        try {
            // 执行目标方法
            Object proceed = proceedingJoinPoint.proceed();
            result = "成功";
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            result = "失败";
            throw throwable;
        } finally {
            Log log = new Log(null, "test", date, operationName, result);
            String context = "id: " + log.getId() + "|name: " + log.getName() + "|date: " + log.getDate() + "|method: " + log.getMethod() + "|result: " + log.getResult() + "\n";
            WriteLogUtil.write(fileName, context);
            System.out.println("结束环绕通知");
        }
    }

    /**
     * 设置切点
     */
    @Pointcut(value = "@annotation(com.liushihao.aspect.LogAspect)")
    public void pc1() {
    }
}
