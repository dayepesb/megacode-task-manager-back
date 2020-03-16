package co.com.megacode.controller;

import co.com.megacode.entity.ImageEntity;
import co.com.megacode.service.ImageService;
import co.com.megacode.util.ParamsName;
import co.com.megacode.util.UrlName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = UrlName.URL_IMAGES)
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ImageController {

    @Autowired
    ImageService imageService;

    @RequestMapping(value = UrlName.URL_IMAGES_PRINCIPAL_PAGE ,method = {RequestMethod.GET} )
    public List<ImageEntity> getImagesPrincipalPage(@RequestParam(name = ParamsName.PARAM_ID_APP) Long idApplication){
        return imageService.getImagePrincipalPageByIdApp(idApplication);
    }
}
