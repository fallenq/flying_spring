package flying.service.sparrow.dao.impl;

import flying.entity.sparrow.SparrowWorker;
import flying.mapper.sparrow.SparrowWorkerMapper;
import flying.service.sparrow.dao.nozzle.SparrowWorkerServiceI;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author Fallen
 * @since 2017-12-19
 */
@Service
public class SparrowWorkerServiceImpl extends ServiceImpl<SparrowWorkerMapper, SparrowWorker> implements SparrowWorkerServiceI {
	
}
