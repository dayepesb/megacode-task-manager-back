package co.com.megacode.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {
    @Autowired
    public DozerBeanMapper mapper;

}
