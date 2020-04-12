package com.ruoyi.taolun.controller;
import	java.util.HashMap;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.domain.SysUser;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.taolun.domain.Taolun;
import com.ruoyi.taolun.service.ITaolunService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 讨论Controller
 * 
 * @author ruoyi
 * @date 2020-04-11
 */
@Controller
@RequestMapping("/taolun/taolun")
public class TaolunController extends BaseController
{
    private String prefix = "taolun/taolun";

    @Autowired
    private ITaolunService taolunService;

    @RequiresPermissions("taolun:taolun:view")
    @GetMapping()
    public String taolun()
    {
        return prefix + "/taolun";
    }

    /**
     * 查询讨论列表
     */
    @RequiresPermissions("taolun:taolun:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Taolun taolun)
    {
        startPage();

        SysUser sysUser = ShiroUtils.getSysUser();
        List<SysRole> roles = sysUser.getRoles();
        for (SysRole role : roles) {
            if(!role.getRoleName().contains("管理")){
                taolun.setState("1");
                continue;
            }
        }

        List<Taolun> list = taolunService.selectTaolunList(taolun);
        return getDataTable(list);
    }

    /**
     * 导出讨论列表
     */
    @RequiresPermissions("taolun:taolun:export")
    @Log(title = "讨论", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Taolun taolun)
    {
        List<Taolun> list = taolunService.selectTaolunList(taolun);
        ExcelUtil<Taolun> util = new ExcelUtil<Taolun>(Taolun.class);
        return util.exportExcel(list, "taolun");
    }

    /**
     * 新增讨论
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存讨论
     */
    @RequiresPermissions("taolun:taolun:add")
    @Log(title = "讨论", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Taolun taolun)

    {
        taolun.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(taolunService.insertTaolun(taolun));
    }

    /**
     * 修改讨论
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Taolun taolun = taolunService.selectTaolunById(id);
        mmap.put("taolun", taolun);
        return prefix + "/edit";
    }

    /**
     * 修改保存讨论
     */
    @RequiresPermissions("taolun:taolun:edit")
    @Log(title = "讨论", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Taolun taolun)
    {
        return toAjax(taolunService.updateTaolun(taolun));
    }

    /**
     * 删除讨论
     */
    @RequiresPermissions("taolun:taolun:remove")
    @Log(title = "讨论", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(taolunService.deleteTaolunByIds(ids));
    }

    //查看帖子
    @RequiresPermissions("taolun:taolun:look")
    @GetMapping("/look/{id}")
    public String look(@PathVariable("id") Long id, ModelMap mmap)
    {
        Taolun taolun = taolunService.selectTaolunById(id);
        mmap.put("taolun", taolun);

        return prefix + "/look";
    }
    //审核
    @RequiresPermissions("taolun:taolun:shenhe")
    @PostMapping("/shenhe/{id}")
    @ResponseBody
    public Map shenhe(@PathVariable("id") Long id, ModelMap mmap)
    {
        Taolun taolun = taolunService.selectTaolunById(id);
        taolun.setState("1");
        taolunService.updateTaolun(taolun);
       // mmap.put("taolun", taolun);

        return (Map) new HashMap().put("state", true);
    }



}
