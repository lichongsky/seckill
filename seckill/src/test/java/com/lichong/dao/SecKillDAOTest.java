package com.lichong.dao;

import com.lichong.entity.SecKillTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by lichong on 2017/2/20.
 * 配置spring和junit整合,junit启动时加载SpringIOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SecKillDAOTest {
    //注入DAO实现类依赖
    @Resource
    private SecKillDAO secKillDAO;

    @Test
    public void reduceNum() throws Exception {
        Date now = new Date();
        long nowTime = now.getTime();
        int num = secKillDAO.reduceNum(1006l,now);
        System.out.println("num=" + num);
    }

    @Test
    public void findSecondKillById() throws Exception {
        long id = 1005l;
        SecKillTO secKillTO = secKillDAO.findSecondKillById(id);
        System.out.println(secKillTO.toString());
    }

    @Test
    public void findSecondKill() throws Exception {
        List<SecKillTO> list = secKillDAO.findSecondKill(1, 3);
        System.out.println(list);
    }

}