package flying.service.sparrow.dao.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import flying.entity.sparrow.SparrowVersion;
import flying.mapper.sparrow.SparrowVersionMapper;
import flying.service.sparrow.dao.nozzle.SparrowVersionServiceI;


/**
 * <p>
 * 版本控制 服务实现类
 * </p>
 *
 * @author Fallen
 * @since 2017-09-21
 */
@Service
public class SparrowVersionServiceImpl extends ServiceImpl<SparrowVersionMapper, SparrowVersion> implements SparrowVersionServiceI {
	
}
