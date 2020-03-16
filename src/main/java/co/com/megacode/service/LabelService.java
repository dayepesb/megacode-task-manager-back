package co.com.megacode.service;

import co.com.megacode.DTO.LabelDTO;
import co.com.megacode.entity.LabelEntity;
import co.com.megacode.repository.LabelRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LabelService extends BaseService{

    @Autowired
    LabelRepository labelRepository;

    public List<LabelDTO> getAllLabelsApp(Long idApp){

        List<LabelEntity> labels = labelRepository.findAllLabelsByIdApp(idApp);

        List<LabelDTO> dtosList = new ArrayList<>();
        for (LabelEntity labelEntity: labels) {
            LabelDTO dto = mapper.map(labelEntity ,LabelDTO.class);
            dtosList.add(dto);
        }
        return dtosList;
    }
}
