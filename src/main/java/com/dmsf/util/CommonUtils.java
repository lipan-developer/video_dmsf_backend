package com.dmsf.util;

import java.util.UUID;

/**
 * @Auther: LiPan
 * @Date: 2018.12.18 10:45
 * @Description:
 */
public class CommonUtils {



    public static String randomUUID() {
        return UUID.randomUUID().toString().replaceAll("\\-", "");
    }


}
