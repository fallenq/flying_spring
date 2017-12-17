package flying.tool.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import flying.tool.CommonTool;


public class XmlModel {
	
	private String name = "", value = "";
	private Map<String, String> attributes = null;
	private List<XmlModel> childList = null;
	private int isLeft = 0;

	public XmlModel() {
		attributes = CommonTool.emptyStringMap();
		childList = new ArrayList<XmlModel>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	public List<XmlModel> getChildList() {
		return childList;
	}

	public void setChildList(List<XmlModel> childList) {
		this.childList = childList;
	}
	
	public void setAttributeValue(String name, String value) {
		attributes.put(name, value);
	}
	
	public void addXmlModel(XmlModel model) {
		childList.add(model);
	}

	public int getIsLeft() {
		return isLeft;
	}

	public void setIsLeft(int isLeft) {
		this.isLeft = isLeft;
	}
}
