package flying.service.sparrow.dao.impl;

import flying.entity.sparrow.SparrowUserInfo;
import flying.mapper.sparrow.SparrowUserInfoMapper;
import flying.service.sparrow.dao.nozzle.SparrowUserInfoServiceI;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户统计信息 服务实现类
 * </p>
 *
 * @author Fallen
 * @since 2017-12-19
 */
@Service
public class SparrowUserInfoServiceImpl extends ServiceImpl<SparrowUserInfoMapper, SparrowUserInfo> implements SparrowUserInfoServiceI {
	
}
