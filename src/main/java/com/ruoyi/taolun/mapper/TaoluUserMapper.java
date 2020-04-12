package com.ruoyi.taolun.mapper;

import java.util.List;
import com.ruoyi.taolun.domain.TaoluUser;

/**
 * 讨论相关Mapper接口
 *
 * @author ruoyi
 * @date 2020-04-11
 */
public interface TaoluUserMapper {

  /**
   * 查询讨论相关
   *
   * @param id 讨论相关ID
   * @return 讨论相关
   */
  public TaoluUser selectTaoluUserById(Long id);

  /**
   * 查询讨论相关列表
   *
   * @param taoluUser 讨论相关
   * @return 讨论相关集合
   */
  public List<TaoluUser> selectTaoluUserList(TaoluUser taoluUser);

  /**
   * 新增讨论相关
   *
   * @param taoluUser 讨论相关
   * @return 结果
   */
  public int insertTaoluUser(TaoluUser taoluUser);

  /**
   * 修改讨论相关
   *
   * @param taoluUser 讨论相关
   * @return 结果
   */
  public int updateTaoluUser(TaoluUser taoluUser);

  /**
   * 删除讨论相关
   *
   * @param id 讨论相关ID
   * @return 结果
   */
  public int deleteTaoluUserById(Long id);

  /**
   * 批量删除讨论相关
   *
   * @param ids 需要删除的数据ID
   * @return 结果
   */
  public int deleteTaoluUserByIds(String[] ids);

  public List<TaoluUser> SelectPinglunList(Long id);

  public int SelectDianzanList(Long id);

  public int SelectShoucangList(Long id);


  public List<TaoluUser> SelectIsDianzan(TaoluUser taoluUser);

  public List<TaoluUser> SelectIsShoucang(TaoluUser taoluUser);


}
