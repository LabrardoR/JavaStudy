package org.head.myword.model.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 关联表,将用户和词库建立联系
 * @TableName user_relate_word
 */
@TableName(value ="user_relate_word")
@Data
public class UserRelateWord implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Long userId;

    /**
     * 
     */
    private Long wordId;

    /**
     * 熟练度: 0-刚添加, 1-不认识, 2-认识, 3-基本熟悉, 4-熟悉, 5-完全掌握
     */
    private Integer level;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}