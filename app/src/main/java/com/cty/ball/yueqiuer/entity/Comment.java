package com.cty.ball.yueqiuer.entity;

import cn.bmob.v3.BmobObject;

/**
 * 评论表,关联活动列表
 * Created by TYD on 2016/4/9.
 */
public class Comment extends BmobObject {
    private Integer commentID;      //评论ID
    private Integer activityID;     //活动ID
    private String CommentInfo;     //评论内容

    public Integer getCommentID() {
        return commentID;
    }

    public void setCommentID(Integer commentID) {
        this.commentID = commentID;
    }

    public Integer getActivityID() {
        return activityID;
    }

    public void setActivityID(Integer activityID) {
        this.activityID = activityID;
    }

    public String getCommentInfo() {
        return CommentInfo;
    }

    public void setCommentInfo(String commentInfo) {
        CommentInfo = commentInfo;
    }

    public Comment(Integer commentID, Integer activityID, String commentInfo) {
        this.commentID = commentID;
        this.activityID = activityID;
        CommentInfo = commentInfo;

    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentID=" + commentID +
                ", activityID=" + activityID +
                ", CommentInfo='" + CommentInfo + '\'' +
                '}';
    }
}
