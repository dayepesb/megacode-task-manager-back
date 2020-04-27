package co.com.megacode.controller;

import co.com.megacode.DTO.response.LabelResponseDTO;
import co.com.megacode.service.impl.LabelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static co.com.megacode.util.UrlName.URL_LABELS;
import static co.com.megacode.util.UrlName.URL_LABELS_BY_APP;
import static co.com.megacode.util.ParamsName.PARAM_ID_APP;

@RestController
@RequestMapping(value = URL_LABELS)
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class LabelController {

    @Autowired
    private LabelServiceImpl labelServiceImpl;

    @RequestMapping(value = URL_LABELS_BY_APP,method = RequestMethod.GET)
    public List<LabelResponseDTO> getAllLabelsWithApp(@RequestParam(name = PARAM_ID_APP)Long idApp){
        List<LabelResponseDTO> labels = labelServiceImpl.getAllLabelsApp(idApp);
        return labels;
    }

}
