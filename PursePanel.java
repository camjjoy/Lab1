//Lab One 9/4/24
import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PursePanel extends JPanel
{
    private Purse purse = new Purse(); //saves the amt to display

    public void setPurse(Purse purse)
    {
        this.purse = purse;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g)//logic for displaying...this was the fun one :|
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int x = 10;
        int y = 10;
        final int imageWidth = 100;
        final int imageHeight = 50;

        //here is where I use getDenomination method

        // Check if the purse is empty
        if (purse.getDenominations().isEmpty())
        {
            g2d.drawString("Empty Purse", 10, 20);
            return;
        }

        for (Map.Entry<Register.Denomination, Integer> entry : purse.getDenominations().entrySet()) {
            Register.Denomination denom = entry.getKey();

            int count = entry.getValue();

            ImageIcon icon = new ImageIcon(getClass().getResource(denom.img()));
            Image img = icon.getImage();

            for (int i = 0; i < count; i++)
            {
                g2d.drawImage(img, x, y, imageWidth, imageHeight, this);
                x += imageWidth + 10;
                if (x > getWidth() - imageWidth)
                {
                    x = 10;
                    y += imageHeight + 10;
                }
            }
        }
    }
}