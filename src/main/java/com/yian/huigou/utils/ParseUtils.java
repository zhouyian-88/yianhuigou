package com.yian.huigou.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-09-16:20
 */
public class ParseUtils {
    public static List<Integer> parseIntToList(int value){
        ArrayList<Integer> list = new ArrayList<>();
        String[] split = (value + "").split("");
        for (String str : split) {
            list.add(Integer.parseInt(str));
        }
        return list;
    }
}
