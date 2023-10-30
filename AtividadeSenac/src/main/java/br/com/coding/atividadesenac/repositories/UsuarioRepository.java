
package br.com.coding.atividadesenac.repositories;

import br.com.coding.atividadesenac.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
     Usuario findByEmailAndSenha(String email, String senha);
}
