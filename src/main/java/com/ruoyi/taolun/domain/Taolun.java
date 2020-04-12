package com.ruoyi.taolun.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 讨论对象 taolun
 * 
 * @author ruoyi
 * @date 2020-04-11
 */
public class Taolun extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;



    /** 状态 */
    @Excel(name = "状态")
    private String state;

    /** 收藏 */
    @Excel(name = "收藏")
    private int shoucang;

    /** 点赞 */
    @Excel(name = "点赞")
    private int dianzan;

    /** 热度 */
    @Excel(name = "热度")
    private Long redu;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }



    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setShoucang(int shoucang)
    {
        this.shoucang = shoucang;
    }

    public int getShoucang()
    {
        return shoucang;
    }
    public void setDianzan(int dianzan)
    {
        this.dianzan = dianzan;
    }

    public int getDianzan()
    {
        return dianzan;
    }
    public void setRedu(Long redu) 
    {
        this.redu = redu;
    }

    public Long getRedu() 
    {
        return redu;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("createTime", getCreateTime())

            .append("state", getState())
            .append("shoucang", getShoucang())
            .append("dianzan", getDianzan())
            .append("redu", getRedu())
            .append("content", getContent())
            .toString();
    }
}
