package com.dmsf.model.resp;

import com.dmsf.domain.Video;

import java.util.List;

/**
 * @Auther: LiPan
 * @Date: 2018.12.14 11:15
 * @Description:
 */
public class NavDataResp {

    private String type;
    private List<Video> data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Video> getData() {
        return data;
    }

    public void setData(List<Video> data) {
        this.data = data;
    }
}
