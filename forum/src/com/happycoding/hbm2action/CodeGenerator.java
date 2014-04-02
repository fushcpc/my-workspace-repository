package com.happycoding.hbm2action;


/**
 * @author DavidChen(陈基明) 电话：13480721426 Email: cjmiou@gmail.com
 * @version 2010-4-22 下午07:15:33
 */
public class CodeGenerator {
	private static String outputPath;
	private static String templatePath;
	//private static List<String> templates=new ArrayList<String>();
	private static String addTemplate;
	private static String deleteTemplate;
	private static String updatePTemplate;
	private static String updateTemplate;
	private static String listTemplate;
	private static int count=0;

	public static void main(String[] args) {
		System.out.println("HappyCoding正在为您生成Action文件...");
		for (String temp : args) {
			if (temp.startsWith("--templatePath=")) {
				templatePath = temp.substring("--templatePath=".length());
			} else if (temp.startsWith("--output=")) {
				outputPath = temp.substring("--output=".length());
			} else if (temp.startsWith("--addTemplate=")) {
				addTemplate=temp.substring("--addTemplate=".length());
			}else if (temp.startsWith("--deleteTemplate=")) {
				deleteTemplate=temp.substring("--deleteTemplate=".length());
			}else if (temp.startsWith("--updatePTemplate=")) {
				updatePTemplate=temp.substring("--updatePTemplate=".length());
			}else if (temp.startsWith("--updateTemplate=")) {
				updateTemplate=temp.substring("--updateTemplate=".length());
			}else if (temp.startsWith("--listTemplate=")) {
				listTemplate=temp.substring("--listTemplate=".length());
			} else {
				++count;
				Helper.getInstance().generateAction(temp, templatePath, outputPath, addTemplate,deleteTemplate,updatePTemplate,updateTemplate,listTemplate);
			}
		}
		System.out.println("恭喜您！HappyCoding已成功生成" + count*5 + "个Action文件...");
	}
}
