package com.lichong.web;

import com.lichong.dto.ExposeSeckill;
import com.lichong.dto.SecKillExcution;
import com.lichong.dto.SecKillRusltTO;
import com.lichong.entity.SecKillTO;
import com.lichong.enums.SeckillstateEnum;
import com.lichong.exception.RepeatSecKillExcption;
import com.lichong.exception.SecKillCloseExcption;
import com.lichong.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by lichongsky on 2017/2/23 0023.
 */
@Controller
@RequestMapping(value = "/seckill")
public class SecKillController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    SeckillService seckillService;

    public String list(Model model) {
        List<SecKillTO> list = seckillService.getAllSecKill();
        model.addAttribute("list", list);
        return "list";
    }

    @RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.POST)
    public String detail(@PathVariable("seckillId") Long seckillId, Model model) {
        if (seckillId == null) {
            return "forward:/seckill/list";
        }
        SecKillTO seckillTO = seckillService.getSeckillById(seckillId);
        if (seckillTO == null) {
            return "forward:/seckill/list";
        }
        model.addAttribute("seckillTO", seckillTO);
        return "/detail";
    }

    @RequestMapping(value = "/{seckillId}/exposer", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SecKillRusltTO<ExposeSeckill> exposer(Long seckillId) {
        SecKillRusltTO<ExposeSeckill> result;
        try {
            ExposeSeckill exposeSeckill = seckillService.exposeSeckill(seckillId);
            result = new SecKillRusltTO<ExposeSeckill>(true, exposeSeckill);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = new SecKillRusltTO<ExposeSeckill>(false, e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/{seckillId}/{md5}/excution", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SecKillRusltTO<SecKillExcution> excution(@PathVariable("seckillId") Long seckillId,
                                                    @PathVariable("md5") String md5,
                                                    @CookieValue(value = "userPhone", required = false) Long killPhone) {
        SecKillRusltTO<SecKillExcution> result;
        try{
            SecKillExcution secKillExcution = seckillService.excuteSecKill(seckillId,killPhone,md5);
            return new SecKillRusltTO<SecKillExcution>(true,secKillExcution);

        }catch (RepeatSecKillExcption e1){
            SecKillExcution secKillExcution = new SecKillExcution(seckillId, SeckillstateEnum.REPEATKILL);
            return new SecKillRusltTO<SecKillExcution>(false,secKillExcution);
        }catch (SecKillCloseExcption e2){
            SecKillExcution secKillExcution = new SecKillExcution(seckillId, SeckillstateEnum.END);
            return new SecKillRusltTO<SecKillExcution>(false,secKillExcution);
        }
        catch (Exception e){
            logger.error(e.getMessage(),e);
            SecKillExcution secKillExcution = new SecKillExcution(seckillId, SeckillstateEnum.INNER_ERROR);
            return new SecKillRusltTO<SecKillExcution>(false,secKillExcution);
        }
    }

    @RequestMapping(value="/time/now",method = RequestMethod.GET)
    public SecKillRusltTO<Long> time(){
        Date now = new Date();
        return new SecKillRusltTO<Long>(true,now.getTime());
    }
}
