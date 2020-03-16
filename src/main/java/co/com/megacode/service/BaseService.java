package co.com.megacode.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class BaseService {
    @Autowired
    DozerBeanMapper mapper;
}
