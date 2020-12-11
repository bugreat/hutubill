package startup;

import gui.frame.MainFrame;
import gui.panel.MainPanel;
import gui.panel.SpendPanel;
import util.GUIUtil;

import javax.swing.*;

public class Bootstrap {
    public static void main(String[] args) throws Exception{


        //使用SwingUtilities.invokeAndWait的方式启动图形界面
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                //显示主窗体，并让主面板下方的workingPanel显示消费一览Panel
                MainFrame.instance.setVisible(true);
                MainPanel.instance.workingPanel.show(SpendPanel.instance);
            }
        });
    }
}
