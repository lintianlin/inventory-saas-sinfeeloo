package com.sinfeeloo.inventory.mapper;

import com.sinfeeloo.inventory.entity.Storage;
import java.util.List;

public interface StorageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lz_base_repo
     *
     * @mbggenerated Tue Apr 24 17:00:10 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lz_base_repo
     *
     * @mbggenerated Tue Apr 24 17:00:10 CST 2018
     */
    int insert(Storage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lz_base_repo
     *
     * @mbggenerated Tue Apr 24 17:00:10 CST 2018
     */
    Storage selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lz_base_repo
     *
     * @mbggenerated Tue Apr 24 17:00:10 CST 2018
     */
    List<Storage> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lz_base_repo
     *
     * @mbggenerated Tue Apr 24 17:00:10 CST 2018
     */
    int updateByPrimaryKey(Storage record);
}