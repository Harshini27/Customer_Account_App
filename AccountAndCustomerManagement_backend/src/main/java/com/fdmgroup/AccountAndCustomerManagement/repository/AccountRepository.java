package com.fdmgroup.AccountAndCustomerManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fdmgroup.AccountAndCustomerManagement.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

	@Query("SELECT acc from Account acc "+
			"join acc.customer c " +
			"join c.address add "+
			"where add.city = :city")
	List<Account> findAccountIdsByCustomerCity(@Param("city") String city);
	

}
