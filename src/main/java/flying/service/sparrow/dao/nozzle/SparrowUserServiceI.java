package flying.service.sparrow.dao.nozzle;

import com.baomidou.mybatisplus.service.IService;

import flying.entity.sparrow.SparrowUser;

/**
 * <p>
 * 用户基本信息 服务类
 * </p>
 *
 * @author Fallen
 * @since 2017-09-10
 */
public interface SparrowUserServiceI extends IService<SparrowUser> {
	
	public SparrowUser getSparrowUserByMobile(String mobile);
	
}
