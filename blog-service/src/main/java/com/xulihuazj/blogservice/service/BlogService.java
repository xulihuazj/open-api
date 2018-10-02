package com.xulihuazj.blogservice.service;

import com.xulihuazj.blogservice.data.BlogDO;
import com.xulihuazj.common.reponse.ResponseDTO;

import java.util.List;

public interface BlogService {

    ResponseDTO findBlogDetail(Long id);

    BlogDO addNewBlog(BlogDO blog);

    List<BlogDO> findBlogs(String username);
}
