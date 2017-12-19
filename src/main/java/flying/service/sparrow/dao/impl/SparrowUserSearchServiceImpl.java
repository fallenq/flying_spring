package flying.service.sparrow.dao.impl;

import flying.entity.sparrow.SparrowUserSearch;
import flying.mapper.sparrow.SparrowUserSearchMapper;
import flying.service.sparrow.dao.nozzle.SparrowUserSearchServiceI;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 搜索记录 服务实现类
 * </p>
 *
 * @author Fallen
 * @since 2017-12-19
 */
@Service
public class SparrowUserSearchServiceImpl extends ServiceImpl<SparrowUserSearchMapper, SparrowUserSearch> implements SparrowUserSearchServiceI {
	
}
