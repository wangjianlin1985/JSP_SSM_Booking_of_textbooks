package com.jxxt.entity;

public class TClass {
    private Integer id;

    private String className;
    private Integer  serieId;
    
    private String serieName;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

	public Integer getSerieId() {
		return serieId;
	}

	public void setSerieId(Integer serieId) {
		this.serieId = serieId;
	}

	public String getSerieName() {
		return serieName;
	}

	public void setSerieName(String serieName) {
		this.serieName = serieName;
	}
}