package com.microservice.oauth.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("servicio-usuarios")
public interface UsuarioFeignClient {

}
