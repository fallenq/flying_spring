package flying.service.sparrow.dao.impl;

import flying.entity.sparrow.SparrowUserSearchCount;
import flying.mapper.sparrow.SparrowUserSearchCountMapper;
import flying.service.sparrow.dao.nozzle.SparrowUserSearchCountServiceI;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户搜索统计 服务实现类
 * </p>
 *
 * @author Fallen
 * @since 2017-12-19
 */
@Service
public class SparrowUserSearchCountServiceImpl extends ServiceImpl<SparrowUserSearchCountMapper, SparrowUserSearchCount> implements SparrowUserSearchCountServiceI {
	
}
