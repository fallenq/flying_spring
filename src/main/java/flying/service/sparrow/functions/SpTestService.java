package flying.service.sparrow.functions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import flying.entity.sparrow.SparrowTest;
import flying.service.sparrow.dao.nozzle.SparrowTestServiceI;

@Repository
public class SpTestService {

	@Autowired
	private SparrowTestServiceI testService;

	public SparrowTest getById(int id) {
		return testService.selectById(id);
	}

}
