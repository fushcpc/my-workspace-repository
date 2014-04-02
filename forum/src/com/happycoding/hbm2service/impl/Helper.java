package com.happycoding.hbm2service.impl;

import java.io.File;

import com.happycoding.utils.HBMUtils;



/**
 * @author DavidChen(陈基明) 电话：13480721426 Email: cjmiou@gmail.com
 * @version 2010-4-22 下午07:01:22
 */
public class Helper {
	private static Helper helper = new Helper();
	//private String spot = HbmUtils.SPOT;
	private Helper(){}
	
	public static Helper getInstance(){
		return helper;
	}
	
	public void generateService(String hbmPath,String templatePath, String outputPath,String templateFileName){
		HBMUtils util = new HBMUtils(hbmPath);
		outputPath = outputPath+File.separator+util.getServiceImplPackagePath();
		String fileName = util.getServiceImplClassFileName();
		if(!HBMUtils.fileExists(outputPath, fileName)){
			String templateContent = HBMUtils.getContent(templatePath+File.separator+templateFileName);
			templateContent=templateContent.replaceAll("@PACKAGE@", util.getServiceImplPackageName());
			templateContent = templateContent.replaceAll("@IMPORTBEANS@", util.getBeanPackageName());
			templateContent = templateContent.replaceAll("@IMPORTDAO@", util.getDaoPackageName());
			templateContent = templateContent.replaceAll("@CLASSNAME@", util.getBeanName());
			templateContent = templateContent.replaceAll("@IMPORTSERVICEINTERFACE@", util.getServicePackageName());
			templateContent=templateContent.replaceAll("@classname@", util.getLowcaseBeanName()); 
			HBMUtils.bornFile(templateContent, outputPath, fileName);
		}
	}
}















