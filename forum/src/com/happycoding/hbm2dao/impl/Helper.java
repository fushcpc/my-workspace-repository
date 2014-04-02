package com.happycoding.hbm2dao.impl;

import java.io.File;

import com.happycoding.utils.HBMUtils;

/**
 * @author DavidChen(陈基明) 电话：13480721426 Email: cjmiou@gmail.com
 * @version 2010-4-22 下午07:01:22
 */
public class Helper {
	private static Helper helper = new Helper();

	private Helper() {
	}

	public static Helper getInstance() {
		return helper;
	}


	public void generateDaoImpl(String hbmPath,String templatePath, String outputPath,String templateFileName) throws Exception {
		HBMUtils util = new HBMUtils(hbmPath);
		outputPath = outputPath+File.separator+util.getDaoImplPackagePath();
		String fileName = util.getDaoImplClassFileName();
		if(!HBMUtils.fileExists(outputPath, fileName)){
			String templateContent = HBMUtils.getContent(templatePath+File.separator+templateFileName);

			templateContent = templateContent.replaceAll("@PACKAGE@", util.getDaoImplPackageName());
			templateContent = templateContent.replaceAll("@IMPORTBEANS@", util.getBeanPackageName());
			templateContent = templateContent.replaceAll("@BEANNAME@", util.getBeanName());
			templateContent = templateContent.replaceAll("@DAOPACKAGE@", util.getDaoPackageName());

			HBMUtils.bornFile(templateContent, outputPath, fileName);
		}
	}
}
