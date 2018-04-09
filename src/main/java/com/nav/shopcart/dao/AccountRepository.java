package com.nav.shopcart.dao;

import com.nav.shopcart.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account,String>{

    public Account findByUserName(String userName);
}
