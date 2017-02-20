package com.lichong.dao;

import com.lichong.entity.SecondKillTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lichong on 2017/2/20.
 */
public interface SecondKillDAO {

    /**
     * 减库存
     *
     * @param secondKillId
     * @return
     */
    int reduceNum(long secondKillId);

    /**
     * 根据秒杀商品id获取商品信息
     *
     * @param secondKillId
     * @return
     */
    SecondKillTO findSecondKillById(long secondKillId);

    /**
     * 根据偏移量查询商品
     * @param offset
     * @param limit
     * @return
     */
    List<SecondKillTO> findSecondKill(@Param("offset") int offset, @Param("limit") int limit);
}
