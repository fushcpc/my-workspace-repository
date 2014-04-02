package com.forum.action.forum;

import com.forum.bean.Forum;
import com.forum.service.ForumService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings({ "serial" })
public class AddForum extends ActionSupport {
    private ForumService service;
    private String name;
    private String description;
    private long parentId;

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setService(ForumService service) {
        this.service = service;
    }

    public Forum getReadyBean() {
        Forum bean = new Forum();
        bean.setName(name);
        bean.setDescription(description);

        return bean;
    }

    @Override
    public void validate() {

    }

    @Override
    public String execute() throws Exception {
        Forum bean = this.getReadyBean();
        if (parentId > 0) {
            this.service.saveForum(bean, parentId);
            return SUCCESS;
        }
        bean.setId(37);
        this.service.saveForum(bean);
        return SUCCESS;
    }
}