package com.cg.CustomerRegistration.DAL;

import java.util.ArrayList;
import java.util.List;
import com.cg.CustomerRegistration.DTO.*;

public class StaticDb {
private static List<CustomerDTO> list=new ArrayList<CustomerDTO>();


public static List<CustomerDTO> getList() {
	return list;
}
public static void setList(List<CustomerDTO> list) {
	StaticDb.list = list;
}
static
{
	list.add(new CustomerDTO(1,"Sudhanshu",8222842456L,"Vishnu nagar","Sudhanshurajpal9741@gmail.coim"));
	list.add(new CustomerDTO(2,"Sahil",8222842457L,"Vishnu nagar","sahill9741@gmail.coim"));
	list.add(new CustomerDTO(3,"Deepanshu",8222842458L,"Vishnu nagar","deepanshu9741@gmail.coim"));
}

}
