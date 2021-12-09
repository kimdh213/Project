package com.ktcs.project.biz;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PpomppuDAO {

    @Autowired
    private SqlSession sqlSession;

    public List<PpomppuVO> getBoardList(PpomppuVO ppomppuVO) {
        List<PpomppuVO> boardList = sqlSession.selectList("ppomppu.getBoardList", ppomppuVO);
        return boardList;
    }

    public List<PpomppuVO> getDayList(PpomppuVO ppomppuVO) {
        List<PpomppuVO> dayList = sqlSession.selectList("ppomppu.getDayList", ppomppuVO);
        return dayList;
    }

    public List<PpomppuVO> getChartList(PpomppuVO ppomppuVO) {
        List<PpomppuVO> chartList = sqlSession.selectList("ppomppu.getChartList", ppomppuVO);
        return chartList;
    }

    public List<PpomppuVO> getKeywordList(PpomppuVO ppomppuVO) {
        List<PpomppuVO> keywordList = sqlSession.selectList("ppomppu.getKeywordList", ppomppuVO);
        return keywordList;
    }

    public List<PpomppuVO> getAreaChart(PpomppuVO ppomppuVO) {
        List<PpomppuVO> areaChart = sqlSession.selectList("ppomppu.getAreaChart", ppomppuVO);
        return areaChart;
    }

    public List<PpomppuVO> getAreaChartLY(PpomppuVO ppomppuVO) {
        List<PpomppuVO> areaChartLY = sqlSession.selectList("ppomppu.getAreaChartLY", ppomppuVO);
        return areaChartLY;
    }

    public PpomppuVO getAreaAvgTY(PpomppuVO ppomppuVO) {
        PpomppuVO areaAvgTY = sqlSession.selectOne("ppomppu.getAreaAvgTY", ppomppuVO);
        return areaAvgTY;
    }

    public PpomppuVO getAreaAvgLY(PpomppuVO ppomppuVO) {
        PpomppuVO areaAvgLY = sqlSession.selectOne("ppomppu.getAreaAvgLY", ppomppuVO);
        return areaAvgLY;
    }
}