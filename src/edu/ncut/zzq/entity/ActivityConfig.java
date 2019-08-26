package edu.ncut.zzq.entity;

import java.util.Date;

/**
 * @ClassName: ActivityConfig
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/8/14 14:05
 * @Version: 1.0
 */
public class ActivityConfig {
    private Integer essayId;
    private String activityClassification;
    private Date startTime;
    private Date endTime;
    private boolean modify;

    public ActivityConfig(Integer essayId, String activityClassification, Date startTime, Date endTime, boolean modify) {
        this.essayId = essayId;
        this.activityClassification = activityClassification;
        this.startTime = startTime;
        this.endTime = endTime;
        this.modify = modify;
    }

    public Integer getEssayId() {
        return essayId;
    }

    public void setEssayId(Integer essayId) {
        this.essayId = essayId;
    }

    public String getActivityClassification() {
        return activityClassification;
    }

    public void setActivityClassification(String activityClassification) {
        this.activityClassification = activityClassification;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public boolean isModify() {
        return modify;
    }

    public void setModify(boolean modify) {
        this.modify = modify;
    }
}
