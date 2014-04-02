package com.happycoding.utils;

import static java.io.File.separator;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.happycoding.exception.BigbuddyException;

/**
 * @author DavidChen(陈基明) 电话：13480721426 Email: cjmiou@gmail.com
 * @version 2010-4-28 下午01:59:46
 */
public class HBMUtils {
	private String beanName;
	private String beanFullName;
	//
	private String beanPackageName;
	private String projectPackageName;
	private String servicePackageName;
	private String serviceImplPackageName;
	private String daoPackageName;
	private String daoImplPackageName;
	private String actionPackageName;
	//
	private String beanPackagePath;
	private String servicePakcagePath;
	private String serviceImplPackagePath;
	private String daoPackagePath;
	private String daoImplPackagePath;
	private String actionPackagePath;
	//
	private String serviceClassName;
	private String serviceImplClassName;
	private String daoClassName;
	private String daoImplClassName;
	//
	private String lowcaseBeanName;
	private String serviceLowcaseClassName ;
	private String serviceImplLowcaseImplClassName;
	private String daoLowcaseClassName;
	private String daoImplLowcaseClassName;
	
	private String daoClassFileName;
	private String daoImplClassFileName;
	private String serviceClassFileName;
	private String serviceImplClassFileName;
	
	private Element root;
	private Document doc;

	public final static String SPOT = ".";
	public final static String SERVICE_EXT="Service";
	public final static String DAO_EXT="Dao";
	public final static String SESSION_FACTORY_NAME="sessionFactory";

	public HBMUtils(String hbmPath) {
		File file = new File(hbmPath);
		SAXReader read = new SAXReader();
		try {
			this.doc = read.read(file);
			this.root = doc.getRootElement();
			this.beanFullName = this.getBeanFullName(root);
			int lastSpotIndex = this.beanFullName.lastIndexOf(SPOT);
			this.beanName = beanFullName.substring(lastSpotIndex + 1);
			this.lowcaseBeanName = this.getFirstLetterLowcase(beanName);
			this.beanPackageName = beanFullName.substring(0, lastSpotIndex);
			lastSpotIndex = beanPackageName.lastIndexOf(SPOT);
			this.projectPackageName = beanPackageName.substring(0, lastSpotIndex);
			this.servicePackageName = projectPackageName + SPOT + "service";
			this.serviceImplPackageName = this.servicePackageName + SPOT + "impl";
			this.daoPackageName = projectPackageName + SPOT + "dao";
			this.daoImplPackageName = this.daoPackageName + SPOT + "impl";
			this.actionPackageName = projectPackageName + SPOT + "action";
			//
			this.beanPackagePath = this.beanPackageName.replace(SPOT, separator);
			this.daoPackagePath = this.daoPackageName.replace(SPOT, separator);
			this.daoImplPackagePath = this.daoImplPackageName.replace(SPOT, separator);
			this.servicePakcagePath = this.servicePackageName.replace(SPOT, separator);
			this.serviceImplPackagePath = this.serviceImplPackageName.replace(SPOT, separator);
			this.actionPackagePath = this.actionPackageName.replace(SPOT, separator);
			
			//
			this.daoClassFileName = this.beanName+"Dao"+".java";
			this.daoImplClassFileName = this.beanName+"DaoImpl"+".java";
			this.serviceClassFileName = this.beanName+"Service"+".java";
			this.serviceImplClassFileName = this.beanName+"ServiceImpl"+".java";
			//
			this.daoClassName = this.beanName+"Dao";
			this.daoImplClassName = this.beanName+"DaoImpl";
			this.serviceClassName = this.beanName+"Service";
			this.serviceImplClassName = this.beanName+"ServiceImpl";
			
			this.daoLowcaseClassName = this.getFirstLetterLowcase(daoClassName);
			this.daoImplLowcaseClassName = this.getFirstLetterLowcase(daoImplClassName);
			this.serviceLowcaseClassName = this.getFirstLetterLowcase(serviceClassName);
			this.serviceImplLowcaseImplClassName = this.getFirstLetterLowcase(serviceImplClassName);
			
		} catch (DocumentException e) {
			e.printStackTrace();
			throw new BigbuddyException("读取Document文件时出错！");
		}
	}

