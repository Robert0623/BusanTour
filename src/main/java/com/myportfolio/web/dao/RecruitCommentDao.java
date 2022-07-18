package com.myportfolio.web.dao;

import com.myportfolio.web.domain.RecruitCommentDto;

import java.util.List;

public interface RecruitCommentDao {
    int count(Integer bno) throws Exception // T selectOne(String statement)
    ;

    int deleteAll(Integer bno) // int delete(String statement)
    ;

    int delete(Integer cno, String commenter) throws Exception // int delete(String statement, Object parameter)
    ;

    int insert(RecruitCommentDto dto) throws Exception // int insert(String statement, Object parameter)
    ;

    List<RecruitCommentDto> selectAll(Integer bno) throws Exception // List<E> selectList(String statement)
    ;

    RecruitCommentDto select(Integer cno) throws Exception // T selectOne(String statement, Object parameter)
    ;

    int update(RecruitCommentDto dto) throws Exception // int update(String statement, Object parameter)
    ;
}
