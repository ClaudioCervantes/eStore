
package com.cervantes.claudio.utils;

import lombok.Getter;

/** 
* 
* @author Claudio Cervantes
* @version 1.0 2 may. 2021
* @since 1.0
*
*/

@Getter
public enum ErrorsEnum {

	OK(200, "OK"),
	NO_DATA_CATEGORY(201, "No se encontraron datos de categoria"),
	NO_DATA_PRODUCT(202, "No se encontraron datos de productos");
	
	private final int errorCode;
	private final String errorMessage;
	
	private ErrorsEnum(int errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
}
