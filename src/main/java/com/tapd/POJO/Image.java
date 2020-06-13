package com.tapd.POJO;

/**
 * @Author jxd
 * @Date 2020-06-12  21:30
 * @Version 1.0
 */
public class Image {


    private Integer id ;
    private String path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Image(Integer id, String path) {
        this.id = id;
        this.path = path;
    }
}
