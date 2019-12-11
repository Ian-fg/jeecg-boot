package org.jeecg.modules.ianfg.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jeecg.common.aspect.annotation.Dict;
import org.jeecg.common.system.base.entity.JeecgEntity;
import org.jeecgframework.poi.excel.annotation.Excel;

import java.io.Serializable;

/**
 * @Description: student Entity
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="student 对象", description="student 对象")
@TableName("STUDENT")
public class StudentEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	/**主键*/
	@TableId(type = IdType.UUID)
	private String id;
	/** 姓名 */
	@ApiModelProperty(value = "姓名")
	@Excel(name="姓名",width=25)
	private String name;
	/** 年龄 */
	@Excel(name="年龄",width=25)
	@ApiModelProperty(value = "年龄")
	private String age;

	/** 性别 */
	@Excel(name="性别",width=25, dicCode = "sex")
	@ApiModelProperty(value = "性别")
	@Dict(dicCode = "sex")
	private String sex;
	/** 邮箱 */
	@Excel(name="邮箱",width=25)
	@ApiModelProperty(value = "邮箱")
	private String email;
	/** 个人简介 */
	@Excel(name="个人简介",width=35)
	@ApiModelProperty(value = "个人简介")
	private String content;
}
