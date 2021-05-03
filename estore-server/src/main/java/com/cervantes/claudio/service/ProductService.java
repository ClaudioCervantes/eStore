
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
	public Page<Product> findProductsByCategoryAndName(Integer idCategory, Integer typeSearch, String name, Pageable pageable) {

		switch (typeSearch) {
		case 1:
			System.out.println("ENTRO A 1");
			return iProductRepository.findByCategoryAndNameAlfabeticAsc(idCategory, "%" + name + "%", pageable);
		case 2:
			System.out.println("ENTRO A 2");
			return iProductRepository.findByCategoryAndNameAlfabeticDesc(idCategory, "%" + name + "%", pageable);
		case 3:
			System.out.println("ENTRO A 3");
			return iProductRepository.findByCategoryAndNameMajorPrice(idCategory, "%" + name + "%", pageable);
		case 4:
			System.out.println("ENTRO A 4");
			return iProductRepository.findByCategoryAndNameMinorPrice(idCategory, "%" + name + "%", pageable);
		case 5:
			System.out.println("ENTRO A 5");
			return iProductRepository.findByCategoryAndNameMajorDiscount(idCategory, "%" + name + "%", pageable);
		case 6:
			System.out.println("ENTRO A 6");
			return iProductRepository.findByCategoryAndNameMinorDiscount(idCategory, "%" + name + "%", pageable);
		default:
			System.out.println("ENTRO A DEFAULT");
			return iProductRepository.findByCategoryAndNameAlfabeticAsc(idCategory, "%" + name + "%", pageable);
		}

	}

}
