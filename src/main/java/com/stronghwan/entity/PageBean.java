package com.stronghwan.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页封装
 * @Author stronghwan
 * @Verison
 * @Date2019/12/21-17-36
 */
public class PageBean<T>{

    // 当前页面 limit的第一个参数为 (currentPage-1) * pageCount
    private int currentPage;
    // 每页的大小 limit的第二个参数
    private int pageCount;
    // 总页数
    private Integer totalPage;
    // 总记录数
    private int totalCount;
    // 开始页数
    private int startPage = 1;

    private List<T> pageData = new ArrayList<>();

    public List<Integer> getListTotalPage(){
        int page = 0;
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < totalPage; i++) {
            page++;
            integerList.add(page);
        }
        return integerList;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalPage() {
        return  (this.totalCount % pageCount == 0) ? (this.totalCount / pageCount) : (this.totalCount / pageCount + 1);
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return (this.totalCount>0) ? this.totalCount : 0 ;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getStartPage() {
        return startPage;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", pageCount=" + pageCount +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", startPage=" + startPage +
                ", pageData=" + pageData +
                '}';
    }
}
