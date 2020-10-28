package com.lhy.chapter21.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhy.chapter21.entity.TaskRecord;
import com.lhy.chapter21.service.TaskRecordService;
import com.lhy.chapter21.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
    * 任务记录表 前端控制器
    * </p>
 *
 * @author test
 * @since 2020-10-26
 */
@RestController
@RequestMapping("//taskRecord")
public class TaskRecordController {

     @Autowired
     private TaskRecordService taskRecordService;
     /**
     * 添加任务记录表
     *
     * @param taskRecord 任务记录表
     * @return success、false
     */
    @PostMapping
    public R
            <Boolean> addTaskRecord(@RequestBody TaskRecord taskRecord) {
        return new R<>(taskRecordService.save(taskRecord));
    }

    /**
     * 删除任务记录表，并且清除任务记录表
     *
     * @param id   ID
     * @param type 类型
     * @return R
     */
    @DeleteMapping("/{id}")
    public R
<Boolean> deleteTaskRecord(@PathVariable String id) {
        return new R<>(taskRecordService.removeById(id));
    }

    /**
     * 修改任务记录表
     *
     * @param taskRecord 任务记录表
     * @return success/false
     */
    @PutMapping
    public R
<Boolean> editTaskRecord(@RequestBody TaskRecord taskRecord) {
        return new R<>(taskRecordService.updateById(taskRecord));
    }

        /**
     * 通过ID查询任务记录表
     *
     * @param id ID
     * @return 任务记录表
     */
    @GetMapping("/{id}")
    public TaskRecord taskRecord(@PathVariable Integer id) {
        return taskRecordService.getById(id);
    }

    /**
     * 分页查询任务记录表
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("/taskRecordPage")
    public IPage taskRecordPage(Page page, TaskRecord taskRecord) {
        return taskRecordService.page(page, new QueryWrapper<>(taskRecord));
    }
}
