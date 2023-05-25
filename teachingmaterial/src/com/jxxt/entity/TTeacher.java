package com.jxxt.entity;

public class TTeacher {
    private Integer id;

    private String teaNo;

    private String teaName;

    private String teaAge;

    private String teaSex;

    private String teaPhone;

    private Integer professionId;

    private String teaPwd;
    
    private String professionName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeaNo() {
        return teaNo;
    }

    public void setTeaNo(String teaNo) {
        this.teaNo = teaNo == null ? null : teaNo.trim();
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName == null ? null : teaName.trim();
    }

    public String getTeaAge() {
        return teaAge;
    }

    public void setTeaAge(String teaAge) {
        this.teaAge = teaAge == null ? null : teaAge.trim();
    }

    public String getTeaSex() {
        return teaSex;
    }

    public void setTeaSex(String teaSex) {
        this.teaSex = teaSex == null ? null : teaSex.trim();
    }

    public String getTeaPhone() {
        return teaPhone;
    }

    public void setTeaPhone(String teaPhone) {
        this.teaPhone = teaPhone == null ? null : teaPhone.trim();
    }

    public Integer getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Integer professionId) {
        this.professionId = professionId;
    }

    public String getTeaPwd() {
        return teaPwd;
    }

    public void setTeaPwd(String teaPwd) {
        this.teaPwd = teaPwd == null ? null : teaPwd.trim();
    }

	public String getProfessionName() {
		return professionName;
	}

	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}
}