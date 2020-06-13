package com.tapd.POJO;

/**
 * @Author jxd
 * @Date 2020-06-12  16:11
 * @Version 1.0
 */
public class ReceiveInfo {

//      'name': '王某某',
//              'phone': '13811111111',
//              'areaCode': '010',
//              'landLine': '64627856',
//              'provinceId': 110000,
//              'province': '北京市',
//              'cityId': 110100,
//              'city': '市辖区',
//              'countyId': 110106,
//              'county': '海淀区',
//              'add': '上地十街辉煌国际西6号楼319室',
//              'default': true,
//              'checked': true
// }

    private Integer id;

    public ReceiveInfo(Integer id, String user_account, String user_nickname, String phone, String city, String area, String street, String specific_address, String is_default) {
        this.id = id;
        this.user_account = user_account;
        this.user_nickname = user_nickname;
        this.phone = phone;
        this.city = city;
        this.area = area;
        this.street = street;
        this.specific_address = specific_address;
        this.is_default = is_default;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String user_account;
    private String user_nickname;
    private String phone;
    private String city;
    private String area;
    private String street;
    private String specific_address;
    private String is_default;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getIs_default() {
        return is_default;
    }

    public void setIs_default(String is_default) {
        this.is_default = is_default;
    }


}