	private String getBeanFullName(Element root) {
		String packageVal = root.attributeValue("package");
		String name = root.element("class").attributeValue("name");
		if (null == packageVal) {
			return name;
		}
		int index = name.indexOf(SPOT);
		if (-1 == index) {
			return packageVal + SPOT + name;
		}
		return name;
	}
	
	public static Document getSpringRootReadyDocument() {
		Namespace n1 = new Namespace("", "http://www.springframework.org/schema/beans");
		Namespace n2 = new Namespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
		Namespace n3 = new Namespace("p", "http://www.springframework.org/schema/p");

		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("beans");
		root.add(n1);
		root.add(n2);
		root.add(n3);

		QName qName = new QName("schemaLocation", n2);
		root.addAttribute(qName, "http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.0.xsd");
		return document;
	}

	public static void bornDocumentToXML(String outputPath, Document document) {
		XMLWriter out = null;
		FileWriter writer = null;
		try {
			File file = new File(outputPath);
			writer = new FileWriter(file);
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("UTF-8");// 默认其实就是utf-8
			format.setIndent("    "); // 设置空4个空格，prettyPrint默认是两个空格

			out = new XMLWriter(writer, format);
			out.write(document);
			out.flush();
		} catch (IOException e) {
			throw new BigbuddyException("生成XML文件时出错!");
		} finally{
			try {
				if(out!=null){
					out.close();
				}
				if(writer!=null){
					writer.close();
				}
			} catch (IOException e) {
				throw new BigbuddyException("关闭资源时出错！");
			}
		}
	}
	
