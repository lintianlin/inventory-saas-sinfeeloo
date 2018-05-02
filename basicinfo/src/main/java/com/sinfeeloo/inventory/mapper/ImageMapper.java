package com.sinfeeloo.inventory.mapper;

import com.sinfeeloo.inventory.entity.Image;
import java.util.List;

public interface ImageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lz_base_image
     *
     * @mbggenerated Wed May 02 13:14:18 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lz_base_image
     *
     * @mbggenerated Wed May 02 13:14:18 CST 2018
     */
    int insert(Image record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lz_base_image
     *
     * @mbggenerated Wed May 02 13:14:18 CST 2018
     */
    Image selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lz_base_image
     *
     * @mbggenerated Wed May 02 13:14:18 CST 2018
     */
    List<Image> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lz_base_image
     *
     * @mbggenerated Wed May 02 13:14:18 CST 2018
     */
    int updateByPrimaryKey(Image record);
}