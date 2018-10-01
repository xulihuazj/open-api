package com.xulihuazj.blogservice.api;

import com.xulihuazj.blogservice.service.BlogService;
import com.xulihuazj.common.reponse.ResponseDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;


    @ApiOperation()
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/{id}/detail")
    public ResponseDTO getBlogDetail(@PathVariable Long id) {
        return ResponseDTO.onSuccess(this.blogService.findBlogDetail(id));
    }

}
