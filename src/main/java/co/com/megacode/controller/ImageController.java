package co.com.megacode.controller;

import co.com.megacode.DTO.ImageDTO;
import co.com.megacode.service.impl.ImageServiceImpl;
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
    ImageServiceImpl imageServiceImpl;

    @RequestMapping(value = UrlName.URL_IMAGES_PRINCIPAL_PAGE ,method = {RequestMethod.GET} )
    public List<ImageDTO> getImagesPrincipalPage(@RequestParam(name = ParamsName.PARAM_ID_APP) Long idApplication){
        return imageServiceImpl.getImagePrincipalPageByIdApp(idApplication);
    }
}
