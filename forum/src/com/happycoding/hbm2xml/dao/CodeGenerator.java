package com.happycoding.hbm2xml.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DavidChen(陈基明) 电话：13480721426 Email: cjmiou@gmail.com
 * @version 2010-4-22 下午07:15:33
 */
public class CodeGenerator {
	private static String outputPath;
	private static List<String> hbmFiles = new ArrayList<String>();
	private static String templateName;
	private static String templatePath;

	public static void main(String[] args) {
		System.out.println("HappyCoding正在为您生成Spring的Dao配置文件...");
		for (String temp : args) {
			if (temp.startsWith("--outputPath=")) {
				outputPath = temp.substring("--outputPath=".length());
			} else if (temp.startsWith("--templatePath=")) {
				templatePath = temp.substring("--templatePath=".length());
			}  else if (temp.startsWith("--templateName=")) {
				templateName = temp.substring("--templateName=".length());
			} else {
				hbmFiles.add(temp);
			}
		}
		Helper.getInstance().generateDaoSpringConfig(outputPath,templatePath, templateName,  hbmFiles);
		System.out.println("恭喜您！HappyCoding已成功生成Spring的Dao配置文件...");
	}
}
