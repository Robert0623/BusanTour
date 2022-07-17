package com.myportfolio.web.service;

import com.myportfolio.web.domain.RecruitBoardDto;
import com.myportfolio.web.domain.SearchCondition;

import java.util.List;
import java.util.Map;

public interface RecruitBoardService {
    int getCount() throws Exception;

    int write(RecruitBoardDto recruitBoardDto) throws Exception;

    RecruitBoardDto read(Integer bno) throws Exception;

    int modify(RecruitBoardDto recruitBoardDto) throws Exception;

    int remove(Integer bno, String writer) throws Exception;

    List<RecruitBoardDto> getList() throws Exception;

    int removeAll() throws Exception;

    List<RecruitBoardDto> getPage(Map map) throws Exception;

    List<RecruitBoardDto> getSearchResultPage(SearchCondition sc) throws Exception;

    int getSearchResultCnt(SearchCondition sc) throws Exception;
}
