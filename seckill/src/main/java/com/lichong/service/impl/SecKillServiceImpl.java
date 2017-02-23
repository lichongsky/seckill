package com.lichong.service.impl;

import com.lichong.dao.SecKillDAO;
import com.lichong.dao.SuccesskilledDAO;
import com.lichong.dto.ExposeSeckill;
import com.lichong.dto.SecKillExcution;
import com.lichong.entity.SecKillTO;
import com.lichong.entity.SuccessKilledTO;
import com.lichong.enums.SeckillstateEnum;
import com.lichong.exception.RepeatSecKillExcption;
import com.lichong.exception.SecKillCloseExcption;
import com.lichong.exception.SecKillException;
import com.lichong.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by lichongsky on 2017/2/21.
 */
@Service
public class SecKillServiceImpl implements SeckillService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private SecKillDAO secKillDAO;

    private SuccesskilledDAO successkilledDAO;

    // 随机盐值
    private static final String salt = "fdew32;pojr32;,lsmc?V?:>}{|+_{!~@$@8fmnjupafdsa";

    public List<SecKillTO> getAllSecKill() {
        return secKillDAO.findSecondKill(0, 5);
    }

    public SecKillTO getSeckillById(long secKillId) {
        return secKillDAO.findSecondKillById(secKillId);
    }

    public ExposeSeckill exposeSeckill(long secKillId) {
        SecKillTO secKillTO = secKillDAO.findSecondKillById(secKillId);
        if (secKillTO == null) {
            return new ExposeSeckill(false, secKillId);
        }
        // 秒杀开启时间
        long startTime = secKillTO.getStartTime().getTime();
        // 秒杀结束时间
        long endTime = secKillTO.getEndTime().getTime();
        // 系统当前时间
        Date nowTime = new Date();
        if (nowTime.getTime() >= startTime && nowTime.getTime() <= endTime) {
            return new ExposeSeckill(true, nowTime.getTime(), startTime, endTime);
        }
        String md5 = getMD5(secKillId);
        return new ExposeSeckill(true, md5, secKillId);
    }

    //  获取md5工具方法
    private String getMD5(long secKillId) {
        String base = secKillId + "/" + salt;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    @Transactional
    public SecKillExcution excuteSecKill(long secKillId, long userPhone, String md5) throws RepeatSecKillExcption, SecKillCloseExcption, SecKillException {
        if (!md5.equals(getMD5(secKillId)) || md5 == null) {
            throw new RepeatSecKillExcption("seckill data rewright");
        }
        Date nowTime = new Date();
        int updateCount = secKillDAO.reduceNum(secKillId, nowTime);
        try {
            if (updateCount < 0) {
                throw new SecKillCloseExcption("seckill is closed");
            } else {
                // 记录购买行为
                int insertCount = successkilledDAO.insertSuccessKilled(secKillId, userPhone);
                if (insertCount <= 0) {
                    throw new SecKillCloseExcption("seckill repeat");
                } else {
                    // 秒杀成功
                    SuccessKilledTO successKilledTO = successkilledDAO.queryByIdWithSecondKillTO(secKillId, userPhone);
                    return new SecKillExcution(secKillId, SeckillstateEnum.SUCCESS, successKilledTO);
                }
            }
        } catch (RepeatSecKillExcption e1) {
            throw e1;
        } catch (SecKillCloseExcption e2) {
            throw e2;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            //所有编译期异常转化为运行期异常
            throw new SecKillException("runtime inner error:" + e.getMessage());
        }
    }
}
