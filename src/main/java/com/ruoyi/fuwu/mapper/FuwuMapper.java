package com.ruoyi.fuwu.mapper;

import java.util.List;
import com.ruoyi.fuwu.domain.Fuwu;

/**
 * 物业服务Mapper接口
 * 
 * @author ruoyi
 * @date 2020-04-12
 */
public interface FuwuMapper 
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
     * 删除物业服务
     * 
     * @param id 物业服务ID
     * @return 结果
     */
    public int deleteFuwuById(Long id);

    /**
     * 批量删除物业服务
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteFuwuByIds(String[] ids);
}
