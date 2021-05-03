
package com.cervantes.claudio.controller.dto;

import java.util.List;

import com.cervantes.claudio.entities.Product;

import lombok.Setter;

import lombok.Getter;

/** 
* 
* @author Claudio Cervantes
* @version 1.0 2 may. 2021
* @since 1.0
*
*/

@Getter
@Setter
public class ProductDto {

	private List<String> listPath;
	private List<Product> listProduct;
	
}
