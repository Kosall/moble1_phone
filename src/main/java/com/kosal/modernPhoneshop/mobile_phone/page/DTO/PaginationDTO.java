package com.kosal.modernPhoneshop.mobile_phone.page.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaginationDTO {
	private int pageSize;
	private int pageNumber;
	private int totalPages;
	private long totalElements;
	private long totalOfElements;
	private boolean first;
	private boolean last;
	private boolean empty;

}
