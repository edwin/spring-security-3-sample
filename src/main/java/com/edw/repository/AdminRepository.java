package com.edw.repository;

import com.edw.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 *     com.edw.repository.AdminRepository
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 07 Apr 2023 16:17
 */
public interface AdminRepository extends JpaRepository<Admin, String> {
    public Admin findByUsername(String username);
}