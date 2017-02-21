package com.lichong.dao;

import com.lichong.entity.SuccessKilledTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by lichong on 2017/2/20.
 */

/**
 * Created by lichong on 2017/2/20.
 * 配置spring和junit整合,junit启动时加载SpringIOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccesskilledDAOTest {

    //注入DAO实现类依赖
    @Resource
    private SuccesskilledDAO successkilledDAO;

    @Test
    public void insertSuccessKilled() throws Exception {
        long secondKillId = 1004l;
        long userPhone = 18349388888l;
        int a = successkilledDAO.insertSuccessKilled(secondKillId, userPhone);
        System.out.println("a=" + a);
    }

    @Test
    public void queryByIdWithSecondKillTO() throws Exception {
        long secondKillId = 1002l;
        long userPhone = 18349388888l;
        SuccessKilledTO successKilledTO = successkilledDAO.queryByIdWithSecondKillTO(secondKillId, userPhone);
        System.out.println(successKilledTO);
    }

}