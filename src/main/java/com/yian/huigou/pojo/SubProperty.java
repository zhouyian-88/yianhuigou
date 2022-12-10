package com.yian.huigou.pojo;

import lombok.Data;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc: 该封装类的对应的是tb_info_detail表，是用作于评估步骤中map中的value中的泛型类
 * @datetime: 2022-12-09-9:40
 */
@Data
public class SubProperty {
    private Integer subPropertyId;
    private String subPropertyName;
    private String subPropertyDesc;
    private ParProperty property;//表与表之间的一对一关系
}
