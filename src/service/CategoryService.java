package service;

import dao.CategoryDAO;
import dao.RecordDAO;
import entity.Category;
import entity.Record;

import java.util.Collections;
import java.util.List;

public class CategoryService {

    CategoryDAO categoryDao = new CategoryDAO();
    RecordDAO recordDao = new RecordDAO();

    public List<Category> list(){
        List<Category> categorys = categoryDao.list();
        for (Category c : categorys){
            List<Record> rs = recordDao.list(c.id);
            c.recordNumber = rs.size();

        }
        Collections.sort(categorys, (c1,c2)->c2.recordNumber-c1.recordNumber);

        return categorys;


    }

    public void add(String name){
        Category c = new Category();
        c.setName(name);
        categoryDao.add(c);
    }

    public void update(int id, String name){
        Category c = new Category();
        c.setName(name);
        c.setId(id);
        categoryDao.update(c);
    }

    public void delete(int id){
        categoryDao.delete(id);
    }
}
