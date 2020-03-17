package co.com.megacode.service;

import co.com.megacode.DTO.ImageDTO;

import java.util.List;

public interface ImageService {

    public List<ImageDTO> getImagePrincipalPageByIdApp(Long idApplication);

}
