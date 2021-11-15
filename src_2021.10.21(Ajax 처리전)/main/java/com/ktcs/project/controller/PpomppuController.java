package com.ktcs.project.controller;

import com.ktcs.project.Biz.PageMaker;
import com.ktcs.project.Biz.PpomppuService;
import com.ktcs.project.Biz.PpomppuVO;
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

    @RequestMapping(value = "/getBoardList.do")
    public String getBoardList(@ModelAttribute("ppomppu") PpomppuVO ppomppuVO, Model model) {
        PageMaker pageMaker = new PageMaker();
        pageMaker.setPpomppuVO(ppomppuVO);

        List<PpomppuVO> boardList = ppomppuService.getBoardList(ppomppuVO);
        model.addAttribute("boardList", boardList);
        model.addAttribute("pageMaker", pageMaker);
        model.addAttribute("search", ppomppuVO);
        pageMaker.setTotalCount(boardList.get(0).getT_count());

        System.out.println("========================================================================");
        System.out.println("시작페이지(pageMaker.getStartPage()) : " + pageMaker.getStartPage());
        System.out.println("종료페이지(pageMaker.getEndPage()) : " + pageMaker.getEndPage());
        System.out.println("pageMaker.getPpomppuVO().getPerPageNum()) : " + pageMaker.getPpomppuVO().getPerPageNum());
        System.out.println("pageMaker.getPpomppuVO().getPageStart() : " + pageMaker.getPpomppuVO().getPageStart());
        System.out.println("전체 카운트(pageMaker.getTotalCount()) : " + pageMaker.getTotalCount());
        System.out.println("isPrev(isPrev()) : " + pageMaker.isPrev());
        System.out.println("isNext(pageMaker.isNext()) : " + pageMaker.isNext());
        System.out.println("현재 페이지(pageMaker.getPpomppuVO().getPage()) : " + pageMaker.getPpomppuVO().getPage());
        System.out.println("마지막 페이지(pageMaker.getFinishPage()) : " + pageMaker.getFinishPage());
        System.out.println("========================================================================");

        /** 일자별 수집현황 */
        List<PpomppuVO> dayList = ppomppuService.getDayList(ppomppuVO);
        model.addAttribute("dayList",dayList);
        return "GatherData";
    }

    @RequestMapping(value = "/QuestionAnalysis.html")
    public String quetionAnalysis(Model model) {

        return "QuestionAnalysis";
    }

    @RequestMapping(value = "/getChartList.do")
    public String getChartList(@ModelAttribute("ppomppu") PpomppuVO ppomppuVO, Model model) {
        if (ppomppuVO.getStart_date() == null) {
            ppomppuVO.setStart_date("2020-01-01");
        }
        if (ppomppuVO.getEnd_date() == null) {
            ppomppuVO.setEnd_date("2020-01-15");
        }
        List<PpomppuVO> chartList = ppomppuService.getChartList(ppomppuVO);
        model.addAttribute("chartList", chartList);
        model.addAttribute("search", ppomppuVO);

        System.out.println(chartList);

        return "QuestionAnalysis";
    }

    @RequestMapping(value = "/KeywordAnalysis")
    public String keywordAnalysis(Model model) {

        return "/KeywordAnalysis";
    }

}
