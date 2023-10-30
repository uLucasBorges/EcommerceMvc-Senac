package br.com.coding.atividadesenac.controllers;

import br.com.coding.atividadesenac.models.Usuario;
import br.com.coding.atividadesenac.models.Product;
import br.com.coding.atividadesenac.repositories.ProductRepository;
import br.com.coding.atividadesenac.repositories.UsuarioRepository;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController  extends HttpServlet  {

    @Autowired
    private ProductRepository productRepository;

     @Autowired
    private UsuarioRepository usuarioRepository;
    
    @GetMapping("/login")
      public String login(Model model) {
  
        // Passar os dados para a página HTML 
        // model.addAttribute("filmes", filme);
          

        return "index.html";
    }    
      
    @PostMapping("/loginAccount")
    public String loginAccount(HttpServletRequest request, Model model, HttpServletResponse response) throws ServletException, IOException, InterruptedException {
       

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

     
    
       Usuario usuario =  this.usuarioRepository.findByEmailAndSenha(email, senha);
       
     

       if(usuario != null){
           
         model.addAttribute("status", true);

         List<Product> products = this.productRepository.findAll();
        
        
        model.addAttribute("products", products);
         
        return "products.html";
        
       }  else {     
          model.addAttribute("status1", true);

       return "index.html";
       
       }
        
        
    } 
      
      
      @GetMapping("/products")
      public String products(Model model) {
  
        List<Product> products = this.productRepository.findAll();
        
        
        model.addAttribute("products", products);
        return "products.html";
    }   
      
      
     @GetMapping("/createproduct")
      public String createProduct(Model model) {
  
      return "createproduct.html";
    }   
      
      @PostMapping("/createProduct")
    public void createProduct(HttpServletRequest request, Model model) throws ServletException, IOException {
       
        
        // Obtenha os dados do formulário
        String nome = request.getParameter("nome");
        String categoria = request.getParameter("categoria");
        String descricao = request.getParameter("descricao");
        float preco = Float.parseFloat(request.getParameter("preco"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
    
        Product produto = new Product(0, nome,categoria,descricao,preco, quantidade);
        
        //inserir produto
                
         this.productRepository.save(produto);

        model.addAttribute("status", true);
        
    } 
      
      
     @PostMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") long id, Model model) {
       
        this.productRepository.deleteById(id);

        model.addAttribute("status", true);
        
        return "products.html";
    } 
    
    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro.html";  // renderiza o arquivo templates/home.html
    }  
      
       
    @PostMapping("/createAccount")
    public String createAccount(HttpServletRequest request, Model model) throws ServletException, IOException {
       
        
        // Obtenha os dados do formulário
        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");
        String confirmeSenha = request.getParameter("confirmeSenha");
        String email = request.getParameter("email");
        String logradouro = request.getParameter("logradouro");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");

        
        if(senha.equals(confirmeSenha)){
            Usuario usuario = new Usuario(nome,senha,email,logradouro,cidade,estado);
       
            this.usuarioRepository.save(usuario);
             
            model.addAttribute("stat", true);

                       return "index.html";

            
        } else{
            model.addAttribute("stat", true);

            
            return "cadastro.html";
        }
    }  
}
