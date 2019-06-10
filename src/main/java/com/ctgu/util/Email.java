package com.ctgu.util;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	/**
	 * 
	 * @param to                收件人
	 * @param from              发件人
	 * @param authorizationCode qq授权码
	 * @param verificationCode  发出去的消息，此处是验证码
	 * @param password
	 * @return
	 */
	public static boolean sendQQEmail(String to, String from, String authorizationCode, String verificationCode) {
		verificationCode = "Chase提醒您:\n您正在修改您的密码请注意安全\n验证码为:" + verificationCode;
		try {
			// 收件人电子邮箱
//	      String to = "2787116449@qq.com";
			// 发件人电子邮箱
//	      String from = "1131497375@qq.com";
			// 指定发送邮件的主机为 smtp.qq.com
			String host = "smtp.qq.com"; // QQ 邮件服务器
			// 获取系统属性
			Properties properties = System.getProperties();
			// 设置邮件服务器
			properties.setProperty("mail.smtp.host", host);
			properties.put("mail.smtp.auth", "true");
			// 获取默认session对象
			Session session = Session.getDefaultInstance(properties, new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
//	         return new PasswordAuthentication("1131497375@qq.com", "jqvaexsqxcrfiijf"); //发件人邮件用户名、授权码
					return new PasswordAuthentication(from, authorizationCode); // 发件人邮件用户名、授权码
				}
			});
			try {
				// 创建默认的 MimeMessage 对象
				MimeMessage message = new MimeMessage(session);
				// Set From: 头部头字段
				message.setFrom(new InternetAddress(from));
				// Set To: 头部头字段
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				// Set Subject: 头部头字段
				message.setSubject("您正在修改密码");
				// 设置消息体
				message.setText(verificationCode);
				// 发送消息
				Transport.send(message);
				System.out.println("Sent message successfully....from chase");
				return true;
			} catch (MessagingException mex) {
				mex.printStackTrace();
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public static String getCode() {
		String str = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";
		StringBuilder sb = new StringBuilder(4);
		for (int i = 0; i < 4; i++) {
			char ch = str.charAt(new Random().nextInt(str.length()));
			sb.append(ch);
		}
		return sb.toString();
	}

	public static String genRandomPassword() {
		int pwd_len = 10;
		// 35是因为数组是从0开始的，26个字母+10个数字
		final int maxNum = 36;
		int i; // 生成的随机数
		int count = 0; // 生成的密码的长度
		char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		StringBuffer pwd = new StringBuffer("");
		Random r = new Random();
		while (count < pwd_len) {
			// 生成随机数，取绝对值，防止生成负数，
			i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为36-1
			if (i >= 0 && i < str.length) {
				pwd.append(str[i]);
				count++;
			}
		}

		return pwd.toString();
	}

}