
package com.cervantes.claudio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cervantes.claudio.controller.dto.ProductDto;
import com.cervantes.claudio.controller.dto.Request;
import com.cervantes.claudio.controller.dto.Response;
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

	@PostMapping("/v1/pagination")
	public ResponseEntity<Response<ProductDto>> findProducts(@RequestBody Request request, @PageableDefault(size = 6, page = 0) Pageable pageable) {
		return productResource.findProducts(request, pageable);
	}
	
}
