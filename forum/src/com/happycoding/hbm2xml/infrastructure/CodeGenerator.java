package com.happycoding.hbm2xml.infrastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DavidChen(陈基明) 电话：13480721426 Email: cjmiou@gmail.com
 * @version 2010-4-22 下午07:15:33
 */
public class CodeGenerator {
	private static String outputPath;
	//private static String fileName;
	private static String dbPropPath;
	private static String hbPropPath;
	private static String templateName;
	private static String templatePath;
	private static List<String> hbms=new ArrayList<String>();

	public static void main(String[] args) {
		System.out.println("HappyCoding正在为您生成Spring的数据库配置文件...");
		for (String temp : args) {
			if (temp.startsWith("--outputPath=")) {
				outputPath = temp.substring("--outputPath=".length());
			}else if(temp.startsWith("--templatePath=")){
				templatePath=temp.substring("--templatePath=".length());
			}
//			else if (temp.startsWith("--fileName=")) {
//				fileName = temp.substring("--fileName=".length());
//			}
			else if(temp.startsWith("--templateName=")){
				templateName = temp.substring("--templateName=".length());
			} else if(temp.startsWith("--dbPropPath=")){
				dbPropPath=temp.substring("--dbPropPath=".length());
			}else if(temp.startsWith("--hbPropPath=")){
				hbPropPath=temp.substring("--hbPropPath=".length());
			}else{
				hbms.add(temp);
			}
		}
		Helper.getInstance().generateSpringCfgFiles(dbPropPath, hbPropPath,templatePath,templateName,hbms, outputPath);
		System.out.println("恭喜您！HappyCoding已成功生成Spring的数据库配置文件...");
	}
}
