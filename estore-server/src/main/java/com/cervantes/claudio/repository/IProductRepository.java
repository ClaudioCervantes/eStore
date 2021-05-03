
package com.cervantes.claudio.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cervantes.claudio.entities.Product;

/** 
* 
* @author Claudio Cervantes
* @version 1.0 2 may. 2021
* @since 1.0
*
*/

public interface IProductRepository extends JpaRepository<Product, Integer> {

	@Query("SELECT e FROM Product e WHERE ( e.category.id = :idcategory OR -1 = :idcategory ) AND UPPER(e.name) LIKE :name")
	public Page<Product> findByCategoryAndName(@Param("idcategory") Integer idcategory, @Param("name") String name, Pageable pageable);

}
