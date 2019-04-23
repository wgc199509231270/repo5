package com.OuSoft.system.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PortalPageController {

	   /**
	    * 图片页面
	    * @author pyl
	    * @date 2018年8月31日
	    */
	   @RequestMapping(value="/file")
	    public String fileUpload() {
	        return "fileUploads";
	    }

	   /**
	    * 登录页
	    * @author pyl
	    * @date 2018年8月31日
	    */
	   @RequestMapping(value="/OA2")
	    public String QueryUser1() {
	        return "login2";
	    }
	
	   /**
	    * 登陆后首页
	    * @author pyl
	    * @date 2018年8月31日
	    */
	    @RequestMapping(value="/index")
	    public String index() {
	        return "index";
	    }

        /**
         * 签到页面
         * @ Author     ：常宗涛
         * @ Date       ：Created in 19:24 2018/9/3
         * @ Description：
         * @ Modified By：
         * @Version:
         */
		@RequestMapping(value="/sign")
		public ModelAndView sign(String bs) {
            ModelAndView mv = new ModelAndView("sign/sign");
			System.out.println(bs);
            mv.addObject("bs",bs);
			return mv;
		}

		/**
		 * 签到详情页面
		 * @ Author     ：常宗涛
		 * @ Date       ：Created in 19:24 2018/9/3
		 * @ Description：
		 * @ Modified By：
		 * @Version:
		 */
		@RequestMapping(value="/sign/signMess")
		public String signMess() {
			return "sign/signMess";
		}

	    /**
         * 计划页面
	     * @ Author     ：常宗涛
	     * @ Date       ：Created in 19:24 2018/9/3
	     * @ Description：
	     * @ Modified By：
	     * @Version:
	     */
        @RequestMapping(value="/jihua")
        public String jihua() {
            return "plan/plan";
        }

		/**
		 * 计划详情页面
		 * @ Author     ：常宗涛
		 * @ Date       ：Created in 19:24 2018/9/3
		 * @ Description：
		 * @ Modified By：
		 * @Version:
		 */
		@RequestMapping(value="/plan/planMess")
		public String planMess() {
			return "plan/planMess";
		}

		/**
		 * 心情墙页面
		 * @ Author     ：常宗涛
		 * @ Date       ：Created in 19:24 2018/9/3
		 * @ Description：
		 * @ Modified By：
		 * @Version:
		 */
		@RequestMapping(value="/xinqingqiang")
		public String xinqingqiang() {
			return "mood/mood";
		}

		/**
		 * 心情详情页面
		 * @ Author     ：常宗涛
		 * @ Date       ：Created in 19:24 2018/9/3
		 * @ Description：
		 * @ Modified By：
		 * @Version:
		 */
		@RequestMapping(value="/mood/moodMess")
		public String moodMess() {
			return "mood/moodMess";
		}


	/**
		 * 问答区页面
		 * @ Author     ：常宗涛
		 * @ Date       ：Created in 19:24 2018/9/3
		 * @ Description：
		 * @ Modified By：
		 * @Version:
		 */
		@RequestMapping(value="/wendaqu")
		public String wendaqu() {
			return "interlocution/interlocution";
		}


		/**
		 * 问答详情页面
		 * @ Author     ：常宗涛
		 * @ Date       ：Created in 19:24 2018/9/3
		 * @ Description：
		 * @ Modified By：
		 * @Version:
		 */
		@RequestMapping(value="/interlocution/interlocutionMess")
		public String interlocutionMess() {
			return "interlocution/interlocutionMess";
		}

		/**
		 * 知识区页面
		 * @ Author     ：常宗涛
		 * @ Date       ：Created in 19:24 2018/9/3
		 * @ Description：
		 * @ Modified By：
		 * @Version:
		 */
		@RequestMapping(value="/zhishiqu")
		public String zhishiqu() {
			return "knowledge/knowledge";
		}


		/**
		 * 知识详情页面
		 * @ Author     ：常宗涛
		 * @ Date       ：Created in 19:24 2018/9/3
		 * @ Description：
		 * @ Modified By：
		 * @Version:
		 */
		@RequestMapping(value="/knowledge/knowledgeMess")
		public String knowledgeMess() {
			return "knowledge/knowledgeMess";
		}

		/**
		 * 今日总结页面
		 * @ Author     ：常宗涛
		 * @ Date       ：Created in 19:24 2018/9/3
		 * @ Description：
		 * @ Modified By：
		 * @Version:
		 */
		@RequestMapping(value="/jinrizongjie")
		public String jinrizongjie() {
			return "summarize/summarize";
		}

		/**
		 * 总结详情页面
		 * @ Author     ：常宗涛
		 * @ Date       ：Created in 19:24 2018/9/3
		 * @ Description：
		 * @ Modified By：
		 * @Version:
		 */
		@RequestMapping(value="/summarize/summarizeMess")
		public String summarizeMess() {
		return "summarize/summarizeMess";
	}

		/**
		 * 完成状况页面
		 * @ Author     ：常宗涛
		 * @ Date       ：Created in 19:24 2018/9/3
		 * @ Description：
		 * @ Modified By：
		 * @Version:
		 */
		@RequestMapping(value="/wanchengzhuangkuang")
		public String wanchengzhuangkuang() {
			return "status/status";
		}

		/**
		 * 完成状况详情页面
		 * @ Author     ：常宗涛
		 * @ Date       ：Created in 19:24 2018/9/3
		 * @ Description：
		 * @ Modified By：
		 * @Version:
		 */
		@RequestMapping(value="/status/statusMess")
		public String statusMess() {
		return "status/statusMess";
	}

		/**
		 * 签退页面
		 * @ Author     ：常宗涛
		 * @ Date       ：Created in 19:24 2018/9/3
		 * @ Description：
		 * @ Modified By：
		 * @Version:
		 */
		@RequestMapping(value="/qiantui")
		public String qiantui() {
			return "signout/signout";
		}

		/**
		 * 签退详情页面
		 * @ Author     ：常宗涛
		 * @ Date       ：Created in 19:24 2018/9/3
		 * @ Description：
		 * @ Modified By：
		 * @Version:
		 */
		@RequestMapping(value="/signout/signoutMess")
		public String signoutMess() {
			return "signout/signoutMess";
		}

		/**
		 * 工作圈首页
		 * @ Author     ：常宗涛
		 * @ Date       ：Created in 19:24 2018/9/3
		 * @ Description：
		 * @ Modified By：
		 * @Version:
		 */
	@RequestMapping(value="yeji")
	public String test() {
		return "yeji";
	}
	/**
	 * 业绩排名
	 * @ Author     ：王垚
	 */
	@RequestMapping(value="rank")
	public String rank() {
		return "achievement/rank";
	}
	/**
	 * 业绩详情
	 * @ Author     ：王垚
	 */
	@RequestMapping(value="rankMess")
	public String rankMess() {
		return "achievement/rankMess";
	}

	/**
	 * 业绩排名详情二
	 * @ Author     ：王垚
	 */
	@RequestMapping(value="rankMess2")
	public String rankMesstwo() {
		return "achievement/rankMess2";
	}
	/**
	 * 业绩管理
	 * @ Author     ：王垚
	 */
	@RequestMapping(value="manage")
	public String manage() {
		return "achievement/manage";
	}


	/**
	 * 业绩管理详情
	 * @ Author     ：王垚
	 */
	@RequestMapping(value="manageMess")
	public String manageMess() {
		return "achievement/manageMess";
	}
    /**
     * 请假管理
     * @ Author     ：王垚
     */
   @RequestMapping(value="timeOff")
    public String timeoff() {
        return "attendance/takeoff";
    }

    /**
     * 考勤管理
     * @ Author     ：王垚
     */
    @RequestMapping(value="checkOn")
    public String checkon() {
        return "attendance/checkon";
    }

    /**
	 * 发布业绩
	 * @ Author     ：王垚
	 */
	@RequestMapping(value="fbyj")
	public String fbyj() {
		return "achievement/fbyj";
	}


	/**
	 * 业绩分析
	 * @ Author     ：常宗涛
	 */
	@RequestMapping(value="parse")
	public String parse() {
		return "achievement/parse";
	}


	/**
	 * 业绩分析
	 * @ Author     ：常宗涛
	 */
	@RequestMapping(value="warning")
	public String parseMess() {
		return "achievement/warning";
	}

	/**
	 * 业绩提醒
	 * @ Author     ：常宗涛
	 */
	@RequestMapping(value="remark")
	public String remark() {
		return "achievement/remark";
	}

	/**
	 * 个人信息
	 * @ Author     ：马聪聪
	 */
	@RequestMapping(value="basicinformation")
	public String basicinformation() {
		return "personalmanagement/basicinformation";
	}

	/**
	 * 消息管理
	 * @ Author     ：马聪聪
	 */
	@RequestMapping(value="news")
	public String news() {
		return "achievement/news";
	}

    /**
     * 薪资规则
     *  * @ Author     ：曹浩
     * @return
     */
	@RequestMapping(value="compensationRule")
	public  String compensationRule(){
	    return "Remuneration/compensationRules";
    }


	/**
	 * 计划管理
	 * @ Author     ：崔志鹏
	 */
	@RequestMapping(value="planmanagement")
	public String planmanagement() {
		return "czpmanagement/planmanagement";
	}
	/**
	 * 计划管理详情
	 * @ Author     ：崔志鹏
	 */
	@RequestMapping(value="planmanagementMess")
	public String planmanagementMess() {
		return "czpmanagement/planmanagementMess";
	}

	/**
	 * 计划分析
	 * @ Author     ：崔志鹏
	 */
	@RequestMapping(value="Projectanalysis")
	public String Projectanalysis() {
		return "czpmanagement/Projectanalysis";
	}
/**
 * 计划动态
 * @ Author
 */
	@RequestMapping(value="planRules")
	public String planRules() {
		return "czpmanagement/planRules";
	}
	/**
	 * 调薪记录
	 * @ Author     ：曹浩
	 * @return
	 */
	@RequestMapping(value = "Payrecordhtml")
	public String Payrecordhtml(){
		return "Remuneration/Payrecord";
	}

	/**
	 * 考勤日历
	 * @return
	 */
	@RequestMapping(value = "calendar")
	public String calendar(){
		return "attendance/calendar";
	}
	/**
	 * 考勤小日历
	 * @return
	 */
	@RequestMapping(value = "calendar2")
	public String calendar2(){
		return "attendance/calendar2";
	}
	/**
	 * 薪资列表
	 *  @ Author     ：曹浩
	 * @return
	 */
	@RequestMapping(value = "salarylist")
	public String salarylist(){
		return "Remuneration/salarylist";
	}

	/**
	 * 调薪申请
	 * @return
	 */
	@RequestMapping(value = "wagea")
	public String wageAdjustment(){
		return "Remuneration/wageadjustment";
	}

	/**
	 * 员工列表
	 *  @ Author     ：曹浩
 	 * @return
	 */
	@RequestMapping(value = "satff")
	public String satff(){
		return "tatff/staff";
	}
	/**
	 * 新建员工
	 *  @ Author     ：曹浩
	 * @return
	 */
	@RequestMapping(value = "newsatff")
	public String newsatff(){
		return "tatff/newstaff";
	}
	/**
	 * 员工详情
	 *  @ Author     ：曹浩
	 * @return
	 */
	@RequestMapping(value = "staffMess")
	public String staffMess(){
		return "tatff/staffMess";
	}

	/**
	 * 合同列表
	 * @return
	 */
	@RequestMapping(value = "contract")
	public String contract(){return "tatff/contract";}

	/**
	 * 活动
	 * @return 马聪聪
	 */
	@RequestMapping(value = "activity")
	public String activity() {
		return "achievement/activity";
	}
	/**
	 * 风采
	 * @return 马聪聪
	 */
	@RequestMapping(value = "elegant")
	public String elegant() {
		return "achievement/elegant";
	}
	/**
	 * 风采详情
	 * @return 马聪聪
	 */
	@RequestMapping(value = "elegantMess")
	public String elegantMess() {
		return "achievement/elegantMess";
	}
	/**
	 * 活动详情
	 * @return
	 */
	@RequestMapping(value = "activityMess")
	public String activityMess() {
		return "achievement/activityMess";
	}

	/**
	 * 报名信息
	 * @return
	 */
	@RequestMapping(value = "activityRegMess")
	public String activityRegMess() {
		return "achievement/activityRegMess";
	}
	/**
	 * 说说页面
	 * @ Author     ：崔志鹏
	 */
	@RequestMapping(value="talk")
	public String talk() {
		return "czptalk/talk";
	}

	/**
	 * 说说详情页面
	 * @ Author     ：崔志鹏
	 */
	@RequestMapping(value="talkxq")
	public String talkxq() {
		return "czptalk/talkxq";
	}
	/**
	 * 账号管理页面
	 * @ Author     ：崔志鹏
	 */
	@RequestMapping(value="account")
	public String account() { return "administration/account"; }

	/**
	 * 角色管理页面
	 * @ Author     ：崔志鹏
	 */
	@RequestMapping(value="role")
	public String role() {
		return "administration/role";
	}
	/**
	 * 岗位管理页面
	 * @ Author     ：崔志鹏
	 */
	@RequestMapping(value="post")
	public String post() {
		return "administration/post";
	}
	/**
	 * 部门管理页面
	 * @ Author     ：崔志鹏
	 */
	@RequestMapping(value="department")
	public String department() {
		return "administration/department";
	}
	/**
	 * 公司管理页面
	 * @ Author     ：崔志鹏
	 */
	@RequestMapping(value="company")
	public String company() { return "administration/company";}

	@RequestMapping(value="conference")
	public String conference() { return "Conference/conference";}
}
