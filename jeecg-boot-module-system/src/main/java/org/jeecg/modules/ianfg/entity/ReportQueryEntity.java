package org.jeecg.modules.ianfg.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * @Description: 报表查询Entity
 *
 */
@Data
public class ReportQueryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 起始日期 */
	@ApiModelProperty(value = "起始日期")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private java.util.Date startDate;


	/** 结束日期 */
	@ApiModelProperty(value = "结束日期")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private java.util.Date endDate;

}
