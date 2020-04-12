package com.ruoyi.fuwu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.StringUtils;
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
import com.ruoyi.fuwu.domain.Fuwu;
import com.ruoyi.fuwu.service.IFuwuService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import sun.util.locale.provider.FallbackLocaleProviderAdapter;

/**
 * 物业服务Controller
 *
 * @author ruoyi
 * @date 2020-04-12
 */
@Controller
@RequestMapping("/fuwu/fuwu")
public class FuwuController extends BaseController {
    private String prefix = "fuwu/fuwu";

    @Autowired
    private IFuwuService fuwuService;

    @RequiresPermissions("fuwu:fuwu:view")
    @GetMapping()
    public String fuwu() {
        return prefix + "/fuwu";
    }

    /**
     * 查询物业服务列表
     */
    @RequiresPermissions("fuwu:fuwu:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Fuwu fuwu) {
        startPage();
        List<Fuwu> list = fuwuService.selectFuwuList(fuwu);
        return getDataTable(list);
    }

    /**
     * 导出物业服务列表
     */
    @RequiresPermissions("fuwu:fuwu:export")
    @Log(title = "物业服务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Fuwu fuwu) {
        List<Fuwu> list = fuwuService.selectFuwuList(fuwu);
        ExcelUtil<Fuwu> util = new ExcelUtil<Fuwu>(Fuwu.class);
        return util.exportExcel(list, "fuwu");
    }

    /**
     * 新增物业服务
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存物业服务
     */
    @RequiresPermissions("fuwu:fuwu:add")
    @Log(title = "物业服务", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Fuwu fuwu) {
        return toAjax(fuwuService.insertFuwu(fuwu));
    }

    /**
     * 修改物业服务
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        Fuwu fuwu = fuwuService.selectFuwuById(id);
        mmap.put("fuwu", fuwu);
        return prefix + "/edit";
    }

    /**
     * 修改保存物业服务
     */
    @RequiresPermissions("fuwu:fuwu:edit")
    @Log(title = "物业服务", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Fuwu fuwu) {
        return toAjax(fuwuService.updateFuwu(fuwu));
    }

    /**
     * 删除物业服务
     */
    @RequiresPermissions("fuwu:fuwu:remove")
    @Log(title = "物业服务", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(fuwuService.deleteFuwuByIds(ids));
    }


    //审核

    @PostMapping("/shenhe/{id}/{feiyong}")
    @ResponseBody
    public Map shenhe(@PathVariable("id") Long id, @PathVariable("feiyong") Long feiyong, ModelMap mmap) {
        Map map = new HashMap();
        Fuwu fuwu1 = fuwuService.selectFuwuById(id);
        if (fuwu1.getShenheState().equals("1")) {
            map.put("state", false);
            return map;
        }
        Fuwu fuwu = new Fuwu();
        fuwu.setId(id);
        fuwu.setFeiyong(feiyong);
        fuwu.setShenheState("1");
        fuwuService.updateFuwu(fuwu);

        map.put("state", true);
        return map;
    }

    @PostMapping("/jiaofei/{id}")
    @ResponseBody
    public Map jiaofei(@PathVariable("id") Long id, ModelMap mmap) {
        Map map = new HashMap();
        Fuwu fuwu1 = fuwuService.selectFuwuById(id);
        if (fuwu1.getJiaofeiState().equals("1")) {
            map.put("state", false);
            return map;

        }

        Fuwu fuwu = new Fuwu();
        fuwu.setId(id);
        fuwu.setJiaofeiState("1");
        fuwuService.updateFuwu(fuwu);

        map.put("state", true);
        return map;
    }

    @PostMapping("/pinglun/{id}/{pinglun}")
    @ResponseBody
    public Map pinglun(@PathVariable("id") Long id, @PathVariable("pinglun") String pinglun, ModelMap mmap) {
        Map map = new HashMap();
        Fuwu fuwu1 = fuwuService.selectFuwuById(id);
        if (!StringUtils.isEmpty(fuwu1.getPinglun())) {

            map.put("state", false);
            return map;
        }

        Fuwu fuwu = new Fuwu();
        fuwu.setId(id);
        fuwu.setPinglun(pinglun);
        fuwuService.updateFuwu(fuwu);

        map.put("state", true);
        return map;
    }
    @PostMapping("/dafen/{id}/{dafen}")
    @ResponseBody
    public Map dafen(@PathVariable("id") Long id, @PathVariable("dafen") long dafen, ModelMap mmap) {
        Map map = new HashMap();
        Fuwu fuwu1 = fuwuService.selectFuwuById(id);
        if (fuwu1.getXingji()!=null) {
            map.put("state", false);
            return map;
        }

        Fuwu fuwu = new Fuwu();
        fuwu.setId(id);
        fuwu.setXingji(dafen);
        fuwuService.updateFuwu(fuwu);

        map.put("state", true);
        return map;
    }
}
