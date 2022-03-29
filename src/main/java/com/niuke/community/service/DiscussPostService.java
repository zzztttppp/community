package com.niuke.community.service;

import com.niuke.community.dao.DiscussPostMapper;
import com.niuke.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DiscussPostService {
    @Autowired
    private  DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findDiscussPosts( int userId, int offset, int limit, int orderMode){
        return discussPostMapper.selectDiscussPosts( userId,  offset,  limit,  orderMode);
    }

    public int findDiscussPostRows(int userId){
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}
