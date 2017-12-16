package flying.service.sparrow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flying.entity.sparrow.SparrowTest;
import flying.service.sparrow.dao.impl.SparrowTestServiceImpl;
import flying.service.sparrow.dao.nozzle.SparrowTestServiceI;
import flying.service.sparrow.nozzle.SpTestServiceI;

@Service
public class SpTestImpl implements SpTestServiceI {

	@Autowired
	private SparrowTestServiceI testService;

	@Override
	public SparrowTest getById(int id) {
		return testService.selectById(id);
	}

}
