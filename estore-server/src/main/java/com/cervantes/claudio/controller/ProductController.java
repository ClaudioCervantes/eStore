
package com.cervantes.claudio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cervantes.claudio.resource.ProductResource;

/** 
* 
* @author Claudio Cervantes
* @version 1.0 2 may. 2021
* @since 1.0
*
*/

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductResource productResource;

}
