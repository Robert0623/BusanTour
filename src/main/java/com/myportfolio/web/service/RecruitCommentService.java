package com.myportfolio.web.service;

import com.myportfolio.web.domain.RecruitCommentDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RecruitCommentService {
    int getCount(Integer bno) throws Exception;

    @Transactional(rollbackFor = Exception.class)
    int remove(Integer cno, Integer bno, String commenter) throws Exception;

    @Transactional(rollbackFor = Exception.class)
    int write(RecruitCommentDto commentDto) throws Exception;

    List<RecruitCommentDto> getList(Integer bno) throws Exception;

    RecruitCommentDto read(Integer cno) throws Exception;

    int modify(RecruitCommentDto commentDto) throws Exception;
}
