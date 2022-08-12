package com.example.usuarioservice.service;

import com.example.usuarioservice.entity.Usuario;
import com.example.usuarioservice.feign.CarroFeignClient;
import com.example.usuarioservice.feign.MotoFeignClient;
import com.example.usuarioservice.model.Carro;
import com.example.usuarioservice.model.Moto;
import com.example.usuarioservice.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final RestTemplate restTemplate;
    private final CarroFeignClient carroFeignClient;

    private final MotoFeignClient motoFeignClient;

    public Carro saveCarro(int usuarioId, Carro carro){
        carro.setUsuarioId(usuarioId);
        Carro nuevoCarro= carroFeignClient.save(carro);
        return nuevoCarro;
    }
    public List<Carro> getCarros(int usuarioId){
        List<Carro> carros= restTemplate.getForObject("http://localhost:8082/carro/usuario/"+usuarioId,List.class);
        return carros;
    }

    public List<Moto> getMotos(int usuarioId){
        List<Moto> motos= restTemplate.getForObject("http://localhost:8083/moto/usuario/"+usuarioId,List.class);
        return motos;
    }

    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(int id){
        return  usuarioRepository.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario){
        Usuario usuario1= usuarioRepository.save(usuario);
        return usuario1;

    }

    public Moto saveMoto(int usuarioId, Moto moto){
        moto.setUsuarioId(usuarioId);
        Moto nuevaMoto= motoFeignClient.save(moto);
        return nuevaMoto;
    }

    public Map<String,Object> getUsuarioAndVehiculos(int usuarioId){
        Map<String,Object> resultado = new HashMap<>();
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
        if(usuario==null){
            resultado.put("Mensaje","El usuario no existe");
            return resultado;
        }

        resultado.put("Usuario",usuario);
        List<Carro> carros=carroFeignClient.getCarros(usuarioId);
        if(carros.isEmpty()){
            resultado.put("Carros","El usuario no tiene carross");
        }else{
            resultado.put("Carros",carros);
        }

        List<Moto> motos = motoFeignClient.getMotos(usuarioId);
        if(motos.isEmpty()){
            resultado.put("Motos","El usuario no tiene motos");
        }else{
            resultado.put("Motos",motos);
        }
        return resultado;

    }
}
