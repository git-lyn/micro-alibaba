package com.tuling.seata.service;


import java.math.BigDecimal;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lihaodong
 * @since 2019-11-25
 */
public interface IAccountService  {

    /**
     * 扣减账户余额
     * @param userId
     * @param balance
     * @return
     */
    boolean reduceBalance(Integer userId, BigDecimal balance) throws Exception;
}
