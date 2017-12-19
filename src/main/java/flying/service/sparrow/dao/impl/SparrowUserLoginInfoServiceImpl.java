package flying.service.sparrow.dao.impl;

import flying.entity.sparrow.SparrowUserLoginInfo;
import flying.mapper.sparrow.SparrowUserLoginInfoMapper;
import flying.service.sparrow.dao.nozzle.SparrowUserLoginInfoServiceI;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户登录信息 服务实现类
 * </p>
 *
 * @author Fallen
 * @since 2017-12-19
 */
@Service
public class SparrowUserLoginInfoServiceImpl extends ServiceImpl<SparrowUserLoginInfoMapper, SparrowUserLoginInfo> implements SparrowUserLoginInfoServiceI {
	
}
