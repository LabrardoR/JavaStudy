package org.head.myword.model.request;

import lombok.Data;

/**
 * 用户需要背的单词的返回信息
 */
@Data
public class UserWordRequest {

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
}
