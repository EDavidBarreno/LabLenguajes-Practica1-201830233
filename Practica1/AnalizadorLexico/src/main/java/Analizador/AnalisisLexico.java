package Analizador;

import javax.swing.table.AbstractTableModel;

public class AnalisisLexico extends AbstractTableModel {
    public String[] nombreColumna = {"TOKEN", "LEXEMA"};
    public Object[][] data;
    public AnalisisLexico(String[] tokens, String[] lexemas){
        data=new Object[tokens.length][2];
        for(int i=0; i<tokens.length; i++){
            data[i][0]=tokens[i];
            data[i][1]=lexemas[i];
        }
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return nombreColumna.length;
    }

    @Override
    public String getColumnName(int col) {
        return nombreColumna[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }
}
