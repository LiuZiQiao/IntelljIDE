package com.lxk.repository.wrapper;

import java.util.List;

import com.lxk.vo.CategoryVO;

/**
 * @author lxk
 * <p>
 * 2018年1月25日
 */
public interface CategoryWrapper {

    List<CategoryVO> findAllDetail();

    CategoryVO getCategoryDetail(Integer categoryId);
}
