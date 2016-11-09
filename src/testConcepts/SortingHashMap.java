package testConcepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortingHashMap {

	Map<String,String> map1=new HashMap<String,String>();

	public SortingHashMap()
	{
		this.map1.put("str1", "str1");
		this.map1.put("str2", "str0");
		this.map1.put("str3", "str3");
		this.map1.put("str4", "str2");
		this.map1.put("Sample", String.valueOf(1));
	}

	public void printMap(Map<String,String> c)
	{
		for(Entry<String,String> entrySet:c.entrySet())
		{
			System.out.println(entrySet.getKey()+"-"+entrySet.getValue());
		}
	}
	public void sortMyHashMap()
	{
		List<String> valueList=new ArrayList<String>();
		for(Entry<String,String> entrySet:this.map1.entrySet())
		{
			valueList.add(entrySet.getValue());
		}
		Collections.sort(valueList,new MyComparator2());
		for(String str:valueList)
			System.out.println(str);
		//Based on keys
		SortedMap<String,String> treeMap=new TreeMap<String,String>(map1);
		printMap(treeMap);

		//Based on Values use a LinkedHashMap
		List<Entry<String,String>> listEntry=new ArrayList<Entry<String,String>>(map1.entrySet());
		Collections.sort(listEntry,new MyComparator());
		Map<String,String> linkedHM=new LinkedHashMap<String,String>();
		for(Entry<String,String> entry :listEntry)
		{
			linkedHM.put(entry.getKey(), entry.getValue());
		}
		map1=linkedHM;
		printMap(map1);
		printMap(linkedHM);
	}

	public static void main(String args[])
	{
		SortingHashMap obj1=new SortingHashMap();
		obj1.printMap(obj1.map1);
		obj1.sortMyHashMap();
	}
}
class MyComparator2 implements Comparator<String>
{

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o1.compareTo(o2);
	}

}
class MyComparator implements Comparator<Entry<String,String>>
{
	@Override
	public int compare(Entry<String, String> o1, Entry<String, String> o2) {
		// TODO Auto-generated method stub
		return o1.getValue().compareTo(o2.getValue());
	}
}