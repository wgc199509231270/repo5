package com.OuSoft.system.dao.Troleinfo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.OuSoft.system.entity.Tbuttonsinfo;
import com.OuSoft.system.entity.Tmenuinfo;
import com.OuSoft.system.entity.Tmenurole;
import com.OuSoft.system.entity.Troleinfo;
import com.OuSoft.system.entity.Trolemenubutton;

@Mapper
@Component(value="troleinfo")
public interface TroleinfoDao {
	
	/**
	 * 给角色分配子菜单下的按钮：   roleid  角色id ，menuid	菜单id ，	buttonid	按钮id 
	 * 返回 ：信息 
	 */
	int insertTrolemenubuttonDao(Trolemenubutton trolemenubutton);
	
	/**
		查询角色下的主菜单   roleid 角色id       后台已处理处理条件 menuepid = 1zcd
		返回：menuname 菜单名称 	menuurl  差点地址菜单排序 	menutime 时间 	menuinfo  菜单描述 menuimage  菜单图表 	remark 备注
	 * @author pyl
	 * @date 2019年1月15日
	 */
	List<Tmenuinfo> queryByRoleidTrolemenubuttonDao(Tmenurole tmenurole);

	/**
	 * 查询角色下主菜单下的子菜单        roleid	角色id , menuid 主菜单id 
	 * 返回：
	 * menuname	菜单名称 
		menuurl	菜单子菜单路径
		menusort	序号排列
		menutime	创建时间
		menuinfo	按钮描述
		remark	备注信息
		menuimage	图标
		menutype	菜单端
		menupid	顶级公司id
	 * @author pyl
	 * @date 2019年1月15日
	 */
	List<Tmenuinfo> queryByMenuidTmenuinfoDao(Tmenurole tmenurole);
	
	/**
	 *  查询角色下子菜单下的按钮：
			 接：
			roleid  角色id
			menuid	菜单id
			返回：
			buttonname	按钮名称
			buttonmark	按钮标识
			buttontime	创建时间
			buttonimage	按钮图标
			buttonsort	按钮排序 
			buttontext	按钮说明 
			buttonpid	顶级公司id
	 * @author pyl
	 * @date 2019年1月15日
	 */
	List<Tbuttonsinfo> queryByTrolemenuTbuttonDao(Tmenurole tmenurole);
	
	/**
	 * 	删除给角色分配的按钮  
		roleid	角色id 	menuid	菜单id buttonid	按钮id 
		返回：信息  
	 * @author pyl
	 * @date 2019年1月15日
	 */
	int deleTrolemenubuttonDao(Trolemenubutton trolemenubutton);
	
	/**
	 * 	删除给角色分配的主菜单和子菜单 roleid	角色id ,menuid	菜单id 
		返回： 信息 
	 * @author pyl
	 * @date 2019年1月15日
	 */
	int deleTroleTmenuDao(Tmenurole tmenurole);
	
	/**
	 * 修改角色信息 
	rolename 角色名称
	remark 备注
	 */
	int updateByidTroleinfoDao(Troleinfo troleinfo);
	
	/**
	 * 给用户分配角色
	 userid用户id
	 roleid角色id
	 */
	 int insertByidTroleinfotuserDao(Troleinfo troleinfo);
	
	/**
	 * 给角色分配主菜单
	roleid 角色id
	menuid 主菜单id
	 */
	int insertByidTmenuinfoTuserDao(Troleinfo troleinfo);
	
	List<Troleinfo> queryPidTroleinfoDao(Troleinfo troleinfo);
	
	int saveTroleinfoDao(Troleinfo troleinfo);
	
	int deleByIdTroleinfoDao(Troleinfo troleinfo);
	

}
