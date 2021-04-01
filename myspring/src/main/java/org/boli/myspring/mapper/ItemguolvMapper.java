package org.boli.myspring.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.boli.myspring.entity.Itemguolv;
import org.boli.myspring.entity.ItemguolvExample;

public interface ItemguolvMapper {
	long countByExample(ItemguolvExample example);

	int deleteByExample(ItemguolvExample example);

	int insert(Itemguolv record);

	int insertSelective(Itemguolv record);

	List<Itemguolv> selectByExample(ItemguolvExample example);

	int updateByExampleSelective(@Param("record") Itemguolv record, @Param("example") ItemguolvExample example);

	int updateByExample(@Param("record") Itemguolv record, @Param("example") ItemguolvExample example);
}
