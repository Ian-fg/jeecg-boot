package org.jeecg.modules.ianfg.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.constant.CommonConstant;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.modules.ianfg.entity.ReportQueryEntity;
import org.jeecg.modules.ianfg.entity.SectionDataEntity;
import org.jeecg.modules.ianfg.entity.StudentEntity;
import org.jeecg.modules.ianfg.service.IReportService;
import org.jeecg.modules.ianfg.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Description:  报表类
 * @Author: ianfg
 * @Date:2019-11-19
 * @Version:V2.0
 */
@Slf4j
@Api(tags = "报表")
@RestController
@RequestMapping("/report")
public class ReportController  {

    @Autowired
    private IReportService reportService;

    @ApiOperation(value = "获取大额资金列表", notes = "获取大额资金列表")
    @GetMapping(value = "/sectionData")
    public Result<?> whMoney(@RequestParam(name="startDate",required=false) String startDate,@RequestParam(name="endDate",required=false) String endDate) {
        System.out.println("时间："+startDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ReportQueryEntity queryEntity = new ReportQueryEntity();
        if(startDate != null && endDate!= null) {
            try {
                queryEntity.setStartDate(sdf.parse(startDate));
                queryEntity.setEndDate(sdf.parse(endDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        List<SectionDataEntity> sectionDataList = reportService.getSectionData(queryEntity);

        Result<List<SectionDataEntity>> result = new Result<List<SectionDataEntity>>();
        result.setResult(sectionDataList);
        result.setSuccess(true);
        result.setCode(CommonConstant.SC_OK_200);
        return result;
    }




}
