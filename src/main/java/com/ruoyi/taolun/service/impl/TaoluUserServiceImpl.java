package com.ruoyi.taolun.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.taolun.mapper.TaoluUserMapper;
import com.ruoyi.taolun.domain.TaoluUser;
import com.ruoyi.taolun.service.ITaoluUserService;
import com.ruoyi.common.core.text.Convert;

/**
 * 讨论相关Service业务层处理
 *
 * @author ruoyi
 * @date 2020-04-11
 */
@Service
public class TaoluUserServiceImpl implements ITaoluUserService {

  @Autowired
  private TaoluUserMapper taoluUserMapper;

  /**
   * 查询讨论相关
   *
   * @param id 讨论相关ID
   * @return 讨论相关
   */
  @Override
  public TaoluUser selectTaoluUserById(Long id) {
    return taoluUserMapper.selectTaoluUserById(id);
  }

  /**
   * 查询讨论相关列表
   *
   * @param taoluUser 讨论相关
   * @return 讨论相关
   */
  @Override
  public List<TaoluUser> selectTaoluUserList(TaoluUser taoluUser) {
    return taoluUserMapper.selectTaoluUserList(taoluUser);
  }

  /**
   * 新增讨论相关
   *
   * @param taoluUser 讨论相关
   * @return 结果
   */
  @Override
  public int insertTaoluUser(TaoluUser taoluUser) {
    // taoluUser.setCreateTime(DateUtils.getNowDate());
    return taoluUserMapper.insertTaoluUser(taoluUser);
  }

  /**
   * 修改讨论相关
   *
   * @param taoluUser 讨论相关
   * @return 结果
   */
  @Override
  public int updateTaoluUser(TaoluUser taoluUser) {
    return taoluUserMapper.updateTaoluUser(taoluUser);
  }

  /**
   * 删除讨论相关对象
   *
   * @param ids 需要删除的数据ID
   * @return 结果
   */
  @Override
  public int deleteTaoluUserByIds(String ids) {
    return taoluUserMapper.deleteTaoluUserByIds(Convert.toStrArray(ids));
  }

  /**
   * 删除讨论相关信息
   *
   * @param id 讨论相关ID
   * @return 结果
   */
  @Override
  public int deleteTaoluUserById(Long id) {
    return taoluUserMapper.deleteTaoluUserById(id);
  }

  @Override
  public List<TaoluUser> SelectPinglunList(Long id) {
    return taoluUserMapper.SelectPinglunList(id);
  }

  @Override
  public int SelectDianzanList(Long id) {
    return taoluUserMapper.SelectDianzanList(id);
  }

  @Override
  public int SelectShoucangList(Long id) {
    return taoluUserMapper.SelectShoucangList(id);
  }

  @Override
  public List<TaoluUser> SelectIsDianzan(TaoluUser taoluUser) {
    return taoluUserMapper.SelectIsDianzan(taoluUser);
  }

  @Override
  public List<TaoluUser> SelectIsShoucang(TaoluUser taoluUser) {
    return taoluUserMapper.SelectIsShoucang(taoluUser);
  }
}
