package com.xmut.hotel.mapper;

import com.xmut.hotel.entity.Apply;

public interface ApplyMapper {
    int deleteByPrimaryKey(String applyId);

    int insert(Apply record);

    int insertSelective(Apply record);

    Apply selectByPrimaryKey(String applyId);

    int updateByPrimaryKeySelective(Apply record);

    int updateByPrimaryKey(Apply record);
}