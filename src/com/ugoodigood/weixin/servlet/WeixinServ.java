package com.ugoodigood.weixin.servlet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ugoodigood.weixin.entity.WeixinMessage;
import com.ugoodigood.weixin.utils.ConvertUtil;

/**
 * Servlet implementation class WeixinServ
 */
public class WeixinServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Logger log = Logger.getLogger(getClass());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WeixinServ() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		log.info("get a request" + request.getRequestURL() + "; params:" + request.getParameterMap() + "\n");
		String echostr = request.getParameter("echostr");

		if (echostr != null) {
			OutputStreamWriter output = new OutputStreamWriter(response.getOutputStream());
			output.write(echostr);
			output.flush();
			output.close();
		} else {
			File file = new File(this.getServletConfig().getServletContext().getRealPath("/") + "/msg.log");
			if (!file.exists()) {
				file.createNewFile();
				log.info("create log file : " + file.getAbsolutePath());
			}

			FileWriter writer = new FileWriter(file, true);
			StringBuilder strBuilder = new StringBuilder();
			InputStream is = request.getInputStream();

			InputStreamReader reader = new InputStreamReader(is);
			char[] cbuf = new char[1024];

			int length = 0;
			while ((length = reader.read(cbuf)) > 0) {
				strBuilder.append(cbuf, 0, length);
			}
			reader.close();
			writer.close();
			if (strBuilder.length() > 10) {
				WeixinMessage msg = ConvertUtil.convertString2Message(strBuilder.toString());
				if (msg != null) {
					log.info(msg);
					OutputStreamWriter output = new OutputStreamWriter(response.getOutputStream());
					String from = msg.FromUserName;
					msg.FromUserName = msg.ToUserName;
					msg.ToUserName = from;
					msg.CreateTime += 5;
					output.write(ConvertUtil.convertMessage2String(msg));
					output.flush();
					output.close();
				}
			}
		}

	}

}
