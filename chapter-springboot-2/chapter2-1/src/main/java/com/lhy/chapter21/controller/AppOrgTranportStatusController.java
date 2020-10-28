package com.lhy.chapter21.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhy.chapter21.entity.AppOrgTranportStatus;
import com.lhy.chapter21.service.AppOrgTranportStatusService;
import com.lhy.chapter21.util.R;
import com.lhy.chapter21.vo.AppOrgTransportTableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
    *  前端控制器
    * </p>
 *
 * @author test
 * @since 2020-10-26
 */
@RestController
@RequestMapping("//appOrgTranportStatus")
public class AppOrgTranportStatusController {

     @Autowired
     private AppOrgTranportStatusService appOrgTranportStatusService;
     /**
     * 添加
     *
     * @param appOrgTranportStatus 
     * @return success、false
     */
    @PostMapping
    public R
<Boolean> addAppOrgTranportStatus(@RequestBody AppOrgTranportStatus appOrgTranportStatus) {
        return new R<>(appOrgTranportStatusService.save(appOrgTranportStatus));
    }

    /**
     * 删除，并且清除
     *
     * @param id   ID
     * @param type 类型
     * @return R
     */
    @DeleteMapping("/{id}")
    public R
<Boolean> deleteAppOrgTranportStatus(@PathVariable String id) {
        return new R<>(appOrgTranportStatusService.removeById(id));
    }

    /**
     * 修改
     *
     * @param appOrgTranportStatus 
     * @return success/false
     */
    @PutMapping
    public R
<Boolean> editAppOrgTranportStatus(@RequestBody AppOrgTranportStatus appOrgTranportStatus) {
        return new R<>(appOrgTranportStatusService.updateById(appOrgTranportStatus));
    }

        /**
     * 通过ID查询
     *
     * @param id ID
     * @return 
     */
    @GetMapping("/{id}")
    public AppOrgTranportStatus appOrgTranportStatus(@PathVariable Integer id) {
        return appOrgTranportStatusService.getById(id);
    }

    /**
     * 分页查询
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("/appOrgTranportStatusPage")
    public IPage appOrgTranportStatusPage(Page page, AppOrgTranportStatus appOrgTranportStatus) {
        return appOrgTranportStatusService.page(page, new QueryWrapper<>(appOrgTranportStatus));
    }
    /**
     * 查询当前单位的在线率的异常次数及异常时长
     *
     * @return
     */
    @GetMapping("/getAppOrgTransportTableInfo")
    public R<IPage<AppOrgTransportTableVO>> getAppOrgTransportTableInfo(Page page, String startDate,String endDate) {
        return new R<>(appOrgTranportStatusService.getAppOrgTransportTableInfo(page,startDate,endDate));
    }
}
