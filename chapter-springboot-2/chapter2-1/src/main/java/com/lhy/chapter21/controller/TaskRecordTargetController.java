package com.lhy.chapter21.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhy.chapter21.entity.TaskRecordTarget;
import com.lhy.chapter21.service.TaskRecordTargetService;
import com.lhy.chapter21.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
    * 任务日志表 前端控制器
    * </p>
 *
 * @author test
 * @since 2020-10-26
 */
@RestController
@RequestMapping("//taskRecordTarget")
public class TaskRecordTargetController {

     @Autowired
     private TaskRecordTargetService taskRecordTargetService;
     /**
     * 添加任务日志表
     *
     * @param taskRecordTarget 任务日志表
     * @return success、false
     */
    @PostMapping
    public R
<Boolean> addTaskRecordTarget(@RequestBody TaskRecordTarget taskRecordTarget) {
        return new R<>(taskRecordTargetService.save(taskRecordTarget));
    }

    /**
     * 删除任务日志表，并且清除任务日志表
     *
     * @param id   ID
     * @param type 类型
     * @return R
     */
    @DeleteMapping("/{id}")
    public R
<Boolean> deleteTaskRecordTarget(@PathVariable String id) {
        return new R<>(taskRecordTargetService.removeById(id));
    }

    /**
     * 修改任务日志表
     *
     * @param taskRecordTarget 任务日志表
     * @return success/false
     */
    @PutMapping
    public R
<Boolean> editTaskRecordTarget(@RequestBody TaskRecordTarget taskRecordTarget) {
        return new R<>(taskRecordTargetService.updateById(taskRecordTarget));
    }

        /**
     * 通过ID查询任务日志表
     *
     * @param id ID
     * @return 任务日志表
     */
    @GetMapping("/{id}")
    public TaskRecordTarget taskRecordTarget(@PathVariable Integer id) {
        return taskRecordTargetService.getById(id);
    }

    /**
     * 分页查询任务日志表
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("/taskRecordTargetPage")
    public IPage taskRecordTargetPage(Page page, TaskRecordTarget taskRecordTarget) {
        return taskRecordTargetService.page(page, new QueryWrapper<>(taskRecordTarget));
    }
}
