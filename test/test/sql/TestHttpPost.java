package test.sql;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.*;

public class TestHttpPost {

	@Test
	public void testGet() {
		try {
			String xml = "<xml>    <ToUserName>sdjfldsj</ToUserName><FromUserName>hello</FromUserName><CreateTime>315416545</CreateTime></xml>";
			byte[] entity = xml.getBytes();
			URL url = new URL("http://localhost:8080/weixin/wxservice");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setConnectTimeout(1000 * 5);
			con.setReadTimeout(1000 * 5);
			con.setDoOutput(true);
			con.setRequestProperty("Content-Type","text/xml; charset=UTF-8");
	        con.setRequestProperty("Content-Length",String.valueOf(entity.length));//entity为要传输的数据格式为  title=hello&time=20//可以对该数据编码  
			con.connect();
			con.getOutputStream().write(entity);
			
			con.getOutputStream().flush();
			if (con.getResponseCode()  == 200) {
				System.out.println("cool");
				 BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream())); 
				 String line = null;
				 while((line = reader.readLine()) != null) {
					 System.out.println(line);
				 }
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
