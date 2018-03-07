package com.lmandy.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 94993 on 2017/3/6.
 */
public class PageBean <T> {
    private Integer pageNo;
    private Integer pageSize;
    private List<T> results;
    private Integer totalCount;
    private Integer totalPageNo;
    private Map<String,Object> conMap;
    private List<Integer> showNums;
    private String params;
    private String url;
    private Integer actualPageNo;

    public PageBean() {
    }

    public PageBean(Integer pageNo, Integer pageSize, Map<String, Object> conMap) {
        this.pageNo = pageNo == null ? 1:pageNo;
        this.pageSize = pageSize == null ? 10:pageSize;
        this.conMap = conMap;
        setPageNo(this.pageNo);
        setActualPageNo(this.pageNo);
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = (pageNo-1)*pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPageNo() {

        totalPageNo = totalCount % pageSize == 0 ? totalCount % pageSize : (totalCount / pageSize) +1;

        return totalPageNo;
    }

    public void setTotalPageNo(Integer totalPageNo) {
        this.totalPageNo = totalPageNo;
    }

    public Map<String, Object> getConMap() {
        return conMap;
    }

    public void setConMap(Map<String, Object> conMap) {
        this.conMap = conMap;
    }

    public List<Integer> getShowNums() {

        List<Integer> nums = new ArrayList<>();
        Integer totalPageNo = getTotalPageNo();

        if(totalPageNo<=5){
            for (Integer i = 1; i <= totalPageNo; i++) {
                nums.add(i);
            }
        }else{
            if(pageNo + 2 > totalPageNo){
                nums.add(totalPageNo);
                nums.add(totalPageNo-1);
                nums.add(totalPageNo-2);
                nums.add(totalPageNo-3);
                nums.add(totalPageNo-4);
            }else{
                nums.add(totalPageNo+2);
                nums.add(totalPageNo+1);
                nums.add(totalPageNo);
                nums.add(totalPageNo-1);
                nums.add(totalPageNo-2);
            }
        }

        return nums;
    }

    public void setShowNums(List<Integer> showNums) {
        this.showNums = showNums;
    }

    public String getParams() {
        StringBuffer sb = new StringBuffer();
        if(conMap.size()>0){
            for (String key : conMap.keySet()) {
                if(conMap.get(key) !=null && !conMap.get(key).equals("")){
                    sb.append("&").append(key).append("=").append(conMap.get(key));
                }
            }
        }
        return sb.toString();
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getActualPageNo() {
        return actualPageNo;
    }

    public void setActualPageNo(Integer actualPageNo) {
        this.actualPageNo = actualPageNo;
    }
}
