package co.com.megacode.service;

import co.com.megacode.DTO.LabelDTO;
import java.util.List;

public interface LabelService {

    public List<LabelDTO> getAllLabelsApp(Long idApp);
}
