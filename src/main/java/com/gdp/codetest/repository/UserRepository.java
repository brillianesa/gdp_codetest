package com.gdp.codetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gdp.codetest.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT user_id FROM tb_m_user WHERE phoneNumber=?1", nativeQuery = true)
    public Integer findIdByPhoneNumber(String phoneNumber);
}
