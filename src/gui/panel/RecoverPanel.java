package gui.panel;

import javax.swing.JButton;
import javax.swing.JPanel;

import gui.listener.RecoverListener;
import util.ColorUtil;
import util.GUIUtil;

public class RecoverPanel extends WorkingPanel {

    public static RecoverPanel instance = new RecoverPanel();

    JButton bRecover =new JButton("恢复");

    public RecoverPanel() {

        GUIUtil.setColor(ColorUtil.blueColor, bRecover);
        this.add(bRecover);
        addListener();

    }

    public static void main(String[] args) {
        GUIUtil.showPanel(RecoverPanel.instance);
    }

    @Override
    public void addListener() {
        RecoverListener listener = new RecoverListener();
        bRecover.addActionListener(listener);
    }

    @Override
    public void updateData() {

    }
}