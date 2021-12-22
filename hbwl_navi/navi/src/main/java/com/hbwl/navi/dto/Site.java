package com.hbwl.navi.dto;


public class Site {

  private long id;
  private String categoryName;
  private String websiteName;
  private String site;
  private String introduction;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }


  public String getWebsiteName() {
    return websiteName;
  }

  public void setWebsiteName(String websiteName) {
    this.websiteName = websiteName;
  }


  public String getSite() {
    return site;
  }

  public void setSite(String site) {
    this.site = site;
  }


  public String getIntroduction() {
    return introduction;
  }

  public void setIntroduction(String introduction) {
    this.introduction = introduction;
  }

}
