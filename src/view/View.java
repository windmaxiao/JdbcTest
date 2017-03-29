package view;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import action.GoddessAction;
import model.Goddess;

public class View
{

	private static final String CONTEXT = "欢迎来到女神禁区：\n" 
										+ "下面是女神禁区的功能列表：\n" 
										+ "[MAIN/M]:主菜单 \n"
										+ "[QUERY/Q]:查看女神的全部信息 \n" 
										+ "[GET/G]:查看某位女神的详细信息 \n" 
										+ "[ADD/A]:添加女神信息 \n" 
										+ "[UPDATE/U]:更新女神信息 \n"
										+ "[DELETE/D]:删除女神 \n" 
										+ "[SEARCH/S]:查询女神信息（根据姓名，手机号来查询） \n" 
										+ "[EXIT/E]:退出女神禁区 \n"
										+ "[BREAK/B]:退出当前功能，返回主菜单";

	private static final String OPERATION_MAIN = "MAIN";
	private static final String OPERATION_QUERY = "QUERY";
	private static final String OPERATION_GET = "GET";
	private static final String OPERATION_ADD = "ADD";
	private static final String OPERATION_UPDATE = "UPDATE";
	private static final String OPERATION_DELETE = "DELETE";
	private static final String OPERATION_SEARCH = "SEARCH";
	private static final String OPERATION_EXIT = "EXIT";
	private static final String OPERATION_BREAK = "BREAK";

	public static void main(String[] args)
	{

		System.out.println(CONTEXT);
		Scanner sc = new Scanner(System.in);

		Goddess goddess = new Goddess();
		GoddessAction action = new GoddessAction();
		String flags = null;
		Integer step = 1;
		while (true)
		{
			System.out.println("请选择：");
			String in = sc.next().toString();
			if (OPERATION_EXIT.equals(in.toUpperCase()) || OPERATION_EXIT.substring(0, 1).equals(in.toUpperCase()))
			{
				System.out.println("成功退出！");
				break;
			}
			else if (OPERATION_UPDATE.equals(in.toUpperCase())
					|| OPERATION_UPDATE.substring(0, 1).equals(in.toUpperCase()))
			{
				System.out.println("");
			}
			else if (OPERATION_DELETE.equals(in.toUpperCase())
					|| OPERATION_DELETE.substring(0, 1).equals(in.toUpperCase()))
			{
				System.out.println("输入要删除的ID：");
				try
				{
					action.del(sc.nextInt());
					System.out.println("删除成功");
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			else if (OPERATION_GET.equals(in.toUpperCase())
					|| OPERATION_GET.substring(0, 1).equals(in.toUpperCase()))
			{
				System.out.println("输入ID：");
				try
				{
					goddess = action.get(sc.nextInt());
					System.out.println(goddess.toString());
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			else if (OPERATION_QUERY.equals(in.toUpperCase())
					|| OPERATION_QUERY.substring(0, 1).equals(in.toUpperCase()))
			{
				try
				{
					List<Goddess> list = action.query();
					for (Goddess god : list)
					{
						System.out.println(god.getId() + " : " + god.getUser_name());
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			else if (OPERATION_ADD.equals(in.toUpperCase()) || OPERATION_ADD.substring(0, 1).equals(in.toUpperCase())
					|| OPERATION_ADD.equals(flags))
			{
				flags = OPERATION_ADD;
				if (1 == step)
				{
					System.out.println("输入姓名：");
				}
				else if (2 == step)
				{
					goddess.setUser_name(in);
					System.out.println("输入年龄：");
				}
				else if (3 == step)
				{
					goddess.setAge(Integer.valueOf(in));
					System.out.println("输入生日（yyyy-mm-dd）：");
				}
				else if (4 == step)
				{
					SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd");
					Date birthday;
					try
					{
						birthday = sf.parse(in);
						goddess.setBirthday(birthday);
						System.out.println("邮箱：");
					}
					catch (ParseException e)
					{
						e.printStackTrace();
						System.out.println("格式有误，重新输入");
						step = 3;
					}
				}
				else if (5 == step)
				{
					goddess.setEmail(in);
					System.out.println("手机号：");
				}
				else if (6 == step)
				{
					goddess.setMobile(in);
					try
					{
						action.add(goddess);
						System.out.println("添加成功");
					}
					catch (Exception e)
					{
						e.printStackTrace();
						System.out.println("添加失败");
					}
				}
				if (OPERATION_ADD.equals(flags))
				{
					step++;
				}
			}
		}
	}
}
