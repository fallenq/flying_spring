package flying.service.sparrow.dao.impl;

import flying.entity.sparrow.SparrowUserDevice;
import flying.mapper.sparrow.SparrowUserDeviceMapper;
import flying.service.sparrow.dao.nozzle.SparrowUserDeviceServiceI;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户设备 服务实现类
 * </p>
 *
 * @author Fallen
 * @since 2017-12-19
 */
@Service
public class SparrowUserDeviceServiceImpl extends ServiceImpl<SparrowUserDeviceMapper, SparrowUserDevice> implements SparrowUserDeviceServiceI {
	
}
