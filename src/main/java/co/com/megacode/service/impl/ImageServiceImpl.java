package co.com.megacode.service.impl;

import co.com.megacode.DTO.response.ImageResponseDTO;
import co.com.megacode.entity.ApplicationEntity;
import co.com.megacode.entity.ImageEntity;
import co.com.megacode.entity.TypeImageEntity;
import co.com.megacode.enumeration.ErrorMessagesEnum;
import co.com.megacode.enumeration.TypeImageEnum;
import co.com.megacode.exception.MegacodeException;
import co.com.megacode.repository.ImageRepository;
import co.com.megacode.repository.TypeImageRepository;
import co.com.megacode.service.BaseService;
import co.com.megacode.service.ImageService;
import co.com.megacode.util.AmazonS3ClientImage;
import co.com.megacode.util.ApplicationUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;

@Service
public class ImageServiceImpl extends BaseService implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private TypeImageRepository typeImageRepository;

    @Autowired
    private AmazonS3ClientImage amazonS3ClientImage;

    @Autowired
    private ApplicationUtil applicationUtil;

    @Autowired
    public ImageServiceImpl() {
        logger = LoggerFactory.getLogger(ImageServiceImpl.class);
    }

    public List<ImageResponseDTO> getImagePrincipalPageByIdApp(Long idApplication) {
        logger.debug("Get images principal page by app id "+idApplication);
        List<ImageEntity> images = imageRepository.findImagesPrincipalPageByApp(idApplication);
        logger.debug(images.size()+" images were found");
        List<ImageResponseDTO> imagesDto = new LinkedList<>();
        for (ImageEntity imageEntity : images) {
            ImageResponseDTO dto = new ImageResponseDTO();
            mapper.map(imageEntity, dto);
            imagesDto.add(dto);
        }
        return imagesDto;
    }

    public ImageResponseDTO uploadImageToS3Bucket(MultipartFile multipartFile, String title, String comment, Long type, boolean enablePublicReadAccess) throws MegacodeException {
        try {
            logger.debug("Upload image");
            String path = null;
            TypeImageEntity typeImageEntity = null;
            LoopTypeImageEnum:
            for (TypeImageEnum typeImageEnum: TypeImageEnum.values()) {
                if(typeImageEnum.getId()==type){
                    path = typeImageEnum.getPath();
                    typeImageEntity = typeImageRepository.findTypeImageByName(typeImageEnum.getNameType());
                    break LoopTypeImageEnum;
                }
            }
            if(path == null){
                throw new MegacodeException(ErrorMessagesEnum.INVALID_TYPE_IMAGE);
            }
            if(typeImageEntity == null){
                throw new MegacodeException(ErrorMessagesEnum.INVALID_TYPE_NAME);
            }

            logger.debug("Path file is : "+path);
            logger.debug("Type image is : "+typeImageEntity.getNameType());

            String pathFile = amazonS3ClientImage.saveImageS3Bucket(multipartFile,enablePublicReadAccess,path);

            logger.debug("Save Image in S3 bucket");

            ImageEntity imageEntity = new ImageEntity();

            ApplicationEntity app = applicationUtil.getApplication();

            imageEntity.setApplication(app);
            imageEntity.setPath(pathFile);
            imageEntity.setTitleImage(title);
            imageEntity.setCommentsImage(comment);
            imageEntity.setTypeImage(typeImageEntity);

            imageRepository.save(imageEntity);

            logger.debug("Save Image in database");

            ImageResponseDTO imageResponseDTO = new ImageResponseDTO();
            mapper.map(imageEntity, imageResponseDTO);

            return imageResponseDTO;
        } catch (IOException e) {
            logger.error(ErrorMessagesEnum.INTERNAL_ERROR.getMessage());
            throw new MegacodeException(ErrorMessagesEnum.INTERNAL_ERROR);
        } catch (NoSuchAlgorithmException e) {
            logger.error(ErrorMessagesEnum.CRYPTING_ERROR.getMessage());
            throw new MegacodeException(ErrorMessagesEnum.CRYPTING_ERROR);
        }catch (MegacodeException e){
            logger.error(e.getMessage());
            throw e;
        }

    }
}
