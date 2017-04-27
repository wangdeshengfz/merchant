package com.bosssoft.itfinance.epay.v2.merchant.service.dubboservice.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bosssoft.itfinance.epay.v2.merchant.api.dubboservice.ISysConfigTestService;
import com.bosssoft.itfinance.epay.v2.merchant.api.dubboservice.exception.MerchantServiceException;
import com.bosssoft.itfinance.epay.v2.merchant.api.dubboservice.params.test.SysConfigTestQueryParam;
import com.bosssoft.itfinance.epay.v2.merchant.api.dubboservice.results.test.SysConfigTestResult;
import com.bosssoft.itfinance.epay.v2.merchant.common.util.BeanConvertUtil;
import com.bosssoft.itfinance.epay.v2.merchant.service.dao.SysConfigTestMapper;
import com.bosssoft.itfinance.epay.v2.merchant.service.entity.SysConfigTest;

@Service
public class SysConfigTestServiceImpl implements ISysConfigTestService {
	
	@Autowired
	private SysConfigTestMapper sysConfigTestMapper;	//ID获取

	@Override
	public List<SysConfigTestResult> querySysConfigTest(
			SysConfigTestQueryParam sysConfigTestQueryParam)
			throws MerchantServiceException {
		
		Map<String, Object> param = new HashMap<String,Object>();
		param.put("id", "1");
		param.put("code", "XB");
		List<SysConfigTest> rst = sysConfigTestMapper.selectByMap(param);
		
		return BeanConvertUtil.beanListConvert(rst, SysConfigTestResult.class);
	}

	
	
}
