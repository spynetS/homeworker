import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;

public class WarningDeleteWindow {
    private JButton canselButton;
    private JButton yesButton;
    private JPanel rootName;
    private JButton noButton1;
    JFrame frame = new JFrame();

    public void Start() {
        frame.setVisible(true);
    }

    public WarningDeleteWindow(String deleteName)
    {
        frame.add(rootName);
        frame.setSize(300,200);

canselButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
});

        noButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });

        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] name = deleteName.split(" ");
                File file = new File("Files/Vocabularys/"+name[0]+","+name[1]+","+name[2]);
                file.delete();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

            }
        });

    }

}
