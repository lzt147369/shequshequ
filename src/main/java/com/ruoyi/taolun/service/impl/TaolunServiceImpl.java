package com.ruoyi.taolun.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.taolun.mapper.TaolunMapper;
import com.ruoyi.taolun.domain.Taolun;
import com.ruoyi.taolun.service.ITaolunService;
import com.ruoyi.common.core.text.Convert;

/**
 * 讨论Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-11
 */
@Service
public class TaolunServiceImpl implements ITaolunService 
{
    @Autowired
    private TaolunMapper taolunMapper;

    /**
     * 查询讨论
     * 
     * @param id 讨论ID
     * @return 讨论
     */
    @Override
    public Taolun selectTaolunById(Long id)
    {
        return taolunMapper.selectTaolunById(id);
    }

    /**
     * 查询讨论列表
     * 
     * @param taolun 讨论
     * @return 讨论
     */
    @Override
    public List<Taolun> selectTaolunList(Taolun taolun)
    {
        return taolunMapper.selectTaolunList(taolun);
    }

    /**
     * 新增讨论
     * 
     * @param taolun 讨论
     * @return 结果
     */
    @Override
    public int insertTaolun(Taolun taolun)
    {
        taolun.setCreateTime(DateUtils.getNowDate());
        return taolunMapper.insertTaolun(taolun);
    }

    /**
     * 修改讨论
     * 
     * @param taolun 讨论
     * @return 结果
     */
    @Override
    public int updateTaolun(Taolun taolun)
    {
        return taolunMapper.updateTaolun(taolun);
    }

    /**
     * 删除讨论对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTaolunByIds(String ids)
    {
        return taolunMapper.deleteTaolunByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除讨论信息
     * 
     * @param id 讨论ID
     * @return 结果
     */
    @Override
    public int deleteTaolunById(Long id)
    {
        return taolunMapper.deleteTaolunById(id);
    }
}
