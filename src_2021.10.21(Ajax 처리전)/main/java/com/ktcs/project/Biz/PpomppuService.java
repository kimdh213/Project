package com.ktcs.project.Biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.jvm.hotspot.debugger.Page;

import java.awt.print.Pageable;
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
}
