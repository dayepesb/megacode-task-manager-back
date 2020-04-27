package co.com.megacode.controller;

import co.com.megacode.DTO.response.ImageResponseDTO;
import co.com.megacode.service.impl.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static co.com.megacode.util.UrlName.URL_IMAGES;
import static co.com.megacode.util.UrlName.URL_IMAGES_PRINCIPAL_PAGE;
import static co.com.megacode.util.ParamsName.PARAM_ID_APP;

@RestController
@RequestMapping(value = URL_IMAGES)
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ImageController {

    @Autowired
    ImageServiceImpl imageServiceImpl;

    @RequestMapping(value = URL_IMAGES_PRINCIPAL_PAGE ,method = {RequestMethod.GET} )
    public List<ImageResponseDTO> getImagesPrincipalPage(@RequestParam(name = PARAM_ID_APP) Long idApplication){
        return imageServiceImpl.getImagePrincipalPageByIdApp(idApplication);
    }
}
