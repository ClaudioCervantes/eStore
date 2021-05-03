
package com.cervantes.claudio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cervantes.claudio.entities.Product;
import com.cervantes.claudio.repository.IProductRepository;


/**
 * 
 * @author Claudio Cervantes
 * @version 1.0 2 may. 2021
 * @since 1.0
 *
 */

@Service
public class ProductService implements IProductService {

	@Autowired
	private IProductRepository iProductRepository;

	@Override
	public Page<Product> findProductsByCategoryAndName(Integer idCategory, Integer typeSearch, String name, Pageable pageable) {
		
		Pageable pageableSort;
		Sort sort = null;
		
		switch (typeSearch) {
		case 1:
			sort = Sort.by(Direction.ASC, "name");
			break;
		case 2:
			sort = Sort.by(Direction.DESC, "name");
			break;
		case 3:
			sort = Sort.by(Direction.DESC, "price");
			break;
		case 4:
			sort = Sort.by(Direction.ASC, "price");
			break;
		case 5:
			sort = Sort.by(Direction.DESC, "discount");
			break;
		case 6:
			sort = Sort.by(Direction.ASC, "discount");
			break;
		default:
			sort = Sort.by(Direction.ASC, "name");
			break;
		}
		
		pageableSort = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
		
		return iProductRepository.findByCategoryAndName(idCategory, "%" + name + "%", pageableSort);

	}

}
