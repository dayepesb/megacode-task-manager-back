package co.com.megacode.controller;

import co.com.megacode.entity.LabelEntity;
import co.com.megacode.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/labels")
public class LabelController {

    @Autowired
    private LabelService labelService;

    @RequestMapping(value = "/app",method = RequestMethod.GET)
    public List<LabelEntity> getAllLabelsWithApp(@RequestParam(name = "app")String app){
        List labels = labelService.getAllLabelsApp(app);
        return labels;
    }

}
