
package com.cervantes.claudio.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.cervantes.claudio.controller.dto.Response;
import com.cervantes.claudio.entities.Category;
import com.cervantes.claudio.service.ICategoryService;
import com.cervantes.claudio.utils.ErrorsEnum;

import lombok.extern.slf4j.Slf4j;

/** 
* 
* @author Claudio Cervantes
* @version 1.0 2 may. 2021
* @since 1.0
*
*/

@Slf4j
@Component
public class CategoryResource {

	@Autowired
	private ICategoryService iCategoryService;
	
	public ResponseEntity<Response<List<Category>>> listCategories() {
		
		log.info("INICIA LISTADO DE CATEGORIAS");
		
		Response<List<Category>> response;
		List<Category> listCategory;
		
		listCategory = iCategoryService.findAll();
		
		if (listCategory.isEmpty()) {
			log.info("NO SE ENCONTRARON CATEGORIAS REGISTRADAS");
			response = new Response<List<Category>>();
			response.setErrorCode(ErrorsEnum.NO_DATA_CATEGORY.getErrorCode());
			response.setErrorMessage(ErrorsEnum.NO_DATA_CATEGORY.getErrorMessage());
			return new ResponseEntity<Response<List<Category>>>(response, HttpStatus.OK);
		}
		
		response = new Response<List<Category>>();
		response.setErrorCode(ErrorsEnum.NO_DATA_CATEGORY.getErrorCode());
		response.setErrorMessage(ErrorsEnum.NO_DATA_CATEGORY.getErrorMessage());
		response.setData(listCategory);
		
		return new ResponseEntity<Response<List<Category>>>(response, HttpStatus.OK);
		
	}
	
}
