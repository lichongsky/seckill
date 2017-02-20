package com.lichong.dao;

import com.lichong.entity.SecondKillTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lichong on 2017/2/20.
 * 配置spring和junit整合,junit启动时加载SpringIOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SecondKillDAOTest {
    //注入DAO实现类依赖
    @Resource
    private SecondKillDAO secondKillDAO;
    @Test
    public void reduceNum() throws Exception {
        int num = secondKillDAO.reduceNum(1000l);
        System.out.println("num="+num);
    }

    @Test
    public void findSecondKillById() throws Exception {
        long id = 1000;
        SecondKillTO secondKillTO = secondKillDAO.findSecondKillById(id);
        System.out.println(secondKillTO.toString());
    }

    @Test
    public void findSecondKill() throws Exception {
        List<SecondKillTO> list = secondKillDAO.findSecondKill(1,3);
        System.out.println(list);
    }

}