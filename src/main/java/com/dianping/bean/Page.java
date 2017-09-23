package com.dianping.bean;

/**
 * Created by byebyejude on 2017/9/21.
 */
public class Page {
    private int totalNumber;
    private int currentPage;
    private int totalPage;
    private int NumberInPage;

    public Page(){
        this.currentPage = 1;
        this.NumberInPage = 5;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getNumberInPage() {
        return NumberInPage;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setNumberInPage(int numberInPage) {
        NumberInPage = numberInPage;
    }

    private  void count(){
        this.totalPage = this.totalNumber/this.NumberInPage;
        if(this.totalNumber%this.NumberInPage>0){
            this.totalPage++;
        }

        if(this.totalPage<=0){
            this.totalPage = 1;
        }

        if(this.currentPage >this.totalPage){
            this.currentPage = this.totalPage;
        }

        if(this.currentPage<=0){
           this.currentPage = 1;
        }
    }
}
