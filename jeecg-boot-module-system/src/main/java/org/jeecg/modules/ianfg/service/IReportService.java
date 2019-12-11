package org.jeecg.modules.ianfg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.ianfg.entity.ReportQueryEntity;
import org.jeecg.modules.ianfg.entity.SectionDataEntity;
import org.jeecg.modules.ianfg.entity.StudentEntity;

import java.util.List;


/**
 * 报表类接口
 */
public interface IReportService  {

    //获取年度区间分布数据
     public List<SectionDataEntity> getSectionData(ReportQueryEntity queryEntity);

}
