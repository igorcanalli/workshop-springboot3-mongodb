package com.canalli.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canalli.workshopmongo.domain.Post;
import com.canalli.workshopmongo.domain.User;
import com.canalli.workshopmongo.dto.UserDTO;
import com.canalli.workshopmongo.repository.PostRepository;
import com.canalli.workshopmongo.repository.UserRepository;
import com.canalli.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	public PostRepository repository;
	
	public List<Post> findAll(){
		return repository.findAll();
	}
	
	public Post findById(String id){
		Optional<Post> post = repository.findById(id);
		if(!post.isPresent()) {
			throw new ObjectNotFoundException("Objeto não encontrado.");
		}
		return post.get();
	}


}