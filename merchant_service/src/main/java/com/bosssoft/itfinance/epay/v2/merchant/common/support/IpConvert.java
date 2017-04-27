package com.bosssoft.itfinance.epay.v2.merchant.common.support;

import java.net.InetAddress;
import java.net.UnknownHostException;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class IpConvert extends ClassicConverter
{

	@Override
	public String convert(ILoggingEvent event)
	{
		try
		{
			InetAddress addr = InetAddress.getLocalHost();
			String ip = addr.getHostAddress().toString();
/*			String hostName = addr.getHostName();
			hostName  = hostName.replace(" ", "_");
			return hostName+"_"+ip;*/
			return ip;
		} catch (UnknownHostException e)
		{
			return "can't find ip.";
		}
	}

}
