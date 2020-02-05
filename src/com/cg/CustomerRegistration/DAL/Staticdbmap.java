package com.cg.CustomerRegistration.DAL;
import java.util.HashMap;

import com.cg.CustomerRegistration.DTO.*;

public class Staticdbmap {
private static HashMap<Integer,CustomerDTO> map=new HashMap<Integer,CustomerDTO>();

public static HashMap<Integer, CustomerDTO> getMap() {
	return map;
}

public static void setMap(HashMap<Integer, CustomerDTO> map) {
	Staticdbmap.map = map;
}
static
{
	map.put(1,new CustomerDTO(1,"Sudhanshu",8222842456L,"Vishnu nagar","Sudhanshurajpal9741@gmail.coim"));
	map.put(2,new CustomerDTO(2,"Sahil",8222842457L,"Vishnu nagar","sahill9741@gmail.coim"));
	map.put(3,new CustomerDTO(3,"Deepanshu",8222842458L,"Vishnu nagar","deepanshu9741@gmail.coim"));
}
}
