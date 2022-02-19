package com.tuling.seata.mapper;


import com.tuling.seata.domin.Account;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * Created by smlz on 2019/12/9.
 */
public interface AccountMapper {

    /**
     * 扣减账户余额
     * @param userId
     * @param balance
     * @return
     */
    Integer reduceBalance(@Param("userId") Integer userId, @Param("balance") BigDecimal balance);

    Account selectByUserId(@Param("userId") Integer userId);
}
