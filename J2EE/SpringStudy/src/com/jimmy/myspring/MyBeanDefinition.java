package com.jimmy.myspring;

public class MyBeanDefinition {
    private String id;
    private String clazz;
    private String factoryBean;
    private String factoryMethod;
    private String scope;

    public MyBeanDefinition(String id, String clazz, String factoryBean, String factoryMethod, String scope) {
        super();
        this.id = id;
        this.clazz = clazz;
        this.factoryBean = factoryBean;
        this.factoryMethod = factoryMethod;
        this.scope = scope;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getFactoryBean() {
        return factoryBean;
    }

    public void setFactoryBean(String factoryBean) {
        this.factoryBean = factoryBean;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getFactoryMethod() {
        return factoryMethod;
    }

    public void setFactoryMethod(String factoryMethod) {
        this.factoryMethod = factoryMethod;
    }

}
