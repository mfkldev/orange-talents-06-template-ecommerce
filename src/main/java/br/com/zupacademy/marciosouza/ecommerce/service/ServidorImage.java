package br.com.zupacademy.marciosouza.ecommerce.service;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ServidorImage {

    public Set<String> push(List<MultipartFile> images) {
        return images.stream().map(image -> "http://bucket.io/"+image.getOriginalFilename()).collect(Collectors.toSet());
    }
}
