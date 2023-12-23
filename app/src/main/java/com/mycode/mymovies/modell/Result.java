package com.mycode.mymovies.modell;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

//step..1
public class Result {
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("total_pages")
    @Expose
    private Integer total_page;
    @SerializedName("total_results")
    @Expose
    private Integer total_result;
    @SerializedName("results")
    @Expose
    private List<Movies> results =null;

    public Result() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotal_page() {
        return total_page;
    }

    public void setTotal_page(Integer total_page) {
        this.total_page = total_page;
    }

    public Integer getTotal_result() {
        return total_result;
    }

    public void setTotal_result(Integer total_result) {
        this.total_result = total_result;
    }

    public List<Movies> getResults() {
        return results;
    }

    public void setResults(List<Movies> results) {
        this.results = results;
    }
}
