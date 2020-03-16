package co.com.megacode.config;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class AppConfig {

    @Value("classpath*:dozer/*.xml")
    List<Resource> resources = new LinkedList<>();

    @Bean(name = "org.dozer.Mapper")
    public DozerBeanMapper dozerBeanMapper(){
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        List<String> xmlString =
                resources.stream()
                        .map(t -> {
                            try {
                                return t.getFile().toURI().toURL().toString();
                            }
                            catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        })
                        .collect(Collectors.toList());
        dozerBeanMapper.setMappingFiles(xmlString);
        return dozerBeanMapper;
    }
}
