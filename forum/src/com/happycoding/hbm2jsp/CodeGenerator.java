package com.happycoding.hbm2jsp;



/**
 * @author DavidChen(陈基明) 电话：13480721426 Email: cjmiou@gmail.com
 * @version 2010-4-22 下午07:15:33
 */
public class CodeGenerator {
	private static String outputPath;
	private static String templatePath;
	private static String addTemplateName;
	private static String listTemplateName;
	private static String updateTemplateName;
	private static String jSPPropFilePath;
	private static int count;


	public static void main(String[] args) {
		System.out.println("HappyCoding正在为您生成JSP文件...");
		for (String temp : args) {
			if (temp.startsWith("--templatePath=")) {
				templatePath = temp.substring("--templatePath=".length());
			} else if (temp.startsWith("--outputPath=")) {
				outputPath = temp.substring("--outputPath=".length());
			}else if(temp.startsWith("--JSPPropFilePath=")){
				jSPPropFilePath=temp.substring("--JSPPropFilePath=".length());
			}else if (temp.startsWith("--addTemplate=")) {
				addTemplateName = temp.substring("--addTemplate=".length());
			}else if (temp.startsWith("--listTemplate=")) {
				listTemplateName = temp.substring("--listTemplate=".length());
			}else if (temp.startsWith("--updateTemplate=")) {
				updateTemplateName = temp.substring("--updateTemplate=".length());
			} else {
				++count;
				try {
					Helper.getInstance().generateJSP(temp, jSPPropFilePath, templatePath, outputPath, addTemplateName, listTemplateName, updateTemplateName);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("恭喜您！HappyCoding已成功生成"+count+"个JSP文件...");
	}
}
