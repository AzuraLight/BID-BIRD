package com.project.model.dao;

import java.util.List;

import com.project.model.dto.BidProductDTO;

public interface BidSellMapper {

	List<BidProductDTO> sellProductAllSelect();

	int insertProduct(BidProductDTO product);

	int updateProduct(BidProductDTO product);

	int deleteProduct(String pId);
	
	
	
	
}
