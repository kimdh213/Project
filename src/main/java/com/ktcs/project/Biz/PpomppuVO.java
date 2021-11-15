package com.ktcs.project.Biz;

import lombok.Data;

import java.util.Date;

@Data
public class PpomppuVO {

    private int number;
    private String category;
    private String q_class;
    private String l_name;
    private String l_title;
    private Date date;
    private int click_num;
    private String c_date;
    private String url;
    private String maincontent;

    /** 검색 관련 키워드 */
    private String searchKeyword;
    private String searchCondition;
    private String start_date;
    private String end_date;

    /** 일자별 수집현황 */
    private int count;

    /** 전체 카운트 */
    private int t_count;

    /** 현재 페이지 번호 */
    private int page;
    /** 페이지당 출력할 데이터 개수 */
    private int perPageNum;
    /** 화면 하단에 출력할 페이지 사이즈 */
    private int pageStart;
    private int endpage;

    /** 질문 유형 분석 */
    private String c_category;
    private int cnt_total;

    /** 키워드 분석 */
    private int row_number;
    private double ratio;
    private double roc;

    /** AreaChart 페이지 */
    private double allAvg;

    public PpomppuVO() {
        this.page = 1;
        this.perPageNum = 10;
    }

    public int getPageStart() {
        return (this.page - 1) * perPageNum;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        if (page <= 0) {
            this.page = 1;
        } else {
            this.page = page;
        }
    }

    public int getPerPageNum() {
        return perPageNum;
    }

    public void setPerPageNum(int pageCount) {
        int cnt = this.perPageNum;
        if(pageCount != cnt) {
            this.perPageNum = cnt;
        } else {
            this.perPageNum = pageCount;
        }
    }
}
