package com.happycoding.hbm2xml.infrastructure;

import static java.io.File.separator;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

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

//	private Document getReadyDocument() {
//		Namespace n1 = new Namespace("", "http://www.springframework.org/schema/beans");
//		Namespace n2 = new Namespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
//		Namespace n3 = new Namespace("p", "http://www.springframework.org/schema/p");
//
//		Document document = DocumentHelper.createDocument();
//		Element root = document.addElement("beans");
//		root.add(n1);
//		root.add(n2);
//		root.add(n3);
//
//		QName qName = new QName("schemaLocation", n2);
//		root.addAttribute(qName, "http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.0.xsd");
//
//		return document;
//	}

//	public void generateSpringCfgFiles(String dbPropPath, String hbPropPath, String fileName, String filePath) {
//		
//		InputStream is = null;
//		FileWriter writer = null;
//		XMLWriter out = null;
//		try {
//			is = new FileInputStream(dbPropPath);
//			Properties props = new Properties();
//			props.load(is);
//			Enumeration<?> enums = props.propertyNames();
//			String dataSourceClass = props.getProperty("dataSourceClass");
//			Element bean = root.addElement(new QName("bean", n1));
//			bean.addAttribute("id", "dataSource");
//			bean.addAttribute("class", dataSourceClass);
//			bean.addAttribute("destroy-method", "close");
//			while (enums.hasMoreElements()) {
//				String name = (String) enums.nextElement();
//				String value = (String) props.get(name);
//				if (!name.equals("dataSourceClass")) {
//					Element subEle = bean.addElement("property");
//					subEle.addAttribute("name", name);
//					subEle.addAttribute("value", value);
//				}
//			}
//
//			// 设置hibernate配置
//			Element hibernateBean = root.addElement(new QName("bean", n1));
//			hibernateBean.addAttribute("id", "sessionFactory");
//			hibernateBean.addAttribute("class", "org.springframework.orm.hibernate3.LocalSessionFactoryBean");
//			Element e1 = hibernateBean.addElement(new QName("property", n1));
//			e1.addAttribute("name", "dataSource");
//			e1.addAttribute("ref", "dataSource");
//
////			<property name="dataSource" ref="dataSource"></property>
////			<property name="hibernateProperties">
////				<props>
////					<prop key="hibernate.dialect">org.hibernate.dialect.Oracle10gDialect</prop>
////					<prop key="hibernate.show_sql">true</prop>
////					<prop key="hibernate.hbm2ddl.auto">update</prop>
////				</props>
////			</property>
////			<property name="mappingResources">
////				<list>
////					<value>DocumentCatalog.hbm.xml</value>
////					<value>DocumentItem.hbm.xml</value>
////				</list>
////			</property>
//			Element hibernateProperties = hibernateBean.addElement(new QName("property", n1));
//			hibernateProperties.addAttribute("name", "hibernateProperties");
//
//			Element pros = hibernateProperties.addElement(new QName("props", n1));
//
//			is = new FileInputStream(hbPropPath);
//			props = new Properties();
//			props.load(is);
//			enums = props.propertyNames();
//			while (enums.hasMoreElements()) {
//				String name = (String) enums.nextElement();
//				String value = (String) props.getProperty(name);
//				Element prop = pros.addElement(new QName("prop", n1));
//				prop.addAttribute("key", name).setText(value);
//				// prop.addAttribute("value", value);
//			}
//
//			File file = new File(filePath + separator + fileName);
//			writer = new FileWriter(file);
//
//			OutputFormat format = OutputFormat.createPrettyPrint();
//			format.setEncoding("UTF-8");// 默认其实就是utf-8
//			format.setIndent("    "); // 设置空4个空格，prettyPrint默认是两个空格
//
//			out = new XMLWriter(writer, format);
//			out.write(document);
//			out.flush();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (out != null) {
//					out.close();
//				}
//				if (writer != null) {
//					writer.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
	public void generateSpringCfgFiles(String dbPropPath, String hbPropPath, String templatePath, String templateName, List<String> hbms, String outputPath) {
		outputPath = outputPath+File.separator+templateName;
		SAXReader reader = new SAXReader();
		Document doc;
		InputStream is;
		try {
			is = new FileInputStream(dbPropPath);
			Properties props = new Properties();
			props.load(is);
			Enumeration<?> enums = props.propertyNames();
			String dataSourceClass = props.getProperty("dataSourceClass");
			File file = new File(outputPath);
			if(file.exists()){
//				doc = reader.read(file);
				return ;//如果已经存在，则不再生成
			}else{
				System.out.println(templatePath+"==========="+templateName);
				doc = reader.read(new File(templatePath, templateName));
			}
			Element root = doc.getRootElement();
			Element bean = root.addElement("bean");
			bean.addAttribute("id", "dataSource");
			bean.addAttribute("class", dataSourceClass);
			bean.addAttribute("destroy-method", "close");
			while (enums.hasMoreElements()) {
				String name = (String) enums.nextElement();
				String value = (String) props.get(name);
				if (!name.equals("dataSourceClass")) {
					Element subEle = bean.addElement("property");
					subEle.addAttribute("name", name);
					subEle.addAttribute("value", value);
				}
			}
			
			Element hibernateBean = root.addElement("bean");
			hibernateBean.addAttribute("id", "sessionFactory");
			hibernateBean.addAttribute("class", "org.springframework.orm.hibernate3.LocalSessionFactoryBean");
			Element e1 = hibernateBean.addElement("property");
			e1.addAttribute("name", "dataSource");
			e1.addAttribute("ref", "dataSource");
			
			Element hibernateProperties = hibernateBean.addElement("property");
			hibernateProperties.addAttribute("name", "hibernateProperties");

			Element pros = hibernateProperties.addElement("props");

			is = new FileInputStream(hbPropPath);
			props = new Properties();
			props.load(is);
			enums = props.propertyNames();
			while (enums.hasMoreElements()) {
				String name = (String) enums.nextElement();
				String value = (String) props.getProperty(name);
				Element prop = pros.addElement("prop");
				prop.addAttribute("key", name).setText(value);
				// prop.addAttribute("value", value);
			}
			Element list = hibernateBean.addElement("property").addAttribute("name", "mappingResources").addElement("list");
			for(String hbm :hbms){
				list.addElement("value").setText(hbm.substring(hbm.lastIndexOf(separator)+1));
			}
			HBMUtils.bornDocumentToXML(outputPath, doc);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}


	