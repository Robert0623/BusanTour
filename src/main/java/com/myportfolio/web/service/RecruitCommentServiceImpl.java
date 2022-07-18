package com.myportfolio.web.service;

import com.myportfolio.web.dao.RecruitBoardDao;
import com.myportfolio.web.dao.RecruitCommentDao;
import com.myportfolio.web.domain.RecruitCommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecruitCommentServiceImpl implements RecruitCommentService {
    @Autowired
    RecruitBoardDao boardDao;
    @Autowired
    RecruitCommentDao commentDao;

    @Override
    public int getCount(Integer bno) throws Exception {
        return commentDao.count(bno);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int remove(Integer cno, Integer bno, String commenter) throws Exception {
        int rowCnt = boardDao.updateCommentCnt(bno, -1);
        System.out.println("updateCommentCnt - rowCnt = " + rowCnt);
//        throw new Exception("test");
        rowCnt = commentDao.delete(cno, commenter);
        System.out.println("rowCnt = " + rowCnt);
        return rowCnt;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int write(RecruitCommentDto commentDto) throws Exception {
        boardDao.updateCommentCnt(commentDto.getBno(), 1);
//                throw new Exception("test");
        return commentDao.insert(commentDto);
    }

    @Override
    public List<RecruitCommentDto> getList(Integer bno) throws Exception {
//        throw new Exception("test");
        return commentDao.selectAll(bno);
    }

    @Override
    public RecruitCommentDto read(Integer cno) throws Exception {
        return commentDao.select(cno);
    }

    @Override
    public int modify(RecruitCommentDto commentDto) throws Exception {
        return commentDao.update(commentDto);
    }
}
