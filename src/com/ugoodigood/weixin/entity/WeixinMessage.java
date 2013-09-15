package com.ugoodigood.weixin.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * An entity for weixin message.
 * only support text message 
 * @author meng@tofindaway.com
 * 
 * @version 0.0.1
 *
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class WeixinMessage implements Serializable {

	private static final long serialVersionUID = -8039373649516695373L;

	/** text type */
	public static final String TYPE_TEXT = "<![CDATA[text]]>";
	
	/** image type */
	public static final String TYPE_IMG = "<![CDATA[image]]>";
	
	/** address message */
	public static final String TYPE_ADDRESS = "<![CDATA[location]]>";
	
	/** a link message */
	public static final String TYPE_LINK = "<![CDATA[link]]>";
	
	/** event message */
	public static final String TYPE_EVENT = "<![CDATA[event]]>";
	
	@XmlElement(name = "ToUserName")
	public String ToUserName;

	@XmlElement(name = "FromUserName")
	public String FromUserName;

	@XmlElement(name = "CreateTime")
	public Long CreateTime;

	@XmlElement(name = "MsgType")
	public String MsgType;

	@XmlElement(name = "Content")
	public String Content;

	@XmlElement(name = "MsgId")
	public Long MsgId;

	@Override
	public String toString() {
		return "WeixinMessage [ToUserName=" + ToUserName + ", FromUserName=" + FromUserName + ", CreateTime="
				+ CreateTime + ", MsgType=" + MsgType + ", Content=" + Content + ", MsgId=" + MsgId + "]";
	}
	
	
}
