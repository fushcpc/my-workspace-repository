package com.happycoding.hbm2xml.action;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DavidChen(陈基明) 电话：13480721426 Email: cjmiou@gmail.com
 * @version 2010-4-22 下午07:15:33
 */
public class CodeGenerator {
	private static String outputPath;
	private static String templatePath;
	private static String springActionCfgTemplateName;
	private static List<String> hbmFiles = new ArrayList<String>();

	public static void main(String[] args) {
		System.out.println("HappyCoding正在为您生成Spring的Action配置文件...");
		for (String temp : args) {
			if (temp.startsWith("--outputPath=")) {
				outputPath = temp.substring("--outputPath=".length());
			} else if (temp.startsWith("--templatePath=")) {
				templatePath = temp.substring("--templatePath=".length());
			}else if (temp.startsWith("--springActionCfgTemplateName=")) {
				springActionCfgTemplateName = temp.substring("--springActionCfgTemplateName=".length());
			} else {
				hbmFiles.add(temp);
			}
		}
		Helper.getInstance().generateServiceActionConfig(outputPath,templatePath, springActionCfgTemplateName, hbmFiles);
		System.out.println("恭喜您！HappyCoding已成功生成Spring的Action配置文件...");
	}
}
