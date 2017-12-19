package flying.service.sparrow.functions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import flying.config.enums.ResponseCommonMsgEnum;
import flying.entity.sparrow.SparrowVersion;
import flying.service.sparrow.dao.nozzle.SparrowVersionServiceI;
import flying.tool.ResponseTool;
import flying.tool.StringTool;
import flying.tool.WarnMsgTool;
import flying.tool.model.ResponseModel;

@Repository
public class SpVersionService {

	@Autowired
	private SparrowVersionServiceI versionService;

	/**
	 * Get the lasted version by type
	 */
	public SparrowVersion getLastedVersion(int type) {
		SparrowVersion version = null;
		switch (type) {
		case 1:
			version = versionService.selectOne(new EntityWrapper<SparrowVersion>().orderBy("code DESC, update_at DESC"));
			break;
		case 2:
			break;
		}
		return version;
	}

	/**
	 * Compare version to know whether allow use
	 */
	public int compareVersion(SparrowVersion version, String code, Object... params) {
		if (version == null) {
			return -3;
		}
		if (version.getCode().equals(code)) {
			return 0;
		}
		if (version.getForceUpdate() > 0) {
			// Need force update
			return -2;
		}
		String[] codeList = StringTool.splitString(code, "\\.");
		String[] versionList = StringTool.splitString(version.getCode(), "\\.");
		int codeIndex = 0;
		for (; codeIndex < codeList.length; codeIndex++) {
			int compareCode = Integer.parseInt(codeList[codeIndex]);
			if (codeIndex + 1 <= versionList.length) {
				int compareVersion = Integer.parseInt(versionList[codeIndex]);
				if (compareVersion < compareCode) {
					return -1;
				} else if (compareVersion == compareCode) {
					continue;
				} else if (compareVersion > compareCode) {
					return 1;
				}
			}
		}
		if (codeIndex <= versionList.length) {
			return 1;
		}
		return -1;
	}

	/**
	 * Compare lastest version by type
	 */
	public ResponseModel compareLastVersion(int type, String code) {
		ResponseTool responseService = ResponseTool.getInstance();
		SparrowVersion version = getLastedVersion(type);
		int cmpStatus = compareVersion(version, code);
		if (cmpStatus == 0) {
			responseService.successStatus();
		} else if (cmpStatus == 1) {
			responseService.setMessage(WarnMsgTool.getCommonValue(ResponseCommonMsgEnum.DEVICE_NEED_UPDATE.getValue()));
			responseService.successStatus();
		} else {
			responseService.setMessage(WarnMsgTool.getCommonValue(ResponseCommonMsgEnum.DEVICE_NEED_UPDATE.getValue()));
		}
		if (cmpStatus != 0) {
			String url = "";
			if (version != null) {
				url = version.getUrl();
			}
			responseService.setDataValue("url", url);
		}
		return responseService.combineResponse();
	}

}
