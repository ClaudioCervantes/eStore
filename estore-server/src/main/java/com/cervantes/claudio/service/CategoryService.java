
package com.cervantes.claudio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cervantes.claudio.entities.Category;
import com.cervantes.claudio.repository.ICategoryRepository;

/** 
* 
* @author Claudio Cervantes
* @version 1.0 2 may. 2021
* @since 1.0
*
*/

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private ICategoryRepository iCategoryRepository;
	
	@Override
	public List<Category> findAll() {
		return iCategoryRepository.findAll();
	}

}
