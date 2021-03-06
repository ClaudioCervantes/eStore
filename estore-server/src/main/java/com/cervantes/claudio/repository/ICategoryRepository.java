
package com.cervantes.claudio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cervantes.claudio.entities.Category;

/** 
* 
* @author Claudio Cervantes
* @version 1.0 2 may. 2021
* @since 1.0
*
*/

public interface ICategoryRepository extends JpaRepository<Category, Integer> {

}
