package com.example.usuarioservice.feign;

import com.example.usuarioservice.model.Carro;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="carro-service",url="http://localhost:8082",path = "/carro")
public interface CarroFeignClient {
    @PostMapping()
    public Carro save(@RequestBody Carro carro);
}
