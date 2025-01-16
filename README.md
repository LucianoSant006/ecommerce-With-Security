# DSCommerce

**DSCommerce** é um projeto de API RESTful desenvolvido em **Java** com o framework **Spring Boot**, seguindo boas práticas de design e implementação. O projeto utiliza um banco de dados H2 e foi desenvolvido como parte de um aprendizado intensivo sobre desenvolvimento back-end e controle de acesso.

---

## **Funcionalidades**

1. **Endpoints públicos**:
   - GET /products: Lista todos os produtos.
   - GET /products/{id}: Retorna detalhes de um produto específico.

2. **Autenticação e autorização**:
   - Autenticação implementada com **JWT** (JSON Web Token).
   - Controle de acesso baseado em perfis de usuário (USER/ADMIN).

3. **Gestão de produtos**:
   - Endpoints privados para criar, atualizar e deletar produtos. **Apenas administradores podem acessar**.

4. **Informações do usuário**:
   - GET /users/me: Retorna informações do usuário logado.

5. **Gestão de pedidos**:
   - POST /orders: Criação de pedidos.
   - GET /orders/{id}: Consulta de detalhes do pedido, acessível apenas para o proprietário ou administradores.

6. **Gestão de categorias**:
   - GET /categories: Lista todas as categorias. Endpoint público.

---

## **Detalhes de Implementação**

### **Pacote Principal**

O pacote principal da aplicação está localizado em com.devsuperior.dscommerce.services. Ele contém serviços essenciais para:
- Autenticação de usuários através de **JWT**.
- Controle de acesso com validação de permissões em nível de rota e regra de negócio.
- Operações para gestão de usuários e pedidos.

Exemplo do método authenticated na classe UserService:
````java
protected User authenticated() {
    try {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Jwt jwtPrincipal = (Jwt) authentication.getPrincipal();
        String username = jwtPrincipal.getClaim("username");
        return repository.findByEmail(username).get();
    } catch (Exception e) {
        throw new UsernameNotFoundException("User not found");
    }
}

````
### **JWT**
- JWT é utilizado para autenticar e autorizar os usuários, com tokens seguros que carregam as informações necessárias para validação do acesso.

---

## **Tecnologias Utilizadas**

- **Java 17**
- **Spring Boot**
  - Spring Data JPA
  - Spring Security (OAuth2, JWT)
- **Banco de dados H2**
- **Maven** como gerenciador de dependências

---

## **Como Executar**

1. **Clone o repositório**:
   
bash
   git clone https://github.com/seu-usuario/dscommerce.git


2. **Navegue até o diretório do projeto**:
   
bash
   cd dscommerce


3. **Execute o projeto**:
   
bash
   mvn spring-boot:run


4. **Acesse o H2 Console** (opcional para visualizar os dados):
   - URL: http://localhost:8080/h2-console
   - JDBC URL: jdbc:h2:mem:testdb
   - Usuário: sa
   - Senha: (em branco)

---

## **Testes**

- Utilize ferramentas como **Postman** ou **Insomnia** para testar os endpoints.
- Um arquivo de exemplo de requisições pode ser fornecido no futuro.

---

## **Contribuições**

Sinta-se à vontade para abrir issues ou pull requests para melhorias no projeto.

**Desenvolvedor**: Luciano Santiago  
[GitHub](https://github.com/LucianoSant006) | [LinkedIn](https://linkedin.com/in/seu-perfil)

---

**Nota**: Este projeto foi desenvolvido como parte de um aprendizado prático e busca por aprimorar habilidades em desenvolvimento back-end. Feedbacks são sempre bem-vindos!
