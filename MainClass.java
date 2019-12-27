import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.io.*;
import java.util.Properties;

public class MainClass {
    public static void main(String[] args){
        Settings s = new Settings();
        try {
           // s.ReadSettings();
        } catch (Exception e) {
            e.printStackTrace();
        }
        gui gui = new gui();
        gui.setVisible(true);
    }
}
