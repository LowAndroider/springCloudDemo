package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.DeptDao;
import com.example.entities.Dept;
import com.example.service.DeptService;
import org.springframework.stereotype.Service;

/**
 * @author Djh
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptDao, Dept> implements DeptService {
}
