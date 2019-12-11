package org.jeecg.modules.ianfg.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jeecgframework.poi.excel.annotation.Excel;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description: student Entity
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="付款区间对象", description="付款区间对象")
public class SectionDataEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 付款区间 */
	@ApiModelProperty(value = "付款区间")
	@Excel(name="付款区间",width=25)
	private String section;

	/** 支付笔数 */
	@ApiModelProperty(value = "支付笔数")
	@Excel(name="支付笔数",width=25)
	private int count;

	/** 累计金额 */
	@ApiModelProperty(value = "累计金额")
	@Excel(name="累计金额",width=25)
	private BigDecimal totalmoney;

}
