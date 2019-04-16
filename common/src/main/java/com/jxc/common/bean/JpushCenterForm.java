package com.jxc.common.bean;

import com.alibaba.fastjson.JSONObject;

public class JpushCenterForm {

    private boolean sendToAll;//是否全体发送
    private String aliases;//接受推送的别名数组(逗号分割)
    private String notificationTitle;//通知title
    private String notificationAlert;//通知内容
    private JSONObject notificationExtraParams;//通知额外参数
    private String messageTitle;//消息title
    private String messageContent;//消息内容
    private JSONObject messageExtraParams;//消息额外参数
    private long timeToLive;//离线保存时长

    public boolean isSendToAll() {
        return sendToAll;
    }

    public void setSendToAll(boolean sendToAll) {
        this.sendToAll = sendToAll;
    }

    public String getAliases() {
        return aliases;
    }

    public void setAliases(String aliases) {
        this.aliases = aliases;
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public String getNotificationAlert() {
        return notificationAlert;
    }

    public void setNotificationAlert(String notificationAlert) {
        this.notificationAlert = notificationAlert;
    }

    public JSONObject getNotificationExtraParams() {
        return notificationExtraParams;
    }

    public void setNotificationExtraParams(JSONObject notificationExtraParams) {
        this.notificationExtraParams = notificationExtraParams;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public JSONObject getMessageExtraParams() {
        return messageExtraParams;
    }

    public void setMessageExtraParams(JSONObject messageExtraParams) {
        this.messageExtraParams = messageExtraParams;
    }

    public long getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(long timeToLive) {
        this.timeToLive = timeToLive;
    }
}
