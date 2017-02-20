package com.lichong.dao;

import com.lichong.entity.SuccessKilledTO;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lichong on 2017/2/20.
 */
public interface SuccesskilledDAO {

    /**
     * 插入购买明细
     *
     * @param secondKillId
     * @param userPhone
     * @return
     */
    int insertSuccessKilled(@Param("secondKillId") long secondKillId, @Param("userPhone") long userPhone);

    /**
     * 根据秒杀商品id查询秒杀成功信息并携带SecondeKillTO
     *
     * @param secondKillId
     * @return
     */
    SuccessKilledTO queryByIdWithSecondKillTO(@Param("secondKillId") long secondKillId, @Param("userPhone") long userPhone);
}
