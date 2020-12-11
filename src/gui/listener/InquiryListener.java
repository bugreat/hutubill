package gui.listener;

import entity.Record;
import gui.panel.CategoryPanel;
import gui.panel.InquiryPanel;
import gui.panel.MainPanel;
import service.CategoryService;
import service.RecordService;
import util.DateUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InquiryListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        InquiryPanel p = InquiryPanel.instance;
        MainPanel mp = MainPanel.instance;
        JButton b = (JButton) e.getSource();

        if (b == p.bReturn)
            mp.workingPanel.show(CategoryPanel.instance);

        if (b == p.bDelete){
            Record r = p.getSelectedRecord();
            if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(p, "确认要删除？"))
                return;
            int id = r.id;
            new RecordService().delete(id);

        }

        if (b == p.bUpdate){
            Record r = p.getSelectedRecord();
            int type = p.getSelectedType();
            if (type == 2) {
                String spend = JOptionPane.showInputDialog("修改金额", r.spend);

                if (0 == spend.length()) {
                    JOptionPane.showMessageDialog(p, "金额不能为空");
                    return;
                }
                r.spend = Integer.parseInt(spend);
                new RecordService().update(r);
            }
            if (type == 3) {
                String comment = JOptionPane.showInputDialog("修改备注", r.comment);
                r.comment = comment;
                new RecordService().update(r);
            }

        }
        p.updateData();

    }
}
