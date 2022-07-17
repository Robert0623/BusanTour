package com.myportfolio.web.dao;

import com.myportfolio.web.domain.RecruitBoardDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RecruitBoardDaoImpl implements RecruitBoardDao {
    @Autowired
    private SqlSession session;

    private static String namespace = "com.myportfolio.web.dao.RecruitBoardMapper.";

    @Override
    public int count() throws Exception {
        return session.selectOne(namespace + "count");
    }
    @Override
    public int insert(RecruitBoardDto recruitBoardDto) throws Exception {
        return session.insert(namespace + "insert", recruitBoardDto);
    }
    @Override
    public RecruitBoardDto select(Integer bno) throws Exception {
        return session.selectOne(namespace + "select", bno);
    }
    @Override
    public int update(RecruitBoardDto recruitBoardDto) throws Exception {
        return session.update(namespace + "update", recruitBoardDto);
    }
    @Override
    public int delete(Integer bno, String writer) throws Exception {
        Map map = new HashMap();
        map.put("bno", bno);
        map.put("writer", writer);
        return session.delete(namespace + "delete", map);
    }
    @Override
    public List<RecruitBoardDto> selectAll() throws Exception {
        return session.selectList(namespace + "selectAll");
    }
    @Override
    public int deleteAll() throws Exception {
        return session.delete(namespace + "deleteAll");
    }
    @Override
    public List<RecruitBoardDto> selectPage(Map map) throws Exception {
        return session.selectList(namespace + "selectPage", map);
    }
    @Override
    public int increaseViewCnt(Integer bno) throws Exception {
        return session.update(namespace + "increaseViewCnt", bno);
    }
    @Override
    public int updateCommentCnt(Map map) throws Exception {
        return session.update(namespace + "updateCommentCnt", map);
    }
}
