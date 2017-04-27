package com.bosssoft.itfinance.epay.v2.merchant.api.dubboservice;

import java.util.List;

import com.bosssoft.itfinance.epay.v2.merchant.api.dubboservice.exception.MerchantServiceException;
import com.bosssoft.itfinance.epay.v2.merchant.api.dubboservice.params.test.SysConfigTestQueryParam;
import com.bosssoft.itfinance.epay.v2.merchant.api.dubboservice.results.test.SysConfigTestResult;



/**
 * 配置测试表
 * @author wangml
 *
 */
public interface ISysConfigTestService {
	
	/**
	 * 测试配置信息查询
	 * @param sysConfigTestQueryParam
	 * @return
	 * @throws MerchantServiceException
	 */
	List<SysConfigTestResult> querySysConfigTest(SysConfigTestQueryParam sysConfigTestQueryParam) throws MerchantServiceException;
	
}
