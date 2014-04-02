package com.jimmy.myspring;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;
import org.springframework.util.StringUtils;

import com.david.swing.utility.StringUtility;

public class MyClassPathXMLApplicationContext {
    private Set<MyBeanDefinition> MyBeanDefinitions = new HashSet<MyBeanDefinition>();
    private Set<MyBeanDefinition> latestInitBeanDefinitions = new HashSet<MyBeanDefinition>();
    private Map<String, Object> singletonBeanMap = new HashMap<String, Object>();
    private List<Element> beans;

    public MyClassPathXMLApplicationContext(String filename) {
        try {
            this.readXML(filename);
            this.initBeans();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getBean(String beanId) {
        Object bean = singletonBeanMap.get(beanId);
        if (bean == null) {
            MyBeanDefinition beanDefinition = getMyBeanDefinitionByBeanId(beanId);
            try {
                return this.getObject(beanDefinition);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return singletonBeanMap.get(beanId);
    }

    private MyBeanDefinition getMyBeanDefinitionByBeanId(String beanId) {
        for (Element bean : beans) {
            if (beanId.equals(bean.attributeValue("id"))) {
                return this.getMyBeanDefinition(bean);
            }
        }
        return null;
    }

    private void initBeans() throws Exception {
        initInitableBeans();
        initLatestInitBeans();
    }

    private void initInitableBeans() throws Exception, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        for (MyBeanDefinition mbf : MyBeanDefinitions) {
            checkBeanDefnition(mbf);
            if (isPrototypeScope(mbf)) {
                continue;
            }
            if (shouldInitLatest(mbf)) {
                latestInitBeanDefinitions.add(mbf);
                continue;
            }
            Object beanObj = getObject(mbf);
            singletonBeanMap.put(mbf.getId(), beanObj);
        }
    }

    private boolean isPrototypeScope(MyBeanDefinition mbf) {
        if (!StringUtility.isNullOrEmpty(mbf.getScope()) && mbf.getScope().equals("prototype")) {
            return true;
        }
        return false;
    }

    private void initLatestInitBeans() throws SecurityException, IllegalArgumentException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException {
        for (MyBeanDefinition mbf : MyBeanDefinitions) {
            Object beanObj = singletonBeanMap.get(mbf.getId());
            Class<? extends Object> clazz = beanObj.getClass();
            Method method = clazz.getMethod(mbf.getFactoryMethod());
            singletonBeanMap.put(mbf.getId(), method.invoke(beanObj));
        }
    }

    private boolean shouldInitLatest(MyBeanDefinition mbf) {
        return StringUtility.isNullOrEmpty(mbf.getFactoryBean());
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private Object getObject(MyBeanDefinition mbf) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException,
            InvocationTargetException {
        if (StringUtils.hasText(mbf.getFactoryMethod())) {
            Class clazz = null;
            if (StringUtils.hasText(mbf.getFactoryBean())) {
                clazz = Class.forName(mbf.getFactoryBean());
            } else {
                clazz = Class.forName(mbf.getClazz());
            }
            Method method = clazz.getMethod(mbf.getFactoryMethod());
            return method.invoke(clazz.newInstance());
        }
        return Class.forName(mbf.getClazz()).newInstance();
    }

    private void checkBeanDefnition(MyBeanDefinition mbf) throws Exception {
        if (StringUtility.isNullOrEmpty(mbf.getId()) || StringUtility.isNullOrEmpty(mbf.getClazz())) {
            throw new Exception("id and class are mandatory attributes for MySpring!");
        }
    }

    @SuppressWarnings("unchecked")
    private void readXML(String filename) throws DocumentException {
        URL xmlPath = this.getClass().getClassLoader().getResource(filename);
        SAXReader saxReader = new SAXReader();
        Document doc = saxReader.read(xmlPath);
        Map<String, String> nameSpaceMap = new HashMap<String, String>();
        // join the name space
        nameSpaceMap.put("ns", "http://www.springframework.org/schema/beans");
        // create the query path "beans/bean"
        XPath xsub = doc.createXPath("//ns:beans/ns:bean");
        xsub.setNamespaceURIs(nameSpaceMap);
        this.beans = xsub.selectNodes(doc);
        for (Element bean : beans) {
            MyBeanDefinitions.add(this.getMyBeanDefinition(bean));
        }
    }

    private MyBeanDefinition getMyBeanDefinition(Element bean) {
        String id = bean.attributeValue("id");
        String clazz = bean.attributeValue("class");
        String factoryBean = bean.attributeValue("factory-bean");
        String factoryMethod = bean.attributeValue("fafactory-method");
        String scope = bean.attributeValue("scope");
        return new MyBeanDefinition(id, clazz, factoryBean, factoryMethod, scope);
    }

}
