package com.lichong.service;

import com.lichong.dto.ExposeSeckill;
import com.lichong.dto.SecKillExcution;
import com.lichong.entity.SecKillTO;
import com.lichong.exception.RepeatSecKillExcption;
import com.lichong.exception.SecKillCloseExcption;

import java.util.List;

/**
 * Created by lichongsky on 2017/2/21.
 */
public interface SeckillService {

    // 获取所有秒杀商品
    List<SecKillTO> getAllSecKill();

    // 根据id获取单个商品
    SecKillTO getSeckillById(long secKillId);

    // 暴露秒杀活动接口
    ExposeSeckill exposeSeckill(long secKillId);

    // 执行秒杀结果
    SecKillExcution excuteSecKill(long secKillId, long userPhone, String md5) throws RepeatSecKillExcption, SecKillCloseExcption;
}
