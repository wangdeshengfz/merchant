package com.test.merchant.dubboService;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bosssoft.itfinance.epay.v2.merchant.api.dubboservice.ISysConfigTestService;
import com.bosssoft.itfinance.epay.v2.merchant.api.dubboservice.exception.MerchantServiceException;
import com.bosssoft.itfinance.epay.v2.merchant.api.dubboservice.params.test.SysConfigTestQueryParam;
import com.bosssoft.itfinance.epay.v2.merchant.api.dubboservice.results.test.SysConfigTestResult;
import com.bosssoft.itfinance.epay.v2.merchant.common.util.BeanConvertUtil;
import com.bosssoft.itfinance.epay.v2.merchant.service.dao.SysConfigTestMapper;
import com.bosssoft.itfinance.epay.v2.merchant.service.entity.SysConfigTest;
import com.test.merchant.BaseTest;



public class ISysConfigTestServiceTest extends BaseTest{
	private static final Logger logger = LoggerFactory.getLogger(ISysConfigTestServiceTest.class);
	
	@Autowired
	private SysConfigTestMapper sysConfigTestMapper;
	
	@Autowired
	private ISysConfigTestService sysConfigTestService;

	/**
	 * 测试dao
	 * @throws UnsupportedEncodingException 
	 */
	@Test
	public void querySysConfigTest() throws MerchantServiceException, UnsupportedEncodingException{
		SysConfigTestQueryParam param = new SysConfigTestQueryParam();
		param.setCode("XB");
		param.setId("1");
		List<SysConfigTestResult> list = sysConfigTestService.querySysConfigTest(param);
		logger.info("=============="+BeanConvertUtil.Obj2String(list));
	} 
	
	/**
	 * 测试dao
	 * @throws UnsupportedEncodingException 
	 */
	//@Test
	public void query() throws MerchantServiceException, UnsupportedEncodingException{
		SysConfigTest scft = sysConfigTestMapper.selectById(1L);
		logger.info("=============="+BeanConvertUtil.Obj2String(scft));
	} 
	
	
	
}
