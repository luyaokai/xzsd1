package com.xzsd.app.userInformation.entity;

/**
 * 地址实体类
 * @author cairuifeng
 * @date 2020-04-22
 */
public class AddressInfo {
    /**
     * 省名
     */
    private String provinceName;
    /**
     * 市名
     */
    private String cityName;
    /**
     * 区名
     */
    private String areaName;

    public String getProvinceName() {return provinceName;}

    public void setProvinceName(String provinceName) {this.provinceName = provinceName;}

    public String getCityName() {return cityName;}

    public void setCityName(String cityName) {this.cityName = cityName;}

    public String getAreaName() {return areaName;}

    public void setAreaName(String areaName) {this.areaName = areaName; }
}
