package com.myportfolio.web.service;

import com.myportfolio.web.dao.RecruitBoardDao;
import com.myportfolio.web.domain.RecruitBoardDto;
import com.myportfolio.web.domain.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RecruitBoardServiceImpl implements RecruitBoardService {
    @Autowired
    RecruitBoardDao recruitBoardDao;

    @Override
    public int getCount() throws Exception {
        return recruitBoardDao.count();
    }
    @Override
    public int write(RecruitBoardDto recruitBoardDto) throws Exception {
        return recruitBoardDao.insert(recruitBoardDto);
//        throw new Exception("test");
    }
    @Override
    public RecruitBoardDto read(Integer bno) throws Exception {
        recruitBoardDao.increaseViewCnt(bno);
        return recruitBoardDao.select(bno);
    }
    @Override
    public int modify(RecruitBoardDto recruitBoardDto) throws Exception {
        return recruitBoardDao.update(recruitBoardDto);
    }
    @Override
    public int remove(Integer bno, String writer) throws Exception {
        return recruitBoardDao.delete(bno, writer);
    }
    @Override
    public List<RecruitBoardDto> getList() throws Exception {
        return recruitBoardDao.selectAll();
    }
    @Override
    public int removeAll() throws Exception {
        return recruitBoardDao.deleteAll();
    }
    @Override
    public List<RecruitBoardDto> getPage(Map map) throws Exception {
        return recruitBoardDao.selectPage(map);
    }
    @Override
    public List<RecruitBoardDto> getSearchResultPage(SearchCondition sc) throws Exception {
        return recruitBoardDao.searchSelectPage(sc);
    }
    @Override
    public int getSearchResultCnt(SearchCondition sc) throws Exception {
        return recruitBoardDao.searchResultCnt(sc);
    }

}
