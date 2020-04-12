package com.ruoyi.taolun.controller;

import com.ruoyi.taolun.domain.Taolun;
import com.ruoyi.taolun.service.ITaolunService;
import java.util.Date;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.taolun.domain.TaoluUser;
import java.util.HashMap;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.taolun.service.ITaoluUserService;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 讨论相关Controller
 *
 * @author ruoyi
 * @date 2020-04-11
 */
@Controller
@RequestMapping("/taolun/taolun")
public class TaoluUserController extends BaseController {

  private String prefix = "taolun/taolun";

  @Autowired
  private ITaoluUserService taoluUserService;

  @Autowired
  private ITaolunService taolunService;

  @PostMapping("/{id}")
  @ResponseBody
  public Map list(@PathVariable("id") Long id, ModelMap mma) {

    int dianzannum = taoluUserService.SelectDianzanList(id);
    int shoucangnum = taoluUserService.SelectShoucangList(id);
    List<TaoluUser> pinglunList = taoluUserService.SelectPinglunList(id);
    Map map = new HashMap();

    map.put("dianzan", dianzannum);
    map.put("shoucang", shoucangnum);
    map.put("pinglun", pinglunList);

    return map;
  }

  //点赞
  @PostMapping("/dianzan/{id}")
  @ResponseBody
  public Map dianzan(@PathVariable("id") Long id, ModelMap mma) {
    Map map = new HashMap();
    SysUser sysUser = ShiroUtils.getSysUser();
    Long userId = sysUser.getUserId();
    TaoluUser taolu1 = new TaoluUser();
    taolu1.setTaolunId(id);
    taolu1.setDianzanUserId(userId);
    //查看是否已经点赞过
    List<TaoluUser> taoluUsers = taoluUserService.SelectIsDianzan(taolu1);
    if (taoluUsers.size() > 0) {

      map.put("state", false);
      return map;
    }
    //点赞+ 1
    Taolun taolun = taolunService.selectTaolunById(id);

    taolun.setDianzan(taolun.getDianzan()+1);
    taolunService.updateTaolun(taolun);
    map.put("state", true);
    TaoluUser taolu = new TaoluUser();
    taolu.setTaolunId(id);
    taolu.setDianzanUserId(userId);
    taoluUserService.insertTaoluUser(taolu);


    return map;
  }

  //收藏
  @PostMapping("/shoucang/{id}")
  @ResponseBody
  public Map shoucang(@PathVariable("id") Long id, ModelMap mma) {

    Map map = new HashMap();
    SysUser sysUser = ShiroUtils.getSysUser();
    Long userId = sysUser.getUserId();
    TaoluUser taolu1 = new TaoluUser();
    taolu1.setTaolunId(id);
    taolu1.setShoucangUserId(userId);
    //查看是否已经点收藏
    List<TaoluUser> taoluUsers = taoluUserService.SelectIsShoucang(taolu1);
    if (taoluUsers.size() > 0) {

      map.put("state", false);
      return map;
    }
    //收藏+ 1
    Taolun taolun = taolunService.selectTaolunById(id);

    taolun.setShoucang(taolun.getShoucang()+1);
    taolunService.updateTaolun(taolun);
    map.put("state", true);
    TaoluUser taolu = new TaoluUser();
    taolu.setTaolunId(id);
    taolu.setShoucangUserId(userId);
    taoluUserService.insertTaoluUser(taolu);


    return map;
  }

  //评论

  @PostMapping("/pinglun/{id}")
  @ResponseBody
  public Map pinglun(@RequestBody String content, @PathVariable("id") Long id, ModelMap mma) {
    System.out.println(content.replace("content=", ""));
    System.out.println(id);
    SysUser sysUser = ShiroUtils.getSysUser();
    TaoluUser taolu = new TaoluUser();
    taolu.setPinglunContent(content.replace("content=", ""));
    taolu.setPinglunUserId(sysUser.getUserId());
    taolu.setPinglunUserName(sysUser.getUserName());
    taolu.setCreateTime(new Date());
    taolu.setTaolunId(id);

    taoluUserService.insertTaoluUser(taolu);

    Map map = new HashMap();
    map.put("state", true);

    return map;
  }


}
