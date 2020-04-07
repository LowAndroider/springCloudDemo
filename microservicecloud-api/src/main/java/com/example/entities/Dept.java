package com.example.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@ApiModel("部门信息")
public class Dept implements Serializable {

    /** 主键 */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("部门id")
    private Long deptNo;

    /** 部门名称 */
    @ApiModelProperty("部门名称")
    private String deptName;

    /** 来自哪个数据库 */
    @ApiModelProperty("数据库名")
    private String dbSource;
}
