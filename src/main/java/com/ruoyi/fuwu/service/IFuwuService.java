package com.ruoyi.fuwu.service;

import java.util.List;
import com.ruoyi.fuwu.domain.Fuwu;

/**
 * 物业服务Service接口
 * 
 * @author ruoyi
 * @date 2020-04-12
 */
public interface IFuwuService 
{
    /**
     * 查询物业服务
     * 
     * @param id 物业服务ID
     * @return 物业服务
     */
    public Fuwu selectFuwuById(Long id);

    /**
     * 查询物业服务列表
     * 
     * @param fuwu 物业服务
     * @return 物业服务集合
     */
    public List<Fuwu> selectFuwuList(Fuwu fuwu);

    /**
     * 新增物业服务
     * 
     * @param fuwu 物业服务
     * @return 结果
     */
    public int insertFuwu(Fuwu fuwu);

    /**
     * 修改物业服务
     * 
     * @param fuwu 物业服务
     * @return 结果
     */
    public int updateFuwu(Fuwu fuwu);

    /**
     * 批量删除物业服务
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteFuwuByIds(String ids);

    /**
     * 删除物业服务信息
     * 
     * @param id 物业服务ID
     * @return 结果
     */
    public int deleteFuwuById(Long id);
}
