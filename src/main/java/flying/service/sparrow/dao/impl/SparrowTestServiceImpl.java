package flying.service.sparrow.dao.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import flying.entity.sparrow.SparrowTest;
import flying.mapper.sparrow.SparrowTestMapper;
import flying.service.sparrow.dao.nozzle.SparrowTestServiceI;

@Service
public class SparrowTestServiceImpl extends ServiceImpl<SparrowTestMapper, SparrowTest> implements SparrowTestServiceI {
	
}
