package co.com.megacode.service;

import co.com.megacode.DTO.response.LabelResponseDTO;
import java.util.List;

public interface LabelService {

    public List<LabelResponseDTO> getAllLabelsApp(Long idApp);
}
