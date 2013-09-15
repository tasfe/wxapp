package com.ugoodigood.weixin.utils;

import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXB;

import org.junit.Test;

import com.ugoodigood.weixin.common.AppException;
import com.ugoodigood.weixin.entity.WeixinMessage;

/**
 * An util for convert xml to entity. or from entity to xml
 * 
 * @author meng
 * @version 0.0.1
 * 
 */
public class ConvertUtil {

	/**
	 * convert inputStream to Message
	 * 
	 * @param inputStream
	 * @return
	 */
	public static WeixinMessage convertStream2Message(InputStream inputStream) {
		if (inputStream == null) {
			throw new AppException(0, "null parameters");
		}
		WeixinMessage msg = JAXB.unmarshal(inputStream, WeixinMessage.class);
		return msg;
	}

	/**
	 * convert xml String to Message
	 * 
	 * @param xml
	 * @return message entity
	 */
	public static WeixinMessage convertString2Message(String xml) {
		if (xml == null) {
			throw new AppException(0, "null parameters");
		}
		StringReader reader = new StringReader(xml);
		try {
			WeixinMessage msg = JAXB.unmarshal(reader, WeixinMessage.class);
			return msg;
		} catch (Exception e) {
			throw new AppException(3);
		}
	}

	/**
	 * convert message to string with xml format
	 * 
	 * @param msg
	 * @return
	 */
	public static String convertMessage2String(WeixinMessage msg) {
		StringWriter writer = new StringWriter();
		JAXB.marshal(msg, writer);
		return writer.getBuffer().toString();
	}

	@Test
	public void testConvert() {
		WeixinMessage msg = new WeixinMessage();
		msg.FromUserName = "hello";
		msg.ToUserName = "sdjfldsj";
		msg.CreateTime = 315416545L;
		String xml = ConvertUtil.convertMessage2String(msg);
		System.out.println(xml);
	}

}
