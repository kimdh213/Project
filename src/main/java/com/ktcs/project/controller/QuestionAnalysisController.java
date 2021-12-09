package com.ktcs.project.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ktcs.project.biz.PpomppuService;
import com.ktcs.project.biz.PpomppuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class QuestionAnalysisController {
    @Autowired
    private PpomppuService ppomppuService;

    @RequestMapping(value = "/getChartList.do")
    public String getChartList(PpomppuVO ppomppuVO, Model model) {

        /** 날짜 검색조건 유지 */
        model.addAttribute("search", ppomppuVO);

        /** 처음 질문유형 페이지에 접속 시, StartDate와 EndDate 가 없으므로 아래 적용 */
        if(ppomppuVO.getStart_date() != null) {
            List<PpomppuVO> chartList = ppomppuService.getChartList(ppomppuVO);

            JsonArray jsonArray = new JsonArray();

            /** Top1 에는 cateogry명과 count, sliced, selected 가 포함 */
            JsonObject json = new JsonObject();
            json.addProperty("name", chartList.get(0).getC_category());
            json.addProperty("y", chartList.get(0).getCnt_total());
            json.addProperty("sliced","true");
            json.addProperty("selected", "true");
            jsonArray.add(json);

            /** Top2~Top5 까지는 각각의 Category명과 Count 가 포함 */
            for(int i=1; i<5; i++) {
                JsonObject json1 = new JsonObject();
                json1.addProperty("name", chartList.get(i).getC_category());
                json1.addProperty("y", chartList.get(i).getCnt_total());
                jsonArray.add(json1);
            }

            /** Top6~10 까지는 기타항목으로 보여지며, 합산된 Count 가 포함  */
            int sum_cnt = 0; // 6위~10위까지의 count를 기타로 합치는 변수
            for(int i=5; i<10; i++) {
                sum_cnt += chartList.get(i).getCnt_total();
            }
            JsonObject json2 = new JsonObject();
            json2.addProperty("name", "기타");
            json2.addProperty("y", sum_cnt);
            jsonArray.add(json2);

            model.addAttribute("jsonArray", jsonArray);
            model.addAttribute("chartList", chartList);
        }
        return "QuestionAnalysis";
    }
}