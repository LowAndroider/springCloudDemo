package com.example.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable {

    /** 主键 */
    @TableId(type = IdType.AUTO)
    private Long deptNo;

    /** 部门名称 */
    private String dName;

    /** 来自哪个数据库 */
    private String dbSource;
}
