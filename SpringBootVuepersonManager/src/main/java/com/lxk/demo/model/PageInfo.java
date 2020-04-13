package com.lxk.demo.model;

public class PageInfo {
    private Object count,page;
    private Object results;
    private long total;

    public Object getResults() {
        return results;
    }

    public void setResults(Object results) {
        this.results = results;
    }

    public Object getCount() {
        return count;
    }

    public void setCount(Object count) {
        this.count = count;
    }

    public Object getPage() {
        return page;
    }

    public void setPage(Object page) {
        this.page = page;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
