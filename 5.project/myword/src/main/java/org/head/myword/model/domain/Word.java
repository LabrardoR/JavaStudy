package org.head.myword.model.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName word
 */
@TableName(value ="word")
@Data
public class Word implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long wordId;

    /**
     * 单词拼写
     */
    private String spell;

    /**
     * 所属词库4(CET4), 6(CET6)
     */
    private String library;

    /**
     * 基础释义
     */
    private String explanation;

    /**
     * 联想
     */
    private String association;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}