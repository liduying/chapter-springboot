package com.lhy.chapter21.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhy.chapter21.entity.AlarmRecordHandleRelat;
import com.lhy.chapter21.service.AlarmRecordHandleRelatService;
import com.lhy.chapter21.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
    * 报警处置批量操作表 前端控制器
    * </p>
 *
 * @author test1
 * @since 2020-10-26
 */
@RestController
@RequestMapping("//alarmRecordHandleRelat")
public class AlarmRecordHandleRelatController {

     @Autowired
     private AlarmRecordHandleRelatService alarmRecordHandleRelatService;
     /**
     * 添加报警处置批量操作表
     *
     * @param alarmRecordHandleRelat 报警处置批量操作表
     * @return success、false
     */
    @PostMapping
    public R
            <Boolean> addAlarmRecordHandleRelat(@RequestBody AlarmRecordHandleRelat alarmRecordHandleRelat) {
        return new R<>(alarmRecordHandleRelatService.save(alarmRecordHandleRelat));
    }

    /**
     * 删除报警处置批量操作表，并且清除报警处置批量操作表
     *
     * @param id   ID
     * @param type 类型
     * @return R
     */
    @DeleteMapping("/{id}")
    public R
<Boolean> deleteAlarmRecordHandleRelat(@PathVariable String id) {
        return new R<>(alarmRecordHandleRelatService.removeById(id));
    }

    /**
     * 修改报警处置批量操作表
     *
     * @param alarmRecordHandleRelat 报警处置批量操作表
     * @return success/false
     */
    @PutMapping
    public R
<Boolean> editAlarmRecordHandleRelat(@RequestBody AlarmRecordHandleRelat alarmRecordHandleRelat) {
        return new R<>(alarmRecordHandleRelatService.updateById(alarmRecordHandleRelat));
    }

        /**
     * 通过ID查询报警处置批量操作表
     *
     * @param id ID
     * @return 报警处置批量操作表
     */
    @GetMapping("/{id}")
    public AlarmRecordHandleRelat alarmRecordHandleRelat(@PathVariable Integer id) {
        return alarmRecordHandleRelatService.getById(id);
    }

    /**
     * 分页查询报警处置批量操作表
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("/alarmRecordHandleRelatPage")
    public IPage alarmRecordHandleRelatPage(Page page, AlarmRecordHandleRelat alarmRecordHandleRelat) {
        return alarmRecordHandleRelatService.page(page, new QueryWrapper<>(alarmRecordHandleRelat));
    }
}
