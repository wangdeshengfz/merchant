package com.bosssoft.itfinance.epay.v2.merchant.api.dubboservice.exception;

import java.io.Serializable;

import com.bosssoft.itfinance.epay.v2.teamcommon.BaseException;
import com.bosssoft.itfinance.epay.v2.teamcommon.EnumVal;

/**
 * 商户中心业务异常
 * @author wangml
 *
 */
public class MerchantServiceException extends BaseException implements Serializable {

    private static final long serialVersionUID = 1L;

    public MerchantServiceException() {

    }

    public MerchantServiceException(EnumVal errorCode) {
        super(errorCode);
    }


    public MerchantServiceException(EnumVal errorCode, Throwable cause) {
        super(errorCode, cause);
    }

}
