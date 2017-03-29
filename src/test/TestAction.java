package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import action.GoddessAction;
import model.Goddess;

public class TestAction {

	public static void main(String[] args) throws Exception {
		GoddessAction ga = new GoddessAction();
		
		
		Goddess g = new Goddess();
		
		g.setUser_name("小晴2");
		g.setAge(18);
		g.setBirthday(new Date());
		g.setSex(1);
		g.setMobile("12345698756");
		g.setEmail("xiaoqing@163.com");
		g.setCreate_date(new Date());
		g.setCreate_user("admin");
		g.setIsdel(0);
		g.setUpdate_date(new Date());
		g.setUpdate_user("admin");
		g.setId(4);
		
		//ga.add(g);
		//ga.edit(g);
		//ga.del(3);
		
		List<Map<String, Object>> lms = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "user_name");
		map.put("rela", "=");
		map.put("value", "'小美'");
		
		lms.add(map);
		
		List<Goddess> gl = ga.query(lms);
		for (int i = 0; i < gl.size(); i++) {
			System.out.println(gl.get(i).getId() + ":" + gl.get(i).getUser_name());
		}
		
	}

}
