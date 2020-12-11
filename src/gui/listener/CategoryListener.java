package gui.listener;

import dao.CategoryDAO;
import entity.Category;
import gui.panel.CategoryPanel;
import gui.panel.InquiryPanel;
import gui.panel.MainPanel;
import gui.panel.RecordPanel;
import jdk.nashorn.internal.scripts.JO;
import service.CategoryService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;

public class CategoryListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        CategoryPanel p = CategoryPanel.instance;
        MainPanel mp = MainPanel.instance;
        CategoryDAO categoryDao = new CategoryDAO();

        JButton b = (JButton) e.getSource();
        if (b == p.bAdd) {
            String name = JOptionPane.showInputDialog(null);
            List<Category> categorys = categoryDao.list();
            for (Category c : categorys){
                if (name.equals(c.getName())){
                    JOptionPane.showMessageDialog(p, "分类名称不能重复");
                    return;
                }
            }
            if ( 0 ==name.length()){
                JOptionPane.showMessageDialog(p, "分类名称不能为空");
                return;
            }

            new CategoryService().add(name);
        }
        if (b == p.bEdit){
            Category c = p.getSelectedCategory();
            int id = c.id;
            String name = JOptionPane.showInputDialog("修改分类名称", c.name);
            if (0 == name.length()){
                JOptionPane.showMessageDialog(p, "分类名称不能为空");
                return;
            }

            new CategoryService().update(id, name);
        }

        if (b == p.bDelete) {
            Category c = p.getSelectedCategory();
            if (0 != c.recordNumber){
                JOptionPane.showMessageDialog(p, "本分类下有消费记录存在，不能删除");
                return;
            }
            if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(p, "确认要删除？"))
                return;
            int id = c.id;
            new CategoryService().delete(id);
        }

        if (b == p.bInquiry) {
            mp.workingPanel.show(InquiryPanel.instance);

        }
        p.updateData();
    }

}
