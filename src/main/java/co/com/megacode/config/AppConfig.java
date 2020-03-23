package co.com.megacode.config;


import co.com.megacode.util.AmazonS3ClientImage;
import co.com.megacode.util.ApplicationUtil;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class AppConfig {

    @Value("classpath:dozer/dozzer_mapping.xml")
    Resource resource;

    @Bean(name = "org.dozer.Mapper")
    public DozerBeanMapper dozerBeanMapper() throws IOException {
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        List<String> list = Arrays.asList(new String[]{
                resource.getFile()
                        .toURI().
                        toURL()
                        .toString()
        });
        dozerBeanMapper.setMappingFiles(list);
        return dozerBeanMapper;
    }

    @Bean(name="co.com.megacode.util.ApplicationUtil")
    public ApplicationUtil applicationUtil(){
        return new ApplicationUtil();
    }

}
