package com.lyj.sms.constans;

import java.util.HashMap;
import java.util.Map;

/**
 * 常量类.
 * Created by lunyujie on 2017/3/23.
 */
public enum Constants {
    /**
     * 等级 1 不合格 2 合格 3 良好 4 优秀.
     */
    LEVEL_UNQUALIFIED(1),
    /**
     * 等级 1 不合格 2 合格 3 良好 4 优秀.
     */
    LEVEL_QUALIFIED(2),
    /**
     * 等级 1 不合格 2 合格 3 良好 4 优秀.
     */
    LEVEL_GOOD(3),
    /**
     * 等级 1 不合格 2 合格 3 良好 4 优秀.
     */
    LEVEL_BEST(4),
    /**
     * 个人状态 0 禁用 1 启用.
     */
    STATUS_DISABLE(0),
    /**
     * 个人状态 0 禁用 1 启用.
     */
    STATUS_ENABLE(1),
    /**
     * 角色 1 管理员 2 普通.
     */
    ROLE_CODE_ADMIN(1),
    /**
     * 角色 1 管理员 2 普通.
     */
    ROLE_CODE_NORMAL(2);
    /**
     * int 值.
     */
    private int value;

    /**
     * int 构造函数.
     *
     * @param v int 值
     */
    Constants(int v) {
        this.value = v;
    }

    /**
     * 得到 int 值.
     *
     * @return int 值
     */
    public int getValue() {
        return value;
    }

    /**
     * 组织等级.
     *
     * @return 等级map
     */
    public static Map<Integer, String> getMapLevels() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(LEVEL_UNQUALIFIED.value, "不合格");
        map.put(LEVEL_QUALIFIED.value, "合格");
        map.put(LEVEL_GOOD.value, "良好");
        map.put(LEVEL_BEST.value, "优秀");
        return map;
    }
}
