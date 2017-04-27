package com.bosssoft.itfinance.epay.v2.merchant.service.common.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.config.ProtocolConfig;

public class MerchantContextListener implements ServletContextListener {
	
	private final static Logger log = LoggerFactory.getLogger(MerchantContextListener.class);
	
	/**
     * 这个方法在Web应用服务做好接受请求的时候被调用。
     * 
     * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
     */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
	    log.info("=============================服务器成功启动！版本"+"=============================");
	}
	
	/**
     * 这个方法在Web应用服务被移除，没有能力再接受请求的时候被调用。
     * 服务器关闭时候关闭长连接与连接池
	 * 防止内存泄漏与AMQ连接不会关闭等问题
     * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
     */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		ProtocolConfig.destroyAll();//关闭dubbo服务端口
		log.info("=============================服务器成功关闭！版本"+"=============================");
	}

}
