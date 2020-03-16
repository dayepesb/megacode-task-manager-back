package co.com.megacode.service;

import co.com.megacode.DTO.ImageDTO;
import co.com.megacode.entity.ImageEntity;
import co.com.megacode.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ImageService extends BaseService {

    @Autowired
    ImageRepository imageRepository;

    public List<ImageDTO> getImagePrincipalPageByIdApp(Long idApplication) {
        List<ImageEntity> images = imageRepository.findImagesPrincipalPageByApp(idApplication);
        List<ImageDTO> imagesDto = new LinkedList<>();
        for (ImageEntity imageEntity : images) {
            ImageDTO dto = new ImageDTO();
            mapper.map(imageEntity, dto);
            imagesDto.add(dto);
        }
        return imagesDto;
    }
}
