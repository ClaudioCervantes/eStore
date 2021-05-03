
package com.cervantes.claudio.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cervantes.claudio.entities.Product;

/** 
* 
* @author Claudio Cervantes
* @version 1.0 2 may. 2021
* @since 1.0
*
*/

public interface IProductService {

	public Page<Product> findProductsByCategory(int idCategory, int typeSearch, Pageable pageable);
	
	public Page<Product> findProductsByName(String name, Pageable pageable);
	
}
