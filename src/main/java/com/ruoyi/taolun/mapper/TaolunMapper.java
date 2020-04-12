package com.ruoyi.taolun.mapper;

import java.util.List;
import com.ruoyi.taolun.domain.Taolun;

/**
 * 讨论Mapper接口
 * 
 * @author ruoyi
 * @date 2020-04-11
 */
public interface TaolunMapper 
{
    /**
     * 查询讨论
     * 
     * @param id 讨论ID
     * @return 讨论
     */
    public Taolun selectTaolunById(Long id);

    /**
     * 查询讨论列表
     * 
     * @param taolun 讨论
     * @return 讨论集合
     */
    public List<Taolun> selectTaolunList(Taolun taolun);

    /**
     * 新增讨论
     * 
     * @param taolun 讨论
     * @return 结果
     */
    public int insertTaolun(Taolun taolun);

    /**
     * 修改讨论
     * 
     * @param taolun 讨论
     * @return 结果
     */
    public int updateTaolun(Taolun taolun);

    /**
     * 删除讨论
     * 
     * @param id 讨论ID
     * @return 结果
     */
    public int deleteTaolunById(Long id);

    /**
     * 批量删除讨论
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTaolunByIds(String[] ids);
}
