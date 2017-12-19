package flying.service.sparrow.dao.impl;

import flying.entity.sparrow.SparrowUserOperation;
import flying.mapper.sparrow.SparrowUserOperationMapper;
import flying.service.sparrow.dao.nozzle.SparrowUserOperationServiceI;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户操作记录 服务实现类
 * </p>
 *
 * @author Fallen
 * @since 2017-12-19
 */
@Service
public class SparrowUserOperationServiceImpl extends ServiceImpl<SparrowUserOperationMapper, SparrowUserOperation> implements SparrowUserOperationServiceI {
	
}
