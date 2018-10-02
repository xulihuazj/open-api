package com.xulihuazj.blogservice.api;

import com.xulihuazj.blogservice.data.BlogDO;
import com.xulihuazj.blogservice.service.BlogService;
import com.xulihuazj.blogservice.util.UserUtils;
import com.xulihuazj.common.annotation.SysLogger;
import com.xulihuazj.common.error.BizErrorCode;
import com.xulihuazj.common.exception.BusinessException;
import com.xulihuazj.common.reponse.ResponseDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @ApiOperation(value = "发布博客", notes = "发布博客")
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/add")
    @SysLogger("postBlog")
    public ResponseDTO postBlog(@RequestBody BlogDO blog) {
        BlogDO resultBlog = this.blogService.addNewBlog(blog);
        return ResponseDTO.onSuccess(resultBlog);
    }

    @ApiOperation(value = "获取博客的详细信息", notes = "获取博客的详细信息")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/{id}/detail")
    public ResponseDTO getBlogDetail(@PathVariable Long id) {
        return ResponseDTO.onSuccess(this.blogService.findBlogDetail(id));
    }

    @ApiOperation(value = "获取某个用户所有博客", notes = "获取某个用户所有博客")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/{username}")
    @SysLogger("getBlogs")
    public ResponseDTO getAllBlogs(@PathVariable String username) {
        if (UserUtils.isMyself(username)) {
            List<BlogDO> blogs = this.blogService.findBlogs(username);
            return ResponseDTO.onSuccess(blogs);
        } else {
            throw new BusinessException(BizErrorCode.TOKEN_IS_NOT_MATCH_USER);
        }
    }


}
