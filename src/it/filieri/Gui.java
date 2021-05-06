package it.filieri;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Gui {

    public Gui() {
        buildPanel();
    }

    //    Vector<String> element_list;
    JComboBox<String> list1;
    JComboBox<String> list2;
    JTextField txt1;
    JTextField txt2;
    JButton calcola;
    JButton reset;

    {
        Vector<String> element_list = new Vector<String>(0);
        element_list.add("K");
        element_list.add("F");
        element_list.add("C");

        list1 = new JComboBox<String>(element_list);
        list2 = new JComboBox<String>(element_list);


    }


    private void buildPanel() {
        JFrame frame = new JFrame();
        frame.setTitle("Convertitore");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setResizable(false);

        txt1 = new JTextField();
        txt1.setPreferredSize(new Dimension(150, 50));
        txt1.setEditable(true);
        txt1.setVisible(true);

        txt2 = new JTextField();
        txt2.setPreferredSize(new Dimension(150, 50));
        txt2.setEditable(false);
        txt2.setFocusable(false);
        txt2.setVisible(true);

        calcola = new JButton("Calcola");
        calcola.setFocusable(false);
        calcola.addActionListener(l -> {
            String strl = list1.getSelectedItem().toString().toLowerCase();
            String str2 = list2.getSelectedItem().toString().toLowerCase();
            double val = Double.parseDouble(txt1.getText());
            try {
                if (strl.equals("k") && str2.equals("f"))
                    txt2.setText(String.valueOf(Convertitore.k_to_f(val)));
                if (strl.equals("k") && str2.equals("c"))
                    txt2.setText(String.valueOf(Convertitore.k_to_c(val)));
                if (strl.equals("f") && str2.equals("k"))
                    txt2.setText(String.valueOf(Convertitore.f_to_k(val)));
                if (strl.equals("f") && str2.equals("c"))
                    txt2.setText(String.valueOf(Convertitore.f_to_c(val)));
                if (strl.equals("c") && str2.equals("f"))
                    txt2.setText(String.valueOf(Convertitore.c_to_f(val)));
                if (strl.equals("c") && str2.equals("k"))
                    txt2.setText(String.valueOf(Convertitore.c_to_k(val)));
                if (strl.equals(str2)) {
                    reset_fields();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        reset = new JButton("Reset");
        reset.setFocusable(false);
        reset.addActionListener(l -> {
            reset_fields();
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(list1);
        panel.add(txt1);
        panel.add(list2);
        panel.add(txt2);
        panel.add(calcola);
        panel.add(reset);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    private void reset_fields() {
        txt1.setText("");
        txt2.setText("");
        list1.setSelectedItem(0);
        list2.setSelectedItem(0);
    }
}