package com.xmut.hotel.mapper;

import com.xmut.hotel.entity.Apply;

import java.util.List;

public interface ApplyMapper {
    int deleteByPrimaryKey(String applyId);

    int insert(Apply record);

    int insertSelective(Apply record);

    Apply selectByPrimaryKey(String applyId);

    int updateByPrimaryKeySelective(Apply record);

    int updateByPrimaryKey(Apply record);

    //获取所有的申请表通过Pass
    List<Apply> selectApplyByPass(Integer pass);

    int updateApplyPassById(Apply apply);
}