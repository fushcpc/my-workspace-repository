package com.happycoding.hbm2jsp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

import com.happycoding.exception.BigbuddyException;
import com.happycoding.utils.HBMUtils;

/**
 * @author DavidChen(陈基明) 电话：13480721426 Email: cjmiou@gmail.com
 * @version 2010-4-22 下午07:01:22
 */
public class Helper {
	private static Helper helper = new Helper();
	private String separator = File.separator;
	private Properties props;
	private HBMUtils util;
	private Field[] fields;

	private Helper() {
	}

	public static Helper getInstance() {
		return helper;
	}

	public void generateJSP(String hbmPath, String propPath, String templatePath, String outputPath, String addTemplateName, String listTemplateName, String updateTemplateName) {
		this.util = new HBMUtils(hbmPath);
		outputPath = outputPath + separator + util.getBeanName();
		try {
			File file = new File(propPath);
			InputStream is = new FileInputStream(file);
			this.props = new Properties();
			this.props.load(is);
			this.fields = util.getDeclaredFields();
			// outputPath = outputPath+separator+util.getBeanName();
			String addFileName = "add" + util.getBeanName() + ".jsp";
			String listFileName = "list" + util.getBeanName() + "s.jsp";
			String updateFileName = "update" + util.getBeanName() + ".jsp";

			file = new File(outputPath, addFileName);
			if (!file.exists()) {
				String resource = HBMUtils.getContent(templatePath + separator + addTemplateName);
				String changeContent = this.props.getProperty("addJSP");
				this.generateAddJSP(resource, changeContent, outputPath, addFileName);
			}
			file = new File(outputPath, updateFileName);
			if (!file.exists()) {
				String resource = HBMUtils.getContent(templatePath + separator + updateTemplateName);
				String changeContent = this.props.getProperty("updateJSP");
				this.generateUpdateJSP(resource, changeContent, outputPath, updateFileName);
			}
			file = new File(outputPath, listFileName);
			if (!file.exists()) {
				String resource = HBMUtils.getContent(templatePath + separator + listTemplateName);
				String tableHead = this.props.getProperty("tableHead");
				String tableContent = this.props.getProperty("tableContent");
				this.generateListJSP(resource, tableHead, tableContent, outputPath, listFileName);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new BigbuddyException("找不到JSP的模块文件！");
		} catch (IOException e) {
			e.printStackTrace();
			throw new BigbuddyException("读取输入流时发生错误!");
		}

	}

	private void generateAddJSP(String resource, String changeContent, String outputPath, String fileName) {
		StringBuffer sb = new StringBuffer();
		for (Field field : this.fields) {
			if (!field.getName().equals("id")) {
				sb.append(changeContent.replaceAll("@PROPERTY@", field.getName()));
			}
		}
		resource = resource.replace("@ADD@", sb.toString());
		resource = resource.replace("@CLASSNAME@", util.getBeanName());
		HBMUtils.bornFile(resource, outputPath, fileName);
	}

	private void generateUpdateJSP(String resource, String changeContent, String outputPath, String fileName) {
		StringBuffer sb = new StringBuffer();
		for (Field field : this.fields) {
			if (!field.getName().equals("id")) {
				sb.append(changeContent.replaceAll("@PROPERTY@", field.getName()).replace("@classname@", util.getLowcaseBeanName()));
			}
		}
		resource = resource.replace("@UPDATE@", sb.toString());
		resource = resource.replace("@CLASSNAME@", util.getBeanName());
		HBMUtils.bornFile(resource, outputPath, fileName);
	}

	private void generateListJSP(String resource, String tableHead, String tableContent, String outputPath, String listFileName) {
		StringBuffer sb = new StringBuffer();
		StringBuffer s = new StringBuffer();
		for (Field field : this.fields) {
			sb.append(tableHead.replaceAll("@PROPERTY@", field.getName()));
			s.append(tableContent.replaceAll("@PROPERTY@", field.getName()));
		}
		resource = resource.replace("@head@", sb.toString());
		resource = resource.replace("@content@", s.toString());
		resource = resource.replace("@CLASSNAME@", util.getBeanName());
		HBMUtils.bornFile(resource, outputPath, listFileName);

	}
}
