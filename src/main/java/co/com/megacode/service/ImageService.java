package co.com.megacode.service;

import co.com.megacode.DTO.ImageDTO;
import co.com.megacode.exception.MegacodeException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {

    List<ImageDTO> getImagePrincipalPageByIdApp(Long idApplication);

    ImageDTO uploadImageToS3Bucket(MultipartFile multipartFile, String title, String comment,Long type, boolean enablePublicReadAccess) throws MegacodeException;
}
