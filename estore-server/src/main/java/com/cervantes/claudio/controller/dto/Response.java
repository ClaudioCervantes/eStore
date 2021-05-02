
package com.cervantes.claudio.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<D> {

	private int errorCode;
	private String errorMessage;
	private D data;
	
}
