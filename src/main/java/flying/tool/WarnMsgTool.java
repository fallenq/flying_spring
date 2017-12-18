package flying.tool;

import java.util.Map;

import flying.tool.model.XmlModel;


public class WarnMsgTool {

	private static Map<Integer, String> commonMap = null;
	private static Map<Integer, String> sparrowMap = null;

	public static Map<Integer, String> putValue(Map<Integer, String> warnMap, int msgId, String value) {
		warnMap.put(msgId, value);
		return warnMap;
	}

	public static synchronized Map<Integer, String> getCommonMap() {
		if (commonMap == null) {
			commonMap = CommonTool.emptyIntMap();
			XmlModel root = XmlTool.getXmlModelList("config/service/warn-common-msg.xml");
			if (root != null && root.getChildList().size() > 0) {
				for (XmlModel model : root.getChildList()) {
					Map<String, String> attributes = model.getAttributes();
					commonMap.put(Integer.parseInt(attributes.get("id")), attributes.get("value"));
				}
			}
		}
		return commonMap;
	}

	public static synchronized Map<Integer, String> getSparrowMap() {
		if (sparrowMap == null) {
			sparrowMap = CommonTool.emptyIntMap();
			XmlModel root = XmlTool.getXmlModelList("config/service/warn-sparrow-msg.xml");
			if (root != null && root.getChildList().size() > 0) {
				for (XmlModel model : root.getChildList()) {
					Map<String, String> attributes = model.getAttributes();
					sparrowMap.put(Integer.parseInt(attributes.get("id")), attributes.get("value"));
				}
			}
		}
		return sparrowMap;
	}

	public static String getCommonValue(int msgId) {
		Map<Integer, String> messageMap = WarnMsgTool.getCommonMap();
		if (messageMap.containsKey(msgId)) {
			return messageMap.get(msgId);
		}
		return "";
	}

	public static String getSparrowValue(int msgId) {
		Map<Integer, String> messageMap = WarnMsgTool.getSparrowMap();
		if (messageMap.containsKey(msgId)) {
			return messageMap.get(msgId);
		}
		return "";
	}

}
