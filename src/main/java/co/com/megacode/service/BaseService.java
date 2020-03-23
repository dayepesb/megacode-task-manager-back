package co.com.megacode.service;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {

    public static Logger logger;

    @Autowired
    public DozerBeanMapper mapper;

}
