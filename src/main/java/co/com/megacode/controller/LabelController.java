package co.com.megacode.controller;

import co.com.megacode.DTO.LabelDTO;
import co.com.megacode.entity.LabelEntity;
import co.com.megacode.service.LabelService;
import co.com.megacode.util.ParamsName;
import co.com.megacode.util.UrlName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = UrlName.URL_LABELS)
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class LabelController {

    @Autowired
    private LabelService labelService;

    @RequestMapping(value = UrlName.URL_LABELS_BY_APP,method = RequestMethod.GET)
    public List<LabelDTO> getAllLabelsWithApp(@RequestParam(name = ParamsName.PARAM_ID_APP)Long idApp){
        List<LabelDTO> labels = labelService.getAllLabelsApp(idApp);
        return labels;
    }

}
