package com.lsq.utils;


import java.util.UUID;

/**
 * @author linshengqian
 */
public class IDUtil {

    public static String genId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

}