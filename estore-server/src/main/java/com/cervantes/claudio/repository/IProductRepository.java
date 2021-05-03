
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

	@Query("SELECT e FROM Product e WHERE ( e.category.id = :idcategory OR -1 = :idcategory ) AND UPPER(e.name) LIKE :name ORDER BY e.name ASC")
	public Page<Product> findByCategoryAndNameAlfabeticAsc(@Param("idcategory") Integer idcategory, @Param("name") String name, Pageable pageable);

	@Query("SELECT e FROM Product e WHERE ( e.category.id = :idcategory OR -1 = :idcategory ) AND UPPER(e.name) LIKE :name ORDER BY e.name DESC")
	public Page<Product> findByCategoryAndNameAlfabeticDesc(@Param("idcategory") Integer idcategory, @Param("name") String name, Pageable pageable);
	
	@Query("SELECT e FROM Product e WHERE ( e.category.id = :idcategory OR -1 = :idcategory ) AND UPPER(e.name) LIKE :name ORDER BY e.price DESC")
	public Page<Product> findByCategoryAndNameMajorPrice(@Param("idcategory") Integer idcategory, @Param("name") String name, Pageable pageable);
	
	@Query("SELECT e FROM Product e WHERE ( e.category.id = :idcategory OR -1 = :idcategory ) AND UPPER(e.name) LIKE :name ORDER BY e.price ASC")
	public Page<Product> findByCategoryAndNameMinorPrice(@Param("idcategory") Integer idcategory, @Param("name") String name, Pageable pageable);
	
	@Query("SELECT e FROM Product e WHERE ( e.category.id = :idcategory OR -1 = :idcategory ) AND UPPER(e.name) LIKE :name ORDER BY e.discount DESC")
	public Page<Product> findByCategoryAndNameMajorDiscount(@Param("idcategory") Integer idcategory, @Param("name") String name, Pageable pageable);
	
	@Query("SELECT e FROM Product e WHERE ( e.category.id = :idcategory OR -1 = :idcategory ) AND UPPER(e.name) LIKE :name ORDER BY e.discount ASC")
	public Page<Product> findByCategoryAndNameMinorDiscount(@Param("idcategory") Integer idcategory, @Param("name") String name, Pageable pageable);

}
