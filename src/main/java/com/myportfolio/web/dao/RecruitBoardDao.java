package com.myportfolio.web.dao;

import com.myportfolio.web.domain.RecruitBoardDto;

import java.util.List;
import java.util.Map;

public interface RecruitBoardDao {
    int count() throws Exception;

    int insert(RecruitBoardDto recruitBoardDto) throws Exception;

    RecruitBoardDto select(Integer bno) throws Exception;

    int update(RecruitBoardDto recruitBoardDto) throws Exception;

    int delete(Integer bno, String writer) throws Exception;

    List<RecruitBoardDto> selectAll() throws Exception;

    int deleteAll() throws Exception;

    List<RecruitBoardDto> selectPage(Map map) throws Exception;

    int increaseViewCnt(Integer bno) throws Exception;

    int updateCommentCnt(Map map) throws Exception;
}
