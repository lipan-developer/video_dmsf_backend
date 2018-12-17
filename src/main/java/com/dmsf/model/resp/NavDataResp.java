package com.dmsf.model.resp;

import com.dmsf.domain.DmsfVideoInfo;

import java.util.List;

/**
 * @Auther: LiPan
 * @Date: 2018.12.14 11:15
 * @Description:
 */
public class NavDataResp {

    private String type;
    private List<DmsfVideoInfo> data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<DmsfVideoInfo> getData() {
        return data;
    }

    public void setData(List<DmsfVideoInfo> data) {
        this.data = data;
    }
}
