package service;

import dao.RecordDAO;
import entity.Category;
import entity.Record;
import gui.listener.RecoverListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecordService {
    RecordDAO recordDao = new RecordDAO();
    public void add(int spend, Category c, String comment, Date date){
        Record r = new Record();
        r.spend = spend;
        r.comment = comment;
        r.date = date;
        r.cid = c.id;
        recordDao.add(r);

    }

    public void delete(int id){
        recordDao.delete(id);
    }

    public void update(Record r){
        recordDao.update(r);
    }

    public List<Record> list(){
        List<Record> rs = new ArrayList<>();
        rs = recordDao.list();
        return rs;
    }



}
