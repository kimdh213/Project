package com.ktcs.project.controller;

import com.ktcs.project.biz.PageMaker;
import com.ktcs.project.biz.PpomppuService;
import com.ktcs.project.biz.PpomppuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PpomppuController {

    @Autowired
    private PpomppuService ppomppuService;

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/getBoardList.do")
    public String getBoardList(@ModelAttribute("ppomppu") PpomppuVO ppomppuVO, Model model) {
        PageMaker pageMaker = new PageMaker();
        pageMaker.setPpomppuVO(ppomppuVO);

        /** 리스트 출력 */
        List<PpomppuVO> boardList = ppomppuService.getBoardList(ppomppuVO);
        model.addAttribute("boardList", boardList);
        model.addAttribute("pageMaker", pageMaker);

        /** 검색조건 유지 */
        model.addAttribute("search", ppomppuVO);

        /** 리스트 내 전체 건수 지정 */
        pageMaker.setTotalCount(boardList.get(0).getT_count());

        /** 일자별 수집현황 */
        List<PpomppuVO> dayList = ppomppuService.getDayList(ppomppuVO);
        model.addAttribute("dayList",dayList);

        return "GatherData";
    }
}
