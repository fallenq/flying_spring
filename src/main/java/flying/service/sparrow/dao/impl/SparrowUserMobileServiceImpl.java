package flying.service.sparrow.dao.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import flying.entity.sparrow.SparrowUserMobile;
import flying.mapper.sparrow.SparrowUserMobileMapper;
import flying.service.sparrow.dao.nozzle.SparrowUserMobileServiceI;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户电话列表 服务实现类
 * </p>
 *
 * @author Fallen
 * @since 2017-09-21
 */
@Service
public class SparrowUserMobileServiceImpl extends ServiceImpl<SparrowUserMobileMapper, SparrowUserMobile> implements SparrowUserMobileServiceI {
}
