package com.czh.geek.mapper;

import com.czh.geek.bean.OrderMasterBrief;

import java.util.List;

/**
 * @author Caizh
 * @date 2020/12/2
 */
public interface OrderMasterBriefMapper {

    void batchInsert(List<OrderMasterBrief> list);

}
