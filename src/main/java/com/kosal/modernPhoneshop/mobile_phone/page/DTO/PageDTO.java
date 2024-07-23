package com.kosal.modernPhoneshop.mobile_phone.page.DTO;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data
public class PageDTO {
	private List<?>lists;
	private  PaginationDTO paginationDTO;
	
	public PageDTO(Page<?>page) {
		this.lists=page.getContent();
		this.paginationDTO=PaginationDTO
		.builder()
		.empty(page.isEmpty())
		.first(page.isFirst())
		.last(page.isLast())
		.pageSize(page.getPageable().getPageSize())
		.pageNumber(page.getPageable().getPageNumber())
		.totalPages(page.getTotalPages())
		.totalElements(page.getTotalElements())
		.totalOfElements(page.getNumberOfElements())
		.build();
		
	}

}
