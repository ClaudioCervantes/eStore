
package com.cervantes.claudio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Page<Product> findProductsByCategory(int idCategory, int typeSearch, Pageable pageable) {

		switch (typeSearch) {
		case 1:
			return iProductRepository.findByCategoryAlfabeticAsc(idCategory, pageable);
		case 2:
			return iProductRepository.findByCategoryAlfabeticDesc(idCategory, pageable);
		case 3:
			return iProductRepository.findByCategoryMajorPrice(idCategory, pageable);
		case 4:
			return iProductRepository.findByCategoryMinorPrice(idCategory, pageable);
		case 5:
			return iProductRepository.findByCategoryMajorDiscount(idCategory, pageable);
		case 6:
			return iProductRepository.findByCategoryMinorDiscount(idCategory, pageable);
		default:
			return iProductRepository.findByCategoryAlfabeticAsc(idCategory, pageable);
		}

	}

	@Override
	public Page<Product> findProductsByName(String name, Pageable pageable) {
		return iProductRepository.findByName("%" + name + "%", pageable);
	}

}
