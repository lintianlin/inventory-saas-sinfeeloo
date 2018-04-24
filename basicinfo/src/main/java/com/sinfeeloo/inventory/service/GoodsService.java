package com.sinfeeloo.inventory.service;

import com.sinfeeloo.inventory.entity.Goods;
import com.sinfeeloo.inventory.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: mhj
 * @Desc:
 * @Date: 2018/4/24 17:21
 */
@Service
public class GoodsService {


    @Autowired
    private GoodsMapper goodsMapper;


    public List<Goods> getGoodsList(){
        return goodsMapper.selectAll();
    }
}
