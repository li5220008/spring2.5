package junit.test;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;


/**
 * 传智播客版的spring容器实例类
 * @author Administrator
 *
 */
public class ItcastClassPathXMLApplicationContext {
	private List<BeanDefinition> beanDefines = new ArrayList<BeanDefinition>();
	private Map<String,Object> sigletons = new HashMap<String, Object>(); 

	public ItcastClassPathXMLApplicationContext(String filename){
		this.readXML(filename);
		this.instanceBeans();
	}

	/**
	 * 完成了bean的实例化
	 */
	private void instanceBeans() {
		for(BeanDefinition beanDefine : beanDefines){
			try {
				if(beanDefine.getClassName() != null && !"".equals(beanDefine.getClassName().trim()))
				sigletons.put(beanDefine.getId(),Class.forName(beanDefine.getClassName()).newInstance());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 读取配置文件
	 * @param filename
	 */
	private void readXML(String filename) {
		SAXReader saxReader = new SAXReader();   
        Document document=null;   
        try{
         URL xmlpath = this.getClass().getClassLoader().getResource(filename);
         document = saxReader.read(xmlpath);
         Map<String,String> nsMap = new HashMap<String,String>();
         nsMap.put("ns","http://www.springframework.org/schema/beans");//加入命名空间
         XPath xsub = document.createXPath("//ns:beans/ns:bean");//创建beans/bean查询路径
         xsub.setNamespaceURIs(nsMap);//设置命名空间
         List<Element> beans = xsub.selectNodes(document);//获取文档下所有bean节点 
         for(Element element: beans){
            String id = element.attributeValue("id");//获取id属性值
            String clazz = element.attributeValue("class"); //获取class属性值        
            BeanDefinition beanDefine = new BeanDefinition(id, clazz);
            beanDefines.add(beanDefine);
         }   
        }catch(Exception e){   
            e.printStackTrace();
        }
	}

	/**
	 * 获取bean实例
	 * @param beanName
	 * @return
	 */
	public Object getBean(String beanName){
		return this.sigletons.get(beanName);
	}
}