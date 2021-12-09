package com.ktcs.project.biz;

import lombok.Data;

@Data
public class PageMaker {

    private PpomppuVO ppomppuVO;
    private int totalCount;
    private int startPage;
    private int endPage;
    private int finishPage;
    private boolean prev;
    private boolean next;
    private int displayPageNum = 10;

    public PpomppuVO getPpomppuVO() {
        return ppomppuVO;
    }

    public void setPpompu(PpomppuVO ppomppuVO){
        this.ppomppuVO = ppomppuVO;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        calcData();
    }

    private void calcData() {
        endPage = (int) (Math.ceil(ppomppuVO.getPage() / (double) displayPageNum) * displayPageNum);
        finishPage = (int) (Math.ceil(totalCount / (double) displayPageNum));


        startPage = (endPage - displayPageNum) + 1;
        if(startPage <= 0) startPage = 1;

        int tempEndPage = (int) (Math.ceil(totalCount / (double) ppomppuVO.getPerPageNum()));
        if(endPage > tempEndPage) {
            endPage = tempEndPage;
        }

        prev = startPage == 1 ? false:true;
        next = endPage * ppomppuVO.getPerPageNum() < totalCount ? true:false;
    }



    public int getStartPage() {
        return startPage;
    }
    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }
    public int getEndPage() {
        return endPage;
    }
    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }
    public boolean isPrev() {
        return prev;
    }
    public void setPrev(boolean prev) {
        this.prev = prev;
    }
    public boolean isNext() {
        return next;
    }
    public void setNext(boolean next) {
        this.next = next;
    }
    public int getDisplayPageNum() {
        return displayPageNum;
    }
    public void setDisplayPageNum(int displayPageNum) {
        this.displayPageNum = displayPageNum;
    }
}
