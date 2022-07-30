package com.xxxxxchen.table01;

import com.xxxxxchen.bean.Card;

import java.util.List;

/**
 * @author KevinWilliams
 */
public interface OneToOneMapper {

    /**查询全部*/
    public abstract List<Card> selectAll();
}
