package com.sinfeeloo.inventory.service;

import com.sinfeeloo.inventory.entity.Goods;
import com.sinfeeloo.inventory.entity.Paging;
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
    public GoodsMapper goodsMapper;


    /**
     * 添加商品
     *
     * @param goods
     */
    public void addGoods(Goods goods) {
        goodsMapper.insert(goods);
    }


    /**
     * 分页查询商品列表
     *
     * @param paging
     */
    public void getGoodsListByPage(Paging<Goods> paging) {
        paging.setTotal(goodsMapper.selectGoodsListCount(paging.getSearchMap()));
        paging.setList(goodsMapper.selectGoodsListByPage(paging.getSearchMap()));
    }

    /**
     * 修改商品
     *
     * @param goods
     * @return
     */
    public int modifyGoods(Goods goods) {
        return goodsMapper.updateByPrimaryKey(goods);
    }

    /**
     * 删除
     *
     * @param goods
     */
    public void deleteGoods(Goods goods) {
        goodsMapper.deleteByPrimaryKey(goods);
    }

    /**
     * 商品详情
     * @param id
     * @return
     */
    public Goods getGoodsDetail(Integer id) {
        return goodsMapper.selectByPrimaryKey(id);
    }
}