	public static void bornFile(String content,String outputPath,String fileName){
		FileWriter writer=null;
		try {
			File file = new File(outputPath);
			file.mkdirs(); //别忘了这句
			writer = new FileWriter(outputPath+separator+fileName);
			writer.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(writer!=null){
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private String getFirstLetterLowcase(String str) {
		StringBuffer name = new StringBuffer(str.substring(0, 1).toLowerCase());
		name.append(str.substring(1));
		return name.toString();
	}
	
	public static String getContent(String filePath) {
		File file = new File(filePath);
		FileReader reader = null;
		try {
			reader = new FileReader(file);
			char[] data = new char[(int) file.length()];
			reader.read(data);
			return String.copyValueOf(data);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "";
	}

	public static Document getReadyDocument() {
		Namespace n1 = new Namespace("", "http://www.springframework.org/schema/beans");
		Namespace n2 = new Namespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
		Namespace n3 = new Namespace("p", "http://www.springframework.org/schema/p");

		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("beans");
		root.add(n1);
		root.add(n2);
		root.add(n3);

		QName qName = new QName("schemaLocation", n2);
		root.addAttribute(qName, "http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.0.xsd");

		return document;
	}
	
	private String[][] getReadyProperties() {
		Class<?> clazz;
		try {
			clazz = Class.forName(this.getBeanFullName());
			Field[] field = clazz.getDeclaredFields();
			String[][] array = new String[field.length][2];
			String type;
			for(int i=0;i<field.length;++i){
				type=field[i].getType().getName();//此处放的是类型名，且是完整的类型名，如java.lang.String
				int index = type.lastIndexOf(SPOT);
				if(-1 != index){
					type=type.substring(index+1);
				}
				array[i][0] = type;
				array[i][1] = field[i].getName();
			}
			return array;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new BigbuddyException("执行生成Action中的反射方法时出错！");
		}
	}
	
	public Field[] getDeclaredFields(){
		Class<?> clazz;
		try {
			clazz = Class.forName(this.getBeanFullName());
			Field[] fields = clazz.getDeclaredFields();
			return fields;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean fileExists(String path,String fileName){
		File file = new File(path, fileName);
		if(file.exists()){
			return true; 
		}
		return false;
	}
	
	public static String getFirstLetterUpperCase(String str){
		StringBuffer sb = new StringBuffer();
		sb.append(str.substring(0, 1).toUpperCase());
		sb.append(str.substring(1));
		return sb.toString();
	}
	
	public String getPropertiesString(){
		StringBuffer props = new StringBuffer();
		StringBuffer setter = new StringBuffer();
		StringBuffer getter = new StringBuffer();
		String[][] array=getReadyProperties();
		for(int i=0;i<array.length;++i){
			props.append("\tprivate ").append(array[i][0]).append(" ").append(array[i][1]).append(";\n");
			
			setter.append("\tpublic void set").append(getFirstLetterUpperCase(array[i][1])).append("(");
			setter.append(array[i][0]).append(" ").append(array[i][1]).append("){\n\t\t");
			setter.append("this.").append(array[i][1]).append("=").append(array[i][1]).append(";\n\t}\n");
			
			getter.append("\tpublic ").append(array[i][0]).append(" get").append(getFirstLetterUpperCase(array[i][1])).append("(){\n\t\t");
			getter.append("return this.").append(array[i][1]).append(";\n\t}\n");
		}
		return props.append(setter).append(getter).toString();
	}
	
	public String getSetUpBeanCode(){
		StringBuffer code = new StringBuffer(); 
		String[][] array=getReadyProperties();
		for(int i=0;i<array.length;++i){
			if(array[i][1].toLowerCase().equals("id")){
				continue;
			}
			code.append("\t\tbean.set").append(getFirstLetterUpperCase(array[i][1])).append("(").append(array[i][1]).append(");\n");
		}
		return code.toString();
	}
	
	
	
	
	
	
	
	//以下为属性的getter方法
	public String getBeanName() {
		return beanName;
	}

	public String getLowcaseBeanName() {
		return lowcaseBeanName;
	}

	public String getBeanFullName() {
		return beanFullName;
	}

	public String getBeanPackageName() {
		return beanPackageName;
	}

	public String getProjectPackageName() {
		return projectPackageName;
	}

	public String getServicePackageName() {
		return servicePackageName;
	}

	public String getServiceImplPackageName() {
		return serviceImplPackageName;
	}

	public String getDaoPackageName() {
		return daoPackageName;
	}

	public String getDaoImplPackageName() {
		return daoImplPackageName;
	}

	public String getActionPackageName() {
		return actionPackageName;
	}

	public String getBeanPackagePath() {
		return beanPackagePath;
	}

	public String getServicePakcagePath() {
		return servicePakcagePath;
	}

	public String getServiceImplPackagePath() {
		return serviceImplPackagePath;
	}

	public String getDaoPackagePath() {
		return daoPackagePath;
	}

	public String getDaoImplPackagePath() {
		return daoImplPackagePath;
	}

	public String getActionPackagePath() {
		return actionPackagePath;
	}

	public String getServiceClassName() {
		return serviceClassName;
	}

	public String getServiceImplLowcaseImplClassName() {
		return serviceImplLowcaseImplClassName;
	}

	public String getServiceImplClassName() {
		return serviceImplClassName;
	}

	public String getDaoClassName() {
		return daoClassName;
	}

	public String getDaoImplClassName() {
		return daoImplClassName;
	}

	public String getServiceLowcaseClassName() {
		return serviceLowcaseClassName;
	}

	public String getDaoLowcaseClassName() {
		return daoLowcaseClassName;
	}

	public String getDaoImplLowcaseClassName() {
		return daoImplLowcaseClassName;
	}

	public String getDaoClassFileName() {
		return daoClassFileName;
	}

	public String getDaoImplClassFileName() {
		return daoImplClassFileName;
	}

	public String getServiceClassFileName() {
		return serviceClassFileName;
	}

	public String getServiceImplClassFileName() {
		return serviceImplClassFileName;
	}

	public Element getRoot() {
		return root;
	}

	public Document getDoc() {
		return doc;
	}

	public static String getSpot() {
		return SPOT;
	}
}
