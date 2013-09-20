package com.ugoodigood.weixin.entity;

import java.io.Serializable;

/**
 * 请求应答实体类，用于保存自定义应答信息。
 * 
 * @author meng
 *
 */
public class QuestAnswer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String quest;
	
	private String answer;
	
	private String defaultMessage;
	
}
