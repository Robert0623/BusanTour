package com.myportfolio.web.dao;

import com.myportfolio.web.domain.RecruitBoardDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class RecruitBoardDaoImplTest {
    @Autowired
    RecruitBoardDao recruitBoardDao;

    @Test
    public void count() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void select() throws Exception {
        assertTrue(recruitBoardDao!=null);
        System.out.println("recruitBoardDao = " + recruitBoardDao);
        RecruitBoardDto recruitBoardDto = recruitBoardDao.select(1);
        assertTrue(recruitBoardDto.getBno().equals(1));
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void selectAll() {
    }

    @Test
    public void deleteAll() {
    }

    @Test
    public void selectPage() {
    }

    @Test
    public void increaseViewCnt() {
    }

    @Test
    public void updateCommentCnt() {
    }
}