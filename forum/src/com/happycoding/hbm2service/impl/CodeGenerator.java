package com.happycoding.hbm2service.impl;



/**
 * @author DavidChen(陈基明) 电话：13480721426 Email: cjmiou@gmail.com
 * @version 2010-4-22 下午07:15:33
 */
public class CodeGenerator {
	private static String outputPath;
	private static String templatePath;
	private static String templateName;
	private static int count;


	public static void main(String[] args) {
		System.out.println("HappyCoding正在为您生成Service实现类文件...");
		for (String temp : args) {
			if (temp.startsWith("--templatePath=")) {
				templatePath = temp.substring("--templatePath=".length());
			} else if (temp.startsWith("--output=")) {
				outputPath = temp.substring("--output=".length());
			} else if (temp.startsWith("--templateName=")) {
				templateName = temp.substring("--templateName=".length());
			} else {
				++count;
				try {
					Helper.getInstance().generateService(temp, templatePath, outputPath, templateName);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("恭喜您！HappyCoding已成功生成"+count+"个Service实现类文件...");
	}
}
