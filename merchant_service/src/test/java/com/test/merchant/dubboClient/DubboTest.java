package com.test.merchant.dubboClient;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bosssoft.itfinance.epay.v2.merchant.api.dubboservice.ISysConfigTestService;
import com.bosssoft.itfinance.epay.v2.merchant.api.dubboservice.params.test.SysConfigTestQueryParam;
import com.bosssoft.itfinance.epay.v2.merchant.api.dubboservice.results.test.SysConfigTestResult;
import com.bosssoft.itfinance.epay.v2.merchant.common.util.BeanConvertUtil;
import com.bosssoft.itfinance.epay.v2.teamcommon.BaseException;

public class DubboTest {
	@org.junit.Test
    public void test() throws BaseException, UnsupportedEncodingException {
		System.out.println("");
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "dubbo-consumer-test.xml" });
		context.start();
		ISysConfigTestService sysConfigTestService=(ISysConfigTestService)context.getBean("sysConfigTestService");
		
		SysConfigTestQueryParam param = new SysConfigTestQueryParam();
		param.setCode("XB");
		param.setId("1");
		List<SysConfigTestResult> list = sysConfigTestService.querySysConfigTest(param);
		System.out.println("=============="+BeanConvertUtil.Obj2String(list));
	}
}
