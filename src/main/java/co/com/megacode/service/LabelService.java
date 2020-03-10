package co.com.megacode.service;

import co.com.megacode.entity.LabelEntity;
import co.com.megacode.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedList;
import java.util.List;

@Service
public class LabelService {

    @Autowired
    LabelRepository labelRepository;

    public List<LabelEntity> getAllLabelsApp(String app){

        if (app==null || app.equals("")){
            return new LinkedList<>();
        }

        List<LabelEntity> labels = labelRepository.findAllLabelsByApp(app);
        return labels;
    }
}
