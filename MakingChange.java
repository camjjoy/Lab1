//Lab One 9/4/24
import javax.swing.JFrame;

public class MakingChange
{
    public static void main(String[] args)
    {
        // Create JFrame(this was the easy part lol)

        JFrame frame = new JFrame("Making Change");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits on close

        // Create and add RegisterPanel
        RegisterPanel registerpanel = new RegisterPanel();
        frame.add(registerpanel);

        // Make frame visible
        frame.setVisible(true);
    }
}
