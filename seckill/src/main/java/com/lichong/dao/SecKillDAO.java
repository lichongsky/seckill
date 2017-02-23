package com.lichong.dao;

import com.lichong.entity.SecKillTO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by lichong on 2017/2/20.
 */
public interface SecKillDAO {

    /**
     * 减库存
     *
     * @param secKillId
     * @return
     */
    int reduceNum(@Param("secKillId") long secKillId, @Param("nowTime") Date nowTime);

    /**
     * 根据秒杀商品id获取商品信息
     *
     * @param secKillId
     * @return
     */
    SecKillTO findSecondKillById(long secKillId);

    /**
     * 根据偏移量查询商品
     *
     * @param offset
     * @param limit
     * @return
     */
    List<SecKillTO> findSecondKill(@Param("offset") int offset, @Param("limit") int limit);
}
