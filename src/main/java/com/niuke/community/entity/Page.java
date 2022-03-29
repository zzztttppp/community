package com.niuke.community.entity;

public class Page {
    //当前页码
    private int current =1;
    //上限
    private int limit = 10;
    //数据总数，用于查询总页码
    private int rows;
    //查询路径（用于复用分页链接）
    private String path;

    //当前页的起始行
    public int getOffset() {
        return (current-1)*limit;
    }
    //获取总页数
    public int getTotal() {
        return rows%limit==0? (rows/limit):(rows/limit+1);
    }
    //获取起始页码  6-10
    public int getFrom() {
        return current>2? current-2:1;
    }
    //获取结束页码
    public int getTo() {
        int to=current+2;
        int total=getTotal();
        return  to>total? total:to;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if(current>0)
            this.current = current;
    }

    public int getLimit() {

        return limit;
    }

    public void setLimit(int limit) {
        if(limit>0 && limit<100)
            this.limit = limit;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if(rows>=0)
            this.rows = rows;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }



    @Override
    public String toString() {
        return "Page{" +
                "current=" + current +
                ", limit=" + limit +
                ", rows=" + rows +
                ", path='" + path + '\'' +
                '}';
    }

    public Page(int current, int limit, int rows, String path) {
        this.current = current;
        this.limit = limit;
        this.rows = rows;
        this.path = path;
    }

    public Page() {
    }
}
