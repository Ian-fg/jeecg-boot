package org.jeecg.modules.ianfg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeecg.modules.ianfg.entity.ReportQueryEntity;
import org.jeecg.modules.ianfg.entity.SectionDataEntity;
import org.jeecg.modules.ianfg.entity.StudentEntity;
import org.jeecg.modules.ianfg.mapper.StudentMapper;
import org.jeecg.modules.ianfg.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, StudentEntity> implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

}
