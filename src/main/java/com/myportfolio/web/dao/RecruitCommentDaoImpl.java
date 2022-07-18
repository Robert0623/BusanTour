package com.myportfolio.web.dao;

import com.myportfolio.web.domain.RecruitCommentDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RecruitCommentDaoImpl implements RecruitCommentDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "com.myportfolio.web.dao.RecruitCommentMapper.";

    @Override
    public int count(Integer bno) throws Exception {
        return session.selectOne(namespace+"count", bno);
    } // T selectOne(String statement)

    @Override
    public int deleteAll(Integer bno) {
        return session.delete(namespace+"deleteAll", bno);
    } // int delete(String statement)

    @Override
    public int delete(Integer cno, String commenter) throws Exception {
        Map map = new HashMap();
        map.put("cno", cno);
        map.put("commenter", commenter);
        return session.delete(namespace+"delete", map);
    } // int delete(String statement, Object parameter)

    @Override
    public int insert(RecruitCommentDto dto) throws Exception {
        return session.insert(namespace+"insert", dto);
    } // int insert(String statement, Object parameter)

    @Override
    public List<RecruitCommentDto> selectAll(Integer bno) throws Exception {
        return session.selectList(namespace+"selectAll", bno);
    } // List<E> selectList(String statement)

    @Override
    public RecruitCommentDto select(Integer cno) throws Exception {
        return session.selectOne(namespace + "select", cno);
    } // T selectOne(String statement, Object parameter)

    @Override
    public int update(RecruitCommentDto dto) throws Exception {
        return session.update(namespace+"update", dto);
    } // int update(String statement, Object parameter)
}
