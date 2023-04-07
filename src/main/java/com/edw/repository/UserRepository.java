package com.edw.repository;

import com.edw.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 *     com.edw.repository.UserRepository
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 07 Apr 2023 16:07
 */
public interface UserRepository extends JpaRepository<User, String> {

    public User findByUsername(String username);

}
