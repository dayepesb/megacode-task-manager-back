package co.com.megacode.service.impl;

import co.com.megacode.DTO.LabelDTO;
import co.com.megacode.entity.LabelEntity;
import co.com.megacode.repository.LabelRepository;
import co.com.megacode.service.BaseService;
import co.com.megacode.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LabelServiceImpl extends BaseService implements LabelService {

    @Autowired
    LabelRepository labelRepository;

    public List<LabelDTO> getAllLabelsApp(Long idApp){

        List<LabelEntity> labels = labelRepository.findAllLabelsByIdApp(idApp);

        List<LabelDTO> dtosList = new ArrayList<>();
        for (LabelEntity labelEntity: labels) {
            LabelDTO dto = new LabelDTO();
            mapper.map(labelEntity , dto);
            dtosList.add(dto);
        }
        return dtosList;
    }
}
