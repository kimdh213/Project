package com.ktcs.project.Biz;

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

}