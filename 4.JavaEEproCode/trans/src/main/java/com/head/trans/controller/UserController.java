package com.head.trans.controller;


import com.head.trans.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;
    @Autowired
    private TransactionDefinition transactionDefinition;

    @Autowired
    private UserService userService;

    @RequestMapping("/registry")
    public String registry(String userName, String password){
        // 开启事务
        TransactionStatus transaction = dataSourceTransactionManager.getTransaction(transactionDefinition);
        Integer result = userService.insertUser(userName, password);
        log.info("用户注册成功, result:" + result);
        // 回滚事务
        // dataSourceTransactionManager.rollback(transaction);

        // 提交事务
        dataSourceTransactionManager.commit(transaction);
        return "注册成功";
    }

}
