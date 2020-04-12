package com.ruoyi.fuwu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 物业服务对象 fuwu
 * 
 * @author ruoyi
 * @date 2020-04-12
 */
public class Fuwu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 服务类别 */
    @Excel(name = "服务类别")
    private String type;

    /** 业主姓名 */
    @Excel(name = "业主姓名")
    private String name;

    /** 业主地址 */
    @Excel(name = "业主地址")
    private String address;

    /** 审核状态 */
    @Excel(name = "审核状态")
    private String shenheState;

    /** 服务人数 */
    @Excel(name = "服务人数")
    private Long renshu;

    /** 星级 */
    @Excel(name = "星级")
    private Long xingji;

    /** 评论 */
    @Excel(name = "评论")
    private String pinglun;

    /** 费用 */
    @Excel(name = "费用")
    private Long feiyong;

    /** 是否缴费 */
    @Excel(name = "是否缴费")
    private String jiaofeiState;


    private String chuliState;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setShenheState(String shenheState) 
    {
        this.shenheState = shenheState;
    }

    public String getShenheState() 
    {
        return shenheState;
    }
    public void setRenshu(Long renshu) 
    {
        this.renshu = renshu;
    }

    public Long getRenshu() 
    {
        return renshu;
    }
    public void setXingji(Long xingji) 
    {
        this.xingji = xingji;
    }

    public Long getXingji() 
    {
        return xingji;
    }
    public void setPinglun(String pinglun) 
    {
        this.pinglun = pinglun;
    }

    public String getPinglun() 
    {
        return pinglun;
    }
    public void setFeiyong(Long feiyong) 
    {
        this.feiyong = feiyong;
    }

    public Long getFeiyong() 
    {
        return feiyong;
    }
    public void setJiaofeiState(String jiaofeiState) 
    {
        this.jiaofeiState = jiaofeiState;
    }

    public String getJiaofeiState() 
    {
        return jiaofeiState;
    }

    public String getChuliState() {
        return chuliState;
    }

    public void setChuliState(String chuliState) {
        this.chuliState = chuliState;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("name", getName())
            .append("address", getAddress())
            .append("shenheState", getShenheState())
            .append("renshu", getRenshu())
            .append("xingji", getXingji())
            .append("pinglun", getPinglun())
            .append("feiyong", getFeiyong())
            .append("jiaofeiState", getJiaofeiState())
            .toString();
    }
}
