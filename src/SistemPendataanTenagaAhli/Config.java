package SistemPendataanTenagaAhli;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class Config {
        
    private static final String URL = "jdbc:mysql://localhost:3306/PT_ViramaKarya";
    private static final String Driver = "com.mysql.jdbc.Driver";
    private static final String User = "root";
    private static final String Pass = "";

    static Connection Conn = null;
    static Statement Stmt = null;
    static ResultSet RS = null;
    static PreparedStatement PS = null;

    public static Connection getConnection() {
        try {
            Class.forName(Driver);
            try {
                Conn = DriverManager.getConnection(URL, User, Pass);
            } catch(SQLException e) {
                
            }  
        } catch(ClassNotFoundException e) {
            System.out.println(e);
        }
        return Conn;
    }
    
    private Object preparedStatement;
    
    public static ResultSet getData(String Query) {
        try {
            PS = (PreparedStatement) Conn.prepareStatement(Query);
            RS = PS.executeQuery();
            return RS;
        } catch(SQLException e) {
            return null;
        }
    }
    
    public static int updateData(String Query) {
        try {
            PS = (PreparedStatement) Conn.prepareStatement(Query);
            return PS.executeUpdate();
        } catch(SQLException e) {
            return 0;
        }
    }    
    
    public static void setTableColumn(JTable TableName, int Column, int Width[]) {
        for(int i = 0; i < Column; i++) {
            TableName.getColumnModel().getColumn(i).setPreferredWidth(Width[i]);
        }
    }
       
    public static void setTableDesign(JTable TableName, JScrollPane ScrollPaneName) {
        
        JTableHeader THeader = TableName.getTableHeader();
        
        THeader.setFont(new Font("Tahoma", Font.BOLD, 9));
        THeader.setPreferredSize(new Dimension(1500, 40));
        THeader.setOpaque(false);
        THeader.setBackground(Color.decode("#003399"));
        THeader.setForeground(Color.decode("#FFFFFF"));

        ((DefaultTableCellRenderer)TableName.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        TableName.setRowHeight(35);
        TableName.setGridColor(Color.decode("#CCCCCC"));
        TableName.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableName.setBackground(Color.decode("#FFFFFF"));
      
        ScrollPaneName.getViewport().setBackground(TableName.getBackground());
        ScrollPaneName.setBorder(null);
        //ScrollPaneName.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        
        TableName.setDefaultRenderer(Object.class, new TableCellRenderer() {
            private DefaultTableCellRenderer DEFAULT_RENDERER =  new DefaultTableCellRenderer();

                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    if(isSelected){
                        c.setBackground(Color.decode("#E8F0FE"));
                        c.setForeground(Color.decode("#000000"));
                    } else {
                    if(row%2 == 0){
                        c.setBackground(Color.decode("#FFFFFF"));

                    } else {
                        c.setBackground(Color.decode("#F5F5F5"));
                    }     
                }
                return c;
            } 
        });
        
        TableName.setGridColor(Color.decode("#F0F0F0"));
        TableName.setShowHorizontalLines(false);
    }
    
}