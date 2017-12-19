package flying.service.sparrow.basic;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import flying.config.enums.ResponseSparrowMsgEnum;
import flying.entity.sparrow.SparrowUserMobile;
import flying.service.sparrow.dao.nozzle.SparrowUserMobileServiceI;
import flying.tool.ResponseTool;
import flying.tool.WarnMsgTool;
import flying.tool.model.ResponseModel;

@Repository
public class SpUserMobileService {

	@Autowired
	private SparrowUserMobileServiceI mobileService;

	/**
	 * Insert record
	 */
	public int insert(SparrowUserMobile record) {
		record.setCreatedAt(new Date());
		boolean insertRes = mobileService.insert(record);
		return insertRes ? record.getId() : 0;
	}

	/**
	 * Update record by id
	 */
	public int updateById(SparrowUserMobile record) {
		record.setUpdateAt(new Date());
		boolean updateRes = mobileService.updateById(record);
		return updateRes ? record.getId() : 0;
	}

	public boolean delete(int mobileId) {
		return mobileService.deleteById(mobileId);
	}

	/**
	 * Get mobile of user by mobile
	 */
	public SparrowUserMobile getUserMobileByMobile(String mobile) {
		return mobileService.selectOne(new EntityWrapper<SparrowUserMobile>().eq("mobile", mobile));
	}

	/**
	 * Get mobile by mobileId
	 */
	public SparrowUserMobile getUserMobileById(int mobileId) {
		return mobileService.selectById(mobileId);
	}
	
	/**
	 * Whether mobile exists
	 * @param mobile
	 * @return
	 */
	public ResponseModel existMobile(String mobile) {
		ResponseTool responseService = ResponseTool.getInstance();
		SparrowUserMobile userMobile = getUserMobileByMobile(mobile);
		if (userMobile != null) {
			responseService.successStatus();
		} else {
			responseService.setMessage(WarnMsgTool.getSparrowValue(ResponseSparrowMsgEnum.USER_MOBILE_NOEXIST.getValue()));
		}
		return responseService.combineResponse();
	}

}
