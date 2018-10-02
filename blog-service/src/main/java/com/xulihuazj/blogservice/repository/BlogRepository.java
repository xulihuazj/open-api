package com.xulihuazj.blogservice.repository;

import com.xulihuazj.blogservice.data.BlogDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<BlogDO,Long> {

    /**
     * 根据用户信息查找博客
     * @param username
     * @return
     */
    List<BlogDO> findByUsername(String username);

}
