package com.jxxt.entity;

import java.util.List;

public class TMenus {
    private Integer id;

    private String text;

    private String icon;

    private String url;

    private String close;

    private Integer pid;
    
    List<TMenus> menus;



	public List<TMenus> getMenus() {
		return menus;
	}

	public void setMenus(List<TMenus> menus) {
		this.menus = menus;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close == null ? null : close.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}