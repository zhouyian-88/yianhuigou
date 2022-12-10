package com.yian.huigou.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc: 这个封装类对应的是baseInfo表，主要用来作用map集合中的键
 * @datetime: 2022-12-09-9:38
 */
@Data
public class ParProperty implements Serializable, Comparable<ParProperty>{
    private static final long serialVersionUID = 1L;
    private Integer parPropertyId;
    private String parPropertyName;

    @Override
    public int compareTo(ParProperty o) {
        return this.getParPropertyId() - o.parPropertyId;
    }
}
