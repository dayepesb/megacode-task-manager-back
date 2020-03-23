package co.com.megacode.controller;

import co.com.megacode.DTO.ImageDTO;
import co.com.megacode.exception.MegacodeException;
import co.com.megacode.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static co.com.megacode.util.ParamsName.*;
import static co.com.megacode.util.UrlName.URL_FILES;
import static co.com.megacode.util.UrlName.URL_SAVE_IMG_GENERAL;

@RestController
@RequestMapping(URL_FILES)
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class FileHandlerController {

    @Autowired
    private ImageService imageService;

    @PostMapping(value = URL_SAVE_IMG_GENERAL)
    public ImageDTO uploadImage(@RequestPart(value = PARAM_MULTIPART_FILE) MultipartFile file, @RequestParam(PARAM_TITLE)String title, @RequestParam(PARAM_COMMENTS)String comments, @RequestParam(PARAM_TYPE_IMAGE) Long typeImage) throws MegacodeException {

        return imageService.uploadImageToS3Bucket(file,title,comments,typeImage, true);
    }
}