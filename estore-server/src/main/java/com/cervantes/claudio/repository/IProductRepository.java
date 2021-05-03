
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

	@Query("SELECT e FROM Product e WHERE ( e.category.id = :idcategory OR -1 = :idcategory ) ORDER BY e.name ASC")
	public Page<Product> findByCategoryAlfabeticAsc(@Param("idcategory") Integer idcategory, Pageable pageable);

	@Query("SELECT e FROM Product e WHERE ( e.category.id = :idcategory OR -1 = :idcategory ) ORDER BY e.name DESC")
	public Page<Product> findByCategoryAlfabeticDesc(@Param("idcategory") Integer idcategory, Pageable pageable);
	
	@Query("SELECT e FROM Product e WHERE ( e.category.id = :idcategory OR -1 = :idcategory ) ORDER BY e.price DESC")
	public Page<Product> findByCategoryMajorPrice(@Param("idcategory") Integer idcategory, Pageable pageable);
	
	@Query("SELECT e FROM Product e WHERE ( e.category.id = :idcategory OR -1 = :idcategory ) ORDER BY e.price ASC")
	public Page<Product> findByCategoryMinorPrice(@Param("idcategory") Integer idcategory, Pageable pageable);
	
	@Query("SELECT e FROM Product e WHERE ( e.category.id = :idcategory OR -1 = :idcategory ) ORDER BY e.discount DESC")
	public Page<Product> findByCategoryMajorDiscount(@Param("idcategory") Integer idcategory, Pageable pageable);
	
	@Query("SELECT e FROM Product e WHERE ( e.category.id = :idcategory OR -1 = :idcategory ) ORDER BY e.discount ASC")
	public Page<Product> findByCategoryMinorDiscount(@Param("idcategory") Integer idcategory, Pageable pageable);
	
	@Query("SELECT e FROM Product e WHERE UPPER(e.name) LIKE :name ORDER BY e.name ASC")
	public Page<Product> findByName(@Param("name") String name, Pageable pageable);

}
