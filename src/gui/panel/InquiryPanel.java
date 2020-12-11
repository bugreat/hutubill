package gui.panel;

import entity.Category;
import entity.Record;
import gui.listener.InquiryListener;
import gui.model.InquiryTableModel;
import service.CategoryService;
import service.RecordService;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class InquiryPanel extends WorkingPanel{

    public static InquiryPanel instance = new InquiryPanel();

    String columNames[] = new String[]{"分类名称","消费金额","备注","日期"};

    public InquiryTableModel itm = new InquiryTableModel();
    public JTable t = new JTable(itm);
    public JButton bUpdate = new JButton("修改");
    public JButton bDelete = new JButton("删除");
    public JButton bReturn = new JButton("返回");


    public InquiryPanel() {
        GUIUtil.setColor(ColorUtil.blueColor, bUpdate, bDelete, bReturn);
        JScrollPane sp =new JScrollPane(t);
        JPanel pSubmit = new JPanel();
        pSubmit.add(bUpdate);
        pSubmit.add(bDelete);
        pSubmit.add(bReturn);
//        pSubmit.add(bAdd);
//        pSubmit.add(bEdit);
//        pSubmit.add(bInquiry);
//        pSubmit.add(bDelete);

        this.setLayout(new BorderLayout());
        this.add(sp,BorderLayout.CENTER);
        this.add(pSubmit,BorderLayout.SOUTH);
        addListener();
    }
    public Record getSelectedRecord() {
        int index = t.getSelectedRow();
        return itm.rs.get(index);
    }

    public int getSelectedType() {
        return t.getSelectedColumn();
    }


    public static void main(String[] args) {
        GUIUtil.showPanel(InquiryPanel.instance);
    }


    @Override
    public void addListener() {
        InquiryListener listener = new InquiryListener();
        bReturn.addActionListener(listener);
        bDelete.addActionListener(listener);
        bUpdate.addActionListener(listener);

    }

    @Override
    public void updateData() {
        itm.rs = new RecordService().list();
        itm.cs = new CategoryService().list();
        t.updateUI();
        t.getSelectionModel().setSelectionInterval(0, 0);

    }
}
