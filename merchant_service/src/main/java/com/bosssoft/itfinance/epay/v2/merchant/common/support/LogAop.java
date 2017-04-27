package com.bosssoft.itfinance.epay.v2.merchant.common.support;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bosssoft.itfinance.epay.v2.teamcommon.BaseException;

/**
 * @ClassName: LogAop
 * @Description: TODO(AOP全局异常日志输出)
 * @author xiangqi
 * @date 2016年4月5日 上午10:40:27
 */
@Aspect
@Component
public class LogAop {
    private final static Logger logger = LoggerFactory.getLogger(LogAop.class.getName());

    @Pointcut("execution(* com.cagtc.homegive.dubboservice..*.*(..)) or execution(* com.cagtc.homegive.biz..*.*(..))")
    public void anymethod() {}
    @Around("anymethod()")
    // 声明环绕通知
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
	    Object result = null;
	    long start = System.currentTimeMillis();
	    boolean is_debug = false;	    
	    try {
            is_debug = true;
		    result = pjp.proceed();
	    } catch (BaseException se) {
		    logger.info(pjp.toShortString() + " :  " + se.getMessage());
		    throw se;
	    } catch (Throwable e) {
		    logger.warn(e.getMessage(), e);
		    throw e;
	    } finally {
		    long end = System.currentTimeMillis();
		    
		    if(is_debug){
		    	long count = end - start; //耗时（毫秒）
		    	//调用方法
		    	String methodName = pjp.getTarget().getClass().getName() + "." + pjp.getSignature().getName();
		    	Object[] args = pjp.getArgs();
		    	String inParam = obj2String(args);//入参
		    	String outParam = obj2String(result);//出参
		    	logger.info("\n调用方法:{} 耗时(毫秒):{}\n 入参:{}\n出参:{}\n", methodName,count,inParam,outParam);
		    }
	    }
	    return result;
    }
    
    /**
     * 序列化对象为字符串，并排除request和response
     * @param object
     * @return
     * @throws BaseException
     */
    private String obj2String(Object object) throws BaseException {
        SerializerFeature feature = SerializerFeature.DisableCircularReferenceDetect;
	    String object_str = null;
        try{
	        byte[] bytes = JSON.toJSONBytes(object, feature);
		    object_str = new String(bytes, "UTF-8");
	    }catch (Exception e){
	    	//throw new BaseException(ErrorCode.SYS_SERIALIZE_BUG,e);
	    	if(object instanceof Object[]){
	    		Object[] args = (Object[]) object;
	    		if(args.length > 0){
	    			List<Object> list = new ArrayList<Object>();
	    			for(int i=0;i<args.length;i++){
	    				if(args[i] instanceof HttpServletRequest){
	    					continue;
	    				}else if(args[i] instanceof HttpServletResponse){
	    					continue;
	    				}else{
	    					list.add(args[i]);
	    				}
	    			}
	    			object_str = obj2String(list);
	    		}
	    	}
	    	logger.info("序列化入参失败");
	    }
        return object_str;
    } 

}
