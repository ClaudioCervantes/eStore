
package com.cervantes.claudio.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.cervantes.claudio.controller.dto.ProductDto;
import com.cervantes.claudio.controller.dto.Request;
import com.cervantes.claudio.controller.dto.Response;
import com.cervantes.claudio.entities.Product;
import com.cervantes.claudio.service.IProductService;
import com.cervantes.claudio.utils.Constants;
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
public class ProductResource {

	@Autowired
	private IProductService iProductService;
	
	public ResponseEntity<Response<ProductDto>> findProducts(Request request, Pageable pageable) {
		
		log.info("INICIA PAGINACION DE PRODUCTOS POR CATEGORIA");
		
		Response<ProductDto> response;
		ProductDto productDto;
		List<String> listPath;
		Page<Product> pageProduct;
		StringBuilder path;
		
		pageProduct = iProductService.findProductsByCategoryAndName(request.getProductCategory(), request.getProductOrder(), request.getProductName(), pageable);
				
		if (pageProduct.getContent().isEmpty()) {
			log.info("NO SE ENCONTRARON PRODUCTOS PARA LA BUSQUEDA REALIZADA");
			response = new Response<ProductDto>();
			response.setErrorCode(ErrorsEnum.NO_DATA_PRODUCT.getErrorCode());
			response.setErrorMessage(ErrorsEnum.NO_DATA_PRODUCT.getErrorMessage());
			return new ResponseEntity<Response<ProductDto>>(response, HttpStatus.OK);
		}
		
		productDto = new ProductDto();
		
		listPath = new ArrayList<String>();
		for (int i = 0; i < pageProduct.getTotalPages(); i++) {
			
			path = new StringBuilder();
			path.append(Constants.PATH_PART_1);
			path.append(pageProduct.getSize());
			path.append(Constants.PATH_PART_2);
			path.append(i);
			listPath.add(path.toString());
		}
		
		productDto.setListPath(listPath);
		productDto.setListProduct(pageProduct.getContent());
		
		response = new Response<ProductDto>();
		response.setErrorCode(ErrorsEnum.OK.getErrorCode());
		response.setErrorMessage(ErrorsEnum.OK.getErrorMessage());
		response.setData(productDto);
		
		return new ResponseEntity<Response<ProductDto>>(response, HttpStatus.OK);

	}
	
}
