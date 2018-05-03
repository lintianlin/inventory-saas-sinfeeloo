package com.sinfeeloo.inventory.mapper;

import com.sinfeeloo.inventory.entity.Stock;
import java.util.List;

public interface StockMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lz_stock
     *
     * @mbggenerated Thu May 03 10:43:21 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lz_stock
     *
     * @mbggenerated Thu May 03 10:43:21 CST 2018
     */
    int insert(Stock record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lz_stock
     *
     * @mbggenerated Thu May 03 10:43:21 CST 2018
     */
    Stock selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lz_stock
     *
     * @mbggenerated Thu May 03 10:43:21 CST 2018
     */
    List<Stock> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lz_stock
     *
     * @mbggenerated Thu May 03 10:43:21 CST 2018
     */
    int updateByPrimaryKey(Stock record);
}