package com.happycoding.hbm2xml.action;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;
import org.dom4j.io.SAXReader;

import com.happycoding.exception.BigbuddyException;
import com.happycoding.utils.HBMUtils;

/**
 * @author DavidChen(陈基明) 电话：13480721426 Email: cjmiou@gmail.com
 * @version 2010-4-22 下午07:01:22
 */
@SuppressWarnings("unchecked")
public class Helper {
	private static Helper helper = new Helper();
	private Namespace defaultSpingNamespace = new Namespace("", "http://www.springframework.org/schema/beans");
	private QName beanQName = new QName("bean", defaultSpingNamespace);
	private QName propertyQName = new QName("property", defaultSpingNamespace);

	private Helper() {
	}

	public static Helper getInstance() {
		return helper;
	}


	public void generateServiceActionConfig(String output,String templatePath,String fileName,List<String> hbmFiles) {
		String outputPath = output+File.separator+fileName;
		SAXReader reader = new SAXReader();
		Document doc;
		try {
			File file = new File(outputPath);
			if(file.exists()){
				doc = reader.read(file);
			}else{
				doc = reader.read(new File(templatePath, fileName));
			}
			
			Element beans = doc.getRootElement();
			for (String hbm : hbmFiles) {
				HBMUtils util = new HBMUtils(hbm);
				String beanActionName = util.getActionPackageName()+HBMUtils.SPOT+util.getBeanName().toLowerCase();
				List<Element> list =(List<Element>) beans.elements("bean");
				boolean isExited = false;
				for(Element el : list){
					String value = el.attribute("class").getValue();
					if(value.startsWith(beanActionName)){
						isExited = true;
						break;
					}
				}
				if(!isExited){
					//add
					beans.addComment("开始"+util.getBeanName()+"的配置");
					Element element = beans.addElement(beanQName);
					element.addAttribute("id", "add"+util.getBeanName());
					element.addAttribute("class", util.getActionPackageName()+HBMUtils.SPOT//
							+util.getBeanName().toLowerCase()+HBMUtils.SPOT+"Add"+util.getBeanName());
					element.addAttribute("scope", "prototype");
					Element property = element.addElement(propertyQName);
					property.addAttribute("name", "service");
					property.addAttribute("ref", util.getLowcaseBeanName()+"Service");
					//delete
					element = beans.addElement(beanQName);
					element.addAttribute("id", "delete"+util.getBeanName());
					element.addAttribute("class", util.getActionPackageName()+HBMUtils.SPOT//
							+util.getBeanName().toLowerCase()+HBMUtils.SPOT+"Delete"+util.getBeanName());
					element.addAttribute("scope", "prototype");
					property = element.addElement(propertyQName);
					property.addAttribute("name", "service");
					property.addAttribute("ref", util.getLowcaseBeanName()+"Service");
					//updateP
					element = beans.addElement(beanQName);
					element.addAttribute("id", "updateP"+util.getBeanName());
					element.addAttribute("class", util.getActionPackageName()+HBMUtils.SPOT//
							+util.getBeanName().toLowerCase()+HBMUtils.SPOT+"UpdateP"+util.getBeanName());
					element.addAttribute("scope", "prototype");
					property = element.addElement(propertyQName);
					property.addAttribute("name", "service");
					property.addAttribute("ref", util.getLowcaseBeanName()+"Service");
					//update
					element = beans.addElement(beanQName);
					element.addAttribute("id", "update"+util.getBeanName());
					element.addAttribute("class", util.getActionPackageName()+HBMUtils.SPOT//
							+util.getBeanName().toLowerCase()+HBMUtils.SPOT+"Update"+util.getBeanName());
					element.addAttribute("scope", "prototype");
					property = element.addElement(propertyQName);
					property.addAttribute("name", "service");
					property.addAttribute("ref", util.getLowcaseBeanName()+"Service");
					//list
					element = beans.addElement(beanQName);
					element.addAttribute("id", "list"+util.getBeanName()+"s");
					element.addAttribute("class", util.getActionPackageName()+HBMUtils.SPOT//
							+util.getBeanName().toLowerCase()+HBMUtils.SPOT+"List"+util.getBeanName()+"s");
					element.addAttribute("scope", "prototype");
					property = element.addElement(propertyQName);
					property.addAttribute("name", "service");
					property.addAttribute("ref", util.getLowcaseBeanName()+"Service");
					beans.addComment("结束"+util.getBeanName()+"的配置");
				}
			}
			HBMUtils.bornDocumentToXML(outputPath, doc);
		} catch (DocumentException e) {
			e.printStackTrace();
			throw new BigbuddyException("无法创建XML文档对象，你的路径是否有问题？");
		}
	}

}
