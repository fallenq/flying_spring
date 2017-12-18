package flying.tool;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import flying.tool.model.XmlModel;

public class XmlTool {
	
	public static Element getXmlRoot(String filePath) {
		String fileName = Thread.currentThread().getContextClassLoader().getResource(filePath).getPath();
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(new File(fileName));
			return document.getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static XmlModel parseXmlElement(Element element) {
		XmlModel model = new XmlModel();
		model.setName(element.getName());
		model.setValue(element.getStringValue());
		List<Attribute> attributes = element.attributes();
		for(Attribute attribute : attributes){
			model.setAttributeValue(attribute.getName(), attribute.getValue());
		}
		Iterator<Element> iterator = element.elementIterator();
		while (iterator.hasNext()) {
			Element childElement = iterator.next();
			model.addXmlModel(XmlTool.parseXmlElement(childElement));
		}
		if (model.getChildList().size() == 0) {
			model.setIsLeft(1);
		}
		return model;
	}
	
	public static XmlModel getXmlModelList(String filePath) {
		Element rootElement = XmlTool.getXmlRoot(filePath);
		if (rootElement != null) {
			return XmlTool.parseXmlElement(rootElement);
		}
		return null;
	}
	
}
