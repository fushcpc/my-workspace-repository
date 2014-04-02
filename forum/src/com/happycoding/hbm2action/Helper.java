package com.happycoding.hbm2action;

import java.io.File;

import com.happycoding.utils.HBMUtils;

/**
 * @author DavidChen(陈基明) 电话：13480721426 Email: cjmiou@gmail.com
 * @version 2010-4-22 下午07:01:22
 */
public class Helper {
	private static Helper helper = new Helper();

	// private String spot = HbmUtils.SPOT;
	private Helper() {
	}

	public static Helper getInstance() {
		return helper;
	}
	
	private String templatePath;
	private String outputPath;
	private HBMUtils util;
	private String addFileName ;
	private String deleteFileName;
	private String listFileName ;
	private String updatePFileName ;
	private String updateFileName ;

	public void generateAction(String hbmPath, String templatePath, //
			String outputPath, String addTemplate,String deleteTemplate,//
			String updatePTemplate,String updateTemplate,String listTemplate) {
		
		this.util= new HBMUtils(hbmPath);
		this.templatePath=templatePath;
		this.outputPath=outputPath = outputPath + File.separator + util.getActionPackagePath()+File.separator+util.getBeanName().toLowerCase();
		
		this.addFileName = "Add" + util.getBeanName() + ".java";
		this.deleteFileName = "Delete" + util.getBeanName() + ".java";
		this.listFileName = "List" + util.getBeanName() + "s.java";
		this.updatePFileName = "UpdateP" + util.getBeanName() + ".java";
		this.updateFileName = "Update" + util.getBeanName() + ".java";
		
		
		if(!HBMUtils.fileExists(outputPath, addFileName)){
			generateAddAction(addTemplate);
		}
		if(!HBMUtils.fileExists(outputPath, deleteFileName)){
			generateDeleteAction(deleteTemplate);
		}
		if(!HBMUtils.fileExists(outputPath, listFileName)){
			generateListAction(listTemplate);
		}
		if(!HBMUtils.fileExists(outputPath, updateFileName)){
			generateUpdateAction(updateTemplate);
		}
		if(!HBMUtils.fileExists(outputPath, updatePFileName)){
			generateUpdatePAction(updatePTemplate);
		}
	}
	
	private void generateAddAction(String templateName){
		String templateContent = HBMUtils.getContent(templatePath + File.separator + templateName);
		templateContent = templateContent.replaceAll("@PACKAGE@", util.getActionPackageName()+HBMUtils.SPOT+util.getBeanName().toLowerCase());
		templateContent = templateContent.replaceAll("@BEANPACKAGENAME@", util.getBeanPackageName());
		templateContent = templateContent.replaceAll("@SERVICEPACKAGENAME@", util.getServicePackageName());
		templateContent = templateContent.replaceAll("@CLASSNAME@", util.getBeanName());
		templateContent = templateContent.replaceAll("@ADDPROPERTIES@", util.getPropertiesString());
		templateContent = templateContent.replaceAll("@SETPROPERTY@", util.getSetUpBeanCode());

		HBMUtils.bornFile(templateContent, outputPath, addFileName);
	}
	
	private void generateDeleteAction(String templateName){
		String templateContent = HBMUtils.getContent(templatePath + File.separator + templateName);
		templateContent = templateContent.replaceAll("@PACKAGE@", util.getActionPackageName()+HBMUtils.SPOT+util.getBeanName().toLowerCase());
		templateContent = templateContent.replaceAll("@BEANPACKAGENAME@", util.getBeanPackageName());
		templateContent = templateContent.replaceAll("@SERVICEPACKAGENAME@", util.getServicePackageName());
		templateContent = templateContent.replaceAll("@CLASSNAME@", util.getBeanName());

		HBMUtils.bornFile(templateContent, outputPath, deleteFileName);
	}
	
	private void generateListAction(String templateName){
		String templateContent = HBMUtils.getContent(templatePath + File.separator + templateName);
		templateContent = templateContent.replaceAll("@PACKAGE@", util.getActionPackageName()+HBMUtils.SPOT+util.getBeanName().toLowerCase());
		templateContent = templateContent.replaceAll("@BEANPACKAGENAME@", util.getBeanPackageName());
		templateContent = templateContent.replaceAll("@SERVICEPACKAGENAME@", util.getServicePackageName());
		templateContent = templateContent.replaceAll("@CLASSNAME@", util.getBeanName());

		HBMUtils.bornFile(templateContent, outputPath, listFileName);
	}
	
	private void generateUpdatePAction(String templateName){
		String templateContent = HBMUtils.getContent(templatePath + File.separator + templateName);
		templateContent = templateContent.replaceAll("@PACKAGE@", util.getActionPackageName()+HBMUtils.SPOT+util.getBeanName().toLowerCase());
		templateContent = templateContent.replaceAll("@BEANPACKAGENAME@", util.getBeanPackageName());
		templateContent = templateContent.replaceAll("@SERVICEPACKAGENAME@", util.getServicePackageName());
		templateContent = templateContent.replaceAll("@CLASSNAME@", util.getBeanName());
		templateContent = templateContent.replaceAll("@classname@", util.getLowcaseBeanName());

		HBMUtils.bornFile(templateContent, outputPath, updatePFileName);
	}
	
	private void generateUpdateAction(String templateName){
		String templateContent = HBMUtils.getContent(templatePath + File.separator + templateName);
		templateContent = templateContent.replaceAll("@PACKAGE@", util.getActionPackageName()+HBMUtils.SPOT+util.getBeanName().toLowerCase());
		templateContent = templateContent.replaceAll("@BEANPACKAGENAME@", util.getBeanPackageName());
		templateContent = templateContent.replaceAll("@SERVICEPACKAGENAME@", util.getServicePackageName());
		templateContent = templateContent.replaceAll("@CLASSNAME@", util.getBeanName());
		templateContent = templateContent.replaceAll("@PROPERTIES@", util.getPropertiesString());
		templateContent = templateContent.replaceAll("@SETPROPERTY@", util.getSetUpBeanCode());

		HBMUtils.bornFile(templateContent, outputPath,updateFileName);
	}
}
