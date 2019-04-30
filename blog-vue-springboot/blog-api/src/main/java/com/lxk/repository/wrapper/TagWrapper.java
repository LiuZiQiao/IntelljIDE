package com.lxk.repository.wrapper;

import java.util.List;

import com.lxk.vo.TagVO;

/**
 * @author lxk
 * <p>
 * 2018年1月25日
 */
public interface TagWrapper {

    List<TagVO> findAllDetail();

    TagVO getTagDetail(Integer tagId);
}
