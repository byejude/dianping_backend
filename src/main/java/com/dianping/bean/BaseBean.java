package com.dianping.bean;

/**
 * Created by byebyejude on 2017/9/21.
 */
public class BaseBean {
    private Page page;
    public BaseBean(){
        this.page = new Page();
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
