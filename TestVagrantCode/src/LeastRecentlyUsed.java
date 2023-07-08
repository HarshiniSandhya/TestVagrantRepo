import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LeastRecentlyUsed {
Deque<String> q=new LinkedList<String>();
Map<String,HashMapCache> map=new HashMap<String,HashMapCache>();
int capacity=3;

public String getElementFromCache(String key) {
	if(map.containsKey(key))
	{
		HashMapCache current=map.get(key);
		q.remove(key);
		q.addFirst(key);
		System.out.print("song played is"+" "+key+" "+"by");
		return current.value;
	}
	return "song"+" "+key+" does not exsist";
}
public void PutElementtoCache(String key,String value)
{
	if(map.containsKey(key))
	{
		HashMapCache current=map.get(key);
		q.remove(current.key);
	}
	else
	{
		if(q.size()==capacity)
		{
			String temp=q.removeLast();
			map.remove(temp);
			
		}
	}
	HashMapCache newItem=new HashMapCache(key, value);
	q.addFirst(newItem.key);
	map.put(key,newItem);
}
public static void main(String[] args) {
		LeastRecentlyUsed cache=new LeastRecentlyUsed();
		cache.PutElementtoCache("s1"," user");
		cache.PutElementtoCache("s2"," user");
		cache.PutElementtoCache("s3"," user");
		cache.PutElementtoCache("s4"," user");
		System.out.println(cache.getElementFromCache("s4"));
		System.out.println(cache.getElementFromCache("s2"));
		cache.PutElementtoCache("s1"," user");
		System.out.println(cache.getElementFromCache("s1"));
		System.out.println(cache.getElementFromCache("s3"));
		

	}

}
