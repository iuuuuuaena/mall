package com.tapd.POJO;


/**
 * @Author jxd
 * @Date 2020-06-09  08:55
 * @Version 1.0
 */
public class ShoppingAddress {

    private String user_account;
    private String user_nickname;
    private Integer user_phone;
    private String city;
    private String area;
    private String street;
    private String specific_address;
    private Integer is_default;
//     是否是默认地址  。默认为0   1是默认的


    @Override
    public String toString() {
        return "ShoppingAddress{" +
                "user_account='" + user_account + '\'' +
                ", user_nickname='" + user_nickname + '\'' +
                ", user_phone=" + user_phone +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", street='" + street + '\'' +
                ", specific_address='" + specific_address + '\'' +
                ", is_default=" + is_default +
                '}';
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public Integer getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(Integer user_phone) {
        this.user_phone = user_phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSpecific_address() {
        return specific_address;
    }

    public void setSpecific_address(String specific_address) {
        this.specific_address = specific_address;
    }

    public Integer getIs_default() {
        return is_default;
    }

    public void setIs_default(Integer is_default) {
        this.is_default = is_default;
    }

    public ShoppingAddress(String user_account, String user_nickname, Integer user_phone, String city, String area, String street, String specific_address, Integer is_default) {
        this.user_account = user_account;
        this.user_nickname = user_nickname;
        this.user_phone = user_phone;
        this.city = city;
        this.area = area;
        this.street = street;
        this.specific_address = specific_address;
        this.is_default = is_default;
    }
}
