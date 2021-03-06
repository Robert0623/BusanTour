package com.myportfolio.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.myportfolio.web.domain.PageHandler;
import com.myportfolio.web.domain.RecruitBoardDto;
import com.myportfolio.web.domain.SearchCondition;
import com.myportfolio.web.service.RecruitBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/recruit")
public class RecruitBoardController {
    @Autowired
    RecruitBoardService recruitBoardService;

    @PostMapping("/modify")
    public String modify(RecruitBoardDto recruitBoardDto, Integer page, Integer pageSize, Model m, HttpSession session, RedirectAttributes rattr) {
        String writer = (String) session.getAttribute("id");
        recruitBoardDto.setWriter(writer);

        try {
            int rowCnt = recruitBoardService.modify(recruitBoardDto);

            if(rowCnt!=1)
                throw new Exception("Modify Failed");

            rattr.addAttribute("page", page);
            rattr.addAttribute("pageSize", pageSize);
            rattr.addFlashAttribute("msg", "MOD_OK");

            return "redirect:/recruit/list";
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute(recruitBoardDto);
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);
            m.addAttribute("msg", "MOD_ERR");
            return "recruitBoard";
        }
    }

    @PostMapping("/write")
    public String write(RecruitBoardDto recruitBoardDto, Model m, HttpSession session, RedirectAttributes rattr) {
        String writer = (String) session.getAttribute("id");
        recruitBoardDto.setWriter(writer);

        try {
            int rowCnt = recruitBoardService.write(recruitBoardDto);

            if(rowCnt!=1)
                throw new Exception("Write Failed");

            rattr.addFlashAttribute("msg", "WRT_OK");
            return "redirect:/recruit/list";
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute(recruitBoardDto);
            m.addAttribute("msg", "WRT_ERR");
            return "recruitBoard";
        }
    }

    @GetMapping("/write")
    public String write(Model model) {
        model.addAttribute("mode", "new");
        return "recruitBoard";
    }

    @PostMapping("/remove")
    public String remove(Integer bno, Integer page, Integer pageSize, Model m, HttpSession session, RedirectAttributes rattr) {
        String writer = (String) session.getAttribute("id");

        try {
            rattr.addAttribute("page", page);
            rattr.addAttribute("pageSize", pageSize);
            int rowCnt = recruitBoardService.remove(bno, writer);

            if(rowCnt!=1)
                throw new Exception("Failed Remove");
            rattr.addFlashAttribute("msg", "DEL_OK");
        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "DEL_ERR");
        }
        return "redirect:/recruit/list";
    }

    @GetMapping("/read")
    public String read(Integer bno, Integer page, Integer pageSize, Model m) {
        try {
            RecruitBoardDto recruitBoardDto = recruitBoardService.read(bno);
            m.addAttribute(recruitBoardDto);
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "recruitBoard";
    }

    @GetMapping("/list")
    public String list(SearchCondition sc, Model m, HttpServletRequest request) {
        if(!loginCheck(request))
            return "redirect:/login/login?toURL="+request.getRequestURL();  // ???????????? ???????????? ????????? ???????????? ??????

        try {

            int totalCnt = recruitBoardService.getSearchResultCnt(sc);
            m.addAttribute("totalCnt", totalCnt);
            PageHandler pageHandler = new PageHandler(totalCnt, sc);

            List<RecruitBoardDto> list = recruitBoardService.getSearchResultPage(sc);

            m.addAttribute("list", list);
            m.addAttribute("ph", pageHandler);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return "recruitBoardList"; // ???????????? ??? ????????????, ????????? ???????????? ??????
    }

    private boolean loginCheck(HttpServletRequest request) {
        // 1. ????????? ?????????
        HttpSession session = request.getSession();
        // 2. ????????? id??? ????????? ??????, ????????? true??? ??????
        return session.getAttribute("id")!=null;
    }
}
