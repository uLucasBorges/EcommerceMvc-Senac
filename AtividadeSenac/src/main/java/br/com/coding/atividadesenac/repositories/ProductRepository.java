
package br.com.coding.atividadesenac.repositories;

import br.com.coding.atividadesenac.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
