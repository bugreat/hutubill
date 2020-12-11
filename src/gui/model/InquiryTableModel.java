package gui.model;

import entity.Category;
import entity.Record;
import service.CategoryService;
import service.RecordService;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class InquiryTableModel extends AbstractTableModel {

    String columnNames[] = new String[]{"序号","分类名称","消费金额","备注","日期"};

    public List<Record> rs = new RecordService().list();
    public List<Category> cs = new CategoryService().list();


    @Override
    public int getRowCount() {
        return rs.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int columnIndex) {

        return columnNames[columnIndex];
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Record r = rs.get(rowIndex);
        //Category c = cs.get(rowIndex);
        if (0 == columnIndex)
            return r.id;
        if (1 == columnIndex){
            for (Category c : cs){
                if (c.getId() == r.cid)
                    return c.getName();
                }
            }
        if (2 == columnIndex)
            return r.spend;

        if (3 == columnIndex)
            return r.comment;

        if (4 == columnIndex)
            return r.date;
        return null;
    }
}
