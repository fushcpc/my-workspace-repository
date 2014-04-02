package com.happycoding.hbm2dao;

import static java.io.File.separator;

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

	public void generateDao(String hbmPath, String templatePath, String templateName, String outputPath) throws Exception {
		HBMUtils util = new HBMUtils(hbmPath);
		outputPath = outputPath + separator + util.getDaoPackagePath();
		String fileName = util.getDaoClassFileName();
		if (!HBMUtils.fileExists(outputPath, fileName)) {
			String templateContent = HBMUtils.getContent(templatePath + separator + templateName);

			templateContent = templateContent.replaceAll("@PACKAGE@", util.getDaoPackageName());
			templateContent = templateContent.replaceAll("@IMPORTBEANS@", util.getBeanPackageName());
			templateContent = templateContent.replaceAll("@BEANNAME@", util.getBeanName());

			HBMUtils.bornFile(templateContent, outputPath, fileName);
		}
	}
}
