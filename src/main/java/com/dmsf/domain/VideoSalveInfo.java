package com.dmsf.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Auther: LiPan
 * @Date: 2018.12.17 15:48
 * @Description:
 */
@Entity
@Table(name = "t_video_salve_info")
public class VideoSalveInfo {

    @Id
    private String tableKey;
    private String masterKey;
    private String url;

    public String getTableKey() {
        return tableKey;
    }

    public void setTableKey(String tableKey) {
        this.tableKey = tableKey;
    }

    public String getMasterKey() {
        return masterKey;
    }

    public void setMasterKey(String masterKey) {
        this.masterKey = masterKey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
