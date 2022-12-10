package com.yian.huigou.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName tb_good
 */
@Data
public class Good implements Serializable {
    /**
     * 
     */
    private Integer goodId;

    /**
     * 
     */
    private String goodName;

    /**
     * 
     */
    private String goodImg;

    /**
     * 
     */
    private Integer goodCost;

    /**
     * 
     */
    private Integer goodMinPrice;

    /**
     * 
     */
    private Integer goodFirstPrice;

    /**
     * 
     */
    private Integer goodSecondPrice;

    /**
     * 
     */
    private Integer goodThirdPrice;

    /**
     * 
     */
    private Integer goodForthPrice;

    /**
     * 
     */
    private Integer goodFifthPrice;

    private static final long serialVersionUID = 1L;
}