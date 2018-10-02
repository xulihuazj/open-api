package com.xulihuazj.blogservice.dto;

import com.xulihuazj.blogservice.data.BlogDO;
import com.xulihuazj.blogservice.data.UserDO;
import com.xulihuazj.common.utils.ToString;

public class BlogDetailDTO extends ToString {

    private static final long serialVersionUID = -7029942870941213635L;

    private BlogDO blog;

    private UserDO user;

    public BlogDO getBlog() {
        return blog;
    }

    public void setBlog(BlogDO blog) {
        this.blog = blog;
    }

    public UserDO getUser() {
        return user;
    }

    public void setUser(UserDO user) {
        this.user = user;
    }
}
