package flying.mapper.sparrow;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import flying.entity.sparrow.SparrowUser;

/**
 * <p>
  * 用户基本信息 Mapper 接口
 * </p>
 *
 * @author Fallen
 * @since 2017-09-10
 */
public interface SparrowUserMapper extends BaseMapper<SparrowUser> {


	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sparrow_user
	 * @mbg.generated  Sat Sep 02 11:40:28 CST 2017
	 */
	SparrowUser selectByMobile(@Param("mobile")String mobile, @Param("method")Integer method);
}