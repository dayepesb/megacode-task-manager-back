package co.com.megacode.controller;

import co.com.megacode.DTO.response.LabelResponseDTO;
import co.com.megacode.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static co.com.megacode.constant.UrlName.URL_LABELS;
import static co.com.megacode.constant.UrlName.URL_LABELS_BY_APP;
import static co.com.megacode.constant.ParamsName.PARAM_ID_APP;

@RestController
@RequestMapping(value = URL_LABELS)
public class LabelController extends BaseController {

    @Autowired
    private LabelService labelService;

    @RequestMapping(value = URL_LABELS_BY_APP,method = RequestMethod.GET)
    public List<LabelResponseDTO> getAllLabelsWithApp(@RequestParam(name = PARAM_ID_APP)Long idApp){
        List<LabelResponseDTO> labels = labelService.getAllLabelsApp(idApp);
        return labels;
    }

}
