package cn.thychan.mtdm.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * Created by cn_cx on 2016/12/8.
 */


public class DownloadTableCellRenderer extends DefaultTableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
												   boolean isSelected, boolean hasFocus, int row, int column) {
		//判断是否需要显示图片
		if (value instanceof Icon) this.setIcon((Icon)value);
		else this.setText(value.toString());
		//判断是否选中
		if (isSelected) super.setBackground(table.getSelectionBackground());
		else setBackground(table.getBackground());
		//设置居中
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setToolTipText(value.toString());
		return this;
	}


}

