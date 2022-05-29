package com.lyn.eshop.common.util;

/**
 * @program: projects
 * @author: lyn
 * * @create: 2021-05-14 16:26
 **/
public class CloneDirection {

    /**
     * 正向克隆：从VO->DTO，DTO->DO
     */
    public static final Integer FORWARD = 1;
    /**
     * 反向克隆：从DO->DTO，DTO->VO
     */
    public static final Integer OPPOSITE = 2;

    private CloneDirection() {

    }

}
