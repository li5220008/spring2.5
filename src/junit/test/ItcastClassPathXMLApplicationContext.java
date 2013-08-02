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
 * ���ǲ��Ͱ��spring����ʵ����
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
	 * �����bean��ʵ����
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
	 * ��ȡ�����ļ�
	 * @param filename
	 */
	private void readXML(String filename) {
		SAXReader saxReader = new SAXReader();   
        Document document=null;   
        try{
         URL xmlpath = this.getClass().getClassLoader().getResource(filename);
         document = saxReader.read(xmlpath);
         Map<String,String> nsMap = new HashMap<String,String>();
         nsMap.put("ns","http://www.springframework.org/schema/beans");//���������ռ�
         XPath xsub = document.createXPath("//ns:beans/ns:bean");//����beans/bean��ѯ·��
         xsub.setNamespaceURIs(nsMap);//���������ռ�
         List<Element> beans = xsub.selectNodes(document);//��ȡ�ĵ�������bean�ڵ� 
         for(Element element: beans){
            String id = element.attributeValue("id");//��ȡid����ֵ
            String clazz = element.attributeValue("class"); //��ȡclass����ֵ        
            BeanDefinition beanDefine = new BeanDefinition(id, clazz);
            beanDefines.add(beanDefine);
         }   
        }catch(Exception e){   
            e.printStackTrace();
        }
	}
	
	/**
	 * ��ȡbeanʵ��
	 * @param beanName
	 * @return
	 */
	public Object getBean(String beanName){
		return this.sigletons.get(beanName);
	}
}
