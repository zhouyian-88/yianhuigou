package com.yian.huigou.mapper;

import com.yian.huigou.pojo.Good;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author ZHOUYIAN
* @description 针对表【tb_good】的数据库操作Mapper
* @createDate 2022-12-08 11:46:50
* @Entity com.yian.huigou.pojo.Good
*/
@Mapper
public interface GoodMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Good record);

    int insertSelective(Good record);

    Good selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Good record);

    int updateByPrimaryKey(Good record);


    /**
     * 通过不同的条件查询商品列表，如果这个条件不传递，请使用-1表示
     * @param categoryId 分类id
     * @param brandId 品牌id
     * @return
     */
    List<Good> selectGoodByCategoryIdOrBrandId(@Param("categoryId")int categoryId,@Param("brandId")int brandId);

    Good getGoodByGoodId(int goodId);
}
