
package com.cervantes.claudio.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cervantes.claudio.service.IProductService;

/** 
* 
* @author Claudio Cervantes
* @version 1.0 2 may. 2021
* @since 1.0
*
*/

@Component
public class ProductResource {

	@Autowired
	private IProductService iProductService;
	
}
