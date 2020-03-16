package co.com.megacode.service;

import co.com.megacode.entity.ImageEntity;
import co.com.megacode.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService{

    @Autowired
    ImageRepository imageRepository;

    public List<ImageEntity> getImagePrincipalPageByIdApp(Long idApplication) {
        return imageRepository.findImagesPrincipalPageByApp(idApplication);
    }
}
