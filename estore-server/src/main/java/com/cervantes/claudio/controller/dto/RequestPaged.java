
package com.cervantes.claudio.controller.dto;

import lombok.Getter;
import lombok.Setter;

/** 
* 
* @author Claudio Cervantes
* @version 1.0 2 may. 2021
* @since 1.0
*
*/

@Getter
@Setter
public class RequestPaged {
	
	private int pageNumber;
	private int pageSize;
	private int orderedBy;
	private int productCategory;
	private String productName;

}
