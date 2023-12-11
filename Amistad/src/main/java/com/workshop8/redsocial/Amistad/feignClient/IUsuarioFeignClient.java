package com.workshop8.redsocial.Amistad.feignClient;

import com.workshop8.redsocial.Amistad.entities.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuario", url = "http://localhost:8081/api/v1/usuario")
public interface IUsuarioFeignClient {

    @GetMapping("/usuario/{id}")
    Usuario getUsuarioById(@PathVariable("id") Long id);
}
