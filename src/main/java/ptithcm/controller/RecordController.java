package ptithcm.controller;

import java.util.Date;
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

import ptithcm.entity.Record;
import ptithcm.entity.Staff;

@Transactional
@Controller
@RequestMapping("/record/")
public class RecordController {
	@Autowired
	SessionFactory factory;
	@RequestMapping("index")
	public String index(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Record";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Record> list = query.list();
		model.addAttribute("records", list);
		return "record/index";
	}
	
	@RequestMapping(value="index", params = "message", method=RequestMethod.GET)
	public String index(ModelMap model, @PathParam("message") String message) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Record";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Record> list = query.list();
		model.addAttribute("records", list);
		model.addAttribute("message",message);
		return "record/index";
	}
	
	@RequestMapping(value="insert", method=RequestMethod.GET)
	public String insert(ModelMap model) {
		model.addAttribute("record", new Record());
		return "record/insert";
	}
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(ModelMap model, @ModelAttribute("record") Record record) {
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		try {
			record.setDate(new Date());
			session.save(record);
			transaction.commit();
			model.addAttribute("message","Thêm mới thành công!");
		}catch (Exception e) {
			transaction.rollback();
			model.addAttribute("message","Thêm mới thất bại!");
		}finally {
			session.close();
		}
		return "redirect:index.htm";
	}
	@ModelAttribute("staffs")
	public List<Staff> getStaffs(){
		Session session=factory.getCurrentSession();
		String hql="FROM Staff";
		Query query=session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Staff> list=query.list();
		return list;
	}
	
	//===============
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
        public String update(ModelMap model, @PathVariable("id") Integer iD) {
            Session session = factory.getCurrentSession();
            Record record = (Record)session.get(Record.class, iD);
            model.addAttribute("record", record);
            return "record/update";
        }
    
        @RequestMapping(value = "update/update",method = RequestMethod.POST)
        public String update(@ModelAttribute("record") Record record, ModelMap model) {
            Session session = factory.openSession();
            Transaction t = session.beginTransaction();

            try {
            	record.setDate(new Date());
            	System.out.println("rec: "+record.getDate());
                session.update(record);
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

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(ModelMap model, @PathVariable("id") Integer iD) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Record record = (Record) session.get(Record.class, iD);
			session.delete(record);
			transaction.commit();
			model.addAttribute("message", "Xóa thành công " + record.getStaff().getName());
		} catch (Exception e) {
			transaction.rollback();
			model.addAttribute("message", "Xóa thất bại");
		} finally {
			session.close();
		}
		return "redirect:../index.htm";
	}
}
