package com.dmsf.model.req;

/**
 * @Auther: LiPan
 * @Date: 2018.12.20 16:45
 * @Description:
 */
public class ManagePageReq {


    private Integer page;
    private Integer size;
    private String title;
    private String type;
    private String actor;

    public ManagePageReq(Integer page, Integer size, String title, String type, String actor) {
        this.page = page;
        this.size = size;
        this.title = title;
        this.type = type;
        this.actor = actor;
    }


    public ManagePageReq() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
