
package com.cervantes.claudio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cervantes.claudio.controller.dto.Response;
import com.cervantes.claudio.entities.Category;
import com.cervantes.claudio.resource.CategoryResource;

/** 
* 
* @author Claudio Cervantes
* @version 1.0 2 may. 2021
* @since 1.0
*
*/

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryResource categoryResource;

	@GetMapping("/v1/list")
	public ResponseEntity<Response<List<Category>>> listCategories() {
		return categoryResource.listCategories();
	}
	
}
