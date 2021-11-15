package com.ktcs.project.Biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.ProxySelector;
import java.util.List;

@Service
public class PpomppuService {

    @Autowired
    private PpomppuDAO ppomppuDAO;
    private ProxySelector PageRequest;

    public List<PpomppuVO> getBoardList(PpomppuVO ppomppuVO) {
        return ppomppuDAO.getBoardList(ppomppuVO);
    }

    public List<PpomppuVO> getDayList(PpomppuVO ppomppuVO) {
        return ppomppuDAO.getDayList(ppomppuVO);
    }

    public List<PpomppuVO> getChartList(PpomppuVO ppomppuVO) {
        return ppomppuDAO.getChartList(ppomppuVO);
    }

    public List<PpomppuVO> getKeywordList(PpomppuVO ppomppuVO) {
        return ppomppuDAO.getKeywordList(ppomppuVO);
    }

    public List<PpomppuVO> getAreaChart(PpomppuVO ppomppuVO) {
        return ppomppuDAO.getAreaChart(ppomppuVO);
    }

    public List<PpomppuVO> getAreaChartLY(PpomppuVO ppomppuVO) {
        return ppomppuDAO.getAreaChartLY(ppomppuVO);
    }

    public PpomppuVO getAreaAvgTY(PpomppuVO ppomppuVO) {
        return ppomppuDAO.getAreaAvgTY(ppomppuVO);
    }

    public PpomppuVO getAreaAvgLY(PpomppuVO ppomppuVO) {
        return ppomppuDAO.getAreaAvgLY(ppomppuVO);
    }
}
