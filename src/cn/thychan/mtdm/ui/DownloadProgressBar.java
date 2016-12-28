package cn.thychan.mtdm.ui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * Created by cn_cx on 2016/12/8.
 */

public class DownloadProgressBar extends JProgressBar implements
		TableCellRenderer {
	public DownloadProgressBar() {
		super(0, 100);
		this.setStringPainted(true);
		this.setForeground(Color.green);
	}
	public Component getTableCellRendererComponent(JTable table, Object value,
												   boolean isSelected, boolean hasFocus, int row, int column) {
		Float floatValue = Float.parseFloat(value.toString());
		int intValue = (int)floatValue.floatValue();
		this.setValue(intValue);
		this.setString(value.toString() + " %");
		return this;
	}
}
