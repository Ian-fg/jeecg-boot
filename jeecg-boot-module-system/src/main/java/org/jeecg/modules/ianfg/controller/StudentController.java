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
import org.jeecg.modules.ianfg.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description:  学生类
 * @Author: ianfg
 * @Date:2019-11-19
 * @Version:V2.0
 */
@Slf4j
@Api(tags = "学生")
@RestController
@RequestMapping("/student")
public class StudentController  extends JeecgController<StudentEntity, IStudentService> {

    @Autowired
    private IStudentService studentService;

    @ApiOperation(value = "获取student数据列表", notes = "获取所有student数据列表")
    @GetMapping(value = "/list")
//    @PermissionData(pageComponent = "jeecg/JeecgDemoList")
    public Result<?> list(StudentEntity studentEntity, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                          HttpServletRequest req) {
        QueryWrapper<StudentEntity> queryWrapper = QueryGenerator.initQueryWrapper(studentEntity, req.getParameterMap());
        Page<StudentEntity> page = new Page<StudentEntity>(pageNo, pageSize);

        IPage<StudentEntity> pageList = studentService.page(page, queryWrapper);
        log.info("查询当前页：" + pageList.getCurrent());;
        log.info("查询当前页数量：" + pageList.getSize());
        log.info("查询结果数量：" + pageList.getRecords().size());
        log.info("数据总数：" + pageList.getTotal());
        return Result.ok(pageList);
    }


    /**
     * 添加
     *
     */
    @PostMapping(value = "/add")
    @AutoLog(value = "添加学生")
    @ApiOperation(value = "添加学生", notes = "添加学生")
    public Result<?> add(@RequestBody StudentEntity studentEntity) {
        studentService.save(studentEntity);
        return Result.ok("添加成功！");
    }


    /**
     * 编辑
     *
     */
    @PutMapping(value = "/edit")
    @ApiOperation(value = "编辑学生", notes = "编辑学生")
    @AutoLog(value = "编辑学生", operateType = CommonConstant.OPERATE_TYPE_3)
    public Result<?> edit(@RequestBody StudentEntity studentEntity) {
        studentService.updateById(studentEntity);
        return Result.ok("更新成功！");
    }

    /**
     * 通过id删除
     *
     */
    @AutoLog(value = "删除学生")
    @DeleteMapping(value = "/delete")
    @ApiOperation(value = "通过ID删除学生", notes = "通过ID删除学生")
    public Result<?> delete(@RequestParam(name = "id", required = true) String id) {
        studentService.removeById(id);
        return Result.ok("删除成功!");
    }



    /**
     * 导出excel
     *
     * @param request
     **/
    @RequestMapping(value = "/exportXls")
    @ApiOperation(value = "导出学生", notes = "导出学生")
//    @PermissionData(pageComponent = "jeecg/JeecgDemoList")
    public ModelAndView exportXls(HttpServletRequest request, StudentEntity studentEntity) {
        return super.exportXls(request, studentEntity, StudentEntity.class, "学生");
    }


    /**
     * 通过excel导入数据
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    @ApiOperation(value = "导入学生", notes = "导入学生")
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, StudentEntity.class);
    }


}
