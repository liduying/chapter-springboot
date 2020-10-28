package com.lhy.chapter21.controller;

import com.lhy.chapter21.entity.AlarmRecordHandle;
import com.lhy.chapter21.service.AlarmRecordHandleService;
import com.lhy.chapter21.util.R;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * <p>
    *  前端控制器
    * </p>
 *
 * @author test1
 * @since 2020-10-26
 */
@RestController
@RequestMapping("//alarmRecordHandle")
public class AlarmRecordHandleController {

     @Autowired
     private AlarmRecordHandleService alarmRecordHandleService;
     /**
     * 添加
     *
     * @param alarmRecordHandle 
     * @return success、false
     */
    @PostMapping
    public R
            <Boolean> addAlarmRecordHandle(@RequestBody AlarmRecordHandle alarmRecordHandle) {
        return new R<>(alarmRecordHandleService.save(alarmRecordHandle));
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
<Boolean> deleteAlarmRecordHandle(@PathVariable String id) {
        return new R<>(alarmRecordHandleService.removeById(id));
    }

    /**
     * 修改
     *
     * @param alarmRecordHandle 
     * @return success/false
     */
    @PutMapping
    public R
<Boolean> editAlarmRecordHandle(@RequestBody AlarmRecordHandle alarmRecordHandle) {
        return new R<>(alarmRecordHandleService.updateById(alarmRecordHandle));
    }

        /**
     * 通过ID查询
     *
     * @param id ID
     * @return 
     */
    @GetMapping("/{id}")
    public AlarmRecordHandle alarmRecordHandle(@PathVariable Integer id) {
        return alarmRecordHandleService.getById(id);
    }

    /**
     * 分页查询
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("/alarmRecordHandlePage")
    public IPage alarmRecordHandlePage(Page page,AlarmRecordHandle alarmRecordHandle) {
        return alarmRecordHandleService.page(page, new QueryWrapper<>(alarmRecordHandle));
    }
}
