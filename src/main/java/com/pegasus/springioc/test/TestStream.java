package com.pegasus.springioc.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			//1.将propteris文件转化为一个map集体；
			 Map<String, String> collect = Files
			.lines(Paths
			.get("E:/0ZSET_SOURCES/SPRING_ARTICLE/SpringIoC2/src/main/resources/spring_ioc/user.properties"))
			.map(str -> str.split("="))
			.collect(Collectors.toMap(s -> s[0],s -> s[1]));
			
			 System.out.println(collect);
			 
			 for(Map.Entry<String, String> entry:collect.entrySet()) {
				 
				 System.out.println("key="+entry.getKey()+" and value="+entry.getValue());
			 }
			 
			 System.out.println("--------------------------------");
			 
			 //2根据key值取value值；
			 String key="email";
			 String value = Files
			 .lines(Paths
					 .get("E:/0ZSET_SOURCES/SPRING_ARTICLE/SpringIoC2/src/main/resources/spring_ioc/user.properties"))
			 .map(str -> str.split("="))
			 .collect(Collectors.toMap(s -> s[0], s -> s[1]))
			 .get(key);
			 
			 System.out.println(value);
			 System.out.println("--------------------------------");
			 String path = TestStream.class.getResource("/").toString();
			 System.out.println(path);
			 
			 String path2 = Thread.currentThread().getContextClassLoader().getResource("").getPath();
			 System.out.println(path2);
			
			 System.out.println("--------------------------------");
			 //index.do?id=0001&uuid=eijqrperjkepr&username=Photon
			 
			 String str="id=0001&uuid=eijqrperjkepr&username=Photon";
			 
			 Map<String, String> maps = Stream.of(str.split("&"))
			 .map(s -> s.split("="))
			 .collect(Collectors.toMap(s -> s[0], s -> s[1]));
			 
			 for(Map.Entry<String, String> entry:maps.entrySet()) {
				 
				 System.out.println("key="+entry.getKey()+"  value="+entry.getValue());
			 }
			 
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
