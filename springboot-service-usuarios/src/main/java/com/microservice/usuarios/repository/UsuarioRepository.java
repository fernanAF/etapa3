package com.microservice.usuarios.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.microservice.commons.users.entity.Usuario;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.repository.query.Param;

@RepositoryRestResource(path="usuarios")
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>{
	
	//select u from Usuario u where u.username = ?1
	@RestResource(path="buscar-username")
	public Usuario findByUsername(@Param(value="name")String username);
	
	//select u from Usuario u where u.username = ?1 and u.email = ?2
	public Usuario findByUsernameAndEmail(String username, String email);
	
	//Como no se tienen las palabras reservadas no se hacen de manera automatica se agrega @Query
	@Query(value="select u from Usuario u where u.username = ?1")
	public Usuario obtenerPorUsername(String username);
	
	@Query(value="select u from Usuario u where u.username = ?1 and u.email = ?2")
	public Usuario obtenerPorUsernameYEmail(String username, String Email);
	

}
