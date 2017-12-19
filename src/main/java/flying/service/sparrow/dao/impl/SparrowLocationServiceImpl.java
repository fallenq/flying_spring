package flying.service.sparrow.dao.impl;

import flying.entity.sparrow.SparrowLocation;
import flying.mapper.sparrow.SparrowLocationMapper;
import flying.service.sparrow.dao.nozzle.SparrowLocationServiceI;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户定位 服务实现类
 * </p>
 *
 * @author Fallen
 * @since 2017-12-19
 */
@Service
public class SparrowLocationServiceImpl extends ServiceImpl<SparrowLocationMapper, SparrowLocation> implements SparrowLocationServiceI {
	
}
