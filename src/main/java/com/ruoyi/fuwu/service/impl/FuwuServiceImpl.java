package com.ruoyi.fuwu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.fuwu.mapper.FuwuMapper;
import com.ruoyi.fuwu.domain.Fuwu;
import com.ruoyi.fuwu.service.IFuwuService;
import com.ruoyi.common.core.text.Convert;

/**
 * 物业服务Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-12
 */
@Service
public class FuwuServiceImpl implements IFuwuService 
{
    @Autowired
    private FuwuMapper fuwuMapper;

    /**
     * 查询物业服务
     * 
     * @param id 物业服务ID
     * @return 物业服务
     */
    @Override
    public Fuwu selectFuwuById(Long id)
    {
        return fuwuMapper.selectFuwuById(id);
    }

    /**
     * 查询物业服务列表
     * 
     * @param fuwu 物业服务
     * @return 物业服务
     */
    @Override
    public List<Fuwu> selectFuwuList(Fuwu fuwu)
    {
        return fuwuMapper.selectFuwuList(fuwu);
    }

    /**
     * 新增物业服务
     * 
     * @param fuwu 物业服务
     * @return 结果
     */
    @Override
    public int insertFuwu(Fuwu fuwu)
    {
        return fuwuMapper.insertFuwu(fuwu);
    }

    /**
     * 修改物业服务
     * 
     * @param fuwu 物业服务
     * @return 结果
     */
    @Override
    public int updateFuwu(Fuwu fuwu)
    {
        return fuwuMapper.updateFuwu(fuwu);
    }

    /**
     * 删除物业服务对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteFuwuByIds(String ids)
    {
        return fuwuMapper.deleteFuwuByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除物业服务信息
     * 
     * @param id 物业服务ID
     * @return 结果
     */
    @Override
    public int deleteFuwuById(Long id)
    {
        return fuwuMapper.deleteFuwuById(id);
    }
}
