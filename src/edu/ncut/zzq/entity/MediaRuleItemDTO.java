package edu.ncut.zzq.entity;

/**
 * Created by vansteve911 on 16-11-22.
 */
public class MediaRuleItemDTO {
    private Integer t; // 类型：1-每日发文数量限制，其他待定
    private String val; // 规则的值：字符串

    public enum Type {
        UNDEFINED, // 0-未定义
        MAX_PUBLISH_COUNT_DAILY, // 1-每日发文数量限制
        MAX_VIDEO_PUBLISH_COUNT_DAILY, // 2-视频每日发文数量限制
        PLAYLIST_AUTHORITY_FLAG
    }

    public MediaRuleItemDTO() {
    }

    public MediaRuleItemDTO(Type type, String val) {
        this.t = type.ordinal();
        this.val = val;
    }

    public Integer getT() {
        return t;
    }

    public void setT(Integer t) {
        this.t = t;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "MediaRuleItemDTO{" +
                "t=" + t +
                ", val='" + val + '\'' +
                '}';
    }
}
