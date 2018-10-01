package com.xulihuazj.blogservice.service;

import com.xulihuazj.common.reponse.ResponseDTO;

public interface BlogService {

    ResponseDTO findBlogDetail(Long id);
}
