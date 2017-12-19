package flying.service.sparrow.basic;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import flying.entity.sparrow.SparrowUser;
import flying.service.sparrow.dao.nozzle.SparrowUserServiceI;
import flying.tool.CommonTool;
import flying.tool.EncodeTool;
import flying.tool.StringTool;

@Repository
public class SpUserService {

	@Autowired
	private SparrowUserServiceI userService;
	
	/**
	 * Insert user
	 */
	public int insert(SparrowUser sparrowUser) {
		sparrowUser.setCreatedAt(new Date());
		boolean insertRes = userService.insert(sparrowUser);
		return insertRes? sparrowUser.getId(): 0;
	}
	
	/**
	 * Edit user by Id
	 */
	public int updateById(SparrowUser sparrowUser) {
		sparrowUser.setUpdateAt(new Date());
		boolean updateRes = userService.updateById(sparrowUser);
		return updateRes? sparrowUser.getId(): 0;
	}
	
	/**
	 * Get user through userId
	 */
	public SparrowUser getUserById(int userId) {
		return userService.selectById(userId);
	}

	/**
	 * Get user through nickname
	 */
	public SparrowUser getUserByNickname(String nickname) {
		return userService.selectOne(new EntityWrapper<SparrowUser>().eq("nickName", nickname));
	}

	/**
	 * Get user through mobile
	 */
	public SparrowUser getUserByMobile(String mobile) {
		return userService.getSparrowUserByMobile(mobile);
	}

	/**
	 * Get user through information of user and type
	 */
	public SparrowUser getUserByParams(String refer, Integer type) {
		return getUserByInfo(refer, type);
	}
	
	public SparrowUser getUserByInfo(String refer, Integer type, String... args) {
		SparrowUser sparrowUser = null;
		switch (type) {
			case 1:
				sparrowUser = getUserByMobile(refer);
				break;
			case 2:
				sparrowUser = getUserByNickname(refer);
				break;
			default:
				sparrowUser = null;
		}
		return sparrowUser;
	}

	/**
	 * Compare user password
	 */
	public boolean compareUserLoginPwd(SparrowUser sparrowUser, String password) {
		return EncodeTool.match(password + sparrowUser.getSalt(), sparrowUser.getLoginPwd());
	}
	
	/**
	 * Combine user password set
	 * @param password
	 * @param salt
	 * @return
	 */
	private Map<String, Object> userPwdMap(String password, String salt) {
		Map<String, Object> passwordMap = CommonTool.emptyMap();
		passwordMap.put("salt", salt);
		passwordMap.put("key", password);
		passwordMap.put("password", EncodeTool.encrypt(password + salt));
		return passwordMap;
	}
	
	/**
	 * Create user password set
	 */
	public Map<String, Object> createUserPwd() {
		return this.userPwdMap(StringTool.uuCode(), StringTool.uuCode());
	}
	
	/**
	 * Create user password set
	 */
	public Map<String, Object> createUserPwd(String password) {
		return this.userPwdMap(password, StringTool.uuCode());
	}
	
	/**
	 * Create user password set
	 */
	public Map<String, Object> createUserPwd(SparrowUser sparrowUser, String password) {
		return this.userPwdMap(password, sparrowUser.getSalt());
	}
	
}
