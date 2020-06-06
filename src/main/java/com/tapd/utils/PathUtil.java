package com.tapd.utils;

import org.springframework.boot.system.ApplicationHome;

import java.io.File;

public class PathUtil {
    // 根路径
    private static String ROOT_PATH = "";

    static {
        ApplicationHome h = new ApplicationHome(PathUtil.class);
        File jarF = h.getSource();
        ROOT_PATH = jarF.getParentFile().toString();
    }

    // 返回根路径
    public static String getRootPath() {
        return ROOT_PATH;
    }
}
