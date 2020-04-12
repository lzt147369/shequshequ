package com.ruoyi.taolun.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 讨论相关对象 taolu_user
 * 
 * @author ruoyi
 * @date 2020-04-11
 */
public class TaoluUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 讨论内容id */
    @Excel(name = "讨论内容id")
    private Long taolunId;

    /** 收藏者id */
    @Excel(name = "收藏者id")
    private Long shoucangUserId;

    /** 收藏者 */
    @Excel(name = "收藏者")
    private String shoucangUserName;

    /** 点赞者id */
    @Excel(name = "点赞者id")
    private Long dianzanUserId;

    /** 点赞者 */
    @Excel(name = "点赞者")
    private String dianzanUserName;

    /** 评论者id */
    @Excel(name = "评论者id")
    private Long pinglunUserId;

    /** 评论者 */
    @Excel(name = "评论者")
    private String pinglunUserName;

    /** 评论内容 */
    @Excel(name = "评论内容")
    private String pinglunContent;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTaolunId(Long taolunId) 
    {
        this.taolunId = taolunId;
    }

    public Long getTaolunId() 
    {
        return taolunId;
    }
    public void setShoucangUserId(Long shoucangUserId) 
    {
        this.shoucangUserId = shoucangUserId;
    }

    public Long getShoucangUserId() 
    {
        return shoucangUserId;
    }
    public void setShoucangUserName(String shoucangUserName) 
    {
        this.shoucangUserName = shoucangUserName;
    }

    public String getShoucangUserName() 
    {
        return shoucangUserName;
    }
    public void setDianzanUserId(Long dianzanUserId) 
    {
        this.dianzanUserId = dianzanUserId;
    }

    public Long getDianzanUserId() 
    {
        return dianzanUserId;
    }
    public void setDianzanUserName(String dianzanUserName) 
    {
        this.dianzanUserName = dianzanUserName;
    }

    public String getDianzanUserName() 
    {
        return dianzanUserName;
    }
    public void setPinglunUserId(Long pinglunUserId) 
    {
        this.pinglunUserId = pinglunUserId;
    }

    public Long getPinglunUserId() 
    {
        return pinglunUserId;
    }
    public void setPinglunUserName(String pinglunUserName) 
    {
        this.pinglunUserName = pinglunUserName;
    }

    public String getPinglunUserName() 
    {
        return pinglunUserName;
    }
    public void setPinglunContent(String pinglunContent) 
    {
        this.pinglunContent = pinglunContent;
    }

    public String getPinglunContent() 
    {
        return pinglunContent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("taolunId", getTaolunId())
            .append("shoucangUserId", getShoucangUserId())
            .append("shoucangUserName", getShoucangUserName())
            .append("dianzanUserId", getDianzanUserId())
            .append("dianzanUserName", getDianzanUserName())
            .append("pinglunUserId", getPinglunUserId())
            .append("pinglunUserName", getPinglunUserName())
            .append("pinglunContent", getPinglunContent())
            .append("createTime", getCreateTime())
            .toString();
    }
}
