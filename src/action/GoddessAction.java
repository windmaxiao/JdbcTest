package action;

import java.util.List;
import java.util.Map;

import dao.GoddessDao;
import model.Goddess;

public class GoddessAction {
	
	public void add(Goddess goddess) throws Exception{
		GoddessDao dao = new GoddessDao();
		goddess.setSex(1);
		goddess.setCreate_user("ADMIN");
		goddess.setUpdate_user("ADMIN");
		goddess.setIsdel(0);
		dao.addGoddess(goddess);
	}
	
	public void del(Integer id) throws Exception{
		GoddessDao dao = new GoddessDao();
		dao.delGoddess(id);
	}
	
	public void edit(Goddess goddess) throws Exception{
		GoddessDao dao = new GoddessDao();
		dao.updateGoddess(goddess);;
	}
	
	public Goddess get(Integer id) throws Exception{
		GoddessDao dao = new GoddessDao();
		return dao.get(id);
	}
	
	public List<Goddess> query() throws Exception{
		GoddessDao dao = new GoddessDao();
		return dao.query();
	}
	
	public List<Goddess> query(List<Map<String, Object>> params) throws Exception{
		GoddessDao dao = new GoddessDao();
		return dao.query(params);
	}
	
	/*public static void main(String[] args) throws Exception {
		
		GoddessDao g = new GoddessDao();
		
		List<Goddess> gs = g.query();
		
		for (Goddess goddess : gs) {
			System.out.println(goddess.getUser_name()+","+goddess.getAge());
		}
		
		List<Map<String, Object>> params = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name", "user_name");
		param.put("rela", "=");
		param.put("value", "'小美'");
		
		params.add(param);
		
		List<Goddess> result = g.query(params);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).toString());
		}
	
		
		
		String d = "1992-6-1";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(d);
		
		Goddess gd = new Goddess();
		gd.setId(1);
		gd.setUser_name("小夏");
		gd.setSex(1);
		gd.setAge(19);
		gd.setBirthday(date);
		gd.setEmail("123456@qq.com");
		gd.setMobile("13611111111");
		//gd.setCreate_user("admin");
		//gd.setUpdate_user("admin");
		gd.setUpdate_user("maxiao");
		gd.setUpdate_date(new Date());
		gd.setIsdel(1);
		
		Goddess g1 = g.get(2);
		System.out.println(g1.toString());
		//g.addGoddess(gd);
		//g.updateGoddess(gd);
		//g.delGoddess(1);
	
	}*/
}
