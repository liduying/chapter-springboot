package com.lhy.chapter21.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhy.chapter21.entity.AppInfo;
import com.lhy.chapter21.mapper.AppInfoMapper;
import com.lhy.chapter21.service.AppInfoService;
import org.springframework.stereotype.Service;

/**
 * @program: chapter-springboot
 * @description:
 * @author: lihy
 * @create: 2020-10-11 16:50
 **/
@Service
public class AppInfoServiceImpl extends ServiceImpl<AppInfoMapper, AppInfo> implements AppInfoService {
}
