package ptithcm.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ptithcm.entity.User;

@Transactional
@Controller
@RequestMapping("/user/")
public class UserController {

	@Autowired
	SessionFactory factory;
	@RequestMapping(value="index",params = "message", method=RequestMethod.GET)
	public String index(ModelMap model, @PathParam("message") String message) {
		Session session = factory.getCurrentSession();
		String hql = "FROM User";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		model.addAttribute("users", list);
		model.addAttribute("message",message);
		return "user/index";
	}

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert(ModelMap model) {
		model.addAttribute("user", new User());
		return "user/insert";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(ModelMap model, @ModelAttribute("user") User user) {
		Session session = this.factory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(user);
			transaction.commit();
			model.addAttribute("message", "Thêm mới thành công");
		} catch (Exception e) {
			transaction.rollback();
			model.addAttribute("message", "Thêm thất bại");
		} finally {
			session.close();
		}
		return "redirect:index.htm";
	}

//===============
    @RequestMapping(value = "update/{username}", method = RequestMethod.GET)
        public String update(ModelMap model, @PathVariable("username") String userId) {
            Session session = factory.getCurrentSession();
            User user = (User)session.get(User.class, userId);
            model.addAttribute("user", user);
            return "user/update";
        }
    
        @RequestMapping(value = "update/update",method = RequestMethod.POST)
        public String update(@ModelAttribute("user") User user, ModelMap model) {
            Session session = this.factory.openSession();
            Transaction t = session.beginTransaction();

            try {
                session.update(user);
                t.commit();
                model.addAttribute("message", "Cập nhật thành công!");
            } catch (Exception var9) {
                t.rollback();
                model.addAttribute("message", "Cập nhật thất bại!");
            } finally {
                session.close();
            }

            return "redirect:../index.htm";
        }
//===================

	@RequestMapping(value = "delete/{username}", method = RequestMethod.GET)
	public String delete(ModelMap model, @PathVariable("username") String userId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			User user = (User) session.get(User.class, userId);
			session.delete(user);
			transaction.commit();
			model.addAttribute("message", "Xóa thành công " + user.getUsername());
		} catch (Exception e) {
			transaction.rollback();
			model.addAttribute("message", "Xóa thất bại :(");
		} finally {
			session.close();
		}
		return "redirect:../index.htm";
	}

}
