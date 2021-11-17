package com.ktcs.project.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ktcs.project.Biz.PpomppuService;
import com.ktcs.project.Biz.PpomppuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class KeywordAnalysisContorller {

    @Autowired
    private PpomppuService ppomppuService;

    @RequestMapping("/getKeywordList.do")
    public String getKeywordList(PpomppuVO ppomppuVO, Model model) {

        /** 날짜 검색조건 유지 */
        model.addAttribute("search", ppomppuVO);

        if(ppomppuVO.getStart_date()!=null) {
            List<PpomppuVO> keywordList = ppomppuService.getKeywordList(ppomppuVO);
            model.addAttribute("keywordList", keywordList);
        }
        return "KeywordAnalysis";
    }

    // ajax 컨트롤러
    @ResponseBody
    @RequestMapping("getAjaxArea.do")
    public String getAjaxArea(PpomppuVO ppomppuVO) {

        JsonArray jsonArray = new JsonArray();
        SimpleDateFormat fm = new SimpleDateFormat("MM-dd");

        // 1. 자바스크립트로 호출받았을 때 리스트 조회
        List<PpomppuVO> areaChart = ppomppuService.getAreaChart(ppomppuVO);
        List<PpomppuVO> areaChartLY = ppomppuService.getAreaChartLY(ppomppuVO);
        PpomppuVO areaChartAvgTY = ppomppuService.getAreaAvgTY(ppomppuVO);
        PpomppuVO areaChartAvgLY = ppomppuService.getAreaAvgLY(ppomppuVO);

        // 2. 페이징 계산값 json 객체에 저장
        // 2-1. 날짜 값 저장
        JsonObject jsonObjectDate = new JsonObject();
        JsonArray jsonArrayDate = new JsonArray();
        for(int i=0; i<areaChart.size(); i++) {
            String c_date = areaChart.get(i).getC_date();
            jsonArrayDate.add(c_date);
        }
        jsonObjectDate.addProperty("categories", jsonArrayDate.toString());

        // 2-2. 카운트 값 저장
        JsonObject jsonObjectCount = new JsonObject();
        JsonArray jsonArrayCount = new JsonArray();
        for(int i=0; i<areaChart.size(); i++) {
            jsonArrayCount.add(areaChart.get(i).getCnt_total());
        }

        jsonObjectCount.addProperty("data", jsonArrayCount.toString());

        jsonArray.add(jsonObjectDate);
        jsonArray.add(jsonObjectCount);

        // 4. 페이징 계산값 json 객체에 저장
        // 4-1. 날짜 값 저장
        JsonObject jsonObjectDateLY = new JsonObject();
        JsonArray jsonArrayDateLY = new JsonArray();
        for(int i=0; i<areaChartLY.size(); i++) {
            String c_date = areaChartLY.get(i).getC_date();
            jsonArrayDateLY.add(c_date);
        }
        jsonObjectDateLY.addProperty("categories", jsonArrayDateLY.toString());

        // 4-2. 카운트 값 저장
        JsonObject jsonObjectCountLY = new JsonObject();
        JsonArray jsonArrayCountLY = new JsonArray();
        for(int i=0; i<areaChartLY.size(); i++) {
            jsonArrayCountLY.add(areaChartLY.get(i).getCnt_total());
        }

        jsonObjectCountLY.addProperty("data", jsonArrayCountLY.toString());

        jsonArray.add(jsonObjectDateLY);
        jsonArray.add(jsonObjectCountLY);
        jsonArray.add(areaChartAvgTY.getAllAvg());
        jsonArray.add(areaChartAvgLY.getAllAvg());

        // 5. json 객체로 list 변환(vo)
        Gson gson = new Gson();
        String jsonAreaChart = gson.toJson(jsonArray);

        // 6. return
        return jsonAreaChart;
    }
}