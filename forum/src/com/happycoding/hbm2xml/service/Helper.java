package com.happycoding.hbm2xml.service;

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

//	<bean id="itemServie" class="com.bigbuddy.oa.service.impl.DocumentItemServiceImpl"
//		scope="singleton">
//		<property name="dao" ref="itemDao"></property>
//	</bean>
	@SuppressWarnings("unchecked")
	public void generateServiceSpringConfig(String output,String templatePath,String fileName,List<String> hbmFiles) {
//		Document doc = HBMUtils.getSpringRootReadyDocument();
//		Element root = doc.getRootElement();
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
			Element root = doc.getRootElement();
			for (String hbm : hbmFiles) {
				HBMUtils util = new HBMUtils(hbm);
				String beanName = util.getLowcaseBeanName();// 取得小写开头的bean名
				List<Element> list =(List<Element>) root.elements("bean");
				boolean isExited = false;
				for(Element el : list){
					String value = el.attribute("id").getValue();
					if(value.equals(beanName+HBMUtils.SERVICE_EXT)){
						isExited = true;
						break;
					}
				}
				if(!isExited){
					Element bean = root.addElement(beanQName);
					bean.addAttribute("id", beanName + HBMUtils.SERVICE_EXT);
					bean.addAttribute("class", util.getServiceImplPackageName()+HBMUtils.SPOT+util.getServiceImplClassName());
					bean.addAttribute("scope", "singleton");

					Element subBean = bean.addElement(propertyQName);
					subBean.addAttribute("name", beanName+HBMUtils.DAO_EXT);
					subBean.addAttribute("ref", beanName+HBMUtils.DAO_EXT);
				}
			}
			//String outputPath = output+File.separator+fileName;
			HBMUtils.bornDocumentToXML(outputPath, doc);
		} catch (DocumentException e) {
			e.printStackTrace();
			throw new BigbuddyException("打开或者创建文档失败！");
		}
		
	}

}
