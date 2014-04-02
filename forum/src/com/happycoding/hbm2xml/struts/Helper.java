package com.happycoding.hbm2xml.struts;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
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
	//private Namespace defaultSpingNamespace = new Namespace("", "http://www.springframework.org/schema/beans");
	//private QName beanQName = new QName("bean", defaultSpingNamespace);
	//private QName propertyQName = new QName("property", defaultSpingNamespace);

	private Helper() {
	}

	public static Helper getInstance() {
		return helper;
	}


//	<bean id="addDocumentCatalog" class="com.bigbuddy.oa.action.documentcatalog.AddDocumentCatalog"	scope="prototype">
//		<property name="service" ref="catalogService"></property>
//	</bean>
	public void generateServiceActionConfig(String output,String templatePath,String fileName,List<String> hbmFiles) {
		//Document doc = HBMUtils.getSpringRootReadyDocument();
		//Element root = doc.getRootElement();
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
			
			Element struts = doc.getRootElement();
			//struts.getNamespace()
			for (String hbm : hbmFiles) {
				HBMUtils util = new HBMUtils(hbm);
				String beanName = util.getBeanName();
				List<Element> list =(List<Element>) struts.elements("package");
				boolean isExited = false;
				for(Element pk : list){
					String value = pk.attribute("name").getValue();
					if(value.equals(beanName)){
						isExited = true;
						break;
					}
				}
				if(!isExited){
					struts.addComment("开始"+util.getBeanName()+"的Action配置");
					Element pk = struts.addElement("package");
					pk.addAttribute("name", beanName);
					pk.addAttribute("namespace", "/"+beanName);
					pk.addAttribute("extends", "struts-default");
					Element action = pk.addElement("action");
					action.addAttribute("name", "add"+beanName);
					action.addAttribute("class", "add"+beanName);
					Element result = action.addElement("result");
					result.addAttribute("type", "redirectAction");
					Element param = result.addElement("param");
					param.addAttribute("name","actionName").setText("list"+beanName+"s");
//					<action name="listDocumentCatalogs" class="listDocumentCatalogs">
//					<result>listDocumentCatalog.jsp</result>
//					</action>
					
					action = pk.addElement("action");
					action.addAttribute("name", "list"+beanName+"s");
					action.addAttribute("class", "list"+beanName+"s");
					result = action.addElement("result");
					result.setText("list"+beanName+"s.jsp");
					
//					<action name="deleteDocumentCatalog" class="deleteDocumentCatalog">
//					<result type="redirectAction">
//						<param name="actionName">listDocumentCatalogs</param>
//						<param name="type">${type}</param>
//						<param name="parentId">${parentId}</param>
//					</result>
//				</action>
					action = pk.addElement("action");
					action.addAttribute("name", "delete"+beanName);
					action.addAttribute("class", "delete"+beanName);
					result = action.addElement("result");
					result.addAttribute("type", "redirectAction");
					param = result.addElement("param");
					param.addAttribute("name","actionName").setText("list"+beanName+"s");
					
//					param.addAttribute("name","start").setText("${start}");
//					param.addAttribute("name","range").setText("${range}");
					param = result.addElement("param");
					param.addAttribute("name","start").setText("${start}");
					param = result.addElement("param");
					param.addAttribute("name","range").setText("${range}");
//					<action name="updatePDocumentCatalog" class="updatePDocumentCatalog">
//					<result>updateDocumentCatalog.jsp</result>
//				</action>
					action = pk.addElement("action");
					action.addAttribute("name", "updateP"+beanName);
					action.addAttribute("class", "updateP"+beanName);
					result = action.addElement("result");
					result.setText("update"+beanName+".jsp");
					
//					<action name="updateDocumentCatalog" class="updateDocumentCatalog">
//					<result type="redirectAction">
//						<param name="actionName">listDocumentCatalogs</param>
//						<param name="type">${type}</param>
//						<param name="parentId">${parentId}</param>
//					</result>
//				</action>
					
					action = pk.addElement("action");
					action.addAttribute("name", "update"+beanName);
					action.addAttribute("class", "update"+beanName);
					result = action.addElement("result");
					result.addAttribute("type", "redirectAction");
					param = result.addElement("param");
					param.addAttribute("name","actionName").setText("list"+beanName+"s");
					
					
					
					struts.addComment("结束"+util.getBeanName()+"的Action配置");
				}
			}
			HBMUtils.bornDocumentToXML(outputPath, doc);
		} catch (DocumentException e) {
			e.printStackTrace();
			throw new BigbuddyException("无法创建XML文档对象，你的路径是否有问题？");
		}
	}

}
