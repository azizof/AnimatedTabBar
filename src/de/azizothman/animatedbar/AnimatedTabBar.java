package de.azizothman.animatedbar;

import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.GridLayout;

/**
 *
 * @author Aziz
 */
public class AnimatedTabBar {

    /**
     * The tabs on the bar
     */
    private final AnimatedTab[] tabs;

    /**
     * The tab buttons
     */
    private TabButton[] buttons;

    /**
     * This tab button is used as helper to change the style of the selected
     * Button
     */
    private TabButton selected = null;
    /**
     * the container which will content the Buttons and showen in the Form
     */
    private Container tabContainer;

    /**
     * The color of the tab text
     */
    private int fgColor = -1;
    /**
     * the Background color of the tab bar
     */
    private int bgColor = -1;

    int mm = Display.getInstance().convertToPixels(2);

    /**
     *
     * @param tabs
     */
    public AnimatedTabBar(AnimatedTab... tabs) {
        this.tabs = tabs;
        initGUI();
    }

    /**
     * Initialize the GUI of the Bar
     */
    private void initGUI() {
        //initialize the container 
        tabContainer = new Container(new GridLayout(tabs.length));
        // initialize the tab buttons array
        buttons = new TabButton[tabs.length];
        // create tabs and add them to the Container

        for (int i = 0; i < tabs.length; i++) {
            TabButton tabButton = new TabButton(tabs[i]);
            tabButton.addActionListener(l -> {
                tabButton.animate();
                setSelected(tabButton);
            });
            buttons[i] = tabButton;
            tabContainer.add(tabButton);
        }
        selected = buttons[0];
    }

    /**
     * bind the AnimatedTabBar to a given Form using the layered pane this will
     * make a transparency Container on the given Position of the Form
     *
     * @param top
     * @param form
     */
    public void bindToTheForm(boolean top, Form form) {
        checkStyle();
        BorderLayout layout = new BorderLayout();
        // special case for content pane installs the button directly on the content pane
        Container layers = form.getLayeredPane();
        layers.setLayout(layout);

        form.getContentPane().getAllStyles().setMarginBottom(Display.getInstance().convertToPixels(tabContainer.getHeight()));
        form.revalidate();
        if (top) {
            layers.add(BorderLayout.NORTH, tabContainer);
        } else {
            layers.add(BorderLayout.SOUTH, tabContainer);
        }
    }

    /**
     * Used as helper in the initGUI method
     *
     * @param tabButton
     */
    private void setSelected(TabButton tabButton) {
        selected.getAllStyles().setFgColor(0x0);
        selected.repaint();
        selected = tabButton;
        selected.getAllStyles().setFgColor(fgColor);
        selected.repaint();
        //selected.getComponentForm().revalidate();
    }

    /**
     * Set the text color of the selected button
     *
     * @param color
     */
    public void setSelectedButtonColor(int color) {
        this.fgColor = color;
    }

    /**
     * Set the background color of the tab bar
     *
     * @param color
     */
    public void setBarBGColor(int color) {
        this.bgColor = color;
    }

    /**
     * Set the tab bar should scroll on the X axis or not
     *
     * @param scrollable
     */
    public void setScrollable(boolean scrollable) {
        tabContainer.setScrollableX(scrollable);
    }

    /**
     * get the tab bar as Container
     *
     * @return
     */
    public Container buildContainer() {
        checkStyle();
        return tabContainer;
    }

    private void checkStyle() {
        if (fgColor != -1) {
            selected.getAllStyles().setFgColor(fgColor);
        }
        if (bgColor != -1) {
            tabContainer.getAllStyles().setBgColor(bgColor);
            tabContainer.getAllStyles().setBgTransparency(255);
        }
        tabContainer.getAllStyles().setPaddingBottom(mm);
        tabContainer.getAllStyles().setMargin(0, 0, mm, mm);
    }

}
