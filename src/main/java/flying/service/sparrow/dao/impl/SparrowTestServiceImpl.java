package flying.service.sparrow.dao.impl;


import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import flying.entity.sparrow.SparrowTest;
import flying.mapper.sparrow.SparrowTestMapper;
import flying.service.sparrow.dao.nozzle.SparrowTestServiceI;


/**
 * <p>
 * 版本控制 服务实现类
 * </p>
 *
 * @author Fallen
 * @since 2017-09-21
 */
@Service
public class SparrowTestServiceImpl extends ServiceImpl<SparrowTestMapper, SparrowTest> implements SparrowTestServiceI {
}
