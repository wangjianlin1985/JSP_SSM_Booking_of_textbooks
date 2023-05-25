package com.jxxt.entity;

public class TSerie {
    private Integer id;

    private String serieName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerieName() {
        return serieName;
    }

    public void setSerieName(String serieName) {
        this.serieName = serieName == null ? null : serieName.trim();
    }
}