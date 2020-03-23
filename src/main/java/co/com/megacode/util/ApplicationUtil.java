package co.com.megacode.util;

import co.com.megacode.entity.ApplicationEntity;
import co.com.megacode.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class ApplicationUtil {

    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    private ApplicationRepository applicationRepository;

    public ApplicationEntity getApplication () {
        ApplicationEntity applicationEntity = applicationRepository.findApplicationByName(applicationName);

        return applicationEntity;
    }
}
