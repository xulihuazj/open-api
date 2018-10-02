package com.xulihuazj.blogservice.service.impl;

import com.xulihuazj.blogservice.data.BlogDO;
import com.xulihuazj.blogservice.repository.BlogRepository;
import com.xulihuazj.blogservice.service.BlogService;
import com.xulihuazj.common.reponse.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public ResponseDTO findBlogDetail(Long id) {
        return null;
    }

    @Override
    public BlogDO addNewBlog(BlogDO blog) {
        return blogRepository.save(blog);
    }

    @Override
    public List<BlogDO> findBlogs(String username) {
        return blogRepository.findByUsername(username);
    }
}
